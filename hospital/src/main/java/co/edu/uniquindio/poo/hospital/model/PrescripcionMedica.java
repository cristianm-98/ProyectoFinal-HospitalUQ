package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class PrescripcionMedica {
    private String id;
    private Medicamento theMedicamentos;
    private HistorialMedico theHistorialMedico;

    public PrescripcionMedica(String id, Medicamento theMedicamentos, HistorialMedico theHistorialMedico) {
        this.id=id;
        this.theMedicamentos = theMedicamentos;
        this.theHistorialMedico = theHistorialMedico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medicamento getTheMedicamentos() {
        return theMedicamentos;
    }

    public void setTheMedicamentos(Medicamento theMedicamentos) {
        this.theMedicamentos = theMedicamentos;
    }

    public HistorialMedico getTheHistorialMedico() { return theHistorialMedico; }
    public void setTheHistorialMedico(HistorialMedico theHistorialMedico) {}
}
