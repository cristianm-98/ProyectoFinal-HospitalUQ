package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medicamento;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.PrescripcionMedica;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DetalleMedicamentoViewController {
    private App app;
    private Medico medico;
    private HistorialMedico historialMedico;
    private ObservableList<Medicamento> listamedicamentos;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarMedicamento;

    @FXML
    private Button btnAtras;

    @FXML
    private TableColumn<Medicamento, String> columDescripcionMedic;

    @FXML
    private TableColumn<Medicamento, String> columNombreMedic;

    @FXML
    private TableView<Medicamento> tblMedicamento;

    @FXML
    void onAgregarMedicamento(ActionEvent event) {
        Medicamento medicamentoSeleccionado = tblMedicamento.getSelectionModel().getSelectedItem();
        if (medicamentoSeleccionado != null){
            String id = UUID.randomUUID().toString().replace("-", "");
            PrescripcionMedica prescripcionMedica = new PrescripcionMedica(id,medicamentoSeleccionado,historialMedico);
            medicamentoSeleccionado.agregarPrescripcion(prescripcionMedica);
            historialMedico.agregarPrescripcion(prescripcionMedica);
            mostrarMensaje("Exito","Medicamento agregado","Medicamento agregado correctamente");
        }

    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirDetalleHistorialMedico(historialMedico,medico);
    }

    @FXML
    void initialize() {
        assert btnAgregarMedicamento != null : "fx:id=\"btnAgregarMedicamento\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert columDescripcionMedic != null : "fx:id=\"columDescripcionMedic\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert columNombreMedic != null : "fx:id=\"columNombreMedic\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert tblMedicamento != null : "fx:id=\"tblMedicamento\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initMedico(Medico medico) {
        this.medico = medico;
    }

    public void initHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
        columNombreMedic.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombreMedicamento()));
        columDescripcionMedic.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));
        this.listamedicamentos = FXCollections.observableArrayList(app.getMedicamentos());
        tblMedicamento.setItems(listamedicamentos);
    }

    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
