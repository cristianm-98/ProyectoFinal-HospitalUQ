package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class DetalleTratamientoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarTratamiento;

    @FXML
    private Button btnAgregarTratamiento;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarTrtamiento;

    @FXML
    private TableColumn<?, ?> columDescripcionTratam;

    @FXML
    private TableView<?> tblDescripcion;

    @FXML
    private TextArea txtDescripcionTratamiento;

    @FXML
    void onActualizarTratamiento(ActionEvent event) {

    }

    @FXML
    void onAgregarTratamiento(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onEliminarTratamiento(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizarTratamiento != null : "fx:id=\"btnActualizarTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnAgregarTratamiento != null : "fx:id=\"btnAgregarTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnEliminarTrtamiento != null : "fx:id=\"btnEliminarTrtamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert columDescripcionTratam != null : "fx:id=\"columDescripcionTratam\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert tblDescripcion != null : "fx:id=\"tblDescripcion\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert txtDescripcionTratamiento != null : "fx:id=\"txtDescripcionTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";

    }

}
