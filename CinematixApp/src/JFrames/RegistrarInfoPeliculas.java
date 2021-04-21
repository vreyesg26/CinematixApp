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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Reyes
 */
public class RegistrarInfoPeliculas extends javax.swing.JFrame {

    /**
     * Creates new form registrarInfoPeliculas
     */
    Fuente tipoFuente;

    public RegistrarInfoPeliculas() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        consultarActores();
        consultarHorarios();
        consultarSalas();

        tipoFuente = new Fuente();
        listaActores.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        listaActoresAgregados.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        listaHorarios.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        listaHorariosAgregados.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        listaSalas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        listaSalasAgregadas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));
        lbPelicula.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 16));

        listaActores.setModel(modelActores);
        listaActoresAgregados.setModel(modelActoresAgregados);
        listaHorarios.setModel(modelHorarios);
        listaHorariosAgregados.setModel(modelHorariosElegidos);
        listaSalas.setModel(modelSalas);
        listaSalasAgregadas.setModel(modelSalasElegidas);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listaActores = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaActoresAgregados = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaHorarios = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaHorariosAgregados = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaSalas = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaSalasAgregadas = new javax.swing.JList<>();
        btnAgregarActor = new javax.swing.JButton();
        btnEliminarActor = new javax.swing.JButton();
        btnAgregarHorario = new javax.swing.JButton();
        btnEliminarHorario = new javax.swing.JButton();
        btnAgregarSala = new javax.swing.JButton();
        btnEliminarSala = new javax.swing.JButton();
        btnActores = new javax.swing.JButton();
        btnHorarios = new javax.swing.JButton();
        btnSalas = new javax.swing.JButton();
        btnSalir = new javax.swing.JLabel();
        lbPelicula = new javax.swing.JLabel();
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

        listaActores.setOpaque(false);
        jScrollPane1.setViewportView(listaActores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 125, 250, 170));

        jScrollPane2.setViewportView(listaActoresAgregados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 375, 250, 170));

        jScrollPane3.setViewportView(listaHorarios);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 125, 250, 170));

        jScrollPane4.setViewportView(listaHorariosAgregados);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 375, 250, 170));

        jScrollPane5.setViewportView(listaSalas);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 125, 250, 170));

        jScrollPane6.setViewportView(listaSalasAgregadas);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 375, 250, 170));

        btnAgregarActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento.png"))); // NOI18N
        btnAgregarActor.setBorder(null);
        btnAgregarActor.setBorderPainted(false);
        btnAgregarActor.setContentAreaFilled(false);
        btnAgregarActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarActor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarActor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 310, 50, 50));

        btnEliminarActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento.png"))); // NOI18N
        btnEliminarActor.setBorder(null);
        btnEliminarActor.setBorderPainted(false);
        btnEliminarActor.setContentAreaFilled(false);
        btnEliminarActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarActor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarActor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActorActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarActor, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 310, -1, -1));

        btnAgregarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento.png"))); // NOI18N
        btnAgregarHorario.setBorder(null);
        btnAgregarHorario.setBorderPainted(false);
        btnAgregarHorario.setContentAreaFilled(false);
        btnAgregarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarHorario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarHorario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 310, 50, 50));

        btnEliminarHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento.png"))); // NOI18N
        btnEliminarHorario.setBorder(null);
        btnEliminarHorario.setBorderPainted(false);
        btnEliminarHorario.setContentAreaFilled(false);
        btnEliminarHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarHorario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarHorario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 310, -1, -1));

        btnAgregarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento.png"))); // NOI18N
        btnAgregarSala.setBorder(null);
        btnAgregarSala.setBorderPainted(false);
        btnAgregarSala.setContentAreaFilled(false);
        btnAgregarSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarSala.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarSala.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarElemento2.png"))); // NOI18N
        btnAgregarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSalaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 310, 50, 50));

        btnEliminarSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento.png"))); // NOI18N
        btnEliminarSala.setBorder(null);
        btnEliminarSala.setBorderPainted(false);
        btnEliminarSala.setContentAreaFilled(false);
        btnEliminarSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarSala.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarSala.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEliminarElemento2.png"))); // NOI18N
        btnEliminarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSalaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 310, -1, -1));

        btnActores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarActores.png"))); // NOI18N
        btnActores.setBorder(null);
        btnActores.setBorderPainted(false);
        btnActores.setContentAreaFilled(false);
        btnActores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActores.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarActores2.png"))); // NOI18N
        btnActores.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarActores2.png"))); // NOI18N
        btnActores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnActores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 572, -1, -1));

        btnHorarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarHorarios.png"))); // NOI18N
        btnHorarios.setBorder(null);
        btnHorarios.setBorderPainted(false);
        btnHorarios.setContentAreaFilled(false);
        btnHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHorarios.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarHorarios2.png"))); // NOI18N
        btnHorarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarHorarios2.png"))); // NOI18N
        btnHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 572, -1, -1));

        btnSalas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarSalas.png"))); // NOI18N
        btnSalas.setBorder(null);
        btnSalas.setBorderPainted(false);
        btnSalas.setContentAreaFilled(false);
        btnSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarSalas2.png"))); // NOI18N
        btnSalas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarSalas2.png"))); // NOI18N
        btnSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 572, -1, -1));

        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 28, 28));

        lbPelicula.setForeground(new java.awt.Color(255, 255, 255));
        lbPelicula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 13, 505, 40));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroInfoPeliculas.png"))); // NOI18N
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    Conexion cn = new Conexion();
    Connection cc = cn.GetConexion();

    ArrayList arregloActores = new ArrayList();
    ArrayList arregloActoresElegidos = new ArrayList();
    ArrayList arregloHorarios = new ArrayList();
    ArrayList arregloHorariosElegidos = new ArrayList();
    ArrayList arregloSalas = new ArrayList();
    ArrayList arregloSalasElegidas = new ArrayList();
    DefaultListModel modelActores = new DefaultListModel();
    DefaultListModel modelActoresAgregados = new DefaultListModel();
    DefaultListModel modelHorarios = new DefaultListModel();
    DefaultListModel modelHorariosElegidos = new DefaultListModel();
    DefaultListModel modelSalas = new DefaultListModel();
    DefaultListModel modelSalasElegidas = new DefaultListModel();

    void consultarActores() {
        String sql = "SELECT Nombre FROM actores WHERE IDEstado = 1";

        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                arregloActores.add(rs.getString("Nombre"));
                System.out.println(arregloActores);
            }
        } catch (Exception e) {

        }

        System.out.println(arregloActores);
        for (int i = 0; i < arregloActores.size(); i++) {
            modelActores.addElement(arregloActores.get(i));
        }
    }

    void consultarHorarios() {
        String sql = "SELECT Hora FROM horarios WHERE IDEstado = 1";

        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                arregloHorarios.add(rs.getString("Hora"));
                System.out.println(arregloHorarios);
            }
        } catch (Exception e) {

        }

        System.out.println(arregloHorarios);
        for (int i = 0; i < arregloHorarios.size(); i++) {
            modelHorarios.addElement(arregloHorarios.get(i));
        }
    }

    void consultarSalas() {
        String sql = "SELECT Sala FROM salas WHERE IDEstado = 1";

        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                arregloSalas.add(rs.getString("Sala"));
                System.out.println(arregloSalas);
            }
        } catch (Exception e) {

        }

        System.out.println(arregloSalas);
        for (int i = 0; i < arregloSalas.size(); i++) {
            modelSalas.addElement(arregloSalas.get(i));
        }
    }

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

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        this.dispose();
        Paneles.panelPeliculas.pantallaInfoAdicional = false;
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnAgregarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActorActionPerformed
        String actorSeleccionado = listaActores.getSelectedValue();
        if (arregloActoresElegidos.contains(actorSeleccionado)) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "El actor " + actorSeleccionado + " ya está en la lista", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            arregloActoresElegidos.add(actorSeleccionado);
            System.out.println(arregloActoresElegidos);
            modelActoresAgregados.addElement(actorSeleccionado);
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Se agregó el actor " + actorSeleccionado + " a la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }//GEN-LAST:event_btnAgregarActorActionPerformed

    private void btnEliminarActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActorActionPerformed
        String actorSeleccionado = listaActoresAgregados.getSelectedValue();
        arregloActoresElegidos.remove(actorSeleccionado);
        System.out.println(arregloActoresElegidos);
        modelActoresAgregados.removeElement(actorSeleccionado);
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
        JOptionPane.showMessageDialog(null, "Se quitó el actor " + actorSeleccionado + " de la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
    }//GEN-LAST:event_btnEliminarActorActionPerformed

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        String horarioSeleccionado = listaHorarios.getSelectedValue();
        if (arregloHorariosElegidos.contains(horarioSeleccionado)) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "El horario " + horarioSeleccionado + " ya está en la lista", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            arregloHorariosElegidos.add(horarioSeleccionado);
            System.out.println(arregloHorariosElegidos);
            modelHorariosElegidos.addElement(horarioSeleccionado);
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Se agregó el horario " + horarioSeleccionado + " a la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    private void btnEliminarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHorarioActionPerformed
        String horarioSeleccionado = listaHorariosAgregados.getSelectedValue();
        arregloHorariosElegidos.remove(horarioSeleccionado);
        System.out.println(arregloHorariosElegidos);
        modelHorariosElegidos.removeElement(horarioSeleccionado);
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
        JOptionPane.showMessageDialog(null, "Se quitó el horario " + horarioSeleccionado + " de la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
    }//GEN-LAST:event_btnEliminarHorarioActionPerformed

    private void btnAgregarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSalaActionPerformed
        String salaSeleccionada = listaSalas.getSelectedValue();
        if (arregloSalasElegidas.contains(salaSeleccionada)) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La sala " + salaSeleccionada + " ya está en la lista", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            arregloSalasElegidas.add(salaSeleccionada);
            System.out.println(arregloSalasElegidas);
            modelSalasElegidas.addElement(salaSeleccionada);
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Se agregó la sala " + salaSeleccionada + " a la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }//GEN-LAST:event_btnAgregarSalaActionPerformed

    private void btnEliminarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSalaActionPerformed
        String salaSeleccionada = listaSalasAgregadas.getSelectedValue();
        arregloSalasElegidas.remove(salaSeleccionada);
        System.out.println(arregloSalasElegidas);
        modelSalasElegidas.removeElement(salaSeleccionada);
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
        JOptionPane.showMessageDialog(null, "Se quitó la sala " + salaSeleccionada + " de la lista", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
    }//GEN-LAST:event_btnEliminarSalaActionPerformed

    ArrayList arregloIDActores = new ArrayList();

    void obtenerIDActores() {
        for (int i = 0; i < arregloActoresElegidos.size(); i++) {
            try {
                String sql = "SELECT IDActor FROM actores WHERE Nombre = '" + arregloActoresElegidos.get(i) + "'";

                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    arregloIDActores.add(rs.getString("IDActor"));
                    System.out.println(arregloIDActores);
                }
            } catch (Exception e) {
            }
        }
    }

    ArrayList arregloIDHorarios = new ArrayList();

    void obtenerIDHorarios() {
        for (int i = 0; i < arregloHorariosElegidos.size(); i++) {
            try {
                String sql = "SELECT IDHorario FROM horarios WHERE Hora = '" + arregloHorariosElegidos.get(i) + "'";

                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    arregloIDHorarios.add(rs.getString("IDHorario"));
                    System.out.println(arregloIDHorarios);
                }
            } catch (Exception e) {
            }
        }
    }

    ArrayList arregloIDSalas = new ArrayList();

    void obtenerIDSalas() {
        for (int i = 0; i < arregloSalasElegidas.size(); i++) {
            try {
                String sql = "SELECT IDSalas FROM salas WHERE Sala = '" + arregloSalasElegidas.get(i) + "'";

                Statement st = cc.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    arregloIDSalas.add(rs.getString("IDSalas"));
                    System.out.println(arregloIDSalas);
                }
            } catch (Exception e) {
            }
        }
    }

    void guardarActores() {
        int datosGuardados = 0;
        for (int i = 0; i < arregloIDActores.size(); i++) {
            try {
                String sql = "INSERT INTO peliculasactores (IdPelicula, IDActor) VALUES (?,?)";

                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, Paneles.panelPeliculas.idUltimaPelicula);
                pst.setString(2, arregloIDActores.get(i).toString());
                datosGuardados = pst.executeUpdate();

            } catch (Exception e) {
            }
        }
        if (datosGuardados > 0) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Los actores se guardaron satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            arregloIDActores.clear();
            arregloActoresElegidos.clear();
            modelActoresAgregados.clear();
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar guardar los actores", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }

    void guardarHorarios() {
        int datosGuardados = 0;
        for (int i = 0; i < arregloIDHorarios.size(); i++) {
            try {
                String sql = "INSERT INTO peliculashorarios (IdPelicula, IDHorario) VALUES (?,?)";

                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, Paneles.panelPeliculas.idUltimaPelicula);
                pst.setString(2, arregloIDHorarios.get(i).toString());
                datosGuardados = pst.executeUpdate();

            } catch (Exception e) {
            }
        }
        if (datosGuardados > 0) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Los horarios se guardaron satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            arregloIDHorarios.clear();
            arregloHorariosElegidos.clear();
            modelHorariosElegidos.clear();
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar guardar los horarios", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }

    void guardarSalas() {
        int datosGuardados = 0;
        for (int i = 0; i < arregloIDSalas.size(); i++) {
            try {
                String sql = "INSERT INTO peliculassalas (IdPelicula, IDSalas) VALUES (?,?)";

                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, Paneles.panelPeliculas.idUltimaPelicula);
                pst.setString(2, arregloIDSalas.get(i).toString());
                datosGuardados = pst.executeUpdate();

            } catch (Exception e) {
            }
        }
        if (datosGuardados > 0) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
            JOptionPane.showMessageDialog(null, "Las salas se guardaron satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            arregloIDSalas.clear();
            arregloSalasElegidas.clear();
            modelSalasElegidas.clear();
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar guardar las salas", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }

    private void btnActoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActoresActionPerformed
        if (arregloActoresElegidos.isEmpty()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún actor", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            obtenerIDActores();
            guardarActores();
        }
    }//GEN-LAST:event_btnActoresActionPerformed

    private void btnHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorariosActionPerformed
        if (arregloHorariosElegidos.isEmpty()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "No has seleccionado ningún horario", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            obtenerIDHorarios();
            guardarHorarios();
        }
    }//GEN-LAST:event_btnHorariosActionPerformed

    private void btnSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalasActionPerformed
        if (arregloSalasElegidas.isEmpty()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna sala", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            obtenerIDSalas();
            guardarSalas();
        }
    }//GEN-LAST:event_btnSalasActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarInfoPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarInfoPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActores;
    private javax.swing.JButton btnAgregarActor;
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnAgregarSala;
    private javax.swing.JButton btnEliminarActor;
    private javax.swing.JButton btnEliminarHorario;
    private javax.swing.JButton btnEliminarSala;
    private javax.swing.JButton btnHorarios;
    private javax.swing.JButton btnSalas;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbFondo;
    public static javax.swing.JLabel lbPelicula;
    private javax.swing.JList<String> listaActores;
    private javax.swing.JList<String> listaActoresAgregados;
    private javax.swing.JList<String> listaHorarios;
    private javax.swing.JList<String> listaHorariosAgregados;
    private javax.swing.JList<String> listaSalas;
    private javax.swing.JList<String> listaSalasAgregadas;
    // End of variables declaration//GEN-END:variables
}
