/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tda;

public class ListaSimpleEnlazada<T> {
    //atributos
    private Nodo cabeza;
    private Nodo ultimo;
    
    //metodos
    public ListaSimpleEnlazada(){
        cabeza = null;
        ultimo = null;
    }
    
    /*
    metodo: es vacio.
    verifica si la lista esta vacia
    */
    public boolean esVacia(){
        return cabeza == null;
    }
    
    /*
    agregar: añade al final de la lista un nuevo nodo
    */
    public void agregar(int item){
        //crear un nuevo nodo
        Nodo nuevoNodo = new Nodo(item, null);
        
        if (esVacia()==true) {
            //lista esta vacia
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            //lista tiene elementos
            /*Nodo aux = cabeza;
            while (aux.getSgteNodo()!=null){
                aux = aux.getSgteNodo();
            }
            //sale cuando sgte nodo es null:
            aux.setSgteNodo(nuevoNodo);       
            */
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
        
    }
    /*
    *Mostrar los elementos de la lista
    */
    public void mostrar(){
        Nodo aux = cabeza;
        while(aux !=null){
            System.out.print(aux.getItem()+"\t");
            aux = aux.getSgteNodo();
        }
    }
    
    public int longitud(){
        if(esVacia()){
            return 0;
        }else{
            Nodo aux = cabeza;
            int i=0;
            while(aux!=null){
                aux = aux.getSgteNodo();
                i++;
            }
         return i;
        }
    }
    /*
    *iesimo: devuelve el valor de un item de una determinada posicion
    */
    public Integer iesimo(int pos){
        if(pos>=1 && pos<=longitud()){
            Nodo aux = cabeza;
            int i = 1;
            while(i<pos){
                aux = aux.getSgteNodo();
                i++;
            }
            return aux.getItem();
        }else{
            return null;
            }
    }
    
    
    public boolean areEqual(ListaSimpleEnlazada<T> lista1, ListaSimpleEnlazada<T> lista2){
        boolean equal = true;
        if(lista1.longitud()!=lista2.longitud()){
            equal = false;
        }else{
            Nodo aux = lista1.cabeza;
            Nodo aux1 = lista2.cabeza;
            while(aux!=null || aux1!=null){
                if(aux == null && aux!=null){
                    equal = false;
                }else if( aux1== null && aux!=null){
                    equal = false;
                }else{
               
                if(aux.getItem()!=aux1.getItem()){
                    equal = false;
                    
                }
                aux = aux.getSgteNodo();
                aux1 = aux1.getSgteNodo();
                 }
            }
        }
        return equal;
    }
    
    
    
    
}
