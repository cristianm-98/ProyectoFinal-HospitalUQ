package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class Paciente extends Persona{
    private String tipoSangre;
    private LinkedList<Notificacion>listaNotificaciones;
    private LinkedList<Cita>listaCitas;
    private HistorialMedico historialMedico;

    public Paciente(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario,String tipoSangre){
        super(id,nombre,edad,telefono,direccion,theUsusario);
        this.tipoSangre=tipoSangre;
        listaNotificaciones=new LinkedList<>();
        listaCitas=new LinkedList<>();
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public LinkedList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(LinkedList<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }


    public LinkedList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(LinkedList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }
}
