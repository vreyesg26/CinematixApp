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
    
    void bloquear(){
        txtidvendedor1.setEnabled(false);
        cbojornada.setEnabled(false);
        txtcelular.setEnabled(false);
        txtcorreo.setEnabled(false);  
        txtnombre.setEnabled(false);  
        txtsueldo.setEnabled(false);  
        txtcorreo.setEnabled(false);  
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        cbodocu.setEnabled(false);
    }
    
    void limpiarCajas(){
        txtidvendedor1.setEnabled(false);
        cbojornada.setEnabled(false);
        txtcelular.setEnabled(false);
        txtcorreo.setEnabled(false);  
        txtnombre.setEnabled(false);  
        txtsueldo.setEnabled(false);  
        txtcorreo.setEnabled(false); 
        cbodocu.setEnabled(false);
    }
    
    Fuente tipoFuente;
    public panelVendedores() {
        initComponents();
        bloquear();
        cargarData("");
        
        tipoFuente = new Fuente();
        txtnombre.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtcelular.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtsueldo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtdireccion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
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
        String sql = "SELECT * FROM vendedor";
        
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
        txtdireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtidvendedor1 = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        btnGuardar = new rojerusan.RSButtonHover();
        btnEditar = new rojerusan.RSButtonHover();
        btnEliminar = new rojerusan.RSButtonHover();
        btnNuevo = new rojerusan.RSButtonHover();

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

        setBackground(new java.awt.Color(61, 61, 61));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 690));

        L1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L1.setForeground(new java.awt.Color(255, 255, 255));
        L1.setText("ID VENDEDOR");

        L2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L2.setForeground(new java.awt.Color(255, 255, 255));
        L2.setText("NOMBRE");

        L3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L3.setForeground(new java.awt.Color(255, 255, 255));
        L3.setText("DIRECCION");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID JORNADA");

        L4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L4.setForeground(new java.awt.Color(255, 255, 255));
        L4.setText("SUELDO");

        L6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L6.setForeground(new java.awt.Color(255, 255, 255));
        L6.setText("NUMERO CELULAR");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID TIPO DOCUMENTO");

        L5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        L5.setForeground(new java.awt.Color(255, 255, 255));
        L5.setText("CORREO");

        cbojornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "MATUTINA", "DIURNA", "NOCTURNA" }));
        cbojornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbojornada.setPreferredSize(new java.awt.Dimension(166, 26));
        cbojornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojornadaActionPerformed(evt);
            }
        });

        cbodocu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "TARJETA DE IDENTIDAD ", "PASAPORTE ", "RTN" }));
        cbodocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));

        txtdireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtdireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdireccion.setOpaque(false);

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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VendedoresLT 1.png"))); // NOI18N

        txtidvendedor1.setForeground(new java.awt.Color(255, 255, 255));
        txtidvendedor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidvendedor1.setOpaque(false);

        txtcelular.setForeground(new java.awt.Color(255, 255, 255));
        txtcelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcelular.setOpaque(false);

        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombre.setOpaque(false);

        txtsueldo.setForeground(new java.awt.Color(255, 255, 255));
        txtsueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsueldo.setOpaque(false);

        txtcorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtcorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorreo.setOpaque(false);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(cbodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(cbojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel8)
                                .addGap(187, 187, 187)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidvendedor1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(L1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(L2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(L3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtsueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(L4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(L5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtcorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(L6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidvendedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(L1)
                                    .addComponent(L3)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L2)))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L5)
                            .addComponent(L6))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbodocu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbojornada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(L4)
                        .addGap(438, 438, 438))))
        );
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
            btnNuevo.setEnabled(false);
            txtidvendedor1.setEnabled(true);
            cbojornada.setEnabled(true);
            txtcelular.setEnabled(true);
            txtcorreo.setEnabled(true);  
            txtnombre.setEnabled(true);  
            txtsueldo.setEnabled(true);  
            txtcorreo.setEnabled(true);  
            cbodocu.setEnabled(true);
            btnGuardar.setEnabled(false);
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
            txtdireccion.setText(dir);      
            txtsueldo.setText(sue);
            cbojornada.setSelectedIndex(Integer.valueOf(idj));
            txtcelular.setText(num);
            cbodocu.setSelectedIndex(Integer.valueOf(idt));
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

        boolean guardo = true;
        datos data = new datos();
        if(cbojornada.getSelectedIndex() == 0){
            JOptionPane.showConfirmDialog(null, "Debe seleccionar una opción");
        }
        if(cbodocu.getSelectedIndex() == 0){
            JOptionPane.showConfirmDialog(null, "Debe seleccionar una opción");
        }

        data.setNombre(txtnombre.getText());
        data.setDireccion(txtdireccion.getText());
        data.setCorrreo(txtcorreo.getText());
        data.setSueldo(Float.parseFloat(txtsueldo.getText()));
        data.setIDJornada(cbojornada.getSelectedIndex());
        data.setNumeroCelular(Integer.parseInt(txtcelular.getText()));
        data.setIDTipoDocumento(cbodocu.getSelectedIndex());

        guardo = data.guardar();
        if (guardo==true){
            JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
        }
        cargarData("");
        limpiarCajas();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnNuevo.setEnabled(true);
        boolean edito = true;
        datos pro = new datos();
        pro.setIDVendedor(Integer.parseInt(txtidvendedor1.getText()));
        pro.setNombre(txtnombre.getText());
        pro.setDireccion(txtdireccion.getText());
        pro.setSueldo(Float.parseFloat(txtsueldo.getText()));
        pro.setIDJornada(Integer.valueOf(cbojornada.getSelectedIndex()));
        pro.setNumeroCelular(Integer.parseInt(txtcelular.getText()));
        pro.setIDTipoDocumento(Integer.valueOf(cbodocu.getSelectedIndex()));
        pro.setCorrreo(txtcorreo.getText());

        pro.editar();

        datos data = new datos();
        if (edito==true){
            JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
        }
        cargarData("");
        limpiarCajas();
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtidvendedor1.setEnabled(true);
        cbojornada.setEnabled(true);
        txtcelular.setEnabled(true);
        txtcorreo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtsueldo.setEnabled(true);
        txtcorreo.setEnabled(true);
        cbodocu.setEnabled(true);
        txtdireccion.setText("");
        txtnombre.setText("");
        txtidvendedor1.setText("");
        txtdireccion.setText("");
        txtsueldo.setText("");
        txtcelular.setText("");
        txtcorreo.setText("");

        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private rojerusan.RSButtonHover btnEditar;
    private rojerusan.RSButtonHover btnEliminar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox cbodocu;
    private javax.swing.JComboBox cbojornada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtidvendedor1;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
