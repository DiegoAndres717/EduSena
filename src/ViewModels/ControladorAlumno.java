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
        Object[] object = new Object[11];
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
            object[10] = listaUsuarios.get(i).getFecha_nacimiento();
            modelo.addRow(object);
        }
        vista.tblAlumnos.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregarAlumno(){
        int cod = Integer.parseInt(vista.txtCodigoAlumn.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ape = vista.txtApellidoAlumno.getText();
        int nid = Integer.parseInt(vista.txtNidAlumno.getText());
        int gra = Integer.parseInt(vista.txtGradoAlumno.getText());
        int eda = Integer.parseInt(vista.txtEdaAlumn.getText());
        String em = vista.txtEmailAlumno.getText();
        int tel = Integer.parseInt(vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
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
        us.setFecha_nacimiento(fec);
        int r = alum.agregarAlumno(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro exitoso!");
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
        int cod = Integer.parseInt(vista.txtCodigoAlumn.getText());
        String nom = vista.txtNombreAlumno.getText();
        String ap = vista.txtApellidoAlumno.getText();
        int nid = Integer.parseInt(vista.txtNidAlumno.getText());
        int gra = Integer.parseInt(vista.txtGradoAlumno.getText());
        int ed = Integer.parseInt(vista.txtEdaAlumn.getText());
        String em = vista.txtEmailAlumno.getText();
        int tel = Integer.parseInt(vista.txtTelefonoAlumno.getText());
        String dir = vista.txtDirecciondAlumno.getText();
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
        us.setFecha_nacimiento(fec);
        int r = alum.actualizarAlumno(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro actualizado");
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
    }
    
    public void eliminarAlumno(){
        int fila = vista.tblAlumnos.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(vista,"Debe seleccionar un registro");
        }
        else{
            int doc = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 0).toString());
            alum.eliminarAlumno(doc);
            JOptionPane.showMessageDialog(vista, "Registro eliminado");
        }
        
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
                int id = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 0).toString());
                int cod = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 1).toString());
                String nom = vista.tblAlumnos.getValueAt(fila, 2).toString();
                String ap = vista.tblAlumnos.getValueAt(fila, 3).toString();
                int nid = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 4).toString());
                int gra = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 5).toString());
                int ed = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 6).toString());
                String em = vista.tblAlumnos.getValueAt(fila, 7).toString();
                int tel = Integer.parseInt(vista.tblAlumnos.getValueAt(fila, 8).toString());
                String dir = vista.tblAlumnos.getValueAt(fila, 9).toString();
                String fec = vista.tblAlumnos.getValueAt(fila, 10).toString();
                vista.txtCodigoAlumn.setText(""+cod);
                vista.txtNombreAlumno.setText(nom);
                vista.txtApellidoAlumno.setText(ap);
                vista.txtNidAlumno.setText(""+nid);
                vista.txtGradoAlumno.setText(""+gra);
                vista.txtEdaAlumn.setText(""+ed);
                vista.txtEmailAlumno.setText(em);
                vista.txtTelefonoAlumno.setText(""+tel);
                vista.txtDirecciondAlumno.setText(dir);
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

