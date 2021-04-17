/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import conexion.ConexionBD;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
import static ventas.Ventas.conn;

/**
 *
 * @author Rojeru San
 */
public class Productos1 extends javax.swing.JDialog {
public static String id = "1";
public int MESA=0;
public static String opcion = "insertar";
    static ConexionBD cc = new ConexionBD();
    public static Connection conn = cc.conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Creates new form Principal
     */
    public Productos1(JFrame parent, boolean modal,int Mesa) {
        super(parent, modal);
        initComponents();
        this.MESA=Mesa;
       txtMesa.setText(Mesa+"");
     
       tabla();
llenarTabla("");
    }
    public void tabla( ){
        
            modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Tipo de Producto");
             modelo.addColumn("Precio");
                  modelo.addColumn("Stock");
       tabla.setModel(modelo);
         TableColumn columna= tabla.getColumn("Codigo");
        columna.setResizable(false);
  columna.setPreferredWidth(30);
    TableColumn columnaP= tabla.getColumn("Producto");
    columnaP.setResizable(false);
  columnaP.setPreferredWidth(100);
    TableColumn columnaD= tabla.getColumn("Descripcion");
  columnaD.setPreferredWidth(180);
  columnaD.setResizable(false);
 TableColumn colum= tabla.getColumn("Tipo de Producto");
  colum.setPreferredWidth(50);
  colum.setResizable(false);
         TableColumn column= tabla.getColumn("Precio");
        column.setResizable(false);
  column.setPreferredWidth(30);
   TableColumn columnn= tabla.getColumn("Stock");
        columnn.setResizable(false);
  columnn.setPreferredWidth(30);
        this.tabla.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
    
        this.tabla.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        this.setLocation(330, 120);
        AWTUtilities.setOpaque(this, true);
         tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "selectColumnCell");    
    }
    public void remove(){
       int filas = modelo.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
    }
    public int enIn(int codigo){
      try {
            String sql = "select * from inventario where idProducto="+codigo+";";
            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            
            if (rs.next()) {
//                System.out.println(rs.getInt("cantidad"));
             return rs.getInt("cantidad");
            } 
            } catch (SQLException ex) {
            System.out.println("tabla descripcion "+ex.getMessage());
        }
        return -1;
    }
    public void llenarTabla(String dato){
  remove();
     
        try {
            String sql = "select DISTINCT(producto.idProducto) as "
                    + "id,descripcion,tipoproducto,precio,nombre,"
                    + "tipoproducto from producto where descripcion LIKE '%"+dato+"%' OR nombre like '%"+dato+"%';";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            Object datos[] = new Object[6];
            while (rs.next()) {
                datos[0] = rs.getInt("id");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("descripcion");
                datos[3] = rs.getString("tipoproducto");
               datos[4] = rs.getFloat("precio");
                  if(rs.getString("tipoproducto").equals("COMIDA")){
                datos[5] = "-----";
                }else{
                    datos[5] = enIn(rs.getInt("id"));
                }
                modelo.addRow(datos);
            }
            } catch (SQLException ex) {
            System.out.println("tabla productos: "+ex.getMessage());
        }
    
}
    
     public int repetido(int codigo) {
             try {
            String sql = "SELECT cantidad from ventasp where mesa="+MESA+" and idProducto="+codigo+";";
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

    private void seleccionaFila(String id) {
        for (int i = 0; i < this.tabla.getRowCount(); i++) {
            if (id.equals(this.tabla.getValueAt(i, 0).toString())) {
                this.tabla.setRowSelectionInterval(i, i);
                break;
            }
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        jLabel10 = new javax.swing.JLabel();
        txtOpcion = new javax.swing.JLabel();
        txtMesa = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnMenos = new principal.MaterialButtonCircle();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 5));
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
        jPanel2.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 0, 54, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/productos.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        txtOpcion.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtOpcion.setForeground(new java.awt.Color(255, 255, 255));
        txtOpcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtOpcion.setText("MESA:");
        jPanel2.add(txtOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 170, 50));

        txtMesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtMesa.setForeground(new java.awt.Color(255, 255, 255));
        txtMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMesa.setText("22");
        jPanel2.add(txtMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 100, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 950, -1));

        jPanel7.setBackground(new java.awt.Color(58, 159, 171));

        tabla.setBackground(new java.awt.Color(204, 204, 204));
        tabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla.setDoubleBuffered(true);
        tabla.setRowHeight(20);
        tabla.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 940, 450));

        jPanel5.setBackground(new java.awt.Color(58, 159, 171));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 960, 260));

        btnMenos.setBackground(new java.awt.Color(58, 159, 171));
        btnMenos.setForeground(new java.awt.Color(255, 255, 255));
        btnMenos.setText("+");
        btnMenos.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Añadir</h4> </body> </html>");
        btnMenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenos.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 60, 60));

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
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 140, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-buscar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 210, -1));

        txtCantidad.setBorder(null);
        txtCantidad.setForeground(new java.awt.Color(58, 159, 171));
        txtCantidad.setText("1");
        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCantidad.setPlaceholder("CANTIDAD");
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 110, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-cantidad.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 8, 960, 590));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
//        FadeEffect.fadeOut(this, 50, 0.1f);
        producto.Opciones.commit();
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        llenarTabla(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyTyped
        char letras = evt.getKeyChar();

        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_buscarKeyTyped

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
   int fila=tabla.getSelectedRow();
           if(fila>-1){
        agregar(fila);
dispose();
           }
//        ErrorAlert er = new ErrorAlert(new JFrame(), true);
//                    er.titulo.setText("OOPS...");
//                    er.msj.setText("VERIFICA EL ALMACEN");
//                    er.msj1.setText("");
//                    er.setVisible(true);
       
    }//GEN-LAST:event_btnMenosActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
      
    }//GEN-LAST:event_tablaMouseClicked

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void tablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyReleased
if(evt.getKeyCode()==KeyEvent.VK_ENTER){
agregar(tabla.getSelectedRow());
}        
    }//GEN-LAST:event_tablaKeyReleased

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
            txtCantidad.selectAll();
    }//GEN-LAST:event_txtCantidadFocusGained
