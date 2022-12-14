package ViewModels;
import Models.*;
import Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public final class ControladorAlumno implements ActionListener{
  
    
    Persona us = new Persona();
    MetodoAlumno alum = new MetodoAlumno();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Método constructor del controlador
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorAlumno(Colegio vista){
        this.vista = vista;
        this.vista.btnAgregarAlumno.addActionListener(this);
        this.vista.btnSeleccionarAlumno.addActionListener(this);
        this.vista.btnActualizaAlumno.addActionListener(this);
        this.vista.btnBorrarAlumno.addActionListener(this);
        ListarAlumno(vista.tblAlumnos);
        ListarAlumProf(vista.tblAlumnos1);
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void ListarAlumno(JTable tblAlumnos){
        modelo = (DefaultTableModel) tblAlumnos.getModel();
        List<Persona> listaUsuarios = alum.listar();
        Object[] object = new Object[11];
        for (int i = 0; i < listaUsuarios.size(); i++) {
            object[0] = listaUsuarios.get(i).getId();
            object[1] = listaUsuarios.get(i).getNombres();
            object[2] = listaUsuarios.get(i).getApellidos();
            object[3] = listaUsuarios.get(i).getNid();
            object[4] = listaUsuarios.get(i).getGrado();
            object[5] = listaUsuarios.get(i).getEmail();
            object[6] = listaUsuarios.get(i).getTelefono();
            object[7] = listaUsuarios.get(i).getDireccion();
            object[8] = listaUsuarios.get(i).getGenero();
            object[9] = listaUsuarios.get(i).getFecha_nacimiento();
            object[10] = listaUsuarios.get(i).getCodigo();
            modelo.addRow(object);
        }
        vista.tblAlumnos1.setModel(modelo);
    }
    
    public void ListarAlumProf(JTable tblAlumnos1){
        modelo = (DefaultTableModel) tblAlumnos1.getModel();
        List<Persona> listaUsuarios = alum.listarAlumnoProf();
        Object[] object = new Object[10];
        for (int i = 0; i < listaUsuarios.size(); i++) {
            object[0] = listaUsuarios.get(i).getId();
            object[1] = listaUsuarios.get(i).getNombres();
            object[2] = listaUsuarios.get(i).getApellidos();
            object[3] = listaUsuarios.get(i).getGrado();
            object[4] = listaUsuarios.get(i).getEmail();
            object[5] = listaUsuarios.get(i).getTelefono();
            object[6] = listaUsuarios.get(i).getDireccion();
            object[7] = listaUsuarios.get(i).getGenero();
            object[8] = listaUsuarios.get(i).getFecha_nacimiento();
            object[9] = listaUsuarios.get(i).getCodigo();
            modelo.addRow(object);
        }
        vista.tblAlumnos1.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregarAlu(){
        //int al = Integer.parseInt(vista.txtCodigoAlumno.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ape = vista.txtApellidoAlumno.getText();
        String nid = (vista.txtNidAlumno.getText());
        String gra = (vista.txtGradoAlumno.getText());
        String em = vista.txtEmailAlumno.getText();
        String tel = (vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
        String gen = vista.cbxGeneroAlumno.getSelectedItem().toString();
        String fec = ((JTextField)vista.DateAlumno.getDateEditor().getUiComponent()).getText();
        int cod= Integer.parseInt(vista.txtCodigoAlumno.getText());
        //us.setId(al);
        us.setNombres(nom);
        us.setApellidos(ape);
        us.setNid(nid);
        us.setGrado(gra);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        us.setCodigo(cod);
        int r = alum.agregarAlumno(us);
        if(r == 1){
            JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente!", 
                    "Atención!", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            limpiartablaAlumno();
        }
        else{
            JOptionPane.showMessageDialog(null, "Intente de nuevo!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        limpiartablaAlumno();
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizarAlumno(){
        //int al = Integer.parseInt(vista.txtCodigoAlumno.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ap = vista.txtApellidoAlumno.getText();
        String nid = (vista.txtNidAlumno.getText());
        String gra = (vista.txtGradoAlumno.getText());
        String em = vista.txtEmailAlumno.getText();
        String tel = (vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
        String gen = vista.cbxGeneroAlumno.getSelectedItem().toString();
        String fec = vista.DateAlumno.getDateFormatString();
        int cod= Integer.parseInt(vista.txtCodigoAlumno.getText());
        //us.setId(al);
        us.setNombres(nom);
        us.setApellidos(ap);
        us.setNid(nid);
        us.setGrado(gra);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        us.setCodigo(cod);
        int r = alum.actualizarAlumnos(us);
        if(r == 1){
            JOptionPane.showMessageDialog(null, "Alumno actualizado exitosamente",
                    "Atención", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(null, "Intente de nuevo!", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarAlumno(){
        int fila = vista.tblAlumnos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(vista,"Debe seleccionar un registro");
            limpiarCampos();
        }
        else{
            int doc = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 0).toString());
            alum.eliminarAlumno(doc);
            JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente", 
                    "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    //metodo para limpiar los campos de textos
    public void limpiarCampos(){
        //vista.txtCodigoAlumno.setText(null);
        vista.txtNombreAlumno.setText(null);
        vista.txtApellidoAlumno.setText(null);
        vista.txtNidAlumno.setText(null);
        vista.txtGradoAlumno.setText(null);
        vista.txtEmailAlumno.setText(null);
        vista.txtTelefonoAlumno.setText(null);
        vista.txtDirecciondAlumno.setText(null);
        vista.txtCodigoAlumno.setText(null);
        vista.cbxGeneroAlumno.setSelectedIndex(0);
        ((JTextField)vista.DateAlumno.getDateEditor().getUiComponent()).setText(null);
    }
    public void limpiartablaAlumno(){
        for (int i = 0; i < vista.tblAlumnos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acción para agregar un registro
        if(e.getSource() == vista.btnAgregarAlumno){
            agregarAlu();
            limpiartablaAlumno();
            ListarAlumno(vista.tblAlumnos);
        }
        if(e.getSource() == vista.btnSeleccionarAlumno){
            int fila = vista.tblAlumnos.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                //vista.txtNidAlumno.setEditable(false);
                //vista.txtCodigoAlumn.setEditable(false);
                int id = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 0).toString());
                String nom = vista.tblAlumnos.getValueAt(fila, 1).toString();
                String ap = vista.tblAlumnos.getValueAt(fila, 2).toString();
                String nid = (vista.tblAlumnos.getValueAt(fila, 3).toString());
                String gra = (vista.tblAlumnos.getValueAt(fila, 4).toString());
                String em = vista.tblAlumnos.getValueAt(fila, 5).toString();
                String tel = (vista.tblAlumnos.getValueAt(fila, 6).toString());
                String dir = vista.tblAlumnos.getValueAt(fila, 7).toString();
                String gen = vista.tblAlumnos.getValueAt(fila, 8).toString();
                String fec = vista.tblAlumnos.getValueAt(fila, 9).toString();
                int cod = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 10).toString());
                //vista.txtCodigoAlumno.setText(""+id);
                vista.txtNombreAlumno.setText(nom);
                vista.txtApellidoAlumno.setText(ap);
                vista.txtNidAlumno.setText(""+nid);
                vista.txtGradoAlumno.setText(gra);
                vista.txtEmailAlumno.setText(em);
                vista.txtTelefonoAlumno.setText(""+tel);
                vista.txtDirecciondAlumno.setText(dir);
                vista.cbxGeneroAlumno.setSelectedItem(gen);
                vista.DateAlumno.setDateFormatString(fec);
                vista.txtCodigoAlumno.setText(""+cod);
            }
        }
        if(e.getSource() == vista.btnActualizaAlumno){
            actualizarAlumno();
            limpiartablaAlumno();
            ListarAlumno(vista.tblAlumnos);
        }
        if(e.getSource() == vista.btnBorrarAlumno){
            eliminarAlumno();
            limpiartablaAlumno();
            ListarAlumno(vista.tblAlumnos);
        }
        
    }
    
}

