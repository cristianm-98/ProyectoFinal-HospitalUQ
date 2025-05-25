package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SolicitarCitaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private TableColumn<?, ?> columDia;

    @FXML
    private TableColumn<?, ?> columEspecialidad;

    @FXML
    private TableColumn<?, ?> columFechaFinal;

    @FXML
    private TableColumn<?, ?> columFechaInicio;

    @FXML
    private TableColumn<?, ?> columHoraAtencion;

    @FXML
    private TableColumn<?, ?> columNombreMedico;

    @FXML
    private TableView<?> tblCita;

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onSolicitarCita(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert btnSolicitarCita != null : "fx:id=\"btnSolicitarCita\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columDia != null : "fx:id=\"columDia\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columEspecialidad != null : "fx:id=\"columEspecialidad\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columFechaFinal != null : "fx:id=\"columFechaFinal\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columFechaInicio != null : "fx:id=\"columFechaInicio\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columHoraAtencion != null : "fx:id=\"columHoraAtencion\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columNombreMedico != null : "fx:id=\"columNombreMedico\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert tblCita != null : "fx:id=\"tblCita\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";

    }

}