public boolean isComida(int codigo){
    try {
            String sql = "select tipoproducto from producto where idProducto = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next())
            {
                if( rs.getString("tipoproducto").equals("COMIDA")){
              return true;
                }
                else
                {return false;
                }
            } 
            } catch (SQLException ex) {
            System.out.println("ver uni "+ex.getMessage());
        }
return false;
}

public boolean restarInsumos(int codigo,int cantidad){
      try {
          ArrayList<objectI> insumos = new ArrayList();
            String sql = "select * from producto where  idProducto = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
           while (rs.next()) {
               System.out.println("1");
              int idInsumo=rs.getInt("idInsumo");
              float cantidadReceta=rs.getFloat("cantidadInsumo");
              float enExistencia=cantidadInsumo(idInsumo);
              float necesario=cantidadReceta*cantidad;
              if(enExistencia>=necesario){
              float resta=enExistencia-necesario;  
              insumos.add(new objectI(idInsumo,resta));
              
              }else{
                //  System.out.println("se va a romper la funcion");
              return false;
              }
           }
           //for para recorrer y restar los insumos de cada comida
           for (objectI insumo:insumos) {
               restarInsumo(insumo.getIdInsumo(),insumo.getResta());
          }
        
           return true;
            } catch (SQLException ex) {
            System.out.println("ver error en restar insumos "+ex.getMessage());
        }
return true;
}
public void restarInsumo(int idInsumo,float resta){
 try{
    String sql = "update insumos set existencias = "+resta+" where idInsumo ="+idInsumo+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("disminuir inventario "+ex.getMessage());
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
    public void agregar(int fila){
    
    if(!(txtCantidad.getText().equals("")||txtCantidad.getText().equals("0"))){
       int codigo=(int)tabla.getValueAt(fila, 0);
       int cantidadNueva=Integer.parseInt(txtCantidad.getText());
       int cantidad=repetido(codigo);
       int nuevaC=(cantidad+cantidadNueva);
       float precio = (float)tabla.getValueAt(fila, 4);
        if(cantidad>0){
              if(!isComida(codigo)){
            int ca=verUni(codigo);
            if(ca>=cantidadNueva){
                    int resta=ca-cantidadNueva;
             
            aumentarVentas(nuevaC,precio,codigo); 
          
            actualizarInventario(codigo,resta);
           
            }else{
              ErrorAlert  wa = new  ErrorAlert (new JFrame(), true);
        wa.titulo.setText("PRODUCTOS INSUFICIENTES");
        wa.msj.setText("");
        wa.msj1.setText("");
        wa.setVisible(true);
        return;
            }
              }else{
              if(restarInsumos(codigo,cantidadNueva)){
                  //si si hay suficientes  insumos entonces lo vendemos
               aumentarVentas(nuevaC,precio,codigo); 
              }else{
               ErrorAlert  wa = new  ErrorAlert (new JFrame(), true);
        wa.titulo.setText("INSUMOS INSUFICIENTES");
        wa.msj.setText("");
        wa.msj1.setText("");
        wa.setVisible(true);
        return;
              }
              }
        }else{
insertarProceso(fila);
        }
dispose();
}else{
 txtCantidad.setText("1");
 agregar(fila);
    }
}
public void aumentarVentas(int cantidad,float precio,int codigo){
 try{
     float pf=precio*cantidad;
    String sql = "update ventasP set cantidad = "+cantidad+",total= "+pf+" where mesa="+MESA+" and idProducto="+codigo+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("disminuir inventario "+ex.getMessage());
        }
}
public void actualizarInventario(int codigo,int cantidad){
 try{
    String sql = "update inventario set cantidad = "+cantidad+" where idProducto="+codigo+";";
//             System.out.println(sql);
     PreparedStatement pst = conn.prepareStatement(sql);
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("disminuir inventario "+ex.getMessage());
        }
}
public int verUni(int codigo){
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
public boolean tipo(int codigo){
     try {
            String sql = "select tipoproducto from producto where idProducto = "+codigo+";";
//            System.out.println(sql);
  PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if(rs.getString("tipoproducto").equals("COMIDA")){
                return true;
                }
              
            } 
            } catch (SQLException ex) {
            System.out.println("ver TIPO"+ex.getMessage());
        }
    return false;
}
public void insertarProceso(int fila){
    //System.out.println("1");
            int codigo=(int)tabla.getValueAt(fila, 0);
            int cantidad=Integer.parseInt(txtCantidad.getText());
            //este if es para saber si es una bebida o comida si es comida se va al else
            if(!tipo(codigo))
            {
                //ver unidades en el inventario
            int c=verUni(codigo);
            if(c>=cantidad){
                int resta=c-cantidad;
                actualizarInventario(codigo,resta);
                   
               
                }else{
              ErrorAlert  wa = new  ErrorAlert (new JFrame(), true);
        wa.titulo.setText("PRODUCTOS INSUFICIENTES");
        wa.msj.setText("");
        wa.msj1.setText("");
        wa.setVisible(true);
        return;
            }
            }
            else{
                if(!restarInsumos(codigo,cantidad)){
         ErrorAlert  wa = new  ErrorAlert (new JFrame(), true);
        wa.titulo.setText("INSUMOS INSUFICIENTES");
        wa.msj.setText("");
        wa.msj1.setText("");
        wa.setVisible(true);
        return;
              }}
         try {
                  
            String sql = "INSERT INTO ventasP VALUES (?,?,?,?,?)";
//             System.out.println("-->"+tabla.getValueAt(fila, 4));
float precio = (float)tabla.getValueAt(fila, 4);

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,MESA);//carga MESA 
            pst.setInt(2,codigo); //carga id P
            pst.setString(3, (String)tabla.getValueAt(fila, 1)); //carga el status
            pst.setInt(4, cantidad);  //carga el total
            pst.setFloat(5, cantidad*precio);
            
               // System.out.println(FECHAS.darHora());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("INSERTAR VentasProceso "+ex.getMessage());
        }
        
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Productos1 a= new Productos1(new JFrame(),true,5);
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
            java.util.logging.Logger.getLogger(Productos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButtonCircle btnMenos;
    public static app.bolivia.swing.JCTextField buscar;
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    public static javax.swing.JTable tabla;
    private app.bolivia.swing.JCTextField txtCantidad;
    public static javax.swing.JLabel txtMesa;
    public static javax.swing.JLabel txtOpcion;
    // End of variables declaration//GEN-END:variables


}
