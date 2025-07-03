/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.*;

/**
 *
 * @author EDUARDO
 */
public class Dependencia {
    private String nombre;

    private Cola<Expediente> colaDependencia;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.colaDependencia = new Cola();
    }
    
    
    public void encolarDependencia(Expediente exp) {
        Cola<Expediente> aux = new Cola<>();
        boolean agregado = false; //Flag para saber si se agregó o no

        int prioridadNueva = exp.getPrioridad();

        // Caso 0
        if (prioridadNueva == 0) {
            colaDependencia.encolarFrente(exp);
            return;
        }

        // Caso 3
        if (prioridadNueva == 3) {
            colaDependencia.encolar(exp);
            return;
        }

        // Caso 1 o 2
        while (!colaDependencia.esVacia()) {
            Expediente actual = colaDependencia.desencolar();
            int prioridadActual = actual.getPrioridad();

            if (!agregado && prioridadActual > prioridadNueva) {
                aux.encolar(exp); 
                agregado = true; //Se cambia a true
            }

            aux.encolar(actual); 
        }

        // Se inserta al final
        if (!agregado) {
            aux.encolar(exp);
        }

        // Restaura la Cola original
        while (!aux.esVacia()) {
            colaDependencia.encolar(aux.desencolar());
        }
    }

    public Cola<Expediente> getColaDependencia() {
        return colaDependencia;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
