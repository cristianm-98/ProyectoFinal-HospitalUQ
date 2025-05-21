package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NotificacionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnMarcarLeido;

    @FXML
    private TableColumn<?, ?> columFecha;

    @FXML
    private TableColumn<?, ?> columLeido;

    @FXML
    private TableColumn<?, ?> columMensaje;

    @FXML
    private TableView<?> tbNotificaciones;

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onMarcarLeido(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";
        assert btnMarcarLeido != null : "fx:id=\"btnMarcarLeido\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";
        assert columFecha != null : "fx:id=\"columFecha\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";
        assert columLeido != null : "fx:id=\"columLeido\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";
        assert columMensaje != null : "fx:id=\"columMensaje\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";
        assert tbNotificaciones != null : "fx:id=\"tbNotificaciones\" was not injected: check your FXML file 'crudNotificaciones.fxml'.";

    }

}
