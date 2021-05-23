/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import conexion.ConexionBD;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import principal.PrincipalAdministrador;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;

/**
 *
 * @author Rojeru San
 */
public class Tickets extends javax.swing.JDialog {

    static ConexionBD cc = new ConexionBD();
    public static Connection conn = cc.conexion();

    /**
     * Creates new form ModalElegir
     */
    public Tickets(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        table();
        setLocationRelativeTo(parent);
        llenarTabla("SELECT * FROM ticket where fecha='" + fechaactual() + "' ORDER by idTicket DESC;");
    }

    public void table() {
        tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tabla.setSelectionMode(0);
        this.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        this.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        this.jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        this.jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
    }

    public void llenarTabla(String sql) {
        //System.out.println(sql);
        DefaultTableModel modeloMesas = (DefaultTableModel) tabla.getModel();
        while (modeloMesas.getRowCount() > 0) {
            modeloMesas.removeRow(0);
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object[] datos = new Object[6];
            while (rs.next()) {
                datos[0] = Integer.valueOf(rs.getInt("idTicket"));
                datos[1] = rs.getString("fecha");
                datos[3] = rs.getString("vendedor");
                datos[2] = Float.valueOf(rs.getFloat("total"));
                datos[4] = rs.getString("mesa");
                if (rs.getString("status").equals("1")) {
                    datos[5] = "ACTIVO";
                } else {
                    datos[5] = "CANCELADO";
                }

                modeloMesas.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("tabla descripcion " + ex.getMessage());
        }
    }

    public static String fechaactual() /*     */ {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }

    public void cancelarTicket(int idTicket) {
        try {
            String sql = "select DISTINCT(producto.idproducto)as id,tipoproducto,cantidad from ticket INNER JOIN ventas on ventas.idTicket=ticket.idTicket INNER JOIN producto on producto.idproducto=ventas.id_Producto where ticket.idTicket=" + idTicket + ";";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                String idProducto = rs.getString("id");
                String tipo = rs.getString("tipoproducto");
                int cantidad = rs.getInt("cantidad");
                if (tipo.equals("COMIDA")) {
                    sumarInsumo(Integer.parseInt(idProducto), cantidad);
                } else {
                    sumarInventario(Integer.parseInt(idProducto), cantidad);
                }
            }

            updateTicket(idTicket);
        } catch (SQLException ex) {
            System.out.println("tabla descripcion " + ex.getMessage());
        }
    }

    public void updateTicket(int codigo) {
        try {
            String sql = "update ticket set status = 2 where idTicket =" + codigo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("sumar inventario " + ex.getMessage());
        }
    }

