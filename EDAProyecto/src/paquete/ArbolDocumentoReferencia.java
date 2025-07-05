/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

import tda.ArbolBB;


/**
 *
 * @author EDUARDO
 */
public class ArbolDocumentoReferencia {
    private ArbolBB<DocumentoReferencia> docRef;

    public ArbolDocumentoReferencia() {
        docRef = new ArbolBB();
    }

    public ArbolBB<DocumentoReferencia> getDocRef() {
        return docRef;
    }

    public void agregarDocumento(DocumentoReferencia doc){
        docRef.agregar(doc);
    }
    
    
}
