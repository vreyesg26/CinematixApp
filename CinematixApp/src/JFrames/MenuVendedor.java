/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeymerd Canales
 */
public class MenuVendedor extends javax.swing.JFrame {
    /**
     * Creates new form MenuVendedor
     */
    public MenuVendedor() {
        initComponents();
        //setBackground( new Color (0,0,0,0));
        super.setTitle("Menú CineMatix");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        jLabelMenores.setVisible(false);
        jButtonContinuar.setEnabled(false);
        Desactivados();
    }

    void Encender() {
        if (jToggleButtonEncender.isSelected()) {
            jComboBoxPeliculas.setEnabled(true);
            jComboBoxHora.setEnabled(true);
            AgregarAComboboxPelicula();
            //jToggleButtonEncender.setText("Apagar");
        } else {
            jComboBoxPeliculas.setEnabled(false);
            jComboBoxHora.setEnabled(false);
            limpiar();
            Desactivados();
            //jToggleButtonEncender.setText("Encender");
        }
    }

    void Desactivados() {
        jComboBoxPeliculas.setEnabled(false);
        jComboBoxHora.setEnabled(false);
        jRadioButtonEfectivo.setEnabled(false);
        jRadioButtonTCredito.setEnabled(false);
        jTextFieldCantidadDeBoletosAdultos.setEnabled(false);
        jTextFieldCantidadDeBoletosNiños.setEnabled(false);
        jButtonContinuar.setEnabled(false);
    }

    void Activar() {
        jRadioButtonEfectivo.setEnabled(true);
        jRadioButtonTCredito.setEnabled(true);
        jTextFieldCantidadDeBoletosAdultos.setEnabled(true);
        jTextFieldCantidadDeBoletosNiños.setEnabled(true);
        jButtonContinuar.setEnabled(true);
    }
    
