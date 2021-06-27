/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import alertas.principal.AWTUtilities;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.login.LoginView;

/**
 *
 * @author pv_lite_team
 */
public class Settings extends javax.swing.JDialog {

    static DecimalFormat df = new DecimalFormat("#.00");
    Timer timer = null;
    TimerTask task;
    int i = 32;
    private final String PATH = "C:\\TaquitosToluca\\settingsIpAddress.txt";
    private final LoginView loginView;
    /**
     * Creates new form ModalElegir
     */
    public Settings(LoginView loginView, boolean modal) {
        super(loginView, modal);
        initComponents();
        setLocationRelativeTo(null);
        AWTUtilities.setOpaque(this, false);
        Ubicar(0);
        this.loginView = loginView;
        firstOctet.requestFocus();
        chargeIPAddress();
    }

    public void chargeIPAddress() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            file = new File(PATH);
            if (file.exists()) {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                // Lectura del fichero
                String line;
                int i = 1;
                while ((line = br.readLine()) != null) {
                    //System.out.println(line);
                    switch (i) {
                        case 1:
                            String[] octets = line.split("\\.");
                            firstOctet.setText(octets[0]);
                            secondOctet.setText(octets[1]);
                            thirdOctet.setText(octets[2]);
                            fourthOctet.setText(octets[3]);
                            break;
                        case 2:
                            txtUserServer.setText(line);
                            break;
                        case 3:
                            //txtPasswordServer.setText(line);
                            break;
                        case 4:
                            txtDataBase.setText(line);
                            break;
                    }
                    i++;
                }

            } else {
                file.createNewFile();

                fichero = new FileWriter(file);
                pw = new PrintWriter(fichero);
                pw.println("192.168.0.1");
                firstOctet.setText("192");
                secondOctet.setText("168");
                thirdOctet.setText("0");
                fourthOctet.setText("1");
                fichero.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.toString());
            }
        }
    }

    private void writeSettings(String ipAddress, String user, String password, String dataBase) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                file.createNewFile();
            }

            fichero = new FileWriter(file);
            pw = new PrintWriter(fichero);

            pw.println(ipAddress);
            pw.println(user);
            pw.println(password);
            pw.println(dataBase);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void saveIpAddress() {
        lblError.setText("");
        String firstOctetText = firstOctet.getText();
        String secondOctetText = secondOctet.getText();
        String thirdOctetText = thirdOctet.getText();
        String fourthOctetText = fourthOctet.getText();
        String userText = txtUserServer.getText();
        String passwordText = txtPasswordServer.getText();
        String dataBaseText = txtDataBase.getText();
        if (!(firstOctetText.equals("") || secondOctetText.equals("") || thirdOctetText.equals("")
                || fourthOctetText.equals("") || userText.equals("") || passwordText.equals("") || dataBaseText.equals(""))) {
            String ipAddress = firstOctetText + "." + secondOctetText + "." + thirdOctetText + "." + fourthOctetText;
            String regular = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
            Pattern pat = Pattern.compile(regular);
            Matcher mat = pat.matcher(ipAddress);
            if (mat.matches()) {
                //System.out.println(ipAddress);
                writeSettings(ipAddress, userText, passwordText, dataBaseText);
                dispose();
                this.loginView.setPrensenter();
            } else {
                lblError.setText("IP Address invalida!!!");
            }
        } else {
            lblError.setText("Faltan datos!!!");
        }
    }

    private boolean checkOctet(String octet) {
        String regular = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))$";
        Pattern pat = Pattern.compile(regular);
        Matcher mat = pat.matcher(octet);
        return mat.matches();
    }

    private boolean checkNumber(char charInput) {
        return (charInput < '0' || charInput > '9');
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new org.edisoncor.gui.panel.Panel();
        btnSettings = new principal.MaterialButton();
        secondOctet = new app.bolivia.swing.JCTextField();
        txtUserServer = new app.bolivia.swing.JCTextField();
        fourthOctet = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        thirdOctet = new app.bolivia.swing.JCTextField();
        cerrar = new principal.MaterialButton();
        lblError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        firstOctet = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDataBase = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPasswordServer = new jpass.JRPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alertas/img/fondo.png"))); // NOI18N
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSettings.setBackground(new java.awt.Color(58, 159, 171));
        btnSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setText("ACEPTAR");
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        panel3.add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 370, 320, 53));

        secondOctet.setBackground(new java.awt.Color(255, 255, 255));
        secondOctet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        secondOctet.setForeground(new java.awt.Color(58, 159, 171));
        secondOctet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        secondOctet.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        secondOctet.setPhColor(new java.awt.Color(58, 159, 171));
        secondOctet.setPlaceholder("  168");
        secondOctet.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        secondOctet.setSelectionColor(new java.awt.Color(58, 159, 171));
        secondOctet.setVerifyInputWhenFocusTarget(false);
        secondOctet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondOctetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondOctetFocusLost(evt);
            }
        });
        secondOctet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                secondOctetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                secondOctetKeyTyped(evt);
            }
        });
        panel3.add(secondOctet, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 70, 40));

        txtUserServer.setBackground(new java.awt.Color(255, 255, 255));
        txtUserServer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        txtUserServer.setForeground(new java.awt.Color(58, 159, 171));
        txtUserServer.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        txtUserServer.setPhColor(new java.awt.Color(58, 159, 171));
        txtUserServer.setPlaceholder(" Usuario...");
        txtUserServer.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtUserServer.setSelectionColor(new java.awt.Color(58, 159, 171));
        txtUserServer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserServerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserServerFocusLost(evt);
            }
        });
        txtUserServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserServerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserServerKeyTyped(evt);
            }
        });
        panel3.add(txtUserServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 310, 40));

        fourthOctet.setBackground(new java.awt.Color(255, 255, 255));
        fourthOctet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        fourthOctet.setForeground(new java.awt.Color(58, 159, 171));
        fourthOctet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fourthOctet.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        fourthOctet.setPhColor(new java.awt.Color(58, 159, 171));
        fourthOctet.setPlaceholder("   10");
        fourthOctet.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        fourthOctet.setSelectionColor(new java.awt.Color(58, 159, 171));
        fourthOctet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fourthOctetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fourthOctetFocusLost(evt);
            }
        });
        fourthOctet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fourthOctetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fourthOctetKeyTyped(evt);
            }
        });
        panel3.add(fourthOctet, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 70, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 159, 171));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(".");
        panel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 10, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 159, 171));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(".");
        panel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 10, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 159, 171));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(".");
        panel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 10, 20));

        thirdOctet.setBackground(new java.awt.Color(255, 255, 255));
        thirdOctet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        thirdOctet.setForeground(new java.awt.Color(58, 159, 171));
        thirdOctet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        thirdOctet.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        thirdOctet.setPhColor(new java.awt.Color(58, 159, 171));
        thirdOctet.setPlaceholder("    0");
        thirdOctet.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        thirdOctet.setSelectionColor(new java.awt.Color(58, 159, 171));
        thirdOctet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                thirdOctetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                thirdOctetFocusLost(evt);
            }
        });
        thirdOctet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                thirdOctetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                thirdOctetKeyTyped(evt);
            }
        });
        panel3.add(thirdOctet, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 70, 40));

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
        panel3.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 45, 40));

        lblError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panel3.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 310, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(58, 159, 171));
        jLabel6.setText("Usuario:");
        panel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 310, 20));

        firstOctet.setBackground(new java.awt.Color(255, 255, 255));
        firstOctet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        firstOctet.setForeground(new java.awt.Color(58, 159, 171));
        firstOctet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstOctet.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        firstOctet.setPhColor(new java.awt.Color(58, 159, 171));
        firstOctet.setPlaceholder("  192");
        firstOctet.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        firstOctet.setSelectionColor(new java.awt.Color(58, 159, 171));
        firstOctet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstOctetFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstOctetFocusLost(evt);
            }
        });
        firstOctet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstOctetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstOctetKeyTyped(evt);
            }
        });
        panel3.add(firstOctet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 159, 171));
        jLabel7.setText("Configuración del servidor");
        panel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 270, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(58, 159, 171));
        jLabel8.setText("Ip Address:");
        panel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 159, 171));
        jLabel9.setText("Contraseña:");
        panel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 310, 20));

        txtDataBase.setBackground(new java.awt.Color(255, 255, 255));
        txtDataBase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        txtDataBase.setForeground(new java.awt.Color(58, 159, 171));
        txtDataBase.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        txtDataBase.setPhColor(new java.awt.Color(58, 159, 171));
        txtDataBase.setPlaceholder("Base de datos...");
        txtDataBase.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDataBase.setSelectionColor(new java.awt.Color(58, 159, 171));
        txtDataBase.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataBaseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataBaseFocusLost(evt);
            }
        });
        txtDataBase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataBaseKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataBaseKeyTyped(evt);
            }
        });
        panel3.add(txtDataBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 310, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(58, 159, 171));
        jLabel10.setText("Base de datos:");
        panel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 310, 20));

        txtPasswordServer.setBackground(new java.awt.Color(255, 255, 255));
        txtPasswordServer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 159, 171), 2, true));
        txtPasswordServer.setForeground(new java.awt.Color(58, 159, 171));
        txtPasswordServer.setFont(new java.awt.Font("Britannic Bold", 1, 18)); // NOI18N
        txtPasswordServer.setPhColor(new java.awt.Color(58, 159, 171));
        txtPasswordServer.setPlaceholder("Contraseña...");
        txtPasswordServer.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtPasswordServer.setSelectionColor(new java.awt.Color(58, 159, 171));
        txtPasswordServer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordServerKeyReleased(evt);
            }
        });
        panel3.add(txtPasswordServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 222, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 352) {
                    timer.cancel();
                } else {
                    Ubicar(i);
                    i += 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        saveIpAddress();
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 0) {
                    Cerrar();
                } else {
                    Ubicar(i);
                    i -= 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_cerrarActionPerformed

    private void txtUserServerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserServerKeyTyped

    }//GEN-LAST:event_txtUserServerKeyTyped

    private void secondOctetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_secondOctetKeyTyped
        char charInput = evt.getKeyChar();
        if (charInput == '.') {
            thirdOctet.requestFocus();
        }
        if (checkNumber(charInput)) {
            evt.consume();
        }
    }//GEN-LAST:event_secondOctetKeyTyped

    private void txtUserServerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserServerFocusLost

    }//GEN-LAST:event_txtUserServerFocusLost

    private void secondOctetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondOctetFocusLost
        if (!checkOctet(secondOctet.getText())) {
            secondOctet.setText("");
        }
    }//GEN-LAST:event_secondOctetFocusLost

    private void thirdOctetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thirdOctetFocusLost
        if (!checkOctet(thirdOctet.getText())) {
            thirdOctet.setText("");
        }
    }//GEN-LAST:event_thirdOctetFocusLost

    private void fourthOctetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fourthOctetFocusLost
        if (!checkOctet(fourthOctet.getText())) {
            fourthOctet.setText("");
        }
    }//GEN-LAST:event_fourthOctetFocusLost

    private void thirdOctetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thirdOctetKeyTyped
        char charInput = evt.getKeyChar();
        if (charInput == '.') {
            fourthOctet.requestFocus();
        }
        if (checkNumber(charInput)) {
            evt.consume();
        }
    }//GEN-LAST:event_thirdOctetKeyTyped

    private void fourthOctetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fourthOctetKeyTyped
        char charInput = evt.getKeyChar();
        if (checkNumber(charInput)) {
            evt.consume();
        }
    }//GEN-LAST:event_fourthOctetKeyTyped

    private void txtUserServerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserServerFocusGained
        txtUserServer.selectAll();
    }//GEN-LAST:event_txtUserServerFocusGained

    private void secondOctetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondOctetFocusGained
        secondOctet.selectAll();
    }//GEN-LAST:event_secondOctetFocusGained

    private void thirdOctetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_thirdOctetFocusGained
        thirdOctet.selectAll();
    }//GEN-LAST:event_thirdOctetFocusGained

    private void fourthOctetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fourthOctetFocusGained
        fourthOctet.selectAll();
    }//GEN-LAST:event_fourthOctetFocusGained

    private void txtUserServerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserServerKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_txtUserServerKeyReleased

    private void secondOctetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_secondOctetKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_secondOctetKeyReleased

    private void thirdOctetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thirdOctetKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_thirdOctetKeyReleased

    private void fourthOctetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fourthOctetKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_fourthOctetKeyReleased

    private void firstOctetFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstOctetFocusGained
        firstOctet.selectAll();
    }//GEN-LAST:event_firstOctetFocusGained

    private void firstOctetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstOctetFocusLost
        if (!checkOctet(firstOctet.getText())) {
            firstOctet.setText("");
        }
    }//GEN-LAST:event_firstOctetFocusLost

    private void firstOctetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstOctetKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_firstOctetKeyReleased

    private void firstOctetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstOctetKeyTyped
        char charInput = evt.getKeyChar();
        if (charInput == '.') {
            secondOctet.requestFocus();
        }
        if (checkNumber(charInput)) {
            evt.consume();
        }
    }//GEN-LAST:event_firstOctetKeyTyped

    private void txtDataBaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataBaseFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataBaseFocusGained

    private void txtDataBaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataBaseFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataBaseFocusLost

    private void txtDataBaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataBaseKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_txtDataBaseKeyReleased

    private void txtDataBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataBaseKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataBaseKeyTyped

    private void txtPasswordServerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordServerKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            saveIpAddress();
        }
    }//GEN-LAST:event_txtPasswordServerKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnSettings;
    private principal.MaterialButton cerrar;
    private app.bolivia.swing.JCTextField firstOctet;
    private app.bolivia.swing.JCTextField fourthOctet;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblError;
    private org.edisoncor.gui.panel.Panel panel3;
    private app.bolivia.swing.JCTextField secondOctet;
    private app.bolivia.swing.JCTextField thirdOctet;
    private app.bolivia.swing.JCTextField txtDataBase;
    public static jpass.JRPasswordField txtPasswordServer;
    private app.bolivia.swing.JCTextField txtUserServer;
    // End of variables declaration//GEN-END:variables

    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }

    private void Trasparencia(float trasp) {
        AWTUtilities.setOpacity(this, trasp);
    }

    private void Ubicar(int y) {
        this.setLocation(590, y - 260);
    }
}
