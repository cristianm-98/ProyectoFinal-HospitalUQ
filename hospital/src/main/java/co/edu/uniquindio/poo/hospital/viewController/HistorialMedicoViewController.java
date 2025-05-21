package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistorialMedicoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnVerDetalle;

    @FXML
    private TableColumn<?, ?> columDescripcion;

    @FXML
    private TableColumn<?, ?> columDiagnostico;

    @FXML
    private TableColumn<?, ?> columFecha;

    @FXML
    private TableColumn<?, ?> columId;

    @FXML
    private TableView<?> tbHistoriales;

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onVerDetalle(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert btnVerDetalle != null : "fx:id=\"btnVerDetalle\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert columDescripcion != null : "fx:id=\"columDescripcion\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert columDiagnostico != null : "fx:id=\"columDiagnostico\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert columFecha != null : "fx:id=\"columFecha\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert columId != null : "fx:id=\"columId\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";
        assert tbHistoriales != null : "fx:id=\"tbHistoriales\" was not injected: check your FXML file 'crudHistorialMedico.fxml'.";

    }

}
