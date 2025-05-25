package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicoHistoialViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarHistorial;

    @FXML
    private Button btnAgregarHistorial;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarHistorial;

    @FXML
    private Button btnVerDetalle;

    @FXML
    private TableColumn<?, ?> columDescripcion;

    @FXML
    private TableColumn<?, ?> columDiagnostico;

    @FXML
    private TableColumn<?, ?> columNombPaciente;

    @FXML
    private Label lblFecha;

    @FXML
    private TableView<?> tblHistorialMedico;

    @FXML
    private TextArea txtDescripMedica;

    @FXML
    private TextArea txtDiagMedico;

    @FXML
    private TextField txtNombPaciente;

    @FXML
    void onActualizarHistorial(ActionEvent event) {

    }

    @FXML
    void onAgregarHistorial(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onEliminarHistorial(ActionEvent event) {

    }

    @FXML
    void onVerDetalle(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizarHistorial != null : "fx:id=\"btnActualizarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnAgregarHistorial != null : "fx:id=\"btnAgregarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnEliminarHistorial != null : "fx:id=\"btnEliminarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnVerDetalle != null : "fx:id=\"btnVerDetalle\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columDescripcion != null : "fx:id=\"columDescripcion\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columDiagnostico != null : "fx:id=\"columDiagnostico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columNombPaciente != null : "fx:id=\"columNombPaciente\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert lblFecha != null : "fx:id=\"lblFecha\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert tblHistorialMedico != null : "fx:id=\"tblHistorialMedico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert txtDescripMedica != null : "fx:id=\"txtDescripMedica\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert txtDiagMedico != null : "fx:id=\"txtDiagMedico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert txtNombPaciente != null : "fx:id=\"txtNombPaciente\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";

    }

}
