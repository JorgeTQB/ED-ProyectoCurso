/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author EDUARDO
 */
public class Movimiento {
    private Dependencia origen;
    private Dependencia destino;

    public Movimiento(Dependencia origen, Dependencia destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public Dependencia getOrigen() {
        return origen;
    }

    public void setOrigen(Dependencia origen) {
        this.origen = origen;
    }

    public Dependencia getDestino() {
        return destino;
    }

    public void setDestino(Dependencia destino) {
        this.destino = destino;
    }
    
    
    
    
}
