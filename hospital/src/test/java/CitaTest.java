import co.edu.uniquindio.poo.hospital.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class CitaTest {

    private Cita cita;
    private ConsultorioMedico consultorio;
    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    public void setUp() {
        consultorio = new ConsultorioMedico("cm1", "Consultorio A", true, (byte) 1);
        paciente = new Paciente("p1", "Juan", 30, "123456", "Calle 1", null, "O+");
        medico = new Medico("m1", "Dra. Ana", 40, "654321", "Avenida 2", null, "LIC001", 15, Especialidad.CIRUGIA_GENERAL);

        cita = new Cita("c1", LocalDate.of(2024, 5, 25),
                LocalTime.of(9, 0),
                LocalTime.of(10, 0),
                true,
                consultorio,
                paciente,
                medico);
    }

    @Test
    public void testCrearCita() {
        assertEquals("c1", cita.getId());
        assertEquals(LocalDate.of(2024, 5, 25), cita.getDia());
        assertEquals(LocalTime.of(9, 0), cita.getHoraInicio());
        assertEquals(LocalTime.of(10, 0), cita.getHoraFinal());
        assertTrue(cita.isEstado());
        assertEquals(consultorio, cita.getTheConsultorioMedico());
        assertEquals(paciente, cita.getThepaciente());
        assertEquals(medico, cita.getThemedico());
    }

    @Test
    public void testSetters() {
        cita.setId("c2");
        cita.setDia(LocalDate.of(2024, 6, 1));
        cita.setHoraInicio(LocalTime.of(14, 0));
        cita.setHoraFinal(LocalTime.of(15, 0));
        cita.setEstado(false);

        ConsultorioMedico nuevoConsultorio = new ConsultorioMedico("cm2", "Consultorio B", false, (byte) 2);
        Paciente nuevoPaciente = new Paciente("p2", "Maria", 28, "987654", "Calle 2", null, "A-");
        Medico nuevoMedico = new Medico("m2", "Dr. Luis", 45, "789123", "Avenida 3", null, "LIC002", 20, Especialidad.CIRUGIA_GENERAL);

        cita.setTheConsultorioMedico(nuevoConsultorio);
        cita.setThepaciente(nuevoPaciente);
        cita.setThemedico(nuevoMedico);

        assertEquals("c2", cita.getId());
        assertEquals(LocalDate.of(2024, 6, 1), cita.getDia());
        assertEquals(LocalTime.of(14, 0), cita.getHoraInicio());
        assertEquals(LocalTime.of(15, 0), cita.getHoraFinal());
        assertFalse(cita.isEstado());
        assertEquals(nuevoConsultorio, cita.getTheConsultorioMedico());
        assertEquals(nuevoPaciente, cita.getThepaciente());
        assertEquals(nuevoMedico, cita.getThemedico());
    }
}
