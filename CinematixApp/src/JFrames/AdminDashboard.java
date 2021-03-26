/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Paneles.panelAcercaDe;
import Paneles.panelInicio;
import Paneles.panelPeliculas;
import Paneles.panelVendedores;
import Tipografia.Fuente;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import paneles.CambiaPanel;

/**
 *
 * @author Victor Reyes
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    Fuente tipoFuente;

    public AdminDashboard() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        new CambiaPanel(panelContenedor, new panelInicio());
        tipoFuente = new Fuente();

        btnAcerca.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        btnPeliculas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        btnSalir.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        btnVendedores.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        btnInicio.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
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

        btnInicio = new rojerusan.RSButtonMetro();
        btnPeliculas = new rojerusan.RSButtonMetro();
        btnVendedores = new rojerusan.RSButtonMetro();
        btnAcerca = new rojerusan.RSButtonMetro();
        btnSalir = new rojerusan.RSButtonMetro();
        panelContenedor = new javax.swing.JPanel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1050, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1050, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setBackground(new java.awt.Color(61, 61, 61));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoInicio.png"))); // NOI18N
        btnInicio.setText("   INICIO");
        btnInicio.setBorderPainted(false);
        btnInicio.setFocusPainted(false);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setSelected(true);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 248, 190, 26));

        btnPeliculas.setBackground(new java.awt.Color(61, 61, 61));
        btnPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoPelicula.png"))); // NOI18N
        btnPeliculas.setText("   PELICULAS");
        btnPeliculas.setBorderPainted(false);
        btnPeliculas.setFocusPainted(false);
        btnPeliculas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPeliculas.setSelected(true);
        btnPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeliculasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 309, 190, 26));

        btnVendedores.setBackground(new java.awt.Color(61, 61, 61));
        btnVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoVendedores.png"))); // NOI18N
        btnVendedores.setText("   VENDEDORES");
        btnVendedores.setBorderPainted(false);
        btnVendedores.setFocusPainted(false);
        btnVendedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVendedores.setSelected(true);
        btnVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnVendedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 369, 190, 26));

        btnAcerca.setBackground(new java.awt.Color(61, 61, 61));
        btnAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoAcerca.png"))); // NOI18N
        btnAcerca.setText("   ACERCA DE");
        btnAcerca.setBorderPainted(false);
        btnAcerca.setFocusPainted(false);
        btnAcerca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAcerca.setSelected(true);
        btnAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 429, 190, 26));

        btnSalir.setBackground(new java.awt.Color(61, 61, 61));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoSalir.png"))); // NOI18N
        btnSalir.setText("   SALIR");
        btnSalir.setBorderPainted(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setSelected(true);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 489, 190, 26));

        panelContenedor.setBackground(new java.awt.Color(61, 61, 61));
        panelContenedor.setForeground(new java.awt.Color(61, 61, 61));
        panelContenedor.setOpaque(false);
        panelContenedor.setLayout(new javax.swing.BoxLayout(panelContenedor, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 805, 690));

        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AdminDashboard1.png"))); // NOI18N
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Inicio ini = new Inicio();
        ini.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendedoresActionPerformed
        new CambiaPanel(panelContenedor, new panelVendedores());
    }//GEN-LAST:event_btnVendedoresActionPerformed

    private void btnPeliculas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeliculas1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ventanaConfirmacion == 0) {
            Inicio ini = new Inicio();
            ini.setVisible(true);
            this.dispose();
        } else {

        }

    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaActionPerformed
        new CambiaPanel(panelContenedor, new panelAcercaDe());
    }//GEN-LAST:event_btnAcercaActionPerformed

    private void btnPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculasActionPerformed
        new CambiaPanel(panelContenedor, new panelPeliculas());
    }//GEN-LAST:event_btnPeliculasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        new CambiaPanel(panelContenedor, new panelInicio());
    }//GEN-LAST:event_btnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private rojerusan.RSButtonMetro btnAcerca;
    private rojerusan.RSButtonMetro btnInicio;
    private rojerusan.RSButtonMetro btnPeliculas;
    private rojerusan.RSButtonMetro btnSalir;
    private rojerusan.RSButtonMetro btnVendedores;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
