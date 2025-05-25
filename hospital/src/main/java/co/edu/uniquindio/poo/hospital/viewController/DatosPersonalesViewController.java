package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DatosPersonalesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAtras;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtTipoSangre;

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtDireccion != null : "fx:id=\"txtDireccion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtEdad != null : "fx:id=\"txtEdad\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtIdentificacion != null : "fx:id=\"txtIdentificacion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTipoSangre != null : "fx:id=\"txtTipoSangre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";

    }

}
