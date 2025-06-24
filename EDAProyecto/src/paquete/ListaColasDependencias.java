package paquete;

import tda.*;



public class ListaColasDependencias{

    private Dependencia inicio;
    private Dependencia bienestar;
    //etc...

    /*
    * Dependencia[Bienestar] = Cola[tramite1, tramite2, tramite3]
    * tramite1: primero que entro
    * tramite3: ultimo que entro
    */
    
    private DoublyLinkedList listaColas;

    public ListaColasDependencias(){
        
        inicio = new Dependencia("Inicio");
        bienestar = new Dependencia("Bienestar");

        listaColas.agregarFinal(inicio);
        listaColas.agregarFinal(bienestar);
        
    }
    
    



}