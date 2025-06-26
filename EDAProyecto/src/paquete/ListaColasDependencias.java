package paquete;

import tda.*;



public class ListaColasDependencias{

    private Dependencia inicio;
    private Dependencia bienestar;
    private Dependencia matricula;
    private Dependencia administracion;
    private Dependencia ventas;
    private Dependencia finanzas;
    private Dependencia academico;
    private Dependencia recursos_humanos;
    private Dependencia tecnologia;
    private Dependencia servicios_generales;
    private Dependencia orientacion;
    private Dependencia biblioteca;
    private Dependencia tesoreria;
    private Dependencia infraestructura;
    private Dependencia comunicacion;
    
    
    //etc...

    /*
    * Dependencia[Bienestar] = Cola[tramite1, tramite2, tramite3]
    * tramite1: primero que entro
    * tramite3: ultimo que entro
    */
    
    private DoublyLinkedList listaColas;

    public ListaColasDependencias(){
        listaColas = new DoublyLinkedList();
        inicio = new Dependencia("Inicio");
        bienestar = new Dependencia("Bienestar");
        matricula = new Dependencia("Matricula");
        administracion = new Dependencia("Administracion");
        ventas = new Dependencia("Ventas");
        finanzas = new Dependencia("Finanzas");
        academico = new Dependencia("Academico");
        recursos_humanos = new Dependencia("Recursos Humanos");
        tecnologia = new Dependencia("Tecnologia");
        servicios_generales = new Dependencia("Servicios Generales");
        orientacion = new Dependencia("Orientacion");
        biblioteca = new Dependencia("Biblioteca");
        tesoreria = new Dependencia("Tesoreria");
        infraestructura = new Dependencia("Infraestructura");
        comunicacion = new Dependencia("Comunicacion");
        
        listaColas.agregarFinal(inicio);
        listaColas.agregarFinal(bienestar);
        listaColas.agregarFinal(matricula);
        listaColas.agregarFinal(administracion);
        listaColas.agregarFinal(ventas);
        listaColas.agregarFinal(finanzas);
        listaColas.agregarFinal(academico);
        listaColas.agregarFinal(recursos_humanos);
        listaColas.agregarFinal(tecnologia);
        listaColas.agregarFinal(servicios_generales);
        listaColas.agregarFinal(orientacion);
        listaColas.agregarFinal(biblioteca);
        listaColas.agregarFinal(tesoreria);
        listaColas.agregarFinal(infraestructura);
        listaColas.agregarFinal(comunicacion);
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

    public Dependencia getAcademico() {
        return academico;
    }

    public Dependencia getRecursos_humanos() {
        return recursos_humanos;
    }

    public Dependencia getTecnologia() {
        return tecnologia;
    }

    public Dependencia getServicios_generales() {
        return servicios_generales;
    }

    public Dependencia getOrientacion() {
        return orientacion;
    }

    public Dependencia getBiblioteca() {
        return biblioteca;
    }

    public Dependencia getTesoreria() {
        return tesoreria;
    }

    public Dependencia getInfraestructura() {
        return infraestructura;
    }

    public Dependencia getComunicacion() {
        return comunicacion;
    }

    public DoublyLinkedList getListaColas() {
        return listaColas;
    }
    
    



}