package paquete;

import tda.*;



public class ListaColasDependencias{

    private Dependencia inicio;
    private Dependencia comunicaciones;
    private Dependencia ingenieria;
    private Dependencia matricula;
    private Dependencia arquitectura;
    private Dependencia secretaria;
    private Dependencia bienestar;
    
    
    //etc...

    /*
    * Dependencia[Bienestar] = Cola[tramite1, tramite2, tramite3]
    * tramite1: primero que entro
    * tramite3: ultimo que entro
    */
    
    private DoublyLinkedList<Dependencia> listaColas;

    public ListaColasDependencias(){
        listaColas = new DoublyLinkedList();
        inicio = new Dependencia("Inicio");
        comunicaciones = new Dependencia("Comunicaciones");
        ingenieria = new Dependencia("Ingenieria");
        matricula = new Dependencia("Matricula");
        arquitectura = new Dependencia("Arquitectura");
        secretaria = new Dependencia("Secretaria");
        bienestar = new Dependencia("Bienestar");
        listaColas.agregarFinal(inicio);
        listaColas.agregarFinal(comunicaciones);
        listaColas.agregarFinal(ingenieria);
        listaColas.agregarFinal(matricula);
        listaColas.agregarFinal(arquitectura);
        listaColas.agregarFinal(secretaria);
        listaColas.agregarFinal(bienestar);

    }
    
    public void crearDependencia(String nombre){
        Dependencia nuevaDependencia = new Dependencia(nombre);
        listaColas.agregarFinal(nuevaDependencia);
        
    }

    public Dependencia conseguirDependencia(String dependencia){
        
        return (Dependencia) listaColas.obtenerDependencia(dependencia);
        
    }
    
    public boolean existeDependencia(String NombreDependencia){

        return listaColas.existe(NombreDependencia);
        
    }
    
    public String[] conseguirNombresDP(){
        String[] nombres = new String[100];
        int c = 0;
        
        Node<Dependencia> aux = listaColas.getHead();
        while(aux != null){
            nombres[c] = aux.item().getNombre();
            aux = aux.next();
        }
        
        return nombres;
    }
    
    public Dependencia getInicio() {
        return inicio;
    }

    public DoublyLinkedList getListaColas() {
        return listaColas;
    }

    
    

}