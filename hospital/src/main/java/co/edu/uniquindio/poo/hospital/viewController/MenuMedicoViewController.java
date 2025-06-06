package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuMedicoViewController {
    private App app;
    private Medico medico;

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
        app.abrirVistaLogin(false);
    }

    @FXML
    void onGestionarHorario(ActionEvent event) {
        app.abrirGestionHorarioMedico(this.medico);
    }

    @FXML
    void onHistorialMedico(ActionEvent event) {
        app.abrirHistorialMedico(this.medico);
    }

    @FXML
    void onNotificarCambioCita(ActionEvent event) {
        app.abrirVistaNotificacionMedico(this.medico);
    }

    @FXML
    void initialize() {
    }

    public void setApp(App app) {
        this.app=app;
    }
    public void setMedico(Medico medico){
        this.medico=medico;
    }
}
