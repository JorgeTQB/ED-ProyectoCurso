/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

/**
 *
 * @author migue
 */
public class Node<T> {
    private T item;
    private Node<T> next;
    private Node<T> prev;

    public Node(T item) {
        this.item = item;
        next = null;
        prev = null;
    }

    public T item() {
        return item;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node prev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
