/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import alertas.principal.ErrorAlert;
import alertas.principal.FadeEffect;
import alertas.principal.WarningAlertCerrar;
import alertas.principal.WarningAlertSalir;
import conexion.ConexionBD;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static principal.PrincipalAdministrador.cerra;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
import ventas.Ventas;

/**
 *
 * @author Rojeru San
 */
public class PrincipalMesero extends javax.swing.JFrame {

    static DecimalFormat df = new DecimalFormat("#.00");
    public static String NO_MESA = "";
    public static int MESERO = -1;
    static ConexionBD cc = new ConexionBD();
    public static Connection conn = cc.conexion();

    boolean b = true;
    private boolean minimiza = false;

    public static boolean cerra = false;
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel productModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form Principal
     */
    public PrincipalMesero() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo-icono.png")).getImage());
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        tableStyle();
        mesasExistentes();
        llenarTabla("");
    }

    public void llenarTabla(String dato) {
        cleanTable(this.productModel);
        try {
            String sql = "select idProducto as id,descripcion,tipoproducto,precio,nombre from producto where status=1 and (descripcion LIKE '%" + dato + "%' OR nombre like '%" + dato + "%');";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object[] datos = new Object[5];
            while (rs.next()) {
                datos[0] = Integer.valueOf(rs.getInt("id"));
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
                datos[4] = Float.valueOf(rs.getFloat("precio"));

                this.productModel.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("tabla productos: " + ex.getMessage());
        }
    }

    public static void mesasExistentes() {
        DefaultTableModel modeloMesas = (DefaultTableModel) tblWaiters.getModel();
        cleanTable(modeloMesas);
        try {
            String sql = "SELECT DISTINCT(mesa) as mesa,mesero from ventasp;";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object[] datos = new Object[4];
            while (rs.next()) {
                String mesa = rs.getString("mesa");
                datos[0] = mesa;
                datos[1] = df.format(mesas(modeloMesas, mesa));
                datos[2] = "Abierta";
                datos[3] = Integer.valueOf(rs.getInt("mesero"));
                modeloMesas.addRow(datos);
            }
        } catch (SQLException ex) {
            System.err.println("tabla descripcion " + ex.getMessage());
        }
    }

    public static float mesas(DefaultTableModel modeloMesas, String mesa) {
        try {
            String sql = "SELECT total froM ventasp where mesa='" + mesa + "';";

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            float total = 0.0F;
            while (rs.next()) {
                float t = rs.getFloat("total");
                total += t;
            }
            return total;
        } catch (SQLException ex) {
            System.out.println("tabla descripcion " + ex.getMessage());
        }
        return 0.0F;
    }

    public void llenarDescripcion(String mesa) {
        cleanTable(this.modelo);
        try {
            String sql = "select * from ventasP where mesa='" + mesa + "';";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object[] datos = new Object[5];
            while (rs.next()) {
                int can = rs.getInt("cantidad");
                float total = rs.getFloat("total");
                datos[0] = Integer.valueOf(rs.getInt("idProducto"));
                datos[1] = Integer.valueOf(can);
                datos[2] = rs.getString("producto");
                datos[3] = Float.valueOf(Float.parseFloat(df.format(total / can)));
                datos[4] = Float.valueOf(Float.parseFloat(df.format(rs.getFloat("total"))));
                this.modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            System.out.println("tabla descripcion " + ex.getMessage());
        }
    }

    public static void cleanTable(DefaultTableModel modelo) {
        int filas = modelo.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    public void tableStyle() {
        this.productModel.addColumn("Codigo");
        this.productModel.addColumn("Producto");
        this.productModel.addColumn("Descripcion");
        this.productModel.addColumn("Tipo de Producto");
        this.productModel.addColumn("Precio");
        tblProducts.setModel(this.productModel);
        TableColumn codeColumn = tblProducts.getColumn("Codigo");
        codeColumn.setResizable(false);
        codeColumn.setPreferredWidth(30);
        TableColumn productColumn = tblProducts.getColumn("Producto");
        productColumn.setResizable(false);
        productColumn.setPreferredWidth(100);
        TableColumn descriptionColumn = tblProducts.getColumn("Descripcion");
        descriptionColumn.setPreferredWidth(180);
        descriptionColumn.setResizable(false);
        TableColumn typeColumn = tblProducts.getColumn("Tipo de Producto");
        typeColumn.setPreferredWidth(50);
        typeColumn.setResizable(false);
        TableColumn priceColumn = tblProducts.getColumn("Precio");
        priceColumn.setResizable(false);
        priceColumn.setPreferredWidth(30);

        tblProducts.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblProducts.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tblProducts.setSelectionMode(0);
        this.scrollProducts.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollProducts.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollProducts.getVerticalScrollBar().setUI(new MyScrollbarUI());
        this.scrollProducts.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        tblProducts.getInputMap(1).put(KeyStroke.getKeyStroke(10, 0, false), "selectColumnCell");

        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Cantidad");
        this.modelo.addColumn("Descripcion");
        this.modelo.addColumn("precio");
        this.modelo.addColumn("Total");
        tblTicketDescription.setModel(this.modelo);
        TableColumn columna = tblTicketDescription.getColumn("Codigo");
        columna.setResizable(false);
        columna.setPreferredWidth(30);
        TableColumn columnaP = tblTicketDescription.getColumn("Cantidad");
        columnaP.setResizable(false);
        columnaP.setPreferredWidth(10);
        TableColumn columnaD = tblTicketDescription.getColumn("Descripcion");
        columnaD.setPreferredWidth(180);
        columnaD.setResizable(false);

        tblTicketDescription.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblTicketDescription.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tblTicketDescription.setSelectionMode(0);
        this.scrollTicketDescription.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollTicketDescription.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollTicketDescription.getVerticalScrollBar().setUI(new MyScrollbarUI());
        this.scrollTicketDescription.getHorizontalScrollBar().setUI(new MyScrollbarUI());

        DefaultTableModel modeloMesas = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modeloMesas.addColumn("Mesa/B/P");
        modeloMesas.addColumn("Total $");
        modeloMesas.addColumn("Status");
        modeloMesas.addColumn("Mesero");

        tblWaiters.setModel(modeloMesas);
        TableColumn columnaM = tblWaiters.getColumn("Mesa/B/P");
        columnaP.setResizable(false);
        columnaP.setPreferredWidth(10);
        TableColumn columnaT = tblWaiters.getColumn("Total $");
        columnaD.setPreferredWidth(80);
        columnaD.setResizable(false);

        tblWaiters.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblWaiters.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.scrollWaiters.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollWaiters.getViewport().setBackground(new Color(255, 255, 255));
        this.scrollWaiters.getVerticalScrollBar().setUI(new MyScrollbarUI());
        this.scrollWaiters.getHorizontalScrollBar().setUI(new MyScrollbarUI());
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
        minimizar = new principal.MaterialButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        minimizar1 = new principal.MaterialButton();
        minimizar2 = new principal.MaterialButton();
        minimizar3 = new principal.MaterialButton();
        jPanel3 = new javax.swing.JPanel();
        scrollTicketDescription = new javax.swing.JScrollPane();
        tblTicketDescription = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new app.bolivia.swing.JCTextField();
        scrollProducts = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        scrollWaiters = new javax.swing.JScrollPane();
        tblWaiters = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtQuantity = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        msp = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 5));

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

        minimizar.setBackground(new java.awt.Color(255, 255, 255));
        minimizar.setForeground(new java.awt.Color(58, 159, 171));
        minimizar.setText("__");
        minimizar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Minimizar</h4> </body> </html>");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-icono1.png"))); // NOI18N

        usuario.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setText("USUARIO");

        minimizar1.setBackground(new java.awt.Color(255, 255, 255));
        minimizar1.setForeground(new java.awt.Color(58, 159, 171));
        minimizar1.setText("ACTUALIZAR");
        minimizar1.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Minimizar</h4> </body> </html>");
        minimizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar1.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        minimizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizar1ActionPerformed(evt);
            }
        });

        minimizar2.setBackground(new java.awt.Color(255, 255, 255));
        minimizar2.setForeground(new java.awt.Color(58, 159, 171));
        minimizar2.setText("NUEVA MESA");
        minimizar2.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Minimizar</h4> </body> </html>");
        minimizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar2.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        minimizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizar2ActionPerformed(evt);
            }
        });

        minimizar3.setBackground(new java.awt.Color(255, 255, 255));
        minimizar3.setForeground(new java.awt.Color(58, 159, 171));
        minimizar3.setText("CERRAR SESIÓN");
        minimizar3.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Minimizar</h4> </body> </html>");
        minimizar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar3.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        minimizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minimizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(minimizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cerrar, minimizar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minimizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minimizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(minimizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cerrar, minimizar});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblTicketDescription.setBackground(new java.awt.Color(0, 0, 0));
        tblTicketDescription.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblTicketDescription.setForeground(new java.awt.Color(255, 255, 255));
        tblTicketDescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTicketDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTicketDescription.setDoubleBuffered(true);
        tblTicketDescription.setRowHeight(20);
        tblTicketDescription.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblTicketDescription.getTableHeader().setReorderingAllowed(false);
        tblTicketDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTicketDescriptionMouseClicked(evt);
            }
        });
        scrollTicketDescription.setViewportView(tblTicketDescription);

        jLabel14.setBackground(new java.awt.Color(58, 159, 171));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 159, 171));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Buscar producto:");

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        txtSearch.setForeground(new java.awt.Color(58, 159, 171));
        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.setPlaceholder("BUSCAR");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        tblProducts.setBackground(new java.awt.Color(0, 0, 0));
        tblProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblProducts.setForeground(new java.awt.Color(255, 255, 255));
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProducts.setDoubleBuffered(true);
        tblProducts.setRowHeight(20);
        tblProducts.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblProducts.getTableHeader().setReorderingAllowed(false);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        scrollProducts.setViewportView(tblProducts);

        tblWaiters.setBackground(new java.awt.Color(0, 0, 0));
        tblWaiters.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblWaiters.setForeground(new java.awt.Color(255, 255, 255));
        tblWaiters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblWaiters.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblWaiters.setDoubleBuffered(true);
        tblWaiters.setRowHeight(20);
        tblWaiters.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblWaiters.getTableHeader().setReorderingAllowed(false);
        tblWaiters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWaitersMouseClicked(evt);
            }
        });
        scrollWaiters.setViewportView(tblWaiters);

        jLabel15.setBackground(new java.awt.Color(58, 159, 171));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 159, 171));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MESA/MESERO:");

        txtQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        txtQuantity.setForeground(new java.awt.Color(58, 159, 171));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setText("1");
        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQuantity.setPlaceholder("Cantidad");
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(58, 159, 171));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 159, 171));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cantidad:");

        msp.setBackground(new java.awt.Color(58, 159, 171));
        msp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        msp.setForeground(new java.awt.Color(58, 159, 171));
        msp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel18.setBackground(new java.awt.Color(58, 159, 171));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 159, 171));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("M/B/P:");

        jLabel19.setBackground(new java.awt.Color(58, 159, 171));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 159, 171));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("DESCRIPCIÓN DEL TICKET:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msp, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollWaiters, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(scrollTicketDescription)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(msp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(scrollWaiters, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollTicketDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizarActionPerformed
        this.setExtendedState(ICONIFIED);
        if (!minimiza) {
            minimiza = false;
            this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        } else {
            minimiza = true;
        }
    }//GEN-LAST:event_minimizarActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        WarningAlertCerrar wa = new WarningAlertCerrar(this, true);
        wa.titulo.setText("¿ESTAS SEGURO?");
        wa.msj.setText("SE CERRARA LA APLICACIÓN");
        wa.msj1.setText("");
        wa.setVisible(true);
    }//GEN-LAST:event_cerrarActionPerformed

    private void minimizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizar1ActionPerformed

    private void minimizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizar2ActionPerformed

    private void minimizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizar3ActionPerformed

    private void tblTicketDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTicketDescriptionMouseClicked

    }//GEN-LAST:event_tblTicketDescriptionMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        if (evt.getClickCount() == 2) {
            if (!NO_MESA.equals("")) {
//                agregar(this.tblProducts.getSelectedRow());
//                llenarDescripcion(NO_MESA);
//                buscar.requestFocus();
//                tabla.clearSelection();
            } else {
                ErrorAlert wa = new ErrorAlert(new JFrame(), true);
                ErrorAlert.titulo.setText("Opssss....");
                ErrorAlert.msj.setText("INGRESA O SELECCIONA UNA MESA");
                ErrorAlert.msj1.setText("");
                wa.setVisible(true);
            }
        }
    }//GEN-LAST:event_tblProductsMouseClicked

    private void tblWaitersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWaitersMouseClicked
        if (evt.getClickCount() == 1) {
            int fila = tblWaiters.getSelectedRow();
            NO_MESA = (String) tblWaiters.getValueAt(fila, 0);
            MESERO = ((Integer) tblWaiters.getValueAt(fila, 3)).intValue();
            llenarDescripcion(NO_MESA);
            this.msp.setText(NO_MESA);
        }
    }//GEN-LAST:event_tblWaitersMouseClicked

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.selectAll();
    }//GEN-LAST:event_txtSearchFocusGained

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
            java.util.logging.Logger.getLogger(PrincipalMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalMesero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalMesero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private principal.MaterialButton minimizar;
    private principal.MaterialButton minimizar1;
    private principal.MaterialButton minimizar2;
    private principal.MaterialButton minimizar3;
    private javax.swing.JLabel msp;
    private javax.swing.JScrollPane scrollProducts;
    private javax.swing.JScrollPane scrollTicketDescription;
    private javax.swing.JScrollPane scrollWaiters;
    public static javax.swing.JTable tblProducts;
    public static javax.swing.JTable tblTicketDescription;
    public static javax.swing.JTable tblWaiters;
    public static app.bolivia.swing.JCTextField txtQuantity;
    public static app.bolivia.swing.JCTextField txtSearch;
    public static javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
