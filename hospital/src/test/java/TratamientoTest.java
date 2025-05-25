import co.edu.uniquindio.poo.hospital.model.Tratamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TratamientoTest {

    private Tratamiento tratamiento;

    @BeforeEach
    public void setUp() {
        tratamiento = new Tratamiento("tr1", "Fisioterapia lumbar");
    }

    @Test
    public void testCrearTratamiento() {
        assertEquals("tr1", tratamiento.getId());
        assertEquals("Fisioterapia lumbar", tratamiento.getDescripcion());
    }

    @Test
    public void testSetters() {
        tratamiento.setId("tr2");
        tratamiento.setDescripcion("Rehabilitación postoperatoria");

        assertEquals("tr2", tratamiento.getId());
        assertEquals("Rehabilitación postoperatoria", tratamiento.getDescripcion());
    }
}
