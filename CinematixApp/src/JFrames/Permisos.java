/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import static JFrames.LoginAdmin.txtusuario;
import static JFrames.MenuVendedor.lb10;
import static JFrames.MenuVendedor.lb9;
import  Paneles.panelInicio;
import Paneles.panelVendedores;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jeymerd Canales
 */
public class Permisos extends javax.swing.JFrame {

    /**
     * Creates new form Permisos
     */
    public Permisos() {
        initComponents();
        setLocationRelativeTo(null);
        //setBackground(new Color(0, 0, 0, 0));
        cargarData();
        anchoColumnas();

        txtusuario.setVisible(true);
        txtID.setVisible(true);
        TextPrompt ID = new TextPrompt("ID", txtID);
        TextPrompt usuario = new TextPrompt("USUARIO", txtusuario);
        txtID.setEnabled(false);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        return retValue;
    }

    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void cargarData() {
        String[] titulos = {"ID", "Usuario", "Contraseña", "Intentos"};
        String[] registros = new String[4];
        String sql = "SELECT IDUsuario, Usuario, Contrasena, Intentos FROM usuarios WHERE IDUsuario != 0 ORDER BY IDUsuario";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IDUsuario");
                registros[1] = rs.getString("Usuario");
                registros[2] = rs.getString("Contrasena");
                registros[3] = rs.getString("Intentos");
                model.addRow(registros);
            }

