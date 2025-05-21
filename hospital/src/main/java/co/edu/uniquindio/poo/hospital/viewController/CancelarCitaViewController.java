package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CancelarCitaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<?, ?> columDia;

    @FXML
    private TableColumn<?, ?> columEstado;

    @FXML
    private TableColumn<?, ?> columHoraFinal;

    @FXML
    private TableColumn<?, ?> columHoraInicio;

    @FXML
    private TableColumn<?, ?> columId;

    @FXML
    private TableView<?> tblCitas;

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onCancelarCita(ActionEvent event) {

    }

    @FXML
    void onLimpiar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert btnCancelarCita != null : "fx:id=\"btnCancelarCita\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert columDia != null : "fx:id=\"columDia\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert columEstado != null : "fx:id=\"columEstado\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert columHoraFinal != null : "fx:id=\"columHoraFinal\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert columHoraInicio != null : "fx:id=\"columHoraInicio\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert columId != null : "fx:id=\"columId\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";
        assert tblCitas != null : "fx:id=\"tblCitas\" was not injected: check your FXML file 'crudCancelarCita.fxml'.";

    }

}
