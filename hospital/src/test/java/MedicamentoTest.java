import co.edu.uniquindio.poo.hospital.model.Medicamento;
import co.edu.uniquindio.poo.hospital.model.PrescripcionMedica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoTest {

    private Medicamento medicamento;

    @BeforeEach
    public void setUp() {
        medicamento = new Medicamento("med1", "Ibuprofeno", "Analgésico antiinflamatorio");
    }

    @Test
    public void testCrearMedicamento() {
        assertEquals("med1", medicamento.getId());
        assertEquals("Ibuprofeno", medicamento.getNombreMedicamento());
        assertEquals("Analgésico antiinflamatorio", medicamento.getDescripcion());
        assertNotNull(medicamento.getListaPrescripcionMedicas());
    }

    @Test
    public void testSetters() {
        medicamento.setId("med2");
        medicamento.setNombreMedicamento("Paracetamol");
        medicamento.setDescripcion("Analgésico antipirético");

        assertEquals("med2", medicamento.getId());
        assertEquals("Paracetamol", medicamento.getNombreMedicamento());
        assertEquals("Analgésico antipirético", medicamento.getDescripcion());

        LinkedList<PrescripcionMedica> lista = new LinkedList<>();
        medicamento.setListaPrescripcionMedicas(lista);
        assertEquals(lista, medicamento.getListaPrescripcionMedicas());
    }

    @Test
    public void testAgregarYConsultarPrescripcion() {
        PrescripcionMedica prescripcion = new PrescripcionMedica("pr1", "500 mg cada 8 horas");
        assertTrue(medicamento.agregarPrescripcion(prescripcion));
        assertEquals(prescripcion, medicamento.consultarPrescripcion("pr1"));
    }

    @Test
    public void testModificarPrescripcion() {
        PrescripcionMedica pr1 = new PrescripcionMedica("pr1", "500 mg cada 8 horas");
        PrescripcionMedica pr2 = new PrescripcionMedica("pr1", "250 mg cada 6 horas");
        medicamento.agregarPrescripcion(pr1);
        assertTrue(medicamento.modificarPrescripcion(pr2));
        assertEquals(pr2, medicamento.consultarPrescripcion("pr1"));
    }

    @Test
    public void testEliminarPrescripcion() {
        PrescripcionMedica prescripcion = new PrescripcionMedica("pr1", "500 mg cada 8 horas");
        medicamento.agregarPrescripcion(prescripcion);
        assertTrue(medicamento.eliminarPrescripcion(prescripcion));
        assertNull(medicamento.consultarPrescripcion("pr1"));
    }
}

