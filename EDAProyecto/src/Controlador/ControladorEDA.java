/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import paquete.ListaColasDependencias;
import paquete.ListaTramites;
import paquete.Tramite;

/**
 *
 * @author HOGAR
 */
public class ControladorEDA {

    private ListaTramites listaTramites;
    private ListaColasDependencias colaDependencia;
    
    public ControladorEDA() {
        listaTramites = new ListaTramites();
        colaDependencia = new ListaColasDependencias();
    }
    
    
    public void agregarLT(Tramite tram){
        listaTramites.agregar(tram);
        
    }


    
    
    
    
}
