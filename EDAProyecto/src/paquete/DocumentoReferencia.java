/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author EDUARDO
 */
public class DocumentoReferencia implements Comparable<DocumentoReferencia> {
    private String nombre;

    public DocumentoReferencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(DocumentoReferencia otro) {
        return this.nombre.compareTo(otro.nombre);
    }
    
}
