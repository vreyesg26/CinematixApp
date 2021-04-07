/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import Datos.Conexion;
import java.sql.Statement;

/**
 *
 * @author nidia
 */
public class FrmReservaciones extends javax.swing.JFrame {

    /**
     * Creates new form FrmReservaciones
     */
    public FrmReservaciones() {
        initComponents();
        setLocationRelativeTo(null);  
        botones();
        buscarAsientosReservados();
    }
    int filas = 7;
    int columnas = 10;
    int largoBoton = 60; 
    int AnchoBoton = 60;
    int ejex = 20;
    int ejey = 20;
    public static Connection Conexion;
    public static PreparedStatement sentenciapreparada;
    public static ResultSet resultado;
    
    public JToggleButton [][] JTBotones = new JToggleButton[filas][columnas];
    
    public void botones(){
    Font fuenteletra = new Font("Arial",Font.BOLD,12);
    int contadorasientos = 1;
        JTBotones = new JToggleButton[filas][columnas];
        
        for (int i=0; i< filas; i++){
            for(int j=0; j<columnas; j++){
                
                JTBotones [i][j] = new JToggleButton ();
                JTBotones [i][j].setBounds(ejex, ejey, largoBoton, AnchoBoton);
                
                AccionBotones accion = new AccionBotones();
                JTBotones [i][j].addActionListener(accion);
                
                jPanel1.add(JTBotones[i][j]);
                JTBotones[i][j].setText("A " + contadorasientos);
                JTBotones[i][j].setFont(fuenteletra);
                JTBotones[i][j].setBackground(Color.GREEN);
                
                contadorasientos++;
                ejex += 70;
            }
            ejex =20;
            ejey += 70;
        }
    }
    public void reservaAsiento(int numeroasiento){
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String consulta = "UPDATE asiento SET Estado = 'reservado' WHERE IDAsiento = " + numeroasiento;
        try{
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(consulta);
           
            sentenciapreparada = Conexion.prepareStatement(consulta);
            int mensaje = sentenciapreparada.executeUpdate();
            
            if (mensaje>0){
                JOptionPane.showMessageDialog(null, "Asiento Reservado");
            
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado de los asientos ");
            }
        }catch(HeadlessException | SQLException e){
            System.out.println("Error: " + e);  
        }finally{
            try {
                Conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrmReservaciones.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
    }
    public void QuitarReservaAsiento(int numeroasiento){
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String consulta = "UPDATE asiento SET Estado = 'no reservado' WHERE IDAsiento = " + numeroasiento;
        try{
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(consulta);
            sentenciapreparada = Conexion.prepareStatement(consulta);
            int mensaje = sentenciapreparada.executeUpdate();
            
            if (mensaje>0){
                JOptionPane.showMessageDialog(null, "Se ha quitado la reservacion para este asiento");
            
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado de los asientos ");
            }
        }catch(HeadlessException | SQLException e){
            System.out.println("Error: " + e);  
        }finally{
            try {
                Conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrmReservaciones.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
    }
    public class AccionBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            for(int i = 0; i<filas; i++){
                for(int j = 0; j<columnas; j++){
                    if (ae.getSource().equals(JTBotones[i][j])){
                        if (JTBotones [i][j].isSelected()){
                            JTBotones [i][j].setBackground(Color.RED);
                            
                            if(JTBotones[i][j].getText().length() == 3){
                                String numeroLetra = JTBotones[i][j].getText().charAt(2)+" ";
                                int numero = Integer.parseInt(numeroLetra);
                                reservaAsiento(numero);
                            }else if(JTBotones[i][j].getText().length() == 4){
                                String numeroLetra = JTBotones[i][j].getText().charAt(2)+" "+ JTBotones[i][j].getText().charAt(3);
                                int numero = Integer.parseInt(numeroLetra);
                                
                            }
                        }else{
                            JTBotones [i][j].setBackground(Color.GREEN);
                             if(JTBotones[i][j].getText().length() == 3){
                                String numeroLetra = JTBotones[i][j].getText().charAt(2)+" ";
                                int numero = Integer.parseInt(numeroLetra);
                                QuitarReservaAsiento(numero);
                            }else if(JTBotones[i][j].getText().length() == 4){
                                String numeroLetra = JTBotones[i][j].getText().charAt(2)+" "+ JTBotones[i][j].getText().charAt(3);
                                int numero = Integer.parseInt(numeroLetra);
                                 QuitarReservaAsiento(numero);
                            }
                        }
                    }
                    
                }
            }
        }
        
    }
    
    public void buscarAsientosReservados(){
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String consulta = "SELECT IDAsiento, Estado FROM asientos";
        
        try{
             Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(consulta);
            sentenciapreparada = Conexion.prepareStatement(consulta);
            resultado = sentenciapreparada.executeQuery();
            int numero;
            String Estado;
            
            while (resultado.next()){
                numero = resultado.getInt("IDAsiento");
                Estado = resultado.getString("Estado");
                
                for (int i = 0; i < filas; i++){
                    for(int j = 0; j < columnas; j++){
                        if (JTBotones[i][j].getText().length() == 3){
                            String numeroLetra = JTBotones[i][j].getText().charAt(2) + "";
                            int numeroN = Integer.parseInt(numeroLetra);
                            if((numero == numeroN ) && (Estado.equals("reservado"))){
                                JTBotones[i][j].setBackground(Color.RED);
                                JTBotones[i][j].setSelected(true);
                            }
                        }else if(JTBotones[i][j].getText().length() == 4){
                            
                            String numeroLetra = JTBotones[i][j].getText().charAt(2) + "" +JTBotones[i][j].getText().charAt(3);
                            int numeroN = Integer.parseInt(numeroLetra);
                            if((numero == numeroN ) && (Estado.equals("reservado"))){
                                JTBotones[i][j].setBackground(Color.RED);
                                JTBotones[i][j].setSelected(true);
                            }
                            
                        }
                    }
                }
            }
        }catch(SQLException e){
            
        }
    }

    /**
     * This metho d is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estado de los Asientos ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Asiento Disponible");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Asiento Reservado");

        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FrmMenu vista = new FrmMenu ();
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
