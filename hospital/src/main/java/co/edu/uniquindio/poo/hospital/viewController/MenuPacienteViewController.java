package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPacienteViewController {
    private App app;
    private Paciente paciente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrarSeccion;

    @FXML
    private Button btnDatosPersonales;

    @FXML
    private Button btnNotificaciones;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private Button btnVerCancelarCita;

    @FXML
    void onCerrarSeccion(ActionEvent event) {
        app.abrirVistaLogin();
    }

    @FXML
    void onDatosPersonales(ActionEvent event) {
        app.abrirVistaDatosPersonalesPaciente(this.paciente);
    }

    @FXML
    void onNotificaciones(ActionEvent event) {
        app.abrirVistaNotificacionPaciente(this.paciente);
    }

    @FXML
    void onSolicitarCita(ActionEvent event) {
        app.abrirVistaSolicitarCitaPaciente(this.paciente);
    }

    @FXML
    void onVerCancelarCita(ActionEvent event) {
        app.abrirVistaCancelarCitaPaciente(this.paciente);
    }

    @FXML
    void onVerHistorialMedico(ActionEvent event) {
        app.abrirVistaHistorialPaciente(this.paciente);
    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
