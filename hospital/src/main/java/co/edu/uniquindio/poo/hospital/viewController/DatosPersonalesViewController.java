package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DatosPersonalesViewController {
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableColumn<?, ?> columDireccion;

    @FXML
    private TableColumn<?, ?> columEdad;

    @FXML
    private TableColumn<?, ?> columIdentificacion;

    @FXML
    private TableColumn<?, ?> columNombre;

    @FXML
    private TableColumn<?, ?> columTelefono;

    @FXML
    private TableColumn<?, ?> columTipoSangre;

    @FXML
    private TableView<?> tblPaciente;

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
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onLimpiar(ActionEvent event) {

    }

    @FXML
    void onRegistrar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columDireccion != null : "fx:id=\"columDireccion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columEdad != null : "fx:id=\"columEdad\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columIdentificacion != null : "fx:id=\"columIdentificacion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columNombre != null : "fx:id=\"columNombre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columTelefono != null : "fx:id=\"columTelefono\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert columTipoSangre != null : "fx:id=\"columTipoSangre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert tblPaciente != null : "fx:id=\"tblPaciente\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtDireccion != null : "fx:id=\"txtDireccion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtEdad != null : "fx:id=\"txtEdad\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtIdentificacion != null : "fx:id=\"txtIdentificacion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTipoSangre != null : "fx:id=\"txtTipoSangre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";

    }
    public void setApp(App app) {
        this.app = app;
    }

}
