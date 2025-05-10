package co.edu.uniquindio.poo.hospital.model;

import co.edu.uniquindio.poo.hospital.model.Interfaces.ICitaCRUD;
import co.edu.uniquindio.poo.hospital.model.Interfaces.IHistorialCRUD;
import co.edu.uniquindio.poo.hospital.model.Interfaces.INotificacionCRUD;

import java.util.LinkedList;

public class Paciente extends Persona implements IHistorialCRUD, INotificacionCRUD, ICitaCRUD {
    private String tipoSangre;
    private LinkedList<Notificacion>listaNotificaciones;
    private LinkedList<Cita>listaCitas;
    private LinkedList<HistorialMedico> listahistorialMedico;

    public Paciente(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario,String tipoSangre){
        super(id,nombre,edad,telefono,direccion,theUsusario);
        this.tipoSangre=tipoSangre;
        listaNotificaciones=new LinkedList<>();
        listaCitas=new LinkedList<>();
        listahistorialMedico=new LinkedList<>();
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

    public LinkedList<HistorialMedico> getListahistorialMedico() {
        return listahistorialMedico;
    }

    public void setListahistorialMedico(LinkedList<HistorialMedico> listahistorialMedico) {
        this.listahistorialMedico = listahistorialMedico;
    }
    /// Cita CRUD
    @Override
    public boolean agregarCita(Cita cita) {
        this.listaCitas.add(cita);
        return true;
    }
    @Override
    public boolean eliminarCita(Cita cita) {
        String id = cita.getId();
        for (Cita cita_local : this.listaCitas){
            if (cita_local.getId().equals(id)){
                this.listaCitas.remove(cita_local);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean modificarCita(Cita cita) {
        String id = cita.getId();
        for (Cita cita_local : this.listaCitas){
            if (cita_local.getId().equals(id)){
                this.listaCitas.remove(cita_local);
                this.listaCitas.add(cita);
                return true;
            }
        }
        return false;
    }

    @Override
    public Cita consultarCita(String id) {
        for (Cita cita_local: this.listaCitas){
            if (cita_local.getId().equals(id)){
                return cita_local;
            }
        }
        return null;
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
        this.listahistorialMedico.add(historial);
        return true;
    }

    @Override
    public boolean eliminarHistorial(HistorialMedico historial) {
        String id = historial.getId();
        for (HistorialMedico historial_local: this.listahistorialMedico){
            if (historial_local.getId().equals(id)){
                this.listahistorialMedico.remove(historial_local);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modificarHistorial(HistorialMedico historial) {
        String id = historial.getId();
        for (HistorialMedico historial_local: this.listahistorialMedico){
            if (historial_local.getId().equals(id)){
                this.listahistorialMedico.remove(historial_local);
                this.listahistorialMedico.add(historial);
                return true;
            }
        }
        return false;
    }

    @Override
    public HistorialMedico consultarHistorial(String id) {
        for (HistorialMedico historial_local: this.listahistorialMedico){
            if (historial_local.getId().equals(id)){
                return historial_local;
            }
        }
        return null;
    }
}
