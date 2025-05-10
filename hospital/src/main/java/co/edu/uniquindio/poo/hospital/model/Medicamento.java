package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class Medicamento {
    private String id;
    private String nombreMedicamento;
    private String descripcion;
    private LinkedList<PrescripcionMedica>listaPrescripcionMedicas;

    public Medicamento(String id,String nombreMedicamento,String descripcion){
        this.id=id;
        this.nombreMedicamento=nombreMedicamento;
        this.descripcion=descripcion;
        listaPrescripcionMedicas=new LinkedList<>();
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

    public LinkedList<PrescripcionMedica> getListaPrescripcionMedicas() {
        return listaPrescripcionMedicas;
    }

    public void setListaPrescripcionMedicas(LinkedList<PrescripcionMedica> listaPrescripcionMedicas) {
        this.listaPrescripcionMedicas = listaPrescripcionMedicas;
    }

    /// PrescripcionMedica CRUD


    public boolean agregarPrescripcion(PrescripcionMedica prescripcionMedica) {
        this.listaPrescripcionMedicas.add(prescripcionMedica);
        return true;
    }

    public boolean eliminarPrescripcion(PrescripcionMedica prescripcionMedica) {
        String id = prescripcionMedica.getId();
        for (PrescripcionMedica prescripcionMedica_local : this.listaPrescripcionMedicas){
            if (prescripcionMedica_local.getId().equals(id)){
                this.listaPrescripcionMedicas.remove(prescripcionMedica_local);
                return true;
            }
        }
        return false;
    }


    public boolean modificarPrescripcion(PrescripcionMedica prescripcionMedica) {
        String id = prescripcionMedica.getId();
        for (PrescripcionMedica prescripcionMedica_local : this.listaPrescripcionMedicas){
            if (prescripcionMedica_local.getId().equals(id)){
                this.listaPrescripcionMedicas.remove(prescripcionMedica_local);
                this.listaPrescripcionMedicas.add(prescripcionMedica);
                return true;
            }
        }
        return false;
    }


    public PrescripcionMedica consultarPrescripcion(String id) {
        for (PrescripcionMedica prescripcionMedica_local : this.listaPrescripcionMedicas){
            if (prescripcionMedica_local.getId().equals(id)){
                return prescripcionMedica_local;
            }
        }
        return null;
    }
}
