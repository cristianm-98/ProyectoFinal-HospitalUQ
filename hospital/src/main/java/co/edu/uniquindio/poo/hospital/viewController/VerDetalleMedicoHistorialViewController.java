package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VerDetalleMedicoHistorialViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDetalleExamen;

    @FXML
    private Button btnDetallePrescripcion;

    @FXML
    private Button btnDetalleTratamiento;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> columDescripTratamiento;

    @FXML
    private TableColumn<?, ?> columDescripcion;

    @FXML
    private TableColumn<?, ?> columMedicamento;

    @FXML
    private TableColumn<?, ?> columNombExamen;

    @FXML
    private TableView<?> tblExamen;

    @FXML
    private TableView<?> tblMedicamento;

    @FXML
    private TableView<?> tblTratamiento;

    @FXML
    void onDetalleExamen(ActionEvent event) {

    }

    @FXML
    void onDetallePrescripcion(ActionEvent event) {

    }

    @FXML
    void onDetalleTratamiento(ActionEvent event) {

    }

    @FXML
    void onVolver(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDetalleExamen != null : "fx:id=\"btnDetalleExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnDetallePrescripcion != null : "fx:id=\"btnDetallePrescripcion\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnDetalleTratamiento != null : "fx:id=\"btnDetalleTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columDescripTratamiento != null : "fx:id=\"columDescripTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columDescripcion != null : "fx:id=\"columDescripcion\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columMedicamento != null : "fx:id=\"columMedicamento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columNombExamen != null : "fx:id=\"columNombExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblExamen != null : "fx:id=\"tblExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblMedicamento != null : "fx:id=\"tblMedicamento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblTratamiento != null : "fx:id=\"tblTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";

    }

}
