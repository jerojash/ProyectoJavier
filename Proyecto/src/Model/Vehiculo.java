/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */


package Model;

public class Vehiculo extends Bien{
    //Atributos
        private String placa, marca, modelo;
        private int annio;
        
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
    
    
    
        public void validarUsuario(){
            
        }
}