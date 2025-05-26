package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class DiagnosticoDescripcion {

    private App app;
    private Medico medico;
    private Paciente paciente;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextArea txtDiagnostico;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirAgregarPacienteMedico(medico);
    }

    @FXML
    void onGuardar(ActionEvent event) {
        if (txtDescripcion.getText().isEmpty() || txtDiagnostico.getText().isEmpty()){
            mostrarMensaje("Advertencia","Campos vacios","Debe completar todos los campos");
        }
        else{
            String id = UUID.randomUUID().toString().replace("-", "");
            HistorialMedico historialMedico = new HistorialMedico(id, LocalDate.now(),txtDiagnostico.getText(),txtDescripcion.getText(),paciente,medico);
            paciente.agregarHistorial(historialMedico);
            medico.agregarHistorial(historialMedico);
            mostrarMensaje("Confirmacion","Diagnostico guardado","Su diagnostico ha sido guardado exitosamente");
            app.abrirDetalleHistorialMedico(historialMedico,medico);
        }
    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'diagnosticoDescripcion.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'diagnosticoDescripcion.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'diagnosticoDescripcion.fxml'.";
        assert txtDiagnostico != null : "fx:id=\"txtDiagnostico\" was not injected: check your FXML file 'diagnosticoDescripcion.fxml'.";

    }

    public void setApp(App app) {this.app = app;}
    public void setMedico(Medico medico){this.medico=medico;}
    public void setPaciente(Paciente paciente){this.paciente=paciente;}
    public void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
