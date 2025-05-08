package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class PrescripcionMedica {
    private String id;
    private LinkedList<Medicamento>listaMedicamentos;

    public PrescripcionMedica(String id) {
        this.id=id;
        listaMedicamentos=new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(LinkedList<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }
}
