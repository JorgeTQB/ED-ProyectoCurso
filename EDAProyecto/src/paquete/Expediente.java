
package paquete;


public class Expediente {
    private int DNI;
    private String Nombres;
    private int Telefono;
    private String email;

    public Expediente(int DNI, String Nombres, int Telefono, String email) {
        this.DNI = DNI;
        this.Nombres = Nombres;
        this.Telefono = Telefono;
        this.email = email;
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
