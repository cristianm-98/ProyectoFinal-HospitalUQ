package co.edu.uniquindio.poo.hospital.model;

public class Tratamiento {
    private String id;
    private String descripcion;
    private HistorialMedico theHistorialMedico;
    public Tratamiento(String id,String descripcion,HistorialMedico theHistorialMedico){
        this.id=id;
        this.descripcion=descripcion;
        this.theHistorialMedico=theHistorialMedico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
