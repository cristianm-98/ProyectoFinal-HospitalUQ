import co.edu.uniquindio.poo.hospital.model.Persona;
import co.edu.uniquindio.poo.hospital.model.PersonaDummy;
import co.edu.uniquindio.poo.hospital.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    private Persona persona;

    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("u4", "personaTest", "pass123");
        persona = new PersonaDummy("p1", "Juan Prueba", 28, "321456", "Calle Falsa 123", usuario);
    }

    @Test
    public void testCrearPersona() {
        assertEquals("p1", persona.getId());
        assertEquals("Juan Prueba", persona.getNombre());
        assertEquals(28, persona.getEdad());
        assertEquals("321456", persona.getTelefono());
        assertEquals("Calle Falsa 123", persona.getDireccion());
        assertEquals(persona, persona.getTheUsuario());
    }

    @Test
    public void testSetters() {
        Usuario nuevoUsuario = new Usuario("u5", "personaNueva", "newpass");

        persona.setId("p2");
        persona.setNombre("Maria Nueva");
        persona.setEdad(35);
        persona.setTelefono("987654");
        persona.setDireccion("Avenida Siempre Viva 742");
        persona.setTheUsuario(nuevoUsuario);

        assertEquals("p2", persona.getId());
        assertEquals("Maria Nueva", persona.getNombre());
        assertEquals(35, persona.getEdad());
        assertEquals("987654", persona.getTelefono());
        assertEquals("Avenida Siempre Viva 742", persona.getDireccion());
        assertEquals(nuevoUsuario, persona.getTheUsuario());
    }
}


