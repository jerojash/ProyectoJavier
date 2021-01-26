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

              
}