/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insumo;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;

/**
 *
 * @author Rojeru San
 */
public class fechCad extends javax.swing.JDialog {

  

    /**
     * Creates new form ModalProducto
     */
    public fechCad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);  
               this.jTable1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.jTable1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        jTable1.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "selectColumnCell");
        Opciones.listarInsumos();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cerrar = new principal.MaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(58, 159, 171));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 159, 171));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR PRODUCTO DESCOMPUESTO");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 380, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_INSUMO","INSUMO","EXISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 530, 230));

        jTextField1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(58, 159, 171));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        panel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 159, 171));
        jLabel2.setText("CANTIDAD:");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 30));

        cerrar.setBackground(new java.awt.Color(58, 159, 171));
        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setText("X");
        cerrar.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        panel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 10, 60, 40));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          int fila=jTable1.getSelectedRow();
                    if(fila>-1){
          
                agregar(fila);
      }else{
        ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECIONA UNA FILA");
                er.msj1.setText("");
                er.setVisible(true);
      }
                }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
      int fila=jTable1.getSelectedRow();
      if(fila>-1){
          
                agregar(fila);
      }else{
        ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECIONA UNA FILA");
                er.msj1.setText("");
                er.setVisible(true);
      }
  
  }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            if(evt.getClickCount()==2){
                int fila=jTable1.getSelectedRow();
                agregar(fila);
            }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
   char num = evt.getKeyChar();
        String pre=jTextField1.getText();
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
    }//GEN-LAST:event_jTextField1KeyTyped
public void agregar(int fila){
int id=(int) jTable1.getValueAt(fila, 0);
String descripcion=(String) jTable1.getValueAt(fila, 1);
float cantidad=Float.parseFloat(jTextField1.getText());
float existe=Opciones.cantidadInsumo(id);
if(cantidad<=existe){
Opciones.insertInsumoVencido(id, descripcion, cantidad, fechaactual());
float sumaT=existe-cantidad;
Opciones.sumarInsumo(id, sumaT);
 Opciones.listarInsumosVencidos(fechaactual());
 this.dispose();
}
else{
    ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("NO SE TIENE LA SUFICIENTE");
                er.msj1.setText("CANTIDAD EN INSUMO");
                er.setVisible(true);
                
}

}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
   public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);
    }
}
