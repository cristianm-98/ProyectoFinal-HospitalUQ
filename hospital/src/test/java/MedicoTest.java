import co.edu.uniquindio.poo.hospital.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoTest {

    private Medico medico;

    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("u2", "drana", "pass123");
        medico = new Medico("2", "Dra. Ana", 40, "987654", "Avenida 45", usuario, "LIC123", 15, Especialidad.CIRUGIA_GENERAL);
    }

    @Test
    public void testCrearMedico() {
        assertEquals("2", medico.getId());
        assertEquals("Dra. Ana", medico.getNombre());
        assertEquals(40, medico.getEdad());
        assertEquals("987654", medico.getTelefono());
        assertEquals("Avenida 45", medico.getDireccion());
        assertEquals("LIC123", medico.getLicencia());
        assertEquals(15, medico.getAnioExperiencia());
        assertNotNull(medico.getEspecialidad());
    }

    @Test
    public void testSetters() {
        medico.setLicencia("LIC999");
        assertEquals("LIC999", medico.getLicencia());

        medico.setAnioExperiencia(20);
        assertEquals(20, medico.getAnioExperiencia());
    }

    @Test
    public void testAgregarYConsultarNotificacion() {
        Notificacion notificacion = new Notificacion("n2", "Aviso importante");
        assertTrue(medico.agregarNotificacion(notificacion));
        assertEquals(notificacion, medico.consultarNotificacion("n2"));
    }

    @Test
    public void testModificarNotificacion() {
        Notificacion not1 = new Notificacion("n2", "Mensaje original");
        Notificacion not2 = new Notificacion("n2", "Mensaje modificado");
        medico.agregarNotificacion(not1);
        assertTrue(medico.modificarNotificacion(not2));
        assertEquals(not2, medico.consultarNotificacion("n2"));
    }

    @Test
    public void testEliminarNotificacion() {
        Notificacion notificacion = new Notificacion("n2", "Aviso importante");
        medico.agregarNotificacion(notificacion);
        assertTrue(medico.eliminarNotificacion(notificacion));
        assertNull(medico.consultarNotificacion("n2"));
    }

    @Test
    public void testAgregarYConsultarHistorial() {
        HistorialMedico historial = new HistorialMedico("h2", "Consulta inicial");
        assertTrue(medico.agregarHistorial(historial));
        assertEquals(historial, medico.consultarHistorial("h2"));
    }

    @Test
    public void testModificarHistorial() {
        HistorialMedico hist1 = new HistorialMedico("h2", "Consulta inicial");
        HistorialMedico hist2 = new HistorialMedico("h2", "Consulta modificada");
        medico.agregarHistorial(hist1);
        assertTrue(medico.modificarHistorial(hist2));
        assertEquals(hist2, medico.consultarHistorial("h2"));
    }

    @Test
    public void testEliminarHistorial() {
        HistorialMedico historial = new HistorialMedico("h2", "Consulta inicial");
        medico.agregarHistorial(historial);
        assertTrue(medico.eliminarHistorial(historial));
        assertNull(medico.consultarHistorial("h2"));
    }

    @Test
    public void testAgregarYConsultarHorario() {
        HorarioAtencion horario = new HorarioAtencion("ha1", "Lunes 9-12");
        assertTrue(medico.agregarHorarioAtencion(horario));
        assertEquals(horario, medico.consultarHorarioAtencion("ha1"));
    }

    @Test
    public void testModificarHorario() {
        HorarioAtencion ha1 = new HorarioAtencion("ha1", "Lunes 9-12");
        HorarioAtencion ha2 = new HorarioAtencion("ha1", "Lunes 10-13");
        medico.agregarHorarioAtencion(ha1);
        assertTrue(medico.modificarHorarioAtencion(ha2));
        assertEquals(ha2, medico.consultarHorarioAtencion("ha1"));
    }

    @Test
    public void testEliminarHorario() {
        HorarioAtencion horario = new HorarioAtencion("ha1", "Lunes 9-12");
        medico.agregarHorarioAtencion(horario);
        assertTrue(medico.eliminarHorarioAtencion(horario));
        assertNull(medico.consultarHorarioAtencion("ha1"));
    }

    @Test
    public void testAgregarYConsultarCita() {
        Cita cita = new Cita("c2", "Chequeo cardiológico");
        assertTrue(medico.agregarCita(cita));
        assertEquals(cita, medico.consultarCita("c2"));
    }

    @Test
    public void testModificarCita() {
        Cita cita1 = new Cita("c2", "Chequeo inicial");
        Cita cita2 = new Cita("c2", "Chequeo actualizado");
        medico.agregarCita(cita1);
        assertTrue(medico.modificarCita(cita2));
        assertEquals(cita2, medico.consultarCita("c2"));
    }

    @Test
    public void testEliminarCita() {
        Cita cita = new Cita("c2", "Chequeo cardiológico");
        medico.agregarCita(cita);
        assertTrue(medico.eliminarCita(cita));
        assertNull(medico.consultarCita("c2"));
    }
}

