package co.edu.uniquindio.poo.hospital.model;

import co.edu.uniquindio.poo.hospital.model.Interfaces.IHistorialCRUD;
import co.edu.uniquindio.poo.hospital.model.Interfaces.INotificacionCRUD;

import java.util.LinkedList;

public class Medico extends Persona implements IHistorialCRUD, INotificacionCRUD {
    private String licencia;
    private int anioExperiencia;
    private LinkedList<HistorialMedico>listaHistorialMedicos;
    private LinkedList<Notificacion>listaNotificaciones;
    private LinkedList<HorarioAtencion>listaHorarioAtenciones;
    private LinkedList<Cita>listaCitas;
    private Especialidad especialidad;


    public Medico(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario, String licencia, int anioExperiencia,Especialidad especialidad) {
        super(id, nombre, edad, telefono, direccion,theUsusario);
        this.licencia = licencia;
        this.anioExperiencia = anioExperiencia;
        this.especialidad=especialidad;
        listaHistorialMedicos=new LinkedList<>();
        listaNotificaciones=new LinkedList<>();
        listaHorarioAtenciones=new LinkedList<>();
        listaCitas=new LinkedList<>();
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getAnioExperiencia() {
        return anioExperiencia;
    }

    public void setAnioExperiencia(int anioExperiencia) {
        this.anioExperiencia = anioExperiencia;
    }

    public LinkedList<HistorialMedico> getListaHistorialMedicos() {
        return listaHistorialMedicos;
    }

    public void setListaHistorialMedicos(LinkedList<HistorialMedico> listaHistorialMedicos) {
        this.listaHistorialMedicos = listaHistorialMedicos;
    }

    public LinkedList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(LinkedList<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }

    public LinkedList<HorarioAtencion> getListaHorarioAtenciones() {
        return listaHorarioAtenciones;
    }

    public void setListaHorarioAtenciones(LinkedList<HorarioAtencion> listaHorarioAtenciones) {
        this.listaHorarioAtenciones = listaHorarioAtenciones;
    }

    public LinkedList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(LinkedList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /// Notificaciones CRUD
    @Override
    public boolean agregarNotificacion(Notificacion notificacion) {
        this.listaNotificaciones.add(notificacion);
        return true;
    }
    @Override
    public boolean eliminarNotificacion(Notificacion notificacion) {
        String id = notificacion.getId();
        for (Notificacion notificacion_local : this.listaNotificaciones){
            if (notificacion_local.getId().equals(id)){
                this.listaNotificaciones.remove(notificacion_local);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean modificarNotificacion(Notificacion notificacion) {
        String id = notificacion.getId();
        for (Notificacion notificacion_local : this.listaNotificaciones){
            if (notificacion_local.getId().equals(id)){
                this.listaNotificaciones.remove(notificacion_local);
                this.listaNotificaciones.add(notificacion);
                return true;
            }
        }
        return false;
    }

    @Override
    public Notificacion consultarNotificacion(String id) {
        for (Notificacion notificacion_local: this.listaNotificaciones){
            if (notificacion_local.getId().equals(id)){
                return notificacion_local;
            }
        }
        return null;
    }

    /// Historial CRUD

    @Override
    public boolean agregarHistorial(HistorialMedico historial) {
        this.listaHistorialMedicos.add(historial);
        return true;
    }

    @Override
    public boolean eliminarHistorial(HistorialMedico historial) {
        String id = historial.getId();
        for (HistorialMedico historial_local: this.listaHistorialMedicos){
            if (historial_local.getId().equals(id)){
                this.listaHistorialMedicos.remove(historial_local);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modificarHistorial(HistorialMedico historial) {
        String id = historial.getId();
        for (HistorialMedico historial_local: this.listaHistorialMedicos){
            if (historial_local.getId().equals(id)){
                this.listaHistorialMedicos.remove(historial_local);
                this.listaHistorialMedicos.add(historial);
                return true;
            }
        }
        return false;
    }

    @Override
    public HistorialMedico consultarHistorial(String id) {
        for (HistorialMedico historial_local: this.listaHistorialMedicos){
            if (historial_local.getId().equals(id)){
                return historial_local;
            }
        }
        return null;
    }
}
