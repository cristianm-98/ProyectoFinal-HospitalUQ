package co.edu.uniquindio.poo.hospital.model;

public class Hospital {
    private String nit;
    private String nombre;

    public Hospital(String nit,String nombre){
        this.nit=nit;
        this.nombre=nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
