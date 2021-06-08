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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class FacturaReporte extends javax.swing.JFrame {

    /**
     * Creates new form Factura
     */
    public FacturaReporte() {
        super.setUndecorated(true);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.setTitle("CineMatix * Factura");
        super.setLocationRelativeTo(this);
        recuperarInformacion();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabeTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton_Imprimir = new javax.swing.JButton();
        jLabelAsientos = new javax.swing.JLabel();
        jLabelVendedor = new javax.swing.JLabel();
        jLabelCAI = new javax.swing.JLabel();
        jLabelFechaEmision = new javax.swing.JLabel();
        jLabelNumeroFactura = new javax.swing.JLabel();
        jLabelNumCAI = new javax.swing.JLabel();
        jLabelF_Emision = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(370, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHora.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoHora.png"))); // NOI18N
        jPanel1.add(jLabelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 110, 20));

        jLabelFecha.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoFecha.png"))); // NOI18N
        jLabelFecha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 10, 110, 20));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pelicula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 245, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sala");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horario");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 315, -1, -1));

        jLabelPelicula.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPelicula.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPelicula.setText("...");
        jPanel1.add(jLabelPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 245, 200, -1));

        jLabelSala.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSala.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSala.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSala.setText("...");
        jPanel1.add(jLabelSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 280, 130, -1));

        jLabelTanda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTanda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTanda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTanda.setText("...");
        jPanel1.add(jLabelTanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 315, 130, -1));

        jLabel16.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Vendedor");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 105, -1, -1));

        jLabel15.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Asientos");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 385, -1, -1));

        jLabel12.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 350, -1, -1));

        jLabeTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabeTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabeTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabeTotal.setText("...");
        jPanel1.add(jLabeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 350, 100, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("N° de Factura");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 140, -1, -1));

        jLabel18.setFont(new java.awt.Font("Ubuntu Condensed", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cliente");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 420, -1, -1));

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
        jPanel1.add(jButton_Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 35, 35));

        jLabelAsientos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelAsientos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAsientos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAsientos.setText("...");
        jPanel1.add(jLabelAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 385, 240, -1));

        jLabelVendedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelVendedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVendedor.setText("...");
        jPanel1.add(jLabelVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 105, 150, -1));

        jLabelCAI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCAI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCAI.setText("CAI");
        jPanel1.add(jLabelCAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 175, -1, -1));

        jLabelFechaEmision.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelFechaEmision.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaEmision.setText("Fecha Limite Emisión");
        jPanel1.add(jLabelFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 210, -1, -1));

        jLabelNumeroFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelNumeroFactura.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumeroFactura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumeroFactura.setText("...");
        jPanel1.add(jLabelNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 140, 200, -1));

        jLabelNumCAI.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelNumCAI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumCAI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumCAI.setText("...");
        jPanel1.add(jLabelNumCAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 175, 250, -1));

        jLabelF_Emision.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelF_Emision.setForeground(new java.awt.Color(255, 255, 255));
        jLabelF_Emision.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelF_Emision.setText("...");
        jPanel1.add(jLabelF_Emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 210, 80, -1));

        jLabelCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCliente.setText("...");
        jPanel1.add(jLabelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 420, 200, -1));

        lbFondo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbFondo.setForeground(new java.awt.Color(255, 255, 255));
        lbFondo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FacturaHistorial.png"))); // NOI18N
        jPanel1.add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 700));

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

    void recuperarInformacion(){
        jLabelHora.setText(Paneles.panelHistorial.horaEmision);
        jLabelFecha.setText(Paneles.panelHistorial.fechaEmision);
        jLabelVendedor.setText(Paneles.panelHistorial.nombreVendedor);
        jLabelNumeroFactura.setText(Paneles.panelHistorial.numeroFactura);
        jLabelNumCAI.setText(Paneles.panelHistorial.cai);
        jLabelF_Emision.setText(Paneles.panelHistorial.fechaFinalCAI);
        jLabelPelicula.setText(Paneles.panelHistorial.pelicula);
        jLabelSala.setText(Paneles.panelHistorial.sala);
        jLabelTanda.setText(Paneles.panelHistorial.hora);
        jLabeTotal.setText("L."+Paneles.panelHistorial.total+"0");
        jLabelAsientos.setText(Paneles.panelHistorial.asientos);
        jLabelCliente.setText(Paneles.panelHistorial.nombreCliente);
    }
    
    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
        int decision = JOptionPane.showConfirmDialog(null, "¿Desea imprimir la factura?", "Imprimir", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
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
            JOptionPane.showMessageDialog(null, "Factura generada exitosamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            this.dispose();
        } else if (decision == 1) {
            Paneles.panelHistorial.facturaHistorial = false;
            this.dispose();
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
            java.util.logging.Logger.getLogger(FacturaReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Imprimir;
    public static javax.swing.JLabel jLabeTotal;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelAsientos;
    private javax.swing.JLabel jLabelCAI;
    public static javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelF_Emision;
    public static javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaEmision;
    public static javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNumCAI;
    private javax.swing.JLabel jLabelNumeroFactura;
    public static javax.swing.JLabel jLabelPelicula;
    public static javax.swing.JLabel jLabelSala;
    public static javax.swing.JLabel jLabelTanda;
    public static javax.swing.JLabel jLabelVendedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFondo;
    // End of variables declaration//GEN-END:variables
}