    public void sumarInsumo(int codigo, int cantidad) {
        String sql = "select * from reseta  where idProducto=" + codigo + ";";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                int idInsumo = rs.getInt("idInsumo");
                float cantidadReceta = rs.getFloat("cantidadInsumo");
                float enExistencia = cantidadInsumo(idInsumo);
                float necesario = cantidadReceta * cantidad;
                float devolver = necesario + enExistencia;
                sumarInsumo(idInsumo, devolver);
            }
        } catch (SQLException localSQLException) {
        }
    }

    public void sumarInsumo(int idInsumo, float suma) {
        try {
            String sql = "update insumos set existencias = " + suma + " where idInsumo =" + idInsumo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("sumar inventario " + ex.getMessage());
        }
    }

    public float cantidadInsumo(int codigo) {
        try {
            String sql = "select existencias as cantidad from insumos where idInsumo = " + codigo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                return rs.getFloat("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("ver uni " + ex.getMessage());
        }
        return -1.0F;
    }

    public boolean isCancel(int id) {
        String sql = "select status from ticket  where idTicket=" + id + ";";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            if ((rs.next())
                    && (rs.getString("status").equals("1"))) {
                return true;
            }
        } catch (SQLException localSQLException) {
        }

        return false;
    }

    public int enInventario(int codigo) {
        try {
            String sql = "select cantidad from inventario where idProducto = " + codigo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("ver uni " + ex.getMessage());
        }
        return -1;
    }

    public void sumarInventario(int codigo, int cantidad) {
        int enInventario = enInventario(codigo);
        int devolver = cantidad + enInventario;
        actualizarInventario(codigo, devolver);
    }

    public void actualizarInventario(int codigo, int cantidad) {
        try {
            String sql = "update inventario set cantidad = " + cantidad + " where idProducto=" + codigo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("sumar inventario " + ex.getMessage());
        }
    }

    public String dar(String fecha) {
        String fe = "";
        String nueF = "";
        if (fecha.charAt(2) == '/') {
            fe = fe + fecha.substring(6);
            String fe2 = fecha.substring(3, 5);
            String fe3 = fecha.substring(0, 2);
            nueF = "20" + fe + "-" + fe2 + "-" + fe3;
            return nueF;
        }

        fe = fe + fecha.substring(5);
        String fe2 = fecha.substring(2, 4);
        String fe3 = fecha.substring(0, 1);
        nueF = "20" + fe + "-" + fe2 + "-0" + fe3;
        return nueF;
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
        ver = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        reimprimir = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cancel = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        ver.setText("DETALLES");
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ver);
        jPopupMenu1.add(jSeparator1);

        reimprimir.setText("REIMPRIMIR TICKET");
        reimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reimprimirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(reimprimir);
        jPopupMenu1.add(jSeparator2);

        cancel.setText("CANCELAR");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(cancel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(58, 159, 171));

        jPanel2.setBackground(new java.awt.Color(58, 159, 171));

        cerrar.setBackground(new java.awt.Color(255, 255, 255));
        cerrar.setForeground(new java.awt.Color(58, 159, 171));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/caja.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VENTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(58, 159, 171));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarKeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-buscar.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 159, 171));
        jLabel1.setText("a");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 159, 171));
        jLabel2.setText("de");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 159, 171));
        jLabel5.setText("Buscar por fecha");

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserCombo1.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserCombo1OnCommit(evt);
        }
    });

    dateChooserCombo2.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserCombo2OnCommit(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(124, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel3)))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );

    tabla.setBackground(new java.awt.Color(0, 0, 0));
    tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    tabla.setForeground(new java.awt.Color(255, 255, 255));
    tabla.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[] {"No.TICKET", "FECHA", "$ TOTAL", "VENDEDOR", "MESA", "STATUS" })
        {
            boolean[] canEdit = { false, false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return this.canEdit[columnIndex];
            }
        }
    );
    tabla.setComponentPopupMenu(jPopupMenu1);
    tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tabla.setDoubleBuffered(true);
    tabla.setRowHeight(20);
    tabla.setSelectionBackground(new java.awt.Color(0, 153, 255));
    tabla.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(tabla);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed

        producto.Opciones.cancelarTransaccion();
        this.dispose();

    }//GEN-LAST:event_cerrarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        String dato = buscar.getText();
        llenarTabla("SELECT * FROM `ticket` where vendedor like '%" + dato + "%' or idTicket like '%" + dato + "%' or mesa like '%" + dato + "%'  ORDER by idTicket DESC");
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();
        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void dateChooserCombo1OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnCommit
        llenarTabla("SELECT * FROM ticket where (fecha BETWEEN '" + dar(this.dateChooserCombo1.getText()) + "' and '" + dar(this.dateChooserCombo2.getText()) + "' ) ORDER by idTicket DESC");
    }//GEN-LAST:event_dateChooserCombo1OnCommit

    private void dateChooserCombo2OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo2OnCommit
        llenarTabla("SELECT * FROM ticket where (fecha BETWEEN '" + dar(this.dateChooserCombo1.getText()) + "' and '" + dar(this.dateChooserCombo2.getText()) + "' ) ORDER by idTicket DESC");
    }//GEN-LAST:event_dateChooserCombo2OnCommit

    private void reimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reimprimirActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila > -1) {
            int codigo = ((Integer) tabla.getValueAt(fila, 0)).intValue();
            reimprimir(codigo);
        } else {
            ErrorAlert wa = new ErrorAlert(new JFrame(), true);
            ErrorAlert.titulo.setText("Opssss....");
            ErrorAlert.msj.setText("SELECCIONA UNA FILA");
            ErrorAlert.msj1.setText("");
            wa.setVisible(true);
        }
    }//GEN-LAST:event_reimprimirActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila > -1) {
            int codigo = ((Integer) tabla.getValueAt(fila, 0)).intValue();
            if (isCancel(codigo)) {
                cancelarTicket(codigo);
                llenarTabla("select * from ticket;");
            } else {
                ErrorAlert wa = new ErrorAlert(new JFrame(), true);
                ErrorAlert.titulo.setText("Opssss....");
                ErrorAlert.msj.setText("Ticket ya cancelado");
                ErrorAlert.msj1.setText("");
                wa.setVisible(true);
            }
        } else {
            ErrorAlert wa = new ErrorAlert(new JFrame(), true);
            ErrorAlert.titulo.setText("Opssss....");
            ErrorAlert.msj.setText("SELECCIONA UNA FILA");
            ErrorAlert.msj1.setText("");
            wa.setVisible(true);
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        int fila = tabla.getSelectedRow();
        if (fila > -1) {
            int codigo = ((Integer) tabla.getValueAt(fila, 0));
            TicketDetail detalles = new TicketDetail(new JFrame(), true, codigo);
            detalles.validate();
            detalles.setVisible(true);
        } else {
            ErrorAlert wa = new ErrorAlert(new JFrame(), true);
            ErrorAlert.titulo.setText("Opssss....");
            ErrorAlert.msj.setText("SELECCIONA UNA FILA");
            ErrorAlert.msj1.setText("");
            wa.setVisible(true);
        }
    }//GEN-LAST:event_verActionPerformed

    private void reimprimir(int codigo) {
        ArrayList productos = productosV(codigo);
        String hora = "";
        String fecha = "";
        int ticket = 0;
        float total = 0.0F;
        float efectivo = 0.0F;
        float cambio = 0.0F;
        try {
            String sql = "select idTicket,fecha,hora,efectivo,total from ticket where idTicket=" + codigo + ";";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                fecha = rs.getString("fecha");
                hora = rs.getString("hora");
                ticket = rs.getInt("idTicket");
                total = rs.getFloat("total");
                efectivo = rs.getFloat("efectivo");
                cambio = efectivo - total;
            }
        } catch (SQLException ex) {
            System.out.println("ver ticket: " + ex.getMessage());
        }
        printT imprimir = new printT(hora, fecha, ticket, productos, total, efectivo, cambio);
    }

    public ArrayList<productosObject> productosV(int ticket) {
        ArrayList productos = new ArrayList();
        try {
            String sql = "select CONCAT(nombre,' ',descripcion) as nombre,precio,cantidad,ventas.total as total from ticket join ventas on ventas.idTicket=ticket.idTicket join producto on producto.idproducto=ventas.id_producto where ticket.idTicket=" + ticket + ";";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);

            while (rs.next()) {
                productos.add(new productosObject(rs.getInt("cantidad"), rs.getString("nombre"), rs.getFloat("precio"), rs.getFloat("total")));
            }
        } catch (SQLException ex) {
            System.out.println("traer productos" + ex.getMessage());
        }
        return productos;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Tickets(new JFrame(), true).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static app.bolivia.swing.JCTextField buscar;
    private javax.swing.JMenuItem cancel;
    private principal.MaterialButton cerrar;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem reimprimir;
    public static javax.swing.JTable tabla;
    private javax.swing.JMenuItem ver;
    // End of variables declaration//GEN-END:variables

}
