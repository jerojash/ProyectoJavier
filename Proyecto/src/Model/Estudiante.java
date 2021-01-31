/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

import java.util.ArrayList;

public class Estudiante extends Usuario implements Prestamo{
    
    
    //Metodos
    protected static ArrayList<Estudiante> list= new ArrayList<Estudiante>();
    
        //Constructor
            
        public Estudiante(int cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        
        }

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
        
        public static ArrayList<Estudiante> getList() {
        return list;
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
}