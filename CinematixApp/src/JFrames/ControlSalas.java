/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import Tipografia.Fuente;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class ControlSalas extends javax.swing.JFrame {

    /**
     * Creates new form ControlSalas
     */
    Fuente tipoFuente;

    public ControlSalas() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        disponibles2D();
        reservados2D();
        disponibles3D();
        reservados3D();
        disponiblesMax2D();
        reservadosMax2D();
        disponiblesMax3D();
        reservadosMax3D();

        tipoFuente = new Fuente();
        lbDisponible2D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbReservado2D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbDisponible3D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbReservado3D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbDisponibleMax2D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbReservadoMax2D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbDisponibleMax3D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
        lbReservadoMax3D.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 22));
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

        lbDisponible2D = new javax.swing.JLabel();
        lbReservado2D = new javax.swing.JLabel();
        lbDisponible3D = new javax.swing.JLabel();
        lbReservado3D = new javax.swing.JLabel();
        lbDisponibleMax2D = new javax.swing.JLabel();
        lbReservadoMax3D = new javax.swing.JLabel();
        lbReservadoMax2D = new javax.swing.JLabel();
        lbDisponibleMax3D = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        btnVaciar2D = new javax.swing.JToggleButton();
        btnVaciar3D = new javax.swing.JToggleButton();
        btnVaciar2DMax = new javax.swing.JToggleButton();
        btnVaciar3DMax = new javax.swing.JToggleButton();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDisponible2D.setForeground(new java.awt.Color(255, 255, 255));
        lbDisponible2D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbDisponible2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 105, 50, 35));

        lbReservado2D.setForeground(new java.awt.Color(255, 255, 255));
        lbReservado2D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbReservado2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 155, 50, 35));

        lbDisponible3D.setForeground(new java.awt.Color(255, 255, 255));
        lbDisponible3D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbDisponible3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 105, 50, 35));

        lbReservado3D.setForeground(new java.awt.Color(255, 255, 255));
        lbReservado3D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbReservado3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 155, 50, 35));

        lbDisponibleMax2D.setForeground(new java.awt.Color(255, 255, 255));
        lbDisponibleMax2D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbDisponibleMax2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 50, 35));

        lbReservadoMax3D.setForeground(new java.awt.Color(255, 255, 255));
        lbReservadoMax3D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbReservadoMax3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 340, 50, 35));

        lbReservadoMax2D.setForeground(new java.awt.Color(255, 255, 255));
        lbReservadoMax2D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbReservadoMax2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 50, 35));

        lbDisponibleMax3D.setForeground(new java.awt.Color(255, 255, 255));
        lbDisponibleMax3D.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbDisponibleMax3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 290, 50, 35));

        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        btnVaciar2D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar.png"))); // NOI18N
        btnVaciar2D.setBorder(null);
        btnVaciar2D.setBorderPainted(false);
        btnVaciar2D.setContentAreaFilled(false);
        btnVaciar2D.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar2.png"))); // NOI18N
        btnVaciar2D.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciando.png"))); // NOI18N
        btnVaciar2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciar2DActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar2D, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 206, -1, -1));

        btnVaciar3D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar.png"))); // NOI18N
        btnVaciar3D.setBorder(null);
        btnVaciar3D.setBorderPainted(false);
        btnVaciar3D.setContentAreaFilled(false);
        btnVaciar3D.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar2.png"))); // NOI18N
        btnVaciar3D.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciando.png"))); // NOI18N
        btnVaciar3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciar3DActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar3D, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 206, -1, -1));

        btnVaciar2DMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar.png"))); // NOI18N
        btnVaciar2DMax.setBorder(null);
        btnVaciar2DMax.setBorderPainted(false);
        btnVaciar2DMax.setContentAreaFilled(false);
        btnVaciar2DMax.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar2.png"))); // NOI18N
        btnVaciar2DMax.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciando.png"))); // NOI18N
        btnVaciar2DMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciar2DMaxActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar2DMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 391, -1, -1));

        btnVaciar3DMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar.png"))); // NOI18N
        btnVaciar3DMax.setBorder(null);
        btnVaciar3DMax.setBorderPainted(false);
        btnVaciar3DMax.setContentAreaFilled(false);
        btnVaciar3DMax.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciar2.png"))); // NOI18N
        btnVaciar3DMax.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnVaciando.png"))); // NOI18N
        btnVaciar3DMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciar3DMaxActionPerformed(evt);
            }
        });
        getContentPane().add(btnVaciar3DMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 391, -1, -1));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/controlSalas.png"))); // NOI18N
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

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

    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void disponibles2D() {
        String sql = "SELECT COUNT(*) AS 'Disponibles' FROM asiento WHERE IDSalas = 1 AND IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String disponibles = rs.getString("Disponibles");
                lbDisponible2D.setText(disponibles);
            }

        } catch (Exception e) {

        }
    }

    void reservados2D() {
        String sql = "SELECT COUNT(*) AS 'Reservados' FROM asiento WHERE IDSalas = 1 AND IDEstado = 2";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String reservados = rs.getString("Reservados");
                lbReservado2D.setText(reservados);
            }

        } catch (Exception e) {

        }
    }

    void disponibles3D() {
        String sql = "SELECT COUNT(*) AS 'Disponibles' FROM asiento WHERE IDSalas = 2 AND IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String disponibles = rs.getString("Disponibles");
                lbDisponible3D.setText(disponibles);
            }

        } catch (Exception e) {

        }
    }

    void reservados3D() {
        String sql = "SELECT COUNT(*) AS 'Reservados' FROM asiento WHERE IDSalas = 2 AND IDEstado = 2";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String reservados = rs.getString("Reservados");
                lbReservado3D.setText(reservados);
            }

        } catch (Exception e) {

        }
    }

    void disponiblesMax2D() {
        String sql = "SELECT COUNT(*) AS 'Disponibles' FROM asiento WHERE IDSalas = 3 AND IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String disponibles = rs.getString("Disponibles");
                lbDisponibleMax2D.setText(disponibles);
            }

        } catch (Exception e) {

        }
    }

    void reservadosMax2D() {
        String sql = "SELECT COUNT(*) AS 'Reservados' FROM asiento WHERE IDSalas = 3 AND IDEstado = 2";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String reservados = rs.getString("Reservados");
                lbReservadoMax2D.setText(reservados);
            }

        } catch (Exception e) {

        }
    }

    void disponiblesMax3D() {
        String sql = "SELECT COUNT(*) AS 'Disponibles' FROM asiento WHERE IDSalas = 4 AND IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String disponibles = rs.getString("Disponibles");
                lbDisponibleMax3D.setText(disponibles);
            }

        } catch (Exception e) {

        }
    }

    void reservadosMax3D() {
        String sql = "SELECT COUNT(*) AS 'Reservados' FROM asiento WHERE IDSalas = 4 AND IDEstado = 2";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String reservados = rs.getString("Reservados");
                lbReservadoMax3D.setText(reservados);
            }

        } catch (Exception e) {

        }
    }

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        this.dispose();
        MenuVendedor.pantallaControlSalas = false;
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnVaciar2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciar2DActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "Estás a punto de vaciar la sala 2D\n¿Deseas continuar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        if (decision == 0) {
            int contador = 1;
            int asientos = 80;
            for (int i = 0; i < asientos; i++) {
                try {
                    String sqlVaciar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
                    PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlVaciar);
                    pst.setString(1, "1");
                    pst.setString(2, String.valueOf(contador));
                    pst.setString(3, "1");
                    pst.execute();

                } catch (Exception e) {

                }
                contador++;
            }
            disponibles2D();
            reservados2D();
            btnVaciar2D.setSelected(false);
            ImageIcon jPanelIcono2 = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "La sala fue vaciada, todos los asientos ahora están disponibles", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono2);
        } else {
            btnVaciar2D.setSelected(false);
        }
    }//GEN-LAST:event_btnVaciar2DActionPerformed

    private void btnVaciar3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciar3DActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "Estás a punto de vaciar la sala 3D\n¿Deseas continuar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        if (decision == 0) {
            int contador = 1;
            int asientos = 80;
            for (int i = 0; i < asientos; i++) {
                try {
                    String sqlVaciar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
                    PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlVaciar);
                    pst.setString(1, "1");
                    pst.setString(2, String.valueOf(contador));
                    pst.setString(3, "2");
                    pst.execute();

                } catch (Exception e) {

                }
                contador++;
            }
            disponibles3D();
            reservados3D();
            btnVaciar3D.setSelected(false);
            ImageIcon jPanelIcono2 = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "La sala fue vaciada, todos los asientos ahora están disponibles", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono2);
        } else {
            btnVaciar3D.setSelected(false);
        }
    }//GEN-LAST:event_btnVaciar3DActionPerformed

    private void btnVaciar2DMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciar2DMaxActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "Estás a punto de vaciar la sala Max2D\n¿Deseas continuar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        if (decision == 0) {
            int contador = 1;
            int asientos = 78;
            for (int i = 0; i < asientos; i++) {
                try {
                    String sqlVaciar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
                    PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlVaciar);
                    pst.setString(1, "1");
                    pst.setString(2, String.valueOf(contador));
                    pst.setString(3, "3");
                    pst.execute();

                } catch (Exception e) {

                }
                contador++;
            }
            disponiblesMax2D();
            reservadosMax2D();
            btnVaciar2DMax.setSelected(false);
            ImageIcon jPanelIcono2 = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "La sala fue vaciada, todos los asientos ahora están disponibles", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono2);
        } else {
            btnVaciar2DMax.setSelected(false);
        }
    }//GEN-LAST:event_btnVaciar2DMaxActionPerformed

    private void btnVaciar3DMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciar3DMaxActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "Estás a punto de vaciar la sala Max3D\n¿Deseas continuar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        if (decision == 0) {
            int contador = 1;
            int asientos = 78;
            for (int i = 0; i < asientos; i++) {
                try {
                    String sqlVaciar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
                    PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlVaciar);
                    pst.setString(1, "1");
                    pst.setString(2, String.valueOf(contador));
                    pst.setString(3, "4");
                    pst.execute();

                } catch (Exception e) {

                }
                contador++;
            }
            disponiblesMax3D();
            reservadosMax3D();
            btnVaciar3DMax.setSelected(false);
            ImageIcon jPanelIcono2 = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "La sala fue vaciada, todos los asientos ahora están disponibles", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono2);
        } else {
            btnVaciar3DMax.setSelected(false);
        }
    }//GEN-LAST:event_btnVaciar3DMaxActionPerformed

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
            java.util.logging.Logger.getLogger(ControlSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlSalas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnSalir;
    private javax.swing.JToggleButton btnVaciar2D;
    private javax.swing.JToggleButton btnVaciar2DMax;
    private javax.swing.JToggleButton btnVaciar3D;
    private javax.swing.JToggleButton btnVaciar3DMax;
    private javax.swing.JLabel lbDisponible2D;
    private javax.swing.JLabel lbDisponible3D;
    private javax.swing.JLabel lbDisponibleMax2D;
    private javax.swing.JLabel lbDisponibleMax3D;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JLabel lbReservado2D;
    private javax.swing.JLabel lbReservado3D;
    private javax.swing.JLabel lbReservadoMax2D;
    private javax.swing.JLabel lbReservadoMax3D;
    // End of variables declaration//GEN-END:variables
}
