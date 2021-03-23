/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static JFrames.MenuVendedor.txtBoletosAdultos;

/**
 *
 * @author Jeymerd Canales
 */
public final class Preview extends javax.swing.JFrame {

    /**
     * Creates new form Preview
     */
    public Preview() {
        super.setUndecorated(true);
        initComponents();
        noEditable();
        super.setLocationRelativeTo(this);
        jButtonComprar.setEnabled(false);
    }

    void noEditable() {
        jTextFieldPelicula.setEditable(false);
        jTextFieldHora.setEditable(false);
    }

    void calculo() {
        double efectivoR;
        double totalPago;
        double cambio;
       
        totalPago = Double.parseDouble(jLabelTotalPago.getText());
        efectivoR = Double.parseDouble(jTextFieldEfectivoRecibido.getText());
        if (efectivoR < totalPago) {
            JOptionPane.showMessageDialog(this, "No cuentas con suficiente dinero", "Cobro", JOptionPane.WARNING_MESSAGE);
        } else {
            cambio = efectivoR - totalPago;
            jLabelCambio.setText("L." + cambio + "0");
            jButtonComprar.setEnabled(true);
        }
    }

    void pasaDatos() {
        Ticket.jLabelPelicula.setText(jTextFieldPelicula.getText());
        Ticket.jLabelSala.setText(jLabelSala.getText());
        Ticket.jLabelTanda.setText(jTextFieldHora.getText());
        Ticket.jLabelNiños.setText(jTextFieldCantidadDeBoletosNiños.getText());
        Ticket.jLabeNiñosTotal.setText(jLabelTotalNiños.getText());
        Ticket.jLabeAdultos.setText(jTextFieldCantidadDeBoletosAdultos.getText());
        Ticket.jLabeAdultosTotal.setText(jLabelTotalAdultos.getText());
        Ticket.jLabeTotal.setText("L."+jLabelTotalPago.getText());
        Ticket.jLabeEfectivoRecibido.setText("L."+jTextFieldEfectivoRecibido.getText());
        Ticket.jLabeCambio.setText(jLabelCambio.getText());
        Ticket.jLabelISV.setText(jLabelImpuesto.getText());
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonComprar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPelicula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletosAdultos = new javax.swing.JTextField();
        jTextFieldCantidadDeBoletosNiños = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelTotalAdultos = new javax.swing.JLabel();
        jLabelTotalNiños = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelTotalPago = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldEfectivoRecibido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabelCambio = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNombreVendedor = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabelImpuesto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel1.setText("Confirme sus datos:");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(490, 50));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButtonComprar.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jButtonComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buy.png"))); // NOI18N
        jButtonComprar.setText("Comprar");
        jButtonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprarActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonComprar);

        jPanel2.add(jPanel5, java.awt.BorderLayout.LINE_END);

        jButtonRegresar.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonRegresar);

        jPanel2.add(jPanel6, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel2.setText("Pelicula ");

        jLabel3.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel3.setText("Sala");

        jLabel4.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel4.setText("Hora");

        jLabelSala.setBackground(new java.awt.Color(0, 204, 51));

        jLabel5.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad de boletos (adultos)");

        jTextFieldCantidadDeBoletosAdultos.setEditable(false);
        jTextFieldCantidadDeBoletosAdultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosAdultosActionPerformed(evt);
            }
        });

        jTextFieldCantidadDeBoletosNiños.setEditable(false);
        jTextFieldCantidadDeBoletosNiños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosNiñosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel6.setText("Cantidad de boletos (niños)");

        jLabel7.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel7.setText("Total Adultos");

        jLabel8.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel8.setText("Total Niños");

        jLabel9.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel9.setText("Total a pagar");

        jLabel15.setText("L.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelSala, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabelTotalAdultos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTotalNiños)
                .addGap(79, 79, 79))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalNiños)
                    .addComponent(jLabelTotalAdultos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabelTotalPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(39, 39, 39))
        );

        jPanel3.add(jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel10.setText("Nombre vendedor: ");

        jLabel11.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel11.setText("Tegucigalpa");

        jLabel12.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel12.setText("Ubicacion:");

        jLabel13.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel13.setText("Efectivo recibido:");

        jTextFieldEfectivoRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEfectivoRecibidoActionPerformed(evt);
            }
        });
        jTextFieldEfectivoRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEfectivoRecibidoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel14.setText("Cambio:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/click.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        jLabel16.setText("CineMatix");

        jTextFieldNombreVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreVendedorActionPerformed(evt);
            }
        });
        jTextFieldNombreVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreVendedorKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("ISV:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(135, 135, 135))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel13)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabelCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextFieldEfectivoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldEfectivoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabelImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel16)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel16.getAccessibleContext().setAccessibleName("CineMatix, Honduras");

        jPanel3.add(jPanel7);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jTextFieldCantidadDeBoletosAdultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       double efectivoR;
       double isv;
        efectivoR = Double.parseDouble(jTextFieldEfectivoRecibido.getText());
        isv = efectivoR *0.15;
            jLabelImpuesto.setText("L." + isv + "0");
        calculo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarActionPerformed
        Ticket obj = new Ticket();
        pasaDatos();
        dispose();
        obj.setVisible(true);
    }//GEN-LAST:event_jButtonComprarActionPerformed

    private void jTextFieldEfectivoRecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEfectivoRecibidoKeyTyped
                char cant = evt.getKeyChar();
            
            if((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                    && (cant != (char)KeyEvent.VK_BACK_SPACE )){
                    evt.consume();
                    
                    JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros"
                    , JOptionPane.WARNING_MESSAGE);
                    
    }else if ((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                    && (cant != (char)KeyEvent.VK_BACK_SPACE )){
                    evt.consume();
                    
                    JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros"
                    , JOptionPane.WARNING_MESSAGE);
                    }
    }//GEN-LAST:event_jTextFieldEfectivoRecibidoKeyTyped

    private void jTextFieldNombreVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreVendedorActionPerformed

    private void jTextFieldEfectivoRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEfectivoRecibidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEfectivoRecibidoActionPerformed

    private void jTextFieldCantidadDeBoletosNiñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed

    private void jTextFieldNombreVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreVendedorKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se admiten letras");
        }
    }//GEN-LAST:event_jTextFieldNombreVendedorKeyTyped

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
            java.util.logging.Logger.getLogger(Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButtonComprar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCambio;
    private javax.swing.JLabel jLabelImpuesto;
    public static final javax.swing.JLabel jLabelSala = new javax.swing.JLabel();
    public static javax.swing.JLabel jLabelTotalAdultos;
    public static javax.swing.JLabel jLabelTotalNiños;
    public static javax.swing.JLabel jLabelTotalPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosAdultos;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosNiños;
    public static javax.swing.JTextField jTextFieldEfectivoRecibido;
    public static javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldNombreVendedor;
    public static javax.swing.JTextField jTextFieldPelicula;
    // End of variables declaration//GEN-END:variables
}
