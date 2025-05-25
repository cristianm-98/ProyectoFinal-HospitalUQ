package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioAtencion {
    private String id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFinal;

    public HorarioAtencion(String id,String dia,LocalTime horaInicio, LocalTime horaFinal){
        this.id=id;
        this.dia=dia;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
    }

    public HorarioAtencion(String id, String dia) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
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
}
