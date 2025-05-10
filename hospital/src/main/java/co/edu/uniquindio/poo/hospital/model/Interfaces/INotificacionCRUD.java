package co.edu.uniquindio.poo.hospital.model.Interfaces;
import co.edu.uniquindio.poo.hospital.model.Notificacion;

public interface INotificacionCRUD {
    boolean agregarNotificacion(Notificacion notificacion);
    Notificacion consultarNotificacion(String id);
    boolean modificarNotificacion(Notificacion notificacion);
    boolean eliminarNotificacion(Notificacion notificacion);
}
