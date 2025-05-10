package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class PrescripcionMedica {
    private String id;
    private Medicamento theMedicamentos;

    public PrescripcionMedica(String id, Medicamento theMedicamentos) {
        this.id=id;
        this.theMedicamentos = theMedicamentos;
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
}
