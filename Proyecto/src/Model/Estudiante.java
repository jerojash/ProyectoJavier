/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

public class Estudiante extends Usuario implements Prestamo{
    
    
    //Metodos
    
        //Constructor
            
            public Estudiante(String nombre, String apellido, int cedula){
                this.nombre = nombre;
                this.apellido = apellido;
                this.cedula = cedula;
                
            }

        public void mostrarPerfil() {
        
        }
        
        public void pedirPrestamo(){
            
        };
        
        public void devolver(){
            
        };
        
        public void registrar(String nombre, String apellido, int cedula){
            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, cedula);
            lista.add(nuevoEstudiante);
            
            
        }
}
