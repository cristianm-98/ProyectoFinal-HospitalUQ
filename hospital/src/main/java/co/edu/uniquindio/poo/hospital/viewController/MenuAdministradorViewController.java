package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuAdministradorViewController {
    private App app;
    private Administrador administrador;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAsignarPaciente;

    @FXML
    private Button btnGestionarMedico;

    @FXML
    private Button btnGestionarPaciente;

    @FXML
    private Button btnGestionarSalaHorarios;

    @FXML
    private Button btnReporte;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    void onAsignarPaciente(ActionEvent event) {

    }

    @FXML
    void onGestionarMedico(ActionEvent event) {
        app.abrirVistaGestionMedico(this.administrador);


    }

    @FXML
    void onGestionarPaciente(ActionEvent event) {
        app.abrirVistaGestionPaciente(this.administrador);

    }

    @FXML
    void onGestionarSalaHorarios(ActionEvent event) {

    }

    @FXML
    void onReporte(ActionEvent event) {
        app.abrirVistaDetalleReporte(this.administrador);

    }
    @FXML
    void onCerrarSesion(ActionEvent event) {
        app.abrirVistaLogin(false);
    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {
        this.app=app;
    }
    public void setAdministrador(Administrador administrador){
        this.administrador=administrador;
    }
}
