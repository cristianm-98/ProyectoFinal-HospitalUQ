package co.edu.uniquindio.poo.hospital.model;

public class Medicamento {
    private String id;
    private String nombreMedicamento;
    private String descripcion;

    public Medicamento(String id,String nombreMedicamento,String descripcion){
        this.id=id;
        this.nombreMedicamento=nombreMedicamento;
        this.descripcion=descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
