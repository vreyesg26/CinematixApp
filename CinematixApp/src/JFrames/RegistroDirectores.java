/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import Paneles.panelInicio;
import Paneles.panelVendedores;
import Tipografia.Fuente;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Los Pibes
 */
public class RegistroDirectores extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAdministradores
     */
    Fuente tipoFuente;

    public RegistroDirectores() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        cargarData();
        anchoColumnas();
        bloquear();

        txtIDDirector.setEnabled(false);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        return retValue;
    }

    void inicio() {
        TextPrompt idDirector = new TextPrompt("ID", txtIDDirector);
        TextPrompt director = new TextPrompt("DIRECTOR", txtDirector);
        idDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        director.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));

        txtIDDirector.setEnabled(false);
        txtIDDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        txtDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        tablaDirectores.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        modificarDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));

        btnGuardar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnNuevo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnActualizar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnDeshabilitar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
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
        modificarDirector = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDirectores = new javax.swing.JTable();
        btnNuevo = new rojeru_san.complementos.RSButtonHover();
        btnGuardar = new rojeru_san.complementos.RSButtonHover();
        btnActualizar = new rojeru_san.complementos.RSButtonHover();
        btnDeshabilitar = new rojeru_san.complementos.RSButtonHover();
        txtIDDirector = new javax.swing.JTextField();
        txtDirector = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();

        modificarDirector.setText("Modificar");
        modificarDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarDirectorActionPerformed(evt);
            }
        });
        jPopupMenu1.add(modificarDirector);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaDirectores.setBackground(new java.awt.Color(61, 61, 61));
        tablaDirectores.setForeground(new java.awt.Color(255, 255, 255));
        tablaDirectores.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDirectores.setToolTipText("");
        tablaDirectores.setComponentPopupMenu(jPopupMenu1);
        tablaDirectores.setFillsViewportHeight(true);
        tablaDirectores.setOpaque(false);
        tablaDirectores.setRowHeight(25);
        tablaDirectores.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaDirectores.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaDirectores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDirectoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDirectores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 89, 430, 340));

        btnNuevo.setBackground(new java.awt.Color(81, 81, 81));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoNuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setColorHover(new java.awt.Color(61, 61, 61));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNuevo.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(81, 81, 81));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoGuardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setColorHover(new java.awt.Color(61, 61, 61));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnGuardar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 330, 130, 40));

        btnActualizar.setBackground(new java.awt.Color(81, 81, 81));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoActualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setColorHover(new java.awt.Color(61, 61, 61));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnActualizar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 130, 40));

        btnDeshabilitar.setBackground(new java.awt.Color(81, 81, 81));
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoDeshabilitar.png"))); // NOI18N
        btnDeshabilitar.setText("DESHABILITAR");
        btnDeshabilitar.setBorderPainted(false);
        btnDeshabilitar.setColorHover(new java.awt.Color(61, 61, 61));
        btnDeshabilitar.setFocusPainted(false);
        btnDeshabilitar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnDeshabilitar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 390, 130, 40));

        txtIDDirector.setForeground(new java.awt.Color(255, 255, 255));
        txtIDDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDDirector.setOpaque(false);
        getContentPane().add(txtIDDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 50, 40));

        txtDirector.setForeground(new java.awt.Color(255, 255, 255));
        txtDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDirector.setOpaque(false);
        txtDirector.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDirectorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirectorFocusLost(evt);
            }
        });
        getContentPane().add(txtDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 220, 220, 40));

        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroDirectores.png"))); // NOI18N
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
        if (txtDirector.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo usuario", "Error", JOptionPane.PLAIN_MESSAGE, jPaneIcon);
        } else {
            guardar = true;
        }
    }

    void cargarData() {
        String[] titulos = {"ID", "Director", "Estado"};
        String[] registros = new String[3];
        String sql = "SELECT IDDirector, Nombre, Estado FROM director INNER JOIN estados USING (IDEstado) WHERE IDDirector != 0 ORDER BY IDDirector";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IDDirector");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Estado");
                model.addRow(registros);
            }

            tablaDirectores.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablaDirectores.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(30);
        anchoColumnas.getColumn(1).setPreferredWidth(200);
        anchoColumnas.getColumn(2).setPreferredWidth(120);
    }

    void limpiarCajas() {
        txtIDDirector.setText("");
        txtDirector.setText("");
    }

    void bloquear() {
        txtDirector.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        tablaDirectores.setEnabled(false);
    }

    void desbloquear() {
        txtDirector.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnDeshabilitar.setEnabled(true);
        tablaDirectores.setEnabled(true);
    }

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        if (!txtIDDirector.getText().isEmpty() || !txtDirector.getText().isEmpty()) {
            ImageIcon jPaneIcon = new ImageIcon("src/Iconos/iconoSalida.png");
            int salidaConfirmacion = JOptionPane.showConfirmDialog(null, "Al parecer tienes un proceso pendiente\n ¿Estás seguro que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPaneIcon);
            if (salidaConfirmacion == 0) {
                this.dispose();
                panelInicio.pantallaDirectores = false;
            }
        } else {
            this.dispose();
            panelInicio.pantallaDirectores = false;
        }
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        verificarNombre();
        if (!guardar == false) {
            String sql = "INSERT INTO director (Nombre) VALUES (?)";

            try {
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtDirector.getText());

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
        if (guardar == false) {

        } else {
            String sql = "UPDATE director SET Nombre = ? WHERE IDDirector = '" + txtIDDirector.getText() + "'";

            try {
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtDirector.getText());

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/Iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro fue actualizado correctamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);

                    ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                    btnDeshabilitar.setIcon(iconobtn);
                    btnDeshabilitar.setText("DESHABILITAR");
                }

            } catch (Exception e) {
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
        int fila = tablaDirectores.getSelectedRow();
        String habilitado = "1";
        String deshabilitado = "2";

        if (fila >= 0) {
            String id = tablaDirectores.getValueAt(fila, 0).toString();
            String director = tablaDirectores.getValueAt(fila, 1).toString();

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
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas deshabilitar este director?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `director` SET `IDEstado` = ? WHERE `director`.`IDDirector` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, deshabilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El director " + director + " ha sido deshabilitado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                    } catch (Exception e) {

                    }
                }
            } else if (btnDeshabilitar.getText().equals("HABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas habilitar este director?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `director` SET `IDEstado` = ? WHERE `director`.`IDDirector` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, habilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "El director " + director + " ahora está habilitado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
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

    void verificarNombre() {
        if (!txtDirector.getText().isEmpty()) {
            Conexion cc = new Conexion();
            Connection cn = cc.GetConexion();
            String director = txtDirector.getText();
            String sql = "SELECT Nombre FROM director WHERE Nombre = '" + director + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    if (rs.getString("Nombre").equals(txtDirector.getText())) {
                        ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Este director ya existe, intenta con otro", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                        ImageIcon x = new ImageIcon("src/iconos/iconoX.png");
                        guardar = false;
                    }
                } else {
                    guardar = true;
                }
            } catch (Exception e) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }

    private void txtDirectorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirectorFocusLost
        //verificarNombre();
    }//GEN-LAST:event_txtDirectorFocusLost

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquear();
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtDirectorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirectorFocusGained
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtDirectorFocusGained

    void modificarRegistro() {
        int fila = tablaDirectores.getSelectedRow();

        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");

        if (fila >= 0) {
            btnActualizar.setEnabled(true);
            btnDeshabilitar.setEnabled(true);
            btnNuevo.setEnabled(false);
            txtDirector.setEnabled(true);
            btnGuardar.setEnabled(false);

            String id = tablaDirectores.getValueAt(fila, 0).toString();
            String usuario = tablaDirectores.getValueAt(fila, 1).toString();

            txtIDDirector.setText(id);
            txtDirector.setText(usuario);

        } else {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }

    private void modificarDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarDirectorActionPerformed
        if (!txtDirector.getText().isEmpty()) {
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
    }//GEN-LAST:event_modificarDirectorActionPerformed

    private void tablaDirectoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDirectoresMouseClicked
        int fila = tablaDirectores.getSelectedRow();
        if (fila >= 0) {
            btnDeshabilitar.setEnabled(true);
            String estado = tablaDirectores.getValueAt(fila, 2).toString();

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
    }//GEN-LAST:event_tablaDirectoresMouseClicked

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
            java.util.logging.Logger.getLogger(RegistroDirectores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroDirectores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroDirectores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDirectores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroDirectores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btnActualizar;
    private rojeru_san.complementos.RSButtonHover btnDeshabilitar;
    private rojeru_san.complementos.RSButtonHover btnGuardar;
    private rojeru_san.complementos.RSButtonHover btnNuevo;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JMenuItem modificarDirector;
    private javax.swing.JTable tablaDirectores;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtIDDirector;
    // End of variables declaration//GEN-END:variables
}
