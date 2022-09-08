package ViewModels;
import Models.*;
import Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ControladorCursos implements ActionListener{
  
    
    Cursos us = new Cursos();
    MetodoCurso cur = new MetodoCurso();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Método constructor del controlador
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorCursos(Colegio vista){
        this.vista = vista;
        this.vista.btnAgregarCursos.addActionListener(this);
        this.vista.btnSeleccionarCurso.addActionListener(this);
        this.vista.btnActualizarCurso.addActionListener(this);
        this.vista.btnBorrarCurso.addActionListener(this);
        ListarCursos(vista.tblCursos);
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void ListarCursos(JTable tblcurso){
        modelo = (DefaultTableModel) tblcurso.getModel();
        List<Cursos> listacursos = cur.listarCu();
        Object[] object = new Object[4];
        for (int i = 0; i < listacursos.size(); i++) {
            object[0] = listacursos.get(i).getId();
            object[1] = listacursos.get(i).getMateria();
            object[2] = listacursos.get(i).getIdProfesor();
            modelo.addRow(object);
        }
        vista.tblCursos.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregarCurso(){
        String cod = vista.cbxCursoMateria.getSelectedItem().toString();
        String nom = vista.txtCursoidProfesor.getText();
        us.setMateria(cod);
        us.setIdProfesor(nom);
        int r = cur.agregarCurso(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro exitoso!");
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
        limpiartablaCurso();
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizarCurso(){
        String gen = vista.cbxCursoMateria.getSelectedItem().toString();
        String cod = (vista.txtCursoidProfesor.getText());
        us.setMateria(gen);
        us.setIdProfesor(cod);
        int r = cur.actualizarCu(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro actualizado");
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
    }
    
    public void eliminarCurso(){
        int fila = vista.tblCursos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(vista,"Debe seleccionar un registro");
            limpiarCampos();
        }
        else{
            int doc = Integer.parseInt(vista.tblCursos.getValueAt(fila, 0).toString());
            cur.eliminarCursos(doc);
            JOptionPane.showMessageDialog(vista, "Registro eliminado");
        }
        
    }
    //metodo para limpiar los campos de textos
    public void limpiarCampos(){
        vista.cbxCursoMateria.setSelectedItem(0);
        vista.txtCursoidProfesor.setText(null);
    }
    public void limpiartablaCurso(){
        for (int i = 0; i < vista.tblCursos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acción para agregar un registro
        if(e.getSource() == vista.btnAgregarCursos){
            agregarCurso();
            limpiartablaCurso();
            ListarCursos(vista.tblCursos);
        }
        if(e.getSource() == vista.btnSeleccionarCurso){
            int fila = vista.tblCursos.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                //vista.txtNidAlumno.setEditable(false);
                int id = Integer.parseInt(vista.tblCursos.getValueAt(fila, 0).toString());
                String cod = vista.tblCursos.getValueAt(fila, 1).toString();
                String nom = vista.tblCursos.getValueAt(fila, 2).toString();
                vista.cbxCursoMateria.setSelectedItem(cod);
                vista.txtCursoidProfesor.setText(nom);
            }
        }
        if(e.getSource() == vista.btnActualizarCurso){
            actualizarCurso();
            limpiartablaCurso();
            ListarCursos(vista.tblCursos);
        }
        if(e.getSource() == vista.btnBorrarCurso){
            eliminarCurso();
            limpiartablaCurso();
            ListarCursos(vista.tblCursos);
        }
    }
    
}

