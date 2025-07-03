/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

import paquete.Dependencia;
import paquete.Tramite;

/**
 *
 * @author migue
 * 
 */
public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    
    public boolean isEmpty() {
        return head == null;
    }

    public void agregarInicio(T value) {
        Node<T> newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void agregarAntes(T value, T ref) {
        if (isEmpty()) {
            System.out.println("Lista vacia, no se puede insertar");
        } else {
            Node<T> ptr = head;
            while (ptr != null && ptr.item() != ref) {
                ptr = ptr.next();
            }
            Node newNode = new Node(value);

            if (ptr != null) {
                if (ptr.prev() != null) {
                    Node tmp = ptr.prev();
                    tmp.setNext(newNode);
                    ptr.setPrev(newNode);
                    newNode.setNext(ptr);
                    newNode.setPrev(tmp);
                } else {
                    agregarInicio(value);
                }
            } else {
                System.out.println("No se encontro el valor de ref.");
            }
        }
    }

    public void agregarFinal(T value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    
    public T obtenerItem(int Id){
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.item() instanceof Tramite tramite){
                int tramiteid = tramite.getExpediente().getIdTramite();
                if(Id == tramiteid){
                    return (T) tramite;
                }
            }
            ptr = ptr.next();
        }
        
        return null;
        
    }
    
    public T obtenerDependencia(String dependencia){
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.item() instanceof Dependencia depend){
                String nombredepend = depend.getNombre();
                if(dependencia == null ? nombredepend == null : dependencia.equals(nombredepend)){
                    return (T) depend;
                }
            }
            ptr = ptr.next();
        }
        
        return null;
    }
    
    public boolean existe(String existeDependencia){
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.item() instanceof Dependencia depend){
                String nombredepend = depend.getNombre();
                if(existeDependencia == null ? nombredepend == null : existeDependencia.equals(nombredepend)){
                    return true;
                }
            }
            ptr = ptr.next();
        }
        
        return false;
        
    }
    
   
    public boolean existeID(int buscarID){
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.item() instanceof Tramite tramit){
                int idbuscado = tramit.getExpediente().getIdTramite();
                if(idbuscado == buscarID){
                    return true;
                }
            }
            ptr = ptr.next();
        }
        
        return false;
        
    }
    
    public T DevolverTramiteExisteID(int buscandoID){
        
        Node ptr = head;
        
        while(ptr != null){
            if(ptr.item() instanceof Tramite tramit){
                int idbuscado = tramit.getExpediente().getIdTramite();
                if(idbuscado == buscandoID){
                    return (T) tramit;
                }
            }
            ptr = ptr.next();
        }
        
        return null;
    }

    public void mostrarAdelante() {
        Node ptr = head;

        while (ptr != null) {
            System.out.print(ptr.item() + " --> ");
            ptr = ptr.next();
        }

        System.out.println("null");
    }

    public void mostrarAtras() {
        Node ptr = tail;

        while (ptr != null) {
            System.out.print(ptr.item() + " <-- ");
            ptr = ptr.prev();
        }

        System.out.println("null");
    }

    public void eliminar(T value) {
        if (isEmpty()) {
            System.out.println("La lista esta vacia.");
        } else {
            Node ptr = head;
            while (ptr != null && ptr.item() != value) {
                ptr = ptr.next();
            }
            if (ptr != null) {
                if (ptr == head) {
                    head = ptr.next();
                    head.setPrev(null);
                } else if (ptr == tail) {
                    tail = ptr.prev();
                    tail.setNext(null);
                } else {
                    Node tmp = ptr.prev();
                    tmp.setNext(ptr.next());
                    ptr.next().setPrev(tmp);
                }
            } else {
                System.out.println("No se encontro el elemento a eliminar");
            }
        }
    }

    // Implemente un método que invierta una porción de la lista desde la posición i
    // hasta la posición j, donde i, j son entradas del método.
    public void invertFromTov2(int i, int j) {
        int count = 0;
        Node<T> ptr = head;
        Node<T> ptrHead = null;
        Node<T> ptrTail = null;
        boolean isInInvertSection = false;

        while (ptr.next() != null) {
            Node<T> next = ptr.next();

            if (count == i) {
                isInInvertSection = true;
                ptrHead = ptr;
            } else if (count == j) {
                ptrTail = ptr;
            } else if (count == j + 1) {
                isInInvertSection = false;
            }

            if (isInInvertSection) {
                // Modificar las ref del nodo actual
                Node<T> prev = ptr.prev();
                ptr.setPrev(ptr.next());
                ptr.setNext(prev);
            }

            count++;
            ptr = next;
        }

        Node<T> prev = ptrHead.next();
        ptrHead.setNext(ptrTail.prev());
        ptrTail.setPrev(prev);

        ptrTail.prev().setNext(ptrTail);
        ptrHead.next().setPrev(ptrHead);
    }
    
    public void invertList() {
        Node<T> ptr = head;
        
        while (ptr != null) {
            Node<T> next = ptr.next();
            
            Node<T> prev = ptr.prev();
            ptr.setPrev(ptr.next());
            ptr.setNext(prev);
            
            ptr = next;
        }
        
        Node<T> aux = head;
        head = tail;
        tail = aux;
    }

    public boolean isPalindrome() {
        Node<T> ptrHead = head;
        Node<T> ptrTail = tail;
        
        while (ptrHead != ptrTail && ptrTail.next() != ptrHead) {
            if (ptrHead.item() != ptrTail.item()) {
                return false;
            }
            
            ptrHead = ptrHead.next();
            ptrTail = ptrTail.prev();
        }
        
        return true;
    }
    
    public void invertFromTo(int i, int j) {
        Node<T> ptr = head;
        int count = 0;
        boolean isInSection = false;
        Node<T> ptrStart = null;
        Node<T> ptrEnd = null;
        
        while (ptr != null) {
            Node<T> next = ptr.next();
            
            if (i == count) {
                isInSection = true;
                ptrStart = ptr;
            }
            else if (j == count) {
                ptrEnd = ptr;
            }
            else if (j + 1 == count) {
                isInSection = false;
            }
            
            if (isInSection) {
                Node<T> prev = ptr.prev();
                ptr.setPrev(ptr.next());
                ptr.setNext(prev);
            }
            
            count++;
            ptr = next;
        }
        
        Node<T> prev = ptrStart.next();
        Node<T> next = ptrEnd.prev();
        
        ptrStart.setNext(next);
        ptrEnd.setPrev(prev);
        
        prev.setNext(ptrEnd);
        next.setPrev(ptrStart);
    }

}
