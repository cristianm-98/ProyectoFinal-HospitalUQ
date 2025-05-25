import co.edu.uniquindio.poo.hospital.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("u1", "juanperez", "pass");
        paciente = new Paciente("1", "Juan Perez", 30, "123456", "Calle 123", usuario, "O+");
    }

    @Test
    public void testCrearPaciente() {
        assertEquals("1", paciente.getId());
        assertEquals("Juan Perez", paciente.getNombre());
        assertEquals(30, paciente.getEdad());
        assertEquals("123456", paciente.getTelefono());
        assertEquals("Calle 123", paciente.getDireccion());
        assertEquals("O+", paciente.getTipoSangre());
    }

    @Test
    public void testSetters() {
        paciente.setTipoSangre("A-");
        assertEquals("A-", paciente.getTipoSangre());

        LinkedList<Cita> citas = new LinkedList<>();
        paciente.setListaCitas(citas);
        assertEquals(citas, paciente.getListaCitas());

        LinkedList<Notificacion> notificaciones = new LinkedList<>();
        paciente.setListaNotificaciones(notificaciones);
        assertEquals(notificaciones, paciente.getListaNotificaciones());

        LinkedList<HistorialMedico> historiales = new LinkedList<>();
        paciente.setListahistorialMedico(historiales);
        assertEquals(historiales, paciente.getListahistorialMedico());
    }

    @Test
    public void testAgregarYConsultarCita() {
        Cita cita = new Cita("c1", "Consulta general");
        assertTrue(paciente.agregarCita(cita));
        assertEquals(cita, paciente.consultarCita("c1"));
    }

    @Test
    public void testModificarCita() {
        Cita cita1 = new Cita("c1", "Consulta general");
        Cita cita2 = new Cita("c1", "Consulta modificada");
        paciente.agregarCita(cita1);
        assertTrue(paciente.modificarCita(cita2));
        assertEquals(cita2, paciente.consultarCita("c1"));
    }

    @Test
    public void testEliminarCita() {
        Cita cita = new Cita("c1", "Consulta general");
        paciente.agregarCita(cita);
        assertTrue(paciente.eliminarCita(cita));
        assertNull(paciente.consultarCita("c1"));
    }

    @Test
    public void testAgregarYConsultarNotificacion() {
        Notificacion notificacion = new Notificacion("n1", "Recordatorio");
        assertTrue(paciente.agregarNotificacion(notificacion));
        assertEquals(notificacion, paciente.consultarNotificacion("n1"));
    }

    @Test
    public void testModificarNotificacion() {
        Notificacion not1 = new Notificacion("n1", "Mensaje original");
        Notificacion not2 = new Notificacion("n1", "Mensaje actualizado");
        paciente.agregarNotificacion(not1);
        assertTrue(paciente.modificarNotificacion(not2));
        assertEquals(not2, paciente.consultarNotificacion("n1"));
    }

    @Test
    public void testEliminarNotificacion() {
        Notificacion notificacion = new Notificacion("n1", "Recordatorio");
        paciente.agregarNotificacion(notificacion);
        assertTrue(paciente.eliminarNotificacion(notificacion));
        assertNull(paciente.consultarNotificacion("n1"));
    }

    @Test
    public void testAgregarYConsultarHistorial() {
        HistorialMedico historial = new HistorialMedico("h1", "Diagnóstico inicial");
        assertTrue(paciente.agregarHistorial(historial));
        assertEquals(historial, paciente.consultarHistorial("h1"));
    }

    @Test
    public void testModificarHistorial() {
        HistorialMedico hist1 = new HistorialMedico("h1", "Diagnóstico inicial");
        HistorialMedico hist2 = new HistorialMedico("h1", "Diagnóstico actualizado");
        paciente.agregarHistorial(hist1);
        assertTrue(paciente.modificarHistorial(hist2));
        assertEquals(hist2, paciente.consultarHistorial("h1"));
    }

    @Test
    public void testEliminarHistorial() {
        HistorialMedico historial = new HistorialMedico("h1", "Diagnóstico inicial");
        paciente.agregarHistorial(historial);
        assertTrue(paciente.eliminarHistorial(historial));
        assertNull(paciente.consultarHistorial("h1"));
    }
}
