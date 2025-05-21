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

public class DetalleHistorialViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<?, ?> columDescripcionExamen;

    @FXML
    private TableColumn<?, ?> columDescripcionTratamiento;

    @FXML
    private TableColumn<?, ?> columIdExamen;

    @FXML
    private TableColumn<?, ?> columIdPrescripcion;

    @FXML
    private TableColumn<?, ?> columIdTratamiento;

    @FXML
    private TableColumn<?, ?> columMedicamentos;

    @FXML
    private TableColumn<?, ?> columNombreExamen;

    @FXML
    private Label lbDiagnostico;

    @FXML
    private Label lbFechaHistorial;

    @FXML
    private Label lbIdHistorial;

    @FXML
    private TableView<?> tbExamenes;

    @FXML
    private TableView<?> tbPrescripcionMedicas;

    @FXML
    private TableView<?> tbTratamientos;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    void onCerrar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCerrar != null : "fx:id=\"btnCerrar\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columDescripcionExamen != null : "fx:id=\"columDescripcionExamen\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columDescripcionTratamiento != null : "fx:id=\"columDescripcionTratamiento\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columIdExamen != null : "fx:id=\"columIdExamen\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columIdPrescripcion != null : "fx:id=\"columIdPrescripcion\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columIdTratamiento != null : "fx:id=\"columIdTratamiento\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columMedicamentos != null : "fx:id=\"columMedicamentos\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert columNombreExamen != null : "fx:id=\"columNombreExamen\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert lbDiagnostico != null : "fx:id=\"lbDiagnostico\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert lbFechaHistorial != null : "fx:id=\"lbFechaHistorial\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert lbIdHistorial != null : "fx:id=\"lbIdHistorial\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert tbExamenes != null : "fx:id=\"tbExamenes\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert tbPrescripcionMedicas != null : "fx:id=\"tbPrescripcionMedicas\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert tbTratamientos != null : "fx:id=\"tbTratamientos\" was not injected: check your FXML file 'detalleHistorial.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'detalleHistorial.fxml'.";

    }

}
