/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import Datos.Conexion;
import Tipografia.Fuente;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Los Pibes
 */
public class Sala2D extends javax.swing.JFrame {

    /**
     * Creates new form Sala2D
     */
    Fuente tipoFuente;
    log lo = new log();
    final Calendar calendar = Calendar.getInstance();
    final java.util.Date date = calendar.getTime();
    String fecha = new SimpleDateFormat("yyyyMMdd-hh.mm.ss").format(date);

    public Sala2D() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        botones();
        buscarAsientosReservados();

        tipoFuente = new Fuente();
        btnFinalizar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        return retValue;
    }

    int filas = 8;
    int columnas = 10;
    int largoBoton = 60;
    int AnchoBoton = 60;
    int ejex = 20;
    int ejey = 20;
    public static Connection Conexion;
    public static PreparedStatement sentenciapreparada;
    public static ResultSet resultado;

    public JToggleButton[][] JTBotones = new JToggleButton[filas][columnas];

    public void botones() {
        Font fuenteletra = new Font("Arial", Font.BOLD, 12);
        int contadorasientos = 1;
        JTBotones = new JToggleButton[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                JTBotones[i][j] = new JToggleButton();
                JTBotones[i][j].setBounds(ejex, ejey, largoBoton, AnchoBoton);

                AccionBotones accion = new AccionBotones();
                JTBotones[i][j].addActionListener(accion);

                jPanel1.add(JTBotones[i][j]);
                if (contadorasientos >= 1 && contadorasientos <= 10) {
                    JTBotones[i][j].setText("A" + contadorasientos);
                } else if (contadorasientos >= 11 && contadorasientos <= 20) {
                    JTBotones[i][j].setText("B" + contadorasientos);
                } else if (contadorasientos >= 21 && contadorasientos <= 30) {
                    JTBotones[i][j].setText("C" + contadorasientos);
                } else if (contadorasientos >= 31 && contadorasientos <= 40) {
                    JTBotones[i][j].setText("D" + contadorasientos);
                } else if (contadorasientos >= 41 && contadorasientos <= 50) {
                    JTBotones[i][j].setText("E" + contadorasientos);
                } else if (contadorasientos >= 51 && contadorasientos <= 60) {
                    JTBotones[i][j].setText("F" + contadorasientos);
                } else if (contadorasientos >= 61 && contadorasientos <= 70) {
                    JTBotones[i][j].setText("G" + contadorasientos);
                } else if (contadorasientos >= 71 && contadorasientos <= 80) {
                    JTBotones[i][j].setText("H" + contadorasientos);
                }
                JTBotones[i][j].setFont(fuenteletra);
                JTBotones[i][j].setBackground(new Color(50, 50, 50));
                JTBotones[i][j].setForeground(Color.WHITE);
                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento.png");
                JTBotones[i][j].setIcon(btnIcono);
                JTBotones[i][j].setVerticalTextPosition((int) CENTER_ALIGNMENT);
                JTBotones[i][j].setHorizontalTextPosition((int) CENTER_ALIGNMENT);
                JTBotones[i][j].setHorizontalAlignment((int) CENTER_ALIGNMENT);
                JTBotones[i][j].setFocusPainted(false);
                JTBotones[i][j].setBorderPainted(false);
                JTBotones[i][j].setContentAreaFilled(false);
                JTBotones[i][j].setOpaque(false);
                JTBotones[i][j].setCursor(new Cursor(HAND_CURSOR));

                contadorasientos++;
                ejex += 70;
            }
            ejex = 20;
            ejey += 70;
        }
    }

    public void reservaAsiento(int numeroasiento) {
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        try {
            String sqlRestar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlRestar);
            pst.setString(1, String.valueOf("2"));
            pst.setString(2, String.valueOf(numeroasiento));
            pst.setString(3, "1");
            boolean mensaje = pst.execute();

            if (mensaje == false) {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                JOptionPane.showMessageDialog(null, "Asiento Reservado", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            } else {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se completó la actualización del estado del asiento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            }

        } catch (Exception e) {
            lo.LogBitacora("No se pudo conectar " + e);
            JOptionPane.showMessageDialog(null, "Hubo un error con la conexión" + e);
        }
    }

    public void QuitarReservaAsiento(int numeroasiento) {
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        try {
            String sqlRestar = "UPDATE `asiento` SET `IDEstado` = ? WHERE `asiento`.`Numero` = ? AND `asiento`.`IDSalas` = ?";
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlRestar);
            pst.setString(1, String.valueOf("1"));
            pst.setString(2, String.valueOf(numeroasiento));
            pst.setString(3, "1");
            boolean mensaje = pst.execute();

            if (mensaje == false) {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                JOptionPane.showMessageDialog(null, "Se ha quitado la reservación del asiento", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);

            } else {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "No se completó la actualización del estado del asiento", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            }

        } catch (Exception e) {
            lo.LogBitacora("No se pudo conectar " + e);
            JOptionPane.showMessageDialog(null, "Hubo un error con la conexión" + e);
        }
    }

    int totalBoletos = Integer.parseInt(ConfirmarVenta.jTextFieldCantidadDeBoletosAdultos.getText()) + Integer.parseInt(ConfirmarVenta.jTextFieldCantidadDeBoletosNiños.getText());
    ArrayList cantidadBoletos = new ArrayList();

    public class AccionBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (ae.getSource().equals(JTBotones[i][j])) {
                        if (JTBotones[i][j].isSelected()) {
                            JTBotones[i][j].setBackground(new Color(36, 36, 36));
                            if (totalBoletos == cantidadBoletos.size()) {
                                if (totalBoletos != 1) {
                                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                                    JOptionPane.showMessageDialog(null, "Ya se completó la reservación de tus " + totalBoletos + " asientos", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                                    JTBotones[i][j].setSelected(false);
                                } else {
                                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                                    JOptionPane.showMessageDialog(null, "Ya se completó la reservación de tu asiento", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                                    JTBotones[i][j].setSelected(false);
                                }
                            } else if (JTBotones[i][j].getText().length() == 2) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento2.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                String numeroLetra = JTBotones[i][j].getText().charAt(1) + "";
                                int numero = Integer.parseInt(numeroLetra);
                                System.out.println(numero);
                                reservaAsiento(numero);
                                cantidadBoletos.add(JTBotones[i][j].getText());
                                System.out.println(cantidadBoletos);
                                System.out.println(cantidadBoletos.size());
                            } else if (JTBotones[i][j].getText().length() == 3) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento2.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                String numeroLetra = JTBotones[i][j].getText().charAt(1) + "" + JTBotones[i][j].getText().charAt(2);
                                int numero = Integer.parseInt(numeroLetra);
                                reservaAsiento(numero);
                                cantidadBoletos.add(JTBotones[i][j].getText());
                                System.out.println(cantidadBoletos);
                                System.out.println(cantidadBoletos.size());
                            }
                        } else {
                            JTBotones[i][j].setBackground(new Color(50, 50, 50));
                            if (JTBotones[i][j].getText().length() == 2) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                String numeroLetra = JTBotones[i][j].getText().charAt(1) + "";
                                int numero = Integer.parseInt(numeroLetra);
                                QuitarReservaAsiento(numero);
                                cantidadBoletos.remove(JTBotones[i][j].getText());
                                System.out.println(cantidadBoletos);
                            } else if (JTBotones[i][j].getText().length() == 3) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                String numeroLetra = JTBotones[i][j].getText().charAt(1) + "" + JTBotones[i][j].getText().charAt(2);
                                int numero = Integer.parseInt(numeroLetra);
                                QuitarReservaAsiento(numero);
                                cantidadBoletos.remove(JTBotones[i][j].getText());
                                System.out.println(cantidadBoletos);
                            }
                        }
                    }
                }
            }
        }
    }

    public void buscarAsientosReservados() {
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String sql = "SELECT Numero, IDEstado FROM asiento WHERE IDSalas = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String numero = rs.getString("Numero");
                String estado = rs.getString("IDEstado");

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        if (JTBotones[i][j].getText().length() == 2) {
                            String numeroLetra = JTBotones[i][j].getText().charAt(1) + "";
                            String numeroN = numeroLetra;
                            if (numero.equals(numeroN) && estado.equals("2")) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento2.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                JTBotones[i][j].setBackground(new Color(36, 36, 36));
                                JTBotones[i][j].setSelected(true);
                            }
                        } else if (JTBotones[i][j].getText().length() == 3) {
                            String numeroLetra = JTBotones[i][j].getText().charAt(1) + "" + JTBotones[i][j].getText().charAt(2);
                            String numeroN = numeroLetra;
                            if (numero.equals(numeroN) && estado.equals("2")) {
                                ImageIcon btnIcono = new ImageIcon("src/imagenes/btnAsiento2.png");
                                JTBotones[i][j].setIcon(btnIcono);
                                JTBotones[i][j].setBackground(new Color(36, 36, 36));
                                JTBotones[i][j].setSelected(true);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sala2D.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This metho d is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizar = new rojerusan.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFinalizar.setBackground(new java.awt.Color(81, 81, 81));
        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoFinalizar.png"))); // NOI18N
        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setColorHover(new java.awt.Color(61, 61, 61));
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.setFont(new java.awt.Font("Garamond", 0, 11)); // NOI18N
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 630, 160, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 570));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PantallaSala2D.png"))); // NOI18N
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

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
                 lo.LogBitacora("No se pudo abrir la ventana" + e);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (totalBoletos == cantidadBoletos.size()) {
            this.dispose();
            Factura ft = new Factura();
            ft.setVisible(true);
            String asientos = cantidadBoletos.toString();
            Factura.jLabelAsientos.setText(asientos.substring(1, asientos.length() - 1));
            cantidadBoletos.clear();
        } else if (totalBoletos != 1) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debes seleccionar los " + totalBoletos + " asientos", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debes seleccionar el asiento", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(Sala2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sala2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sala2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sala2D.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sala2D().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnFinalizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFondo;
    // End of variables declaration//GEN-END:variables
}
