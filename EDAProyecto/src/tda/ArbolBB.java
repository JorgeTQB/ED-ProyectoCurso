package tda;

import java.util.Stack;

public class ArbolBB<T extends Comparable> {
    // Atributos
    private T raiz;
    private ArbolBB<T> subArbolIzq;
    private ArbolBB<T> subArbolDer;

    public ArbolBB() {
        raiz = null;
        subArbolIzq = null;
        subArbolDer = null;
    }

    public ArbolBB(T raiz, 
            ArbolBB<T> subArbolIzq, 
            ArbolBB<T> subArbolDer) {
        this.raiz = raiz;
        this.subArbolIzq = subArbolIzq;
        this.subArbolDer = subArbolDer;
    }

    public T getRaiz() {
        return raiz;
    }


    public ArbolBB<T> getSubArbolIzq() {
        return subArbolIzq;
    }

    public void setSubArbolIzq(ArbolBB<T> subArbolIzq) {
        this.subArbolIzq = subArbolIzq;
    }

    public ArbolBB<T> getSubArbolDer() {
        return subArbolDer;
    }

    public void setSubArbolDer(ArbolBB<T> subArbolDer) {
        this.subArbolDer = subArbolDer;
    }
    
    // Otros metodos
    public boolean esVacio(){
        return raiz ==null;
    }
    /*
    Agregar un nuevo item al arbol
    */
    public void agregar(T item){
        // Caso 1: arbol esta vacio
        if (esVacio()){
            raiz = item;
        }else{
            if (raiz.compareTo(item)>0){ // La raiz es mayor a item
                // el item debe estar en el subarbol izq.
                if (subArbolIzq==null){
                    subArbolIzq = new ArbolBB(item,null,null);
                }else{
                    subArbolIzq.agregar(item);
                }
            }else if (raiz.compareTo(item)<0){ //raiz es menor al item
                if (subArbolDer==null){
                    subArbolDer = new ArbolBB(item,null,null);
                }else{
                    subArbolDer.agregar(item);
                }                
            }            
        }
    }
    // Recorrido en Inorden del arbolBB
    public void inOrden(){
        if (!esVacio()){
            if (subArbolIzq!=null)
                subArbolIzq.inOrden();
            System.out.print(raiz+"\t");
            if (subArbolDer!=null)
                subArbolDer.inOrden();
        }
    }
    /*
    Min: recupera el valor minimo del arboBB
    */
    public T min(){
        if (esVacio()){
            throw new RuntimeException("Error: el arbol esta vacio!!");
        }else{
            if (subArbolIzq==null)
                return raiz;
            else{
                return subArbolIzq.min();
            }
        }
    }
    /*
    * Buscar un item en el arbol
    */
    public boolean buscar(T item){
        boolean encontrado = false;
        if (!esVacio()){
            if (raiz.compareTo(item)==0){
                encontrado = true;
            }else{
                if (raiz.compareTo(item)>0){
                    // hacer la busqueda en la rama izq.
                    if (subArbolIzq!=null){
                        encontrado = subArbolIzq.buscar(item);
                    }
                }else if (raiz.compareTo(item)<0){
                    // el item debemos buscar en el subArbo derecho
                    if (subArbolDer!=null){
                        encontrado = subArbolDer.buscar(item);
                    }
                }
            }
        }
        return encontrado;
    }
    /*
    * Eliminar un item del arbol
    */
    public void eliminar(T item){
        if (!esVacio()){
            if (raiz.equals(item)){ // el item a eliminar es la raiz
                // Caso 1: Que la raiz se una hoja
                if (subArbolIzq == null && subArbolDer==null){
                    raiz = null;
                }else if (subArbolIzq!=null && subArbolDer == null){
                    // Caso 2: existe subArbo Izq pero sub Arbol Der no existe.
                    raiz = subArbolIzq.getRaiz();
                    subArbolDer = subArbolIzq.getSubArbolDer();
                    subArbolIzq = subArbolIzq.getSubArbolIzq();
                }else if (subArbolIzq==null && subArbolDer!=null){
                    // Caso 3: existe subArbolDer y NO existe subArbolIzq
                    raiz = subArbolDer.getRaiz();
                    subArbolIzq = subArbolDer.getSubArbolIzq();
                    subArbolDer = subArbolDer.getSubArbolDer();
                }else if (subArbolIzq!=null && subArbolDer!=null){
                    // Caso 4: el arbol tiene subArbol Izq y Der.
                    T temp = subArbolDer.min();
                    raiz = temp;
                    subArbolDer.eliminar(temp);
                }
                
            } else{
                // El item a eliminar no es la raiz
                // Caso 5: si el item esta en el sub Arbol izq.
                if (item.compareTo(raiz)<0){
                    if (subArbolIzq!=null){
                        subArbolIzq.eliminar(item);
                    }
                }else if (item.compareTo(raiz)>0){
                    // Caso 6: el item a eliminar esta en el subarbol Der
                    if (subArbolDer!=null){
                        subArbolDer.eliminar(item);
                    }
                }
            }
            
        }

    }
    
    public Stack stackWithHighertThan(T value) {
        Stack<T> stack = new Stack<>();
        
        stackWithHighertThan(value, stack, this);
        System.out.println("");
        return stack;
    }
    
    private void stackWithHighertThan(T value, Stack<T> stack, ArbolBB<T> arbol) {
        if (arbol == null || arbol.esVacio()) return;
        
        stackWithHighertThan(value, stack, arbol.subArbolIzq);
        
        if (arbol.raiz.compareTo(value) > 0) {
            stack.add(arbol.raiz);
            System.out.print(arbol.raiz.toString() + "\t");
        }
        
        stackWithHighertThan(value, stack, arbol.subArbolDer);        
    }
    
    public Stack stackWithHighertThanv2(T value) {
        Stack<T> stack = new Stack<>();
        stackWithHighertThanv2(value, stack);
        System.out.println("");
        return stack;
    }
    
    public void stackWithHighertThanv2(T value, Stack<T> stack) {
        if (esVacio()) return;
        
        if (subArbolIzq != null) subArbolIzq.stackWithHighertThanv2(value, stack);
        
        if (raiz.compareTo(value) > 0) {
            stack.add(raiz);
            System.out.print(raiz + "\t");
        }
        
        if (subArbolDer != null) subArbolDer.stackWithHighertThanv2(value, stack);
    }
}
