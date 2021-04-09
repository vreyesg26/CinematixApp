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
import java.awt.event.KeyEvent;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class MenuVendedor extends javax.swing.JFrame {

    /**
     * Creates new form MenuVendedor
     */
    Fuente tipoFuente;

    public MenuVendedor() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        super.setTitle("Menú CineMatix");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        btnContinuar.setEnabled(false);
        txtBoletosAdultos.setEditable(false);
        txtBoletosNiños.setEditable(false);
        Desactivados();

        tipoFuente = new Fuente();
        lb1.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb2.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb6.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 20));
        lb7.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 20));
        lb8.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb9.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb10.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb11.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 20));
        lb12.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 20));
        lb13.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb14.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb15.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb16.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb17.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        lb18.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 20));
        lbMenores.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb_Encender.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        lbVendedor.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jComboBoxPeliculas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        jComboBoxHora.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 14));
        btnContinuar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));

        rbEfectivo.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        rbMixto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        rbTCredito.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));

        lbResultado.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));

        txtBoletosAdultos.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        txtBoletosNiños.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/cinematixLogo.png"));
        return retValue;
    }

    void Encender() {
        if (btnEncendido.isSelected()) {
            lb_Encender.setText("APAGAR");
            jComboBoxPeliculas.setEnabled(true);
            jComboBoxHora.setEnabled(true);
            AgregarAComboboxPelicula();
            Horarios();
        } else {
            lb_Encender.setText("ENCENDER");
            jComboBoxPeliculas.setEnabled(false);
            jComboBoxHora.setEnabled(false);
            limpiar();
            Desactivados();
        }
    }

    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void consultarSala() {
        int indexPelicula = jComboBoxPeliculas.getSelectedIndex();
        String sql = "SELECT Sala\n"
                + "FROM salas\n"
                + "INNER JOIN peliculas USING (IDSalas)\n"
                + "WHERE IdPelicula = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String sala = rs.getString("Sala");
                System.out.println(sala);
                lb8.setText(sala);
            }

        } catch (Exception e) {

        }
    }

    void consultarPrecios() {
        String sql = "SELECT PrecioBoletoAdulto, PrecioBoletoNino FROM salas WHERE Sala = '" + lb8.getText() + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String boletoAdulto = rs.getString("PrecioBoletoAdulto");
                String boletoNiño = rs.getString("PrecioBoletoNino");
                lb9.setText("L. " + boletoAdulto);
                lb10.setText("L. " + boletoNiño);
            }

        } catch (Exception e) {

        }
    }

    void Desactivados() {
        jComboBoxPeliculas.setEnabled(false);
        jComboBoxHora.setEnabled(false);
        rbEfectivo.setEnabled(false);
        rbTCredito.setEnabled(false);
        rbMixto.setEnabled(false);
        btnMas.setEnabled(false);
        btnMenos.setEnabled(false);
        btnMas1.setEnabled(false);
        btnMenos1.setEnabled(false);
        btnContinuar.setEnabled(false);
    }

    void Activar() {
        rbEfectivo.setEnabled(true);
        rbTCredito.setEnabled(true);
        rbMixto.setEnabled(true);
        btnMas.setEnabled(true);
        btnMenos.setEnabled(true);
        btnMas1.setEnabled(true);
        btnMenos1.setEnabled(true);
        btnContinuar.setEnabled(true);
        txtBoletosAdultos.setText(String.valueOf(contadorAdultos));
        txtBoletosNiños.setText(String.valueOf(contadorNiños));
    }

    /* ResultSet rs;
    PreparedStatement Pst;
    DefaultComboBoxModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();*/
    public static void AgregarAComboboxPelicula() {
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        String sql = "SELECT Titulo FROM peliculas WHERE IDEstado = 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            jComboBoxPeliculas.addItem("Seleccione una pelicula");
            while (rs.next()) {

                jComboBoxPeliculas.addItem(rs.getString("Titulo"));
            }

        } catch (Exception e) {

        }
    }

    void seleccionPelicula() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo != 0) {
            Activar();
            //MenoresEdad();
        } else {
            rbEfectivo.setEnabled(false);
            rbTCredito.setEnabled(false);
            txtBoletosAdultos.setEnabled(false);
            txtBoletosNiños.setEnabled(false);
            btnContinuar.setEnabled(false);
        }
    }

    public static void Horarios() {
        int Combo;
        Conexion cc = new Conexion();
        Connection cn = cc.GetConexion();
        Combo = jComboBoxHora.getSelectedIndex();

        String sql = "SELECT Hora FROM horarios ORDER BY IDHorario";
        jComboBoxHora.addItem("Seleccione un horario");
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                jComboBoxHora.addItem(rs.getString("Hora"));
            }

        } catch (Exception e) {

        }
    }

    void LimCantidad() {
        txtBoletosAdultos.setText("");
        txtBoletosNiños.setText("");
    }

    public static void limpiar() {
        ImageIcon i = new ImageIcon("");
        contadorAdultos = 1;
        contadorNiños = 0;
        txtBoletosAdultos.setText("");
        txtBoletosNiños.setText("");
        buttonGroup1.clearSelection();
        jComboBoxPeliculas.removeAllItems();
        jComboBoxHora.removeAllItems();
        lbResultado.setText("");
        lb14.setText("");
        lb15.setText("");
        lb8.setText("");
        lb9.setText("");
        lb10.setText("");
        lbImagen.setIcon(null);
        lbMenores.setText("");
    }

    void calculo() {

        double boletoAdulto = Double.valueOf(lb9.getText().substring(3));
        double boletoNiño = Double.valueOf(lb10.getText().substring(3));
        double cantidadAdultos = 0.0, cantidadNiños = 0.0;
        double precioAdultos = 0.0, precioNiños = 0.0;
        double TotalN = 0, TotalA = 0, Total;

        if ("".equals(txtBoletosNiños.getText())) {
            String ninguno = "0.0";
            ConfirmarVenta.jLabelTotalNiños.setText(ninguno);
            ConfirmarVenta.jTextFieldCantidadDeBoletosNiños.setText("0");
        } else {
            cantidadNiños = Double.parseDouble(txtBoletosNiños.getText());
            precioNiños = boletoNiño;
            TotalN = (cantidadNiños * precioNiños);
            ConfirmarVenta.jLabelTotalNiños.setText(TotalN + "0");
        }

        if ("".equals(txtBoletosAdultos.getText())) {
            txtBoletosAdultos.setText("");
        } else {

            cantidadAdultos = Double.parseDouble(txtBoletosAdultos.getText());
            precioAdultos = boletoAdulto;
            TotalA = (cantidadAdultos * precioAdultos);
            ConfirmarVenta.jLabelTotalAdultos.setText(TotalA + "0");
        }
        Total = TotalA + TotalN;
        ConfirmarVenta.jLabelTotalPago.setText("TOTAL A PAGAR: L " + Total + "0");

    }

    void pasaDatos() {
        ConfirmarVenta.jTextFieldCantidadDeBoletosAdultos.setText(txtBoletosAdultos.getText());
        ConfirmarVenta.jTextFieldCantidadDeBoletosNiños.setText(txtBoletosNiños.getText());
        ConfirmarVenta.jLabelSala.setText(lb8.getText());
    }

    /*void MenoresEdad() {
        int combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2) {
            lbMenores.setVisible(true);
            txtBoletosNiños.setEnabled(false);
            lbMenores.setText("No apta para menores de edad");
        }
        if (combo == 3 || combo == 4 || combo == 5) {
            txtBoletosNiños.setVisible(true);
            lbMenores.setVisible(false);
        }

    }*/
    void tarjeta() {
        if (rbTCredito.isSelected()) {
            ConfirmarVenta.jTextFieldEfectivoRecibido.setText("Paga con tarjeta");
            ConfirmarVenta.jTextFieldEfectivoRecibido.setEditable(false);
            ConfirmarVenta.lb14.setVisible(true);
            ConfirmarVenta.jLabelCambio.setText("Paga con tarjeta");
            ConfirmarVenta.btnCambio.setEnabled(false);
            ConfirmarVenta.jLabelImpuesto.setText("15%");
            ConfirmarVenta.btnComprar.setEnabled(true);
            ConfirmarVenta.jTextFieldNombreVendedor.setText(lbVendedor.getText().substring(12, lbVendedor.getText().length() - 1));
        }
    }

    public void HabilitarBoton() {
        if ("0".equals(txtBoletosAdultos.getText()) && "0".equals(txtBoletosNiños.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que comprar al menos un boleto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            btnContinuar.setEnabled(false);
            //txtBoletosAdultos.setText("1");

        } else if ("0".equals(txtBoletosAdultos.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que comprar al menos un boleto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            btnContinuar.setEnabled(false);
            // txtBoletosAdultos.setText("1");

        } else {
            btnContinuar.setEnabled(true);
        }

        if (!txtBoletosAdultos.getText().isEmpty()) {
            btnContinuar.setEnabled(true);
        }
        if (!txtBoletosNiños.getText().isEmpty() || txtBoletosNiños.getText().length() == 0) {
            btnContinuar.setEnabled(true);
        } else {
            btnContinuar.setEnabled(false);
        }
    }

    /*void buscarData(){
            String sql = "SELECT Titulo FROM Peliculas";
             DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
             ListaModelo.addElement("Seleccione");
             try{
            Statement st = cn.createStatement();
        try (ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                ListaModelo.addElement(rs.getString("Titulo"));
            }
        }
             }catch (SQLException ex){
                 System.out.println(ex.getMessage());
             }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCerrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxPeliculas = new javax.swing.JComboBox<>();
        lb1 = new javax.swing.JLabel();
        jComboBoxHora = new javax.swing.JComboBox<>();
        lb2 = new javax.swing.JLabel();
        lbImagen = new javax.swing.JLabel();
        lb14 = new javax.swing.JLabel();
        lb15 = new javax.swing.JLabel();
        lb16 = new javax.swing.JLabel();
        lb17 = new javax.swing.JLabel();
        btnEncendido = new javax.swing.JToggleButton();
        lb_Encender = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb9 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb10 = new javax.swing.JLabel();
        lb11 = new javax.swing.JLabel();
        lb13 = new javax.swing.JLabel();
        txtBoletosAdultos = new javax.swing.JTextField();
        lb5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rbEfectivo = new javax.swing.JRadioButton();
        rbTCredito = new javax.swing.JRadioButton();
        rbMixto = new javax.swing.JRadioButton();
        lb8 = new javax.swing.JLabel();
        txtBoletosNiños = new javax.swing.JTextField();
        lb4 = new javax.swing.JLabel();
        lb12 = new javax.swing.JLabel();
        lbMenores = new javax.swing.JLabel();
        lbResultado = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        btnContinuar = new rojerusan.RSButtonHover();
        btnMenos = new javax.swing.JButton();
        btnMas = new javax.swing.JButton();
        btnMenos1 = new javax.swing.JButton();
        btnMas1 = new javax.swing.JButton();
        lb18 = new javax.swing.JLabel();
        lbVendedor = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setIconImage(getIconImage());
        setUndecorated(true);
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
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 38, 24, 24));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel7.setMaximumSize(new java.awt.Dimension(387, 530));
        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(387, 530));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxPeliculas.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jComboBoxPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeliculasActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBoxPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, 180, 35));

        lb1.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("PELICULAS");
        jPanel7.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 35));

        jComboBoxHora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHoraActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBoxHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 55, 180, 35));

        lb2.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("HORA");
        jPanel7.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 20, 180, 35));

        lbImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 105, 225, 325));

        lb14.setForeground(new java.awt.Color(255, 255, 255));
        lb14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(lb14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 180, 35));

        lb15.setForeground(new java.awt.Color(255, 255, 255));
        lb15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(lb15, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 475, 180, 35));

        lb16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb16.setForeground(new java.awt.Color(255, 255, 255));
        lb16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb16.setText("DIRECTOR");
        jPanel7.add(lb16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 180, 35));

        lb17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb17.setForeground(new java.awt.Color(255, 255, 255));
        lb17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb17.setText("GÉNERO");
        jPanel7.add(lb17, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 440, 180, 35));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 145, 387, 530));

        btnEncendido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnApagado.png"))); // NOI18N
        btnEncendido.setBorder(null);
        btnEncendido.setBorderPainted(false);
        btnEncendido.setContentAreaFilled(false);
        btnEncendido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEncendido.setFocusPainted(false);
        btnEncendido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnApagado2.png"))); // NOI18N
        btnEncendido.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEncendido2.png"))); // NOI18N
        btnEncendido.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEncendido.png"))); // NOI18N
        btnEncendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncendidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEncendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 38, 55, 55));

        lb_Encender.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_Encender.setForeground(new java.awt.Color(255, 255, 255));
        lb_Encender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Encender.setText("ENCENDER");
        getContentPane().add(lb_Encender, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, 108, 21));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(586, 530));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb9.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        lb9.setForeground(new java.awt.Color(255, 255, 255));
        lb9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 90, 70, 35));

        lb6.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("Tipo Sala");
        jPanel1.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 140, 30));

        lb7.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb7.setForeground(new java.awt.Color(255, 255, 255));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("Precio Niños");
        jPanel1.add(lb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 50, 140, 30));

        lb10.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        lb10.setForeground(new java.awt.Color(255, 255, 255));
        lb10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 70, 35));

        lb11.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb11.setForeground(new java.awt.Color(255, 255, 255));
        lb11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb11.setText("Adultos");
        jPanel1.add(lb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 140, 30));

        lb13.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb13.setForeground(new java.awt.Color(255, 255, 255));
        lb13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb13.setText("CANTIDAD");
        jPanel1.add(lb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 120, 30));

        txtBoletosAdultos.setEditable(false);
        txtBoletosAdultos.setForeground(new java.awt.Color(0, 0, 0));
        txtBoletosAdultos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBoletosAdultos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBoletosAdultos.setOpaque(false);
        jPanel1.add(txtBoletosAdultos, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 240, 50, 30));

        lb5.setBackground(new java.awt.Color(168, 168, 168));
        lb5.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb5.setText("MÉTODO DE PAGO");
        lb5.setOpaque(true);
        jPanel1.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 585, 40));

        jPanel5.setOpaque(false);

        buttonGroup1.add(rbEfectivo);
        rbEfectivo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rbEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        rbEfectivo.setText("Efectivo");
        rbEfectivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbEfectivo.setOpaque(false);
        rbEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEfectivoMouseClicked(evt);
            }
        });
        rbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfectivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTCredito);
        rbTCredito.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rbTCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbTCredito.setText("Tarjeta de crédito");
        rbTCredito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rbTCredito.setOpaque(false);
        rbTCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbTCreditoMouseClicked(evt);
            }
        });

        rbMixto.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rbMixto);
        rbMixto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        rbMixto.setForeground(new java.awt.Color(255, 255, 255));
        rbMixto.setText("Mixto");
        rbMixto.setOpaque(false);
        rbMixto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbMixtoMouseClicked(evt);
            }
        });
        rbMixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMixtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbEfectivo)
                .addGap(65, 65, 65)
                .addComponent(rbTCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(rbMixto)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEfectivo)
                    .addComponent(rbTCredito)
                    .addComponent(rbMixto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 375, 450, -1));

        lb8.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        lb8.setForeground(new java.awt.Color(255, 255, 255));
        lb8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 90, 90, 35));

        txtBoletosNiños.setEditable(false);
        txtBoletosNiños.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBoletosNiños.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBoletosNiños.setOpaque(false);
        txtBoletosNiños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoletosNiñosActionPerformed(evt);
            }
        });
        txtBoletosNiños.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBoletosNiñosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBoletosNiñosKeyTyped(evt);
            }
        });
        jPanel1.add(txtBoletosNiños, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 50, 30));

        lb4.setBackground(new java.awt.Color(168, 168, 168));
        lb4.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("BOLETOS");
        lb4.setOpaque(true);
        jPanel1.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 585, 40));

        lb12.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb12.setForeground(new java.awt.Color(255, 255, 255));
        lb12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb12.setText("Niños");
        jPanel1.add(lb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 200, 140, 30));

        lbMenores.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbMenores.setForeground(new java.awt.Color(255, 255, 255));
        lbMenores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbMenores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbMenoresKeyReleased(evt);
            }
        });
        jPanel1.add(lbMenores, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 280, 495, 30));

        lbResultado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lbResultado.setForeground(new java.awt.Color(255, 255, 255));
        lbResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbResultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lbResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 425, 450, 30));

        lb3.setBackground(new java.awt.Color(168, 168, 168));
        lb3.setFont(new java.awt.Font("Arial Black", 1, 22)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("PRECIOS");
        lb3.setOpaque(true);
        jPanel1.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 585, 40));

        btnContinuar.setBackground(new java.awt.Color(81, 81, 81));
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoContinuar.png"))); // NOI18N
        btnContinuar.setText("CONTINUAR");
        btnContinuar.setBorderPainted(false);
        btnContinuar.setColorHover(new java.awt.Color(61, 61, 61));
        btnContinuar.setFocusable(false);
        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 140, 40));

        btnMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos.png"))); // NOI18N
        btnMenos.setBorder(null);
        btnMenos.setBorderPainted(false);
        btnMenos.setContentAreaFilled(false);
        btnMenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos2.png"))); // NOI18N
        btnMenos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos2.png"))); // NOI18N
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 240, -1, -1));

        btnMas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas.png"))); // NOI18N
        btnMas.setBorder(null);
        btnMas.setBorderPainted(false);
        btnMas.setContentAreaFilled(false);
        btnMas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas2.png"))); // NOI18N
        btnMas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas2.png"))); // NOI18N
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        jPanel1.add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 240, -1, -1));

        btnMenos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos.png"))); // NOI18N
        btnMenos1.setBorder(null);
        btnMenos1.setBorderPainted(false);
        btnMenos1.setContentAreaFilled(false);
        btnMenos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenos1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos2.png"))); // NOI18N
        btnMenos1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMenos2.png"))); // NOI18N
        btnMenos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        btnMas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas.png"))); // NOI18N
        btnMas1.setBorder(null);
        btnMas1.setBorderPainted(false);
        btnMas1.setContentAreaFilled(false);
        btnMas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMas1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas2.png"))); // NOI18N
        btnMas1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnMas2.png"))); // NOI18N
        btnMas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMas1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        lb18.setFont(new java.awt.Font("Ubuntu Condensed", 1, 20)); // NOI18N
        lb18.setForeground(new java.awt.Color(255, 255, 255));
        lb18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb18.setText("Precio Adultos");
        jPanel1.add(lb18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 145, 586, 530));

        lbVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lbVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoUsuario.png"))); // NOI18N
        getContentPane().add(lbVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 114, 350, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VendedorPantalla2.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void transparenciaButton() {
        btnEncendido.setOpaque(false);
        btnEncendido.setContentAreaFilled(false);
        btnEncendido.setBorderPainted(false);
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


    private void jComboBoxPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeliculasActionPerformed
        seleccionPelicula();

        String sql = "SELECT G.Genero, S.Sala, D.Nombre, P.Foto\n"
                + "FROM peliculas AS P\n"
                + "INNER JOIN generos AS G ON P.IDGenero = G.IDGenero\n"
                + "INNER JOIN director AS D ON P.IDDirector = D.IDDirector\n"
                + "INNER JOIN salas AS S ON P.IDSalas = S.IDSalas\n"
                + "WHERE P.Titulo = '" + jComboBoxPeliculas.getSelectedItem() + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String sala = rs.getString("S.Sala");
                String director = rs.getString("D.Nombre");
                String genero = rs.getString("G.Genero");
                System.out.println(sala);
                lb8.setText(sala);
                lb14.setText(director);
                lb15.setText(genero);

                Image i = null;

                Blob blob = rs.getBlob("P.Foto");
                i = javax.imageio.ImageIO.read(blob.getBinaryStream());
                ImageIcon image = new ImageIcon(i.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_DEFAULT));
                lbImagen.setIcon(image);
                this.repaint();
                //rsscalelabel.RSScaleLabel.setScaleLabel(lbImagen, image.toString());

                if (genero.equals("Terror") || genero.equals("Suspenso")) {
                    lbMenores.setText("Esta pelicula no es apta para menores de edad");
                    btnMas1.setEnabled(false);
                    btnMenos1.setEnabled(false);
                    contadorNiños = 0;
                    txtBoletosNiños.setText(String.valueOf(contadorNiños));
                } else {
                    btnMas1.setEnabled(true);
                    btnMenos1.setEnabled(true);
                    lbMenores.setText("");
                }
            }

        } catch (Exception e) {

        }
        consultarPrecios();
    }//GEN-LAST:event_jComboBoxPeliculasActionPerformed

    private void btnEncendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncendidoActionPerformed
        Encender();
    }//GEN-LAST:event_btnEncendidoActionPerformed

    private void jComboBoxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHoraActionPerformed

    }//GEN-LAST:event_jComboBoxHoraActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        if (MenuVendedor.confirmarVenta == true) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
            int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "La pantalla de confirmar venta se está ejecutando\n¿Estás seguro que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            if (ventanaConfirmacion == 0) {
                Inicio ini = new Inicio();
                ini.setVisible(true);
                this.dispose();
                ConfirmarVenta cv = new ConfirmarVenta();
                cv.dispose();
            } else {

            }
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoPregunta.png");
            int ventanaConfirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas salir?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            if (ventanaConfirmacion == 0) {
                Inicio ini = new Inicio();
                ini.setVisible(true);
                this.dispose();
            } else {

            }
        }
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void txtBoletosNiñosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoletosNiñosKeyTyped
        char cant = evt.getKeyChar();

        if ((cant < '0' || cant > '9') && txtBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten números", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else if ((cant < '0' || cant > '9') && txtBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten números", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtBoletosNiñosKeyTyped

    private void txtBoletosNiñosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoletosNiñosKeyReleased
        //HabilitarBoton();
    }//GEN-LAST:event_txtBoletosNiñosKeyReleased

    private void txtBoletosNiñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoletosNiñosActionPerformed
        //HabilitarBoton();
    }//GEN-LAST:event_txtBoletosNiñosActionPerformed

    private void rbTCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbTCreditoMouseClicked
        String mensaje = "Su método de pago es con: ";
        if (rbTCredito.isSelected()) {
            mensaje += "Tarjeta de Crédito";
        }
        lbResultado.setText(mensaje);
    }//GEN-LAST:event_rbTCreditoMouseClicked

    private void rbEfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEfectivoMouseClicked
        String mensaje = "Su método de pago es en: ";

        if (rbEfectivo.isSelected()) {
            mensaje += "Efectivo";
        }
        lbResultado.setText(mensaje);
    }//GEN-LAST:event_rbEfectivoMouseClicked

    private void rbMixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMixtoActionPerformed

    private void rbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEfectivoActionPerformed

    private void rbMixtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMixtoMouseClicked
        String mensaje = "Su método de pago es: ";

        if (rbMixto.isSelected()) {
            mensaje += "Mixto";
        }
        lbResultado.setText(mensaje);
    }//GEN-LAST:event_rbMixtoMouseClicked

    public static boolean confirmarVenta = false;
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if (jComboBoxPeliculas.getSelectedIndex() == 0) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(this, "Debe seleccionar una pelicula", "Complete datos", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (jComboBoxHora.getSelectedIndex() == 0) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(this, "Debe seleccionar un horario", "Complete datos", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else if (rbEfectivo.isSelected() == false && rbTCredito.isSelected() == false && rbMixto.isSelected() == false) {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar un método de pago", "Complete datos", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        } else {
            if (confirmarVenta == false) {
                ConfirmarVenta obj = new ConfirmarVenta();
                pasaDatos();
                ConfirmarVenta.jTextFieldPelicula.setText(jComboBoxPeliculas.getSelectedItem().toString());
                ConfirmarVenta.jTextFieldHora.setText(jComboBoxHora.getSelectedItem().toString());
                ConfirmarVenta.jTextFieldNombreVendedor.setText(lbVendedor.getText().substring(12, lbVendedor.getText().length() - 1));
                tarjeta();
                calculo();
                obj.setVisible(true);
                confirmarVenta = true;
            } else if (confirmarVenta == true) {
                ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
                JOptionPane.showMessageDialog(null, "Esta pantalla se está ejecutando actualmente", "Aviso", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
            }
        }
        HabilitarBoton();
    }//GEN-LAST:event_btnContinuarActionPerformed

    public static int contadorAdultos = 1;
    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        if (contadorAdultos < 2) {
            btnMenos.setEnabled(false);
        } else {
            contadorAdultos--;
            txtBoletosAdultos.setText(String.valueOf(contadorAdultos));
            if (contadorAdultos < 15) {
                btnMas.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnMenosActionPerformed

    public static int contadorNiños = 0;
    private void btnMenos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenos1ActionPerformed
        if (contadorNiños < 1) {
            btnMenos1.setEnabled(false);
        } else {
            contadorNiños--;
            txtBoletosNiños.setText(String.valueOf(contadorNiños));
            if (contadorNiños < 10) {
                btnMas1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnMenos1ActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        if (contadorAdultos > 14) {
            btnMas.setEnabled(false);
        } else {
            contadorAdultos++;
            txtBoletosAdultos.setText(String.valueOf(contadorAdultos));
            if (contadorAdultos > 1) {
                btnMenos.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnMasActionPerformed

    private void btnMas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMas1ActionPerformed
        if (contadorNiños > 9) {
            btnMas1.setEnabled(false);
        } else {
            contadorNiños++;
            txtBoletosNiños.setText(String.valueOf(contadorNiños));
            if (contadorNiños > 0) {
                btnMenos1.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnMas1ActionPerformed

    private void lbMenoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbMenoresKeyReleased
        //HabilitarBoton();
    }//GEN-LAST:event_lbMenoresKeyReleased

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
            java.util.logging.Logger.getLogger(MenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private rojerusan.RSButtonHover btnContinuar;
    public static javax.swing.JToggleButton btnEncendido;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMas1;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnMenos1;
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    public static javax.swing.JComboBox<String> jComboBoxHora;
    public static javax.swing.JComboBox<String> jComboBoxPeliculas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lb1;
    public static javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb12;
    private javax.swing.JLabel lb13;
    public static javax.swing.JLabel lb14;
    public static javax.swing.JLabel lb15;
    private javax.swing.JLabel lb16;
    private javax.swing.JLabel lb17;
    private javax.swing.JLabel lb18;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    public static javax.swing.JLabel lb8;
    public static javax.swing.JLabel lb9;
    public static javax.swing.JLabel lbImagen;
    public static javax.swing.JLabel lbMenores;
    public static javax.swing.JLabel lbResultado;
    public static javax.swing.JLabel lbVendedor;
    private javax.swing.JLabel lb_Encender;
    public static javax.swing.JRadioButton rbEfectivo;
    public static javax.swing.JRadioButton rbMixto;
    public static javax.swing.JRadioButton rbTCredito;
    public static javax.swing.JTextField txtBoletosAdultos;
    public static javax.swing.JTextField txtBoletosNiños;
    // End of variables declaration//GEN-END:variables
}
