package co.edu.uniquindio.poo.hospital.model;

public class Examen {
    private String id;
    private String nombreExamen;
    private String descripcion;

    public Examen(String id, String nombreExamen, String descripcion){
        this.id=id;
        this.nombreExamen=nombreExamen;
        this.descripcion=descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
