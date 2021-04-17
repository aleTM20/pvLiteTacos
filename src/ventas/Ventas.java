/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import alertas.principal.WarningAlertCerrar;
import conexion.ConexionBD;
import static insumo.InsumosCompras.jTable1;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import principal.PrincipalAdministrador;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
import static ventas.Opciones.cc;

/**
 *
 * @author Rojeru San
 */
public class Ventas extends javax.swing.JInternalFrame {
static DecimalFormat df= new DecimalFormat("#.00");

    static ConexionBD cc = new ConexionBD();
    public static Connection conn = cc.conexion();
   
//-------------------------
public static int NO_MESA=-1;
//..................................

public static String usuario = "";
    public static DefaultTableModel modelo;
    
    /**
     * Creates new form NewJInternalFrame
     */
    public Ventas() throws SQLException {
        initComponents();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        fecha.setText(fechaactual());
        modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
        efectosTablas();
        mesasExistentes();
              
    }
    public static void calculoTotal(){
         float t = 0;
        float dr;
        for (int i = 0; i < tblDescripcion.getRowCount(); i++) {
            try {

                dr = (float) tblDescripcion.getValueAt(i, 4);
                t += dr;
            } catch (NumberFormatException|ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
        
     lblTotal.setText(df.format(t)+"");
    }
  
    public void efectosTablas(){
        modelo.addColumn("Codigo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripcion");
        modelo.addColumn("precio");
        modelo.addColumn("Total");
        tblDescripcion.setModel(modelo);
         TableColumn columna= tblDescripcion.getColumn("Codigo");
        columna.setResizable(false);
  columna.setPreferredWidth(30);
    TableColumn columnaP= tblDescripcion.getColumn("Cantidad");
    columnaP.setResizable(false);
  columnaP.setPreferredWidth(10);
    TableColumn columnaD= tblDescripcion.getColumn("Descripcion");
  columnaD.setPreferredWidth(180);
  columnaD.setResizable(false);



      tblDescripcion.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblDescripcion.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        
           DefaultTableModel modeloMesas = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };  
        modeloMesas.addColumn("Mesa");
        modeloMesas.addColumn("Total $");
        modeloMesas.addColumn("Status");

tblMesas.setModel(modeloMesas);
    TableColumn columnaM = tblMesas.getColumn("Mesa");
    columnaP.setResizable(false);
  columnaP.setPreferredWidth(10);
    TableColumn columnaT = tblMesas.getColumn("Total $");
  columnaD.setPreferredWidth(80);
  columnaD.setResizable(false);

        tblMesas.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblMesas.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane3.getHorizontalScrollBar().setUI(new MyScrollbarUI());
    }
    public static void r(DefaultTableModel modelo){
     int filas = modelo.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
    }
    public static void llenarMesa(int numero){
  DefaultTableModel modeloMesas = (DefaultTableModel) tblMesas.getModel();
        NO_MESA=numero;
    Object MESA[]={numero,0.0,"Abierta"};
    modeloMesas.addRow(MESA);
      calculoTotal();
    }
    public static  void mesasExistentes(){
        
    DefaultTableModel modeloMesas   = (DefaultTableModel) tblMesas.getModel();
    r(modeloMesas);       
           try {
            String sql = "SELECT DISTINCT(mesa) as mesa from ventasp;";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object datos[] = new Object[3];
            while (rs.next()) {
                    int mesa= rs.getInt("mesa");
                    datos[0]=mesa;
                    datos[1]=mesas(modeloMesas,mesa);
                    datos[2]="Abierta";
                    modeloMesas.addRow(datos);
            } 
            } catch (SQLException ex) {
            System.out.println("tabla descripcion "+ex.getMessage());
        }
    }
    public static float mesas(DefaultTableModel modeloMesas,int mesa){
      
        try {
            String sql = "SELECT total froM ventasp where mesa="+mesa+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            float total=0;
            while (rs.next()) {
                    float t=rs.getFloat("total");
                    total+=t;
            } 
            return total;
            } catch (SQLException ex) {
            System.out.println("tabla descripcion "+ex.getMessage());
        }
        return 0;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        btnVerTickets = new principal.MaterialButton();
        jPanel8 = new javax.swing.JPanel();
        txtImporte = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCambio = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnVender = new principal.MaterialButton();
        jPanel4 = new javax.swing.JPanel();
        txtCliente = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        btnVender1 = new principal.MaterialButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnVender2 = new principal.MaterialButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDescripcion = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        setBorder(dropShadowBorder1);
        setOpaque(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(58, 159, 171));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 50, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/caja.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VENTAS");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 40));

        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fecha.setText("fecha de hoy");
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 180, 50));

