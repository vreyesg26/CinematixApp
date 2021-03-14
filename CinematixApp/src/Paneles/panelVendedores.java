/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Datos.Conexion;
import JFrames.TextPrompt;
import Logica.datos;
import Tipografia.DecoracionTablas;
import Tipografia.Fuente;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Reyes
 */
public class panelVendedores extends javax.swing.JPanel {

    /**
     * Creates new form panelVendedores
     */
    
    public boolean email(String correo){
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        m = p.matcher(correo);

        if(m.find()){
     return true;
        }else{
            return false;
        }
    }
    
    
     
    void bloquear(){
        txtidvendedor1.setEnabled(false);
        cbojornada.setEnabled(false);
        txtcelular1.setEnabled(false);
        txtcelular2.setEnabled(false);
        txtcorreo.setEnabled(false);  
        txtdocumento.setEnabled(false); 
        txtnombre.setEnabled(false);  
        txtsueldo.setEnabled(false);  
        txtdireccion1.setEnabled(false);  
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        cbodocu.setEnabled(false);
    }
    
    void limpiarCajas(){
        txtidvendedor1.setText("");
        txtcelular1.setText("");
        txtcorreo.setText("");
        txtdireccion1.setText("");
        txtnombre.setText("");
        txtsueldo.setText("");
        txtdocumento.setText("");
        txtcelular2.setText("");
        cbodocu.setSelectedIndex(0);
        cbojornada.setSelectedIndex(0);
    }
    
    public void numeroshol(){
          
    }
    
    public void validarCaracteres(java.awt.event.KeyEvent e) {
        if (e.getKeyChar() >= 33 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 64
                || e.getKeyChar() >= 91 && e.getKeyChar() <= 96
                || e.getKeyChar() >= 123 && e.getKeyChar() <= 208
                || e.getKeyChar() >= 210 && e.getKeyChar() <= 240
                || e.getKeyChar() >= 242 && e.getKeyChar() <= 255) {
            
            e.consume();
            JOptionPane.showMessageDialog(null, "Este campo no acepta caracteres especiales");
        }
    }
    
    public static boolean validarNumeros(String datos){
        return datos.matches("[0-9]");
    }
    
    public static boolean validarStrings(String datos){
        return datos.matches("[a-zA-Z]");
    }
    Fuente tipoFuente;
    public panelVendedores() {
        initComponents();
        bloquear();
        cargarData("");
        
        tipoFuente = new Fuente();
        txtnombre.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtcelular2.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtsueldo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtbuscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtidvendedor1.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtcorreo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbojornada.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        cbodocu.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        L1.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        L2.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        L3.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        L4.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        L5.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        L6.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        
        tablaVendedores.getColumnModel().getColumn(0).setHeaderRenderer(new DecoracionTablas(Color.GRAY,Color.GRAY));
        
    }
    
    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();
    
    void cargarData(String valor){
        String[] titulos = {"IDVendedor", "Nombre", "Direccion", "Sueldo", "Jornada", "Celular", "Documento", "Correo"};
        String[] registros = new String[8];
        String sql = "SELECT IDVendedor, Nombre, Direccion, Sueldo, TipoJornada, NumeroCelular, NombreDocumento, Correo\n"
                + "                FROM vendedor INNER JOIN jornadas USING (IDJornada)\n"
                + "                INNER JOIN tipodocumento USING (IDTipoDocumento)\n"
                + "                WHERE IDVendedor != 0 ORDER BY IDVendedor";
        
        
        model = new DefaultTableModel(null, titulos);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("IDVendedor");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Direccion");
                registros[3] = rs.getString("Sueldo");
                registros[4] = rs.getString("TipoJornada");
                registros[5] = rs.getString("NumeroCelular");
                registros[6] = rs.getString("NombreDocumento");
                registros[7] = rs.getString("Correo");
                model.addRow(registros);
            }
            
