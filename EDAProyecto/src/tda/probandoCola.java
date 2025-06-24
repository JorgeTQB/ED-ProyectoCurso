package tda;
import paquete.*;

public class probandoCola {
    public static void main(String[] args) {
        
        Cola<Tramite> listaTramites = new Cola();
        Expediente expediente = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Expediente expediente2 = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Expediente expediente3 = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Expediente expediente4 = new Expediente(123,"Pepe",123,"pepe@gmail.com");
        Tramite tramite1 = new Tramite(1,1,expediente,"a");
        Tramite tramite2 = new Tramite(2,1,expediente2,"b");
        Tramite tramite3 = new Tramite(3,2,expediente3,"c");
        Tramite tramite4 = new Tramite(4,3,expediente4,"d");
        
        agregar(tramite1,listaTramites);
        agregar(tramite2,listaTramites);
    
        agregar(tramite3,listaTramites);
        agregar(tramite4,listaTramites);

        
        imprimirCola(listaTramites);
       
    }

     public static void agregar(Tramite tramite, Cola listaTramites) {   
        Cola<Tramite> aux = new Cola();    
        boolean agregado = false;
        switch(tramite.getPrioridad()){
        
            case 1:
                if(listaTramites.esVacia()){
                listaTramites.encolar(tramite);
                break;
                } else{
                 while(!listaTramites.esVacia()){
                 Tramite x = (Tramite) listaTramites.desencolar();
                 
                 if(!agregado && x.getPrioridad() > 1){
                 aux.encolarFrente(tramite);
                 agregado = true;
                 }
                 aux.encolarFrente(x);
                 }
                
                }
                
                
                if(!agregado){
                aux.encolarFrente(tramite);
                }
                
                while (!aux.esVacia()) {
                    listaTramites.encolarFrente(aux.desencolar());
                }
                break;
                
                
            case 2:
                if(listaTramites.esVacia()){
                listaTramites.encolar(tramite);
                break;
                } else{
                 while(!listaTramites.esVacia()){
                 Tramite x = (Tramite) listaTramites.desencolar();
                 
                 if(!agregado && x.getPrioridad() > 2){
                 aux.encolarFrente(tramite);
                 agregado = true;
                 }
                 aux.encolarFrente(x);
                 }}
                
                if(!agregado){
                aux.encolarFrente(tramite);
                }
                
                while (!aux.esVacia()) {
                    listaTramites.encolarFrente(aux.desencolar());
                }
                
                break;
            case 3:
                listaTramites.encolar(tramite);
                break;
        
        }
    
>>>>>>> master
    }
    
public static void imprimirCola(Cola<Tramite> listaTramites) {
    Cola<Tramite> aux = new Cola<>();

    System.out.print("[");
    while (!listaTramites.esVacia()) {
        Tramite t = listaTramites.desencolar();
        System.out.print("(" + t.getAsunto() + "," + t.getPrioridad() + ")");

        if (!listaTramites.esVacia()) {
            System.out.print(", ");
        }

        aux.encolar(t); 
    }
    System.out.println("]");

    while (!aux.esVacia()) {
        listaTramites.encolar(aux.desencolar());
    }
}

}
