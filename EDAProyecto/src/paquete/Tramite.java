/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.*;

import java.util.Calendar;



/**
 *
 * @author PC
 */
public class Tramite {
    
    
    
    private Expediente expediente;
    

    private boolean finalizado = false;
    
    private Calendar horaInicio;
    private Calendar horaFin;
    
    
    

    public Tramite(Expediente expediente) {
        
        this.expediente = expediente;
        
        this.horaInicio = Calendar.getInstance();
        
    }
   



    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
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

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
    
}
