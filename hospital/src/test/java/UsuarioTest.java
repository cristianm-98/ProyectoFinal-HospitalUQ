import co.edu.uniquindio.poo.hospital.model.Persona;
import co.edu.uniquindio.poo.hospital.model.PersonaDummy;
import co.edu.uniquindio.poo.hospital.model.TipoUsuario;
import co.edu.uniquindio.poo.hospital.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private Persona personaDummy;

    @BeforeEach
    public void setUp() {
        personaDummy = new PersonaDummy("p1", "Juan Prueba", 28, "12345", "Calle 123", null);
        usuario = new Usuario("juanp", "pass123", personaDummy, TipoUsuario.PACIENTE);
    }

    @Test
    public void testCrearUsuario() {
        assertEquals("juanp", usuario.getUsuario());
        assertEquals("pass123", usuario.getContrasena());
        assertEquals(personaDummy, usuario.getThePersona());
        assertEquals(TipoUsuario.PACIENTE, usuario.getTipoUsuario());
    }

    @Test
    public void testSetters() {
        Persona nuevaPersona = new PersonaDummy("p2", "Maria Nueva", 35, "98765", "Avenida 45", null);

        usuario.setUsuario("mariau");
        usuario.setContraseña("newpass456");
        usuario.setThePersona(nuevaPersona);
        usuario.setTipoUsuario(TipoUsuario.MEDICO);

        assertEquals("mariau", usuario.getUsuario());
        assertEquals("newpass456", usuario.getContrasena());
        assertEquals(nuevaPersona, usuario.getThePersona());
        assertEquals(TipoUsuario.MEDICO, usuario.getTipoUsuario());
    }
}
