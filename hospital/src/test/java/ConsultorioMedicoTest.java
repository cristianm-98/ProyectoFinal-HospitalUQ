import co.edu.uniquindio.poo.hospital.model.Cita;
import co.edu.uniquindio.poo.hospital.model.ConsultorioMedico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultorioMedicoTest {

    private ConsultorioMedico consultorio;

    @BeforeEach
    public void setUp() {
        consultorio = new ConsultorioMedico("c1", "Consultorio A", true, (byte) 1);
    }

    @Test
    public void testCrearConsultorio() {
        assertEquals("c1", consultorio.getId());
        assertEquals("Consultorio A", consultorio.getNombre());
        assertTrue(consultorio.isDisponible());
        assertEquals(1, consultorio.getNumeroSala());
    }

    @Test
    public void testSetters() {
        consultorio.setId("c2");
        consultorio.setNombre("Consultorio B");
        consultorio.setDisponible(false);
        consultorio.setNumeroSala((byte) 2);

        assertEquals("c2", consultorio.getId());
        assertEquals("Consultorio B", consultorio.getNombre());
        assertFalse(consultorio.isDisponible());
        assertEquals(2, consultorio.getNumeroSala());
    }

    @Test
    public void testAgregarYConsultarCita() {
        Cita cita = new Cita("ct1", "Consulta pediátrica");
        assertTrue(consultorio.agregarCita(cita));
        assertEquals(cita, consultorio.consultarCita("ct1"));
    }

    @Test
    public void testModificarCita() {
        Cita cita1 = new Cita("ct1", "Consulta pediátrica");
        Cita cita2 = new Cita("ct1", "Consulta pediátrica actualizada");
        consultorio.agregarCita(cita1);
        assertTrue(consultorio.modificarCita(cita2));
        assertEquals(cita2, consultorio.consultarCita("ct1"));
    }

    @Test
    public void testEliminarCita() {
        Cita cita = new Cita("ct1", "Consulta pediátrica");
        consultorio.agregarCita(cita);
        assertTrue(consultorio.eliminarCita(cita));
        assertNull(consultorio.consultarCita("ct1"));
    }

    @Test
    public void testSetListaCitas() {
        LinkedList<Cita> citas = new LinkedList<>();
        Cita cita = new Cita("ct2", "Consulta general");
        citas.add(cita);
        consultorio.setListaCitas(citas);
        assertEquals(citas, consultorio.getListaCitas());
    }
}

