/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import JFrames.ControlSalasAdmin;
import JFrames.RegistroActores;
import JFrames.RegistroAdministradores;
import JFrames.RegistroClientes;
import JFrames.RegistroDirectores;
import JFrames.RegistroGeneros;
import JFrames.RegistroHorarios;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class panelInicio extends javax.swing.JPanel {

    /**
     * Creates new form panelInicio
     */
    public panelInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        btnAdminUsuarios = new javax.swing.JButton();
        btnAdminGeneros = new javax.swing.JButton();
        btnAdminDirectores = new javax.swing.JButton();
        btnAdminHorarios = new javax.swing.JButton();
        btnAdminActores = new javax.swing.JButton();
        btnAdminClientes = new javax.swing.JButton();
        btnAdminSalas = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/MenúLT.png"))); // NOI18N
        add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 5, -1, -1));

        btnAdminUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónUsuarios.png"))); // NOI18N
        btnAdminUsuarios.setBorder(null);
        btnAdminUsuarios.setBorderPainted(false);
        btnAdminUsuarios.setContentAreaFilled(false);
        btnAdminUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminUsuarios.setFocusPainted(false);
        btnAdminUsuarios.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónUsuarios2.png"))); // NOI18N
        btnAdminUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónUsuarios2.png"))); // NOI18N
        btnAdminUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminUsuariosActionPerformed(evt);
            }
        });
        add(btnAdminUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 108, -1, -1));

        btnAdminGeneros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónGéneros.png"))); // NOI18N
        btnAdminGeneros.setBorder(null);
        btnAdminGeneros.setBorderPainted(false);
        btnAdminGeneros.setContentAreaFilled(false);
        btnAdminGeneros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminGeneros.setFocusPainted(false);
        btnAdminGeneros.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónGéneros2.png"))); // NOI18N
        btnAdminGeneros.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónGéneros2.png"))); // NOI18N
        btnAdminGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminGenerosActionPerformed(evt);
            }
        });
        add(btnAdminGeneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 108, -1, -1));

        btnAdminDirectores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónDirectores.png"))); // NOI18N
        btnAdminDirectores.setBorder(null);
        btnAdminDirectores.setBorderPainted(false);
        btnAdminDirectores.setContentAreaFilled(false);
        btnAdminDirectores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminDirectores.setFocusPainted(false);
        btnAdminDirectores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónDirectores2.png"))); // NOI18N
        btnAdminDirectores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónDirectores2.png"))); // NOI18N
        btnAdminDirectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminDirectoresActionPerformed(evt);
            }
        });
        add(btnAdminDirectores, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 251, -1, -1));

        btnAdminHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónHorarios.png"))); // NOI18N
        btnAdminHorarios.setBorder(null);
        btnAdminHorarios.setBorderPainted(false);
        btnAdminHorarios.setContentAreaFilled(false);
        btnAdminHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminHorarios.setFocusPainted(false);
        btnAdminHorarios.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónHorarios2.png"))); // NOI18N
        btnAdminHorarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónHorarios2.png"))); // NOI18N
        btnAdminHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminHorariosActionPerformed(evt);
            }
        });
        add(btnAdminHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 251, -1, -1));

        btnAdminActores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónActores.png"))); // NOI18N
        btnAdminActores.setBorder(null);
        btnAdminActores.setBorderPainted(false);
        btnAdminActores.setContentAreaFilled(false);
        btnAdminActores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminActores.setFocusPainted(false);
        btnAdminActores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónActores2.png"))); // NOI18N
        btnAdminActores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónActores2.png"))); // NOI18N
        btnAdminActores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActoresActionPerformed(evt);
            }
        });
        add(btnAdminActores, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 394, -1, -1));

        btnAdminClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónClientes.png"))); // NOI18N
        btnAdminClientes.setToolTipText("");
        btnAdminClientes.setBorder(null);
        btnAdminClientes.setBorderPainted(false);
        btnAdminClientes.setContentAreaFilled(false);
        btnAdminClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminClientes.setFocusPainted(false);
        btnAdminClientes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónClientes2.png"))); // NOI18N
        btnAdminClientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónClientes2.png"))); // NOI18N
        btnAdminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminClientesActionPerformed(evt);
            }
        });
        add(btnAdminClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 394, -1, -1));

        btnAdminSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónSalas.png"))); // NOI18N
        btnAdminSalas.setBorder(null);
        btnAdminSalas.setBorderPainted(false);
        btnAdminSalas.setContentAreaFilled(false);
        btnAdminSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminSalas.setFocusPainted(false);
        btnAdminSalas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónSalas2.png"))); // NOI18N
        btnAdminSalas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BotónSalas2.png"))); // NOI18N
        btnAdminSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminSalasActionPerformed(evt);
            }
        });
        add(btnAdminSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 537, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public static boolean pantallaUsuarios = false;
    public static boolean pantallaGeneros = false;
    public static boolean pantallaDirectores = false;
    public static boolean pantallaHorarios = false;
    public static boolean pantallaActores = false;
    public static boolean pantallaClientes = false;
    public static boolean pantallaSalas = false;
    
    private void btnAdminHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminHorariosActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaHorarios == false) {
                RegistroHorarios rh = new RegistroHorarios();
                rh.setVisible(true);
                pantallaHorarios = true;
            } else if (pantallaSalas == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminHorariosActionPerformed

    private void btnAdminDirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminDirectoresActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaDirectores == false) {
                RegistroDirectores rd = new RegistroDirectores();
                rd.setVisible(true);
                pantallaDirectores = true;
            } else if (pantallaDirectores == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminDirectoresActionPerformed

    private void btnAdminUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminUsuariosActionPerformed
        if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaUsuarios == false) {
                RegistroAdministradores ra = new RegistroAdministradores();
                ra.setVisible(true);
                pantallaUsuarios = true;
            } else if (pantallaUsuarios == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminUsuariosActionPerformed

    private void btnAdminGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminGenerosActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaGeneros == false) {
                RegistroGeneros rg = new RegistroGeneros();
                rg.setVisible(true);
                pantallaGeneros = true;
            } else if (pantallaGeneros == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminGenerosActionPerformed

    private void btnAdminActoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActoresActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaActores == false) {
                RegistroActores rac = new RegistroActores();
                rac.setVisible(true);
                pantallaActores = true;
            } else if (pantallaActores == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminActoresActionPerformed

    private void btnAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminClientesActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaSalas == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar salas está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaClientes == false) {
                RegistroClientes rc = new RegistroClientes();
                rc.setVisible(true);
                pantallaClientes = true;
            } else if (pantallaClientes == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminClientesActionPerformed

    private void btnAdminSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminSalasActionPerformed
        if (pantallaUsuarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar usuarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaDirectores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar directores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaHorarios == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar horarios está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaGeneros == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar géneros está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaActores == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar actores está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else if (pantallaClientes == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La ventana de administrar clientes está abierta\n"
                    + "Cierrela para poder visualizar esta pantalla", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            if (pantallaSalas == false) {
                ControlSalasAdmin csa = new ControlSalasAdmin();
                csa.setVisible(true);
                pantallaSalas = true;
            } else if (pantallaSalas == true) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta ventana se está ejecutando actualmente", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
            }
        }
    }//GEN-LAST:event_btnAdminSalasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminActores;
    private javax.swing.JButton btnAdminClientes;
    private javax.swing.JButton btnAdminDirectores;
    private javax.swing.JButton btnAdminGeneros;
    private javax.swing.JButton btnAdminHorarios;
    private javax.swing.JButton btnAdminSalas;
    private javax.swing.JButton btnAdminUsuarios;
    private javax.swing.JLabel lbTitulo;
    // End of variables declaration//GEN-END:variables
}
