/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */


package Model;

import java.util.ArrayList;

public class Vehiculo extends Bien{
    //Atributos
        private String placa, marca, modelo;
        private int annio;
        private static ArrayList<Vehiculo> list= new ArrayList<Vehiculo>();
        
    //Metodos

        public Vehiculo(String placa, String marca, String modelo, int annio, int ID) {
            super(ID);
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
            this.annio = annio;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public void setAnnio(int annio) {
            this.annio = annio;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

        public static ArrayList<Vehiculo> getList() {
            return list;
        }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnnio() {
        return annio;
    }

    public int getID() {
        return ID;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    public static void addList(Vehiculo veh){
        list.add(veh);
    }
    
    
}