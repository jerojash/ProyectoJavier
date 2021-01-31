package Controller;

import Model.Bien;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import Model.Coordinador;
import Model.Estudiante;
import Model.Instrumento;
import Model.Profesor;
import Model.Usuario;
import Vista.Inicio;
import Vista.ClaveNueva;
import Vista.Coordinadores;
import Vista.MenuPrincipal;
import Vista.Profesores;
import Vista.ProfesoresRegistro;
import Vista.Registro;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Vehiculo;

public class Control {
    
    
    private static String userStatic;
    private static Coordinador coordinador;
    private static int op;
    
    JTextField usuario, apellido, cedula, nombre,ID,tipo, marca, modelo, yyString, placa;
    JPasswordField JPassword, JVerificarC;
    JLabel usuarioLabel;
    JTable tabla;
    JComboBox dd, mm, yy;
    JRadioButton profesor, estudiante;
    
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
        
    //RegistroCoordinador
    public Control(JTextField usuario, JTextField apellido, JTextField cedula, JTextField nombre, JPasswordField JPassword, JPasswordField JVerificarC) {
        this.usuario = usuario;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
        this.JPassword = JPassword;
        this.JVerificarC = JVerificarC;
    }
    
    //RegistroProfesores / RegistroEstudiante
    public Control(JTextField apellido, JTextField cedula, JTextField nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    //Listas
    public Control(JTable tabla) {
        this.tabla = tabla;
    }
    
    //Registrar Instrumento

    public Control(JTextField ID, JTextField tipo) {
        this.ID = ID;
        this.tipo = tipo;
    }
    
   //Registrar prestamo de un instrumento

    public Control(JTextField cedula, JTextField ID, JComboBox dd, JComboBox mm, JComboBox yy, JRadioButton profesor, JRadioButton estudiante) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.ID = ID;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
        this.profesor = profesor;
        this.estudiante = estudiante;
    }
    
    //Registrar prestamo de un vehiculo

    public Control(JTextField cedula, JTextField ID, JComboBox dd, JComboBox mm, JComboBox yy) {
        this.cedula = cedula;
        this.ID = ID;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }
    
    
    //Devolucion instrumento y vehiculo

    public Control(JTextField cedula, JComboBox dd, JComboBox mm, JComboBox yy) {
        this.cedula = cedula;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }
    
    //Registrar un vehiculo
    
