import co.edu.uniquindio.poo.hospital.model.Administrador;
import co.edu.uniquindio.poo.hospital.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    private Administrador administrador;

    @BeforeEach
    public void setUp() {
        Usuario usuario = new Usuario("u3", "adminCarlos", "adminpass");
        administrador = new Administrador("3", "Carlos López", 35, "555123", "Oficina 101", usuario, "Jefe", "Recursos Humanos");
    }

    @Test
    public void testCrearAdministrador() {
        assertEquals("3", administrador.getId());
        assertEquals("Carlos López", administrador.getNombre());
        assertEquals(35, administrador.getEdad());
        assertEquals("555123", administrador.getTelefono());
        assertEquals("Oficina 101", administrador.getDireccion());
        assertEquals("Jefe", administrador.getCargo());
        assertEquals("Recursos Humanos", administrador.getAreaResponsable());
    }

    @Test
    public void testSetters() {
        administrador.setCargo("Coordinador");
        administrador.setAreaResponsable("Tecnología");

        assertEquals("Coordinador", administrador.getCargo());
        assertEquals("Tecnología", administrador.getAreaResponsable());
    }

    @Test
    public void testPersonaHeredada() {
        administrador.setNombre("Luis Martínez");
        administrador.setEdad(40);
        administrador.setTelefono("555456");
        administrador.setDireccion("Oficina 202");

        assertEquals("Luis Martínez", administrador.getNombre());
        assertEquals(40, administrador.getEdad());
        assertEquals("555456", administrador.getTelefono());
        assertEquals("Oficina 202", administrador.getDireccion());
    }
}
