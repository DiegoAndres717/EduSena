package ViewModels;
import Models.*;
import Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ControladorUsuario implements ActionListener{
  
    
    Usuario us = new Usuario();
    MetodoUsuario cur = new MetodoUsuario();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Método constructor del controlador
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorUsuario(Colegio vista){
        this.vista = vista;
        this.vista.btnAgregarUsuario.addActionListener(this);
        this.vista.btnActualizarUsuario.addActionListener(this);
        this.vista.btnSeleccionarUsuarios.addActionListener(this);
        ListarUsuario(vista.tblUsuarios);
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void ListarUsuario(JTable tblusuarios){
        modelo = (DefaultTableModel) tblusuarios.getModel();
        List<Usuario> listacursos = cur.listar();
        Object[] object = new Object[4];
        for (int i = 0; i < listacursos.size(); i++) {
            object[0] = listacursos.get(i).getId();
            object[1] = listacursos.get(i).getContraseña();
            object[2] = listacursos.get(i).getRol();
            object[3] = listacursos.get(i).getActivo();
            modelo.addRow(object);
        }
        vista.tblUsuarios.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregarUsuario(){
        //int cocu = Integer.parseInt(vista.txtUsuario.getText());
        String cod = vista.txtContraseñaUsuario.getPassword().toString();
        String nom = vista.cbxRolUsuario.getSelectedItem().toString();
        String act = (vista.txtActivo.getText());
        //us.setId(cocu);
        us.setContraseña(cod);
        us.setRol(nom);
        us.setActivo(act);
        int r = cur.agregarUsu(us);
        if(r == 1){
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente!", 
                    "Atención!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(null, "Intente de nuevo!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        limpiartablaCurso();
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizarCurso(){
        //int cocu = Integer.parseInt(vista.txtUsuario.getText());
        String cod = vista.txtContraseñaUsuario.getPassword().toString();
        String gen = vista.cbxRolUsuario.getSelectedItem().toString();
        String act = vista.txtActivo.getText();
        //us.setId(cocu);
        us.setContraseña(cod);
        us.setRol(gen);
        us.setActivo(act);
        int r = cur.actualizarUsuarios(us);
        if(r == 1){
            JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente!", 
                    "Atención!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(null, "Intente de nuevo!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //metodo para limpiar los campos de textos
    public void limpiarCampos(){
        vista.txtCodigoUsuario.setText(null);
        vista.txtContraseñaUsuario.setText(null);
        vista.cbxRolUsuario.setSelectedItem(0);
        vista.txtActivo.setText(null);
    }
    public void limpiartablaCurso(){
        for (int i = 0; i < vista.tblUsuarios.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acción para agregar un registro
        if(e.getSource() == vista.btnAgregarUsuario){
            agregarUsuario();
            limpiartablaCurso();
            ListarUsuario(vista.tblUsuarios);
        }
        if(e.getSource() == vista.btnSeleccionarUsuarios){
            int fila = vista.tblUsuarios.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                vista.txtCodigoUsuario.setEditable(false);
                int id = Integer.parseInt(vista.tblUsuarios.getValueAt(fila, 0).toString());
                String cocu = vista.tblUsuarios.getValueAt(fila, 0).toString();
                String cod = vista.tblUsuarios.getValueAt(fila, 1).toString();
                String nom = vista.tblUsuarios.getValueAt(fila, 2).toString();
                String act = vista.tblUsuarios.getValueAt(fila, 3).toString();
                vista.txtCodigoUsuario.setText(cocu);
                vista.txtContraseñaUsuario.setText(cod);
                vista.cbxRolUsuario.setSelectedItem(nom);
                vista.txtActivo.setText(act);
            }
        }
        if(e.getSource() == vista.btnActualizarUsuario){
            actualizarCurso();
            limpiartablaCurso();
            limpiarCampos();
            ListarUsuario(vista.tblUsuarios);
        }
        
    }
    
}

