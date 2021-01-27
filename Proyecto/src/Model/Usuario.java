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
        protected String nombre, apellido, usuario;
        protected static ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
    //Metodos
        public abstract void registrar(String nombre, String apellido, String usuario, int cedula);

    public Usuario(int cedula, String nombre, String apellido, String usuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
    }
        
        
        
}