/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.*;

/**
 *
 * @author EDUARDO
 */
public class Dependencia {
    private String nombre;

    private Cola<Tramite> colaDependencia;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.colaDependencia = new Cola();
    }
    
    public void encolarDependencia(Tramite tramite) {   
        Cola<Tramite> aux = new Cola();
        boolean agregado = false;
        switch(tramite.getPrioridad()){
            case 1:
                if(colaDependencia.esVacia()){
                    colaDependencia.encolar(tramite);
                    break;
                } else{
                    while(!colaDependencia.esVacia()){
                        Tramite x = colaDependencia.desencolar();

                        if(!agregado && x.getPrioridad() > 1){
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
                    colaDependencia.encolarFrente(aux.desencolar());
                }
                
                break;
                
            case 2:
                if(colaDependencia.esVacia()){
                    colaDependencia.encolar(tramite);
                    break;
                } else{
                    while(!colaDependencia.esVacia()){
                        Tramite x = colaDependencia.desencolar();

                        if(!agregado && x.getPrioridad() > 2){
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
                    colaDependencia.encolarFrente(aux.desencolar());
                }
                
                break;
                
            case 3:
                colaDependencia.encolar(tramite);
                break;
        
        }
    
    }

    public Cola<Tramite> getColaDependencia() {
        return colaDependencia;
    }
    
}
