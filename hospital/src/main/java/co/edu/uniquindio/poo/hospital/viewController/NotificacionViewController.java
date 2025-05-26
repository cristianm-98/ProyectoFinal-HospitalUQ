package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NotificacionViewController {
    private App app;
    private Paciente paciente = null;
    private Medico medico = null;

    ObservableList<Notificacion> notificacionesObservableList;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnMarcarLeido;

    @FXML
    private TableColumn<Notificacion, LocalTime> columFecha;

    @FXML
    private TableColumn<Notificacion, String> columLeido;

    @FXML
    private TableColumn<Notificacion, String> columMensaje;

    @FXML
    private TableView<Notificacion> tbNotificaciones;

    @FXML
    void onAtras(ActionEvent event) {
        if (this.medico == null && this.paciente != null) {
            app.abrirVistaPaciente(this.paciente);
        }
        if (this.paciente == null && this.medico != null) {
            app.abrirVistaMedico(this.medico);
        }

    }

    @FXML
    void onMarcarLeido(ActionEvent event) {
        Notificacion notificacionSeleccionada = tbNotificaciones.getSelectionModel().getSelectedItem();
        if (notificacionSeleccionada != null){
            notificacionSeleccionada.setLeido(true);
            tbNotificaciones.refresh();
        }
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
    public void setApp(App app) {
        this.app = app;
    }

    public void initNotificacion(LinkedList<Notificacion> notificacion){
        columFecha.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(cellData.getValue().getFechaEnvio()));
        columLeido.setCellValueFactory(cell -> {
            boolean leido = cell.getValue().isLeido();
            String texto = leido ? "Si" : "No";
            return new SimpleStringProperty(texto);
        });

        columMensaje.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMensaje()));

        this.notificacionesObservableList = FXCollections.observableArrayList(notificacion);
        tbNotificaciones.setItems(this.notificacionesObservableList);
    }

    public void initPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.initNotificacion(paciente.getListaNotificaciones());
    }

    public void initMedico(Medico medico) {
        this.medico = medico;
        this.initNotificacion(medico.getListaNotificaciones());
    }


}
