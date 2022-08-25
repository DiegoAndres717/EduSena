 
package Views;

import java.awt.Color;


public class Login extends javax.swing.JFrame {

    int xmouse, ymouse;
    
    public Login() {
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

        bg = new javax.swing.JPanel();
        city = new javax.swing.JLabel();
        PANEL1 = new javax.swing.JPanel();
        exitx = new javax.swing.JLabel();
        LOGO = new javax.swing.JLabel();
        INISESION = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        ingreseusuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        contraseña1 = new javax.swing.JLabel();
        contraseña2 = new javax.swing.JSeparator();
        contraseña3 = new javax.swing.JPasswordField();
        entrar = new javax.swing.JPanel();
        entar2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LOGO1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        city.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/image.png"))); // NOI18N
        bg.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, 440));

        PANEL1.setBackground(new java.awt.Color(255, 255, 255));
        PANEL1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PANEL1MouseDragged(evt);
            }
        });
        PANEL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PANEL1MousePressed(evt);
            }
        });

        exitx.setFont(new java.awt.Font("Roboto Light", 0, 34)); // NOI18N
        exitx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitx.setText("X");
        exitx.setToolTipText("");
        exitx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitxMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout PANEL1Layout = new javax.swing.GroupLayout(PANEL1);
        PANEL1.setLayout(PANEL1Layout);
        PANEL1Layout.setHorizontalGroup(
            PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitx)
                .addContainerGap(693, Short.MAX_VALUE))
        );
        PANEL1Layout.setVerticalGroup(
            PANEL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL1Layout.createSequentialGroup()
                .addComponent(exitx, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.add(PANEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 40));

        LOGO.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        LOGO.setForeground(new java.awt.Color(0, 201, 207));
        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/favicon.png"))); // NOI18N
        LOGO.setText("Edusena ");
        bg.add(LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 110, 30));

        INISESION.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        INISESION.setForeground(new java.awt.Color(0, 134, 190));
        INISESION.setText("INICIO DE SESION");
        bg.add(INISESION, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 210, 30));

        usuario.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        usuario.setText("USUARIO");
        bg.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 70, 30));

        ingreseusuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ingreseusuario.setForeground(new java.awt.Color(204, 204, 204));
        ingreseusuario.setText("Ingrese su nombre de usuario");
        ingreseusuario.setBorder(null);
        ingreseusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ingreseusuarioMousePressed(evt);
            }
        });
        bg.add(ingreseusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 220, 30));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 260, 10));

        contraseña1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        contraseña1.setText("CONTRASEÑA");
        bg.add(contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 100, 30));
        bg.add(contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 260, 20));

        contraseña3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        contraseña3.setText("********");
        contraseña3.setBorder(null);
        contraseña3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseña3MousePressed(evt);
            }
        });
        contraseña3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseña3ActionPerformed(evt);
            }
        });
        bg.add(contraseña3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 130, -1));

        entrar.setBackground(new java.awt.Color(0, 134, 190));
        entrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entrarMouseEntered(evt);
            }
        });

        entar2.setBackground(new java.awt.Color(255, 255, 255));
        entar2.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        entar2.setForeground(new java.awt.Color(255, 255, 255));
        entar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entar2.setText("ENTRAR");
        entar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entar2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout entrarLayout = new javax.swing.GroupLayout(entrar);
        entrar.setLayout(entrarLayout);
        entrarLayout.setHorizontalGroup(
            entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entrarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(entar2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        entrarLayout.setVerticalGroup(
            entrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entar2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bg.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/favicon.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        LOGO1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        LOGO1.setForeground(new java.awt.Color(0, 134, 190));
        LOGO1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/imagenes/favicon.png"))); // NOI18N
        LOGO1.setText("Colegio ");
        bg.add(LOGO1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseña3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseña3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseña3ActionPerformed

    private void PANEL1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANEL1MousePressed
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_PANEL1MousePressed

    private void PANEL1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PANEL1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse,y - ymouse);
    }//GEN-LAST:event_PANEL1MouseDragged

    private void exitxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitxMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitxMouseClicked

    private void exitxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitxMouseEntered
        exitx.setBackground(Color.red);
    }//GEN-LAST:event_exitxMouseEntered

    private void entrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseEntered
        entrar.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_entrarMouseEntered

    private void entar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entar2MouseEntered
        entar2.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_entar2MouseEntered

    private void ingreseusuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingreseusuarioMousePressed
        ingreseusuario.setText("");
        ingreseusuario.setForeground(Color.black);
        contraseña3.setText("**********");
        ingreseusuario.setForeground(Color.gray);
    }//GEN-LAST:event_ingreseusuarioMousePressed

    private void contraseña3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseña3MousePressed
        ingreseusuario.setText("Ingrese su nombre de usuario");
        ingreseusuario.setForeground(Color.gray);
        contraseña3.setText("");
        ingreseusuario.setForeground(Color.black);
    }//GEN-LAST:event_contraseña3MousePressed

    private void entrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseClicked
         
    }//GEN-LAST:event_entrarMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel INISESION;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel LOGO1;
    private javax.swing.JPanel PANEL1;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel city;
    private javax.swing.JLabel contraseña1;
    private javax.swing.JSeparator contraseña2;
    private javax.swing.JPasswordField contraseña3;
    private javax.swing.JLabel entar2;
    private javax.swing.JPanel entrar;
    private javax.swing.JLabel exitx;
    private javax.swing.JTextField ingreseusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
