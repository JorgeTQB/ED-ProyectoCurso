package tda;
import paquete.*;

public class probandoCola {
    public static void main(String[] args) {
        
        Cola<Integer> Cola = new Cola();
       /*Expediente expediente = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Tramite tramite = new Tramite(1,1,expediente,"a");
        */
        Cola.encolarFinal(1);
        Cola.encolarFinal(2);
        Cola.encolarFinal(3);
        Cola.encolarFinal(4);

        
        System.out.println("");
        Cola.imprimirCola();
    }
    

}
