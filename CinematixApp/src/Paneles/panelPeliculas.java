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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

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
        cargarData("");
        tipoFuente = new Fuente();

        lbDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        txtDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtBuscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbIdiomas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbHorarios.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbGeneros.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
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
                && labelFoto.getIcon() == null && cbDirector.getSelectedIndex() == 0
                && cbHorarios.getSelectedIndex() == 0 && cbIdiomas.getSelectedIndex() == 0 
                && cbGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo título");
        } else if (txtDuracion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo duración");
        } else if (txtReparto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo reparto");
        } else if (txtSinopsis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo sinopsis");
        } else if (labelFoto.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una imagen para la pelicula");
        } else if (cbDirector.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un director");
        } else if (cbIdiomas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un idioma");
        } else if (cbGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un género");
        } else if (cbHorarios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un horario");
        }else{
            guardar = true;
        }
    }
    
    void buscarData(String valor){
        String[] titulos = {"ID", "Titulo", "Duración", "Director", "Reparto", "Idioma", "Sinopsis", "Horario", "Género", "Foto"};
        String[] registros = new String[10];
        String sql = "SELECT * FROM peliculas WHERE CONCAT (IdPelicula, ' ', Titulo) LIKE '%" + valor + "%'";
        
        model = new DefaultTableModel(null, titulos);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("IdPelicula");
                registros[1] = rs.getString("Titulo");
                registros[2] = rs.getString("Duracion");
                registros[3] = rs.getString("IDDirector");
                registros[4] = rs.getString("Reparto");
                registros[5] = rs.getString("IDIdioma");
                registros[6] = rs.getString("Sinopsis");
                registros[7] = rs.getString("IDHorario");
                registros[8] = rs.getString("IDGenero");
                registros[9] = rs.getString("Foto");
                model.addRow(registros);
            }
            
            tablaPeliculas.setModel(model);
        } catch (SQLException ex){
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();
    
    void cargarData(String valor){
        String[] titulos = {"ID", "Titulo", "Duración", "Director", "Reparto", "Idioma", "Sinopsis", "Horario", "Género", "Foto"};
        String[] registros = new String[10];
        String sql = "SELECT IdPelicula, Titulo, Duracion, Nombre, Reparto, Tipo, Sinopsis, Hora, TipoGenero, Foto\n"
                + "                FROM peliculas INNER JOIN director USING (IDDirector)\n"
                + "                INNER JOIN idiomas USING (IDIdioma)\n"
                + "                INNER JOIN horarios USING (IDHorario)\n"
                + "                INNER JOIN generos USING (IDGenero)\n"
                + "                WHERE IdPelicula != 0 ORDER BY IdPelicula";
        
        /**String sql = "SELECT P.IdPelicula, P.Titulo, P.Duracion, D.Nombre, P.Reparto, I.Tipo, P.Sinopsis, H.Hora, G.TipoGenero, P.Foto \n"
                + "FROM peliculas AS P INNER JOIN director AS D ON P.IDDirector = D.IDDirector \n"
                + "INNER JOIN idiomas AS I ON P.IDIdioma = I.IDIdioma \n"
                + "INNER JOIN horarios AS H ON P.IDHorario = H.IDHorario \n"
                + "INNER JOIN generos AS G ON P.IDGenero = G.IDGenero \n"
                + "WHERE P.IdPelicula != 0 ORDER BY P.IdPelicula";**/
        
        
        model = new DefaultTableModel(null, titulos);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registros[0] = rs.getString("IdPelicula");
                registros[1] = rs.getString("Titulo");
                registros[2] = rs.getString("Duracion");
                registros[3] = rs.getString("Nombre");
                registros[4] = rs.getString("Reparto");
                registros[5] = rs.getString("Tipo");
                registros[6] = rs.getString("Sinopsis");
                registros[7] = rs.getString("Hora");
                registros[8] = rs.getString("TipoGenero");
                registros[9] = rs.getString("Foto");
                model.addRow(registros);
            }
            
            tablaPeliculas.setModel(model);
        } catch (SQLException ex){
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void limpiarCajas() {
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtReparto.setText("");
        txtSinopsis.setText("");
        txtBuscar.setText("");
        cbDirector.setSelectedIndex(0);
        cbHorarios.setSelectedIndex(0);
        cbIdiomas.setSelectedIndex(0);
        cbGeneros.setSelectedIndex(0);
        labelFoto.setIcon(null);
    }

    public void validarNumerosLetras(java.awt.event.KeyEvent e) {
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
    
    public void validarSoloNumeros(java.awt.event.KeyEvent e){
        if(e.getKeyChar() >= 32 && e.getKeyChar() <= 47 || e.getKeyChar() >= 58 && e.getKeyChar() <= 255){
            e.consume();
            JOptionPane.showMessageDialog(null, "Este campo solo admite números");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuModificar = new javax.swing.JMenuItem();
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
        txtBuscar = new javax.swing.JTextField();
        lbSinopsis = new javax.swing.JLabel();
        labelLupa = new javax.swing.JLabel();
        cbGeneros = new javax.swing.JComboBox<>();

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

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
        tablaPeliculas.setSelectionForeground(new java.awt.Color(255, 255, 255));
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
        cbDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDirectorActionPerformed(evt);
            }
        });

        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setOpaque(false);
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
            }
        });

        txtSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        txtSinopsis.setOpaque(false);

        txtDuracion.setForeground(new java.awt.Color(255, 255, 255));
        txtDuracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuracion.setOpaque(false);
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
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
        txtReparto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepartoKeyTyped(evt);
            }
        });

        cbHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Horario...", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm", "10:00pm" }));
        cbHorarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbHorarios.setOpaque(false);
        cbHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHorariosActionPerformed(evt);
            }
        });

        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setOpaque(false);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        lbSinopsis.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        lbSinopsis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSinopsis.setText("SINOPSIS");

        labelLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoBuscar.png"))); // NOI18N

        cbGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Género...", "Acción ", "Aventura", "Comedia", "Drama", "Terror", "Ciencia Ficción", "Suspenso" }));
        cbGeneros.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(labelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelLupa)
                            .addGap(2, 2, 2)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(276, 276, 276)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbIdiomas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addComponent(txtLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLetras)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbIdiomas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSinopsis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLupa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Variable que almacenará la URL de las fotos
    String url;
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if(guardar == false){
            
        } else {
            String sql = "INSERT INTO peliculas "
                    + "(Titulo, Duracion, IDDirector, Reparto, IDIdioma, Sinopsis, IDHorario, IDGenero, Foto)"
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
                pst.setInt(8, cbGeneros.getSelectedIndex());
                //pst.setString(9, txtUrl.getText());
                archivoImagen = new FileInputStream(url);
                pst.setBinaryStream(9, archivoImagen);

                int i = pst.executeUpdate();
                if(i>0){
                JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                limpiarCajas();
                cargarData("");
               }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar guardar");
                System.out.println(e.getMessage());
            }
        }
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
            url = (String.valueOf(file));
            Image portada = getToolkit().getImage(url);
            portada.getScaledInstance(178, 233, Image.SCALE_DEFAULT);
            labelFoto.setIcon(new ImageIcon(portada));
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        validarNumerosLetras(evt);
        buscarData(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        validarNumerosLetras(evt);
    }//GEN-LAST:event_txtTituloKeyTyped

    private void txtRepartoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepartoKeyTyped

    }//GEN-LAST:event_txtRepartoKeyTyped

    private void cbHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHorariosActionPerformed

    private void cbDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDirectorActionPerformed

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        if (txtDuracion.getText().length() > 2) {
            evt.consume();
        }
        validarSoloNumeros(evt);
    }//GEN-LAST:event_txtDuracionKeyTyped

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        int fila = tablaPeliculas.getSelectedRow();
  
        if(fila>=0){   
            String titulo = tablaPeliculas.getValueAt(fila, 0).toString();
            String duracion = tablaPeliculas.getValueAt(fila, 1).toString();
            String director = tablaPeliculas.getValueAt(fila, 2).toString();
            String reparto = tablaPeliculas.getValueAt(fila, 3).toString();
            String idioma = tablaPeliculas.getValueAt(fila, 4).toString();
            String sinopsis = tablaPeliculas.getValueAt(fila, 5).toString();
            String horario = tablaPeliculas.getValueAt(fila, 6).toString();
            String genero = tablaPeliculas.getValueAt(fila, 7).toString();
            String foto = tablaPeliculas.getValueAt(fila, 8).toString();
            
            
            txtTitulo.setText(titulo);
            txtDuracion.setText(duracion);
            if(director.contains("Mel Gibson")){
                cbDirector.setSelectedIndex(1);
            } else if(director.contains("Martin Scorsese")){
                cbDirector.setSelectedIndex(2);
            } else if(director.contains("David Lynch")){
                cbDirector.setSelectedIndex(3);
            } else if(director.contains("Federico Fellini")){
                cbDirector.setSelectedIndex(4);
            } else if(director.contains("Stanley Kubrick")){
                cbDirector.setSelectedIndex(5);
            } else if(director.contains("Steven Spielberg")){
                cbDirector.setSelectedIndex(6);
            } else if(director.contains("Quentin Tarantino")){
                cbDirector.setSelectedIndex(7);
            } else if(director.contains("Ingmar Bergman")){
                cbDirector.setSelectedIndex(8);
            } else if(director.contains("Francis Ford Coppola")){
                cbDirector.setSelectedIndex(9);
            } else if(director.contains("Alfred Hitchcock")){
                cbDirector.setSelectedIndex(10);
            }
            txtReparto.setText(reparto);
            if(idioma.contains("Español")){
                cbIdiomas.setSelectedIndex(1);
            } else if(idioma.contains("Inglés")){
                cbIdiomas.setSelectedIndex(2);
            }
            txtSinopsis.setText(sinopsis);
        }
        else {
           JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    datosPeliculas dataPeli = new datosPeliculas();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnEditar;
    private rojerusan.RSButtonHover btnEliminar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnImagen;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox<String> cbDirector;
    private javax.swing.JComboBox<String> cbGeneros;
    private javax.swing.JComboBox<String> cbHorarios;
    private javax.swing.JComboBox<String> cbIdiomas;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelLupa;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbReparto;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTable tablaPeliculas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JLabel txtLetras;
    private javax.swing.JTextField txtReparto;
    private javax.swing.JTextField txtSinopsis;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