   /* ResultSet rs;
    PreparedStatement Pst;
    DefaultComboBoxModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();*/
    void AgregarAComboboxPelicula() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        modelo.addElement("Viernes 13");
        modelo.addElement("La masacre en texas 3");
        modelo.addElement("Cars 3");
        modelo.addElement("Spider-Man");
        modelo.addElement("Batman");
        jComboBoxPeliculas.setModel(modelo);
            /*String[] titulos = {"Titulo"};
            String sql = "SELECT Titulo FROM peliculas WHERE Titulo";
             DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
             ListaModelo.addElement("Seleccione");
             try{
            Statement st = cn.createStatement();
        try (ResultSet rs = st.executeQuery(sql)) {
            while(rs.next()){
                ListaModelo.addElement(rs.getString("Titulo"));
            }
        jComboBoxPeliculas.setModel(modelo);
        }
             }catch (SQLException ex){
                  Logger.getLogger(panelPeliculas.class.getName()).log(Level.SEVERE,null,ex);
                 System.out.println(ex.getMessage());
             }*/
             
}

    void seleccionPelicula() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2 || combo == 3 || combo == 4 || combo == 5) {
            Activar();
            MenoresEdad();
        } else {
            jRadioButtonEfectivo.setEnabled(false);
            jRadioButtonTCredito.setEnabled(false);
            jTextFieldCantidadDeBoletosAdultos.setEnabled(false);
            jTextFieldCantidadDeBoletosNiños.setEnabled(false);
            jButtonContinuar.setEnabled(false);
        }
    }

    void caratulas() {
        int combo;
        combo = jComboBoxPeliculas.getSelectedIndex();
        switch (combo) {
            case 0: {
                ImageIcon i = new ImageIcon("");
                break;
            }
            case 1: {
                LimCantidad();
                Preview.jLabelSala.setText("4");
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("4:00 pm");
                modelo.addElement("6:00 pm");
                modelo.addElement("8:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 2: {
                LimCantidad();
                Preview.jLabelSala.setText("2");
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("5:00 pm");
                modelo.addElement("7:00 pm");
                modelo.addElement("9:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 3: {
                LimCantidad();
                Preview.jLabelSala.setText("3");
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("12:00 pm");
                modelo.addElement("2:00 pm");
                modelo.addElement("4:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 4: {
                LimCantidad();
                Preview.jLabelSala.setText("5");
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("1:00 pm");
                modelo.addElement("3:00 pm");
                modelo.addElement("6:30 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            case 5: {
                LimCantidad();
                Preview.jLabelSala.setText("1");
                DefaultComboBoxModel modelo = new DefaultComboBoxModel();
                modelo.addElement("Seleccione");
                modelo.addElement("2:00 pm");
                modelo.addElement("5:00 pm");
                modelo.addElement("8:00 pm");
                jComboBoxHora.setModel(modelo);
                break;
            }
            default:
                break;
        }
    }

    void LimCantidad() {
        jTextFieldCantidadDeBoletosAdultos.setText("");
        jTextFieldCantidadDeBoletosNiños.setText("");
    }

    void limpiar() {
        ImageIcon i = new ImageIcon("");
        jTextFieldCantidadDeBoletosAdultos.setText("");
        buttonGroup1.clearSelection();
        jComboBoxPeliculas.removeAllItems();
        jComboBoxHora.removeAllItems();
    }

    void calculo() {

        double cantidadAdultos = 0.0, cantidadNiños = 0.0;
        double precioAdultos = 0.0, precioNiños = 0.0;
        double TotalN = 0, TotalA = 0, Total;

        if ("".equals(jTextFieldCantidadDeBoletosNiños.getText())) {
            String ninguno = "0.0";
            Preview.jLabelTotalNiños.setText(ninguno);
            Preview.jTextFieldCantidadDeBoletosNiños.setText("0");
        } else {
            cantidadNiños = Double.parseDouble(jTextFieldCantidadDeBoletosNiños.getText());
            precioNiños = Double.parseDouble(jLabelPrecio2DNiños.getText());
            TotalN = (cantidadNiños * precioNiños);
            Preview.jLabelTotalNiños.setText(TotalN + "");
        }

        if ("".equals(jTextFieldCantidadDeBoletosAdultos.getText())) {
            jTextFieldCantidadDeBoletosAdultos.setText("");
        } else {

            cantidadAdultos = Double.parseDouble(jTextFieldCantidadDeBoletosAdultos.getText());
            precioAdultos = Double.parseDouble(jLabelPrecio2DAdulto.getText());
            TotalA = (cantidadAdultos * precioAdultos);
            Preview.jLabelTotalAdultos.setText(TotalA + "");
        }
        Total = TotalA + TotalN;
        Preview.jLabelTotalPago.setText(Total + "");

    }

    void pasaDatos() {
        Preview.jTextFieldCantidadDeBoletosAdultos.setText(jTextFieldCantidadDeBoletosAdultos.getText());
        Preview.jTextFieldCantidadDeBoletosNiños.setText(jTextFieldCantidadDeBoletosNiños.getText());
    }

    void MenoresEdad() {
        int combo = jComboBoxPeliculas.getSelectedIndex();
        if (combo == 1 || combo == 2) {
            jLabelMenores.setVisible(true);
            jTextFieldCantidadDeBoletosNiños.setEnabled(false);
            jTextFieldCantidadDeBoletosNiños.setVisible(false);
            jLabelMenores.setText("No apta para menores de edad");
        }
        if (combo == 3 || combo == 4 || combo == 5) {
            jTextFieldCantidadDeBoletosNiños.setVisible(true);
            jLabelMenores.setVisible(false);
        }

    }

    void tarjeta() {
        if (jRadioButtonTCredito.isSelected()) {
            Preview.jTextFieldEfectivoRecibido.setText("Paga con tarjeta");
            Preview.jTextFieldEfectivoRecibido.setEditable(false);
            Preview.jLabel14.setVisible(false);
            Preview.jButton3.setVisible(false);
            Preview.jButtonComprar.setEnabled(true);
        }
    }

    public void HabilitarBoton() {
        if (!jTextFieldCantidadDeBoletosAdultos.getText().isEmpty()) {
            jButtonContinuar.setEnabled(true);
        }
        if (!jTextFieldCantidadDeBoletosNiños.getText().isEmpty() || jTextFieldCantidadDeBoletosNiños.getText().length() == 0) {
            jButtonContinuar.setEnabled(true);
        } else {
            jButtonContinuar.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHora = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelPrecio2DAdulto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelPrecio2DNiños = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletosAdultos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioButtonEfectivo = new javax.swing.JRadioButton();
        jRadioButtonTCredito = new javax.swing.JRadioButton();
        jRadioButtonMixto = new javax.swing.JRadioButton();
        jButtonContinuar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldCantidadDeBoletosNiños = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelMenores = new javax.swing.JLabel();
        jLabelResultado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButtonEncender = new javax.swing.JToggleButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
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
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 43, 35, 35));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel7.setOpaque(false);

        jComboBoxPeliculas.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jComboBoxPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeliculasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Peliculas");

        jComboBoxHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHoraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hora");

        jPanel1.setOpaque(false);

        jLabelPrecio2DAdulto.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        jLabelPrecio2DAdulto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecio2DAdulto.setText("90");

        jLabel4.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precios Adultos");

        jLabel8.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precios Niños");

        jLabelPrecio2DNiños.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        jLabelPrecio2DNiños.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecio2DNiños.setText("40");

        jLabel11.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Adultos");

        jLabel12.setFont(new java.awt.Font("Ubuntu Condensed", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cantidad:");

        jTextFieldCantidadDeBoletosAdultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosAdultosActionPerformed(evt);
            }
        });
        jTextFieldCantidadDeBoletosAdultos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadDeBoletosAdultosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadDeBoletosAdultosKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Metodo de pago");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setOpaque(false);

        buttonGroup1.add(jRadioButtonEfectivo);
        jRadioButtonEfectivo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRadioButtonEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonEfectivo.setText("Efectivo");
        jRadioButtonEfectivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioButtonEfectivo.setOpaque(false);
        jRadioButtonEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonEfectivoMouseClicked(evt);
            }
        });
        jRadioButtonEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEfectivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTCredito);
        jRadioButtonTCredito.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRadioButtonTCredito.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonTCredito.setText("Tarjeta de crédito");
        jRadioButtonTCredito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRadioButtonTCredito.setOpaque(false);
        jRadioButtonTCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonTCreditoMouseClicked(evt);
            }
        });

        jRadioButtonMixto.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(jRadioButtonMixto);
        jRadioButtonMixto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jRadioButtonMixto.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonMixto.setText("Mixto");
        jRadioButtonMixto.setOpaque(false);
        jRadioButtonMixto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMixtoMouseClicked(evt);
            }
        });
        jRadioButtonMixto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMixtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButtonEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonTCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButtonMixto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonTCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMixto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonContinuar.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        jButtonContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnContinuar1.png"))); // NOI18N
        jButtonContinuar.setBorder(null);
        jButtonContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonContinuar.setEnabled(false);
        jButtonContinuar.setOpaque(false);
        jButtonContinuar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnContinuar2.png"))); // NOI18N
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Ubuntu Condensed", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("2D");

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("L.");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("L.");

        jTextFieldCantidadDeBoletosNiños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadDeBoletosNiñosActionPerformed(evt);
            }
        });
        jTextFieldCantidadDeBoletosNiños.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadDeBoletosNiñosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadDeBoletosNiñosKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Boletos");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Ubuntu Condensed", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Niños");

        jLabelMenores.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelMenores.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenores.setText("jLabel6");
        jLabelMenores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelMenores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabelMenoresKeyReleased(evt);
            }
        });

        jLabelResultado.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelResultado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelResultado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Precios");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(21, 21, 21))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(jLabelPrecio2DAdulto))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(15, 15, 15)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelPrecio2DNiños))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelMenores, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabelPrecio2DAdulto)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabelPrecio2DNiños))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCantidadDeBoletosAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldCantidadDeBoletosNiños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMenores))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonContinuar)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(825, 825, 825))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jToggleButtonEncender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnApagado.png"))); // NOI18N
        jToggleButtonEncender.setBorder(null);
        jToggleButtonEncender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonEncender.setOpaque(false);
        jToggleButtonEncender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnApagado2.png"))); // NOI18N
        jToggleButtonEncender.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEncendido.png"))); // NOI18N
        jToggleButtonEncender.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEncendido.png"))); // NOI18N
        jToggleButtonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEncenderActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButtonEncender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 60, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/VendedorPantalla2.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, 1050, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void transparenciaButton() {
        jToggleButtonEncender.setOpaque(false);
        jToggleButtonEncender.setContentAreaFilled(false);
        jToggleButtonEncender.setBorderPainted(false);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
//            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeliculasActionPerformed
         seleccionPelicula();
        caratulas();
        jButtonContinuar.setEnabled(false);
    }//GEN-LAST:event_jComboBoxPeliculasActionPerformed

    private void jToggleButtonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEncenderActionPerformed
        Encender();
    }//GEN-LAST:event_jToggleButtonEncenderActionPerformed

    private void jComboBoxHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHoraActionPerformed
        jButtonContinuar.setEnabled(false);
    }//GEN-LAST:event_jComboBoxHoraActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void jLabelMenoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelMenoresKeyReleased
        HabilitarBoton();
    }//GEN-LAST:event_jLabelMenoresKeyReleased

    private void jTextFieldCantidadDeBoletosNiñosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosNiñosKeyTyped
        char cant = evt.getKeyChar();

        if ((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros",
                    JOptionPane.WARNING_MESSAGE);

        } else if ((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosNiñosKeyTyped

    private void jTextFieldCantidadDeBoletosNiñosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosNiñosKeyReleased
        HabilitarBoton();
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosNiñosKeyReleased

    private void jTextFieldCantidadDeBoletosNiñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed
        HabilitarBoton();
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosNiñosActionPerformed

    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarActionPerformed
        if (jComboBoxPeliculas.getSelectedIndex() == 0 || jComboBoxHora.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Todavía hacen falta datos por completar", "Complete datos", JOptionPane.WARNING_MESSAGE);
        }

        if (jTextFieldCantidadDeBoletosAdultos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba la cantidad de boletos", "Complete datos", JOptionPane.WARNING_MESSAGE);

        }
        if (jRadioButtonEfectivo.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "Pago en Efectivo");
        }

        if (jRadioButtonMixto.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "Pago Mixto");
        }

        if (jRadioButtonTCredito.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "Pago con Tarjeta de Credito");
            Preview obj = new Preview();
            pasaDatos();
            Preview.jTextFieldPelicula.setText(jComboBoxPeliculas.getSelectedItem().toString());
            Preview.jTextFieldHora.setText(jComboBoxHora.getSelectedItem().toString());

            tarjeta();
            calculo();
            obj.setVisible(true);

        } else if (jRadioButtonEfectivo.isSelected() == false && jRadioButtonTCredito.isSelected() == false && jRadioButtonMixto.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN METODO DE PAGO", "Complete datos", JOptionPane.WARNING_MESSAGE);

        } else {
            Preview obj = new Preview();
            pasaDatos();
            Preview.jTextFieldPelicula.setText(jComboBoxPeliculas.getSelectedItem().toString());
            Preview.jTextFieldHora.setText(jComboBoxHora.getSelectedItem().toString());

            tarjeta();
            calculo();
            obj.setVisible(true);
        }
        HabilitarBoton();
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    private void jRadioButtonTCreditoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonTCreditoMouseClicked
        String mensaje = "Su metodo de pago es con: ";
        if (jRadioButtonTCredito.isSelected()) {
            mensaje += "Tarjeta de Credito";
        }
        jLabelResultado.setText(mensaje);
    }//GEN-LAST:event_jRadioButtonTCreditoMouseClicked

    private void jRadioButtonEfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonEfectivoMouseClicked
        String mensaje = "Su metodo de pago es en: ";

        if (jRadioButtonEfectivo.isSelected()) {
            mensaje += "Efectivo";
        }
        jLabelResultado.setText(mensaje);
    }//GEN-LAST:event_jRadioButtonEfectivoMouseClicked

    private void jTextFieldCantidadDeBoletosAdultosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosAdultosKeyTyped
        char cant = evt.getKeyChar();

        if ((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros",
                    JOptionPane.WARNING_MESSAGE);

        } else if ((cant < '0' || cant > '9') && jTextFieldCantidadDeBoletosAdultos.getText().contains("")
                && (cant != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se admiten numeros", "Validar numeros",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosAdultosKeyTyped

    private void jTextFieldCantidadDeBoletosAdultosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosAdultosKeyReleased
        HabilitarBoton();
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosAdultosKeyReleased

    private void jTextFieldCantidadDeBoletosAdultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed
        HabilitarBoton();
    }//GEN-LAST:event_jTextFieldCantidadDeBoletosAdultosActionPerformed

    private void jRadioButtonMixtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMixtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMixtoActionPerformed

    private void jRadioButtonEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonEfectivoActionPerformed

    private void jRadioButtonMixtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMixtoMouseClicked
        String mensaje = "Su metodo de pago es: ";

        if (jRadioButtonMixto.isSelected()) {
            mensaje += "Mixto";
        }
        jLabelResultado.setText(mensaje);
    }//GEN-LAST:event_jRadioButtonMixtoMouseClicked

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
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButtonContinuar;
    public static javax.swing.JComboBox<String> jComboBoxHora;
    public static javax.swing.JComboBox<String> jComboBoxPeliculas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabelMenores;
    private javax.swing.JLabel jLabelPrecio2DAdulto;
    private javax.swing.JLabel jLabelPrecio2DNiños;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JRadioButton jRadioButtonEfectivo;
    public static javax.swing.JRadioButton jRadioButtonMixto;
    public static javax.swing.JRadioButton jRadioButtonTCredito;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosAdultos;
    public static javax.swing.JTextField jTextFieldCantidadDeBoletosNiños;
    public static javax.swing.JToggleButton jToggleButtonEncender;
    // End of variables declaration//GEN-END:variables
}
