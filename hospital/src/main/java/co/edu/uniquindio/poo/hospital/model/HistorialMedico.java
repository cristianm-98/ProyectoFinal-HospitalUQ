package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;

public class HistorialMedico {
    private String id;
    private LocalDate fecha;
    private String descripcion;
    private String diagnostico;

    public HistorialMedico(String id, LocalDate fecha, String descripcion,String diagnostico){
        this.id=id;
        this.fecha=fecha;
        this.descripcion=descripcion;
        this.diagnostico=diagnostico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}

