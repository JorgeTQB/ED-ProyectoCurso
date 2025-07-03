/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.DoublyLinkedList;

/**
 *
 * @author EDUARDO
 */
public class ListaTramitesFinalizados {
    private DoublyLinkedList<Tramite> tramites;

    public ListaTramitesFinalizados() {
        tramites = new DoublyLinkedList();
    }

    public DoublyLinkedList<Tramite> getTramites() {
        return tramites;
    }
    public void AgregarTramFin(Tramite tramite){
        tramites.agregarInicio(tramite);
    }
}
