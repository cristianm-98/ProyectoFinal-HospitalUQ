package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class SolicitarCitaViewController {
    private Paciente paciente;
    private App app;
    private ObservableList<HorarioAtencion> horarios;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnSolicitarCita;

    @FXML
    private TableColumn<HorarioAtencion, String> columDia;

    @FXML
    private TableColumn<HorarioAtencion, String> columEspecialidad;

    @FXML
    private TableColumn<HorarioAtencion, LocalTime> columHoraFinal;

    @FXML
    private TableColumn<HorarioAtencion, LocalTime> columHoraInicio;

    @FXML
    private TableColumn<HorarioAtencion, String> columNombreMedico;

    @FXML
    private TableView<HorarioAtencion> tblCita;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaPaciente(this.paciente);
    }

    @FXML
    void onSolicitarCita(ActionEvent event) {
        HorarioAtencion horarioSeleccionado = tblCita.getSelectionModel().getSelectedItem();
        if (horarioSeleccionado!=null){
            LocalTime horaInicio = horarioSeleccionado.getHoraInicio();
            LocalTime horaFinal = horarioSeleccionado.getHoraFinal();
            LocalDate dia_seleccionado = app.getDia(horarioSeleccionado);
            ConsultorioMedico  consultorioMedico = app.getConsultorioMedico(dia_seleccionado,horaInicio);
            String id = UUID.randomUUID().toString().replace("-", "");
            Cita cita = new Cita(id,dia_seleccionado,horaInicio,horaFinal,false,consultorioMedico,paciente,horarioSeleccionado.getTheMedico());
            paciente.agregarCita(cita);
            consultorioMedico.agregarCita(cita);
            horarioSeleccionado.getTheMedico().agregarCita(cita);
            mostrarMensaje("Confirmacion","Cita solicitada","Su cita ha sido solicitada exitosamente");
        }else{
            mostrarMensaje("Advertencia","Cita no seleccionada","Por favor seleccione un horario de atencion");
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert btnSolicitarCita != null : "fx:id=\"btnSolicitarCita\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columDia != null : "fx:id=\"columDia\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columEspecialidad != null : "fx:id=\"columEspecialidad\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columHoraFinal != null : "fx:id=\"columHoraFinal\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columHoraInicio != null : "fx:id=\"columHoraInicio\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert columNombreMedico != null : "fx:id=\"columNombreMedico\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        assert tblCita != null : "fx:id=\"tblCita\" was not injected: check your FXML file 'crudSolicitarCita.fxml'.";
        columDia.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getDia()));
        columEspecialidad.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTheMedico().getEspecialidad().toString()));
        columHoraInicio.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getHoraInicio()));
        columHoraFinal.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getHoraFinal()));
        columNombreMedico.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getTheMedico().getNombre())
        );
    }

    public void initPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void initHorarios(LinkedList<HorarioAtencion> listaHorarios) {
        LinkedHashSet<HorarioAtencion> set = new LinkedHashSet<>(listaHorarios);
        List<HorarioAtencion> unique = new ArrayList<>(set);

        if (this.horarios == null) {
            this.horarios = FXCollections.observableArrayList(unique);
            tblCita.setItems(this.horarios);
            tblCita.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } else {
            this.horarios.setAll(unique);
        }
    }


    public void setApp(App app) {
        this.app = app;
    }
}
