import co.edu.uniquindio.poo.hospital.model.Notificacion;
import co.edu.uniquindio.poo.hospital.model.Persona;
import co.edu.uniquindio.poo.hospital.model.PersonaDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class NotificacionTest {

    private Notificacion notificacion;
    private Persona destinatario;

    @BeforeEach
    public void setUp() {
        destinatario = new PersonaDummy("p1", "Juan Prueba", 28, "12345", "Calle 123", null);
        notificacion = new Notificacion("n1", LocalTime.of(10, 30), "Consulta confirmada", false, destinatario);
    }

    @Test
    public void testCrearNotificacion() {
        assertEquals("n1", notificacion.getId());
        assertEquals(LocalTime.of(10, 30), notificacion.getFechaEnvio());
        assertEquals("Consulta confirmada", notificacion.getMensaje());
        assertFalse(notificacion.isLeido());
        assertEquals(destinatario, notificacion.getDestinatario());
    }

    @Test
    public void testSetters() {
        Persona nuevoDestinatario = new PersonaDummy("p2", "Maria Nueva", 35, "98765", "Avenida 45", null);

        notificacion.setId("n2");
        notificacion.setFechaEnvio(LocalTime.of(15, 0));
        notificacion.setMensaje("Cita cancelada");
        notificacion.setLeido(true);
        notificacion.setDestinatario(nuevoDestinatario);

        assertEquals("n2", notificacion.getId());
        assertEquals(LocalTime.of(15, 0), notificacion.getFechaEnvio());
        assertEquals("Cita cancelada", notificacion.getMensaje());
        assertTrue(notificacion.isLeido());
        assertEquals(nuevoDestinatario, notificacion.getDestinatario());
    }
}

