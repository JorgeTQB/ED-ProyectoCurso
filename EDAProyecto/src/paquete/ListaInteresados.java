/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.DoublyLinkedList;
import tda.Node;

/**
 *
 * @author EDUARDO
 */
public class ListaInteresados {
    private DoublyLinkedList<Interesado> interesados;

    public ListaInteresados() {
        this.interesados = new DoublyLinkedList();
    }
    
    public void AgregarInteresado(Interesado interesado){
        interesados.agregarFinal(interesado);
    }
    
    public boolean existInter(int dni){
        Node<Interesado> auxi = interesados.getHead();
        boolean encontrado = false;
        while(auxi!=null){
            if(auxi.item().getDNI()==dni){
                return true;
            }
            auxi = auxi.next();
        }
        return encontrado;
    }

    public DoublyLinkedList<Interesado> getInteresados() {
        return interesados;
    }
    
}
