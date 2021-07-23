/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import static JFrames.LoginAdmin.txtusuario;
import Paneles.panelInicio;
import Paneles.panelVendedores;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Los Pibes
 */
public class RegistroHorarios extends javax.swing.JFrame {
    log lo = new log();
    final Calendar calendar = Calendar.getInstance();
    final java.util.Date date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);

    /**
     * Creates new form RegistroAdministradores
     */
    public RegistroHorarios() {
        initComponents();
        if ("adminlectura".equals(txtusuario.getText())) {
            btnNuevo.setEnabled(false);
            tablaHorarios.setEnabled(false);
        }
        setBackground(new Color(0, 0, 0, 0));
        anchoColumnas();
        cargarData();
        bloquear();

        txtIDHorario.setEnabled(false);
        TextPrompt idHora = new TextPrompt("ID", txtIDHorario);
        TextPrompt hora = new TextPrompt("HORARIO", txtHorarios);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        modificarHorarios = new javax.swing.JMenuItem();
        btnRegresar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHorarios = new javax.swing.JTable();
        txtIDHorario = new javax.swing.JTextField();
        txtHorarios = new javax.swing.JTextField();
        btnNuevo = new rojerusan.RSButtonHover();
        btnGuardar = new rojerusan.RSButtonHover();
        btnActualizar = new rojerusan.RSButtonHover();
        btnDeshabilitar = new rojerusan.RSButtonHover();
        btnReporte2 = new rojerusan.RSButtonHover();
        lbFondo = new javax.swing.JLabel();

        modificarHorarios.setText("Modificar");
        modificarHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarHorariosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificarHorarios);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        tablaHorarios.setBackground(new java.awt.Color(61, 61, 61));
        tablaHorarios.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        tablaHorarios.setForeground(new java.awt.Color(255, 255, 255));
        tablaHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaHorarios.setComponentPopupMenu(jPopupMenu1);
        tablaHorarios.setOpaque(false);
        tablaHorarios.setRowHeight(25);
        tablaHorarios.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaHorarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHorariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaHorarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 430, 340));

        txtIDHorario.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        txtIDHorario.setForeground(new java.awt.Color(255, 255, 255));
        txtIDHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDHorario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtIDHorario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtIDHorario.setOpaque(false);
        txtIDHorario.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtIDHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 50, 40));

        txtHorarios.setFont(new java.awt.Font("Garamond", 1, 16)); // NOI18N
        txtHorarios.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHorarios.setCaretColor(new java.awt.Color(255, 255, 255));
        txtHorarios.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtHorarios.setOpaque(false);
        txtHorarios.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtHorarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHorariosFocusGained(evt);
            }
        });
        getContentPane().add(txtHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 220, 220, 40));

        btnNuevo.setBackground(new java.awt.Color(81, 81, 81));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoNuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setColorHover(new java.awt.Color(61, 61, 61));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Garamond", 0, 11)); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 330, 140, 40));

        btnGuardar.setBackground(new java.awt.Color(81, 81, 81));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoGuardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setColorHover(new java.awt.Color(61, 61, 61));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Garamond", 0, 11)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 140, 40));

        btnActualizar.setBackground(new java.awt.Color(81, 81, 81));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoActualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setColorHover(new java.awt.Color(61, 61, 61));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFont(new java.awt.Font("Garamond", 0, 11)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 390, 140, 40));

        btnDeshabilitar.setBackground(new java.awt.Color(81, 81, 81));
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoDeshabilitar.png"))); // NOI18N
        btnDeshabilitar.setText("DESHABILITAR");
        btnDeshabilitar.setBorderPainted(false);
        btnDeshabilitar.setColorHover(new java.awt.Color(61, 61, 61));
        btnDeshabilitar.setFocusPainted(false);
        btnDeshabilitar.setFont(new java.awt.Font("Garamond", 0, 11)); // NOI18N
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 140, 40));

        btnReporte2.setBackground(new java.awt.Color(81, 81, 81));
        btnReporte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoReporte.png"))); // NOI18N
        btnReporte2.setBorderPainted(false);
        btnReporte2.setColorHover(new java.awt.Color(61, 61, 61));
        btnReporte2.setFocusable(false);
        btnReporte2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 40, 35));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroHorarios.png"))); // NOI18N
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
              
            }
        }
    }//GEN-LAST:event_formWindowOpened

    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    boolean guardar;

    void validarCamposVacios() {
        ImageIcon jPaneIcon = new ImageIcon("src/Iconos/iconoError.png");
        if (txtHorarios.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo horario", "Error", JOptionPane.PLAIN_MESSAGE, jPaneIcon);
        } else {
            guardar = true;
        }
    }

    void cargarData() {
        String[] titulos = {"ID", "Horario", "Estado"};
        String[] registros = new String[3];
        String sql = "SELECT IDHorario, Hora, Estado FROM horarios INNER JOIN estados USING (IDEstado) WHERE IDHorario != 0 ORDER BY IDHorario";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IDHorario");
                registros[1] = rs.getString("Hora");
                registros[2] = rs.getString("Estado");
                model.addRow(registros);
            }

            tablaHorarios.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablaHorarios.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(30);
        anchoColumnas.getColumn(1).setPreferredWidth(200);
        anchoColumnas.getColumn(2).setPreferredWidth(120);
    }

    void limpiarCajas() {
        txtIDHorario.setText("");
        txtHorarios.setText("");
        tablaHorarios.clearSelection();
    }

    void bloquear() {
        txtHorarios.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        tablaHorarios.setEnabled(false);
    }

    void desbloquear() {
        txtHorarios.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnDeshabilitar.setEnabled(true);
        tablaHorarios.setEnabled(true);
    }

    public boolean verificarFormatoHora(String hora) {
        String patron = "^(?:0?[1-9]|1[0-2]):[0-5][0-9]\\s?[ap][m]$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(hora);
        if (!comparador.matches()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Asegurate de escribir el horario de forma correcta\nFormato: 12 horas", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            guardar = false;
        } else {
            guardar = true;
        }
        return guardar;
    }

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        if (!txtIDHorario.getText().isEmpty() || !txtHorarios.getText().isEmpty()) {
            ImageIcon jPaneIcon = new ImageIcon("src/Iconos/iconoSalida.png");
            int salidaConfirmacion = JOptionPane.showConfirmDialog(null, "Al parecer tienes un proceso pendiente\n ¿Estás seguro que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPaneIcon);
            if (salidaConfirmacion == 0) {
                this.dispose();
                panelInicio.pantallaHorarios = false;
            }
        } else {
            this.dispose();
            panelInicio.pantallaHorarios = false;
        }
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void tablaHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHorariosMouseClicked
        int fila = tablaHorarios.getSelectedRow();
        if (fila >= 0) {
            btnDeshabilitar.setEnabled(true);
            String estado = tablaHorarios.getValueAt(fila, 2).toString();

            if ("Habilitado".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("DESHABILITAR");
            } else if ("Deshabilitado".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoHabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("HABILITAR");
            }
        }
    }//GEN-LAST:event_tablaHorariosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquear();
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    public boolean verificarHorario() {
        if (!txtHorarios.getText().isEmpty()) {
            Conexion cc = new Conexion();
            Connection cn = cc.GetConexion();
            String hora = txtHorarios.getText();
            String sql = "SELECT Hora FROM horarios WHERE Hora = '" + hora + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("Hora").equals(txtHorarios.getText())) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este horario ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                        ImageIcon x = new ImageIcon("src/iconos/iconoX.png");
                        guardar = false;
                    }
                } else {
                    guardar = true;
                }
            } catch (Exception e) {
                lo.LogBitacora("No se pudo verificar " + e);
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
        return guardar;
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        verificarHorario();
        verificarFormatoHora(txtHorarios.getText());
        if (!guardar == false) {
            String sql = "INSERT INTO horarios (Hora) VALUES (?)";

            try {
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtHorarios.getText());

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    cargarData();
                    bloquear();
                    limpiarCajas();
                    btnNuevo.setEnabled(true);
                }

            } catch (Exception e) {
                lo.LogBitacora("No se pudo guardar " + e);
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar guardar", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        verificarHorario();
        verificarFormatoHora(txtHorarios.getText());
        if (!guardar == false) {
            String sql = "UPDATE horarios SET Hora = ? WHERE IDHorario = '" + txtIDHorario.getText() + "'";

            try {
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtHorarios.getText());

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/Iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro fue actualizado correctamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);

                    ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                    btnDeshabilitar.setIcon(iconobtn);
                    btnDeshabilitar.setText("DESHABILITAR");
                }

            } catch (Exception e) {
                lo.LogBitacora("No se pudo actualizar " + e);
                ImageIcon jPanelIcono = new ImageIcon("src/Iconos/iconoCorrecto.png");
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                System.out.println(e.getMessage());
            }
        }
        cargarData();
        bloquear();
        limpiarCajas();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        int fila = tablaHorarios.getSelectedRow();
        String habilitado = "1";
        String deshabilitado = "2";

        if (fila >= 0) {
            String id = tablaHorarios.getValueAt(fila, 0).toString();
            String genero = tablaHorarios.getValueAt(fila, 1).toString();

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
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas deshabilitar este horario?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `horarios` SET `IDEstado` = ? WHERE `horarios`.`IDHorario` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, deshabilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El horario de las " + genero + " ha sido deshabilitado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                    } catch (Exception e) {
                       lo.LogBitacora("No se pudo deshabilitar el horario " + e);
                    }
                }
            } else if (btnDeshabilitar.getText().equals("HABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas habilitar este horario?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `horarios` SET `IDEstado` = ? WHERE `horarios`.`IDHorario` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, habilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El horario de las " + genero + " ahora está habilitado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                    } catch (Exception e) {
                         lo.LogBitacora("No se pudo habilitar el horario " + e);
                    }
                }
            }
        }
        cargarData();
        bloquear();
        limpiarCajas();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

    private void txtHorariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHorariosFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtHorariosFocusGained

    public int fila;

    void modificarRegistro() {
        if ("adminlectura".equals(txtusuario.getText())) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta accion", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
        fila = tablaHorarios.getSelectedRow();

        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");

        if (fila >= 0) {
            btnActualizar.setEnabled(true);
            btnDeshabilitar.setEnabled(true);
            btnNuevo.setEnabled(false);
            txtHorarios.setEnabled(true);
            btnGuardar.setEnabled(false);

            String id = tablaHorarios.getValueAt(fila, 0).toString();
            String horario = tablaHorarios.getValueAt(fila, 1).toString();

            txtIDHorario.setText(id);
            txtHorarios.setText(horario);

        } else {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }

    private void modificarHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarHorariosActionPerformed
        if (!txtHorarios.getText().isEmpty()) {
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
    }//GEN-LAST:event_modificarHorariosActionPerformed

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte2ActionPerformed
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.GetConexion();

            JasperReport reporte = null;
            String path = "src\\Reportes\\reporteHorarios.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporte2ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizar;
    private rojerusan.RSButtonHover btnDeshabilitar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JLabel btnRegresar;
    private rojerusan.RSButtonHover btnReporte2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JMenuItem modificarHorarios;
    private javax.swing.JTable tablaHorarios;
    public javax.swing.JTextField txtHorarios;
    private javax.swing.JTextField txtIDHorario;
    // End of variables declaration//GEN-END:variables
}
