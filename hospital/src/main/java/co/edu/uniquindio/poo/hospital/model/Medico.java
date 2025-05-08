package co.edu.uniquindio.poo.hospital.model;

public class Medico extends Persona {
    private String licencia;
    private int anioExperiencia;

    public Medico(String id, String nombre, int edad, String telefono, String direccion, String licencia, int anioExperiencia) {
        super(id, nombre, edad, telefono, direccion);
        this.licencia = licencia;
        this.anioExperiencia = anioExperiencia;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getAnioExperiencia() {
        return anioExperiencia;
    }

    public void setAnioExperiencia(int anioExperiencia) {
        this.anioExperiencia = anioExperiencia;
    }
}
