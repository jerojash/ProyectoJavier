/*
Integrantes:
Ashly Colmenares
Javier Rojas
 */

package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    
    public static void main(String[] args){
        ArrayList<Bien> listado = new ArrayList<Bien>();
                
        Iterator<Bien> iterador = listado.iterator();
        
        while(iterador.hasNext()){
            System.out.println(iterador.next().ID);
        }
        
        
    }
    
    
}