        btnVerTickets.setBackground(new java.awt.Color(255, 255, 255));
        btnVerTickets.setForeground(new java.awt.Color(58, 159, 171));
        btnVerTickets.setText("Ver Tickets");
        btnVerTickets.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Quitar</h4> </body> </html>");
        btnVerTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTickets.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVerTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTicketsActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 140, 47));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1045, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtImporte.setBorder(null);
        txtImporte.setForeground(new java.awt.Color(58, 159, 171));
        txtImporte.setText("0.00");
        txtImporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtImporte.setPlaceholder("IMPORTE");
        txtImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImporteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImporteFocusLost(evt);
            }
        });
        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImporteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteKeyTyped(evt);
            }
        });
        jPanel8.add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 110, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-importe.png"))); // NOI18N
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 180, -1));

        txtCambio.setEditable(false);
        txtCambio.setBorder(null);
        txtCambio.setForeground(new java.awt.Color(58, 159, 171));
        txtCambio.setText("0.00");
        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCambio.setPlaceholder("CAMBIO");
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });
        txtCambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCambioKeyTyped(evt);
            }
        });
        jPanel8.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 110, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-cambio.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 180, -1));

        lblTotal.setBackground(new java.awt.Color(58, 159, 171));
        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(58, 159, 171));
        lblTotal.setText("0.00");
        jPanel8.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 150, 40));

        jLabel15.setBackground(new java.awt.Color(58, 159, 171));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 159, 171));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("TOTAL : $");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        btnVender.setBackground(new java.awt.Color(58, 159, 171));
        btnVender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setText("VENDER");
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jPanel8.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, 47));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 382, 230));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCliente.setEditable(false);
        txtCliente.setBorder(null);
        txtCliente.setForeground(new java.awt.Color(58, 159, 171));
        txtCliente.setText("PUBLICO EN GENERAL");
        txtCliente.setToolTipText("");
        txtCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliente.setPlaceholder("CLIENTE");
        jPanel4.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-cliente.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        btnVender1.setBackground(new java.awt.Color(58, 159, 171));
        btnVender1.setForeground(new java.awt.Color(255, 255, 255));
        btnVender1.setText("NUEVA MESA");
        btnVender1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVender1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnVender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 170, 60));

        jSeparator1.setBackground(new java.awt.Color(58, 159, 171));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 20, 200));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPrincipal1.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 210));

        btnVender2.setBackground(new java.awt.Color(58, 159, 171));
        btnVender2.setForeground(new java.awt.Color(255, 255, 255));
        btnVender2.setText("Buscar");
        btnVender2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender2.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVender2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnVender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 170, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 620, 230));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 3));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDescripcion.setBackground(new java.awt.Color(0, 0, 0));
        tblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        tblDescripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDescripcion.setDoubleBuffered(true);
        tblDescripcion.setRowHeight(20);
        tblDescripcion.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblDescripcion.getTableHeader().setReorderingAllowed(false);
        tblDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDescripcionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDescripcion);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 650, 310));

        tblMesas.setBackground(new java.awt.Color(0, 0, 0));
        tblMesas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblMesas.setForeground(new java.awt.Color(255, 255, 255));
        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblMesas.setDoubleBuffered(true);
        tblMesas.setRowHeight(20);
        tblMesas.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblMesas.getTableHeader().setReorderingAllowed(false);
        tblMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMesas);
        tblMesas.getAccessibleContext().setAccessibleDescription("");

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 310));

        jLabel11.setBackground(new java.awt.Color(58, 159, 171));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(58, 159, 171));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DESCRIPCIÓN");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 200, 40));

        jLabel14.setBackground(new java.awt.Color(58, 159, 171));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 159, 171));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("MESAS");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 170, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 294, 1030, 370));

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

    private void txtImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyTyped
   char num = evt.getKeyChar();
        String pre=txtImporte.getText();
        boolean hay=false;
        for (int i = 0; i < pre.length(); i++) {
            if(pre.charAt(i)=='.'){
                hay=true;
            }
        }
        if ((num < '0' || num > '9')) {
            if(num!='.'||hay){
                evt.consume();
            }
        }     
    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtCambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambioKeyTyped
     
    }//GEN-LAST:event_txtCambioKeyTyped

    private void btnVender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVender1ActionPerformed
 nuevaMesa();     
    }//GEN-LAST:event_btnVender1ActionPerformed
