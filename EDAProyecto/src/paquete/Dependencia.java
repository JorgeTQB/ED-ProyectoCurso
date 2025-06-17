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

    private Cola colaDependencia;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.colaDependencia = new Cola();
    }
    
    
}
