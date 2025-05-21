package co.edu.uniquindio.poo.hospital.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuPacienteViewController {
    private App app;


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
        app.abrirCrudVistaDatosPersonales();
    }

    @FXML
    void onNotificaciones(ActionEvent event) {

    }

    @FXML
    void onSolicitarCita(ActionEvent event) {

    }

    @FXML
    void onVerCancelarCita(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {
        this.app = app;
    }
}
