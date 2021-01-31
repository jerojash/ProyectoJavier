/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

import java.util.ArrayList;

public class Coordinador extends Usuario{
    //Atributo
        protected String password, usuario;
        protected static ArrayList<Coordinador> list= new ArrayList<Coordinador>();

    //Metodos
        
        //Constructores

        public Coordinador(String password, int cedula, String nombre, String apellido, String usuario) {
            super(cedula, nombre, apellido);
            this.password = password;
            this.usuario = usuario;
        }

            
        
        public void prestamo(int dd, int mm, int yy, Usuario persona, Vehiculo vehiculo){ //Para prestar vehiculo
            vehiculo.setDisponible(false);
            
            Registro reg = new Registro(vehiculo, dd, mm, yy,persona);
            
            Registro.addLista(reg);
            
        }
        
        public void prestamo(int dd, int mm, int yy, Usuario persona, Instrumento instrumento){ //Para prestar instrumentos
            instrumento.setDisponible(false);
            
            Registro reg = new Registro(instrumento, persona, dd, mm, yy);
            
            Registro.addLista(reg);
        }
        
        public Bien buscar(int ID){ //Para buscar un bien
            for(Bien iterador: Bien.lista){
                if(iterador.ID == ID) return iterador;
            }
            return null;
        }
        
        public Registro buscarInstrumentoNoDisponible(int ID){ //Metodo para buscar si la persona debe un
                                                                                                      //instrumento
            for(Registro iterador: Registro.lista){
                
                if(iterador.getInstrumento().ID == ID && iterador.getInstrumento().isDisponible()==false){                             //Busca el registro y le coloca la fecha

                    return iterador; //Si lo debe, devuelve el registro
                }
            }
            return null; //Sino null
        }
        
        public Registro buscarVehiculoNoDisponible(int ID){ //Metodo para buscar si la persona debe un
                                                                                                      //instrumento
            for(Registro iterador: Registro.lista){
                
                if(iterador.getVehiculo().ID == ID && iterador.getVehiculo().isDisponible()==false){                             //Busca el registro y le coloca la fecha

                    return iterador; //Si lo debe, devuelve el registro
                }
            }
            return null; //Sino null
        }
        
        public boolean recibirInstrumento(int cedula, int dv, int mv, int yv){ //Recibir un bien, 
            
                for(Registro iterador: Registro.lista){
                
                if(iterador.getPersona().cedula == cedula && iterador.getInstrumento().isDisponible()==false){                             //Busca el registro y le coloca la fecha
                          //Busca el registro y le coloca la fecha
                    iterador.setDv(dv);                   //de devolucion
                    iterador.setMv(mv);
                    iterador.setYv(yv);
                    iterador.getInstrumento().setDisponible(true);
                    
                    return true;

                }
        }
        return false;    
    }
        
        public boolean recibirVehiculo(int ID, int dv, int mv, int yv){ //Recibir un bien, 
            
            Registro iterador = buscarVehiculoNoDisponible(ID);

            if(iterador!=null){                             
            //Busca el registro donde la persona no haya devuelto el vehiculo

                iterador.setDv(dv);                                                        
                iterador.setMv(mv);
                iterador.setYv(yv);
                iterador.getVehiculo().setDisponible(true);

                return true; //Si recibio el bien
            }
            
            return false; //Si no lo recibio
        }
        
        public boolean validarPrestamoInstrumento(int cedula){
            for(Registro iterador: Registro.lista){
                
                if(iterador.getPersona().cedula== cedula && iterador.getInstrumento().isDisponible()==false){                             //Busca el registro y le coloca la fecha
                    return false;
                }
            }
            return true; //Sino true
        }
        
        public void agregar(int ID, int yy, String placa, String marca, String modelo){ //agregar un vehiculo
            
            Vehiculo vehi = new Vehiculo(placa,marca,modelo,yy,ID);
            
            Bien.lista.add(vehi);
            Vehiculo.addList(vehi);
            
        }
        
        public void agregar(int ID,String tipo){  // agregar un instrumento
            
            Instrumento ins = new Instrumento(tipo, ID);
            
            Bien.lista.add(ins);
            Instrumento.addList(ins);
            
        }
        
        public void editarDatos(Vehiculo vehi, String placa, String marca, String modelo, int yy, int ID){
            
            vehi.setAnnio(yy);
            vehi.setMarca(marca);
            vehi.setModelo(modelo);
            vehi.setPlaca(placa);
            vehi.setID(ID);
            
        }
        
        public void editarDatos(Instrumento ins, String tipo, int ID){
            
            ins.setTipo(tipo);
            ins.setID(ID);
            
        }
        
        public static Usuario buscarUsuario(int cedula){ //Buscar un usuario por su numero de cedula
            for (Usuario iterador : Usuario.lista){
                if(iterador.cedula==cedula) return iterador;
            }
            return null;
        }
        
        public static Coordinador buscarCoordinador(String usuario){
            
            for (Coordinador iterador : Coordinador.list){
                if(iterador.usuario.equals(usuario)) return iterador;
            }
            return null;
        }
        
        public static Profesor buscarProfesor(int cedula){
            
            for (Profesor iterador : Profesor.list){
                if(iterador.getCedula()==cedula) return iterador;
            }
            return null;
        }
        
        public static Estudiante buscarEstudiante(int cedula){
            
            for (Estudiante iterador : Estudiante.list){
                if(iterador.getCedula()==cedula) return iterador;
            }
            return null;
        }
        
        public static int acceder(String usuario, String password){ //Retorna 0 si se puede acceder, 1 si la contra es incorrecta, 2 si no encontro el usuario
            
            Coordinador user = buscarCoordinador(usuario);
            
            if (user!=null){ //Quiere decir que encontro un usuario
                if (user.password.equals(password)) return 0;
                else return 1;
            } else return 2;
            
        }
        
    @Override //Sobre carga del metodo registrar
        public void registrar(){
            lista.add(this);
            list.add(this);
        }
        
        public static void registrar(String nombre, String apellido, String usuario, String password, int cedula){
            Coordinador cord = new Coordinador(password, cedula, nombre, apellido, usuario); //Creo instancia
            cord.registrar(); //Agrego a la lista el nuevo usuario
        }
        
        public void editarPerfil(String nombre, String apellido, String usuario, int cedula, String password){
            this.nombre = nombre;
            this.apellido = apellido;
            this.usuario = usuario;
            this.cedula = cedula;
            this.password = password;
        }

        public void buscarRegistro(int ID){
            
        }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public static void setLista(ArrayList<Usuario> lista) {
        Usuario.lista = lista;
    }

    public String getPassword() {
        return password;
    }      

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public static ArrayList<Usuario> getLista() {
        return lista;
    }

    public static ArrayList<Coordinador> getList() {
        return list;
    }
    
    
    
}