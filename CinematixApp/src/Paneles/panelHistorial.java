/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import Datos.Conexion;
import JFrames.FacturaReporte;
import JFrames.TextPrompt;
import JFrames.log;
import Tipografia.Fuente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Victor Reyes
 */
public class panelHistorial extends javax.swing.JPanel {

    /**
     * Creates new form panelHistorial
     */
    Fuente tipoFuente;
    log lo = new log();

    public panelHistorial() {
        initComponents();
        verificarPermisos(JFrames.LoginAdmin.usuario);
        cargarData();

        tipoFuente = new Fuente();
        tablaFacturas.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 14));
        jtextFIltroFactura.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 14));

        TextPrompt filtro = new TextPrompt("Buscar por Fecha o Vendedor", jtextFIltroFactura);
        filtro.setFont(tipoFuente.fuente(tipoFuente.LUSI, 2, 14));
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
        visualizarFactura = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        btnGenerarReporte = new javax.swing.JButton();
        jtextFIltroFactura = new javax.swing.JTextField();
        lbBuscarFactura = new javax.swing.JLabel();

        visualizarFactura.setText("Visualizar Factura");
        visualizarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarFacturaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(visualizarFactura);

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LTHistorial.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        tablaFacturas.setBackground(new java.awt.Color(61, 61, 61));
        tablaFacturas.setForeground(new java.awt.Color(255, 255, 255));
        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFacturas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaFacturas.setComponentPopupMenu(jPopupMenu1);
        tablaFacturas.setOpaque(false);
        tablaFacturas.setRowHeight(25);
        tablaFacturas.setSelectionBackground(new java.awt.Color(29, 29, 29));
        tablaFacturas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaFacturas);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 800, 540));

        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btngGenerarReporte.png"))); // NOI18N
        btnGenerarReporte.setBorder(null);
        btnGenerarReporte.setBorderPainted(false);
        btnGenerarReporte.setContentAreaFilled(false);
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.setFocusPainted(false);
        btnGenerarReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btngGenerarReporte2.png"))); // NOI18N
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 105, 219, 40));

        jtextFIltroFactura.setForeground(new java.awt.Color(255, 255, 255));
        jtextFIltroFactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtextFIltroFactura.setCaretColor(new java.awt.Color(255, 255, 255));
        jtextFIltroFactura.setOpaque(false);
        jtextFIltroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextFIltroFacturaKeyTyped(evt);
            }
        });
        add(jtextFIltroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 280, 35));

        lbBuscarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoBuscar.png"))); // NOI18N
        add(lbBuscarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 35, 35));
    }// </editor-fold>//GEN-END:initComponents

    public String historial;

    public void verificarPermisos(String usuario) {
        String sql = "SELECT * FROM permisos WHERE Usuario = '" + usuario + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                historial = rs.getString("Historial");

                if (!historial.contains("F")) {
                    tablaFacturas.setEnabled(false);
                    visualizarFactura.setVisible(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void anchoColumnas() {
        TableColumnModel anchoColumnas = tablaFacturas.getColumnModel();
        anchoColumnas.getColumn(0).setPreferredWidth(40);
        anchoColumnas.getColumn(1).setPreferredWidth(165);
        anchoColumnas.getColumn(2).setPreferredWidth(175);
        anchoColumnas.getColumn(3).setPreferredWidth(110);
        anchoColumnas.getColumn(4).setPreferredWidth(110);
        anchoColumnas.getColumn(5).setPreferredWidth(95);
        anchoColumnas.getColumn(6).setPreferredWidth(70);
        anchoColumnas.getColumn(7).setPreferredWidth(135);
    }

    ResultSet rs;
    PreparedStatement Pst;
    DefaultTableModel model;
    Conexion cc = new Conexion();
    Connection cn = cc.GetConexion();

    void cargarData() {
        String[] titulos = {"ID", "N° Factura", "Pelicula", "Fecha Emision", "Hora Emisión",
            "Forma Pago", "Total", "Vendedor"};
        String[] registros = new String[8];

        String sql = "SELECT FD.IDFacturaDetalle, FD.NumeroFactura, P.Titulo,\n"
                + "FE.FechaEmision, FE.HoraEmision, FP.Tipo, FD.Total, V.Nombre\n"
                + "FROM facturadetalle AS FD\n"
                + "INNER JOIN peliculas AS P ON FD.IdPelicula = P.IdPelicula\n"
                + "INNER JOIN salas AS S ON FD.IDSalas = S.IDSalas\n"
                + "INNER JOIN horarios AS H ON FD.IDHorario = H.IDHorario\n"
                + "INNER JOIN facturaencabezado AS FE ON FD.IDFacturaEncabezado = FE.IDFacturaEncabezado\n"
                + "INNER JOIN formaspago AS FP ON FE.IDPago = FP.IDPago\n"
                + "INNER JOIN vendedor AS V ON FE.IDVendedor = V.IDVendedor\n"
                + "ORDER BY FD.IDFacturaDetalle";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("FD.IDFacturaDetalle");
                registros[1] = rs.getString("FD.NumeroFactura");
                registros[2] = rs.getString("P.Titulo");
                registros[3] = rs.getString("FE.FechaEmision");
                registros[4] = rs.getString("FE.HoraEmision");
                registros[5] = rs.getString("FP.Tipo");
                registros[6] = rs.getString("FD.Total");
                registros[7] = rs.getString("V.Nombre");
                model.addRow(registros);
            }

            tablaFacturas.setModel(model);
            anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    void buscarData(String valor) {
        String[] titulos = {"IDFactura", "N° Factura", "Pelicula", "Fecha Emision", "Hora Emisión",
            "Forma Pago", "Total", "Vendedor"};
        String[] registros = new String[8];
        String sql = "SELECT FD.IDFacturaDetalle, FD.NumeroFactura, P.Titulo,\n"
                + "FE.FechaEmision, FE.HoraEmision, FP.Tipo, FD.Total, V.Nombre\n"
                + "FROM facturadetalle AS FD\n"
                + "INNER JOIN peliculas AS P ON FD.IdPelicula = P.IdPelicula\n"
                + "INNER JOIN salas AS S ON FD.IDSalas = S.IDSalas\n"
                + "INNER JOIN horarios AS H ON FD.IDHorario = H.IDHorario\n"
                + "INNER JOIN facturaencabezado AS FE ON FD.IDFacturaEncabezado = FE.IDFacturaEncabezado\n"
                + "INNER JOIN formaspago AS FP ON FE.IDPago = FP.IDPago\n"
                + "INNER JOIN vendedor AS V ON FE.IDVendedor = V.IDVendedor\n"
                + "WHERE CONCAT (FE.FechaEmision, ' ', V.Nombre) LIKE '%" + valor + "%'\n"
                + "ORDER BY FD.IDFacturaDetalle";

        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("FD.IDFacturaDetalle");
                registros[1] = rs.getString("FD.NumeroFactura");
                registros[2] = rs.getString("P.Titulo");
                registros[3] = rs.getString("FE.FechaEmision");
                registros[4] = rs.getString("FE.HoraEmision");
                registros[5] = rs.getString("FP.Tipo");
                registros[6] = rs.getString("FD.Total");
                registros[7] = rs.getString("V.Nombre");
                model.addRow(registros);
            }

            tablaFacturas.setModel(model);
            //anchoColumnas();
        } catch (SQLException ex) {
            Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        if (historial.contains("R")) {
            try {
                Conexion cc = new Conexion();
                Connection cn = cc.GetConexion();

                JasperReport reporte = null;
                String path = "src\\Reportes\\reporteFactura.jasper";
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);
                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(panelVendedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
            JOptionPane.showMessageDialog(null, "No cuenta con permisos para generar reportes", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void jtextFIltroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextFIltroFacturaKeyTyped
        buscarData(jtextFIltroFactura.getText());
    }//GEN-LAST:event_jtextFIltroFacturaKeyTyped

    public static String horaEmision, fechaEmision, nombreVendedor, numeroFactura, cai, fechaFinalCAI,
            pelicula, sala, hora, total, asientos, nombreCliente;
    public static boolean facturaHistorial = false;
    private void visualizarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarFacturaActionPerformed
        int fila = tablaFacturas.getSelectedRow();

        if (fila >= 0) {
            String numFactura = tablaFacturas.getValueAt(fila, 1).toString();

            String sql = "SELECT FE.HoraEmision, FE.FechaEmision, V.Nombre, FD.NumeroFactura, PAR.Valor, \n"
                    + "PAR.FechaFinal, P.Titulo, S.Sala, H.Hora, FD.Total, FD.Asientos, C.Nombre\n"
                    + "FROM facturadetalle AS FD\n"
                    + "INNER JOIN peliculas AS P ON FD.IdPelicula = P.IdPelicula\n"
                    + "INNER JOIN salas AS S ON FD.IDSalas = S.IDSalas\n"
                    + "INNER JOIN horarios AS H ON FD.IDHorario = H.IDHorario\n"
                    + "INNER JOIN facturaencabezado AS FE ON FD.IDFacturaEncabezado = FE.IDFacturaEncabezado\n"
                    + "INNER JOIN formaspago AS FP ON FE.IDPago = FP.IDPago\n"
                    + "INNER JOIN vendedor AS V ON FE.IDVendedor = V.IDVendedor\n"
                    + "INNER JOIN parametros AS PAR ON FD.IDParametro = PAR.IDParametro\n"
                    + "INNER JOIN cliente AS C ON FE.IDCliente = C.IDCliente\n"
                    + "WHERE FD.NumeroFactura = '" + numFactura + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {
                    horaEmision = rs.getString("FE.HoraEmision");
                    fechaEmision = rs.getString("FE.FechaEmision");
                    nombreVendedor = rs.getString("V.Nombre");
                    numeroFactura = rs.getString("FD.NumeroFactura");
                    cai = rs.getString("PAR.Valor");
                    fechaFinalCAI = rs.getString("PAR.FechaFinal");
                    pelicula = rs.getString("P.Titulo");
                    sala = rs.getString("S.Sala");
                    hora = rs.getString("H.Hora");
                    total = rs.getString("FD.Total");
                    asientos = rs.getString("FD.Asientos");
                    nombreCliente = rs.getString("C.Nombre");
                    if (facturaHistorial == false) {
                        FacturaReporte fr = new FacturaReporte();
                        fr.setVisible(true);
                        facturaHistorial = true;
                    } else if (facturaHistorial == true) {
                        ImageIcon jPanelIcono = new ImageIcon("src/iconos/iconoAdvertencia.png");
                        JOptionPane.showMessageDialog(null, "Ya hay una factura mostrándose", "Advertencia", JOptionPane.PLAIN_MESSAGE, jPanelIcono);
                    }
                }
            } catch (Exception e) {
                lo.LogBitacora("Ya hay una factura mostrandose" + e);
            }
        }
    }//GEN-LAST:event_visualizarFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextFIltroFactura;
    private javax.swing.JLabel lbBuscarFactura;
    public static javax.swing.JTable tablaFacturas;
    private javax.swing.JMenuItem visualizarFactura;
    // End of variables declaration//GEN-END:variables

}
