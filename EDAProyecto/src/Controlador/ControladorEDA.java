/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import paquete.Expediente;
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
    private int contadorId;
    
    public ControladorEDA() {
        listaTramites = new ListaTramites();
        colaDependencia = new ListaColasDependencias();
        contadorId = 0;
    }
    
    
    public void agregarLT(int dni, String nombres, int telefono, String email, String asunto, String docrefe){
        Tramite tramit = new Tramite(contadorId, 1, new Expediente(dni, nombres, telefono, email), asunto, docrefe);
        contadorId++;
        listaTramites.agregar(tramit);
        
    }
    public void agregarDP(int dni, String nombres, int telefono, String email, String asunto, String docrefe){
        Tramite tramit = new Tramite(contadorId, 1, new Expediente(dni, nombres, telefono, email), asunto, docrefe);
        colaDependencia.getInicio().encolarDependencia(tramit);
    }

    public ListaTramites getListaTramites() {
        return listaTramites;
    }

    public ListaColasDependencias getColaDependencia() {
        return colaDependencia;
    }

    

    
    
    
    
}
