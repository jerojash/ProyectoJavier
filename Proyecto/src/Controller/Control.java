package Controller;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import Model.Coordinador;
import Model.Usuario;
import Vista.Inicio;
import Vista.ClaveNueva;
import Vista.MenuPrincipal;

public class Control {
    
    JTextField usuario;
    JPasswordField JPassword, JVerificarC;
    JLabel usuarioLabel;
    
    //Inicio
    public Control(JTextField usuario, JPasswordField password) { 
        this.usuario = usuario;
        this.JPassword = password;
    }
    
    //ClaveNueva
    public Control(JPasswordField JPassword, JPasswordField JVerificarC, JLabel usuarioLabel){
        this.JPassword = JPassword;
        this.JVerificarC = JVerificarC;
        this.usuarioLabel = usuarioLabel;
    }
    
    public void ingresar(Inicio ini){
        String password = new String(JPassword.getPassword()); //Decifro la clave y la convierto en string
        
        //Valido si uno de los dos esta vacio
        if(usuario.getText().isEmpty() || password.isEmpty())JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados");
        else{
            usuario.setText(usuario.getText().replace(" ", "").toLowerCase()); //Elimino cualquier espacio y convierto todo en minusculas
            Coordinador user = Coordinador.buscarCoordinador(usuario.getText()); //Busco al coordinador con ese nombre
            //JOptionPane.showMessageDialog(null, password.getPassword());

            if(user==null) JOptionPane.showMessageDialog(null, "Ha ingresado un usuario que no esta registrado");
            else if(!user.getPassword().equals(password)) JOptionPane.showMessageDialog(null, "Clave incorrecta. Intentelo de nuevo");
            else{ //Todo es correcto y se puede iniciar sesion
                MenuPrincipal ventana = new MenuPrincipal();
                ventana.setVisible(true);
                ini.setVisible(false);
            }
        }
    }
    
    public void olvidoClave(Inicio ini){
        usuario.setText(usuario.getText().replace(" ", "").toLowerCase());
         Coordinador user = Coordinador.buscarCoordinador(usuario.getText()); //Busco un usuario registrado con ese usuario
        if(usuario.getText().isEmpty())JOptionPane.showMessageDialog(null, "Escriba el nombre de usuario e intentelo de nuevo");
        else if(user==null) JOptionPane.showMessageDialog(null, "Ha ingresado un usuario que no esta registrado");
        else{
        ClaveNueva ventana = new ClaveNueva();
        ventana.setVisible(true);
        ini.setVisible(false);
        }
    }
    
    public void cambiarClave(ClaveNueva cambiar){
        
        
    }
}
    
    
