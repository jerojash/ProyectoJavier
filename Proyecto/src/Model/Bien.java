package Model;

import java.util.ArrayList;

import java.util.Iterator;

public class Bien {
    //Atributos
        protected int ID;
        protected boolean disponible;
        protected static ArrayList<Bien> lista = new ArrayList<Bien>(); //Instanciar la lista de los bienes
    
    //Metodos

    public Bien(int ID) {
        this.ID = ID;
        this.disponible = true;
    }
        
        
        
        public static void imprimirLista(){
            Iterator<Bien> iteradorBienes = lista.iterator();
            while(iteradorBienes.hasNext()){
                
                //El codigo para imprimir los bienes.
                
            }
        }
        
        public static void buscarBienesDisponibles(){
            
            Iterator<Bien> iteradorBienes = lista.iterator();
            
            while(iteradorBienes.hasNext()){
               if(iteradorBienes.next().disponible ==  true){
                   //Codigo de imprimir, los bienes disponibles
               }
            }
            
        }
        
        
       public static Bien buscarBien(int ID){
            //Busca un bien y retorna un bien
            Iterator<Bien> iteradorBienes = lista.iterator();
            while (iteradorBienes.hasNext()){
                if(iteradorBienes.next().ID ==ID) return iteradorBienes.next();
            }
            return null;
        }
       
        public void cambiarEstado(int ID){
            Bien bien2 = buscarBien(ID);
            if (bien2 == null){
                //Muestra en pantalla que no se consiguio el bien que buscamos
            } else{
                if(bien2.disponible == true) bien2.disponible = false;
                else bien2.disponible = true;
            }
        }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
        //ola ashly
    }
}