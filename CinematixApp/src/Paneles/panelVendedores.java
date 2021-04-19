/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Datos.Conexion;
import JFrames.TextPrompt;
import Tipografia.Fuente;
import encriptacion.Encode;
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
import javax.swing.BorderFactory;
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
    boolean guardar = false;

    void validarCamposVacios() {
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
        if (txtCelular.getText().isEmpty() && txtClave.getText().isEmpty() && txtCorreo.getText().isEmpty()
                && txtDireccion.getText().isEmpty()
                && cbJornada.getSelectedIndex() == 0
                && cbTipoDocu.getSelectedIndex() == 0 && txtNombre.getText().isEmpty()
                && txtNumDocu.getText().isEmpty() && txtSueldo.getText().isEmpty()
                && txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtCelular.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo celular", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtClave.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo clave", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo correo", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo direccion", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbJornada.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una jornada", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbTipoDocu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbTipoDocu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de documento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (Float.valueOf(txtSueldo.getText()) < 8000) {
            JOptionPane.showMessageDialog(null, "El sueldo debe de ser mayor de 8000", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            txtSueldo.setText("");
        } else {
            guardar = true;
        }
    }

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

    public boolean aprobado = false;
    public int aciertos = 0;

    public void verificarCaracteresRepetidos(String cadena) {
        String patron = "^(\\d|(([A-Za-zñÑáéíóúÁÉÍÓÚ\\s])\\3?(?!\\3)))+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if (!comparador.matches()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Tienes caracteres repetidos de forma incorrecta", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            aprobado = false;
        } else {
            aprobado = true;
        }
    }

    public boolean nombre(String nombre) {
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("^([A-Z-ÁÉÍÓÚÑ]{1}[a-z-áéíóúñ]+[ ]*){2,4}$");
        m = p.matcher(nombre);

        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pasaporte(String pasaporte) {
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("[A-Z-ÁÉÍÓÚÑ]{1}[0-9]{6}");
        m = p.matcher(pasaporte);

        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean identidad(String identidad) {
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("^[0-1]{1}[1-8]{1}[0-9]{2}[19|20]{2}[0-9]{7}");
        m = p.matcher(identidad);

        if (m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sueldo(String sueldo) {
        Pattern p = null;
        Matcher m = null;
        p = Pattern.compile("^\\d{4,5}([.][\\d]{2})?$");
        m = p.matcher(sueldo);

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
        btnActualizar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
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
        tablaVendedores.clearSelection();
    }

    void cargarTipoDocumento() {
        String sql = "SELECT NombreDocumento FROM tipodocumento";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbTipoDocu.addItem("SELECCIONE...");
            while (rs.next()) {
                cbTipoDocu.addItem(rs.getString("NombreDocumento").toUpperCase());
            }

        } catch (Exception e) {

        }
    }

    void cargarJornadas() {
        String sql = "SELECT TipoJornada FROM jornadas";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbJornada.addItem("SELECCIONE...");
            while (rs.next()) {
                cbJornada.addItem(rs.getString("TipoJornada").toUpperCase());
            }

        } catch (Exception e) {

        }
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
        cargarJornadas();
        cargarTipoDocumento();

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
        btnActualizar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnDeshabilitar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnNuevo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));

        TextPrompt buscar = new TextPrompt("Buscar por ID o Nombre", txtBuscar);
        buscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
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
        String[] titulos = {"ID", "Nombre", "Dirección", "Sueldo", "Jornada", "Celular", "Documento", "NumeroDocumento", "Correo", "Usuario", "Clave", "Intentos"};
        String[] registros = new String[12];

        String sql = "SELECT V.IDVendedor, V.Nombre, V.Direccion, V.Sueldo, J.TipoJornada, V.NumeroCelular,\n"
                + "TD.NombreDocumento, V.NumeroDocumento, V.Correo, V.Usuario, V.Clave, V.Intentos\n"
                + "FROM vendedor AS V\n"
                + "INNER JOIN jornadas AS J ON J.IDJornada = V.IDJornada\n"
                + "INNER JOIN tipodocumento as TD ON TD.IDTipoDocumento = V.IDTipoDocumento\n"
                + "ORDER BY V.IDVendedor";

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
        btnActualizar = new rojerusan.RSButtonHover();
        btnDeshabilitar = new rojerusan.RSButtonHover();
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
        lb3.setText("DIRECCIÓN");

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
        lb10.setText("NÚMERO DEL DOCUMENTO");

        lb11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb11.setForeground(new java.awt.Color(255, 255, 255));
        lb11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb11.setText("JORNADA");

        cbJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        cbJornada.setPreferredSize(new java.awt.Dimension(166, 26));
        cbJornada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbJornadaFocusGained(evt);
            }
        });
        cbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadaActionPerformed(evt);
            }
        });

        cbTipoDocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbTipoDocu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbTipoDocuFocusGained(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setOpaque(false);
        txtBuscar.setSelectedTextColor(new java.awt.Color(255, 255, 255));
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
        txtIDVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtIDVendedor.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIDVendedor.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIDVendedor.setOpaque(false);
        txtIDVendedor.setSelectedTextColor(new java.awt.Color(255, 255, 255));

        txtClave.setForeground(new java.awt.Color(255, 255, 255));
        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtClave.setCaretColor(new java.awt.Color(255, 255, 255));
        txtClave.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtClave.setOpaque(false);
        txtClave.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClaveFocusLost(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtNombre.setOpaque(false);
        txtNombre.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtCorreo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCorreo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCorreo.setOpaque(false);
        txtCorreo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
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

        btnActualizar.setBackground(new java.awt.Color(81, 81, 81));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoActualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setColorHover(new java.awt.Color(61, 61, 61));
        btnActualizar.setFocusable(false);
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnDeshabilitar.setBackground(new java.awt.Color(81, 81, 81));
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoDeshabilitar.png"))); // NOI18N
        btnDeshabilitar.setText("DESHABILITAR");
        btnDeshabilitar.setBorderPainted(false);
        btnDeshabilitar.setColorHover(new java.awt.Color(61, 61, 61));
        btnDeshabilitar.setFocusable(false);
        btnDeshabilitar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
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
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtDireccion.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDireccion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtDireccion.setOpaque(false);
        txtDireccion.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
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
        txtSueldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtSueldo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSueldo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSueldo.setOpaque(false);
        txtSueldo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSueldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSueldoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSueldoFocusLost(evt);
            }
        });
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
        txtNumDocu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNumDocu.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNumDocu.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtNumDocu.setOpaque(false);
        txtNumDocu.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtNumDocu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumDocuFocusGained(evt);
            }
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
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtCelular.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCelular.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCelular.setOpaque(false);
        txtCelular.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCelularFocusGained(evt);
            }
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
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUsuario.setOpaque(false);
        txtUsuario.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    void modificarRegistro() {
        int fila = tablaVendedores.getSelectedRow();

        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");

        if (fila >= 0) {
            btnActualizar.setEnabled(true);
            btnDeshabilitar.setEnabled(true);
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
    }

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        if (!txtNombre.getText().isEmpty() || !txtDireccion.getText().isEmpty() || cbJornada.getSelectedIndex() != 0
                || !txtSueldo.getText().isEmpty() || !txtCorreo.getText().isEmpty() || !txtUsuario.getText().isEmpty()
                || !txtClave.getText().isEmpty() || cbTipoDocu.getSelectedIndex() != 0 || !txtCelular.getText().isEmpty()
                || !txtNumDocu.getText().isEmpty()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
            int decision = JOptionPane.showConfirmDialog(null, "Los datos aún no se han guardado y podrían perderse\n "
                    + "¿Seguro que desea entrar en modo edición?", "Confirmación", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            if (decision == 0) {
                modificarRegistro();
            }
        } else {
            modificarRegistro();
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    Encode enconde = new Encode();
    String secretKey = "lospibes";
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if (!guardar == false) {
            String sql = "INSERT INTO vendedor "
                    + "(Nombre, Direccion, Sueldo, IDJornada, NumeroCelular, IDTipoDocumento, NumeroDocumento, Correo, Usuario, Clave)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            try {

                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtNombre.getText());
                pst.setString(2, txtDireccion.getText());
                pst.setString(3, txtSueldo.getText());
                pst.setInt(4, cbJornada.getSelectedIndex());
                pst.setInt(5, Integer.parseInt(txtCelular.getText()));
                pst.setInt(6, cbTipoDocu.getSelectedIndex());
                pst.setString(7, txtNumDocu.getText());
                pst.setString(8, txtCorreo.getText());
                pst.setString(9, txtUsuario.getText());
                pst.setString(10, enconde.ecnode(secretKey, txtClave.getText()));

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro se guardó satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    limpiarCajas();
                    bloquear();

                    btnDeshabilitar.setEnabled(false);
                    btnActualizar.setEnabled(false);

                }

            } catch (Exception e) {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar guardar el registro", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                System.out.println(e.getMessage());
            }
        }
        cargarData();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if (!guardar == false) {
            String sql = "UPDATE vendedor SET Nombre = ?, Direccion = ?, Sueldo = ?, "
                    + "IDJornada = ?, NumeroCelular = ?, IDTipoDocumento = ?, NumeroDocumento = ?, "
                    + "Correo = ?, Usuario = ?, Clave = ? "
                    + "WHERE IDVendedor = '" + txtIDVendedor.getText() + "'";

            try {
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtNombre.getText());
                pst.setString(2, txtDireccion.getText());
                pst.setString(3, txtSueldo.getText());
                pst.setInt(4, cbJornada.getSelectedIndex());
                pst.setInt(5, Integer.parseInt(txtCelular.getText()));
                pst.setInt(6, cbTipoDocu.getSelectedIndex());
                pst.setString(7, txtNumDocu.getText());
                pst.setString(8, txtCorreo.getText());
                pst.setString(9, txtUsuario.getText());
                pst.setString(10, enconde.ecnode(secretKey, txtClave.getText()));

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/Iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "Se actualizó el registro satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    limpiarCajas();
                    btnGuardar.setEnabled(false);
                    btnNuevo.setEnabled(true);
                    btnDeshabilitar.setEnabled(false);
                    btnActualizar.setEnabled(false);
                    tablaVendedores.setEnabled(false);
                    bloquear();

                    ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                    btnDeshabilitar.setIcon(iconobtn);
                    btnDeshabilitar.setText("DESHABILITAR");
                }

            } catch (Exception e) {
                ImageIcon jPanelIcono = new ImageIcon("src/Iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                System.out.println(e.getMessage());
            }
        }
        cargarData();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        int fila = tablaVendedores.getSelectedRow();
        String habilitado = "3";
        String deshabilitado = "0";

        if (fila >= 0) {
            String id = tablaVendedores.getValueAt(fila, 0).toString();
            String nombre = tablaVendedores.getValueAt(fila, 1).toString();

            if (btnDeshabilitar.getText().equals("CANCELAR")) {
                limpiarCajas();
                btnActualizar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnDeshabilitar.setEnabled(false);
                btnGuardar.setEnabled(true);

                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("DESHABILITAR");

            } else if (btnDeshabilitar.getText().equals("DESHABILITAR")) {
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
            } else if (btnDeshabilitar.getText().equals("HABILITAR")) {
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
        bloquear();
        limpiarCajas();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

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
        btnDeshabilitar.setEnabled(true);
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
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

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }

        if (txtSueldo.getText().contains(".")) {
            if (txtSueldo.getText().length() == 8) {
                evt.consume();
            }
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
            } else if (txtNumDocu.getText().length() > 12) {
                evt.consume();
            }
        }
        if (cbTipoDocu.getSelectedIndex() == 2) {

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
            } else if (txtNumDocu.getText().length() > 13) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNumDocuKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (!txtCorreo.getText().isEmpty()) {
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
                JOptionPane.showMessageDialog(null, "Debes escribir un correo que sea válido\n•Ejemplo: cinematix@gmail.com", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped
        //validarCaracteres(evt);
    }//GEN-LAST:event_txtClaveKeyTyped

    private void txtCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusLost
        if (!txtCelular.getText().isEmpty()) {
            if (txtCelular.getText().length() < 8) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El número de celular debe contener 8 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            } else if (txtCelular.getText().charAt(0) == '0' || txtCelular.getText().charAt(0) == '1' || txtCelular.getText().charAt(0) == '4' || txtCelular.getText().charAt(0) == '5' || txtCelular.getText().charAt(0) == '6' || txtCelular.getText().charAt(0) == '2') {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "El número de celular debe comenzar con 7, 3, 8 o 9", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                txtCelular.setText("");
            }
        }
    }//GEN-LAST:event_txtCelularFocusLost

    private void txtNumDocuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumDocuFocusLost
        if (!txtNumDocu.getText().isEmpty()) {
            Conexion cc = new Conexion();
            Connection cn = cc.GetConexion();
            String numDocu = txtNumDocu.getText();
            String tipoDocu = String.valueOf(cbTipoDocu.getSelectedIndex());
            String sql = "SELECT IDTipoDocumento, NumeroDocumento FROM vendedor WHERE IDTipoDocumento = '" + tipoDocu + "' and NumeroDocumento = '" + numDocu + "'";

            if (cbTipoDocu.getSelectedIndex() == 1) {
                if (txtNumDocu.getText().length() < 13) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El número de identidad debe contener 13 dígitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else if (!identidad(txtNumDocu.getText())) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El número de identidad debe comenzar con dígitos del 01 al 18\nAsegurate de que el año sea correcto", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else {
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
            }
            if (cbTipoDocu.getSelectedIndex() == 2) {
                if (txtNumDocu.getText().length() < 7) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El código del pasaporte debe contener 7 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else if (!pasaporte(txtNumDocu.getText())) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El código del pasaporte debe empezar con una letra mayúsucula seguido de 6 numeros", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else {
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
            }
            if (cbTipoDocu.getSelectedIndex() == 3) {
                if (txtNumDocu.getText().length() < 14) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El número del RTN debe contener 14 digitos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else {
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
            }
        }
    }//GEN-LAST:event_txtNumDocuFocusLost

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped

    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (!txtNombre.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtNombre.getText());
            if (aprobado != false) {
                if (!nombre(txtNombre.getText())) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El nombre debe empezar con mayúscula y debe contener al menos un apellido", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else if (txtNombre.getText().length() < 3) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El nombre debe de tener más de 3 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                }
            }
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if (!txtUsuario.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtUsuario.getText());
            if (aprobado != false) {
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
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void tablaVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVendedoresMouseClicked
        int fila = tablaVendedores.getSelectedRow();
        if (fila >= 0) {
            btnDeshabilitar.setEnabled(true);
            String estado = tablaVendedores.getValueAt(fila, 11).toString();

            if ("3".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("DESHABILITAR");
            } else if ("0".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoHabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("HABILITAR");
            }
        }
    }//GEN-LAST:event_tablaVendedoresMouseClicked

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtCelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtCelularFocusGained

    private void txtSueldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSueldoFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtSueldoFocusGained

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtClaveFocusGained

    private void cbTipoDocuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoDocuFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbTipoDocuFocusGained

    private void txtNumDocuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumDocuFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtNumDocuFocusGained

    private void cbJornadaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbJornadaFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbJornadaFocusGained

    private void txtSueldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSueldoFocusLost
        if (!txtSueldo.getText().isEmpty()) {
            if (!sueldo(txtSueldo.getText())) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Para el sueldo cumplir con estos requisitos:\n•Debe contener 4 o 5 dígitos\n•Si es un número decimal debe poner 2 digitos después del punto", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtSueldoFocusLost

    private void txtClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusLost
        if (!txtClave.getText().isEmpty()) {
            if (txtClave.getText().length() < 6) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "La clave debe contener 6 o mas caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_txtClaveFocusLost

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        if (!txtDireccion.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtDireccion.getText());
            if (aprobado != false) {
                if (txtDireccion.getText().length() < 6) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "La dirección debe contener al menos 6 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                }
            }
        }
    }//GEN-LAST:event_txtDireccionFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizar;
    private rojerusan.RSButtonHover btnDeshabilitar;
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
