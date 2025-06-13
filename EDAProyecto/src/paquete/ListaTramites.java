/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import TDA.DoublyLinkedList;

/**
 *
 * @author HOGAR
 */
public class ListaTramites {
    
    private Cola<Tramite> listaTramites;

    public ListaTramites() {
        this.listaTramites = new DoublyLinkedList();
    }
    
    
    public void agregar(Tramite tramite) {
        listaTramites.agregarFinal(tramite);
    }
    
    public void eliminar(Tramite tramite){
        listaTramites.eliminar(tramite);
    }
    
    public Tramite get(int ID){
        Tramite tram = (Tramite) listaTramites.obtenerItem(ID);
        
        return tram;
    }
    
    
    
    
}
