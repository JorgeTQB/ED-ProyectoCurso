/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.*;


/**
 *
 * @author HOGAR
 */
public class ListaTramites {
    
    private Cola<Tramite> listaTramites;

    public ListaTramites() {
        this.listaTramites = new Cola();
    }
    
    
    
    public void agregar(Tramite tramite) {
        Cola<Tramite> aux = new Cola<>();
        boolean agregado = false; //Flag para saber si se agregó o no

        int prioridadNueva = tramite.getExpediente().getPrioridad();

        // Caso 0
        if (prioridadNueva == 0) {
            listaTramites.encolarFrente(tramite);
            return;
        }

        // Caso 3
        if (prioridadNueva == 3) {
            listaTramites.encolar(tramite);
            return;
        }

        // Caso 1 o 2
        while (!listaTramites.esVacia()) {
            Tramite actual = listaTramites.desencolar();
            int prioridadActual = actual.getExpediente().getPrioridad();

            if (!agregado && prioridadActual > prioridadNueva) {
                aux.encolar(tramite); 
                agregado = true; //Se cambia a true
            }

            aux.encolar(actual); 
        }

        // Se inserta al final
        if (!agregado) {
            aux.encolar(tramite);
        }

        // Restaura la Cola original
        while (!aux.esVacia()) {
            listaTramites.encolar(aux.desencolar());
        }
    }
    
    
    /*
    public void agregar(Tramite tramite) {   
        Cola<Tramite> aux = new Cola();    
        boolean agregado = false;
        switch(tramite.getExpediente().getPrioridad() ){
            case 1:
                if(listaTramites.esVacia()){
                    listaTramites.encolar(tramite);
                    break;
                } else{
                    while(!listaTramites.esVacia()){
                        Tramite x = listaTramites.desencolar();

                        if(!agregado && x.getExpediente().getPrioridad() > 1){
                            aux.encolarFrente(x);
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
                        Tramite x = listaTramites.desencolar();

                        if(!agregado && x.getExpediente().getPrioridad() > 2){
                            aux.encolarFrente(x);
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
                
            case 3:
                listaTramites.encolar(tramite);
                break;
        
        }
    
    }
*/
    
    public void eliminar(){
        listaTramites.desencolar();
        
    }
    
    public Tramite get(int ID){
        Tramite tram = (Tramite) listaTramites.obtenerItemTramite(ID);
        return tram;
    }

    public Cola<Tramite> getListaTramites() {
        return listaTramites;
    }

    public Node<Tramite> getFrente() {
        return listaTramites.getFrente(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
