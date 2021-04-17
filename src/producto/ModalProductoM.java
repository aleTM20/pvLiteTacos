/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;

import alertas.principal.AWTUtilities;
import alertas.principal.ErrorAlert;
import alertas.principal.SuccessAlert;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 *
 * @author Rojeru San
 */
public class ModalProductoM extends javax.swing.JDialog {

    Timer timer = null;
    TimerTask task;
    int i = 32;
    static boolean opcion = true;

    /**
     * Creates new form ModalProducto
     */
    public ModalProductoM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        this.tipo.setCursor(new Cursor(12));
        this.id2.setVisible(false);
        Ubicar(0);
        this.nombre.requestFocus();
    }

    private void limpiarCampos() {

        this.nombre.requestFocus();

        this.nombre.setText("");
        this.descripcion.setText("");
        this.tipo.setSelectedIndex(0);
        this.precio.setText("");

        Opciones.listar("");
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
        jPanel2 = new javax.swing.JPanel();
        cerrar = new principal.MaterialButton();
        titulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nombre = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        descripcion = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        tipo = new componentes.org1.bolivia.combo.SComboBox();
        jLabel5 = new javax.swing.JLabel();
        precio = new app.bolivia.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        stock = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombre1 = new app.bolivia.swing.JCTextField();
        id = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        limpiar = new principal.MaterialButton();
        registrar = new principal.MaterialButton();
        id2 = new javax.swing.JLabel();

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

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("TITULO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 10, 458, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel4.setBorder(dropShadowBorder1);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBorder(null);
        nombre.setForeground(new java.awt.Color(58, 159, 171));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.setPlaceholder("NOMBRE");
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel4.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-nombre.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        descripcion.setBorder(null);
        descripcion.setForeground(new java.awt.Color(58, 159, 171));
        descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descripcion.setPlaceholder("DESCRIPCIÓN");
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });
        jPanel4.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 240, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-tipo.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ELEGIR TIPO PRODUCTO", "COMIDA", "BEBIDA" }));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoItemStateChanged(evt);
            }
        });
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        jPanel4.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 240, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-nombre.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        precio.setBorder(null);
        precio.setForeground(new java.awt.Color(58, 159, 171));
        precio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precio.setPlaceholder("PRECIO");
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        jPanel4.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 240, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas/campo-precio.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        stock.setEditable(false);
        stock.setBorder(null);
        stock.setForeground(new java.awt.Color(58, 159, 171));
        stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stock.setPlaceholder("CANTIDAD");
        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
            }
        });
        jPanel4.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 240, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo_stock.png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-nombre.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        nombre1.setBorder(null);
        nombre1.setForeground(new java.awt.Color(58, 159, 171));
        nombre1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre1.setPlaceholder("NOMBRE");
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre1KeyTyped(evt);
            }
        });
        jPanel4.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 240, 30));

        id.setBorder(null);
        id.setForeground(new java.awt.Color(58, 159, 171));
        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setPlaceholder("ID");
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 240, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos/campo-nombre.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        panel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 420, 410));

        jPanel3.setBackground(new java.awt.Color(58, 159, 171));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setForeground(new java.awt.Color(58, 159, 171));
        limpiar.setText("LIMPIAR CAMPOS");
        limpiar.setToolTipText("<html> <head> <style> #contenedor{background:#3A9FAB;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Limpiar campos</h4> </body> </html>");
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel3.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 160, 50));

        registrar.setBackground(new java.awt.Color(255, 255, 255));
        registrar.setForeground(new java.awt.Color(58, 159, 171));
        registrar.setText("REGISTRAR");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registrarKeyTyped(evt);
            }
        });
        jPanel3.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 50));

        id2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        id2.setForeground(new java.awt.Color(255, 255, 255));
        id2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id2.setText("id");
        jPanel3.add(id2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 30, -1));

        panel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 340, 459, 200));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 476, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_limpiarActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                    && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
        if (Character.isLowerCase(letras)) {
            String cad = ("" + letras).toUpperCase();
            letras = cad.charAt(0);
            evt.setKeyChar(letras);
        }
    }//GEN-LAST:event_descripcionKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_precioKeyTyped

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
        if (this.nombre.getText().equals("") || this.descripcion.getText().equals("")
                || this.tipo.getSelectedIndex() == 0 || this.precio.getText().equals("")
                || this.id.getText().equals("")) {

            ErrorAlert er = new ErrorAlert(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("FALTAN CAMPOS DE LLENAR");
            er.msj1.setText("");
            er.setVisible(true);

        } else {

            if (this.registrar.getText().equals("GUARDAR")) {
                this.id.setEditable(false);
                producto.Sentencias s = new Sentencias();

                s.setNombre(this.nombre.getText());
                s.setDescripcion(this.descripcion.getText());
                s.setTipo(this.tipo.getSelectedItem().toString());
                s.setPrecio(Double.parseDouble(this.precio.getText()));
                s.setId(this.id.getText());

                int validaStock = 0;
                if (!this.stock.getText().equals("")) {
                    validaStock = Integer.parseInt(this.stock.getText());
                    s.setStock(String.valueOf(validaStock));
                } else {

//                if (this.tipo.getSelectedIndex() == 2) {
//                    s.setStock(String.valueOf(validaStock));
//                } else {
                    s.setStock("");
//                }
                }
                int opcion = producto.Opciones.actualizar(s);
                if (opcion != 0) {
                    String fila = this.id.getText();
                    Opciones.listar("");
                    Productos.seleccionaFila(fila);
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡HECHO!");
                    sa.msj.setText("SE HAN GUARDADO LOS CAMBIOS");
                    sa.msj1.setText("");
                    sa.setVisible(true);
                }

            } else {

                producto.Sentencias s = new Sentencias();

                s.setNombre(this.nombre.getText());
                s.setDescripcion(this.descripcion.getText());
                s.setTipo(this.tipo.getSelectedItem().toString());
                s.setPrecio(Double.parseDouble(this.precio.getText()));
                s.setId(this.id.getText());

                int validaStock = 0;
                if (!this.stock.getText().equals("")) {
                    validaStock = Integer.parseInt(this.stock.getText());
                }

                if (this.tipo.getSelectedIndex() == 2) {
                    s.setStock(String.valueOf(validaStock));
                } else {
                    s.setStock("");
                }
                if (tipo.getSelectedItem().toString().equals("COMIDA")) {
                ModalIngredientesProducto mp = new ModalIngredientesProducto(new JFrame(), true);
                mp.setVisible(true);
                    
                }else{
                
                int opcion = producto.Opciones.registrar(s);
                producto.Opciones.registrarInventario(Integer.parseInt(id.getText()),Integer.parseInt(stock.getText()));
                
                 if (this.opcion == true || opcion != 0) {
//                if (opcion != 0) {
                    String fila = Opciones.extraerID();
                    limpiarCampos();
                    Productos.seleccionaFila(fila);
                    Opciones.listar("");
                    SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                    sa.titulo.setText("¡HECHO!");
                    sa.msj.setText("SE HA REGISTRADO UN");
                    sa.msj1.setText("NUEVO PRODUCTO");
                    sa.setVisible(true);
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
        Opciones.listar("");
//                }
                }
                this.opcion = true;
            }
        }
        }
    }//GEN-LAST:event_registrarActionPerformed

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

    private void registrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrarKeyTyped
        if ((evt.getKeyChar() == KeyEvent.VK_ENTER)) {
            if (this.nombre.getText().equals("") || this.descripcion.getText().equals("")
                    || this.tipo.getSelectedIndex() == 0 || this.precio.getText().equals("")) {

                ErrorAlert er = new ErrorAlert(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("FALTAN CAMPOS DE LLENAR");
                er.msj1.setText("");
                er.setVisible(true);

            } else {

                if (this.registrar.getText().equals("GUARDAR")) {

                    producto.Sentencias s = new Sentencias();

                    s.setNombre(this.nombre.getText());
                    s.setDescripcion(this.descripcion.getText());
                    s.setTipo(this.tipo.getSelectedItem().toString());
                    s.setPrecio(Double.parseDouble(this.precio.getText()));
                    s.setId(this.id2.getText());

                    int validaStock = 0;
                    if (!this.stock.getText().equals("")) {
                        validaStock = Integer.parseInt(this.stock.getText());
                        s.setStock(String.valueOf(validaStock));
                    } else {

//                if (this.tipo.getSelectedIndex() == 2) {
//                    s.setStock(String.valueOf(validaStock));
//                } else {
                        s.setStock("");
//                }
                    }

                    int opcion = producto.Opciones.actualizar(s);
                    if (opcion != 0) {
                        String fila = this.id2.getText();
                        Opciones.listar("");
                        Productos.seleccionaFila(fila);
                        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                        sa.titulo.setText("¡HECHO!");
                        sa.msj.setText("SE HAN GUARDADO LOS CAMBIOS");
                        sa.msj1.setText("");
                        sa.setVisible(true);
                    }

                } else {

                    producto.Sentencias s = new Sentencias();

                    s.setNombre(this.nombre.getText());
                    s.setDescripcion(this.descripcion.getText());
                    s.setTipo(this.tipo.getSelectedItem().toString());
                    s.setPrecio(Double.parseDouble(this.precio.getText()));

                    int validaStock = 0;
                    if (!this.stock.getText().equals("")) {
                        validaStock = Integer.parseInt(this.stock.getText());
                    }

                    if (this.tipo.getSelectedIndex() == 2) {
                        s.setStock(String.valueOf(validaStock));
                    } else {
                        s.setStock("");
                    }
                    int opcion = producto.Opciones.registrar(s);
                    if (opcion != 0) {
                        String fila = String.valueOf(Opciones.extraerID());
                        limpiarCampos();
                        Productos.seleccionaFila(fila);
                        SuccessAlert sa = new SuccessAlert(new JFrame(), true);
                        sa.titulo.setText("¡HECHO!");
                        sa.msj.setText("SE HA REGISTRADO UN");
                        sa.msj1.setText("NUEVO PRODUCTO");
                        sa.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_registrarKeyTyped

    private void stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyTyped
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_stockKeyTyped

    private void tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoItemStateChanged
        if (this.tipo.getSelectedIndex() == 0 || this.tipo.getSelectedIndex() == 1) {
            this.stock.setEditable(false);
            this.stock.setText("");
        } else {
            this.stock.setEditable(true);
            this.stock.setText("0");
        }
    }//GEN-LAST:event_tipoItemStateChanged

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    private void nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1KeyTyped

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idKeyTyped

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
            java.util.logging.Logger.getLogger(ModalProductoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalProductoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalProductoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalProductoM.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModalProductoM dialog = new ModalProductoM(new javax.swing.JFrame(), true);
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
    private principal.MaterialButton cerrar;
    public static app.bolivia.swing.JCTextField descripcion;
    public static app.bolivia.swing.JCTextField id;
    public static javax.swing.JLabel id2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private principal.MaterialButton limpiar;
    public static app.bolivia.swing.JCTextField nombre;
    public static app.bolivia.swing.JCTextField nombre1;
    private org.edisoncor.gui.panel.Panel panel1;
    public static app.bolivia.swing.JCTextField precio;
    public static principal.MaterialButton registrar;
    public static app.bolivia.swing.JCTextField stock;
    public static componentes.org1.bolivia.combo.SComboBox tipo;
    public static javax.swing.JLabel titulo;
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
        this.setLocation(603, y - 200);
    }
}
