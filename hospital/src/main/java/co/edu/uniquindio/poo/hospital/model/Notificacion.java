package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Notificacion {
    private String id;
    private LocalTime fechaEnvio;
    private String mensaje;
    private boolean leido;
    private Persona destinatario;

    public Notificacion(String id, LocalTime fechaEnvio, String mensaje, boolean leido, Persona destinatario){
        this.id=id;
        this.fechaEnvio=fechaEnvio;
        this.mensaje=mensaje;
        this.leido=leido;
        this.destinatario=destinatario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }
}
