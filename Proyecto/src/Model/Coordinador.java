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
            
            Registro reg = new Registro(vehiculo, persona, dd, mm, yy);
            
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
        
        public void recibir(int ID){ //Recibir un bien
            Bien bien = buscar(ID);
            bien.setDisponible(true);
            
            for(Registro iterador: Registro.lista){
                if(iterador.bien.ID == ID) Registro.lista.remove(iterador);
                
            }
        }
        
        public void agregar(int ID, int yy, String placa, String marca, String modelo){ //agregar un vehiculo
            
            Vehiculo vehi = new Vehiculo(placa,marca,modelo,yy,ID);
            
            Bien.lista.add(vehi);
            
        }
        
        public void agregar(int ID,String tipo){  // agregar un instrumento
            
            Instrumento ins = new Instrumento(tipo, ID);
            
            Bien.lista.add(ins);
            
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
        
        public void mostrarPerfil(){
            
        };

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
    
    
}