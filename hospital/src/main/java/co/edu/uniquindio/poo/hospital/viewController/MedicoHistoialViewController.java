package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicoHistoialViewController {

    private App app;
    private Medico medico;
    private ObservableList<HistorialMedico> listaHistoriales;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarHistorial;

    @FXML
    private Button btnAgregarHistorial;

    @FXML
    public Label lblPaciente;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarHistorial;

    @FXML
    private Button btnVerDetalle;

    @FXML
    private TableColumn<HistorialMedico, String> columDescripcion;

    @FXML
    private TableColumn<HistorialMedico, String> columDiagnostico;

    @FXML
    private TableColumn<HistorialMedico, String> columNombPaciente;

    @FXML
    private Label lblFecha;

    @FXML
    private TableView<HistorialMedico> tblHistorialMedico;

    @FXML
    private TextArea txtDescripMedica;

    @FXML
    private TextArea txtDiagMedico;


    @FXML
    void onActualizarHistorial(ActionEvent event) {
        HistorialMedico historialSeleccionado = tblHistorialMedico.getSelectionModel().getSelectedItem();
        if (historialSeleccionado != null) {
            if ((txtDescripMedica.getText().isEmpty() || txtDiagMedico.getText().isEmpty())) {
                mostrarMensaje("Error", "Campos vacios", "Llene todos los campos");
                txtDescripMedica.setText(historialSeleccionado.getDescripcion());
                txtDiagMedico.setText(historialSeleccionado.getDiagnostico());
            }
            if (txtDescripMedica.getText() != historialSeleccionado.getDescripcion()){
                historialSeleccionado.setDescripcion(txtDescripMedica.getText());

            }
            if (txtDiagMedico.getText() != historialSeleccionado.getDiagnostico()){
                historialSeleccionado.setDiagnostico(txtDiagMedico.getText());

            }
            tblHistorialMedico.refresh();
            mostrarMensaje("Actualizacion", "Historial actualizado", "Se ha actualizado el historial con exito");

        }
    }


    @FXML
    void onAgregarHistorial(ActionEvent event) {
        app.abrirAgregarPacienteMedico(medico);
    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaMedico(this.medico);
    }

    @FXML
    void onEliminarHistorial(ActionEvent event) {
        HistorialMedico historialSeleccionado = tblHistorialMedico.getSelectionModel().getSelectedItem();

        if (historialSeleccionado != null) {
            Medico medico = historialSeleccionado.getTheMedico();
            medico.eliminarHistorial(historialSeleccionado);
            listaHistoriales.remove(historialSeleccionado);
            Paciente paciente = historialSeleccionado.getThePaciente();
            paciente.eliminarHistorial(historialSeleccionado);
        }
    }

    @FXML
    void onVerDetalle(ActionEvent event) {
        HistorialMedico historialSeleccionado = tblHistorialMedico.getSelectionModel().getSelectedItem();
        if (historialSeleccionado != null){
            app.abrirDetalleHistorialMedico(historialSeleccionado,medico);
        }
    }

    @FXML
    void initialize() {
        assert btnActualizarHistorial != null : "fx:id=\"btnActualizarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnAgregarHistorial != null : "fx:id=\"btnAgregarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnEliminarHistorial != null : "fx:id=\"btnEliminarHistorial\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert btnVerDetalle != null : "fx:id=\"btnVerDetalle\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columDescripcion != null : "fx:id=\"columDescripcion\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columDiagnostico != null : "fx:id=\"columDiagnostico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert columNombPaciente != null : "fx:id=\"columNombPaciente\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert lblFecha != null : "fx:id=\"lblFecha\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert tblHistorialMedico != null : "fx:id=\"tblHistorialMedico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert txtDescripMedica != null : "fx:id=\"txtDescripMedica\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert txtDiagMedico != null : "fx:id=\"txtDiagMedico\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        assert lblPaciente != null : "fx:id=\"lblPaciente\" was not injected: check your FXML file 'crudMedicoHistorial.fxml'.";
        columDescripcion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));
        columDiagnostico.setCellValueFactory((cell -> new SimpleStringProperty(cell.getValue().getDiagnostico())));
        columNombPaciente.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getThePaciente().getNombre()));
        tblHistorialMedico.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                lblFecha.setText(newSelection.getFecha().toString());
                txtDescripMedica.setText(newSelection.getDescripcion());
                txtDiagMedico.setText(newSelection.getDiagnostico());
                lblPaciente.setText(newSelection.getThePaciente().getNombre());
            } else {
                txtDescripMedica.clear();
                txtDiagMedico.clear();
            }
        });
    }

    public void setApp(App app) {
        this.app=app;
    }

    public void initMedico(Medico medico) {
        this.medico=medico;
        listaHistoriales = FXCollections.observableArrayList(medico.getListaHistorialMedicos());
        tblHistorialMedico.setItems(listaHistoriales);
    }

    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