public void nuevaMesa(){
Detalles nueva = new Detalles(new JFrame(),true);
nueva.setVisible(true);
}

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed
public static void vender(){
insertarTicket();
int ticket=UltimoTicket();
    for (int i = 0; i < tblDescripcion.getRowCount(); i++) {
        try{
       String sql = "INSERT INTO ventas VALUES (?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setInt(1, ticket);//carga el ultimo ticket
                    pst.setString(2,String.valueOf((int)tblDescripcion.getValueAt(i,0))); //carga el codigo del producto
                    pst.setInt(3,(int)tblDescripcion.getValueAt(i,1)); //carga la cantidad
                    pst.setDouble(4,(float)tblDescripcion.getValueAt(i,4));  //carga el total
                    pst.executeUpdate();
    }catch(SQLException e){
            System.err.println("vender: "+e.getMessage());
            }
}
    borrarVentasEnProceso(NO_MESA);
    mesasExistentes();
    
remove();
//VentasLista1.llenarTabla("");
lblTotal.setText("0.00");
txtImporte.setText("0.00");
txtCambio.setText("0.00");
}
public static void borrarVentasEnProceso(int mesa){
  
        String sql = "DELETE FROM ventasP WHERE mesa="+mesa+"";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("hubo un error en borrar la tabla procesos");
        }
        
}
public static int UltimoTicket(){
    String sql = "select max(idTicket) as id from ticket;";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
}
  public static void insertarTicket() {
   
        try {

            String sql = "INSERT INTO ticket VALUES (?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, 0);//carga un ticket
            pst.setString(2, fechaactual()); //carga fecha
            pst.setFloat(3, Float.parseFloat(lblTotal.getText())); //carga el total
            pst.setString(4, PrincipalAdministrador.usuario.getText());  //carga el  vendedor
            pst.setString(5, NO_MESA+"");  //carga la fecha
             pst.setString(6, "1"); 
           
            
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("INSERTAR TICKET "+ex.getMessage());
        }catch(NumberFormatException e){
                    System.out.println("no "+e.getMessage());
                    }
    }
    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
if(tblDescripcion.getRowCount()>0){
        vender();      }else{
     ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("NO SE TIENE UNA PRODUCTOS");
                er.msj1.setText("LISTOS PARA VENDER");
                er.setVisible(true);

}

    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnVerTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTicketsActionPerformed
 
        if (PrincipalAdministrador.estacerrado(PrincipalAdministrador.ventasLista)) {
            PrincipalAdministrador.ventasLista = new VentasLista1();
            int width = PrincipalAdministrador.escritorio.getWidth();
            int Height = PrincipalAdministrador.escritorio.getHeight();
            PrincipalAdministrador.ventasLista.setSize(width, Height);
            PrincipalAdministrador.escritorio.add(PrincipalAdministrador.ventasLista);
            PrincipalAdministrador.ventasLista.show();
        }   
    }//GEN-LAST:event_btnVerTicketsActionPerformed

    private void btnVender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVender2ActionPerformed
buscar();
mesasExistentes();
    }//GEN-LAST:event_btnVender2ActionPerformed
public void buscar(){
    if(NO_MESA!=-1){

        Productos1 a= new Productos1(new JFrame(),true,NO_MESA);    
a.setVisible(true);
llenarDescripcion(NO_MESA);
    }else{
     ErrorAlert wa = new ErrorAlert(new JFrame(), true);
        wa.titulo.setText("Opssss....");
        wa.msj.setText("INGRESA O SELECCIONA UNA MESA");
        wa.msj1.setText("");
        wa.setVisible(true);
    }
}
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
  
    }//GEN-LAST:event_formKeyReleased

    private void tblMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesasMouseClicked
  if(evt.getClickCount()==1){
         int fila=tblMesas.getSelectedRow();
         NO_MESA= (int) tblMesas.getValueAt(fila, 0);
         llenarDescripcion(NO_MESA);
         txtImporte.setText("0.00");
         txtCambio.setText("0.00");
        }
    }//GEN-LAST:event_tblMesasMouseClicked
         
 public String verTipo(String codigo){
                       try {
            String sql = "select tipoproducto from producto where idProducto = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if(rs.getString("tipoproducto").equals("1")){
                return "COMIDA";
                }else{
              return "BEBIDA";}
            } 
            } catch (SQLException ex) {
            System.out.println("ver tipo"+ex.getMessage());
        }
return "";
                }
    private void tblDescripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDescripcionMouseClicked
         if(evt.getClickCount()==2){
             int fila = tblDescripcion.getSelectedRow();
                String idProducto=String.valueOf((int)tblDescripcion.getValueAt(fila,0));
                  String tipo= verTipo(idProducto);
                  int cantidad= (int)tblDescripcion.getValueAt(fila,1);
                   if(tipo.equals("COMIDA")){
                       sumarInsumo(Integer.parseInt(idProducto), cantidad);
                   }else{
                   sumarInventario(Integer.parseInt(idProducto), cantidad);
                   }
                   moverDeMesa(idProducto);
                   modelo.removeRow(fila);
                   mesasExistentes();
             calculoTotal();
        }
    }//GEN-LAST:event_tblDescripcionMouseClicked

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImporteActionPerformed

    private void txtImporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyReleased
