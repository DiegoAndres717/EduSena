package ViewModels;
import Models.*;
import Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class ControladorNotas implements ActionListener{
  
    
    Notas us = new Notas();
    MetodoNotas dao = new MetodoNotas();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    //Método constructor del controlador
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorNotas(Colegio vista){
        this.vista = vista;
        this.vista.btnAgregarrNotaDoc.addActionListener(this);
        this.vista.btnActualizarNotaDoc.addActionListener(this);
        this.vista.btnSelecionarNotaDoc1.addActionListener(this);
        listar(vista.tblNotasDocente);
    }
    
    /**
     *
     * @param tblUsuarios
     */
    public void listar(JTable tblNotas){
        modelo = (DefaultTableModel) tblNotas.getModel();
        List<Notas> listaNotas = dao.listar();
        Object[] object = new Object[8];
        for (int i = 0; i < listaNotas.size(); i++) {
            object[0] = listaNotas.get(i).getId();
            object[1] = listaNotas.get(i).getIdCurso();
            object[2] = listaNotas.get(i).getIdAlumno();
            object[3] = listaNotas.get(i).getNota1();
            object[4] = listaNotas.get(i).getNota2();
            object[5] = listaNotas.get(i).getNota3();
            object[6] = listaNotas.get(i).getNota4();
            object[7] = listaNotas.get(i).getPromedio();
            modelo.addRow(object);
        }
        vista.tblNotasDocente.setModel(modelo);
    }
    
    /**
     *metodo para agregar a la tabla
     */
    public void agregar(){
        int codcu = Integer.parseInt(vista.txtCodidoNotaDoc.getText());
        int codal = Integer.parseInt(vista.txtCodigoAlumnNotaDoc.getText());
        double n1 = Double.parseDouble(vista.txtNota1.getText());
        double n2 = Double.parseDouble(vista.txtNota2.getText());
        double n3 = Double.parseDouble(vista.txtNota3.getText());
        double n4 = Double.parseDouble(vista.txtNota4.getText());
        double pro =Double.parseDouble(vista.txtPromedio.getText());
        us.setIdCurso(codcu);
        us.setIdAlumno(codal);
        us.setNota1(n1);
        us.setNota2(n2);
        us.setNota3(n3);
        us.setNota4(n4);
        us.setPromedio(pro);
        int r = dao.agregar(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro exitoso!");
            limpiarNotas();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
        }
        limpiartabla();
    }
    public void limpiarNotas(){
        vista.txtCodidoNotaDoc.setText(null);
        vista.txtCodigoAlumnNotaDoc.setText(null);
        vista.txtNota1.setText(null);
        vista.txtNota2.setText(null);
        vista.txtNota3.setText(null);
        vista.txtNota4.setText(null);
        vista.txtPromedio.setText(null);
    }
    
    /**
     *Metodo para actualizar la tabla
     */
    public void actualizarNotas(){
        int cod = Integer.parseInt(vista.txtCodidoNotaDoc.getText());
        int nom = Integer.parseInt(vista.txtCodigoAlumnNotaDoc.getText());
        double n1 = Double.parseDouble(vista.txtNota1.getText());
        double n2 = Double.parseDouble(vista.txtNota2.getText());
        double n3 = Double.parseDouble(vista.txtNota3.getText());
        double n4 = Double.parseDouble(vista.txtNota4.getText());
        double pro = Double.parseDouble(vista.txtPromedio.getText());
        us.setIdCurso(cod);
        us.setIdAlumno(nom);
        us.setNota1(n1);
        us.setNota2(n2);
        us.setNota3(n3);
        us.setNota4(n4);
        us.setPromedio(pro);
        int r = dao.actualizarNota(us);
        if(r == 1){
            JOptionPane.showMessageDialog(vista, "Registro actualizado");
            limpiarNotas();
        }
        else{
            JOptionPane.showMessageDialog(vista, "Error, intente de nuevo");
            
        }
    }
    
 
    public void limpiartabla(){
        for (int i = 0; i < vista.tblNotasDocente.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Acción para agregar un registro
        if(e.getSource() == vista.btnAgregarrNotaDoc){
            agregar();
            limpiartabla();
            listar(vista.tblNotasDocente);
        }
        if(e.getSource() == vista.btnSelecionarNotaDoc1){
            int fila = vista.tblNotasDocente.getSelectedRow();
            if(fila == -1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un registro");
            }
            else{
                vista.txtNidDocente.setEditable(false);
                vista.txtCodigoDocente.setEditable(false);
                int id = Integer.parseInt(vista.tblNotasDocente.getValueAt(fila, 0).toString());
                int cod = Integer.parseInt(vista.tblNotasDocente.getValueAt(fila, 1).toString());
                int nom = Integer.parseInt(vista.tblNotasDocente.getValueAt(fila, 2).toString());
                double n1 = Double.parseDouble(vista.tblNotasDocente.getValueAt(fila, 3).toString());
                double n2 =Double.parseDouble(vista.tblNotasDocente.getValueAt(fila, 4).toString());
                double n3 = Double.parseDouble(vista.tblNotasDocente.getValueAt(fila, 5).toString());
                double n4 =Double.parseDouble(vista.tblNotasDocente.getValueAt(fila, 6).toString());
                double pro =Double.parseDouble(vista.tblNotasDocente.getValueAt(fila, 7).toString());
                vista.txtCodidoNotaDoc.setText(""+cod);
                vista.txtCodigoAlumnNotaDoc.setText(""+nom);
                vista.txtNota1.setText(""+n1);
                vista.txtNota2.setText(""+n2);
                vista.txtNota3.setText(""+n3);
                vista.txtNota4.setText(""+n4);
                vista.txtPromedio.setText(""+pro);
            }
        }
        if(e.getSource() == vista.btnActualizarNotaDoc){
            actualizarNotas();
            limpiartabla();
            listar(vista.tblNotasDocente);
        }
        if(e.getSource() == vista.btnBorrarDocente){
            limpiartabla();
            listar(vista.tblNotasDocente);
        }
    }
    
}
