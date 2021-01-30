/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

import java.util.ArrayList;

public class Profesor extends Usuario{
    
     protected static ArrayList<Profesor> list= new ArrayList<Profesor>();
        
        //Constructores
    
        public Profesor(int cedula, String nombre, String apellido){
        super(cedula, nombre, apellido);
        }

     //Metodos
        
    public void mostrarPerfil() {
    }
        
        public void pedirPrestamo(){
            
        };
        
        public void devolver(){
            
        };
        
        public void registrar(){
            lista.add(this);
            list.add(this);
        }
}