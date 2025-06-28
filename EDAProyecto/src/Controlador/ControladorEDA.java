/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import paquete.Expediente;
import paquete.Interesado;
import paquete.ListaColasDependencias;
import paquete.ListaTramites;
import paquete.Movimiento;
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
        contadorId = 1;
    }
    
    
    public void agregarInicio(int prioridad, int dni, String nombres, int telefono, String email, String asunto, String docrefe){
        Interesado intere = new Interesado(dni, nombres, telefono, email);
        Expediente expe = new Expediente(contadorId, prioridad, intere, asunto, docrefe);
        
        expe.setDepend(colaDependencia.getInicio());
        
        Tramite tramit = new Tramite(expe);
        
        listaTramites.agregar(tramit);
        colaDependencia.getInicio().encolarDependencia(tramit); 
        
        contadorId++;
        
    }
    

    public void moverTramDepend(String combo, String combo2){
        
        Tramite aux1 = colaDependencia.conseguirDependencia(combo).getColaDependencia().desencolar();
        aux1.getExpediente().setDepend(colaDependencia.conseguirDependencia(combo2));
        aux1.getMovimientos().agregarFinal(new Movimiento(colaDependencia.conseguirDependencia(combo), colaDependencia.conseguirDependencia(combo2)));
        colaDependencia.conseguirDependencia(combo2).getColaDependencia().encolar(aux1);
        
    }
    
    public ListaTramites getListaTramites() {
        return listaTramites;
    }

    public ListaColasDependencias getColaDependencia() {
        return colaDependencia;
    }

    

    
    
    
    
}
