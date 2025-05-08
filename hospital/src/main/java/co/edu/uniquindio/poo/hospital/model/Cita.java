package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    private String id;
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private boolean estado;


    public Cita(String id, LocalDate dia, LocalTime horaInicio, LocalTime horaFinal, boolean estado){
        this.id=id;
        this.dia=dia;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.estado=estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
