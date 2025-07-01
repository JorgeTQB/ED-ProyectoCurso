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
    
    private static ControladorEDA instancia;

    private ListaTramites listaTramites;
    private ListaColasDependencias colaDependencia;
    private int contadorId;
    
    private ControladorEDA() {
        listaTramites = new ListaTramites();
        colaDependencia = new ListaColasDependencias();
        contadorId = 1;
    }
    
    public static ControladorEDA getInstance(){
        if(instancia == null){
            instancia = new ControladorEDA();
        }
        return instancia;
    }
    
    
    public void agregarInicio(int prioridad, int dni, String nombres, int telefono, String email, String asunto, String docrefe, boolean externo){
        Interesado intere = new Interesado(dni, nombres, telefono, email, externo);
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
    
    public int getContadorId(){
        return contadorId;
    }
    
    public void ControlCrearDependencia(String nombre){
        colaDependencia.crearDependencia(nombre);
    }
    
    public String[] conseguirNombresDependencia(){
        String[] nombres = colaDependencia.conseguirNombresDP();
        
        return nombres;
    }
    
    public ListaTramites getListaTramites() {
        return listaTramites;
    }

    public ListaColasDependencias getColaDependencia() {
        return colaDependencia;
    }
    
    
}
