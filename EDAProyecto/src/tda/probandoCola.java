package tda;
import paquete.*;

public class probandoCola {
    public static void main(String[] args) {
        
        Cola<Tramite> Cola = new Cola();
        Expediente expediente = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Tramite tramite = new Tramite(1,1,expediente,"a");
        
        Cola.encolarFinal(tramite);

        Cola.eliminarT(tramite);
        System.out.println("");
        Cola.imprimirCola();
    }
    

}