            tablausuarios.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablausuarios.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(30);
        anchoColumnas.getColumn(1).setPreferredWidth(120);
        anchoColumnas.getColumn(2).setPreferredWidth(160);
        anchoColumnas.getColumn(3).setPreferredWidth(40);
    }

    public String usuario;
    public int fila;

    void modificarRegistro() {
        fila = tablausuarios.getSelectedRow();

        if (fila >= 0) {
            txtusuario.setEnabled(true);

            String id = tablausuarios.getValueAt(fila, 0).toString();
            usuario = tablausuarios.getValueAt(fila, 1).toString();

            txtID.setText(id);
            txtusuario.setText(usuario);

        } else {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }

    void bloquear() {
        txtusuario.setEnabled(true);
        txtID.setEnabled(true);
        tablausuarios.setEnabled(true);
    }

    void desbloquear() {
        txtusuario.setEnabled(true);
        txtID.setEnabled(true);
        tablausuarios.setEnabled(true);
    }

    void ActivarUsuarios() {
        
}
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pn_inicio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_Activo_Usuario = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_Activo_Genero = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btn_Activo_Directores = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_Activo_Horarios = new javax.swing.JButton();
        btn_Activo_Actores = new javax.swing.JButton();
        btn_Activo_Clientes = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_Activo_Salas = new javax.swing.JButton();
        btn_Inactivo_Usuario = new javax.swing.JButton();
        btn_Inactivo_Genero = new javax.swing.JButton();
        btn_Inactivo_Directores = new javax.swing.JButton();
        btn_Inactivo_Horarios = new javax.swing.JButton();
        btn_Inactivo_Actores = new javax.swing.JButton();
        btn_Inactivo_Clientes = new javax.swing.JButton();
        btn_Inactivo_Salas = new javax.swing.JButton();
        pn_peliculas = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_Activo_Agregar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btn_Activo_Eliminar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btn_Activo_Actualizar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btn_Activo_Des_y_Habi = new javax.swing.JButton();
        btn_Inactivo_Agregar = new javax.swing.JButton();
        btn_Inactivo_Eliminar = new javax.swing.JButton();
        btn_Inactivo_Actualizar = new javax.swing.JButton();
        btn_Inactivo_Des_y_Habi = new javax.swing.JButton();
        pn_vendedores = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_Activo_Agregar_Vend = new javax.swing.JButton();
        btn_Activo_Eliminar_Vend = new javax.swing.JButton();
        btn_Activo_Actualizar_Vend = new javax.swing.JButton();
        btn_Activo_Des_y_Habi_Vend = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        btn_Inactivo_Agregar_Vend = new javax.swing.JButton();
        btn_Inactivo_Eliminar_Vend = new javax.swing.JButton();
        btn_Inactivo_Actualizar_Vend = new javax.swing.JButton();
        btn_Inactivo_Des_y_Habi_Vend = new javax.swing.JButton();
        pn_historial = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btn_Activo_Reporte = new javax.swing.JButton();
        btn_Inactivo_Reporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuarios = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SEGURIDAD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel3)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INFORMACIÓN DEL USUARIO");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre de Usuario: ");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID Usuario:");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Asignar permisos para pantalla de inicio");

        btn_Activo_Usuario.setText("Activo");
        btn_Activo_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Activo_UsuarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Administrar Usuarios");

        jLabel7.setText("Administrar Generos");

        btn_Activo_Genero.setText("Activo");

        jLabel8.setText("Administrar Directores");

        btn_Activo_Directores.setText("Activo");

        jLabel9.setText("Administrar Horarios");

        jLabel10.setText("Administrar Actores");

        jLabel11.setText("Administrar Clientes");

        btn_Activo_Horarios.setText("Activo");

        btn_Activo_Actores.setText("Activo");

        btn_Activo_Clientes.setText("Activo");

        jLabel12.setText("Control y administración de salas");

        btn_Activo_Salas.setText("Activo");

        btn_Inactivo_Usuario.setText("Inactivo");

        btn_Inactivo_Genero.setText("Inactivo");

        btn_Inactivo_Directores.setText("Inactivo");

        btn_Inactivo_Horarios.setText("Inactivo");

        btn_Inactivo_Actores.setText("Inactivo");

        btn_Inactivo_Clientes.setText("Inactivo");

        btn_Inactivo_Salas.setText("Inactivo");

        javax.swing.GroupLayout pn_inicioLayout = new javax.swing.GroupLayout(pn_inicio);
        pn_inicio.setLayout(pn_inicioLayout);
        pn_inicioLayout.setHorizontalGroup(
            pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_inicioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Inactivo_Usuario)
                            .addComponent(btn_Activo_Usuario)))
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Inactivo_Horarios)
                            .addComponent(btn_Activo_Horarios))))
                .addGap(109, 109, 109)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Activo_Genero)
                            .addComponent(btn_Activo_Actores)
                            .addComponent(btn_Inactivo_Genero)
                            .addComponent(btn_Inactivo_Actores))))
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(pn_inicioLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_Inactivo_Directores)
                                        .addComponent(btn_Activo_Directores)))))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_inicioLayout.createSequentialGroup()
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Inactivo_Clientes)
                            .addComponent(btn_Activo_Clientes))
                        .addGap(49, 49, 49))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_inicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(pn_inicioLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addComponent(btn_Activo_Salas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Inactivo_Salas))
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_inicioLayout.setVerticalGroup(
            pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Activo_Usuario)
                    .addComponent(btn_Activo_Genero)
                    .addComponent(btn_Activo_Directores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_inicioLayout.createSequentialGroup()
                        .addComponent(btn_Inactivo_Usuario)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_inicioLayout.createSequentialGroup()
                        .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Inactivo_Genero)
                            .addComponent(btn_Inactivo_Directores))
                        .addGap(18, 18, 18)))
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Activo_Horarios)
                    .addComponent(btn_Activo_Actores)
                    .addComponent(btn_Activo_Clientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Inactivo_Horarios)
                    .addComponent(btn_Inactivo_Actores)
                    .addComponent(btn_Inactivo_Clientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Activo_Salas)
                    .addComponent(btn_Inactivo_Salas))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Inicio", pn_inicio);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel13.setText("Asignar permisos para pantalla de Peliculas");

        jLabel14.setText("Agregar ");

        btn_Activo_Agregar.setText("Activo");

        jLabel15.setText("Eliminar");

        btn_Activo_Eliminar.setText("Activo");

        jLabel16.setText("Actualizar");

        btn_Activo_Actualizar.setText("Activo");

        jLabel17.setText("Habilitar y Deshabilitar");

        btn_Activo_Des_y_Habi.setText("Activo");
        btn_Activo_Des_y_Habi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Activo_Des_y_HabiActionPerformed(evt);
            }
        });

        btn_Inactivo_Agregar.setText("Inactivo");

        btn_Inactivo_Eliminar.setText("Inactivo");

        btn_Inactivo_Actualizar.setText("Inactivo");

        btn_Inactivo_Des_y_Habi.setText("Inactivo");

        javax.swing.GroupLayout pn_peliculasLayout = new javax.swing.GroupLayout(pn_peliculas);
        pn_peliculas.setLayout(pn_peliculasLayout);
        pn_peliculasLayout.setHorizontalGroup(
            pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_peliculasLayout.createSequentialGroup()
                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_peliculasLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel14)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel15))
                    .addGroup(pn_peliculasLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Activo_Agregar)
                            .addComponent(btn_Inactivo_Agregar))
                        .addGap(59, 59, 59)
                        .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Inactivo_Eliminar)
                            .addComponent(btn_Activo_Eliminar))))
                .addGap(55, 55, 55)
                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_peliculasLayout.createSequentialGroup()
                        .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Activo_Actualizar)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_peliculasLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(8, 8, 8)))
                        .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_peliculasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(32, 32, 32))
                            .addGroup(pn_peliculasLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Inactivo_Des_y_Habi)
                                    .addComponent(btn_Activo_Des_y_Habi))
                                .addContainerGap(45, Short.MAX_VALUE))))
                    .addGroup(pn_peliculasLayout.createSequentialGroup()
                        .addComponent(btn_Inactivo_Actualizar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_peliculasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(80, 80, 80))
        );
        pn_peliculasLayout.setVerticalGroup(
            pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_peliculasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(52, 52, 52)
                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Activo_Agregar)
                    .addComponent(btn_Activo_Eliminar)
                    .addComponent(btn_Activo_Actualizar)
                    .addComponent(btn_Activo_Des_y_Habi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_peliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Inactivo_Agregar)
                    .addComponent(btn_Inactivo_Eliminar)
                    .addComponent(btn_Inactivo_Actualizar)
                    .addComponent(btn_Inactivo_Des_y_Habi))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peliculas", pn_peliculas);

        jLabel18.setText("Agregar");

        jLabel19.setText("Eliminar");

        jLabel20.setText("Actualizar");

        jLabel21.setText("Habilitar o Deshabilitar");

        btn_Activo_Agregar_Vend.setText("Activo");

        btn_Activo_Eliminar_Vend.setText("Activo");

        btn_Activo_Actualizar_Vend.setText("Activo");

        btn_Activo_Des_y_Habi_Vend.setText("Activo");

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel22.setText("Asignar permisos para pantalla de Vendedores");

        btn_Inactivo_Agregar_Vend.setText("Inactivo");

        btn_Inactivo_Eliminar_Vend.setText("Inactivo");

        btn_Inactivo_Actualizar_Vend.setText("Inactivo");

        btn_Inactivo_Des_y_Habi_Vend.setText("Inactivo");

        javax.swing.GroupLayout pn_vendedoresLayout = new javax.swing.GroupLayout(pn_vendedores);
        pn_vendedores.setLayout(pn_vendedoresLayout);
        pn_vendedoresLayout.setHorizontalGroup(
            pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel22)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_vendedoresLayout.createSequentialGroup()
                        .addComponent(btn_Inactivo_Agregar_Vend)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_vendedoresLayout.createSequentialGroup()
                        .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Activo_Agregar_Vend)
                            .addComponent(jLabel18))
                        .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel19))
                            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btn_Activo_Eliminar_Vend))
                            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btn_Inactivo_Eliminar_Vend)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(btn_Activo_Actualizar_Vend))
                                .addGap(35, 35, 35)
                                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addGroup(pn_vendedoresLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_Inactivo_Des_y_Habi_Vend)
                                            .addComponent(btn_Activo_Des_y_Habi_Vend)))))
                            .addComponent(btn_Inactivo_Actualizar_Vend))
                        .addGap(77, 77, 77))))
        );
        pn_vendedoresLayout.setVerticalGroup(
            pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_vendedoresLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel22)
                .addGap(44, 44, 44)
                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Activo_Agregar_Vend)
                    .addComponent(btn_Activo_Eliminar_Vend)
                    .addComponent(btn_Activo_Actualizar_Vend)
                    .addComponent(btn_Activo_Des_y_Habi_Vend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_vendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Inactivo_Agregar_Vend)
                    .addComponent(btn_Inactivo_Eliminar_Vend)
                    .addComponent(btn_Inactivo_Actualizar_Vend)
                    .addComponent(btn_Inactivo_Des_y_Habi_Vend))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vendedores", pn_vendedores);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel23.setText("Asignar permisos para pantalla de Historial");

        jLabel24.setText("Generar Reporte");

        btn_Activo_Reporte.setText("Activo");

        btn_Inactivo_Reporte.setText("Inactivo");

        javax.swing.GroupLayout pn_historialLayout = new javax.swing.GroupLayout(pn_historial);
        pn_historial.setLayout(pn_historialLayout);
        pn_historialLayout.setHorizontalGroup(
            pn_historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_historialLayout.createSequentialGroup()
                .addGroup(pn_historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_historialLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel23))
                    .addGroup(pn_historialLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(pn_historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addGroup(pn_historialLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pn_historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Inactivo_Reporte)
                                    .addComponent(btn_Activo_Reporte))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pn_historialLayout.setVerticalGroup(
            pn_historialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_historialLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel23)
                .addGap(42, 42, 42)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Activo_Reporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Inactivo_Reporte)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Historial", pn_historial);

        tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablausuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuarios);

        txtID.setForeground(new java.awt.Color(0, 0, 0));

        txtusuario.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(244, 244, 244))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(93, 93, 93))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuariosMouseClicked
        // int seleccion = tablausuarios.rowAtPoint(evt.getPoint());
        int fila = tablausuarios.getSelectedRow();
        txtID.setText(String.valueOf(tablausuarios.getValueAt(fila, 0)));
        txtusuario.setText(String.valueOf(tablausuarios.getValueAt(fila, 1)));
    }//GEN-LAST:event_tablausuariosMouseClicked

    private void btn_Activo_Des_y_HabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Activo_Des_y_HabiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Activo_Des_y_HabiActionPerformed

    private void btn_Activo_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Activo_UsuarioActionPerformed
        
    }//GEN-LAST:event_btn_Activo_UsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Permisos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Permisos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Activo_Actores;
    private javax.swing.JButton btn_Activo_Actualizar;
    private javax.swing.JButton btn_Activo_Actualizar_Vend;
    private javax.swing.JButton btn_Activo_Agregar;
    private javax.swing.JButton btn_Activo_Agregar_Vend;
    private javax.swing.JButton btn_Activo_Clientes;
    private javax.swing.JButton btn_Activo_Des_y_Habi;
    private javax.swing.JButton btn_Activo_Des_y_Habi_Vend;
    private javax.swing.JButton btn_Activo_Directores;
    private javax.swing.JButton btn_Activo_Eliminar;
    private javax.swing.JButton btn_Activo_Eliminar_Vend;
    private javax.swing.JButton btn_Activo_Genero;
    private javax.swing.JButton btn_Activo_Horarios;
    private javax.swing.JButton btn_Activo_Reporte;
    private javax.swing.JButton btn_Activo_Salas;
    private javax.swing.JButton btn_Activo_Usuario;
    private javax.swing.JButton btn_Inactivo_Actores;
    private javax.swing.JButton btn_Inactivo_Actualizar;
    private javax.swing.JButton btn_Inactivo_Actualizar_Vend;
    private javax.swing.JButton btn_Inactivo_Agregar;
    private javax.swing.JButton btn_Inactivo_Agregar_Vend;
    private javax.swing.JButton btn_Inactivo_Clientes;
    private javax.swing.JButton btn_Inactivo_Des_y_Habi;
    private javax.swing.JButton btn_Inactivo_Des_y_Habi_Vend;
    private javax.swing.JButton btn_Inactivo_Directores;
    private javax.swing.JButton btn_Inactivo_Eliminar;
    private javax.swing.JButton btn_Inactivo_Eliminar_Vend;
    private javax.swing.JButton btn_Inactivo_Genero;
    private javax.swing.JButton btn_Inactivo_Horarios;
    private javax.swing.JButton btn_Inactivo_Reporte;
    private javax.swing.JButton btn_Inactivo_Salas;
    private javax.swing.JButton btn_Inactivo_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pn_historial;
    private javax.swing.JPanel pn_inicio;
    private javax.swing.JPanel pn_peliculas;
    private javax.swing.JPanel pn_vendedores;
    private javax.swing.JTable tablausuarios;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

}