            tablaVendedores.setModel(model);
        } catch (SQLException ex){
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   void buscarData(String valor){
         String[] titulos = {"IDVendedor", "Nombre", "Direccion", "Sueldo", "Jornada", "Celular", "Documento", "Correo"};
        String[] registros = new String[8];
        String sql = "SELECT * FROM vendedor WHERE CONCAT (IDVendedor, ' ', Nombre) LIKE '%"+ valor +"%'";
        
        model = new DefaultTableModel(null, titulos);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("IDVendedor");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Direccion");
                registros[3] = rs.getString("Sueldo");
                registros[4] = rs.getString("IDJornada");
                registros[5] = rs.getString("NumeroCelular");
                registros[6] = rs.getString("IDTipoDocumento");
                registros[7] = rs.getString("Correo");
                model.addRow(registros);
            }
            
            tablaVendedores.setModel(model);
        } catch (SQLException ex){
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuModificar = new javax.swing.JMenuItem();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        cbojornada = new javax.swing.JComboBox();
        cbodocu = new javax.swing.JComboBox();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtidvendedor1 = new javax.swing.JTextField();
        txtcelular2 = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnGuardar = new rojerusan.RSButtonHover();
        btnEditar = new rojerusan.RSButtonHover();
        btnEliminar = new rojerusan.RSButtonHover();
        btnNuevo = new rojerusan.RSButtonHover();
        txtdireccion1 = new javax.swing.JTextField();
        L7 = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        txtdocumento = new javax.swing.JTextField();
        txtcelular1 = new javax.swing.JTextField();
        L8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

        setBackground(new java.awt.Color(61, 61, 61));
        setMinimumSize(new java.awt.Dimension(700, 690));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L1.setForeground(new java.awt.Color(255, 255, 255));
        L1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L1.setText("ID VENDEDOR");
        add(L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, -1));

        L2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L2.setForeground(new java.awt.Color(255, 255, 255));
        L2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L2.setText("NOMBRE");
        add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 170, -1));

        L3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L3.setForeground(new java.awt.Color(255, 255, 255));
        L3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L3.setText("DIRECCION");
        add(L3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 170, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID JORNADA");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 156, -1));

        L4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L4.setForeground(new java.awt.Color(255, 255, 255));
        L4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L4.setText("SUELDO");
        add(L4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, -1));

        L6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L6.setForeground(new java.awt.Color(255, 255, 255));
        L6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L6.setText("CELULAR 2");
        add(L6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 170, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TIPO DOCUMENTO");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 166, -1));

        L5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L5.setForeground(new java.awt.Color(255, 255, 255));
        L5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L5.setText("CORREO");
        add(L5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 170, -1));

        cbojornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "MATUTINA", "DIURNA", "NOCTURNA" }));
        cbojornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbojornada.setPreferredSize(new java.awt.Dimension(166, 26));
        cbojornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojornadaActionPerformed(evt);
            }
        });
        add(cbojornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 290, 35));

        cbodocu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "TARJETA DE IDENTIDAD ", "PASAPORTE ", "RTN" }));
        cbodocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        add(cbodocu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 230, 35));

        txtbuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtbuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbuscar.setOpaque(false);
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 150, 30));

        tablaVendedores.setBackground(new java.awt.Color(61, 61, 61));
        tablaVendedores.setForeground(new java.awt.Color(255, 255, 255));
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IDVendedor", "Nombre", "Direccion", "Sueldo", "IDJornada", "NumeroCelular", "IDTipoDocumento", "Correo"
            }
        ));
        tablaVendedores.setComponentPopupMenu(jPopupMenu1);
        tablaVendedores.setOpaque(false);
        tablaVendedores.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaVendedores.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaVendedores);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 494, 788, 196));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VendedoresLT 1.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 24, -1, 40));

        txtidvendedor1.setForeground(new java.awt.Color(0, 0, 0));
        txtidvendedor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidvendedor1.setOpaque(false);
        add(txtidvendedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, 35));

        txtcelular2.setForeground(new java.awt.Color(0, 0, 0));
        txtcelular2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcelular2.setOpaque(false);
        txtcelular2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelular2KeyTyped(evt);
            }
        });
        add(txtcelular2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 130, 35));

        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setOpaque(false);
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 240, 35));

        txtcorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtcorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorreo.setOpaque(false);
        txtcorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcorreoFocusLost(evt);
            }
        });
        txtcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcorreoKeyTyped(evt);
            }
        });
        add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 240, 35));

        btnGuardar.setBackground(new java.awt.Color(81, 81, 81));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoGuardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setColorHover(new java.awt.Color(61, 61, 61));
        btnGuardar.setFocusable(false);
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 132, 35));

        btnEditar.setBackground(new java.awt.Color(81, 81, 81));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoEditar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorderPainted(false);
        btnEditar.setColorHover(new java.awt.Color(61, 61, 61));
        btnEditar.setFocusable(false);
        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 132, 35));

        btnEliminar.setBackground(new java.awt.Color(81, 81, 81));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoEliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setColorHover(new java.awt.Color(61, 61, 61));
        btnEliminar.setFocusable(false);
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 132, 35));

        btnNuevo.setBackground(new java.awt.Color(81, 81, 81));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoNuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setColorHover(new java.awt.Color(61, 61, 61));
        btnNuevo.setFocusable(false);
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 132, 35));

        txtdireccion1.setForeground(new java.awt.Color(0, 0, 0));
        txtdireccion1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdireccion1.setOpaque(false);
        txtdireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccion1KeyTyped(evt);
            }
        });
        add(txtdireccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 290, 35));

        L7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L7.setForeground(new java.awt.Color(255, 255, 255));
        L7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L7.setText("BUSCAR");
        add(L7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 122, -1));

        txtsueldo.setForeground(new java.awt.Color(0, 0, 0));
        txtsueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsueldo.setOpaque(false);
        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsueldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsueldoKeyTyped(evt);
            }
        });
        add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, 35));

        txtdocumento.setForeground(new java.awt.Color(0, 0, 0));
        txtdocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdocumento.setOpaque(false);
        txtdocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdocumentoFocusLost(evt);
            }
        });
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });
        add(txtdocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 170, 35));

        txtcelular1.setForeground(new java.awt.Color(0, 0, 0));
        txtcelular1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcelular1.setOpaque(false);
        txtcelular1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcelular1FocusLost(evt);
            }
        });
        txtcelular1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcelular1KeyTyped(evt);
            }
        });
        add(txtcelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 130, 35));

        L8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L8.setForeground(new java.awt.Color(255, 255, 255));
        L8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        L8.setText("CELULAR");
        add(L8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 170, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DATOS DOCUMENTO");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 166, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbojornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojornadaActionPerformed

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        int fila = tablaVendedores.getSelectedRow();
  
        if(fila>=0)
        {

            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnNuevo.setEnabled(true);
            txtidvendedor1.setEnabled(false);
            cbojornada.setEnabled(true);
            txtcelular2.setEnabled(true);
            txtcorreo.setEnabled(true);  
            txtnombre.setEnabled(true);  
            txtsueldo.setEnabled(true);  
            txtcorreo.setEnabled(true);  
            cbodocu.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtcelular1.setEnabled(true);
            txtdireccion1.setEnabled(true);
            
            String id=tablaVendedores.getValueAt(fila, 0).toString();
            String nom=tablaVendedores.getValueAt(fila, 1).toString();
            String dir=tablaVendedores.getValueAt(fila, 2).toString();
            String sue=tablaVendedores.getValueAt(fila, 3).toString();
            String idj=tablaVendedores.getValueAt(fila, 4).toString();
            String num=tablaVendedores.getValueAt(fila, 5).toString();
            String idt=tablaVendedores.getValueAt(fila, 6).toString();
            String cor=tablaVendedores.getValueAt(fila, 7).toString();
            
            
            txtidvendedor1.setText(id);
            txtnombre.setText(nom);
            txtdireccion1.setText(dir);      
            txtsueldo.setText(sue);
            if(idj.contains("Matutina")){
                cbojornada.setSelectedIndex(1);
            } else if(idj.contains("Diurna")){
                cbojornada.setSelectedIndex(2);
            } else if(idj.contains("Nocturna")){
                cbojornada.setSelectedIndex(3);
            }
            txtcelular1.setText(num);
            if(idt.contains("Identidad")){
                cbodocu.setSelectedIndex(1);
            } else if(idt.contains("Pasaporte")){
                cbodocu.setSelectedIndex(2);
            } else if(idt.contains("RTN")){
                cbodocu.setSelectedIndex(3);
            }
            txtcorreo.setText(cor);
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        txtidvendedor1.setEnabled(false);

        boolean guardo = true;
        datos data = new datos();
        if(cbojornada.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento");
        }
        
        else if(cbodocu.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Jornada");
        }
        
        else if(txtcelular1.getText().isEmpty() || cbodocu.getSelectedIndex() == 0 || cbojornada.getSelectedIndex() == 0 || txtcorreo.getText().isEmpty() || txtdireccion1.getText().isEmpty() || txtdocumento.getText().isEmpty() || txtnombre.getText().isEmpty() || txtsueldo.getText().isEmpty() || txtcelular2.getText().isEmpty()) {
     
            JOptionPane.showMessageDialog(null, "Aun hay campos vacios porfavor llenar todos los campos");
        }
                
        
        else if(Integer.parseInt(txtsueldo.getText()) < 8000){
            JOptionPane.showMessageDialog(null, "El sueldo debe de ser mayor");
             txtsueldo.setText("");
        }else if(txtcorreo.getText().contains("@") && txtcorreo.getText().contains(".com") || txtcorreo.getText().contains(".hn")){
            data.setNombre(txtnombre.getText());
            data.setDireccion(txtdireccion1.getText());
            data.setCorrreo(txtcorreo.getText());
            data.setSueldo(Float.parseFloat(txtsueldo.getText()));
            data.setIDJornada(cbojornada.getSelectedIndex());
            data.setNumeroCelular(Integer.parseInt(txtcelular1.getText()));
            data.setIDTipoDocumento(cbodocu.getSelectedIndex());

            guardo = data.guardar();
            if (guardo == true) {
                JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
            }
            cargarData("");
            limpiarCajas();
        }else {
            JOptionPane.showMessageDialog(null, "Correo NO Válido,Ejem: cinematix@gmail.com");
        } 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnNuevo.setEnabled(true);
        boolean edito = true;
         if(cbojornada.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento");
        }
        
        else if(cbodocu.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Jornada");
        }
        
        else if(txtcelular1.getText().isEmpty() || txtcorreo.getText().isEmpty() || txtdireccion1.getText().isEmpty() || txtdocumento.getText().isEmpty() || txtnombre.getText().isEmpty() || txtsueldo.getText().isEmpty() || txtcelular2.getText().isEmpty()) {
     
            JOptionPane.showMessageDialog(null, "Aun hay campos vacios porfavor llenar todos los campos");
        }
        
        else if(Integer.parseInt(txtsueldo.getText()) < 8000){
            JOptionPane.showMessageDialog(null, "El sueldo debe de ser mayor");
             txtsueldo.setText("");
        }else 
            
        if(txtcorreo.getText().contains("@") && txtcorreo.getText().contains(".com") || txtcorreo.getText().contains(".hn")){
            
            datos pro = new datos();
            pro.setIDVendedor(Integer.parseInt(txtidvendedor1.getText()));
            pro.setNombre(txtnombre.getText());
            pro.setDireccion(txtdireccion1.getText());
            pro.setSueldo(Integer.parseInt(txtsueldo.getText()));
            pro.setIDJornada(cbojornada.getSelectedIndex());
            pro.setNumeroCelular(Integer.parseInt(txtcelular1.getText()));
            pro.setIDTipoDocumento(cbodocu.getSelectedIndex());
            pro.setCorrreo(txtcorreo.getText());

            pro.editar();

            datos data = new datos();
            if (edito == true) {
                JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
            }
            cargarData("");
            limpiarCajas();
        }else {
            JOptionPane.showMessageDialog(null, "Correo NO Válido,Ejem: cinematix@gmail.com");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String sqlElim="DELETE FROM vendedor WHERE IDVendedor='"+txtidvendedor1.getText()+"'";
        try {
            PreparedStatement pst = cn.prepareStatement(sqlElim);
            int n=pst.executeUpdate();
            if(n>0)
            {
                JOptionPane.showMessageDialog(null, "Los datos fueron eliminados con exito");
                cargarData("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo Problemas al querer eliminar datos");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        limpiarCajas();
    }//GEN-LAST:event_btnEliminarActionPerformed
    
        public void limite(TextField txtnombre,TextField txtdireccion1){
        if(txtnombre.getText().length() > 35){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Supera Limite Permitido");
            alert.setHeaderText("Error");
            alert.setContentText("Supero el Limite de caracteres.+" +
                    " \n El limite de caracteres es de 35");
            alert.showAndWait();
            txtnombre.deleteText(35,txtnombre.getText().length());
        }           
    }
        
         public void limite2(TextField txtcelular1){
      }
        
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtidvendedor1.setEnabled(false);
        cbojornada.setEnabled(true);
        txtcelular1.setEnabled(true);
        txtcorreo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtsueldo.setEnabled(true);
        txtcorreo.setEnabled(true);
        txtdireccion1.setEnabled(true);
        txtdocumento.setEnabled(true);
        txtcelular2.setEnabled(true);
        cbodocu.setEnabled(true);
        txtbuscar.setText("");
        txtnombre.setText("");
        txtidvendedor1.setText("");
        txtbuscar.setText("");
        txtsueldo.setText("");
        txtcelular1.setText("");
        txtcorreo.setText("");

        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        buscarData(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtcelular1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelular1KeyTyped
        
        
        validarCaracteres(evt);
        char validar=evt.getKeyChar();
        
      
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
                    
        }
        if(txtcelular1.getText().length() >= 8){
            evt.consume();
        }
        
       
                
    }//GEN-LAST:event_txtcelular1KeyTyped

    private void txtcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcorreoKeyTyped
            char validar=evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo letras");
                    
        }
        
         if(txtcelular1.getText().charAt(0) == 1 || txtcelular1.getText().charAt(0) == 4 || txtcelular1.getText().charAt(0) == 5
                || txtcelular1.getText().charAt(0) == 6 || txtcelular1.getText().charAt(0) == 7 || txtcelular1.getText().charAt(0) == 0){
            JOptionPane.showMessageDialog(null, "Ingrese un número de celular válido");
            txtcelular1.setText("");
        }  
    }//GEN-LAST:event_txtcorreoKeyTyped

    private void txtdireccion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccion1KeyTyped
        if(txtdireccion1.getText().length() > 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccion1KeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        validarCaracteres(evt);
        char validar=evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo letras");
                    
        }
        if(txtnombre.getText().length() > 50){
            evt.consume();
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtsueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyTyped
            validarCaracteres(evt);
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
                    
        }
        if(txtsueldo.getText().length() > 5){
            evt.consume();
        }
        
    }//GEN-LAST:event_txtsueldoKeyTyped

    private void txtsueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyReleased
       
    }//GEN-LAST:event_txtsueldoKeyReleased

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped
         validarCaracteres(evt);  
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
                    
        }
    }//GEN-LAST:event_txtdocumentoKeyTyped

    private void txtcorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcorreoFocusLost
        if (email(txtcorreo.getText())) {
            
        }else{
            JOptionPane.showMessageDialog(null, "Correo incorrecto,validar ejem: cinematix@gmail.com");
        }
    }//GEN-LAST:event_txtcorreoFocusLost

    private void txtcelular2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcelular2KeyTyped
         validarCaracteres(evt); 
        char validar=evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
                    
        }
          if(txtcelular2.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_txtcelular2KeyTyped

    private void txtcelular1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcelular1FocusLost
       
        else if(txtcelular1.getText().length() < 8){
          JOptionPane.showMessageDialog(null, "El celular debe contener 8 digitos");
          
           txtcelular1.setText("");
        }
    }//GEN-LAST:event_txtcelular1FocusLost

    private void txtdocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdocumentoFocusLost
      if (cbodocu.getSelectedIndex() == 3){
          
      }
    }//GEN-LAST:event_txtdocumentoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JLabel L8;
    private rojerusan.RSButtonHover btnEditar;
    private rojerusan.RSButtonHover btnEliminar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox cbodocu;
    private javax.swing.JComboBox cbojornada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcelular1;
    private javax.swing.JTextField txtcelular2;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion1;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtidvendedor1;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
