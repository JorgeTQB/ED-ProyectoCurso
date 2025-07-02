
package paquete;

import tda.DoublyLinkedList;


public class Expediente {
    
    private int IdTramite;
    private int prioridad;
    
    private String asunto;
    private String DocumentoReferencia;
    
    private Interesado interesado;
    
    private Dependencia depend;
    
    private DoublyLinkedList<Movimiento> movimientos;

    public Expediente(int IdTramite, int prioridad, Interesado intere, String asunto, String DocumentoReferencia) {
        this.IdTramite = IdTramite;
        this.prioridad = prioridad;
        this.interesado = intere;
        this.asunto = asunto;
        this.DocumentoReferencia = DocumentoReferencia;
        this.depend = null;
        this.movimientos = new DoublyLinkedList();
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocumentoReferencia() {
        return DocumentoReferencia;
    }

    public void setDocumentoReferencia(String DocumentoReferencia) {
        this.DocumentoReferencia = DocumentoReferencia;
    }

    public Dependencia getDepend() {
        return depend;
    }

    public void setDepend(Dependencia depend) {
        this.depend = depend;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public DoublyLinkedList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(DoublyLinkedList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    
    
}
