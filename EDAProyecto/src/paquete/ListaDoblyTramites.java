/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.DoublyLinkedList;

/**
 *
 * @author HOGAR
 */
public class ListaDoblyTramites {
    
    private DoublyLinkedList<Tramite> tramites;

    public ListaDoblyTramites() {
        this.tramites = new DoublyLinkedList();
    }

    public DoublyLinkedList<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(DoublyLinkedList<Tramite> tramites) {
        this.tramites = tramites;
    }
    
    
}
