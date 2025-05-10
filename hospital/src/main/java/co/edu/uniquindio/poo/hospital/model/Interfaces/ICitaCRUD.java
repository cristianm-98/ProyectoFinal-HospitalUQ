package co.edu.uniquindio.poo.hospital.model.Interfaces;
import co.edu.uniquindio.poo.hospital.model.Cita;

public interface ICitaCRUD {
    boolean agregarCita(Cita cita);
    Cita consultarCita(String id);
    boolean modificarCita(Cita cita);
    boolean eliminarCita(Cita cita);
}
