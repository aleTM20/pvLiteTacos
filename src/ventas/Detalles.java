/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import principal.PrincipalMesero;

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
        this.setLocationRelativeTo(parent);
        initComponents();
     //   this.getRootPane().setOpaque(false);
    }

    public void aceptar() {
        int pos = boxType.getSelectedIndex();
        if (!this.txtNumberTable.getText().equals("")) {
            if (!this.txtIdWaiter.getText().equals("")) {
                int idWaiter = Integer.parseInt(this.txtIdWaiter.getText());
                String dato = "";
                switch (pos) {
                    case 0:
                        dato = "M";
                        break;
                    case 1:
                        dato = "B";
                        break;
                    case 2:
                        dato = "P";
                }

                String mesaV = dato + this.txtNumberTable.getText();

                if (repetido(mesaV)) {
                    if (PrincipalMesero.meseroExiste(idWaiter)) {
                        if (PrincipalMesero.meseroPassword(idWaiter, txtPassword.getText())) {
                            PrincipalMesero.llenarMesa(mesaV, idWaiter);
                            dispose();
                        } else {
                            this.lblError.setText("CONTRASEÑA INCORRECTA");
                            txtPassword.setText("");
                            txtPassword.requestFocus();
                        }
                    } else {
                        this.lblError.setText("MESERO NO ENCONTRADO");
                        this.txtIdWaiter.requestFocus();
                    }
                } else {
                    switch (pos) {
                        case 0:
                            this.lblError.setText("LA MESA ESTA EN USO");
                            this.txtNumberTable.setText("");
                            this.txtNumberTable.requestFocus();
                            break;
                        case 1:
                            this.lblError.setText("ESTA EN USO");
                            this.txtNumberTable.setText("");
                            this.txtNumberTable.requestFocus();
                            break;
                        case 2:
                            this.txtNumberTable.setText("");
                            this.txtNumberTable.requestFocus();
                            this.lblError.setText("INGRESA UN PEDIDO");
                    }
                }

            } else {
                this.lblError.setText("INGRESA UN MESERO");
                this.txtIdWaiter.setText("");
                this.txtIdWaiter.requestFocus();
            }

        } else {
            switch (pos) {
                case 0:
                    this.lblError.setText("INGRESA UNA MESA");
                    break;
                case 1:
                    this.lblError.setText("INGRESA UNA CUENTA");
                    break;
                case 2:
                    this.lblError.setText("INGRESA UN PEDIDO");
            }

            this.txtNumberTable.requestFocus();
        }
    }

    public boolean repetido(String mesa) {
        for (int i = 0; i < PrincipalMesero.tblWaiters.getRowCount(); i++) {
            String datos = (String) PrincipalMesero.tblWaiters.getValueAt(i, 0);
            if (datos.equals(mesa)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnClose = new principal.MaterialButton();
        jLabel1 = new javax.swing.JLabel();
        boxType = new componentes.org1.bolivia.combo.SComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumberTable = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdWaiter = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAddTicket = new principal.MaterialButton();
        txtPassword = new jpass.JRPasswordField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(58, 159, 171));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171), 6));
        jPanel2.setAutoscrolls(true);

        jPanel3.setBackground(new java.awt.Color(58, 159, 171));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setForeground(new java.awt.Color(58, 159, 171));
        btnClose.setText("X");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" AGREGAR TICKET");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        boxType.setBackground(new java.awt.Color(58, 159, 171));
        boxType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        boxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MESA", "BARRA", "PEDIDO" }));
        boxType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(58, 159, 171));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 159, 171));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MESA NÚMERO:");

        jLabel3.setBackground(new java.awt.Color(58, 159, 171));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 159, 171));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TIPO DE VENTA:");

        txtNumberTable.setBackground(new java.awt.Color(255, 255, 255));
        txtNumberTable.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtNumberTable.setForeground(new java.awt.Color(58, 159, 171));
        txtNumberTable.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumberTable.setToolTipText("");
        txtNumberTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        txtNumberTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumberTableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumberTableKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(58, 159, 171));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 159, 171));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID MESERO:");

        txtIdWaiter.setBackground(new java.awt.Color(255, 255, 255));
        txtIdWaiter.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIdWaiter.setForeground(new java.awt.Color(58, 159, 171));
        txtIdWaiter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdWaiter.setToolTipText("");
        txtIdWaiter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        txtIdWaiter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdWaiterKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdWaiterKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(58, 159, 171));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 159, 171));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CONTRASEÑA:");

        btnAddTicket.setBackground(new java.awt.Color(58, 159, 171));
        btnAddTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTicket.setText("AGREGAR TICKET");
        btnAddTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTicketActionPerformed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 159, 171)));
        txtPassword.setForeground(new java.awt.Color(58, 159, 171));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtPassword.setPlaceholder("*******");
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        lblError.setBackground(new java.awt.Color(58, 159, 171));
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumberTable)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdWaiter)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTicketActionPerformed
        aceptar();
    }//GEN-LAST:event_btnAddTicketActionPerformed

    private void txtNumberTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberTableKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0') || (num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumberTableKeyTyped

    private void txtIdWaiterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdWaiterKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0') || (num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdWaiterKeyTyped

    private void txtNumberTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberTableKeyReleased
        if (evt.getKeyCode() == 10) {
            aceptar();
        }
    }//GEN-LAST:event_txtNumberTableKeyReleased

    private void txtIdWaiterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdWaiterKeyReleased
        if (evt.getKeyCode() == 10) {
            aceptar();
        }
    }//GEN-LAST:event_txtIdWaiterKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (evt.getKeyCode() == 10) {
            aceptar();
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

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
    public static componentes.org1.bolivia.combo.SComboBox boxType;
    private principal.MaterialButton btnAddTicket;
    private principal.MaterialButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtIdWaiter;
    private javax.swing.JTextField txtNumberTable;
    private jpass.JRPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
