package co.edu.uniquindio.poo.hospital.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.LinkedList;

public class HistorialMedico {
    private String id;
    private LocalDate fecha;
    private String descripcion;
    private String diagnostico;
    private Paciente thePaciente;
    private Medico theMedico;
    private LinkedList<Examen> listaExamenes;
    private LinkedList<Tratamiento> listaTratamientos;
    private LinkedList<PrescripcionMedica> listaPrescripcionMedicas;


    public HistorialMedico(String id, LocalDate fecha, String descripcion, String diagnostico, Paciente thePaciente, Medico theMedico) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.thePaciente = thePaciente;
        this.theMedico = theMedico;
        this.listaExamenes = new LinkedList<>();
        this.listaTratamientos = new LinkedList<>();
        this.listaPrescripcionMedicas = new LinkedList<>();
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

    public Paciente getThePaciente() {
        return thePaciente;
    }

    public void setThePaciente(Paciente thePaciente) {
        this.thePaciente = thePaciente;
    }

    public Medico getTheMedico() {
        return theMedico;
    }
    public void setTheMedico(Medico theMedico) {
        this.theMedico = theMedico;
    }
    /// Examen CRUD


    public boolean agregarExamen(Examen examen) {
        this.listaExamenes.add(examen);
        return true;
    }

    public boolean eliminarExamen(Examen examen) {
        String id = examen.getId();
        for (Examen examen_local : this.listaExamenes){
            if (examen_local.getId().equals(id)){
                this.listaExamenes.remove(examen_local);
                return true;
            }
        }
        return false;
    }


    public boolean modificarExamen(Examen examen) {
        String id = examen.getId();
        for (Examen examen_local: this.listaExamenes){
            if (examen_local.getId().equals(id)){
                this.listaExamenes.remove(examen_local);
                this.listaExamenes.add(examen);
                return true;
            }
        }
        return false;
    }


    public Examen consultarExamen(String id) {
        for (Examen examen_local : this.listaExamenes){
            if (examen_local.getId().equals(id)){
                return examen_local;
            }
        }
        return null;
    }

    /// Tratamiento CRUD


    public boolean agregarTratamiento(Tratamiento tratamiento) {
        this.listaTratamientos.add(tratamiento);
        return true;
    }

    public boolean eliminarTratamiento(Tratamiento tratamiento) {
        String id = tratamiento.getId();
        for (Tratamiento tratamiento_local : this.listaTratamientos){
            if (tratamiento_local.getId().equals(id)){
                this.listaTratamientos.remove(tratamiento_local);
                return true;
            }
        }
        return false;
    }


    public boolean modificarTratamiento(Tratamiento tratamiento) {
        String id = tratamiento.getId();
        for (Tratamiento tratamiento_local : this.listaTratamientos){
            if (tratamiento_local.getId().equals(id)){
                this.listaTratamientos.remove(tratamiento_local);
                this.listaTratamientos.add(tratamiento);
                return true;
            }
        }
        return false;
    }


    public Tratamiento consultarTratamiento(String id) {
        for (Tratamiento tratamiento_local : this.listaTratamientos){
            if (tratamiento_local.getId().equals(id)){
                return tratamiento_local;
            }
        }
        return null;
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

