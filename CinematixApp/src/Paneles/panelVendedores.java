/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Datos.Conexion;
import Logica.datos;
import Tipografia.Fuente;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Los Pibes
 */
public class panelVendedores extends javax.swing.JPanel {

    /**
     * Creates new form panelVendedores
     */
    public boolean email(String correo) {
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        m = p.matcher(correo);

        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    void bloquear() {
        txtIDVendedor.setEnabled(false);
        cbJornada.setEnabled(false);
        txtCelular.setEnabled(false);
        txtClave.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtNumDocu.setEnabled(false);
        txtNombre.setEnabled(false);
        txtSueldo.setEnabled(false);
        txtDireccion.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        cbTipoDocu.setEnabled(false);
        tablaVendedores.setEnabled(false);
    }

    void limpiarCajas() {
        txtIDVendedor.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtNombre.setText("");
        txtSueldo.setText("");
        txtUsuario.setText("");
        txtNumDocu.setText("");
        txtClave.setText("");
        cbTipoDocu.setSelectedIndex(0);
        cbJornada.setSelectedIndex(0);
    }

    public void validarCaracteres(java.awt.event.KeyEvent e) {
        if (e.getKeyChar() >= 33 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 64
                || e.getKeyChar() >= 91 && e.getKeyChar() <= 96
                || e.getKeyChar() >= 123 && e.getKeyChar() <= 208
                || e.getKeyChar() >= 210 && e.getKeyChar() <= 240
                || e.getKeyChar() >= 242 && e.getKeyChar() <= 255) {

            e.consume();
            ImageIcon jPaneIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Este campo no acepta caracteres especiales", "Error", JOptionPane.PLAIN_MESSAGE, jPaneIcon);
        }
    }

    public static boolean validarNumeros(String datos) {
        return datos.matches("[0-9]");
    }

    public static boolean validarStrings(String datos) {
        return datos.matches("[a-zA-Z]");
    }

    Fuente tipoFuente;

    public panelVendedores() {
        initComponents();
        bloquear();
        cargarData();
        anchoColumnas();

        tipoFuente = new Fuente();
        txtIDVendedor.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtNombre.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtUsuario.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtClave.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtDireccion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtSueldo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbJornada.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtCelular.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbTipoDocu.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtCorreo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtNumDocu.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtBuscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        tablaVendedores.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        lb1.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb2.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb3.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb4.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb5.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb6.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb7.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb8.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb9.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb10.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lb11.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));

