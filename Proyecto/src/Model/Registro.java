package Model;

import java.util.ArrayList;

public class Registro {
    static ArrayList<Registro> lista = new ArrayList<Registro>(); //La lista que llevara los registros
    
    private Vehiculo vehiculo = null; //Enlace del registro al vehiculo prestado
    private Instrumento instrumento = null;
    private Usuario persona;
    
    private int dd ,mm,yy; // Fecha del prestamo del bien
    private int dv=0, mv=0, yv=0; //Fecha de la devolucion del bien

    public Registro(Instrumento instrumento, Usuario persona,int dd, int mm, int yy) {
        this.instrumento = instrumento;
        this.persona = persona;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }
    
    public Registro(Vehiculo vehiculo, int dd, int mm, int yy,Usuario persona) {
        this.vehiculo = vehiculo;
        this.persona = persona;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public static void addLista(Registro objeto) {
        Registro.lista.add(objeto);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public Usuario getPersona() {
        return persona;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public void setMv(int mv) {
        this.mv = mv;
    }

    public void setYv(int yv) {
        this.yv = yv;
    }
    
    
}