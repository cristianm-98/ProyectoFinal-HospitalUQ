package co.edu.uniquindio.poo.hospital.viewController;

import java.awt.desktop.PreferencesEvent;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VerDetalleMedicoHistorialViewController {

    public App app;
    public Medico medico;
    public HistorialMedico historialMedico;
    private ObservableList<Examen> listaExamenes;
    private ObservableList<Medicamento> listaMedicamentos;
    private ObservableList<Tratamiento> listaTratamientos;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDetalleExamen;

    @FXML
    private Button btnDetallePrescripcion;

    @FXML
    private Button btnDetalleTratamiento;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Tratamiento, String> columDescripTratamiento;

    @FXML
    private TableColumn<Examen, String> columDescripcion;

    @FXML
    private TableColumn<PrescripcionMedica, String> columMedicamento;

    @FXML
    private TableColumn<Examen, String> columNombExamen;

    @FXML
    private TableView<Examen> tblExamen;

    @FXML
    private TableView<PrescripcionMedica> tblMedicamento;

    @FXML
    private TableView<Tratamiento> tblTratamiento;

    @FXML
    void onDetalleExamen(ActionEvent event) {
        app.abrirDetalleExamenMedico(historialMedico,medico);
    }

    @FXML
    void onDetallePrescripcion(ActionEvent event) {
        app.abrirDetalleMedicamentoMedico(historialMedico,medico);
    }

    @FXML
    void onDetalleTratamiento(ActionEvent event) {
        app.abrirDetalleTratamientoMedico(historialMedico,medico);
    }

    @FXML
    void onVolver(ActionEvent event) {
            app.abrirHistorialMedico(medico);
    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {
        this.app=app;
    }

    public void initMedico(Medico medico) {
        this.medico=medico;
    }

    public void initHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico=historialMedico;
        // -------------------- Examenes --------------------
        columNombExamen.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombreExamen()));
        columDescripcion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));
        ObservableList<Examen> lista_examen = FXCollections.observableArrayList(historialMedico.getListaExamenes());
        tblExamen.setItems(lista_examen);

        // -------------------- Tratamientos --------------------
        columDescripTratamiento.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));

        ObservableList<Tratamiento> lista_tratamiento = FXCollections.observableArrayList(historialMedico.getListaTratamientos());
        tblTratamiento.setItems(lista_tratamiento);

        // -------------------- Prescripción Médica --------------------

        columMedicamento.setCellValueFactory(cell -> {
            Medicamento med = cell.getValue().getTheMedicamentos();
            return new SimpleStringProperty(med != null ? med.getNombreMedicamento() : "");
        });

        ObservableList<PrescripcionMedica> lista_prescripcion = FXCollections.observableArrayList(historialMedico.getListaPrescripcionMedicas());
        tblMedicamento.setItems(lista_prescripcion);

    }
}
