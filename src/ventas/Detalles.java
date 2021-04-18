/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import tabla.EstiloTablaHeader;
import tabla.EstiloTablaRenderer;
import tabla.MyScrollbarUI;
import static ventas.Ventas.tblDescripcion;

/**
 *
 * @author Rojeru San
 */
public class Detalles extends javax.swing.JDialog {

    /**
     * Creates new form Principal
     */
    public Detalles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
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
        mesa = new principal.MaterialTextField();
        jLabel12 = new javax.swing.JLabel();
        materialButtomRectangle1 = new principal.MaterialButtomRectangle();
        mostrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 159, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaActionPerformed(evt);
            }
        });
        mesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mesaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mesaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesaKeyTyped(evt);
            }
        });
        jPanel1.add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 170, 40));

        jLabel12.setBackground(new java.awt.Color(58, 159, 171));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Mesa No:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 200, 40));

        materialButtomRectangle1.setBackground(new java.awt.Color(0, 153, 153));
        materialButtomRectangle1.setForeground(new java.awt.Color(255, 255, 255));
        materialButtomRectangle1.setText("Aceptar");
        materialButtomRectangle1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        materialButtomRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButtomRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(materialButtomRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 50));

        mostrar.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        mostrar.setForeground(new java.awt.Color(204, 0, 0));
        mostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrar.setToolTipText("");
        jPanel1.add(mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 260, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaActionPerformed

    private void materialButtomRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButtomRectangle1ActionPerformed
        aceptar();
    }//GEN-LAST:event_materialButtomRectangle1ActionPerformed
    public void aceptar() {
        if (!mesa.getText().equals("")) {
            int mesaV = Integer.parseInt(mesa.getText());
            if (repetido(mesaV)) {
                Ventas.llenarMesa(mesaV);
                dispose();
            } else {
                mostrar.setText("LA MESA ESTA EN USO");
                mesa.setText("");
                mesa.requestFocus();
            }
        } else {
            mostrar.setText("INGRESA UNA MESA");
            mesa.requestFocus();
        }
    }

    public boolean repetido(int mesa) {
        for (int i = 0; i < Ventas.tblMesas.getRowCount(); i++) {
            if ((int) Ventas.tblMesas.getValueAt(i, 0) == mesa) {
                return false;
            }
        }
        return true;
    }
    private void mesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            aceptar();
        }
    }//GEN-LAST:event_mesaKeyReleased

    private void mesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesaKeyPressed

    }//GEN-LAST:event_mesaKeyPressed

    private void mesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesaKeyTyped
        char num = evt.getKeyChar();

        if ((num < '0' || num > '9')) {

            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_mesaKeyTyped

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
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Detalles dialog = new Detalles(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private principal.MaterialButtomRectangle materialButtomRectangle1;
    private principal.MaterialTextField mesa;
    private javax.swing.JLabel mostrar;
    // End of variables declaration//GEN-END:variables
}
