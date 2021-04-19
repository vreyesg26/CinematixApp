package Paneles;

import Datos.Conexion;
import JFrames.TextPrompt;
import Logica.datosPeliculas;
import Tipografia.Fuente;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
        bloquearCampos();
        anchoColumnas();
        cargarIdiomas();
        cargarHorarios();
        cargarDirectores();
        cargarGeneros();
        cargarSalas();
        txtUrl.setEnabled(false);
        txtIDPelicula.setVisible(false);
        tipoFuente = new Fuente();

        lbDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        lbUrl.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        txtDuracion.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtIDPelicula.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtTitulo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtSinopsis.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtReparto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtBuscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        txtUrl.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbDirector.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbIdiomas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbHorarios.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbGeneros.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        cbSalas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        tablaPeliculas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));

        btnImagen.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnGuardar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnActualizar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnDeshabilitar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));
        btnNuevo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 10));

        TextPrompt buscar = new TextPrompt("Buscar por ID o Título", txtBuscar);
        buscar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
    }

    void cargarIdiomas() {
        String sql = "SELECT Idioma FROM idiomas";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbIdiomas.addItem("Seleccione Idioma...");
            while (rs.next()) {
                cbIdiomas.addItem(rs.getString("Idioma"));
            }

        } catch (Exception e) {

        }
    }

    void cargarHorarios() {
        String sql = "SELECT Hora FROM horarios WHERE IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbHorarios.addItem("Seleccione Horario...");
            while (rs.next()) {
                cbHorarios.addItem(rs.getString("Hora"));
            }

        } catch (Exception e) {

        }
    }

    void cargarDirectores() {
        String sql = "SELECT Nombre FROM director WHERE IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbDirector.addItem("Seleccione Director...");
            while (rs.next()) {
                cbDirector.addItem(rs.getString("Nombre"));
            }

        } catch (Exception e) {

        }
    }

    void cargarGeneros() {
        String sql = "SELECT Genero FROM generos WHERE IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbGeneros.addItem("Seleccione Género...");
            while (rs.next()) {
                cbGeneros.addItem(rs.getString("Genero"));
            }

        } catch (Exception e) {

        }
    }

    void cargarSalas() {
        String sql = "SELECT Sala FROM salas";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            cbSalas.addItem("Seleccione Sala...");
            while (rs.next()) {
                cbSalas.addItem(rs.getString("Sala"));
            }

        } catch (Exception e) {

        }
    }

    public boolean aprobado = false;

    public void verificarCaracteresRepetidos(String cadena) {
        String patron = "^[A-Z]((([A-Za-zñÑáéíóúÁÉÍÓÚ ,.\\s])\\3?(?!\\3)))+$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(cadena);
        if (!comparador.matches()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Al parecer estás cometiendo alguno de estos errores:\n•Asegurate de iniciar el párrafo con letras mayúsculas\n•No utilices caracteres especiales ni números\n•No repitas letras de forma incorrecta", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            aprobado = false;
        } else {
            aprobado = true;
        }
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablaPeliculas.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(30);
        anchoColumnas.getColumn(1).setPreferredWidth(140);
        anchoColumnas.getColumn(2).setPreferredWidth(70);
        anchoColumnas.getColumn(3).setPreferredWidth(130);
        anchoColumnas.getColumn(4).setPreferredWidth(250);
        anchoColumnas.getColumn(5).setPreferredWidth(70);
        anchoColumnas.getColumn(6).setPreferredWidth(500);
        anchoColumnas.getColumn(7).setPreferredWidth(80);
        anchoColumnas.getColumn(8).setPreferredWidth(80);
        anchoColumnas.getColumn(9).setPreferredWidth(80);
        anchoColumnas.getColumn(10).setPreferredWidth(100);
        anchoColumnas.getColumn(11).setPreferredWidth(220);
        anchoColumnas.getColumn(12).setPreferredWidth(100);
    }

    void bloquearCampos() {
        txtIDPelicula.setEnabled(false);
        txtTitulo.setEnabled(false);
        txtDuracion.setEnabled(false);
        txtReparto.setEnabled(false);
        txtSinopsis.setEnabled(false);
        cbDirector.setEnabled(false);
        cbHorarios.setEnabled(false);
        cbIdiomas.setEnabled(false);
        cbGeneros.setEnabled(false);
        cbSalas.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnDeshabilitar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnImagen.setEnabled(false);
        tablaPeliculas.setEnabled(false);
    }

    boolean guardar = false;
    void validarCamposVacios() {
        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
        if (txtDuracion.getText().isEmpty() && txtLetras.getText().isEmpty() && txtReparto.getText().isEmpty()
                && txtSinopsis.getText().isEmpty() && txtTitulo.getText().isEmpty()
                && labelFoto.getIcon() == null && cbDirector.getSelectedIndex() == 0
                && cbHorarios.getSelectedIndex() == 0 && cbIdiomas.getSelectedIndex() == 0
                && cbGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo título", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtDuracion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo duración", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtReparto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo reparto", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (txtSinopsis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo sinopsis", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (labelFoto.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una imagen para la pelicula", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbDirector.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un director", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbIdiomas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un idioma", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbGeneros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un género", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbHorarios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un horario", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (cbSalas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una sala", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (lbTitulo.getForeground() != Color.WHITE || lbDuracion.getForeground() != Color.WHITE || lbReparto.getForeground() != Color.WHITE || lbSinopsis.getForeground() != Color.WHITE) {
            JOptionPane.showMessageDialog(null, "Debes corregir los errores para poder guardar este registro", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            guardar = true;
        }
    }

    void buscarData(String valor) {
        String[] titulos = {"ID", "Titulo", "Duración", "Director", "Reparto", "Idioma", "Sinopsis", "Horario", "Género", "Sala", "Foto", "URL", "Estado"};
        String[] registros = new String[13];
        String sql = "SELECT P.IdPelicula, P.Titulo, P.Duracion, D.Nombre, P.Reparto, I.Idioma, P.Sinopsis, H.Hora, G.Genero, S.Sala, P.Foto, P.urlFoto, E.Estado\n"
                + "FROM peliculas AS P \n"
                + "INNER JOIN director AS D ON P.IDDirector = D.IDDirector\n"
                + "INNER JOIN idiomas AS I ON P.IDIdioma = I.IDIdioma\n"
                + "INNER JOIN horarios AS H ON P.IDHorario = H.IDHorario\n"
                + "INNER JOIN generos AS G ON P.IDGenero = G.IDGenero\n"
                + "INNER JOIN salas AS S ON P.IDSalas = S.IDSalas\n"
                + "INNER JOIN estados AS E ON P.IDEstado = E.IDEstado\n"
                + "WHERE CONCAT (IdPelicula, ' ', Titulo) LIKE '%" + valor + "%'\n"
                + "ORDER BY P.IdPelicula";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdPelicula");
                registros[1] = rs.getString("Titulo");
                registros[2] = rs.getString("Duracion");
                registros[3] = rs.getString("Nombre");
                registros[4] = rs.getString("Reparto");
                registros[5] = rs.getString("Idioma");
                registros[6] = rs.getString("Sinopsis");
                registros[7] = rs.getString("Hora");
                registros[8] = rs.getString("Genero");
                registros[9] = rs.getString("Sala");
                registros[10] = rs.getString("Foto");
                registros[11] = rs.getString("urlFoto");
                registros[12] = rs.getString("Estado");
                model.addRow(registros);
            }

            tablaPeliculas.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void cargarData(String valor) {
        String[] titulos = {"ID", "Titulo", "Duración", "Director", "Reparto", "Idioma", "Sinopsis", "Horario", "Género", "Sala", "Foto", "URL", "Estado"};
        String[] registros = new String[13];

        String sql = "SELECT P.IdPelicula, P.Titulo, P.Duracion, D.Nombre, P.Reparto, I.Idioma, P.Sinopsis, H.Hora, G.Genero, S.Sala, P.Foto, P.urlFoto, E.Estado\n"
                + "FROM peliculas AS P \n"
                + "INNER JOIN director AS D ON P.IDDirector = D.IDDirector\n"
                + "INNER JOIN idiomas AS I ON P.IDIdioma = I.IDIdioma\n"
                + "INNER JOIN horarios AS H ON P.IDHorario = H.IDHorario\n"
                + "INNER JOIN generos AS G ON P.IDGenero = G.IDGenero\n"
                + "INNER JOIN salas AS S ON P.IDSalas = S.IDSalas\n"
                + "INNER JOIN estados AS E ON P.IDEstado = E.IDEstado\n"
                + "ORDER BY P.IdPelicula";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdPelicula");
                registros[1] = rs.getString("Titulo");
                registros[2] = rs.getString("Duracion");
                registros[3] = rs.getString("Nombre");
                registros[4] = rs.getString("Reparto");
                registros[5] = rs.getString("Idioma");
                registros[6] = rs.getString("Sinopsis");
                registros[7] = rs.getString("Hora");
                registros[8] = rs.getString("Genero");
                registros[9] = rs.getString("Sala");
                registros[10] = rs.getString("Foto");
                registros[11] = rs.getString("urlFoto");
                registros[12] = rs.getString("Estado");
                model.addRow(registros);
            }

            tablaPeliculas.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void limpiarCajas() {
        txtIDPelicula.setText("");
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtReparto.setText("");
        txtSinopsis.setText("");
        txtBuscar.setText("");
        txtUrl.setText("");
        cbDirector.setSelectedIndex(0);
        cbHorarios.setSelectedIndex(0);
        cbIdiomas.setSelectedIndex(0);
        cbGeneros.setSelectedIndex(0);
        cbSalas.setSelectedIndex(0);
        labelFoto.setIcon(null);
        tablaPeliculas.clearSelection();
        lbTitulo.setForeground(Color.WHITE);
        lbDuracion.setForeground(Color.WHITE);
        lbReparto.setForeground(Color.WHITE);
        lbSinopsis.setForeground(Color.WHITE);
    }

    public void validarNumerosLetras(java.awt.event.KeyEvent e) {
        if (e.getKeyChar() >= 33 && e.getKeyChar() <= 47
                || e.getKeyChar() >= 58 && e.getKeyChar() <= 64
                || e.getKeyChar() >= 91 && e.getKeyChar() <= 96
                || e.getKeyChar() >= 123 && e.getKeyChar() <= 129
                || e.getKeyChar() >= 145 && e.getKeyChar() <= 159
                || e.getKeyChar() >= 164 && e.getKeyChar() <= 238) {

            e.consume();
            JOptionPane.showMessageDialog(null, "Este campo no acepta caracteres especiales");
        }
    }

    public void validarSoloNumeros(String numero) {
        String patron = "^[1-9][0-9]([0-9]?)$";
        Pattern patt = Pattern.compile(patron);
        Matcher comparador = patt.matcher(numero);
        if (!comparador.matches()) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Este campo debe contener mínimo 2 números o máximo 3 del 1 al 9", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            aprobado = false;
        } else {
            aprobado = true;
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
        btnActualizar = new rojerusan.RSButtonHover();
        btnDeshabilitar = new rojerusan.RSButtonHover();
        btnNuevo = new rojerusan.RSButtonHover();
        lbReparto = new javax.swing.JLabel();
        txtReparto = new javax.swing.JTextField();
        cbHorarios = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        lbSinopsis = new javax.swing.JLabel();
        labelLupa = new javax.swing.JLabel();
        cbGeneros = new javax.swing.JComboBox<>();
        txtUrl = new javax.swing.JTextField();
        lbUrl = new javax.swing.JLabel();
        txtIDPelicula = new javax.swing.JTextField();
        cbSalas = new javax.swing.JComboBox<>();

        menuModificar.setText("Modificar");
        menuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuModificar);

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tablaPeliculas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaPeliculas.setComponentPopupMenu(jPopupMenu1);
        tablaPeliculas.setOpaque(false);
        tablaPeliculas.setRowHeight(30);
        tablaPeliculas.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaPeliculas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPeliculas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 445, 800, 240));

        txtLetras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PeliculasLT.png"))); // NOI18N
        add(txtLetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 6, 515, -1));

        labelFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(labelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 74, 192, 274));

        cbIdiomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbIdiomas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbIdiomas.setOpaque(false);
        cbIdiomas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbIdiomasFocusGained(evt);
            }
        });
        add(cbIdiomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 135, 206, 35));

        cbDirector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbDirector.setOpaque(false);
        cbDirector.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbDirectorFocusGained(evt);
            }
        });
        add(cbDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 74, 206, 35));

        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtTitulo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTitulo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTitulo.setOpaque(false);
        txtTitulo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 74, 158, 35));

        txtSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        txtSinopsis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtSinopsis.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSinopsis.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSinopsis.setOpaque(false);
        txtSinopsis.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSinopsis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSinopsisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSinopsisFocusLost(evt);
            }
        });
        txtSinopsis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSinopsisKeyTyped(evt);
            }
        });
        add(txtSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 198, 326, 59));

        txtDuracion.setForeground(new java.awt.Color(255, 255, 255));
        txtDuracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtDuracion.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDuracion.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtDuracion.setOpaque(false);
        txtDuracion.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDuracion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDuracionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDuracionFocusLost(evt);
            }
        });
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });
        add(txtDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 74, 150, 35));

        lbDuracion.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbDuracion.setForeground(new java.awt.Color(255, 255, 255));
        lbDuracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDuracion.setText("DURACIÓN");
        add(lbDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 115, 150, -1));

        lbTitulo.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("TITULO");
        add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 115, 158, -1));

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
        add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 365, 192, 35));

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
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 365, 132, 35));

        btnActualizar.setBackground(new java.awt.Color(81, 81, 81));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoActualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setColorHover(new java.awt.Color(61, 61, 61));
        btnActualizar.setFocusable(false);
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 365, 132, 35));

        btnDeshabilitar.setBackground(new java.awt.Color(81, 81, 81));
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoDeshabilitar.png"))); // NOI18N
        btnDeshabilitar.setText("DESHABILITAR");
        btnDeshabilitar.setBorderPainted(false);
        btnDeshabilitar.setColorHover(new java.awt.Color(61, 61, 61));
        btnDeshabilitar.setFocusable(false);
        btnDeshabilitar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshabilitarActionPerformed(evt);
            }
        });
        add(btnDeshabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 365, 132, 35));

        btnNuevo.setBackground(new java.awt.Color(81, 81, 81));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoNuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setColorHover(new java.awt.Color(61, 61, 61));
        btnNuevo.setFocusable(false);
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 365, 132, 35));

        lbReparto.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbReparto.setForeground(new java.awt.Color(255, 255, 255));
        lbReparto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReparto.setText("REPARTO");
        add(lbReparto, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 176, 326, 16));

        txtReparto.setForeground(new java.awt.Color(255, 255, 255));
        txtReparto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReparto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtReparto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtReparto.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtReparto.setOpaque(false);
        txtReparto.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtReparto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRepartoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRepartoFocusLost(evt);
            }
        });
        txtReparto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepartoKeyTyped(evt);
            }
        });
        add(txtReparto, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 135, 326, 35));

        cbHorarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(61, 61, 61)));
        cbHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbHorarios.setOpaque(false);
        cbHorarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbHorariosFocusGained(evt);
            }
        });
        add(cbHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 255, 206, 35));

        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setOpaque(false);
        txtBuscar.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 232, 29));

        lbSinopsis.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        lbSinopsis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSinopsis.setText("SINOPSIS");
        add(lbSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 263, 326, 16));

        labelLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoBuscar.png"))); // NOI18N
        add(labelLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 410, -1, 29));

        cbGeneros.setOpaque(false);
        cbGeneros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbGenerosFocusGained(evt);
            }
        });
        add(cbGeneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 198, 206, 35));

        txtUrl.setForeground(new java.awt.Color(255, 255, 255));
        txtUrl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUrl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtUrl.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUrl.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtUrl.setOpaque(false);
        txtUrl.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 285, 326, 35));

        lbUrl.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lbUrl.setForeground(new java.awt.Color(255, 255, 255));
        lbUrl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUrl.setText("URL");
        add(lbUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 326, 326, -1));

        txtIDPelicula.setForeground(new java.awt.Color(255, 255, 255));
        txtIDPelicula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDPelicula.setOpaque(false);
        add(txtIDPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 31, 25, 25));

        cbSalas.setOpaque(false);
        cbSalas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbSalasFocusGained(evt);
            }
        });
        add(cbSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 315, 206, 35));
    }// </editor-fold>//GEN-END:initComponents


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if (!guardar == false) {
            String sql = "INSERT INTO peliculas\n"
                    + "(Titulo, Duracion, IDDirector, Reparto, IDIdioma, Sinopsis, IDHorario, IDGenero, IDSalas, Foto, urlFoto)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
                pst.setInt(9, cbSalas.getSelectedIndex());
                archivoImagen = new FileInputStream(txtUrl.getText());
                pst.setBinaryStream(10, archivoImagen);
                pst.setString(11, txtUrl.getText());

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro se guardó satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    limpiarCajas();
                    bloquearCampos();
                    btnImagen.setEnabled(false);
                    btnDeshabilitar.setEnabled(false);
                    btnActualizar.setEnabled(false);
                    tablaPeliculas.setEnabled(false);
                    cargarData("");
                    btnNuevo.setEnabled(true);
                }

            } catch (Exception e) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "Hubo un error al intentar guardar el registro", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Conexion cn = new Conexion();
        Connection cc = cn.GetConexion();
        validarCamposVacios();
        if (guardar != false) {
            String sql = "UPDATE peliculas SET Titulo = ?, Duracion = ?, IDDirector = ?, "
                    + "Reparto = ?, IDIdioma = ?, Sinopsis = ?, IDHorario = ?, "
                    + "IDGenero = ?, IDSalas = ?, Foto = ?, urlFoto = ?"
                    + "WHERE IdPelicula = '" + txtIDPelicula.getText() + "'";

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
                pst.setInt(9, cbSalas.getSelectedIndex());
                archivoImagen = new FileInputStream(txtUrl.getText());
                pst.setBinaryStream(10, archivoImagen);
                pst.setString(11, txtUrl.getText());

                int i = pst.executeUpdate();
                if (i > 0) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "El registro se actualizó satisfactoriamente", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    limpiarCajas();
                    btnGuardar.setEnabled(false);
                    btnNuevo.setEnabled(true);
                    btnImagen.setEnabled(false);
                    btnDeshabilitar.setEnabled(false);
                    btnActualizar.setEnabled(false);
                    tablaPeliculas.setEnabled(false);
                    bloquearCampos();
                    cargarData("");

                    ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                    btnDeshabilitar.setIcon(iconobtn);
                    btnDeshabilitar.setText("DESHABILITAR");
                }

            } catch (Exception e) {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar actualizar el registro", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshabilitarActionPerformed
        int fila = tablaPeliculas.getSelectedRow();
        String habilitado = "1";
        String deshabilitado = "2";

        if (btnDeshabilitar.getText().equals("CANCELAR")) {
            limpiarCajas();
            btnActualizar.setEnabled(false);
            btnNuevo.setEnabled(false);
            btnDeshabilitar.setEnabled(false);
            btnGuardar.setEnabled(true);
            txtTitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            txtDuracion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            txtReparto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            txtSinopsis.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
            btnDeshabilitar.setIcon(iconobtn);
            btnDeshabilitar.setText("DESHABILITAR");
        } else if (fila >= 0) {
            String id = tablaPeliculas.getValueAt(fila, 0).toString();
            String pelicula = tablaPeliculas.getValueAt(fila, 1).toString();

            if (btnDeshabilitar.getText().equals("CANCELAR")) {
                limpiarCajas();
                btnActualizar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnDeshabilitar.setEnabled(false);
                btnGuardar.setEnabled(true);
                txtTitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                txtDuracion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                txtReparto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                txtSinopsis.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

                ImageIcon iconobtn2 = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnDeshabilitar.setIcon(iconobtn2);
                btnDeshabilitar.setText("DESHABILITAR");

            } else if (btnDeshabilitar.getText().equals("DESHABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas deshabilitar esta pelicula?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `peliculas` SET `IDEstado` = ? WHERE `peliculas`.`IdPelicula` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, deshabilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "La pelicula " + pelicula + " ha sido deshabilitada", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                        cargarData("");
                    } catch (Exception e) {

                    }
                }
            } else if (btnDeshabilitar.getText().equals("HABILITAR")) {
                ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoPregunta.png");
                int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas habilitar esta pelicula?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                if (ventanaConfirmacion == 0) {
                    try {
                        String sqlEstado = "UPDATE `peliculas` SET `IDEstado` = ? WHERE `peliculas`.`IdPelicula` = ? ";
                        PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sqlEstado);
                        pst.setString(1, habilitado);
                        pst.setString(2, id);
                        pst.execute();

                        ImageIcon jPanelIcon2 = new ImageIcon("src/iconos/iconoCorrecto.png");
                        JOptionPane.showMessageDialog(null, "La pelicula " + pelicula + " ahora está habilitada", "Confirmación", JOptionPane.PLAIN_MESSAGE, jPanelIcon2);
                        cargarData("");
                    } catch (Exception e) {

                    }
                }
            }
        }
        limpiarCajas();
        bloquearCampos();
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnDeshabilitarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JEPG(*.JPG; *.JPEG)", "jpg", "jpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Archivo");
        File ruta = new File("C:\\Users\\Victor Reyes\\Documents\\Tareas a entregar\\Ingeniería de Software I\\Cinematix\\img\\portadas peliculas");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            txtUrl.setText(String.valueOf(file));
            Image portada = getToolkit().getImage(txtUrl.getText());
            portada.getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_SMOOTH);
            labelFoto.setIcon(new ImageIcon(portada));

            rsscalelabel.RSScaleLabel.setScaleLabel(labelFoto, txtUrl.getText());
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        validarNumerosLetras(evt);
        buscarData(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtRepartoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepartoKeyTyped

    }//GEN-LAST:event_txtRepartoKeyTyped

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        if (txtDuracion.getText().length() > 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDuracionKeyTyped

    void modificarRegistro() {
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnDeshabilitar.setEnabled(true);

        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
        int fila = tablaPeliculas.getSelectedRow();

        if (fila >= 0) {
            String id = tablaPeliculas.getValueAt(fila, 0).toString();
            String titulo = tablaPeliculas.getValueAt(fila, 1).toString();
            String duracion = tablaPeliculas.getValueAt(fila, 2).toString();
            String director = tablaPeliculas.getValueAt(fila, 3).toString();
            String reparto = tablaPeliculas.getValueAt(fila, 4).toString();
            String idioma = tablaPeliculas.getValueAt(fila, 5).toString();
            String sinopsis = tablaPeliculas.getValueAt(fila, 6).toString();
            String horario = tablaPeliculas.getValueAt(fila, 7).toString();
            String genero = tablaPeliculas.getValueAt(fila, 8).toString();
            String sala = tablaPeliculas.getValueAt(fila, 9).toString();
            String url = tablaPeliculas.getValueAt(fila, 11).toString();

            txtIDPelicula.setText(id);
            txtTitulo.setText(titulo);
            txtDuracion.setText(duracion);
            txtReparto.setText(reparto);
            txtSinopsis.setText(sinopsis);
            /*if (director.contains("Mel Gibson")) {
                cbDirector.setSelectedIndex(1);
            } else if (director.contains("Martin Scorsese")) {
                cbDirector.setSelectedIndex(2);
            } else if (director.contains("David Lynch")) {
                cbDirector.setSelectedIndex(3);
            } else if (director.contains("Federico Fellini")) {
                cbDirector.setSelectedIndex(4);
            } else if (director.contains("Stanley Kubrick")) {
                cbDirector.setSelectedIndex(5);
            } else if (director.contains("Steven Spielberg")) {
                cbDirector.setSelectedIndex(6);
            } else if (director.contains("Quentin Tarantino")) {
                cbDirector.setSelectedIndex(7);
            } else if (director.contains("Ingmar Bergman")) {
                cbDirector.setSelectedIndex(8);
            } else if (director.contains("Francis Ford Coppola")) {
                cbDirector.setSelectedIndex(9);
            } else if (director.contains("Alfred Hitchcock")) {
                cbDirector.setSelectedIndex(10);
            }

            if (idioma.contains("Español")) {
                cbIdiomas.setSelectedIndex(1);
            } else if (idioma.contains("Inglés")) {
                cbIdiomas.setSelectedIndex(2);
            }

            if (horario.contains("09:00am")) {
                cbHorarios.setSelectedIndex(1);
            } else if (horario.contains("10:00am")) {
                cbHorarios.setSelectedIndex(2);
            } else if (horario.contains("11:00am")) {
                cbHorarios.setSelectedIndex(3);
            } else if (horario.contains("12:00pm")) {
                cbHorarios.setSelectedIndex(4);
            } else if (horario.contains("01:00pm")) {
                cbHorarios.setSelectedIndex(5);
            } else if (horario.contains("02:00pm")) {
                cbHorarios.setSelectedIndex(6);
            } else if (horario.contains("03:00pm")) {
                cbHorarios.setSelectedIndex(7);
            } else if (horario.contains("04:00pm")) {
                cbHorarios.setSelectedIndex(8);
            } else if (horario.contains("05:00pm")) {
                cbHorarios.setSelectedIndex(9);
            } else if (horario.contains("06:00pm")) {
                cbHorarios.setSelectedIndex(10);
            } else if (horario.contains("07:00pm")) {
                cbHorarios.setSelectedIndex(11);
            } else if (horario.contains("08:00pm")) {
                cbHorarios.setSelectedIndex(12);
            } else if (horario.contains("09:00pm")) {
                cbHorarios.setSelectedIndex(13);
            } else if (horario.contains("10:00pm")) {
                cbHorarios.setSelectedIndex(14);
            }

            if (genero.contains("Acción")) {
                cbGeneros.setSelectedIndex(1);
            } else if (genero.contains("Aventura")) {
                cbGeneros.setSelectedIndex(2);
            } else if (genero.contains("Comedia")) {
                cbGeneros.setSelectedIndex(3);
            } else if (genero.contains("Drama")) {
                cbGeneros.setSelectedIndex(4);
            } else if (genero.contains("Terror")) {
                cbGeneros.setSelectedIndex(5);
            } else if (genero.contains("Ciencia Ficción")) {
                cbGeneros.setSelectedIndex(6);
            } else if (genero.contains("Suspenso")) {
                cbGeneros.setSelectedIndex(7);
            }*/

            cbIdiomas.setSelectedItem(idioma);
            cbDirector.setSelectedItem(director);
            cbHorarios.setSelectedItem(horario);
            cbGeneros.setSelectedItem(genero);
            cbSalas.setSelectedItem(sala);
            txtUrl.setText(url);
//            Image foto = getToolkit().getImage(url);
//            foto = foto.getScaledInstance(192, 274, 1);
//            labelFoto.setIcon(new ImageIcon(foto));

            String sql = "SELECT Foto FROM peliculas WHERE IdPelicula = " + id;

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    Image i = null;

                    Blob blob = rs.getBlob("Foto");
                    i = javax.imageio.ImageIO.read(blob.getBinaryStream());
                    ImageIcon image = new ImageIcon(i.getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_DEFAULT));
                    labelFoto.setIcon(image);
                    this.repaint();
                }
            } catch (Exception e) {
            }

        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }

    private void menuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarActionPerformed
        if (!txtTitulo.getText().isEmpty() || !txtDuracion.getText().isEmpty() || cbDirector.getSelectedIndex() != 0
                || !txtReparto.getText().isEmpty() || cbIdiomas.getSelectedIndex() != 0 || !txtSinopsis.getText().isEmpty()
                || cbGeneros.getSelectedIndex() != 0 || cbHorarios.getSelectedIndex() != 0 || cbSalas.getSelectedIndex() != 0
                || !txtUrl.getText().isEmpty() || labelFoto.getIcon() != null) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
            int decision = JOptionPane.showConfirmDialog(null, "Los datos aún no se han guardado y podrían perderse\n "
                    + "¿Seguro que desea entrar en modo edición?", "Confirmación", JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            if (decision == 0) {
                modificarRegistro();
            }
        } else {
            modificarRegistro();
        }
    }//GEN-LAST:event_menuModificarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        buscarData(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
        txtIDPelicula.setEnabled(true);
        txtTitulo.setEnabled(true);
        txtDuracion.setEnabled(true);
        txtReparto.setEnabled(true);
        txtSinopsis.setEnabled(true);
        cbDirector.setEnabled(true);
        cbHorarios.setEnabled(true);
        cbIdiomas.setEnabled(true);
        cbGeneros.setEnabled(true);
        cbSalas.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnDeshabilitar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnImagen.setEnabled(true);
        tablaPeliculas.setEnabled(true);
        ImageIcon iconoBoton = new ImageIcon("src/iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconoBoton);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtSinopsisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSinopsisKeyTyped

    }//GEN-LAST:event_txtSinopsisKeyTyped

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        if (!txtTitulo.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtTitulo.getText());
            if (aprobado != false) {
                if (txtTitulo.getText().length() < 4) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "Titulo debe contener al menos 4 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    txtTitulo.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                    lbTitulo.setForeground(new Color(176, 3, 3));
                } else {
                    Conexion cc = new Conexion();
                    Connection cn = cc.GetConexion();
                    String titulo = txtTitulo.getText();
                    String sql = "SELECT Titulo FROM peliculas WHERE Titulo = '" + titulo + "'";

                    try {
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery(sql);

                        if (rs.next()) {
                            if (rs.getString("Titulo").equals(titulo)) {
                                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
                                JOptionPane.showMessageDialog(null, "Esta pelicula ya está almacenada", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                                txtTitulo.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                                lbTitulo.setForeground(new Color(176, 3, 3));
                            }
                        } else {
                            txtTitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                            lbTitulo.setForeground(Color.WHITE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se pudo verificar\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                txtTitulo.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                lbTitulo.setForeground(new Color(176, 3, 3));
            }
        } else {
            txtTitulo.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            lbTitulo.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtTituloFocusLost

    private void txtDuracionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDuracionFocusLost
        if (!txtDuracion.getText().isEmpty()) {
            validarSoloNumeros(txtDuracion.getText());
            if (aprobado != true) {
                txtDuracion.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                lbDuracion.setForeground(new Color(176, 3, 3));
            } else {
                txtDuracion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                lbDuracion.setForeground(Color.WHITE);
            }
        } else {
            txtDuracion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            lbDuracion.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtDuracionFocusLost

    private void txtRepartoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepartoFocusLost
        if (!txtReparto.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtReparto.getText());
            if (aprobado != false) {
                if (txtReparto.getText().length() < 10) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El campo reparto debe contener un mínimo de 10 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    txtReparto.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                    lbReparto.setForeground(new Color(176, 3, 3));
                } else {
                    txtReparto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    lbReparto.setForeground(Color.WHITE);
                }
            } else {
                txtReparto.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                lbReparto.setForeground(new Color(176, 3, 3));
            }
        } else {
            txtReparto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            lbReparto.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtRepartoFocusLost

    private void txtSinopsisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSinopsisFocusLost
        if (!txtSinopsis.getText().isEmpty()) {
            verificarCaracteresRepetidos(txtSinopsis.getText());
            if (aprobado != false) {
                if (txtSinopsis.getText().length() < 15) {
                    ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoError.png");
                    JOptionPane.showMessageDialog(null, "El campo sinopsis debe contener un mínimo de 15 caracteres", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    txtSinopsis.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                    lbSinopsis.setForeground(new Color(176, 3, 3));
                } else {
                    txtSinopsis.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    lbSinopsis.setForeground(Color.WHITE);
                }
            } else {
                txtSinopsis.setBorder(BorderFactory.createLineBorder(new Color(176, 3, 3), 2));
                lbSinopsis.setForeground(new Color(176, 3, 3));
            }
        } else {
            txtSinopsis.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            lbSinopsis.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtSinopsisFocusLost

    private void tablaPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPeliculasMouseClicked
        int fila = tablaPeliculas.getSelectedRow();
        if (fila >= 0) {
            btnDeshabilitar.setEnabled(true);
            String estado = tablaPeliculas.getValueAt(fila, 12).toString();

            if ("Habilitado".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoDeshabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("DESHABILITAR");
            } else if ("Deshabilitado".equals(estado)) {
                ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoHabilitar.png");
                btnDeshabilitar.setIcon(iconobtn);
                btnDeshabilitar.setText("HABILITAR");
            }
        }
    }//GEN-LAST:event_tablaPeliculasMouseClicked

    private void txtTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtTituloFocusGained

    private void txtDuracionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDuracionFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtDuracionFocusGained

    private void txtRepartoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRepartoFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtRepartoFocusGained

    private void txtSinopsisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSinopsisFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_txtSinopsisFocusGained

    private void cbDirectorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbDirectorFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbDirectorFocusGained

    private void cbIdiomasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbIdiomasFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbIdiomasFocusGained

    private void cbGenerosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbGenerosFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbGenerosFocusGained

    private void cbHorariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbHorariosFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbHorariosFocusGained

    private void cbSalasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbSalasFocusGained
        ImageIcon iconobtn = new ImageIcon("src/Iconos/iconoCancelar.png");
        btnDeshabilitar.setIcon(iconobtn);
        btnDeshabilitar.setText("CANCELAR");
    }//GEN-LAST:event_cbSalasFocusGained

    datosPeliculas dataPeli = new datosPeliculas();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizar;
    private rojerusan.RSButtonHover btnDeshabilitar;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnImagen;
    private rojerusan.RSButtonHover btnNuevo;
    private javax.swing.JComboBox<String> cbDirector;
    private javax.swing.JComboBox<String> cbGeneros;
    private javax.swing.JComboBox<String> cbHorarios;
    private javax.swing.JComboBox<String> cbIdiomas;
    private javax.swing.JComboBox<String> cbSalas;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelLupa;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbReparto;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JMenuItem menuModificar;
    private javax.swing.JTable tablaPeliculas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtIDPelicula;
    private javax.swing.JLabel txtLetras;
    private javax.swing.JTextField txtReparto;
    private javax.swing.JTextField txtSinopsis;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
