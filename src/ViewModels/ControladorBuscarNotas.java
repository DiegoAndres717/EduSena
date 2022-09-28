
package ViewModels;

import Models.MetodoNotas;
import Models.Notas;
import Views.Colegio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class ControladorBuscarNotas implements ActionListener{
    Notas us = new Notas();
    MetodoNotas dao = new MetodoNotas();
    Colegio vista = new Colegio();
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     *
     * @param vista
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorBuscarNotas(Colegio vista){
        this.vista = vista;
        this.vista.btnBuscarNotaAlumn.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscarNotaAlumn) {
            us.setIdAlumno(Integer.parseInt(vista.txtCodigoBuscarNota2.getText()));
            us.setIdCurso(Integer.parseInt(vista.txtCodigoBuscarMate1.getText()));
            if (dao.listarBusqueda(us)) {
               vista.txtNota1Estudiante.setText(String.valueOf(us.getNota1()));
               vista.txtNota2Estudiante.setText(String.valueOf(us.getNota2()));
               vista.nota3.setText(String.valueOf(us.getNota3()));
               vista.Nota4.setText(String.valueOf(us.getNota4()));
               vista.promed.setText(String.valueOf(us.getPromedio()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Codigo no existe", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
