package Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Control {
    
    JTextField usuario;
    JPasswordField password;

    public Control(JTextField usuario, JPasswordField password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public void Prueba(JTextField usuario){
        JOptionPane.showMessageDialog(null, "Autenticacion invalida. No se encontraron los datos registrados","ERROR",JOptionPane.WARNING_MESSAGE);
    }
}
    
    
