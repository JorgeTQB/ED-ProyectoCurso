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
import tda.Cola;
import tda.Node;

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
    private int contadorTramites;
    
    
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
        if(!listaInteresados.existInter(dni)){
            listaInteresados.AgregarInteresado(intere);
        }
        Expediente expe = new Expediente(contadorId, prioridad, intere, asunto, docrefe);
        
        expe.setDepend(colaDependencia.getInicio());
        
        Tramite tramit = new Tramite(expe);
        
        listaTramites.agregar(tramit);
        
        colaDependencia.getInicio().encolarDependencia(expe);
        
        contadorId++;
        contadorTramites++;
        
    }
    

    public void moverExpToDepend(String combo, String combo2){
        
        Expediente aux1 = colaDependencia.conseguirDependencia(combo).getColaDependencia().desencolar();
        aux1.setDepend(colaDependencia.conseguirDependencia(combo2));
        
        aux1.getMovimientos().agregarFinal(new Movimiento(colaDependencia.conseguirDependencia(combo), colaDependencia.conseguirDependencia(combo2)));
        colaDependencia.conseguirDependencia(combo2).encolarDependencia(aux1);
        
    }
    
    public Tramite FinalizarTramiteNoEspecifico(String combo) {
        
        Cola<Expediente> colaAux = this.colaDependencia.conseguirDependencia(combo).getColaDependencia();

        Expediente expFinalizado = colaAux.desencolar();

        // Buscar y desencolar el trámite correspondiente
        Cola<Tramite> tramites = this.listaTramites.getListaTramites();
        Cola<Tramite> aux = new Cola<>();
        Tramite tramiteFinalizar = null;

        while (!tramites.esVacia()) {
            Tramite t = tramites.desencolar();
            if (t.getExpediente().getIdTramite() == expFinalizado.getIdTramite() && tramiteFinalizar == null) {
                tramiteFinalizar = t; // Encontrado y no lo volvemos a encolar
            } else {
                aux.encolar(t); // Guardamos los demás
            }
        }

        // Restaurar la cola original sin el trámite finalizado
        while (!aux.esVacia()) {
            tramites.encolar(aux.desencolar());
        }
        contadorTramites--;
        return tramiteFinalizar;
        
    }    
    
    public void FinalizarTramiteEspecifico(int idExpediente) {
        
        //Finalizar Expediente en las Colas
        Tramite tram = this.listaTramites.get(idExpediente);
        String dependencia = tram.getExpediente().getDepend().getNombre();
        
        Cola<Expediente> colaAux = this.colaDependencia.conseguirDependencia(dependencia).getColaDependencia();
        Node<Expediente> auxExp = colaAux.getFrente();
        
        contadorTramites--;
        
        while(auxExp != null){
            
            if(auxExp.item().getIdTramite() == idExpediente){
                colaAux.eliminarTr(auxExp.item());
                System.out.println("Se elimina el id " + auxExp.item().getIdTramite());
            }
            
            auxExp = auxExp.next();
        }
        
        //Finalizar Expediente en la lista Tramites
        Cola<Tramite> tramites = this.listaTramites.getListaTramites();
        
        Node<Tramite> auxTram = tramites.getFrente();
        
        while(auxTram != null){
            
            if(auxTram.item().getExpediente().getIdTramite() == idExpediente){
                tramites.eliminarTr(auxTram.item());
                System.out.println("Se elimina el id " + auxTram.item().getExpediente().getIdTramite());
            }
            
            auxTram = auxTram.next();
        }
        
        /*
        Cola<Tramite> aux = new Cola();
        
        
        Tramite tramiteFinalizar = null;

        while (!tramites.esVacia()) {
            Tramite t = tramites.desencolar();
            if (t.getExpediente().getIdTramite() == expFinalizado.getIdTramite() && tramiteFinalizar == null) {
                tramiteFinalizar = t; // Encontrado y no lo volvemos a encolar
            } else {
                aux.encolar(t); // Guardamos los demás
            }
        }

        // Restaurar la cola original sin el trámite finalizado
        while (!aux.esVacia()) {
            tramites.encolar(aux.desencolar());
        }
        
        return tramiteFinalizar;
        */
    }   
    

    public ListaInteresados getListaInteresados() {
        return listaInteresados;
    }
    
    public int getContadorId(){
        return contadorId;
    }
    
    public int getContadorTramites(){
        return this.contadorTramites;
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