        btnGuardar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnEditar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnEliminar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnNuevo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablaVendedores.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(30);
        anchoColumnas.getColumn(1).setPreferredWidth(120);
        anchoColumnas.getColumn(2).setPreferredWidth(150);
        anchoColumnas.getColumn(3).setPreferredWidth(70);
        anchoColumnas.getColumn(4).setPreferredWidth(90);
        anchoColumnas.getColumn(5).setPreferredWidth(80);
        anchoColumnas.getColumn(6).setPreferredWidth(80);
        anchoColumnas.getColumn(7).setPreferredWidth(120);
        anchoColumnas.getColumn(8).setPreferredWidth(200);
        anchoColumnas.getColumn(9).setPreferredWidth(80);
        anchoColumnas.getColumn(10).setPreferredWidth(200);
        anchoColumnas.getColumn(11).setPreferredWidth(60);
    }

    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void cargarData() {
        String[] titulos = {"ID", "Nombre", "Direccion", "Sueldo", "Jornada", "Celular", "Documento", "NumeroDocumento", "Correo", "Usuario", "Clave", "Intentos"};
        String[] registros = new String[12];
        String sql = "SELECT IDVendedor, Nombre , Direccion, Sueldo, TipoJornada, NumeroCelular, NombreDocumento, NumeroDocumento, Correo, Usuario, Clave, Intentos\n"
                + "                FROM vendedor INNER JOIN jornadas USING (IDJornada)\n"
                + "                INNER JOIN tipodocumento USING (IDTipoDocumento)\n"
                + "                WHERE IDVendedor != 0 ORDER BY IDVendedor";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IDVendedor");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Direccion");
                registros[3] = rs.getString("Sueldo");
                registros[4] = rs.getString("TipoJornada");
                registros[5] = rs.getString("NumeroCelular");
                registros[6] = rs.getString("NombreDocumento");
                registros[7] = rs.getString("NumeroDocumento");
                registros[8] = rs.getString("Correo");
                registros[9] = rs.getString("Usuario");
                registros[10] = rs.getString("Clave");
                registros[11] = rs.getString("Intentos");
                model.addRow(registros);
            }

            tablaVendedores.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void buscarData(String valor) {
        String[] titulos = {"ID", "Nombre", "Direccion", "Sueldo", "Jornada", "Celular", "Documento", "NumeroDocumento", "Correo", "Usuario", "Clave", "Intentos"};
        String[] registros = new String[12];
        String sql = "SELECT IDVendedor, Nombre, Direccion, Sueldo, TipoJornada, NumeroCelular, NombreDocumento, NumeroDocumento, Correo, Usuario, Clave, Intentos\n"
                + "                FROM vendedor INNER JOIN jornadas USING (IDJornada)\n"
                + "                INNER JOIN tipodocumento USING (IDTipoDocumento)\n"
                + "                WHERE CONCAT (IDVendedor, ' ', Nombre) LIKE '%" + valor + "%'";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IDVendedor");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Direccion");
                registros[3] = rs.getString("Sueldo");
                registros[4] = rs.getString("TipoJornada");
                registros[5] = rs.getString("NumeroCelular");
                registros[6] = rs.getString("NombreDocumento");
                registros[7] = rs.getString("NumeroDocumento");
                registros[8] = rs.getString("Correo");
                registros[9] = rs.getString("Usuario");
                registros[10] = rs.getString("Clave");
                registros[11] = rs.getString("Intentos");
                model.addRow(registros);
            }

            tablaVendedores.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
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
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        lb10 = new javax.swing.JLabel();
        lb11 = new javax.swing.JLabel();
        cbJornada = new javax.swing.JComboBox();
        cbTipoDocu = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtIDVendedor = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new rojerusan.RSButtonHover();
        btnEditar = new rojerusan.RSButtonHover();
        btnEliminar = new rojerusan.RSButtonHover();
        btnNuevo = new rojerusan.RSButtonHover();
        txtDireccion = new javax.swing.JTextField();
        lbLupa = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        txtNumDocu = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

        setBackground(new java.awt.Color(61, 61, 61));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(700, 690));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 690));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("ID");

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("NOMBRE");

        lb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("DIRECCION");

        lb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("CELULAR");

        lb5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("SUELDO");

        lb6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("CORREO");

        lb7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb7.setForeground(new java.awt.Color(255, 255, 255));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("USUARIO");

        lb8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb8.setForeground(new java.awt.Color(255, 255, 255));
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setText("CLAVE");

        lb9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb9.setForeground(new java.awt.Color(255, 255, 255));
        lb9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb9.setText("TIPO DOCUMENTO");

        lb10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb10.setForeground(new java.awt.Color(255, 255, 255));
        lb10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb10.setText("DATOS DOCUMENTO");

        lb11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb11.setForeground(new java.awt.Color(255, 255, 255));
        lb11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb11.setText("JORNADA");

        cbJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "MATUTINA", "VESPERTINA", "NOCTURNA" }));
        cbJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbJornada.setPreferredSize(new java.awt.Dimension(166, 26));
        cbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadaActionPerformed(evt);
            }
        });

        cbTipoDocu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONAR", "TARJETA DE IDENTIDAD ", "PASAPORTE ", "RTN" }));
        cbTipoDocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));

        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setOpaque(false);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

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
        tablaVendedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaVendedores.setComponentPopupMenu(jPopupMenu1);
        tablaVendedores.setOpaque(false);
        tablaVendedores.setRowHeight(30);
        tablaVendedores.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaVendedores.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VendedoresLT 1.png"))); // NOI18N

        txtIDVendedor.setForeground(new java.awt.Color(255, 255, 255));
        txtIDVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDVendedor.setOpaque(false);

        txtClave.setForeground(new java.awt.Color(255, 255, 255));
        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave.setOpaque(false);
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setOpaque(false);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setOpaque(false);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

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
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoActualizar.png"))); // NOI18N
        btnEditar.setText("ACTUALIZAR");
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
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoDeshabilitar.png"))); // NOI18N
        btnEliminar.setText("DESHABILITAR");
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

        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setOpaque(false);
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        lbLupa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLupa.setForeground(new java.awt.Color(255, 255, 255));
        lbLupa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoBuscar.png"))); // NOI18N

        txtSueldo.setForeground(new java.awt.Color(255, 255, 255));
        txtSueldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSueldo.setOpaque(false);
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });

        txtNumDocu.setForeground(new java.awt.Color(255, 255, 255));
        txtNumDocu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumDocu.setOpaque(false);
        txtNumDocu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumDocuFocusLost(evt);
            }
        });
        txtNumDocu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocuActionPerformed(evt);
            }
        });
        txtNumDocu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumDocuKeyTyped(evt);
            }
        });

        txtCelular.setForeground(new java.awt.Color(255, 255, 255));
        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular.setOpaque(false);
        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCelularFocusLost(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setOpaque(false);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(lbLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(494, 494, 494)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbTipoDocu, 0, 192, Short.MAX_VALUE)
                                        .addComponent(lb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumDocu)
                                        .addComponent(lb10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbJornada, 0, 278, Short.MAX_VALUE)
                                        .addComponent(lb11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSueldo)
                                            .addComponent(txtNombre)
                                            .addComponent(lb2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                        .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lb6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                .addComponent(txtCorreo))
                                            .addGap(166, 166, 166))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtDireccion)
                                                .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                                            .addGap(12, 12, 12)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(lb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addGap(0, 8, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb1)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb3)
                    .addComponent(lb2)
                    .addComponent(lb4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb5)
                    .addComponent(lb6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb8)
                        .addComponent(lb7)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipoDocu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumDocu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb9)
                    .addComponent(lb10)
                    .addComponent(lb11))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJornadaActionPerformed

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        int fila = tablaVendedores.getSelectedRow();

        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnEliminar.setIcon(iconobtn);
        btnEliminar.setText("CANCELAR");

        if (fila >= 0) {
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnNuevo.setEnabled(false);
            txtIDVendedor.setEnabled(false);
            cbJornada.setEnabled(true);
            txtClave.setEnabled(true);
            txtCorreo.setEnabled(true);
            txtNombre.setEnabled(true);
            txtSueldo.setEnabled(true);
            txtCorreo.setEnabled(true);
            txtUsuario.setEnabled(true);
            txtNumDocu.setEnabled(true);
            cbTipoDocu.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtCelular.setEnabled(true);
            txtDireccion.setEnabled(true);

            String id = tablaVendedores.getValueAt(fila, 0).toString();
            String nombre = tablaVendedores.getValueAt(fila, 1).toString();
            String direccion = tablaVendedores.getValueAt(fila, 2).toString();
            String sueldo = tablaVendedores.getValueAt(fila, 3).toString();
            String idJornada = tablaVendedores.getValueAt(fila, 4).toString();
            String numCelular = tablaVendedores.getValueAt(fila, 5).toString();
            String idTipoDocumento = tablaVendedores.getValueAt(fila, 6).toString();
            String numDocumento = tablaVendedores.getValueAt(fila, 7).toString();
            String correo = tablaVendedores.getValueAt(fila, 8).toString();
            String usuario = tablaVendedores.getValueAt(fila, 9).toString();
            String clave = tablaVendedores.getValueAt(fila, 10).toString();

            txtIDVendedor.setText(id);
            txtNombre.setText(nombre);
            txtDireccion.setText(direccion);
            txtSueldo.setText(sueldo);
            if (idJornada.contains("Matutina")) {
                cbJornada.setSelectedIndex(1);
            } else if (idJornada.contains("Vespertina")) {
                cbJornada.setSelectedIndex(2);
            } else if (idJornada.contains("Nocturna")) {
                cbJornada.setSelectedIndex(3);
            }
            txtCelular.setText(numCelular);
            if (idTipoDocumento.contains("Identidad")) {
                cbTipoDocu.setSelectedIndex(1);
            } else if (idTipoDocumento.contains("Pasaporte")) {
                cbTipoDocu.setSelectedIndex(2);
            } else if (idTipoDocumento.contains("RTN")) {
                cbTipoDocu.setSelectedIndex(3);
            }
            txtNumDocu.setText(numDocumento);
            txtCorreo.setText(correo);
            txtUsuario.setText(usuario);
            txtClave.setText(clave);
        } else {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean guardo = true;
        datos data = new datos();
        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
        if (cbTipoDocu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (cbJornada.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Jornada", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (txtCelular.getText().isEmpty() || cbTipoDocu.getSelectedIndex() == 0 || cbJornada.getSelectedIndex() == 0 || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNumDocu.getText().isEmpty() || txtNombre.getText().isEmpty() || txtSueldo.getText().isEmpty() || txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aun hay campos vacios porfavor llenar todos los campos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (Integer.parseInt(txtSueldo.getText()) < 8000) {
            JOptionPane.showMessageDialog(null, "El sueldo debe de ser mayor de 8000", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            txtSueldo.setText("");
        } else if (txtCorreo.getText().contains("@") && txtCorreo.getText().contains(".com") || txtCorreo.getText().contains(".hn")) {
            data.setNombre(txtNombre.getText());
            data.setUsuario(txtUsuario.getText());
            data.setClave(txtClave.getText());
            data.setDireccion(txtDireccion.getText());
            data.setSueldo(Integer.parseInt(txtSueldo.getText()));
            data.setIDJornada(cbJornada.getSelectedIndex());
            data.setNumeroCelular(Integer.parseInt(txtCelular.getText()));
            data.setIDTipoDocumento(cbTipoDocu.getSelectedIndex());
            data.setNumeroDocumento(txtNumDocu.getText());
            data.setCorrreo(txtCorreo.getText());

            guardo = data.guardar();
            if (guardo == true) {
                ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                JOptionPane.showMessageDialog(null, "Los datos fueron guardados correctamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
            }
            limpiarCajas();
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtIDVendedor.setEnabled(false);
            bloquear();
            cargarData();
        } else {
            JOptionPane.showMessageDialog(null, "Correo NO Válido,Ejem: cinematix@gmail.com", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);

        boolean edito = true;
        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
        if (cbJornada.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Jornada", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (cbTipoDocu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (txtCelular.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtNumDocu.getText().isEmpty() || txtNombre.getText().isEmpty() || txtSueldo.getText().isEmpty() || txtClave.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Aun hay campos vacios porfavor llenar todos los campos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (Integer.parseInt(txtSueldo.getText()) < 8000) {
            JOptionPane.showMessageDialog(null, "El sueldo debe de ser mayor", "Error", JOptionPane.ERROR_MESSAGE);
            txtSueldo.setText("");
        } else if (txtCorreo.getText().contains("@") && txtCorreo.getText().contains(".com") || txtCorreo.getText().contains(".hn")) {

            datos pro = new datos();
            pro.setIDVendedor(Integer.parseInt(txtIDVendedor.getText()));
            pro.setNombre(txtNombre.getText());
            pro.setUsuario(txtUsuario.getText());
            pro.setClave(txtClave.getText());
            pro.setDireccion(txtDireccion.getText());
            pro.setSueldo(Integer.parseInt(txtSueldo.getText()));
            pro.setIDJornada(cbJornada.getSelectedIndex());
            pro.setNumeroCelular(Integer.parseInt(txtCelular.getText()));
            pro.setIDTipoDocumento(cbTipoDocu.getSelectedIndex());
            pro.setNumeroDocumento(txtNumDocu.getText());
            pro.setCorrreo(txtCorreo.getText());
            pro.editar();

            datos data = new datos();
            if (edito == true) {
                ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                JOptionPane.showMessageDialog(null, "Datos actualizados de exitosamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
            }
            cargarData();
            limpiarCajas();
            bloquear();
        } else {
            JOptionPane.showMessageDialog(null, "Correo NO Válido,Ejem: cinematix@gmail.com", "", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tablaVendedores.getSelectedRow();
        String habilitado = "3";
        String deshabilitado = "0";

        if (fila >= 0) {
            String id = tablaVendedores.getValueAt(fila, 0).toString();
            String nombre = tablaVendedores.getValueAt(fila, 1).toString();

            if (btnEliminar.getText().equals("CANCELAR")) {
                limpiarCajas();
                btnEditar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(true);

                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnEliminar.setIcon(iconobtn);
                btnEliminar.setText("DESHABILITAR");

            } else if (btnEliminar.getText().equals("DESHABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas deshabilitar este vendedor?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `vendedor` SET `Intentos` = ? WHERE `vendedor`.`IDVendedor` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, deshabilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El vendedor " + nombre + " ha sido deshabilitado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                    } catch (Exception e) {

                    }
                }
            } else if (btnEliminar.getText().equals("HABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas habilitar este vendedor?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `vendedor` SET `Intentos` = ? WHERE `vendedor`.`IDVendedor` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, habilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El vendedor " + nombre + " ahora está habilitado", "Confirmación", JOptionPane.WARNING_MESSAGE, jPanelIcon2);
                    } catch (Exception e) {

                    }
                }
            }
        }
        cargarData();
        btnEliminar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void limite(TextField txtnombre, TextField txtdireccion1) {
        if (txtnombre.getText().length() > 35) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Supera Limite Permitido");
            alert.setHeaderText("Error");
            alert.setContentText("Supero el Limite de caracteres.+"
                    + " \n El limite de caracteres es de 35");
            alert.showAndWait();
            txtnombre.deleteText(35, txtnombre.getText().length());
        }
    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIDVendedor.setEnabled(false);
        cbJornada.setEnabled(true);
        txtCelular.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtNombre.setEnabled(true);
        txtSueldo.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtNumDocu.setEnabled(true);
        txtClave.setEnabled(true);
        cbTipoDocu.setEnabled(true);
        limpiarCajas();
        tablaVendedores.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        buscarData(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtNumDocuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumDocuActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        validarCaracteres(evt);
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
        if (txtCelular.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped

    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        if (txtDireccion.getText().length() > 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        validarCaracteres(evt);
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Ingresar solo letras", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
        if (txtNombre.getText().length() > 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        validarCaracteres(evt);
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
        if (txtSueldo.getText().length() > 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtSueldoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyReleased

    }//GEN-LAST:event_txtSueldoKeyReleased

    private void txtNumDocuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocuKeyTyped
        if (cbTipoDocu.getSelectedIndex() == 1) {
            char validar = evt.getKeyChar();
            if (Character.isLetter(validar)) {
                getToolkit().beep();
                evt.consume();
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Este tipo de documento solo contiene números", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }

            if (txtNumDocu.getText().length() > 12) {
                evt.consume();
            }
        }
        if (cbTipoDocu.getSelectedIndex() == 2) {
            validarCaracteres(evt);
            char validar = evt.getKeyChar();
            if (Character.isLetter(validar)) {
                getToolkit().beep();
                evt.consume();
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Este tipo de documento solo contiene números", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
            if (txtNumDocu.getText().length() > 6) {
                evt.consume();
            }
        }
        if (cbTipoDocu.getSelectedIndex() == 3) {
            char validar = evt.getKeyChar();
            if (Character.isLetter(validar)) {
                getToolkit().beep();
                evt.consume();
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Este tipo de documento solo contiene números", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }

            if (txtNumDocu.getText().length() > 13) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumDocuKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (txtCelular.getText().isEmpty()) {
            if (email(txtCorreo.getText())) {
                Conexion cc = new Conexion();
                Connection cn = cc.GetConexion();
                String correo = txtCorreo.getText();
                String sql = "SELECT Correo FROM vendedor WHERE Correo = '" + correo + "'";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    if (rs.next()) {
                        if (rs.getString("Correo").equals(correo)) {
                            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                            JOptionPane.showMessageDialog(null, "Este correo ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                        }
                    }
                } catch (Exception e) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                }
            } else {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Correo incorrecto,validar ejem: cinematix@gmail.com", "", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped
        validarCaracteres(evt);
    }//GEN-LAST:event_txtClaveKeyTyped

    private void txtCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusLost
        if (!txtCelular.getText().isEmpty()) {
            if (txtCelular.getText().length() < 8) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El debe comenzar con 3, 8 o 9", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            } else if (txtCelular.getText().charAt(0) == '0' || txtCelular.getText().charAt(0) == '1' || txtCelular.getText().charAt(0) == '4' || txtCelular.getText().charAt(0) == '5' || txtCelular.getText().charAt(0) == '6' || txtCelular.getText().charAt(0) == '2') {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El número de celular debe comenzar con 7, 3, 8 o 9", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                txtCelular.setText("");
            }
        }
    }//GEN-LAST:event_txtCelularFocusLost

    private void txtNumDocuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumDocuFocusLost
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String numDocu = txtNumDocu.getText();
        String tipoDocu = String.valueOf(cbTipoDocu.getSelectedIndex());
        String sql = "SELECT IDTipoDocumento, NumeroDocumento FROM vendedor WHERE IDTipoDocumento = '" + tipoDocu + "' and NumeroDocumento = '" + numDocu + "'";

        if (cbTipoDocu.getSelectedIndex() == 1) {
            if (txtNumDocu.getText().length() < 13) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El documento de identidad debe contener 13 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("IDTipoDocumento").equals(tipoDocu) && rs.getString("NumeroDocumento").equals(numDocu)) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este número de identidad ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                    }
                }
            } catch (Exception e) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
        if (cbTipoDocu.getSelectedIndex() == 2) {
            if (txtNumDocu.getText().length() < 7) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El código del pasaporte debe contener 7 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("IDTipoDocumento").equals(tipoDocu) && rs.getString("NumeroDocumento").equals(numDocu)) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este número de pasaporte ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                    }
                }
            } catch (Exception e) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
        if (cbTipoDocu.getSelectedIndex() == 3) {
            if (txtNumDocu.getText().length() < 14) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El número del RTN debe contener 14 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("IDTipoDocumento").equals(tipoDocu) && rs.getString("NumeroDocumento").equals(numDocu)) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este número de RTN ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                    }
                }
            } catch (Exception e) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtNumDocuFocusLost

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped

    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (!txtNombre.getText().isEmpty()) {
            if (txtNombre.getText().length() < 3) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El nombre debe de tener mas de 3 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if (!txtUsuario.getText().isEmpty()) {
            Conexion cc = new Conexion();
            Connection cn = cc.GetConexion();
            String user = txtUsuario.getText();
            String sql = "SELECT Usuario FROM vendedor WHERE Usuario = '" + user + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("Usuario").equals(txtUsuario.getText())) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este usuario ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                    }
                }
            } catch (Exception e) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void tablaVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVendedoresMouseClicked
        int fila = tablaVendedores.getSelectedRow();
        if (fila >= 0) {
            btnEliminar.setEnabled(true);
            String estado = tablaVendedores.getValueAt(fila, 11).toString();

            if ("3".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnEliminar.setIcon(iconobtn);
                btnEliminar.setText("DESHABILITAR");
            } else if ("0".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoHabilitar.png");
                btnEliminar.setIcon(iconobtn);
                btnEliminar.setText("HABILITAR");
            }
        }
    }//GEN-LAST:event_tablaVendedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnEditar;
    private rojerusan.RSButtonHover btnEliminar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox cbJornada;
    private javax.swing.JComboBox cbTipoDocu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbLupa;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIDVendedor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumDocu;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