    public Control(JTextField ID, JTextField marca, JTextField modelo, JTextField yyString, JTextField placa) {
        this.ID = ID;
        this.marca = marca;
        this.modelo = modelo;
        this.yyString = yyString;
        this.placa = placa;
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
                coordinador = Coordinador.buscarCoordinador(usuario.getText().toLowerCase().replace(" ", ""));
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

            if (Coordinador.buscarUsuario(ced)!=null){
                //Si la cedula ya esta registrada
                JOptionPane.showMessageDialog(null, "La cedula que ha ingresado ya se encuentra registrado. Intentelo nuevamente.");   
                return;
            }
            //Si las claves coinciden, y todas las validaciones son correctas, se puede registrar
            if(Control.getOp() == 1){
                Coordinador.registrar(nombre.getText(), apellido.getText(), usuario.getText().toLowerCase().replace(" ", ""), password, ced);    
                //Y salimos de la vista        
                Inicio ventana = new Inicio();
                ventana.setVisible(true);
                ini.setVisible(false);
            }else{          
                coordinador.editarPerfil(nombre.getText(), apellido.getText(), usuario.getText().toLowerCase().replace(" ", ""), ced, password); 
                Coordinadores ventana = new Coordinadores();
              ventana.setVisible(true);
              ini.setVisible(false);
            }
        } else JOptionPane.showMessageDialog(null, "Las claves deben coincider. Intente de nuevo");
            //Las claves no coinciden
            //activaVentana(this,this);
    }
    
    public boolean registrar(int opcion){ //opcion = 1 si es profesor y 2 si es estudiante 
        int ced=3;
        //No ha llenado todos los campos
        if(nombre.getText().isEmpty()||apellido.getText().isEmpty()||cedula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados"); 
            
        }else{ 
            try{ //Capturo la excepcion
                ced = Integer.parseInt(cedula.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if(ced<=0){ //Si la cedula es igual a cero o negativa
              JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (Coordinador.buscarUsuario(ced)!=null){
                //Si la cedula ya esta registrada
                JOptionPane.showMessageDialog(null, "La cedula que ha ingresado ya se encuentra registrado. Intentelo nuevamente.");   
            }else if(opcion ==1){
                Profesor prof = new Profesor(ced,nombre.getText(),apellido.getText());
                prof.registrar();
                return true;
            }else{
                Estudiante est = new Estudiante(ced,nombre.getText(),apellido.getText());
                est.registrar();
                return true;
            }
    }
        return false;
    }
    
    public void llenarTablaP(JTable tablaPersonas ){  
      String[] columna = { "Cédula", "Nombre", "Apellido" };
      
      DefaultTableModel dtm = new DefaultTableModel(null,columna);
      for (Profesor per : Profesor.getList())
          {
            String[] row = {Integer.toString(per.getCedula()), per.getNombre(),per.getApellido()};
            dtm.addRow(row);
          }

        tablaPersonas.setModel(dtm);
    }
    
    public void llenarTablaE(JTable tablaPersonas ){  
      String[] columna = { "Cédula", "Nombre", "Apellido" };
      
      DefaultTableModel dtm = new DefaultTableModel(null,columna);
      for (Estudiante per : Estudiante.getList())
          {
            String[] row = {Integer.toString(per.getCedula()), per.getNombre(),per.getApellido()};
            dtm.addRow(row);
          }

        tablaPersonas.setModel(dtm);
    }
    
    public void llenarTablaC(JTable tablaPersonas ){  
      String[] columna = { "Cédula", "Usuario","Nombre", "Apellido"};
      
      DefaultTableModel dtm = new DefaultTableModel(null,columna);
      for (Coordinador per : Coordinador.getList())
          {
            String[] row = {Integer.toString(per.getCedula()), per.getUsuario(),per.getNombre(),per.getApellido()};
            dtm.addRow(row);
          }

        tablaPersonas.setModel(dtm);
    }
    
    public void llenarTablaI(JTable tabla){
        String[] columna = { "ID", "Tipo","Disponible"};
      String dispon;
      DefaultTableModel dtm = new DefaultTableModel(null,columna);
      for (Instrumento per : Instrumento.getList())
          {
            if(per.isDisponible()) dispon = "SI";
            else dispon = "NO";
            String[] row = {Integer.toString(per.getID()), per.getTipo(),dispon};

            dtm.addRow(row);
          }
        tabla.setModel(dtm);
    }
    
    public void llenarTablaV(JTable tabla){
        String[] columna = { "ID","Marca", "Modelo","Placa","A\u00f1o","Disponible"};
        String dispon;
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (Vehiculo per : Vehiculo.getList())
            {
              if(per.isDisponible()) dispon = "SI";
              else dispon = "NO";
              String[] row = {Integer.toString(per.getID()), per.getMarca(), per.getModelo(), per.getPlaca(), Integer.toString(per.getAnnio()),dispon};

              dtm.addRow(row);
            }
          tabla.setModel(dtm);
    }
    
    public void activaVentana(JFrame ventana,JFrame ventana2) {
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose(); //elimina la ventana de la memoria, incluyendo datos
        //el dispose() garantiza que no dejes ventanas ejecutándose
        //no se almacenan datos en este ejemplo
     }

    public static int getOp() {
        return op;
    }

    public static void setOp(int op) {
        Control.op = op;
    }
    
    public void desactivar(){
        if(Control.getOp() != 1){
            usuario.setEnabled(false);
            cedula.setText(coordinador.getCedula()+"");
            usuario.setText(coordinador.getUsuario());
            nombre.setText(coordinador.getNombre());
            apellido.setText(coordinador.getApellido());
        }
    }
    
    
    public void registrarInstrumento(){
        //Si alguno de los campos esta vacio
        if(ID.getText().isEmpty() || tipo.getText().isEmpty()) JOptionPane.showMessageDialog(null, "Complete todos los campos solicitados.");
        
        else{
            int idInteger;
            
            try{ //Capturo la excepcion
                idInteger = Integer.parseInt(ID.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado un ID invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }if(idInteger<=0){ //Si la cedula es igual a cero o negativa
              JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
              return;
            }
            
            if (coordinador.buscar(idInteger)!=null){//Si ya existe un bien con ese ID
            JOptionPane.showMessageDialog(null, "Ya existe un bien que contenga este ID.");
            
            }else{
                coordinador.agregar(idInteger, tipo.getText().replace(" ", ""));
                JOptionPane.showMessageDialog(null, "El instrumento se ha registrado correctamente.");
            }
        }
    }
    
    public void prestamoInstrumento(JFrame ventana1, JFrame ventana2){
        if(ID.getText().isEmpty()||cedula.getText().isEmpty())JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados");
        else {
            int idInteger, ced;
            try{ //Capturo la excepcion
                idInteger = Integer.parseInt(ID.getText().replace(" ", ""));
                

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalida en alguno de los campos. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try{ //Capturo la excepcion
               
                ced = Integer.parseInt(cedula.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalida en alguno de los campos. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(idInteger<=0||ced<=0){ //Si la cedula y el id es igual a cero o negativa
              JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
              return;
            }
            
            if(Coordinador.buscarUsuario(ced)==null) JOptionPane.showMessageDialog(null, "La cedula no se encuentra registrada en el sistema");
            
            else if(coordinador.buscarInstrumento(idInteger)==null){ JOptionPane.showMessageDialog(null, "El instrumento que acaba de ingresar no se encuentra");
            }
            else if(coordinador.validarPrestamoInstrumento(ced)==false) JOptionPane.showMessageDialog(null, "Este usuario debe un bien", "REPORTE DE HOLD", JOptionPane.ERROR_MESSAGE);
            else if(coordinador.buscarInstrumentoNoDisponible(idInteger)!=null){ JOptionPane.showMessageDialog(null, "El bien no se encuentra disponible en estos momentos");
            
            }else if(profesor.isSelected() && coordinador.buscarProfesor(ced)==null){
                JOptionPane.showMessageDialog(null, "Este usuario no esta registrado como un profesor");
                return;
            }else if(estudiante.isSelected() && coordinador.buscarEstudiante(ced)==null){
                JOptionPane.showMessageDialog(null, "Este usuario no esta registrado como un estudiante");
                return;
            } else{
                    coordinador.prestamo(Integer.parseInt(dd.getSelectedItem().toString()), 
                                                                                            Integer.parseInt(mm.getSelectedItem().toString()), 
                                                                                            Integer.parseInt(yy.getSelectedItem().toString()), 
                                                                                            Coordinador.buscarUsuario(ced), 
                                                                                            (Instrumento)coordinador.buscar(idInteger));
                    JOptionPane.showMessageDialog(null, "El prestamo se ha realizado con exito");
                    activaVentana(ventana1, ventana2);
                    }
            }
        }
        
        public void instrumentoDevolucion(JFrame ventana, JFrame ventana2){
            int ced=3;
        //No ha llenado todos los campos
        if(cedula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese una cedula"); 
        }else{ 
            try{ //Capturo la excepcion
                ced = Integer.parseInt(cedula.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(ced<=0){ //Si la cedula es igual a cero o negativa
              JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
            
            }else if(Coordinador.buscarUsuario(ced)==null) 
                JOptionPane.showMessageDialog(null, "La cedula no se encuentra registrada en el sistema");
            else if(coordinador.recibirInstrumento(ced,Integer.parseInt(dd.getSelectedItem().toString()), 
                                                                                            Integer.parseInt(mm.getSelectedItem().toString()), 
                                                                                            Integer.parseInt(yy.getSelectedItem().toString()))){ 
                        //La devolucion se realizo con exit
                        JOptionPane.showMessageDialog(null, "La devolucion se realizo con exito");
                        activaVentana(ventana, ventana2);
                
            }else {
                JOptionPane.showMessageDialog(null, "Este usuario no debe ningun instrumento");
            }
        }
        }
        
        public void registrarVehiculo(JFrame ventana1, JFrame ventana2){
            if (ID.getText().isEmpty()||marca.getText().isEmpty()||modelo.getText().isEmpty()||yyString.getText().isEmpty()||placa.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Complete todos los campos solicitados");
            else{
                int yy, id;
                try{ //Capturo la excepcion
                    
                 yy=Integer.parseInt(yyString.getText().replaceAll(" ",""));
                
                 
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un a\u00f1o invalido. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{ //Capturo la excepcion
                    
                 
                 id = Integer.parseInt(ID.getText().replaceAll(" ",""));
                 
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un ID invalido. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                while(yy<=0||id<=0){
                    JOptionPane.showMessageDialog(null, "Ha ingresado un valor invalido. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(coordinador.buscar(id)!=null)JOptionPane.showMessageDialog(null, "Ya existe un bien con este ID");
                else{
                    coordinador.agregar(id, yy,placa.getText().replaceAll(" ","").toLowerCase(), 
                                                                marca.getText().replaceAll(" ","").toLowerCase(), 
                                                                modelo.getText().replaceAll(" ","").toLowerCase());
                JOptionPane.showMessageDialog(null, "El vehiculo se ha registrado exitosamente.");
                activaVentana(ventana1,ventana2);
                }
            }
        }
        
        public void prestamoVehiculo(JFrame ventana1, JFrame ventana2){
        if(ID.getText().isEmpty()||cedula.getText().isEmpty())JOptionPane.showMessageDialog(null, "Rellene todos los campos solicitados");
        else {
            int idInteger, ced;
            try{ //Capturo la excepcion
                idInteger = Integer.parseInt(ID.getText().replace(" ", ""));
                

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado un ID invalido. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try{ //Capturo la excepcion
               
                ced = Integer.parseInt(cedula.getText().replace(" ", ""));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(idInteger<=0||ced<=0){ //Si la cedula y el id es igual a cero o negativa
              JOptionPane.showMessageDialog(null, "Ha ingresado una valor negativo. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
              return;
            }
            
            //Verifico si la cedula esta en el sistema como un usuario
            if(coordinador.buscarProfesor(ced)==null) JOptionPane.showMessageDialog(null, "La cedula no se encuentra registrada como un profeso en el sistemar");
            
            else if(coordinador.buscarVehiculo(idInteger)==null){ JOptionPane.showMessageDialog(null, "El ID no esta registrando para un vehiculo");
            }
            else if(coordinador.validarPrestamoVehiculo(ced)==false) JOptionPane.showMessageDialog(null, "Este usuario debe un bien", "REPORTE DE HOLD", JOptionPane.ERROR_MESSAGE);
            else if(coordinador.buscarVehiculoNoDisponible(idInteger)!=null){ JOptionPane.showMessageDialog(null, "El bien no se encuentra disponible en estos momentos");
            
            //Verifico si la cedula pertenece a un profesor
            } else{
                    coordinador.prestamo(Coordinador.buscarProfesor(ced),
                                                                                        Integer.parseInt(dd.getSelectedItem().toString()), 
                                                                                        Integer.parseInt(mm.getSelectedItem().toString()), 
                                                                                        Integer.parseInt(yy.getSelectedItem().toString()),  
                                                                                        (Vehiculo)coordinador.buscar(idInteger));
                    JOptionPane.showMessageDialog(null, "El prestamo se ha realizado con exito");
                    activaVentana(ventana1, ventana2);
                    }
            }
        }
        
        public void vehiculoDevolucion(JFrame ventana, JFrame ventana2){
            int ced=3;
            //No ha llenado todos los campos
            if(cedula.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese una cedula"); 
            }else{ 
                try{ //Capturo la excepcion
                    ced = Integer.parseInt(cedula.getText().replace(" ", ""));

                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(ced<=0){ //Si la cedula es igual a cero o negativa
                  JOptionPane.showMessageDialog(null, "Ha ingresado una cedula invalida. Intente de nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);

                }else if(Coordinador.buscarProfesor(ced)==null) 
                    JOptionPane.showMessageDialog(null, "La cedula no se encuentra registrada en el sistema");
                else if(coordinador.recibirVehiculo(ced,Integer.parseInt(dd.getSelectedItem().toString()), 
                                                                                                Integer.parseInt(mm.getSelectedItem().toString()), 
                                                                                                Integer.parseInt(yy.getSelectedItem().toString()))){ 
                            //La devolucion se realizo con exit
                            JOptionPane.showMessageDialog(null, "La devolucion se realizo con exito");
                            activaVentana(ventana, ventana2);

                }else {
                    JOptionPane.showMessageDialog(null, "Este usuario no debe ningun vehiculo");
                }
            }
        }
        
}