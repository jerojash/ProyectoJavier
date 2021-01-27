/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

public class Profesor extends Usuario{
    
    //Metodos
        
        //Constructores
            
        
    
        public Profesor(int cedula, String nombre, String apellido, String usuario){
        super(cedula, nombre, apellido, usuario);
            
        }

    public void mostrarPerfil() {
    }
        
        public void pedirPrestamo(){
            
        };
        
        public void devolver(){
            
        };
        
        public void registrar(String nombre, String apellido, String usuario, int cedula){
            Profesor nuevoProfesor = new Profesor(cedula, nombre, apellido, usuario);
            lista.add(nuevoProfesor);
        }
}