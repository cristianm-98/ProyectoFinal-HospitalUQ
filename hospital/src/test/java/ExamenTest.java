import co.edu.uniquindio.poo.hospital.model.Examen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExamenTest {

    private Examen examen;

    @BeforeEach
    public void setUp() {
        examen = new Examen("ex1", "Hemograma", "Análisis completo de sangre", null);
    }

    @Test
    public void testCrearExamen() {
        assertEquals("ex1", examen.getId());
        assertEquals("Hemograma", examen.getNombreExamen());
        assertEquals("Análisis completo de sangre", examen.getDescripcion());
    }

    @Test
    public void testSetters() {
        examen.setId("ex2");
        examen.setNombreExamen("Uroanálisis");
        examen.setDescripcion("Análisis de orina");

        assertEquals("ex2", examen.getId());
        assertEquals("Uroanálisis", examen.getNombreExamen());
        assertEquals("Análisis de orina", examen.getDescripcion());
    }
}
