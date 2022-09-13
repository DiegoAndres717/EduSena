package Views;

import Conexion.Conexion;
import Models.MetodoAlumno;
import Models.MetodoDocente;
import Models.Persona;
import ViewModels.ControladorAlumno;
import ViewModels.ControladorBuscarNotas;
import ViewModels.ControladorCursos;
import ViewModels.ControladorDocente;
import ViewModels.ControladorLogin;
import ViewModels.ControladorNotas;
import ViewModels.ControladorUsuario;
import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class LoginEduSena extends javax.swing.JFrame {

    /**
     * Creates new form LoginEduSena
     */
    int xMouse, yMouse;

    public LoginEduSena(Colegio usuarios) {
        this.setLocationRelativeTo(null);
        initComponents();
        roles();
        setIconImage(getIconImage());

    }

    private void roles() {
        cbxRoles.addItem("-- Seleccionar --");
        cbxRoles.addItem("Estudiante");
        cbxRoles.addItem("Docente");
        cbxRoles.addItem("Rector");
    }

    @Override
    public Image getIconImage() {
        Image reValue = getToolkit().getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos/favicon.png"));
        return reValue;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlbContraseña = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cbxRoles = new javax.swing.JComboBox<>();
        barraMover = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnSalirLogin = new newscomponents.RSButtonIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(800, 500));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/female-ga97ccfabe_1920 (2).jpg"))); // NOI18N
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 0, -1, 500));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 213, 225));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/favicon_1.png"))); // NOI18N
        jLabel1.setText("EduSena");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("INICIAR SESIÓN");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 140, 30));

        jlbUsuario.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jlbUsuario.setForeground(new java.awt.Color(0, 204, 204));
        jlbUsuario.setText("USUARIO");
        bg.add(jlbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });
        bg.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 240, -1));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 210, -1));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 210, -1));

        jlbContraseña.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jlbContraseña.setForeground(new java.awt.Color(0, 204, 204));
        jlbContraseña.setText("CONTRASEÑA");
        bg.add(jlbContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("**********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        bg.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 240, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("ROL");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        cbxRoles.setBorder(null);
        cbxRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.add(cbxRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 160, 30));

        barraMover.setBackground(new java.awt.Color(255, 255, 255));
        barraMover.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMoverMouseDragged(evt);
            }
        });
        barraMover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMoverMousePressed(evt);
            }
        });

        javax.swing.GroupLayout barraMoverLayout = new javax.swing.GroupLayout(barraMover);
        barraMover.setLayout(barraMoverLayout);
        barraMoverLayout.setHorizontalGroup(
            barraMoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        barraMoverLayout.setVerticalGroup(
            barraMoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(barraMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        btnIngresar.setBackground(new java.awt.Color(0, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        bg.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 90, 30));

        btnSalirLogin.setBackground(new java.awt.Color(255, 51, 51));
        btnSalirLogin.setBorder(new javax.swing.border.MatteBorder(null));
        btnSalirLogin.setText("Salir");
        btnSalirLogin.setBackgroundHover(new java.awt.Color(204, 0, 0));
        btnSalirLogin.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalirLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirLoginActionPerformed(evt);
            }
        });
        bg.add(btnSalirLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barraMoverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMoverMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraMoverMousePressed

    private void barraMoverMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMoverMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraMoverMouseDragged

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
        if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("**********");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getPassword()).equals("**********")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed
    private ControladorLogin login;
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //javax.swing.JOptionPane.showMessageDialog(this, "Intento de Login con los datos:\nUsuario: "+txtUsuario.getText() + 
        // "\nContraseña: "+String.valueOf(txtPassword.getPassword()), "LOGIN", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        var label = new ArrayList<JLabel>();
        label.add(jlbUsuario);
        label.add(jlbContraseña);
        var textField = new ArrayList<JTextField>();
        textField.add(txtUsuario);
        textField.add(txtPassword);

        login = new ControladorLogin(label, textField);
        Object[] objects = login.Login();

        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());
        String roll = (String) cbxRoles.getSelectedItem();
        String sql = "SELECT idCodigo, contraseña, rol FROM "
                + "usuarios WHERE idCodigo='" + user + "' AND contraseña='" + pass + "' AND rol='" + roll + "' AND activo = 1";
        Conexion conectar = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = conectar.getConnecion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                // si existe el usuario
                String us = rs.getString("idCodigo");
                String pa = rs.getString("contraseña");
                String ro = rs.getString("rol");
                int x = 0;

                if (pass.equals(pa) && user.equals(us) && roll.equals("Rector")) {
                    x = 1;
                }
                if (pass.equals(pa) && user.equals(us) && roll.equals("Docente")) {
                    x = 2;
                }
                if (pass.equals(pa) && user.equals(us) && roll.equals("Estudiante")) {
                    x = 3;

                }
                switch (x) {
                    case 1 -> {
                        //Colegio.Tipo_Usuario = "Rector";
                        this.setVisible(false);
                        Colegio rector = new Colegio();
                        ControladorNotas N = new ControladorNotas(rector);
                        ControladorAlumno al = new ControladorAlumno(rector);
                        ControladorDocente doc = new ControladorDocente(rector);
                        ControladorCursos conre = new ControladorCursos(rector);
                        ControladorUsuario uss = new ControladorUsuario(rector);
                        rector.setVisible(true);
                        break;
                    }
                    case 2 -> {
                        //Colegio.Tipo_Usuario = "Docente";
                        Colegio docente = new Colegio();
                        this.setVisible(false);
                        Colegio.btnAlumno.setVisible(false);
                        Colegio.btnRectoria.setVisible(false);
                        ControladorDocente conde = new ControladorDocente(docente);
                        ControladorAlumno cona = new ControladorAlumno(docente);
                        ControladorNotas N = new ControladorNotas(docente);
                        ControladorCursos C = new ControladorCursos(docente);
                        
                        Persona use = new Persona();
                        MetodoDocente dao = new MetodoDocente();
                        use.setCodigo(Integer.parseInt(txtUsuario.getText()));
                        
                        if (dao.UsuarioIngresadoD(use)) {
                            docente.txtNombreAlumno2.setText((use.getNombres()));
                            docente.txtApellidoAlumno2.setText((use.getApellidos()));
                            docente.txtNidAlumno2.setText((use.getNid()));
                            docente.txtEmailAlumno2.setText((use.getEmail()));
                            docente.txtTelefonoAlumno2.setText(String.valueOf(use.getTelefono()));
                            docente.txtDireccionAlumno2.setText((use.getDireccion()));
                            docente.txtGeneroAlumno1.setText((use.getGenero()));
                            docente.txtFechaNacimientoAlumno1.setText((use.getFecha_nacimiento()));
                        } else {
                            System.out.println("Há ocurrido un error");
                        }
                        docente.setVisible(true);
                        break;
                    }
                    case 3 -> {
                        // Colegio.Tipo_Usuario = "Estudiante";
                        this.setVisible(false);
                        Colegio alumno = new Colegio();
                        Colegio.btnDocente.setVisible(false);
                        Colegio.btnRectoria.setVisible(false);
                        ControladorAlumno cona = new ControladorAlumno(alumno);
                        ControladorNotas N = new ControladorNotas(alumno);
                        ControladorBuscarNotas no = new ControladorBuscarNotas(alumno);

                        Persona use = new Persona();
                        MetodoAlumno dao = new MetodoAlumno();
                        use.setCodigo(Integer.parseInt(txtUsuario.getText()));
                        if (dao.UsuarioIngresado(use)) {
                            alumno.txtNombreAlumno1.setText((use.getNombres()));
                            alumno.txtApellidoAlumno1.setText((use.getApellidos()));
                            alumno.txtNidAlumno1.setText((use.getNid()));
                            alumno.txtEmailAlumno1.setText((use.getEmail()));
                            alumno.txtTelefonoAlumno1.setText(String.valueOf(use.getTelefono()));
                            alumno.txtDireccionAlumno1.setText((use.getDireccion()));
                            alumno.txtGradoAlumno1.setText(String.valueOf(use.getGrado()));
                            alumno.txtGeneroAlumno.setText((use.getGenero()));
                            alumno.txtFechaNacimientoAlumno.setText((use.getFecha_nacimiento()));
                        } else {
                            System.out.println("Há ocurrido un error");
                        }

                        alumno.setVisible(true);
                        break;
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Usuario no existe", "Atención", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {
                //si no existe el usuario
                JOptionPane.showMessageDialog(null, "La información de Usuario y Contraseña ingresada no es correcta", "Atención!", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        btnIngresar.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        btnIngresar.setBackground(new Color(0, 204, 204));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if (txtUsuario.getText().equals("")) {
            jlbUsuario.setForeground(new Color(102, 102, 102));
        } else {
            jlbUsuario.setText("USUARIO");
            jlbUsuario.setForeground(new Color(0, 153, 51));
        }
        //Label_Mensaje.setText("");
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if (txtPassword.getPassword().equals("")) {
            jlbContraseña.setForeground(new Color(102, 102, 102));
        } else {
            jlbContraseña.setText("CONTRASEÑA");
            jlbContraseña.setForeground(new Color(0, 153, 51));
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnSalirLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirLoginActionPerformed
        int sa = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿Desea Salir?", "Salir!", sa);
        if (resultado == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginEduSena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginEduSena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginEduSena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginEduSena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginEduSena(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraMover;
    public transient javax.swing.JPanel bg;
    public javax.swing.JButton btnIngresar;
    private newscomponents.RSButtonIcon_new btnSalirLogin;
    public javax.swing.JComboBox<String> cbxRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlbContraseña;
    private javax.swing.JLabel jlbUsuario;
    public transient javax.swing.JPasswordField txtPassword;
    public transient javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
