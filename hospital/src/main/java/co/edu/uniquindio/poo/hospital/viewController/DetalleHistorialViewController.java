package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import javax.swing.*;

public class DetalleHistorialViewController {
    private App app;
    private Paciente paciente;
    private HistorialMedico historialMedico;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Examen, String> columDescripcionExamen;

    @FXML
    private TableColumn<Tratamiento, String> columDescripcionTratamiento;

    @FXML
    private TableColumn<Examen, String> columIdExamen;

    @FXML
    private TableColumn<PrescripcionMedica, String> columIdPrescripcion;

    @FXML
    private TableColumn<Tratamiento, String> columIdTratamiento;

    @FXML
    private TableColumn<PrescripcionMedica, String> columMedicamentos;

    @FXML
    private TableColumn<Examen, String> columNombreExamen;

    @FXML
    private Label lbDiagnostico;

    @FXML
    private Label lbFechaHistorial;

    @FXML
    private Label lbIdHistorial;


    @FXML
    private TableView<Examen> tbExamenes;

    @FXML
    private TableView<PrescripcionMedica> tbPrescripcionMedicas;

    @FXML
    private TableView<Tratamiento> tbTratamientos;

    @FXML
    private TextArea txtDiagnostico;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    void onCerrar(ActionEvent event) {
        app.abrirVistaHistorialPaciente(paciente);
    }

    @FXML
    void initialize() {
    }

    public void setApp(App app) {this.app = app;}
    public void initPaciente(Paciente paciente) {this.paciente = paciente;}

    public void initHistorial(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;

        // Examenes
        columIdExamen.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
        columNombreExamen.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombreExamen()));
        columDescripcionExamen.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));

        // Tratamientos
        columIdTratamiento.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
        columDescripcionTratamiento.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));

        // Prescripcion Medica
        columIdPrescripcion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));

        columMedicamentos.setCellValueFactory(cell -> {
            Medicamento med = cell.getValue().getTheMedicamentos();
            return new SimpleStringProperty(med != null ? med.getNombreMedicamento() : "");
        });

        ObservableList<Tratamiento> lista_tratamiento = FXCollections.observableArrayList(historialMedico.getListaTratamientos());
        ObservableList<Examen> lista_examen = FXCollections.observableArrayList(historialMedico.getListaExamenes());
        ObservableList<PrescripcionMedica> lista_prescripcion = FXCollections.observableArrayList(historialMedico.getListaPrescripcionMedicas());
        tbTratamientos.setItems(lista_tratamiento);
        tbExamenes.setItems(lista_examen);
        tbPrescripcionMedicas.setItems(lista_prescripcion);

        lbFechaHistorial.setText(historialMedico.getFecha().toString());
        lbIdHistorial.setText(historialMedico.getId());
        txtDescripcion.setText(historialMedico.getDescripcion());
        txtDiagnostico.setText(historialMedico.getDiagnostico().toString());
    }
}
