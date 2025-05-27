package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Cita;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistorialMedicoViewController {
    private Paciente paciente;
    private App app;
    private ObservableList<HistorialMedico> historialObservableList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnVerDetalle;

    @FXML
    private TableColumn<HistorialMedico, String> columDescripcion;

    @FXML
    private TableColumn<HistorialMedico, String> columDiagnostico;

    @FXML
    private TableColumn<HistorialMedico, LocalDate> columFecha;

    @FXML
    private TableColumn<HistorialMedico, String> columId;

    @FXML
    private TableView<HistorialMedico> tbHistoriales;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaPaciente(this.paciente);
    }

    @FXML
    void onVerDetalle(ActionEvent event) {
        HistorialMedico HistorialSeleccionado = tbHistoriales.getSelectionModel().getSelectedItem();
        if (HistorialSeleccionado != null) {
            app.abrirVistaDetallesHistorialPaciente(HistorialSeleccionado,paciente);
        }

    }

    @FXML
    void initialize() {
    }

    public void setApp(App app) {this.app = app;}
    public void initPaciente(Paciente paciente) {
        this.paciente = paciente;
        ObservableList<HistorialMedico> lista = FXCollections.observableArrayList(paciente.getListahistorialMedico());
        columId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
        columFecha.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getFecha()));
        columDescripcion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));
        columDiagnostico.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDiagnostico()));

        tbHistoriales.setItems(lista);
        tbHistoriales.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
