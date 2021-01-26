/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

public class Profesor extends Usuario{
    
    //Metodos
        
        //Constructores
            
            public Profesor(String nombre, String apellido, int cedula){
                this.nombre = nombre;
                this.apellido = apellido;
                this.cedula = cedula;
                
            }
    
        public void mostrarPerfil(){
            
        }
        
        public void pedirPrestamo(){
            
        };
        
        public void devolver(){
            
        };
        
        public void registrar(String nombre, String apellido, int cedula){
            Profesor nuevoProfesor = new Profesor(nombre, apellido, cedula);
            lista.add(nuevoProfesor);
        }
}