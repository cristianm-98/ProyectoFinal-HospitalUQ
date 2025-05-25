package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuMedicoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnGestionarHorario;

    @FXML
    private Button btnHistorialMedico;

    @FXML
    private Button btrnNotificarCambioCita;

    @FXML
    void onCerrarSesion(ActionEvent event) {

    }

    @FXML
    void onGestionarHorario(ActionEvent event) {

    }

    @FXML
    void onHistorialMedico(ActionEvent event) {

    }

    @FXML
    void onNotificarCambioCita(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCerrarSesion != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'menuMedico.fxml'.";
        assert btnGestionarHorario != null : "fx:id=\"btnGestionarHorario\" was not injected: check your FXML file 'menuMedico.fxml'.";
        assert btnHistorialMedico != null : "fx:id=\"btnHistorialMedico\" was not injected: check your FXML file 'menuMedico.fxml'.";
        assert btrnNotificarCambioCita != null : "fx:id=\"btrnNotificarCambioCita\" was not injected: check your FXML file 'menuMedico.fxml'.";

    }

    public void setApp(App app) {

    }
}
