package co.edu.uniquindio.poo.hospital.model;

public class Examen {
    private String id;
    private String nombreExamen;
    private String descripcion;
    private HistorialMedico theHistorialMedico;

    public Examen(String id, String nombreExamen, String descripcion,HistorialMedico historialMedico){
        this.id=id;
        this.nombreExamen=nombreExamen;
        this.descripcion=descripcion;
        this.theHistorialMedico = historialMedico;
    }

    public Examen(String id, String nombreExamen) {
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
    public HistorialMedico getTheHistorialMedico() { return theHistorialMedico; }
    public void setTheHistorialMedico(HistorialMedico theHistorialMedico) { this.theHistorialMedico = theHistorialMedico; }
}
