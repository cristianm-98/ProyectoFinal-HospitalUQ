import co.edu.uniquindio.poo.hospital.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HistorialMedicoTest {

    private HistorialMedico historial;
    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente("p1", "Juan", 30, "123456", "Calle 1", null, "O+");
        medico = new Medico("m1", "Dra. Ana", 40, "654321", "Avenida 2", null, "LIC001", 15, Especialidad.GINECOLOGIA);

        historial = new HistorialMedico("h1", LocalDate.of(2024, 5, 25), "Dolor de cabeza", "Migraña", paciente, medico);
    }

    @Test
    public void testCrearHistorial() {
        assertEquals("h1", historial.getId());
        assertEquals(LocalDate.of(2024, 5, 25), historial.getFecha());
        assertEquals("Dolor de cabeza", historial.getDescripcion());
        assertEquals("Migraña", historial.getDiagnostico());
        assertEquals(paciente, historial.getThePaciente());
        assertEquals(medico, historial.getTheMedico());
    }

    @Test
    public void testSetters() {
        Paciente nuevoPaciente = new Paciente("p2", "Maria", 28, "987654", "Calle 2", null, "A-");
        Medico nuevoMedico = new Medico("m2", "Dr. Luis", 45, "789123", "Avenida 3", null, "LIC002", 20, Especialidad.ORTOPEDIA);

        historial.setId("h2");
        historial.setFecha(LocalDate.of(2024, 6, 1));
        historial.setDescripcion("Dolor lumbar");
        historial.setDiagnostico("Lumbalgia");
        historial.setThePaciente(nuevoPaciente);
        historial.setTheMedico(nuevoMedico);

        assertEquals("h2", historial.getId());
        assertEquals(LocalDate.of(2024, 6, 1), historial.getFecha());
        assertEquals("Dolor lumbar", historial.getDescripcion());
        assertEquals("Lumbalgia", historial.getDiagnostico());
        assertEquals(nuevoPaciente, historial.getThePaciente());
        assertEquals(nuevoMedico, historial.getTheMedico());
    }

    @Test
    public void testAgregarYConsultarExamen() {
        Examen examen = new Examen("ex1", "Sangre");
        assertTrue(historial.agregarExamen(examen));
        assertEquals(examen, historial.consultarExamen("ex1"));
    }

    @Test
    public void testModificarExamen() {
        Examen ex1 = new Examen("ex1", "Sangre");
        Examen ex2 = new Examen("ex1", "Orina");
        historial.agregarExamen(ex1);
        assertTrue(historial.modificarExamen(ex2));
        assertEquals(ex2, historial.consultarExamen("ex1"));
    }

    @Test
    public void testEliminarExamen() {
        Examen examen = new Examen("ex1", "Sangre");
        historial.agregarExamen(examen);
        assertTrue(historial.eliminarExamen(examen));
        assertNull(historial.consultarExamen("ex1"));
    }

    @Test
    public void testAgregarYConsultarTratamiento() {
        Tratamiento tratamiento = new Tratamiento("tr1", "Fisioterapia", null);
        assertTrue(historial.agregarTratamiento(tratamiento));
        assertEquals(tratamiento, historial.consultarTratamiento("tr1"));
    }

    @Test
    public void testModificarTratamiento() {
        Tratamiento tr1 = new Tratamiento("tr1", "Fisioterapia",null);
        Tratamiento tr2 = new Tratamiento("tr1", "Medicamentos",null);
        historial.agregarTratamiento(tr1);
        assertTrue(historial.modificarTratamiento(tr2));
        assertEquals(tr2, historial.consultarTratamiento("tr1"));
    }

    @Test
    public void testEliminarTratamiento() {
        Tratamiento tratamiento = new Tratamiento("tr1", "Fisioterapia",null);
        historial.agregarTratamiento(tratamiento);
        assertTrue(historial.eliminarTratamiento(tratamiento));
        assertNull(historial.consultarTratamiento("tr1"));
    }

    @Test
    public void testAgregarYConsultarPrescripcion() {
        PrescripcionMedica prescripcion = new PrescripcionMedica("pr1", "Ibuprofeno");
        assertTrue(historial.agregarPrescripcion(prescripcion));
        assertEquals(prescripcion, historial.consultarPrescripcion("pr1"));
    }

    @Test
    public void testModificarPrescripcion() {
        PrescripcionMedica pr1 = new PrescripcionMedica("pr1", "Ibuprofeno");
        PrescripcionMedica pr2 = new PrescripcionMedica("pr1", "Paracetamol");
        historial.agregarPrescripcion(pr1);
        assertTrue(historial.modificarPrescripcion(pr2));
        assertEquals(pr2, historial.consultarPrescripcion("pr1"));
    }

    @Test
    public void testEliminarPrescripcion() {
        PrescripcionMedica prescripcion = new PrescripcionMedica("pr1", "Ibuprofeno");
        historial.agregarPrescripcion(prescripcion);
        assertTrue(historial.eliminarPrescripcion(prescripcion));
        assertNull(historial.consultarPrescripcion("pr1"));
    }
}

