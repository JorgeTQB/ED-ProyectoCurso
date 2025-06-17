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
        listaTramites.encolarFinal(tramite);
    }
    
    public void eliminar(Tramite tramite){
        listaTramites.eliminar(tramite);
        

    }
    
    public Tramite get(int ID){
        Tramite tram = (Tramite) listaTramites.obtenerItem(ID);
        return tram;
    }
    
    
    
    
}
