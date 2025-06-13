/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import TDA.DoublyLinkedList;



/**
 *
 * @author PC
 */
public class Tramite {
    private int IdTramite;
    private String prioridad;
    private Expediente expediente;
    private String asunto;
    private String DocumentoReferencia;
    private DoublyLinkedList<Movimiento> movimientos;
    
    private int horaInicio;
    private int horaFin;
    
    

    public Tramite(int IdTramite, String prioridad, Expediente expediente, String asunto) {
        this.IdTramite = IdTramite;
        this.prioridad = prioridad;
        this.expediente = expediente;
        this.asunto = asunto;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdTramite() {
        return IdTramite;
    }

    public void setIdTramite(int IdTramite) {
        this.IdTramite = IdTramite;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
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
    
}
