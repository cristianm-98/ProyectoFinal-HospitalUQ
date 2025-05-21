package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SolicitarCitaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSolicitar;

    @FXML
    private ComboBox<?> cmboxDia;

    @FXML
    private ComboBox<?> cmboxEstado;

    @FXML
    private DatePicker dateFinal;

    @FXML
    private DatePicker dateInicio;

    @FXML
    private TextField txtId;

    @FXML
    void onSolicitar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnSolicitar != null : "fx:id=\"btnSolicitar\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert cmboxDia != null : "fx:id=\"cmboxDia\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert cmboxEstado != null : "fx:id=\"cmboxEstado\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert dateFinal != null : "fx:id=\"dateFinal\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert dateInicio != null : "fx:id=\"dateInicio\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";

    }

}
