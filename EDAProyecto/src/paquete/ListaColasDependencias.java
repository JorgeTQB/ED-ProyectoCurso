package paquete;

import tda.*;



public class ListaColasDependencias{

    private Dependencia inicio;
    private Dependencia bienestar;
    private Dependencia matricula;
    private Dependencia administracion;
    private Dependencia ventas;
    private Dependencia finanzas;
    
    
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
        bienestar = new Dependencia("Bienestar");
        matricula = new Dependencia("Matricula");
        administracion = new Dependencia("Administracion");
        ventas = new Dependencia("Ventas");
        finanzas = new Dependencia("Finanzas");
        
        
        listaColas.agregarFinal(inicio);
        listaColas.agregarFinal(bienestar);
        listaColas.agregarFinal(matricula);
        listaColas.agregarFinal(administracion);
        listaColas.agregarFinal(ventas);
        listaColas.agregarFinal(finanzas);
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

    public Dependencia getBienestar() {
        return bienestar;
    }

    public Dependencia getMatricula() {
        return matricula;
    }

    public Dependencia getAdministracion() {
        return administracion;
    }

    public Dependencia getVentas() {
        return ventas;
    }

    public Dependencia getFinanzas() {
        return finanzas;
    }

    public DoublyLinkedList getListaColas() {
        return listaColas;
    }

    
    

}