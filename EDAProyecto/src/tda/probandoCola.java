package TDA;

public class probandoCola {
    public static void main(String[] args) {
        
        Cola<Integer> Cola = new Cola();
        Cola.encolarFinal(1);
        Cola.encolarFinal(2);
        Cola.encolarFinal(3);
        Cola.encolarFinal(4);
        Cola.encolarFinal(5);
        Cola.encolarFrente(6);    
        Cola.encolarFrente(7);    
        Cola.encolarFrente(8);    
        System.out.println("");
        System.out.println(Cola.desencolarFinal());
        System.out.println(Cola.desencolarFinal());
        System.out.println(Cola.desencolarFinal());
        System.out.println(Cola.desencolarFrente());
        System.out.println(Cola.desencolarFrente());
        System.out.println(Cola.desencolarFrente());
        
        Cola.imprimirCola();
    }
    

}
