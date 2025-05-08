package co.edu.uniquindio.poo.hospital.model;

import java.util.LinkedList;

public class Paciente extends Persona{
    private String tipoSangre;
    private LinkedList<Notificacion>listaNotificaciones;
    private LinkedList<HistorialMedico>listaHistorialMedicos;
    private LinkedList<Cita>listaCitas;

    public Paciente(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario,String tipoSangre){
        super(id,nombre,edad,telefono,direccion,theUsusario);
        this.tipoSangre=tipoSangre;
        listaNotificaciones=new LinkedList<>();
        listaHistorialMedicos=new LinkedList<>();
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

    public LinkedList<HistorialMedico> getListaHistorialMedicos() {
        return listaHistorialMedicos;
    }

    public void setListaHistorialMedicos(LinkedList<HistorialMedico> listaHistorialMedicos) {
        this.listaHistorialMedicos = listaHistorialMedicos;
    }

    public LinkedList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(LinkedList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }
}
