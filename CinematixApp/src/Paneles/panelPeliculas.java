package Paneles;

import Datos.Conexion;
import Logica.datosPeliculas;
import Tipografia.DecoracionTablas;
import Tipografia.Fuente;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Los Pibes
 */
public class panelPeliculas extends javax.swing.JPanel {

    /**
     * Creates new form panelPeliculas
     */
    Fuente tipoFuente;

    public panelPeliculas() {
        initComponents();
        txtUrl.setEnabled(false);
        tipoFuente = new Fuente();

        lbDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbURL.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        txtDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtUrl.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbIdiomas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbHorarios.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        tablaPeliculas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));

        btnImagen.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        btnGuardar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        btnEditar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        btnEliminar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        btnNuevo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        tablaPeliculas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));

        tablaPeliculas.getColumnModel().getColumn(0).setHeaderRenderer(new DecoracionTablas(Color.GRAY, Color.WHITE));
    }
    
    boolean guardar = false;

    void validarCamposVacios() {
        if (txtDuracion.getText().isEmpty() && txtLetras.getText().isEmpty() && txtReparto.getText().isEmpty()
                && txtSinopsis.getText().isEmpty() && txtTitulo.getText().isEmpty()
                && txtUrl.getText().isEmpty() && cbDirector.getSelectedIndex() == 0
                && cbHorarios.getSelectedIndex() == 0 && cbIdiomas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo título");
        } else if (txtDuracion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo duración");
        } else if (txtReparto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo reparto");
        } else if (txtSinopsis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo sinopsis");
        } else if (txtUrl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una imagen para la pelicula");
        } else if (cbDirector.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un director");
        } else if (cbIdiomas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un idioma");
        } else if (cbHorarios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un horario");
        }else{
            guardar = true;
        }
    }

    void limpiarCajas() {
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtReparto.setText("");
        txtSinopsis.setText("");
        txtUrl.setText("");
        cbDirector.setSelectedIndex(0);
        cbHorarios.setSelectedIndex(0);
        cbIdiomas.setSelectedIndex(0);
        labelFoto.setIcon(null);
    }

    public void validarCaracteres(java.awt.event.KeyEvent e) {
        if (e.getKeyChar() >= 33 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 64
                || e.getKeyChar() >= 91 && e.getKeyChar() <= 96
                || e.getKeyChar() >= 123 && e.getKeyChar() <= 208
                || e.getKeyChar() >= 210 && e.getKeyChar() <= 240
                || e.getKeyChar() >= 242 && e.getKeyChar() <= 255) {
            
            e.consume();
            JOptionPane.showMessageDialog(null, "Este campo no acepta caracteres especiales");
        }
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
        tablaPeliculas = new javax.swing.JTable();
        txtLetras = new javax.swing.JLabel();
        labelFoto = new javax.swing.JLabel();
        cbIdiomas = new javax.swing.JComboBox<>();
        cbDirector = new javax.swing.JComboBox<>();
        txtTitulo = new javax.swing.JTextField();
        txtSinopsis = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        lbDuracion = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        btnImagen = new rojerusan.RSButtonHover();
        btnGuardar = new rojerusan.RSButtonHover();
        btnEditar = new rojerusan.RSButtonHover();
        btnEliminar = new rojerusan.RSButtonHover();
        btnNuevo = new rojerusan.RSButtonHover();
        lbReparto = new javax.swing.JLabel();
        txtReparto = new javax.swing.JTextField();
        cbHorarios = new javax.swing.JComboBox<>();
        lbURL = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        lbSinopsis = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 690));

        tablaPeliculas.setBackground(new java.awt.Color(61, 61, 61));
        tablaPeliculas.setForeground(new java.awt.Color(255, 255, 255));
        tablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPeliculas.setAlignmentY(4.0F);
        tablaPeliculas.setOpaque(false);
        tablaPeliculas.setSelectionBackground(new java.awt.Color(29, 29, 29));
        jScrollPane1.setViewportView(tablaPeliculas);

        txtLetras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PeliculasLT.png"))); // NOI18N

        labelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbIdiomas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Idioma...", "Español", "Inglés" }));
        cbIdiomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbIdiomas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbIdiomas.setOpaque(false);

        cbDirector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Director...", "Mel Gibson", "Martin Scorsese", "David Lynch", "Federico Fellini", "Stanley Kubrick", "Steven Spielberg", "Quentin Tarantino", "Ingmar Bergman", "Francis Ford Coppola", "Alfred Hitchcock" }));
        cbDirector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbDirector.setOpaque(false);

        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setOpaque(false);

        txtSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        txtSinopsis.setOpaque(false);
        txtSinopsis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSinopsisActionPerformed(evt);
            }
        });

        txtDuracion.setForeground(new java.awt.Color(255, 255, 255));
        txtDuracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuracion.setOpaque(false);
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDuracionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });

        lbDuracion.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbDuracion.setForeground(new java.awt.Color(255, 255, 255));
        lbDuracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDuracion.setText("DURACIÓN");

        lbTitulo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("TITULO");

        btnImagen.setBackground(new java.awt.Color(81, 81, 81));
        btnImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoFoto.png"))); // NOI18N
        btnImagen.setText("INSERTAR IMAGEN");
        btnImagen.setBorderPainted(false);
        btnImagen.setColorHover(new java.awt.Color(61, 61, 61));
        btnImagen.setFocusable(false);
        btnImagen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(81, 81, 81));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoGuardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setColorHover(new java.awt.Color(61, 61, 61));
        btnGuardar.setFocusable(false);
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(81, 81, 81));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoEditar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorderPainted(false);
        btnEditar.setColorHover(new java.awt.Color(61, 61, 61));
        btnEditar.setFocusable(false);
        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(81, 81, 81));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoEliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setColorHover(new java.awt.Color(61, 61, 61));
        btnEliminar.setFocusable(false);
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(81, 81, 81));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoNuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setColorHover(new java.awt.Color(61, 61, 61));
        btnNuevo.setFocusable(false);
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        lbReparto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbReparto.setForeground(new java.awt.Color(255, 255, 255));
        lbReparto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReparto.setText("REPARTO");

        txtReparto.setForeground(new java.awt.Color(255, 255, 255));
        txtReparto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReparto.setOpaque(false);

        cbHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Horario...", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm", "10:00pm" }));
        cbHorarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbHorarios.setOpaque(false);

        lbURL.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbURL.setForeground(new java.awt.Color(255, 255, 255));
        lbURL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbURL.setText("IMAGEN URL");

        txtUrl.setForeground(new java.awt.Color(255, 255, 255));
        txtUrl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUrl.setOpaque(false);
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });

        lbSinopsis.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        lbSinopsis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSinopsis.setText("SINOPSIS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbURL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbSinopsis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbHorarios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbDirector, 0, 206, Short.MAX_VALUE))
                                    .addComponent(cbIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(279, Short.MAX_VALUE)
                        .addComponent(txtLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLetras)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(290, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbURL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if(guardar == false){
            
        } else {
            String sql = "INSERT INTO peliculas "
                    + "(Titulo, Duracion, IDDirector, Reparto, IDIdioma, Sinopsis, IDHorario, urlFoto, Foto)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                FileInputStream archivoImagen;
                PreparedStatement pst = cc.prepareStatement(sql);
                pst.setString(1, txtTitulo.getText());
                pst.setInt(2, Integer.parseInt(txtDuracion.getText()));
                pst.setInt(3, cbDirector.getSelectedIndex());
                pst.setString(4, txtReparto.getText());
                pst.setInt(5, cbIdiomas.getSelectedIndex());
                pst.setString(6, txtSinopsis.getText());
                pst.setInt(7, cbHorarios.getSelectedIndex());
                pst.setString(8, txtUrl.getText());
                archivoImagen = new FileInputStream(txtUrl.getText());
                pst.setBinaryStream(9, archivoImagen);

                int i = pst.executeUpdate();
                if(i>0){
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
               }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar guardar");
            }
        }
        /**
         * boolean guardo = true; dataPeli.setTitulo(txtTitulo.getText());
         * dataPeli.setDuracion(Integer.getInteger(txtDuracion.toString()));
         * if(cbDirector.getSelectedIndex()==0){
         * JOptionPane.showMessageDialog(null, "Debe seleccionar un director");
         * } else{ dataPeli.setDirector(cbDirector.getSelectedIndex()); }
         * dataPeli.setReparto(txtReparto.getText());
         * dataPeli.setSinopsis(txtSinopsis.getText());
         * if(cbIdiomas.getSelectedIndex()==0){
         * JOptionPane.showMessageDialog(null, "Debe seleccionar un idioma");
         * }else{ dataPeli.setIdioma(cbIdiomas.getSelectedIndex()); }
         * dataPeli.setUrl(txtUrl.getText());
         * if(cbHorarios.getSelectedIndex()==0){
         * JOptionPane.showMessageDialog(null, "Debe seleccionar un director");
         * }else{ dataPeli.setHorarios(cbHorarios.getSelectedIndex()); }
         *
         * try { guardo = dataPeli.guardar(); } catch (FileNotFoundException ex)
         * { Logger.getLogger(panelPeliculas.class.getName()).log(Level.SEVERE,
         * null, ex); } if(guardo == true){ JOptionPane.showMessageDialog(null,
         * "El producto ha sido agregado");
        }*
         */
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JEPG(*.JPG; *.JPEG)", "jpg", "jpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:\\Users\\Victor Reyes\\Documents\\Tareas a entregar\\Ingeniería de Software I\\Cinematix\\img\\portadas peliculas\\imagenes pequeñas");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            txtUrl.setText(String.valueOf(file));
            Image portada = getToolkit().getImage(txtUrl.getText());
            portada.getScaledInstance(178, 233, Image.SCALE_DEFAULT);
            labelFoto.setIcon(new ImageIcon(portada));
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        if (txtDuracion.getText().length() > 2) {
            evt.consume();
        }
        validarCaracteres(evt);
    }//GEN-LAST:event_txtDuracionKeyTyped

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        txtUrl.setEditable(false);
    }//GEN-LAST:event_txtUrlActionPerformed

    private void txtSinopsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSinopsisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSinopsisActionPerformed

    private void txtDuracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyReleased
        try {
            Integer.parseInt(txtDuracion.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Este campo es numérico");
            txtDuracion.setText("");
        }
        
        if (txtDuracion.getText().charAt(0) == ' ') {
            JOptionPane.showMessageDialog(null, "Omita poner espacios al principio");
            //txtDuracion.setText("");
        }
    }//GEN-LAST:event_txtDuracionKeyReleased

    datosPeliculas dataPeli = new datosPeliculas();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnEditar;
    private rojerusan.RSButtonHover btnEliminar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnImagen;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox<String> cbDirector;
    private javax.swing.JComboBox<String> cbHorarios;
    private javax.swing.JComboBox<String> cbIdiomas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbReparto;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbURL;
    private javax.swing.JTable tablaPeliculas;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JLabel txtLetras;
    private javax.swing.JTextField txtReparto;
    private javax.swing.JTextField txtSinopsis;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
