package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    private String id;
    private LocalDate dia;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private ConsultorioMedico theConsultorioMedico;
    private Paciente thepaciente;
    private Medico themedico;
    private boolean estado;


    public Cita(String id, LocalDate dia, LocalTime horaInicio, LocalTime horaFinal, boolean estado, ConsultorioMedico theConsultorioMedico, Paciente thepaciente, Medico themedico){
        this.id=id;
        this.dia=dia;
        this.horaInicio=horaInicio;
        this.horaFinal=horaFinal;
        this.estado=estado;
        this.theConsultorioMedico=theConsultorioMedico;
        this.thepaciente=thepaciente;
        this.themedico=themedico;
    }

    public Cita(String id, String dia) {
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

    public ConsultorioMedico getTheConsultorioMedico() { return theConsultorioMedico; }
    public void setTheConsultorioMedico(ConsultorioMedico theConsultorioMedico) { this.theConsultorioMedico = theConsultorioMedico; }

    public Paciente getThepaciente() { return thepaciente; }
    public void setThepaciente(Paciente thepaciente) { this.thepaciente = thepaciente; }

    public Medico getThemedico() { return themedico; }
    public void setThemedico(Medico themedico) { this.themedico = themedico; }


}
