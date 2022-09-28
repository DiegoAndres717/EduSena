
package ViewModels;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class ControladorLogin {
    
    private ArrayList<JLabel> _label;
    private ArrayList<JTextField> _textField;
    
    public ControladorLogin(ArrayList<JLabel> label, ArrayList<JTextField> textField){
        _label = label;
        _textField = textField;
    }
    
    public Object[] Login(){
        if (_textField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese el Usuario");
            _label.get(0).setForeground(Color.red);
            _textField.get(0).requestFocus();
        }else{
            if (_textField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese una Contraseña");
                _label.get(1).setForeground(Color.red);
                _textField.get(1).requestFocus();
            }else{
                
            }
        }
        return null;
    }
}
