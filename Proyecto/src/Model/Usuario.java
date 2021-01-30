/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */


package Model;

import java.util.ArrayList;

public  abstract class Usuario {
    
    //Atributos
        protected int cedula ;
        protected String nombre, apellido;
        protected static ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
    //Metodos
        public  abstract void registrar();

    public Usuario(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}