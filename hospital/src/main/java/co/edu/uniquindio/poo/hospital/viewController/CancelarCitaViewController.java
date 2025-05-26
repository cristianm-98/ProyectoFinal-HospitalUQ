package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Cita;
import co.edu.uniquindio.poo.hospital.model.ConsultorioMedico;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CancelarCitaViewController {
    private App app;
    private Paciente paciente;
    private ObservableList<Cita> citasObservableList;

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
    private TableColumn<Cita, LocalDate> columDia;

    @FXML
    private TableColumn<Cita, String> columEstado;

    @FXML
    private TableColumn<Cita, LocalTime> columHoraFinal;

    @FXML
    private TableColumn<Cita, LocalTime> columHoraInicio;

    @FXML
    private TableColumn<Cita, String> columId;

    @FXML
    private TableView<Cita> tblCitas;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaPaciente(this.paciente);
    }

    @FXML
    void onCancelarCita(ActionEvent event) {
        Cita citaSeleccionada = tblCitas.getSelectionModel().getSelectedItem();

        if (citaSeleccionada != null) {
            Medico medico = citaSeleccionada.getThemedico();
            ConsultorioMedico consultorioMedico = citaSeleccionada.getTheConsultorioMedico();
            citasObservableList.remove(citaSeleccionada);
            paciente.eliminarCita(citaSeleccionada);
            medico.eliminarCita(citaSeleccionada);
            consultorioMedico.eliminarCita(citaSeleccionada);

        }

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
        tblCitas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void initPaciente(Paciente paciente) {
        this.paciente = paciente;
        // String column
        columId.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getId())
        );

        // LocalDate column
        columDia.setCellValueFactory(cell ->
                new ReadOnlyObjectWrapper<>( cell.getValue().getDia() )
        );

        // LocalTime columns
        columHoraInicio.setCellValueFactory(cell ->
                new ReadOnlyObjectWrapper<>( cell.getValue().getHoraInicio() )
        );
        columHoraFinal.setCellValueFactory(cell ->
                new ReadOnlyObjectWrapper<>( cell.getValue().getHoraFinal() )
        );

        // Boolean column
        columEstado.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().isEstado() ? "Finalizada" : "Pendiente")
        );

        citasObservableList = FXCollections.observableArrayList(paciente.getListaCitas());

        tblCitas.setItems(citasObservableList);


        // Make them fill the width
        tblCitas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}

