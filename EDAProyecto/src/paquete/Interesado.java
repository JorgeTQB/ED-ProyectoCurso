/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author EDUARDO
 */
public class Interesado {
    
    private int DNI;
    private String Nombres;
    private int Telefono;
    private String email;
    private boolean externo;

    public Interesado(int DNI, String Nombres, int Telefono, String email, boolean externo) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Telefono = Telefono;
        this.email = email;
        this.externo = externo;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
