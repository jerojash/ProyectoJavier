/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

public class Coordinador extends Usuario{
    //Atributo
        protected String usuario, password;
        
    
    //Metodos
        
        //Constructores

            public Coordinador(String nombre, String apellido, String usuario, String password, int cedula) {
                this.nombre = nombre;
                this.apellido = apellido;
                this.usuario = usuario;
                this.password = password;
                //Validar que el nombre de usuario sea unico
                this.cedula = cedula;
            }
        
        public void prestamo(int dd, int mm, int yy, Usuario persona, Vehiculo vehiculo){ //Para registrar vehiculo
            vehiculo.setDisponible(false);
            
            Registro reg = new Registro(vehiculo, persona, dd, mm, yy);
            
            Registro.addLista(reg);
            
        }
        
        public void prestamo(int dd, int mm, int yy, Usuario persona, Instrumento instrumento){ //Para registrar instrumentos
            instrumento.setDisponible(false);
            
            Registro reg = new Registro(instrumento, persona, dd, mm, yy);
            
            Registro.addLista(reg);
        }
        
        public Bien buscar(int ID){
            for(Bien iterador: Bien.lista){
                if(iterador.ID == ID) return iterador;
            }
            return null;
        }
        
        public void recibir(int ID){
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
        
        public void mostrarDatos(){
            
        }
        
        public void acceder(){
            
        }
        
    @Override //Hola asly salu2 desde tu culito bb
        public void registrar(String nombre, String apellido, int cedula){

        }
        
        public void salir(){
            
        }
        
        public void editarPerfil(){
            
        }
        
        public void mostrarPerfil(){
            
        };
        
}