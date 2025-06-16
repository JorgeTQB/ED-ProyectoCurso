
package TDA;


public class Cola<T> {
    private Node<T> frente;
    private Node<T> ultimo;
    
    
    public Cola(){frente = null;ultimo = null;}

    public Cola(Node<T> frente, Node<T> ultimo) {
        this.frente = frente;
        this.ultimo = ultimo;
    }
    
    
    public boolean esVacia(){return frente==null;}
    /* 
    encolar: Sirve para agregar un elemento en la cola y la unica forma de agregar el elemento es al final.
    */
    public void encolarFrente(T item){
    Node<T> nuevoNodo = new Node(item);
    if (esVacia()){
        /*
        Si la cola está vacía, entonces ambos apuntan al Nodo Item
        */
    ultimo = nuevoNodo; 
    frente = nuevoNodo;
    }
     else{
    nuevoNodo.setNext(frente);
    frente = nuevoNodo.prev();
    frente = nuevoNodo;
        } 
}
    
    public void encolarFinal(T item){
    Node<T> nuevoNodo = new Node(item);
    if (esVacia()){
    /*
        Si la cola está vacía, entonces ambos apuntan al Nodo Item
        */
    ultimo = nuevoNodo; 
    frente = nuevoNodo;
    } else{
    nuevoNodo.setPrev(ultimo);
    ultimo.setNext(nuevoNodo);
    ultimo = nuevoNodo;
    }
    }
    
    
    public T desencolarFrente(){
    if(esVacia()){ return null;
        //throw new RuntimeException("La cola está vacía");
    }
     else{
        T itemAux = frente.item();
    
        frente= frente.next();
        return itemAux;
}
    }
    
    public T desencolarFinal(){
    if(esVacia()){ return null;
        //throw new RuntimeException("La cola está vacía");
    }
     else{
        T itemAux = ultimo.item();
        ultimo= ultimo.prev();
        ultimo.setNext(null);
        return itemAux;
}
    }
    
    public void imprimirCola(){
    Node<T> aux = frente;
    while(aux !=null){
        System.out.print( aux.item().toString() + " ~ ");
        aux = aux.next();
    }
    }
    
}
