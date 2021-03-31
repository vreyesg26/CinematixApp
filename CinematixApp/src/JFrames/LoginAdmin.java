/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import Tipografia.Fuente;
import encriptacion.Encode;
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
public class LoginAdmin extends javax.swing.JFrame {
    

    /**
     * Creates new form LoginAdmin
     */
    Fuente tipoFuente;
    public LoginAdmin() {
        initComponents();
        transparenciaButton();
        TextPrompt prueba = new TextPrompt("INGRESAR USUARIO", txtusuario);
        TextPrompt pru = new TextPrompt("INGRESAR CLAVE", txtpassword);
        setBackground( new Color (0,0,0,0));  
        
        tipoFuente = new Fuente();
        txtusuario.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 15));
        txtpassword.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 15));
        prueba.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 15));
        pru.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 15));
    }

    
    @Override
    public Image getIconImage(){
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

        btnCerrar = new javax.swing.JLabel();
        btninicioa = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btninicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImage(getIconImage());
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 70, 40, 40));

        btninicioa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BtnIniciarSesión.png"))); // NOI18N
        btninicioa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btninicioa.setOpaque(false);
        btninicioa.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BtnIniciarSesión2.png"))); // NOI18N
        btninicioa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BtnIniciarSesión2.png"))); // NOI18N
        btninicioa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioaActionPerformed(evt);
            }
        });
        getContentPane().add(btninicioa, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 390, 150, 40));

        txtusuario.setBackground(new java.awt.Color(0, 0, 0));
        txtusuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(255, 255, 255));
        txtusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusuario.setAutoscrolls(false);
        txtusuario.setBorder(null);
        txtusuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtusuario.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtusuario.setOpaque(false);
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 210, 240, 45));
        txtusuario.getAccessibleContext().setAccessibleName("");

        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword.setBorder(null);
        txtpassword.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtpassword.setOpaque(false);
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 300, 240, 45));
        txtpassword.getAccessibleContext().setAccessibleName("");

        btninicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LoginAdmin.png"))); // NOI18N
        getContentPane().add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   public void transparenciaButton(){
       btninicioa.setOpaque(false);
       btninicioa.setContentAreaFilled(false);
       btninicioa.setBorderPainted(false);
   }
  
   public void validarAdministradores(){
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        Encode encode = new Encode();
        String secretKey = "lospibes";
        String user = txtusuario.getText();
        String pass = String.valueOf(txtpassword.getPassword());
        String sql = "SELECT * FROM usuarios WHERE Usuario = '" + user + "'";
        
        if(txtusuario.getText().isEmpty() && txtpassword.getText().isEmpty() || txtusuario.getText().isEmpty() || txtpassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debes llenar los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        } else {
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    int intentos = Integer.parseInt(rs.getString("Intentos"));
                    if (rs.getString("Intentos").equals("0")) {
                        JOptionPane.showMessageDialog(null, "Usuario inactivo, comuniquese con el administrador del sistema para restablecer su usuario", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                        txtusuario.setText("");
                        txtpassword.setText("");
                    } else if (encode.deecnode(secretKey, rs.getString("Contrasena")).equals(pass)) {
                        AdminDashboard ad = new AdminDashboard();
                        ad.setVisible(true);
                        this.dispose();
                        try {
                            String sqlRestar = "UPDATE `usuarios` SET `Intentos` = ? WHERE `usuarios`.`Usuario` = ? ";
                            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlRestar);
                            pst.setString(1, String.valueOf("3"));
                            pst.setString(2, user);
                            pst.execute();

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "No ha sido posible restar los intentos" + e);
                        }
                    } else {
                        --intentos;
                        if (intentos == 0) {
                            JOptionPane.showMessageDialog(null, "Ha excedido el número de intentos para ingresar \n" + "Su usuario ha sido deshabilitado", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                            txtusuario.setText("");
                            txtpassword.setText("");
                            Inicio inicio = new Inicio();
                            inicio.setVisible(true);
                            this.dispose();
                            try {
                                String sqlEstado = "UPDATE `usuarios` SET `Intentos` = ? WHERE `usuarios`.`Usuario` = ? ";
                                PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                                pst.setString(1, String.valueOf(intentos));
                                pst.setString(2, user);
                                pst.execute();

                            } catch (Exception e) {
                                
                            }
                        } else {
                            try {
                                String sqlEstado = "UPDATE `usuarios` SET `Intentos` = ? WHERE `usuarios`.`Usuario` = ? ";
                                PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                                pst.setString(1, String.valueOf(intentos));
                                pst.setString(2, user);
                                pst.execute();

                            } catch (Exception e) {
                                
                            }
                            JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta, te quedan " + intentos + " intentos", "Aviso", JOptionPane.WARNING_MESSAGE);
                            txtusuario.setText("");
                            txtpassword.setText("");
                        }
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de conexión " + e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                txtusuario.setText("");
                txtpassword.setText("");
            }
        }
    }
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            for (double i=0.0; i<=1.0; i=i+0.1){
            String val = i+"";
            float f=Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            }
            catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        Inicio regresoMenu = new Inicio();
        regresoMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

   
    private void btninicioaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioaActionPerformed
        validarAdministradores();
    }//GEN-LAST:event_btninicioaActionPerformed

    
    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
      
      
    }//GEN-LAST:event_txtusuarioKeyTyped

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btninicio;
    private javax.swing.JButton btninicioa;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

}
