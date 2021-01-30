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
import Vista.Registro;
import java.io.IOException;

public class Control {
    
    
    private static String userStatic;
    
    JTextField usuario, apellido, cedula, nombre;
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
        this.usuarioLabel.setText(userStatic);
    }
        
    //Registro
    public Control(JTextField usuario, JTextField apellido, JTextField cedula, JTextField nombre, JPasswordField JPassword, JPasswordField JVerificarC) {
        this.usuario = usuario;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
        this.JPassword = JPassword;
        this.JVerificarC = JVerificarC;
    }
    
    
    public void ingresar(Inicio ini){
        String password = new String(JPassword.getPassword()); //Decifro la clave y la convierto en string
        
        //Valido si uno de los dos esta vacio
        if(usuario.getText().isEmpty() || password.isEmpty())JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados");
        else{
            usuario.setText(usuario.getText().replace(" ", "").toLowerCase()); //Elimino cualquier espacio y convierto todo en minusculas
            Coordinador user = Coordinador.buscarCoordinador(usuario.getText()); //Busco al coordinador con ese nombre
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
            userStatic = usuario.getText();
            ClaveNueva ventana = new ClaveNueva();
            ventana.setVisible(true);
            ini.setVisible(false);
        }
    }
    
    public void cambiarClave(ClaveNueva cambiar){
        String password = new String(JPassword.getPassword());
        String verifi = new String(JVerificarC.getPassword());
        if (password.equals("") || verifi.equals("")) JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados"); 
        else if(password.equals(verifi)){ //Las claves coinciden
            Coordinador cord = Coordinador.buscarCoordinador(userStatic); //Busco al coordinador y lo guardo en una variable
            cord.editarPerfil(cord.getNombre(), cord.getApellido(), userStatic, cord.getCedula(), password);
                Inicio ventana = new Inicio();
                ventana.setVisible(true);
                cambiar.setVisible(false);
        } else JOptionPane.showMessageDialog(null, "Las claves deben coincider. Intente de nuevo");
        
    }
    
    public void registrar(Registro ini){
        int ced=0;
        //Decifro las claves
        String password = new String(JPassword.getPassword());
        String verifi = new String(JVerificarC.getPassword());
        
        //Si alguno de los campos esta vacio
        if(password.equals("") || verifi.equals("")||usuario.getText().isEmpty()||nombre.getText().isEmpty()||cedula.getText().isEmpty()||apellido.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados"); 
            
        } else if(Coordinador.buscarCoordinador(usuario.getText().replace(" ", "").toLowerCase())!=null){ 
            //Si hay un usuario con el mismo nombre
            JOptionPane.showMessageDialog(null, "El usuario "+usuario.getText()+" ya se encuentra registrado. Intente con otro usuario.");            
            
        } else if (password.equals(verifi)){ //Las claves son iguales y podriamos registrar

            try{ //Capturo la excepcion
                ced = Integer.parseInt(cedula.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(ced<=0){
              JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
              return;
            }

            if (Coordinador.buscarCedula(ced)!=null){
                //Si la cedula ya esta registrada
                JOptionPane.showMessageDialog(null, "La cedula que ha ingresado ya se encuentra registrado. Intentelo nuevamente.");   
                return;
            }
            //Si las claves coinciden, y todas las validaciones son correctas, se puede registrar

            Coordinador.registrar(nombre.getText(), apellido.getText(), usuario.getText(), password, ced);    

            //Y salimos de la vista
            Inicio ventana = new Inicio();
            ventana.setVisible(true);
            ini.setVisible(false);

        } else JOptionPane.showMessageDialog(null, "Las claves deben coincider. Intente de nuevo");
        //Las claves no coinciden
           
    }
}