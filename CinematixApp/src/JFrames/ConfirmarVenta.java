/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Datos.Conexion;
import Tipografia.Fuente;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Los Pibes
 */
public class ConfirmarVenta extends javax.swing.JFrame {

    /**
     * Creates new form ConfirmarVenta
     */
    Fuente tipoFuente;

    public ConfirmarVenta() {
        //setBackground(new Color(0, 0, 0, 0));
        //super.setUndecorated(true);
        initComponents();
        noEditable();
        //super.setLocationRelativeTo(this);
        btnComprar.setEnabled(false);

        tipoFuente = new Fuente();
        lb1.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb2.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb3.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb4.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb5.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb6.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb7.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb10.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb11.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb12.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb13.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb14.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb15.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lb16.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 24));
        lb17.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        btnComprar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));
        btnRegresar.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 12));

        jTextFieldPelicula.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jTextFieldCantidadDeBoletosAdultos.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jTextFieldCantidadDeBoletosNiños.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jTextFieldEfectivoRecibido.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jTextFieldHora.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jTextFieldNombreVendedor.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
        jLabelSala.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jLabelCambio.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jLabelTotalAdultos.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jLabelTotalNiños.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jLabelTotalPago.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        jLabelImpuesto.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 18));
        lbAgregarCliente.setFont(tipoFuente.fuente(tipoFuente.LUSI, 1, 16));
    }

    void noEditable() {
        jTextFieldPelicula.setEditable(false);
        jTextFieldHora.setEditable(false);
    }

    double efectivoR;
    public static double totalPago;
    double cambio;

    //Variables que almacenarán todos los datos para enviar a la factura.
    public static String idPelicula;
    public static String idSala;
    public static String idHorario;

    Conexion cn = new Conexion();
    Connection cc = cn.GetConexion();

    void datosFactura() {
        String sql = "SELECT P.IdPelicula, S.IDSalas, H.IDHorario\n"
                + "FROM peliculas AS P\n"
                + "INNER JOIN salas AS S ON P.IDSalas = S.IDSalas\n"
                + "INNER JOIN horarios AS H ON P.IDHorario = H.IDHorario\n"
                + "WHERE P.Titulo = '" + jTextFieldPelicula.getText() + "'";

        try {
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idPelicula = rs.getString("P.IdPelicula");
                idSala = rs.getString("S.IDSalas");
                idHorario = rs.getString("H.IDHorario");
                System.out.println("IDPelicula: " + idPelicula);
                System.out.println("IDSala: " + idSala);
                System.out.println("IDHorario: " + idHorario);
            }

        } catch (Exception e) {

        }
    }

    void calculo() {

        totalPago = Double.parseDouble(jLabelTotalPago.getText().substring(17));
        efectivoR = Double.parseDouble(jTextFieldEfectivoRecibido.getText());
        if (efectivoR < totalPago) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(this, "Hubo un problema al realizar el cobro\n Dinero insuficiente", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            cambio = efectivoR - totalPago;
            jLabelCambio.setText("L." + cambio + "0");
            btnComprar.setEnabled(true);
        }
    }

    void pasaDatos() {

        Factura.jLabelPelicula.setText(jTextFieldPelicula.getText());
        Factura.jLabelSala.setText(jLabelSala.getText());
        Factura.jLabelTanda.setText(jTextFieldHora.getText());
        Factura.jLabelNiños.setText(jTextFieldCantidadDeBoletosNiños.getText());
        Factura.jLabeNiñosTotal.setText("L." + jLabelTotalNiños.getText());
        Factura.jLabeAdultos.setText(jTextFieldCantidadDeBoletosAdultos.getText());
        Factura.jLabeAdultosTotal.setText("L." + jLabelTotalAdultos.getText());
        Factura.jLabeTotal.setText("L." + jLabelTotalPago.getText().substring(17));

        if (Factura.jLabeEfectivoRecibido.getText().equals("Paga con tarjeta")) {
            Factura.jLabeEfectivoRecibido.setText(jTextFieldEfectivoRecibido.getText());
        } else {
            Factura.jLabeEfectivoRecibido.setText("L." + jTextFieldEfectivoRecibido.getText());
        }
        Factura.jLabeCambio.setText(jLabelCambio.getText());
        Factura.jLabelISV.setText(jLabelImpuesto.getText());
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

        btnRegresar = new rojerusan.RSButtonHover();
        btnComprar = new rojerusan.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        lb7 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();
        lb6 = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletosNiños = new javax.swing.JTextField();
        lb4 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jLabelTotalPago = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletosAdultos = new javax.swing.JTextField();
        lb3 = new javax.swing.JLabel();
        jLabelTotalNiños = new javax.swing.JLabel();
        jTextFieldPelicula = new javax.swing.JTextField();
        jLabelTotalAdultos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb10 = new javax.swing.JLabel();
        lb12 = new javax.swing.JLabel();
        lb11 = new javax.swing.JLabel();
        lb13 = new javax.swing.JLabel();
        lb14 = new javax.swing.JLabel();
        jLabelCambio = new javax.swing.JLabel();
        btnCambio = new javax.swing.JButton();
        lb16 = new javax.swing.JLabel();
        jTextFieldNombreVendedor = new javax.swing.JTextField();
        lb15 = new javax.swing.JLabel();
        jLabelImpuesto = new javax.swing.JLabel();
        jTextFieldEfectivoRecibido = new javax.swing.JTextField();
        lb17 = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();
        lbAgregarCliente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        btnRegresar.setBackground(new java.awt.Color(81, 81, 81));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoRegresar.png"))); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.setBorderPainted(false);
        btnRegresar.setColorHover(new java.awt.Color(61, 61, 61));
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 475, 140, 45));

        btnComprar.setBackground(new java.awt.Color(81, 81, 81));
        btnComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoComprar.png"))); // NOI18N
        btnComprar.setText("COMPRAR");
        btnComprar.setBorderPainted(false);
        btnComprar.setColorHover(new java.awt.Color(61, 61, 61));
        btnComprar.setFocusable(false);
        btnComprar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 475, 140, 45));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb7.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb7.setForeground(new java.awt.Color(255, 255, 255));
        lb7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb7.setText("Total Niños");
        jPanel1.add(lb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 215, 120, 30));

        lb1.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Pelicula ");
        jPanel1.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 30));

        lb5.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText("Cantidad de boletos (niños):");
        jPanel1.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 30));

        jTextFieldHora.setEditable(false);
        jTextFieldHora.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldHora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldHora.setOpaque(false);
        jPanel1.add(jTextFieldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 55, 100, 30));

        lb6.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb6.setText("Total Adultos");
        jPanel1.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 215, 120, 30));

        jTextFieldCantidadDeBoletosNiños.setEditable(false);
        jTextFieldCantidadDeBoletosNiños.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCantidadDeBoletosNiños.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCantidadDeBoletosNiños.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldCantidadDeBoletosNiños.setOpaque(false);
        jTextFieldCantidadDeBoletosNiños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosNiñosActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCantidadDeBoletosNiños, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        lb4.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText("Cantidad de boletos (adultos):");
        jPanel1.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 30));

        lb2.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("Sala");
        jPanel1.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, 30));

        jLabelSala.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSala.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSala.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSala.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 55, 100, 30));

        jLabelTotalPago.setBackground(new java.awt.Color(168, 168, 168));
        jLabelTotalPago.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelTotalPago.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalPago.setOpaque(true);
        jPanel1.add(jLabelTotalPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 475, 40));

        jTextFieldCantidadDeBoletosAdultos.setEditable(false);
        jTextFieldCantidadDeBoletosAdultos.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCantidadDeBoletosAdultos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCantidadDeBoletosAdultos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldCantidadDeBoletosAdultos.setOpaque(false);
        jTextFieldCantidadDeBoletosAdultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosAdultosActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldCantidadDeBoletosAdultos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 80, 30));

        lb3.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("Hora");
        jPanel1.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 20, 100, 30));

        jLabelTotalNiños.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTotalNiños.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalNiños.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalNiños.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelTotalNiños, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 120, 30));

        jTextFieldPelicula.setEditable(false);
        jTextFieldPelicula.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPelicula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPelicula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldPelicula.setOpaque(false);
        jPanel1.add(jTextFieldPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 200, 30));

        jLabelTotalAdultos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelTotalAdultos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalAdultos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalAdultos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabelTotalAdultos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 104, 476, 360));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb10.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb10.setForeground(new java.awt.Color(255, 255, 255));
        lb10.setText("Nombre vendedor: ");
        jPanel2.add(lb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 155, 30));

        lb12.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb12.setForeground(new java.awt.Color(255, 255, 255));
        lb12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb12.setText("Tegucigalpa");
        lb12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 185, 30));

        lb11.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb11.setForeground(new java.awt.Color(255, 255, 255));
        lb11.setText("Ubicacion:");
        jPanel2.add(lb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 155, 30));

        lb13.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb13.setForeground(new java.awt.Color(255, 255, 255));
        lb13.setText("Efectivo recibido:");
        jPanel2.add(lb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 155, 30));

        lb14.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb14.setForeground(new java.awt.Color(255, 255, 255));
        lb14.setText("Cambio:");
        jPanel2.add(lb14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 155, 30));

        jLabelCambio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelCambio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCambio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCambio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabelCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 185, 30));

        btnCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCambio.png"))); // NOI18N
        btnCambio.setBorder(null);
        btnCambio.setContentAreaFilled(false);
        btnCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnCambio2.png"))); // NOI18N
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });
        jPanel2.add(btnCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 165, -1, 35));

        lb16.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb16.setForeground(new java.awt.Color(255, 255, 255));
        lb16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb16.setText("CINEMATIX");
        jPanel2.add(lb16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 180, 40));

        jTextFieldNombreVendedor.setEditable(false);
        jTextFieldNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreVendedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNombreVendedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldNombreVendedor.setOpaque(false);
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
        jPanel2.add(jTextFieldNombreVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 185, 30));

        lb15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb15.setForeground(new java.awt.Color(255, 255, 255));
        lb15.setText("ISV:");
        jPanel2.add(lb15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 155, 30));

        jLabelImpuesto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelImpuesto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImpuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImpuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabelImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 185, 30));

        jTextFieldEfectivoRecibido.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldEfectivoRecibido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEfectivoRecibido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldEfectivoRecibido.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldEfectivoRecibido.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldEfectivoRecibido.setOpaque(false);
        jTextFieldEfectivoRecibido.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldEfectivoRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEfectivoRecibidoActionPerformed(evt);
            }
        });
        jPanel2.add(jTextFieldEfectivoRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 145, 30));

        lb17.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lb17.setForeground(new java.awt.Color(255, 255, 255));
        lb17.setText("Cliente:");
        jPanel2.add(lb17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 155, 30));

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarCliente.png"))); // NOI18N
        btnAgregarCliente.setBorder(null);
        btnAgregarCliente.setContentAreaFilled(false);
        btnAgregarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarCliente2.png"))); // NOI18N
        btnAgregarCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnAgregarCliente2.png"))); // NOI18N
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 115, -1, 35));

        lbAgregarCliente.setFont(new java.awt.Font("Ubuntu Condensed", 0, 18)); // NOI18N
        lbAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbAgregarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAgregarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lbAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 145, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 104, 387, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ConfirmarPantalla.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 550));

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

    private void jTextFieldCantidadDeBoletosAdultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed

    private void jTextFieldCantidadDeBoletosNiñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        if (jTextFieldEfectivoRecibido.getText().isEmpty()) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoError.png");
            JOptionPane.showMessageDialog(null, "Debe escribir la cantidad de efectivo recibida", "Error", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        } else {
            double efectivoR;
            double isv;
            efectivoR = Double.parseDouble(jTextFieldEfectivoRecibido.getText());
            totalPago = Double.parseDouble(jLabelTotalPago.getText().substring(17));
            System.out.println(totalPago);

            double diferencia = totalPago - efectivoR;
            if (MenuVendedor.rbMixto.isSelected() == true) {
                if (efectivoR >= totalPago) {
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
                    JOptionPane.showMessageDialog(null, "Al hacer un pago de tipo mixto, la cantidad de efectivo debe ser menor al total", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                } else {
                    isv = efectivoR * 0.15;
                    jLabelImpuesto.setText("L." + isv + "0");
                    jLabelCambio.setText("Pago Mixto");
                    ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoCorrecto.png");
                    JOptionPane.showMessageDialog(null, "Se cobraron " + efectivoR + " lempiras en efectivo\nLa diferencia de " + diferencia + " lempiras fue cargada a la tarjeta", "Notificación", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
                    btnComprar.setEnabled(true);
                }
            } else if (MenuVendedor.rbEfectivo.isSelected()) {
                isv = efectivoR * 0.15;
                jLabelImpuesto.setText("L." + isv + "0");
                calculo();
            } else if (MenuVendedor.rbTCredito.isSelected()) {
                calculo();
                btnComprar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnCambioActionPerformed

    private void jTextFieldNombreVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreVendedorActionPerformed

    private void jTextFieldNombreVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreVendedorKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Solo se admiten letras", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_jTextFieldNombreVendedorKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        MenuVendedor.confirmarVenta = false;
        MenuVendedor.btnSalas.setEnabled(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if (!lbAgregarCliente.getText().isEmpty()) {
            datosFactura();
            this.dispose();
            MenuVendedor.confirmarVenta = false;
            if (jLabelSala.getText().equals("2D")) {
                Sala2D sala = new Sala2D();
                sala.setVisible(true);
            } else if (jLabelSala.getText().equals("3D")) {
                Sala3D sala = new Sala3D();
                sala.setVisible(true);
            } else if (jLabelSala.getText().equals("Max2D")) {
                SalaMax2D sala = new SalaMax2D();
                sala.setVisible(true);
            } else if (jLabelSala.getText().equals("Max3D")) {
                SalaMax3D sala = new SalaMax3D();
                sala.setVisible(true);
            }
        } else {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente para continuar con la venta", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void jTextFieldEfectivoRecibidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEfectivoRecibidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEfectivoRecibidoActionPerformed

    public static boolean pantallaCliente = false;
    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed

        if (pantallaCliente == false) {
            RegistroClientesVenta rc = new RegistroClientesVenta();
            rc.setVisible(true);
            pantallaCliente = true;
        } else if (pantallaCliente == true) {
            ImageIcon jPanelIcon = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "La pantalla Registrar Clientes ya se está ejecutando", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcon);
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregarCliente;
    public static javax.swing.JButton btnCambio;
    public static rojerusan.RSButtonHover btnComprar;
    private rojerusan.RSButtonHover btnRegresar;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabelCambio;
    public static javax.swing.JLabel jLabelImpuesto;
    public static final javax.swing.JLabel jLabelSala = new javax.swing.JLabel();
    public static javax.swing.JLabel jLabelTotalAdultos;
    public static javax.swing.JLabel jLabelTotalNiños;
    public static javax.swing.JLabel jLabelTotalPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosAdultos;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosNiños;
    public static javax.swing.JTextField jTextFieldEfectivoRecibido;
    public static javax.swing.JTextField jTextFieldHora;
    public static javax.swing.JTextField jTextFieldNombreVendedor;
    public static javax.swing.JTextField jTextFieldPelicula;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb12;
    private javax.swing.JLabel lb13;
    public static javax.swing.JLabel lb14;
    private javax.swing.JLabel lb15;
    private javax.swing.JLabel lb16;
    private javax.swing.JLabel lb17;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    public static javax.swing.JLabel lbAgregarCliente;
    // End of variables declaration//GEN-END:variables
}
