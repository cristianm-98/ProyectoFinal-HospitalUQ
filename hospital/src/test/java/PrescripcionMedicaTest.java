import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medicamento;
import co.edu.uniquindio.poo.hospital.model.PrescripcionMedica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrescripcionMedicaTest {

    private PrescripcionMedica prescripcion;
    private Medicamento medicamento;
    private HistorialMedico historial;

    @BeforeEach
    public void setUp() {
        medicamento = new Medicamento("med1", "Ibuprofeno", "Analgésico antiinflamatorio");
        historial = new HistorialMedico("h1", null, "Dolor de cabeza", "Migraña", null, null);

        prescripcion = new PrescripcionMedica("pr1", medicamento, historial);
    }

    @Test
    public void testCrearPrescripcionMedica() {
        assertEquals("pr1", prescripcion.getId());
        assertEquals(medicamento, prescripcion.getTheMedicamentos());
        assertEquals(historial, prescripcion.getTheHistorialMedico());
    }

    @Test
    public void testSetters() {
        Medicamento nuevoMedicamento = new Medicamento("med2", "Paracetamol", "Analgésico antipirético");
        HistorialMedico nuevoHistorial = new HistorialMedico("h2", null, "Dolor lumbar", "Lumbalgia", null, null);

        prescripcion.setId("pr2");
        prescripcion.setTheMedicamentos(nuevoMedicamento);
        prescripcion.setTheHistorialMedico(nuevoHistorial);

        assertEquals("pr2", prescripcion.getId());
        assertEquals(nuevoMedicamento, prescripcion.getTheMedicamentos());
        assertEquals(nuevoHistorial, prescripcion.getTheHistorialMedico());
    }
}
