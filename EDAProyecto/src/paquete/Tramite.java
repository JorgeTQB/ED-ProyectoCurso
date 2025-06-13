/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import TDA.DoublyLinkedList;

import java.util.Calendar;



/**
 *
 * @author PC
 */
public class Tramite {
    private int IdTramite;
    private int prioridad;
    private Expediente expediente;
    private String asunto;
    private String DocumentoReferencia;
    private DoublyLinkedList<Movimiento> movimientos;

    private boolean finalizado = false;
    
    private Calendar horaInicio;
    private Calendar horaFin;
    
    

    public Tramite(int IdTramite, int prioridad, Expediente expediente, String asunto) {
        this.IdTramite = IdTramite;
        this.prioridad = prioridad;
        this.expediente = expediente;
        this.asunto = asunto;
        this.horaInicio = Calendar.getInstance();
    }


    public int getIdTramite() {
        return IdTramite;
    }

    public void setIdTramite(int IdTramite) {
        this.IdTramite = IdTramite;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public void finalizarTramite(){
        this.horaFin = Calendar.getInstance();
        finalizado = true;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public Calendar getHoraFin() {
        return horaFin;
    }
    
}
