/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author n04120
 */
public class Expediente {
    
    private int IdExpediente;
    private String prioridad;
    private Interesado interesado;
    private String asunto;
    private String DocumentoReferencia;
    
    private int horaInicio;
    private int horaFin;
    
    

    public Expediente(int IdExpediente, String prioridad, Interesado interesado, String asunto) {
        this.IdExpediente = IdExpediente;
        this.prioridad = prioridad;
        this.interesado = interesado;
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

    public int getIdExpediente() {
        return IdExpediente;
    }

    public void setIdExpediente(int IdExpediente) {
        this.IdExpediente = IdExpediente;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    
    
    
}