calculoCambio();
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
 if(tblDescripcion.getRowCount()>0){
        vender();      }
 
 else{
     ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("NO SE TIENE UNA PRODUCTOS");
                er.msj1.setText("LISTOS PARA VENDER");
                er.setVisible(true);

}
}
    }//GEN-LAST:event_txtImporteKeyReleased
public void calculoCambio(){
    String tota = lblTotal.getText();
        try {
            String f=txtImporte.getText();
            if(!f.equals("")){
            float toF = Float.parseFloat(tota);
            float efectivo = Float.parseFloat(f);
            float cam = (efectivo - toF);
            if (cam >= 0) {
                txtCambio.setText("$" + df.format(cam));
            }else{
            txtCambio.setText("$0.00");
            }
        }else{ 
                  txtCambio.setText(df.format(tota)); 
            }
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
}
    private void txtImporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImporteFocusLost
        if(!txtImporte.getText().equals("")){
        float ef=Float.parseFloat(txtImporte.getText());
            txtImporte.setText(df.format(ef)+"");
        }else{
        txtImporte.setText("0.00");
        }
    }//GEN-LAST:event_txtImporteFocusLost

    private void txtImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImporteFocusGained
                    txtImporte.selectAll();
    }//GEN-LAST:event_txtImporteFocusGained
  
    public void moverDeMesa(String codigo){
     try{
    String sql = "delete from ventasp where idProducto="+codigo+" and mesa="+NO_MESA+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("BORRAR EN VENTASP"+ex.getMessage());
        }
    }
    public void sumarInsumo(int codigo,int cantidad){
 String sql="select * from producto  where idProducto="+codigo+";";
           
        try {
                      
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
           while (rs.next()) {
               
              int idInsumo=rs.getInt("idInsumo");
              float cantidadReceta=rs.getFloat("cantidadInsumo");
              float enExistencia=cantidadInsumo(idInsumo);
              float necesario=cantidadReceta*cantidad;
              float devolver=necesario+enExistencia;
              sumarInsumo(idInsumo,devolver);
              }
       
        } catch (SQLException ex) {
       
        }
}
public void sumarInsumo(int idInsumo,float suma){
 try{
    String sql = "update insumos set existencias = "+suma+" where idInsumo ="+idInsumo+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("sumar inventario "+ex.getMessage());
        }
}
public float cantidadInsumo(int codigo){
       try {
            String sql = "select existencias as cantidad from insumos where idInsumo = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
              return rs.getFloat("cantidad");
            } 
            } catch (SQLException ex) {
            System.out.println("ver uni "+ex.getMessage());
        }
return -1;
} 
   public boolean isCancel(int id){
 String sql="select status from ticket  where idTicket="+id+";";
           
        try {
                      
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
          //  System.out.println("llego 1");
             if(rs.next()){
                if(rs.getString("status").equals("1")){
                return true;
                }
         }  
       
        } catch (SQLException ex) {
       
        }
        return false;
}
   public int enInventario(int codigo){
          try {
            String sql = "select cantidad from inventario where idProducto = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
              return rs.getInt("cantidad");
            } 
            } catch (SQLException ex) {
            System.out.println("ver uni "+ex.getMessage());
        }
return -1;
   }
   public void sumarInventario(int codigo,int cantidad){
   int enInventario=enInventario(codigo);
   int devolver=cantidad+enInventario;
       actualizarInventario(codigo, devolver);
   }
public void actualizarInventario(int codigo,int cantidad){
 try{
    String sql = "update inventario set cantidad = "+cantidad+" where idProducto="+codigo+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("sumar inventario "+ex.getMessage());
        }
}

    public void llenarDescripcion(int mesa){
  remove();
     
        try {
            String sql = "select * from ventasP where mesa="+mesa+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object datos[] = new Object[5];
            while (rs.next()) {
                    int can= rs.getInt("cantidad");
                    float total=rs.getFloat("total");
                datos[0] = rs.getInt("idProducto");
                datos[1] =can;
                datos[2] = rs.getString("producto");
                datos[3] = total/can;
                datos[4] = rs.getFloat("total");
                modelo.addRow(datos);
            } 
            } catch (SQLException ex) {
            System.out.println("tabla descripcion "+ex.getMessage());
        }
        calculoTotal();
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnVender;
    private principal.MaterialButton btnVender1;
    private principal.MaterialButton btnVender2;
    private principal.MaterialButton btnVerTickets;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JTable tblDescripcion;
    public static javax.swing.JTable tblMesas;
    public static app.bolivia.swing.JCTextField txtCambio;
    private app.bolivia.swing.JCTextField txtCliente;
    public static app.bolivia.swing.JCTextField txtImporte;
    // End of variables declaration//GEN-END:variables

    public static void remove(){
       int filas = modelo.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
    }
    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }
    
     public static String horaActual() {
         FECHAS f= new FECHAS();
        return f.darHora();
    }

}