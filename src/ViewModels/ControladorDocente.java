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

public final class ControladorDocente implements ActionListener{
  
    
    Persona us = new Persona();
    MetodoDocente dao = new MetodoDocente();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Método constructor del controlador
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorDocente(Colegio vista){
        this.vista = vista;
        this.vista.btnAgregarDocente.addActionListener(this);
        this.vista.btnSeleccionarDocente.addActionListener(this);
        this.vista.btnActualizarDocente.addActionListener(this);
        this.vista.btnBorrarDocente.addActionListener(this);
        listar(vista.tblDocente);
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void listar(JTable tblDocentes){
        modelo = (DefaultTableModel) tblDocentes.getModel();
        List<Persona> listaUsuarios = dao.listar();
        Object[] object = new Object[11];
        for (int i = 0; i < listaUsuarios.size(); i++) {
            object[0] = listaUsuarios.get(i).getId();
            object[1] = listaUsuarios.get(i).getCodigo();
            object[2] = listaUsuarios.get(i).getNombres();
            object[3] = listaUsuarios.get(i).getApellidos();
            object[4] = listaUsuarios.get(i).getNid();
            object[5] = listaUsuarios.get(i).getEdad();
            object[6] = listaUsuarios.get(i).getEmail();
            object[7] = listaUsuarios.get(i).getTelefono();
            object[8] = listaUsuarios.get(i).getDireccion();
            object[9] = listaUsuarios.get(i).getGenero();
            object[10] = listaUsuarios.get(i).getFecha_nacimiento();
            modelo.addRow(object);
        }
        vista.tblDocente.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregar(){
        String cod = (vista.txtCodigoDocente.getText());
        String nom = vista.txtNombreDocente.getText();
        String ape = vista.txtApellidoDocente.getText();
        String nid = vista.txtNidDocente.getText();
        int eda = Integer.parseInt(vista.txtEdadDocente.getText());
        String em = vista.txtEmailDocente.getText();
        String tel = (vista.txtTelefonoDocente.getText());
        String dir = vista.txtDireccionDocente.getText();
        String gen = vista.cbxGenero.getSelectedItem().toString();
        String fec = ((JTextField)vista.DateDocente.getDateEditor().getUiComponent()).getText();
        us.setCodigo(cod);
        us.setNombres(nom);
        us.setApellidos(ape);
        us.setNid(nid);
        us.setEdad(eda);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        int r = dao.agregar(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro exitoso!");
            limpiarDocente();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
        limpiartabla();
    }
    public void limpiarDocente(){
        vista.txtCodigoDocente.setText(null);
        vista.txtNombreDocente.setText(null);
        vista.txtApellidoDocente.setText(null);
        vista.txtNidDocente.setText(null);
        vista.txtEdadDocente.setText(null);
        vista.txtEmailDocente.setText(null);
        vista.txtTelefonoDocente.setText(null);
        vista.txtDireccionDocente.setText(null);
        vista.cbxGenero.setSelectedIndex(0);
        ((JTextField)vista.DateDocente.getDateEditor().getUiComponent()).setText(null);      
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizar(){
        String cod = (vista.txtCodigoDocente.getText());
        String nom = vista.txtNombreDocente.getText();
        String ap = vista.txtApellidoDocente.getText();
        String nid = (vista.txtNidDocente.getText());
        int ed = Integer.parseInt(vista.txtEdadDocente.getText());
        String em = vista.txtEmailDocente.getText();
        String tel = (vista.txtTelefonoDocente.getText());
        String dir = vista.txtDireccionDocente.getText();
        String gen = vista.cbxGenero.getSelectedItem().toString();
        String fec = vista.DateDocente.getDateFormatString();
        us.setCodigo(cod);
        us.setNombres(nom);
        us.setApellidos(ap);
        us.setNid(nid);
        us.setEdad(ed);
        us.setEmail(em);
        us.setTelefono(tel);
        us.setDireccion(dir);
        us.setGenero(gen);
        us.setFecha_nacimiento(fec);
        int r = dao.actualizar(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro actualizado");
            limpiarDocente();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
            limpiarDocente();
        }
    }
    
    public void eliminar(){
        int fila = vista.tblDocente.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(vista,"Debe seleccionar un registro");
           
        }
        else{
            int doc = Integer.parseInt(vista.tblDocente.getValueAt(fila, 0).toString());
            dao.eliminar(doc);
            JOptionPane.showMessageDialog(vista, "Registro eliminado");
            limpiarDocente();
        }
        
    }
    
    public void limpiartabla(){
        for (int i = 0; i < vista.tblDocente.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acción para agregar un registro
        if(e.getSource() == vista.btnAgregarDocente){
            agregar();
            limpiartabla();
            listar(vista.tblDocente);
        }
        if(e.getSource() == vista.btnSeleccionarDocente){
            int fila = vista.tblDocente.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                vista.txtNidDocente.setEditable(false);
                vista.txtEdadDocente.setEditable(false);
                vista.txtCodigoDocente.setEditable(false);
                int id = Integer.parseInt(vista.tblDocente.getValueAt(fila, 0).toString());
                String cod = (vista.tblDocente.getValueAt(fila, 1).toString());
                String nom = vista.tblDocente.getValueAt(fila, 2).toString();
                String ap = vista.tblDocente.getValueAt(fila, 3).toString();
                String nid = (vista.tblDocente.getValueAt(fila, 4).toString());
                int ed = Integer.parseInt(vista.tblDocente.getValueAt(fila, 5).toString());
                String em = vista.tblDocente.getValueAt(fila, 6).toString();
                String tel = (vista.tblDocente.getValueAt(fila, 7).toString());
                String dir = vista.tblDocente.getValueAt(fila, 8).toString();
                String gen = vista.tblDocente.getValueAt(fila, 9).toString();
                String fec = vista.tblDocente.getValueAt(fila, 10).toString();
                vista.txtCodigoDocente.setText(""+cod);
                vista.txtNombreDocente.setText(nom);
                vista.txtApellidoDocente.setText(ap);
                vista.txtNidDocente.setText(""+nid);
                vista.txtEdadDocente.setText(""+ed);
                vista.txtEmailDocente.setText(em);
                vista.txtTelefonoDocente.setText(""+tel);
                vista.txtDireccionDocente.setText(dir);
                vista.cbxGenero.setSelectedItem(gen);
                vista.DateDocente.setDateFormatString(fec);
            }
        }
        if(e.getSource() == vista.btnActualizarDocente){
            actualizar();
            limpiartabla();
            listar(vista.tblDocente);
        }
        if(e.getSource() == vista.btnBorrarDocente){
            eliminar();
            limpiartabla();
            listar(vista.tblDocente);
        }
    }
    
}
