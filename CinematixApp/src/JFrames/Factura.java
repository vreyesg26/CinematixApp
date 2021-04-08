/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class Factura extends javax.swing.JFrame {

    /**
     * Creates new form Factura
     */
    public Factura() {
        super.setUndecorated(true);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.setTitle("CineMatix * Factura");
        super.setLocationRelativeTo(this);
        fecha();
    }

    void fecha() {
        Date dia = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jLabelFecha.setText(sdf.format(dia));
        // jLabelFecha.setText(dia.getDay() + "/" +dia.getMonth() + "/"+(dia.getYear()+1900));
        //.setText("Fecha: " + (dia.getDay()+ 21) + "/" + (dia.getMonth() + 1) + "/" + (dia.getYear() + 1900));
        jLabelHora.setText("Hora: " + (dia.getHours()) + ":" + (dia.getMinutes()) + ":" + (dia.getSeconds()));
    }

    void limpiar() {
        ImageIcon i = new ImageIcon("");
        MenuVendedor.txtBoletosAdultos.setText("");
        MenuVendedor.buttonGroup1.clearSelection();
        MenuVendedor.jComboBoxHora.setSelectedIndex(0);
        MenuVendedor.jComboBoxPeliculas.setSelectedIndex(0);
        MenuVendedor.lbMenores.setText("");
        MenuVendedor.txtBoletosNiños.setVisible(true);
        MenuVendedor.txtBoletosNiños.setText("");

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

        jPanel1 = new javax.swing.JPanel();
        jLabelHora = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelPelicula = new javax.swing.JLabel();
        jLabelSala = new javax.swing.JLabel();
        jLabelTanda = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelNiños = new javax.swing.JLabel();
        jLabeNiñosTotal = new javax.swing.JLabel();
        jLabeAdultos = new javax.swing.JLabel();
        jLabeAdultosTotal = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabeTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelISV = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabeEfectivoRecibido = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabeCambio = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHora.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        jLabelFecha.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 110, 20));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pelicula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sala");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tanda");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabelPelicula.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPelicula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPelicula.setText("...");
        jPanel1.add(jLabelPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, -1));

        jLabelSala.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSala.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSala.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSala.setText("...");
        jPanel1.add(jLabelSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, -1));

        jLabelTanda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTanda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTanda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTanda.setText("...");
        jPanel1.add(jLabelTanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Boletos niños");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Boletos adultos");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabelNiños.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabelNiños.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNiños.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNiños.setText("...");
        jPanel1.add(jLabelNiños, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 240, 30, -1));

        jLabeNiñosTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeNiñosTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabeNiñosTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeNiñosTotal.setText("...");
        jPanel1.add(jLabeNiñosTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 90, -1));

        jLabeAdultos.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabeAdultos.setForeground(new java.awt.Color(255, 255, 255));
        jLabeAdultos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeAdultos.setText("...");
        jPanel1.add(jLabeAdultos, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 280, 30, -1));

        jLabeAdultosTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeAdultosTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabeAdultosTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeAdultosTotal.setText("...");
        jPanel1.add(jLabeAdultosTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 90, -1));

        jLabel12.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TOTAL");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabeTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabeTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeTotal.setText("...");
        jPanel1.add(jLabeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 80, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ISV / Impuestos incluido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabelISV.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelISV.setForeground(new java.awt.Color(255, 255, 255));
        jLabelISV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelISV.setText("...");
        jPanel1.add(jLabelISV, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 70, -1));

        jLabel13.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Efectivo recibido");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabeEfectivoRecibido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeEfectivoRecibido.setForeground(new java.awt.Color(255, 255, 255));
        jLabeEfectivoRecibido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeEfectivoRecibido.setText("...");
        jPanel1.add(jLabeEfectivoRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 130, -1));

        jLabel14.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cambio");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabeCambio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeCambio.setForeground(new java.awt.Color(255, 255, 255));
        jLabeCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeCambio.setText("...");
        jPanel1.add(jLabeCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 130, -1));

        jButton_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnImprimir.png"))); // NOI18N
        jButton_Imprimir.setBorderPainted(false);
        jButton_Imprimir.setContentAreaFilled(false);
        jButton_Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Imprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnImprimir2.png"))); // NOI18N
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 546, 35, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Factura.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 600));

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

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "¿Desea imprimir la factura de la venta?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        if (decision == 0) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Factura");

            job.setPrintable(new Printable() {
                public int print(Graphics pg, PageFormat pf, int pageNum) {

                    if (pageNum > 0) {
                        return Printable.NO_SUCH_PAGE;
                    }

                    Graphics2D g2 = (Graphics2D) pg;
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    g2.scale(1.0, 1.0);

                    jPanel1.paint(g2);
                    return Printable.PAGE_EXISTS;
                }
            });
            boolean ok = job.printDialog();
            if (ok) {
                try {
                    job.print();
                } catch (PrinterException ex) {

                }
            }

            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Factura Generada", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            limpiar();
            this.dispose();
        } else if (decision == 1){
            this.dispose();
            MenuVendedor mv = new MenuVendedor();
            mv.setVisible(true);
        }
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Imprimir;
    public static javax.swing.JLabel jLabeAdultos;
    public static javax.swing.JLabel jLabeAdultosTotal;
    public static javax.swing.JLabel jLabeCambio;
    public static javax.swing.JLabel jLabeEfectivoRecibido;
    public static javax.swing.JLabel jLabeNiñosTotal;
    public static javax.swing.JLabel jLabeTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelHora;
    public static javax.swing.JLabel jLabelISV;
    public static javax.swing.JLabel jLabelNiños;
    public static javax.swing.JLabel jLabelPelicula;
    public static javax.swing.JLabel jLabelSala;
    public static javax.swing.JLabel jLabelTanda;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
