import co.edu.uniquindio.poo.hospital.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    private Hospital hospital;

    @BeforeEach
    public void setUp() {
        hospital = new Hospital("12345", "Hospital UQ");
    }

    @Test
    public void testCrearHospital() {
        assertEquals("12345", hospital.getNit());
        assertEquals("Hospital UQ", hospital.getNombre());
        assertNotNull(hospital.getListaPacientes());
        assertNotNull(hospital.getListaMedicos());
        assertNotNull(hospital.getListaAdministradores());
        assertNotNull(hospital.getListaConsultorioMedicos());
    }

    @Test
    public void testSettersYGetters() {
        hospital.setNit("54321");
        hospital.setNombre("Nuevo Hospital");
        assertEquals("54321", hospital.getNit());
        assertEquals("Nuevo Hospital", hospital.getNombre());

        LinkedList<Paciente> pacientes = new LinkedList<>();
        hospital.setListaPacientes(pacientes);
        assertEquals(pacientes, hospital.getListaPacientes());
    }

    @Test
    public void testAgregarYConsultarPaciente() {
        Paciente paciente = new Paciente("1", "Juan");
        assertTrue(hospital.agregarPaciente(paciente));
        assertEquals(paciente, hospital.consultarPaciente("1"));
    }

    @Test
    public void testEliminarPaciente() {
        Paciente paciente = new Paciente("1", "Juan");
        hospital.agregarPaciente(paciente);
        assertTrue(hospital.eliminarPaciente(paciente));
        assertNull(hospital.consultarPaciente("1"));
    }

    @Test
    public void testModificarPaciente() {
        Paciente paciente1 = new Paciente("1", "Juan");
        Paciente paciente2 = new Paciente("1", "Pedro");
        hospital.agregarPaciente(paciente1);
        assertTrue(hospital.modificarPaciente(paciente2));
        assertEquals(paciente2, hospital.consultarPaciente("1"));
    }

    @Test
    public void testAgregarYConsultarMedico() {
        Medico medico = new Medico("2", "Dra. Ana");
        assertTrue(hospital.agregarMedico(medico));
        assertEquals(medico, hospital.consultarMedico("2"));
    }

    @Test
    public void testEliminarMedico() {
        Medico medico = new Medico("2", "Dra. Ana");
        hospital.agregarMedico(medico);
        assertTrue(hospital.eliminarMedico(medico));
        assertNull(hospital.consultarMedico("2"));
    }

    @Test
    public void testModificarMedico() {
        Medico medico1 = new Medico("2", "Dra. Ana");
        Medico medico2 = new Medico("2", "Dra. Carla");
        hospital.agregarMedico(medico1);
        assertTrue(hospital.modificarMedico(medico2));
        assertEquals(medico2, hospital.consultarMedico("2"));
    }

    @Test
    public void testAgregarYConsultarAdministrador() {
        Administrador admin = new Administrador("3", "Carlos");
        assertTrue(hospital.agregarAdministrador(admin));
        assertEquals(admin, hospital.consultarAdministrador("3"));
    }

    @Test
    public void testEliminarAdministrador() {
        Administrador admin = new Administrador("3", "Carlos");
        hospital.agregarAdministrador(admin);
        assertTrue(hospital.eliminarAdministrador(admin));
        assertNull(hospital.consultarAdministrador("3"));
    }

    @Test
    public void testModificarAdministrador() {
        Administrador admin1 = new Administrador("3", "Carlos");
        Administrador admin2 = new Administrador("3", "Luis");
        hospital.agregarAdministrador(admin1);
        assertTrue(hospital.modificarAdministrador(admin2));
        assertEquals(admin2, hospital.consultarAdministrador("3"));
    }

    @Test
    public void testAgregarYConsultarConsultorio() {
        ConsultorioMedico consultorio = new ConsultorioMedico("4");
        assertTrue(hospital.agregarConsultorio(consultorio));
        assertEquals(consultorio, hospital.consultarConsultorio("4"));
    }

    @Test
    public void testEliminarConsultorio() {
        ConsultorioMedico consultorio = new ConsultorioMedico("4");
        hospital.agregarConsultorio(consultorio);
        assertTrue(hospital.eliminarConsultorio(consultorio));
        assertNull(hospital.consultarConsultorio("4"));
    }

    @Test
    public void testModificarConsultorio() {
        ConsultorioMedico consultorio1 = new ConsultorioMedico("4");
        ConsultorioMedico consultorio2 = new ConsultorioMedico("4");
        hospital.agregarConsultorio(consultorio1);
        assertTrue(hospital.modificarConsultorio(consultorio2));
        assertEquals(consultorio2, hospital.consultarConsultorio("4"));
    }
}
