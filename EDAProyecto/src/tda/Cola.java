
package tda;
import paquete.*;


public class Cola<T> {
    private Node<T> frente;
    private Node<T> ultimo;
    
    
    public Cola(){
        frente = null;
        ultimo = null;
    }

    public Cola(Node<T> frente, Node<T> ultimo) {
        this.frente = frente;
        this.ultimo = ultimo;
    }
    
    public T obtenerItemTramite(int Id){   
        Node ptr = frente;    
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
    
  
    public void eliminarTr(T item){
        boolean eliminado = false;
        Cola<T> aux = new Cola();
        if(esVacia()){
            System.out.println("La cola esta vacía!"); 
        } else{
            while(!esVacia()){
                T x = desencolarFinal();

                if(x.equals(item) && !eliminado){
                    eliminado = true;
                } else{
                aux.encolar(x);
                }
            }
        }
        
        while(!aux.esVacia()){
        encolar(aux.desencolarFinal());
        }
        
        if(eliminado ==true){
            System.out.println("Se eliminó con éxito!");
        }
    }
   
    public Cola<T> copiar() {
        Cola<T> copia = new Cola<>();
        Cola<T> temp = new Cola<>();

        while (!this.esVacia()) {
            T elemento = this.desencolar();
            copia.encolar(elemento);
            temp.encolar(elemento);
        }

        while (!temp.esVacia()) {
            this.encolar(temp.desencolar());
        }

        return copia;
    }
  
    
    public boolean esVacia(){
        return frente == null;
    }
    
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
    
    public void encolar(T item){
        
        Node<T> nuevoNodo = new Node(item);
        if (esVacia()){
            /*
            Si la cola está vacía, entonces ambos apuntan al Nodo Item
            */
            ultimo = nuevoNodo; 
            frente = nuevoNodo;
        }else{
            nuevoNodo.setPrev(ultimo);
            ultimo.setNext(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    
    public T desencolar(){
        if(esVacia()){
            return null;
            //throw new RuntimeException("La cola está vacía");
        }
        else{
            T itemAux = frente.item();
            frente= frente.next();

            if (frente != null) {
                frente.setPrev(null);
            } else {
                // La cola quedó vacía
                ultimo = null;
            }
            return itemAux;
        }
    }
    
    public T desencolarFinal(){
        if(esVacia()){
            return null;
            //throw new RuntimeException("La cola está vacía");
        }
        else{
            T itemAux = ultimo.item();
            if (frente == ultimo) {
                frente = null;
                ultimo = null;
            } else {
                ultimo = ultimo.prev();
                if (ultimo != null) {
                    ultimo.setNext(null);
                }
            }

            return itemAux;
        }

    
    }
    
    public int length(){
        
        int largo = 0;
        Node<T> aux = frente;
        while(aux !=null){
            largo++;
            aux = aux.next();
        }
        
        return largo;
        
    }
    
    
    public void imprimirCola(){
        Node<T> aux = frente;
        while(aux !=null){
            System.out.print( aux.item().toString() + " ~ ");
            aux = aux.next();
        }
    }

    public Node<T> getFrente() {
        return frente;
    }

    public void setFrente(Node<T> frente) {
        this.frente = frente;
    }

    public Node<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node<T> ultimo) {
        this.ultimo = ultimo;
    }
    
    
    
}
