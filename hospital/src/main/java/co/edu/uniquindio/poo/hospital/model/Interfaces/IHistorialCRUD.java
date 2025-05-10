package co.edu.uniquindio.poo.hospital.model.Interfaces;

import co.edu.uniquindio.poo.hospital.model.HistorialMedico;

public interface IHistorialCRUD {
    boolean agregarHistorial(HistorialMedico historial);
    HistorialMedico consultarHistorial(String id);
    boolean modificarHistorial(HistorialMedico historial);
    boolean eliminarHistorial(HistorialMedico historial);

}
