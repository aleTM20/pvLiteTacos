/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import login.*;
import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import alertas.principal.FadeEffect;
import alertas.principal.WarningAlertCerrar;
import contract.login.LoginContract;
import exception.ExceptionPvLite;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import model.User;
import presenter.login.LoginPresenter;
import principal.PrincipalAdministrador;
import principal.PrincipalMesero;
import usuarios.Opciones;
import view.administrator.InitialBox;

/**
 *
 * @author pv_lite_team
 */
public class LoginView extends javax.swing.JFrame implements LoginContract.View {

    int x, y;
    private final LoginPresenter presenter;

    /**
     * Creates new form Login
     */
    public LoginView() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo-icono.png")).getImage());
        this.setLocation(400, 100);
        AWTUtilities.setOpaque(this, false);
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        this.setLocationRelativeTo(null);
        this.txtUser.requestFocus();
        presenter = new LoginPresenter(this);
        txtPassword.setMargin(new Insets(10, 10, 10, 10));
    }

    
    public static void main(String[] args) {
        new LoginView().setVisible(true);
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
        btnClose = new principal.MaterialButton();
        jLabel1 = new javax.swing.JLabel();
        btnServerSettings = new principal.MaterialButton();
        btnLogin = new principal.MaterialButton();
        lblError = new javax.swing.JLabel();
        txtPassword = new jpass.JRPasswordField();
        txtUser = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login/fondo.png"))); // NOI18N
        panel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel1MouseDragged(evt);
            }
        });
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1MousePressed(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(58, 159, 171));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setForeground(new java.awt.Color(58, 159, 171));
        btnClose.setText("X");
        btnClose.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 45, 45));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login/logo-login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 225, 189));

        btnServerSettings.setBackground(new java.awt.Color(255, 255, 255));
        btnServerSettings.setForeground(new java.awt.Color(58, 159, 171));
        btnServerSettings.setText("RED");
        btnServerSettings.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Quitar</h4> </body> </html>");
        btnServerSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServerSettings.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnServerSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServerSettingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnServerSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 56, 42));

        panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 230));

        btnLogin.setBackground(new java.awt.Color(58, 159, 171));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setToolTipText("<html> <head> <style> #contenedor{background:white;color:black; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Cerrar</h4> </body> </html>");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFont(new java.awt.Font("Roboto Medium", 1, 20)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        panel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 450, 320, 45));

        lblError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 310, 20));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        txtPassword.setForeground(new java.awt.Color(58, 159, 171));
        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.setPlaceholder("CONTRASEÑA");
        txtPassword.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtPassword.setSelectionColor(new java.awt.Color(58, 159, 171));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        panel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 240, -1));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setBorder(null);
        txtUser.setForeground(new java.awt.Color(58, 159, 171));
        txtUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUser.setPlaceholder("USUARIO");
        txtUser.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtUser.setSelectionColor(new java.awt.Color(58, 159, 171));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });
        panel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 240, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login/campo-contrasena.png"))); // NOI18N
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login/campo-usuario.png"))); // NOI18N
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        WarningAlertCerrar wa = new WarningAlertCerrar(this, true);
        wa.titulo.setText("¿ESTAS SEGURO?");
        wa.msj.setText("SE CERRARA LA APLICACIÓN");
        wa.msj1.setText("");
        wa.setVisible(true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void panel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panel1MousePressed

    private void panel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_panel1MouseDragged

    private void btnServerSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServerSettingsActionPerformed
        Settings settings = new Settings(this, true);
        settings.setVisible(true);
    }//GEN-LAST:event_btnServerSettingsActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String user = txtUser.getText();
        String password = txtPassword.getText();
        if (!(user.equals("") || password.equals(""))) {
            presenter.login(user, password);
        } else {
            lblError.setText("¡ USUARIO Y CONTRASEÑA REQUERIDOS !");
            txtUser.requestFocus();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            String user = txtUser.getText();
            String password = txtPassword.getText();
            if (!(user.equals("") || password.equals(""))) {
                presenter.login(user, password);
            } else {
                lblError.setText("¡ USUARIO Y CONTRASEÑA REQUERIDOS !");
                txtUser.requestFocus();
            }
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            String user = txtUser.getText();
            String password = txtPassword.getText();
            if (!(user.equals("") || password.equals(""))) {
                presenter.login(user, password);
            } else {
                lblError.setText("¡ USUARIO Y CONTRASEÑA REQUERIDOS !");
                txtUser.requestFocus();
            }
        }
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        txtUser.selectAll();
    }//GEN-LAST:event_txtUserFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.selectAll();
    }//GEN-LAST:event_txtPasswordFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnClose;
    private principal.MaterialButton btnLogin;
    private principal.MaterialButton btnServerSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblError;
    private org.edisoncor.gui.panel.Panel panel1;
    public static jpass.JRPasswordField txtPassword;
    public static app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onError(ExceptionPvLite exceptionPvLite) {
        ErrorAlert errorAlert = new ErrorAlert(this, true);
        errorAlert.titulo.setText("Error");
        errorAlert.msj.setText(exceptionPvLite.getMessage());
        errorAlert.msj1.setText("<html>" + exceptionPvLite.getCauseMessage() + "</html>");
        errorAlert.setVisible(true);
    }

    @Override
    public void onErrorLogin() {
        lblError.setText("¡ USUARIO O CONTRASEÑA INCORRECTOS !");
        txtUser.requestFocus();
    }

    @Override
    public void onShowAdministratorView(User user) {
        PrincipalAdministrador administrator = new PrincipalAdministrador(user);
        administrator.setVisible(true);
        dispose();
    }

    @Override
    public void onShowWaiterView(User user) {
        PrincipalMesero waiter = new PrincipalMesero(user);
        waiter.setVisible(true);
        dispose();
    }

    @Override
    public void onShowInitialBalanceModal(User user) {
        InitialBox box = new InitialBox(this, true, this, user);
        box.setVisible(true);
    }
}
