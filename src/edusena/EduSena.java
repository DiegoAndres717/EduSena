
package edusena;

import Views.Colegio;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class EduSena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //codigo para abrir desde cualquier clase 
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
        } 
        Colegio colegio = new Colegio();
        colegio.setExtendedState(MAXIMIZED_BOTH);
        colegio.setVisible(true);
        
    }

}
