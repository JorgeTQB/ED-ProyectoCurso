/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import paquete.Expediente;
import paquete.Interesado;
import paquete.ListaColasDependencias;
import paquete.ListaDoblyTramites;
import paquete.ListaInteresados;
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
    private ListaInteresados listaInteresados;
    private int contadorId;
    
    
    private ControladorEDA() {
        listaTramites = new ListaTramites();
        colaDependencia = new ListaColasDependencias();
        listaInteresados = new ListaInteresados();
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
        //if(!listaInteresados.existInter(dni)){
        //    listaInteresados.AgregarInteresado(intere);
        //}
        Expediente expe = new Expediente(contadorId, prioridad, intere, asunto, docrefe);
        
        expe.setDepend(colaDependencia.getInicio());
        
        Tramite tramit = new Tramite(expe);
        
        listaTramites.agregar(tramit);
        
        colaDependencia.getInicio().encolarDependencia(expe);
        
        contadorId++;
        
    }
    

    public void moverExpToDepend(String combo, String combo2){
        
        Expediente aux1 = colaDependencia.conseguirDependencia(combo).getColaDependencia().desencolar();
        aux1.setDepend(colaDependencia.conseguirDependencia(combo2));
        
        aux1.getMovimientos().agregarFinal(new Movimiento(colaDependencia.conseguirDependencia(combo), colaDependencia.conseguirDependencia(combo2)));
        colaDependencia.conseguirDependencia(combo2).encolarDependencia(aux1);
        
    }

    public ListaInteresados getListaInteresados() {
        return listaInteresados;
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
