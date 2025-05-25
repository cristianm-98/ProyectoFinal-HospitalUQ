import co.edu.uniquindio.poo.hospital.model.HorarioAtencion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class HorarioAtencionTest {

    private HorarioAtencion horario;

    @BeforeEach
    public void setUp() {
        horario = new HorarioAtencion("ha1", "Lunes", LocalTime.of(9, 0), LocalTime.of(12, 0));
    }

    @Test
    public void testCrearHorarioAtencion() {
        assertEquals("ha1", horario.getId());
        assertEquals("Lunes", horario.getDia());
        assertEquals(LocalTime.of(9, 0), horario.getHoraInicio());
        assertEquals(LocalTime.of(12, 0), horario.getHoraFinal());
    }

    @Test
    public void testSetters() {
        horario.setId("ha2");
        horario.setDia("Martes");
        horario.setHoraInicio(LocalTime.of(14, 0));
        horario.setHoraFinal(LocalTime.of(18, 0));

        assertEquals("ha2", horario.getId());
        assertEquals("Martes", horario.getDia());
        assertEquals(LocalTime.of(14, 0), horario.getHoraInicio());
        assertEquals(LocalTime.of(18, 0), horario.getHoraFinal());
    }
}
