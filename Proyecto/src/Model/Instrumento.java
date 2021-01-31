/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

import java.util.ArrayList;

public class Instrumento extends Bien {
    //Atributos
        private String tipo;
        private static ArrayList<Instrumento> list= new ArrayList<Instrumento>();

        public Instrumento(String tipo, int ID) {
            super(ID);
            this.tipo = tipo;
        }
        
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

    public static ArrayList<Instrumento> getList() {
        return list;
    }

    public String getTipo() {
        return tipo;
    }

    public int getID() {
        return ID;
    }

    public boolean isDisponible() {
        return disponible;
    }


    public static void setList(ArrayList<Instrumento> list) {
        Instrumento.list = list;
    }
    
    public static void addList(Instrumento ins){
        list.add(ins);
    }

       
}