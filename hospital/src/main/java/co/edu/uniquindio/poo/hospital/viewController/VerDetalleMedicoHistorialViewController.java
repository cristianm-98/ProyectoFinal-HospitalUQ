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

    }

    @FXML
    void onDetallePrescripcion(ActionEvent event) {

    }

    @FXML
    void onDetalleTratamiento(ActionEvent event) {

    }

    @FXML
    void onVolver(ActionEvent event) {
        app.abrirHistorialMedico(medico);
    }

    @FXML
    void initialize() {
        assert btnDetalleExamen != null : "fx:id=\"btnDetalleExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnDetallePrescripcion != null : "fx:id=\"btnDetallePrescripcion\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnDetalleTratamiento != null : "fx:id=\"btnDetalleTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columDescripTratamiento != null : "fx:id=\"columDescripTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columDescripcion != null : "fx:id=\"columDescripcion\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columMedicamento != null : "fx:id=\"columMedicamento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert columNombExamen != null : "fx:id=\"columNombExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblExamen != null : "fx:id=\"tblExamen\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblMedicamento != null : "fx:id=\"tblMedicamento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";
        assert tblTratamiento != null : "fx:id=\"tblTratamiento\" was not injected: check your FXML file 'verDetalleMedicoHistorial.fxml'.";

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
