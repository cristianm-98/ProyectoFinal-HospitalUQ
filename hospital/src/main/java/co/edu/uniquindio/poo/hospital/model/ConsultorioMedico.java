package co.edu.uniquindio.poo.hospital.model;

public class ConsultorioMedico {
    private String id;
    private String nombre;
    private boolean disponible;
    private byte numeroSala;

    public ConsultorioMedico(String id, String nombre,boolean disponible, byte numeroSala){
        this.id=id;
        this.nombre=nombre;
        this.disponible=disponible;
        this.numeroSala=numeroSala;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public byte getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(byte numeroSala) {
        this.numeroSala = numeroSala;
    }
}
