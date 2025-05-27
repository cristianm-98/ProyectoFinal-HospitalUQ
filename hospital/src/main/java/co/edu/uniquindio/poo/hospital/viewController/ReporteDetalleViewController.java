package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Administrador;
import co.edu.uniquindio.poo.hospital.model.Hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ReporteDetalleViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnReporteCita;

    @FXML
    private Button btnReporteMedico;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaAdministrador(this.administrador);

    }

    @FXML
    void onReporteCita(ActionEvent event) {
        app.abrirReporteCita(this.administrador);

    }

    @FXML
    void onReporteMedico(ActionEvent event) {
        app.abrirReporteMedico(this.administrador);

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'reporteDetalle.fxml'.";
        assert btnReporteCita != null : "fx:id=\"btnReporteCita\" was not injected: check your FXML file 'reporteDetalle.fxml'.";
        assert btnReporteMedico != null : "fx:id=\"btnReporteMedico\" was not injected: check your FXML file 'reporteDetalle.fxml'.";

    }

    public void initAdministrador(Administrador administrador) {
        this.administrador=administrador;
    }

    public void setApp(App app) {
        this.app=app;
    }
}
