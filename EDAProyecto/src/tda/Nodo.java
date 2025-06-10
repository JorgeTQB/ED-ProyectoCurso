/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

public class Nodo {
    //atributos
    private int item;
    private Nodo sgteNodo; //asumiendo q la clase nodo ya esta hecha
    
    //metodos
    //creacion de un nodo
    //constructores sin/con parametros
    public Nodo(){
        item = 0;
        sgteNodo = null;
    }
    
    public Nodo(int item){
        this.item = item;
        sgteNodo = null;
    }
    
    public Nodo(int item, Nodo sgteNodo){
        this.item = item;
        this.sgteNodo = sgteNodo;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Nodo getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(Nodo sgteNodo) {
        this.sgteNodo = sgteNodo;
    }
    
    
    
    
    
    
    
    
}
