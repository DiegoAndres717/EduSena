
package ViewModels;

import Models.MetodoNotas;
import Models.Notas;
import Views.Colegio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
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
        listarNotas(vista.tblNotasAlumnos);
    }
    
    public void listarNotas(JTable tblNotas){
        modelo = (DefaultTableModel) tblNotas.getModel();
        List<Notas> listaNotas = dao.listarBusqueda();
        Object[] object = new Object[5];
        for (int i = 0; i < listaNotas.size(); i++) {
            object[0] = listaNotas.get(i).getNota1();
            object[1] = listaNotas.get(i).getNota2();
            object[2] = listaNotas.get(i).getNota3();
            object[3] = listaNotas.get(i).getNota4();
            object[4] = listaNotas.get(i).getPromedio();
            modelo.addRow(object);
        }
        vista.tblNotasAlumnos.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscarNotaAlumn) {
            
            listarNotas(vista.tblNotasAlumnos);
        }
    }
}
