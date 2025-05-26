package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaPacienteViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnSeleccionarPacient;

    @FXML
    private TableColumn<?, ?> columIdentificacion;

    @FXML
    private TableColumn<?, ?> columNombre;

    @FXML
    private TableView<?> tblPaciente;

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onSeleccionarPacient(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert btnSeleccionarPacient != null : "fx:id=\"btnSeleccionarPacient\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert columIdentificacion != null : "fx:id=\"columIdentificacion\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert columNombre != null : "fx:id=\"columNombre\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert tblPaciente != null : "fx:id=\"tblPaciente\" was not injected: check your FXML file 'listaPaciente.fxml'.";

    }

}
