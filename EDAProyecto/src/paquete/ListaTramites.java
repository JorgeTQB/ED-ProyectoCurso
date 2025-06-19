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
        Cola<Tramite> aux = new Cola();    
        boolean agregado = false;
        switch(tramite.getPrioridad()){
            case 1:
                if(listaTramites.esVacia()){
                listaTramites.encolarFinal(tramite);
                break;
                } else{
                 while(!listaTramites.esVacia()){
                 Tramite x = listaTramites.desencolarFrente();
                 
                 if(!agregado && x.getPrioridad() > 1){
                 aux.encolarFrente(x);
                 agregado = true;
                 }
                 aux.encolarFrente(x);
                 }}
                
                if(!agregado){
                aux.encolarFrente(tramite);
                }
                
                while (!aux.esVacia()) {
                    listaTramites.encolarFrente(aux.desencolarFrente());
                }
                break;
                
                
            case 2:
                if(listaTramites.esVacia()){
                listaTramites.encolarFinal(tramite);
                break;
                } else{
                 while(!listaTramites.esVacia()){
                 Tramite x = listaTramites.desencolarFrente();
                 
                 if(!agregado && x.getPrioridad() > 2){
                 aux.encolarFrente(x);
                 agregado = true;
                 }
                 aux.encolarFrente(x);
                 }}
                
                if(!agregado){
                aux.encolarFrente(tramite);
                }
                
                while (!aux.esVacia()) {
                    listaTramites.encolarFrente(aux.desencolarFrente());
                }
                
                break;
            case 3:
                listaTramites.encolarFinal(tramite);
                break;
        
        }
    
    }
    
    public void eliminar(Tramite tramite){
        listaTramites.eliminar(tramite);
        

    }
    
    public Tramite get(int ID){
        Tramite tram = (Tramite) listaTramites.obtenerItemTramite(ID);
        return tram;
    }
    
    
    
    
}
