
package Model;

import java.util.ArrayList;

public class Registro {
    static ArrayList<Registro> lista = new ArrayList<Registro>(); //La lista que llevara los registros
    protected Bien bien; //Enlace del registro al bien prestado
    private Usuario persona;
    
    private int dd,mm,yy; // Fecha del registro del prestamo

    public Registro(Bien Bien, Usuario persona,int dd, int mm, int yy) {
        this.bien = Bien;
        this.persona = persona;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public static void addLista(Registro objeto) {
        Registro.lista.add(objeto);
    }

    public Bien getBien() {
        return bien;
    }
    
    
    
}
