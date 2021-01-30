/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

public class Estudiante extends Usuario implements Prestamo{
    
    
    //Metodos
    
        //Constructor
            
        public Estudiante(int cedula, String nombre, String apellido, String usuario) {
        super(cedula, nombre, apellido, usuario);
        
        }

    public void mostrarPerfil() {
    }
        
        public void pedirPrestamo(){
            
        };
        
        public void devolver(){
            
        };
        
        public void registrar(String nombre, String apellido, String usuario, int cedula){
            Estudiante nuevoEstudiante = new Estudiante(cedula, nombre, apellido, usuario);
            lista.add(nuevoEstudiante);
            
            
        }
}