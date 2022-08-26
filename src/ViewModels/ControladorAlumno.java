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
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void ListarAlumno(JTable tblAlumnos){
        modelo = (DefaultTableModel) tblAlumnos.getModel();
        List<Persona> listaUsuarios = alum.listarAlumno();
        Object[] object = new Object[12];
        for (int i = 0; i < listaUsuarios.size(); i++) {
            object[0] = listaUsuarios.get(i).getId();
            object[1] = listaUsuarios.get(i).getCodigo();
            object[2] = listaUsuarios.get(i).getNombres();
            object[3] = listaUsuarios.get(i).getApellidos();
            object[4] = listaUsuarios.get(i).getNid();
            object[5] = listaUsuarios.get(i).getGrado();
            object[6] = listaUsuarios.get(i).getEdad();
            object[7] = listaUsuarios.get(i).getEmail();
            object[8] = listaUsuarios.get(i).getTelefono();
            object[9] = listaUsuarios.get(i).getDireccion();
            object[10] = listaUsuarios.get(i).getGenero();
            object[11] = listaUsuarios.get(i).getFecha_nacimiento();
            modelo.addRow(object);
        }
        vista.tblAlumnos.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregarAlumno(){
        String cod = (vista.txtCodigoAlumn.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ape = vista.txtApellidoAlumno.getText();
        String nid = (vista.txtNidAlumno.getText());
        int gra = Integer.parseInt(vista.txtGradoAlumno.getText());
        int eda = Integer.parseInt(vista.txtEdaAlumn.getText());
        String em = vista.txtEmailAlumno.getText();
        String tel = (vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
        String gen = vista.cbxGeneroAlumno.getSelectedItem().toString();
        String fec = ((JTextField)vista.DateAlumno.getDateEditor().getUiComponent()).getText();
        us.setCodigo(cod);
        us.setNombres(nom);
        us.setApellidos(ape);
        us.setNid(nid);
        us.setGrado(gra);
        us.setEdad(eda);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        int r = alum.agregarAlumno(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro exitoso!");
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
        limpiartablaAlumno();
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizarAlumno(){
        String cod = (vista.txtCodigoAlumn.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ap = vista.txtApellidoAlumno.getText();
        String nid = (vista.txtNidAlumno.getText());
        int gra = Integer.parseInt(vista.txtGradoAlumno.getText());
        int ed = Integer.parseInt(vista.txtEdaAlumn.getText());
        String em = vista.txtEmailAlumno.getText();
        String tel = (vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
        String gen = vista.cbxGeneroAlumno.getSelectedItem().toString();
        String fec = vista.DateAlumno.getDateFormatString();
        us.setCodigo(cod);
        us.setNombres(nom);
        us.setApellidos(ap);
        us.setNid(nid);
        us.setGrado(gra);
        us.setEdad(ed);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        int r = alum.actualizarAlumno(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro actualizado");
            limpiarCampos();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
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
            JOptionPane.showMessageDialog(vista, "Registro eliminado");
        }
        
    }
    //metodo para limpiar los campos de textos
    public void limpiarCampos(){
        vista.txtCodigoAlumn.setText(null);
        vista.txtNombreAlumno.setText(null);
        vista.txtApellidoAlumno.setText(null);
        vista.txtNidAlumno.setText(null);
        vista.txtGradoAlumno.setText(null);
        vista.txtEdaAlumn.setText(null);
        vista.txtEmailAlumno.setText(null);
        vista.txtTelefonoAlumno.setText(null);
        vista.txtDirecciondAlumno.setText(null);
        vista.cbxGenero.setSelectedIndex(0);
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
            agregarAlumno();
            limpiartablaAlumno();
            ListarAlumno(vista.tblAlumnos);
        }
        if(e.getSource() == vista.btnSeleccionarAlumno){
            int fila = vista.tblAlumnos.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                vista.txtNidAlumno.setEditable(false);
                vista.txtEdaAlumn.setEditable(false);
                vista.txtCodigoAlumn.setEditable(false);
                int id = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 0).toString());
                String cod = (vista.tblAlumnos.getValueAt(fila, 1).toString());
                String nom = vista.tblAlumnos.getValueAt(fila, 2).toString();
                String ap = vista.tblAlumnos.getValueAt(fila, 3).toString();
                String nid = (vista.tblAlumnos.getValueAt(fila, 4).toString());
                int gra = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 5).toString());
                int ed = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 6).toString());
                String em = vista.tblAlumnos.getValueAt(fila, 7).toString();
                String tel = (vista.tblAlumnos.getValueAt(fila, 8).toString());
                String dir = vista.tblAlumnos.getValueAt(fila, 9).toString();
                String gen = vista.tblAlumnos.getValueAt(fila, 10).toString();
                String fec = vista.tblAlumnos.getValueAt(fila, 11).toString();
                vista.txtCodigoAlumn.setText(""+cod);
                vista.txtNombreAlumno.setText(nom);
                vista.txtApellidoAlumno.setText(ap);
                vista.txtNidAlumno.setText(""+nid);
                vista.txtGradoAlumno.setText(""+gra);
                vista.txtEdaAlumn.setText(""+ed);
                vista.txtEmailAlumno.setText(em);
                vista.txtTelefonoAlumno.setText(""+tel);
                vista.txtDirecciondAlumno.setText(dir);
                vista.cbxGeneroAlumno.setSelectedItem(gen);
                vista.DateAlumno.setDateFormatString(fec);
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

