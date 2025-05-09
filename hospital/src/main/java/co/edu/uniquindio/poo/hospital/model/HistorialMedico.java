package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class HistorialMedico {
    private String id;
    private LocalDate fecha;
    private String descripcion;
    private String diagnostico;
    private Paciente paciente;
    private LinkedList<Examen> listaExamenes;
    private LinkedList<Tratamiento> listaTratamientos;
    private LinkedList<PrescripcionMedica> listaPrescripcionMedicas;



    public HistorialMedico(String id, LocalDate fecha, String descripcion, String diagnostico, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.paciente=paciente;
        listaExamenes = new LinkedList<>();
        listaTratamientos = new LinkedList<>();
        listaPrescripcionMedicas = new LinkedList<>();
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

    public LinkedList<Examen> getListaExamenes() {
        return listaExamenes;
    }

    public void setListaExamenes(LinkedList<Examen> listaExamenes) {
        this.listaExamenes = listaExamenes;
    }

    public LinkedList<Tratamiento> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(LinkedList<Tratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public LinkedList<PrescripcionMedica> getListaPrescripcionMedicas() {
        return listaPrescripcionMedicas;
    }

    public void setListaPrescripcionMedicas(LinkedList<PrescripcionMedica> listaPrescripcionMedicas) {
        this.listaPrescripcionMedicas = listaPrescripcionMedicas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

