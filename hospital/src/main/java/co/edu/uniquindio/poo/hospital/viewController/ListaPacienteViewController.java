package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaPacienteViewController {
    private Medico medico;
    private App app;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnSeleccionarPacient;

    @FXML
    private TableColumn<Paciente, String> columIdentificacion;

    @FXML
    private TableColumn<Paciente, String> columNombre;

    @FXML
    private TableView<Paciente> tblPaciente;

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirHistorialMedico(medico);
    }

    @FXML
    void onSeleccionarPacient(ActionEvent event) {
        Paciente pacienteSeleccionado = tblPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSeleccionado != null) {
            app.abrirAgregarDescDiagMedico(pacienteSeleccionado, medico);
        }
    }

    @FXML
    void initialize() {
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert btnSeleccionarPacient != null : "fx:id=\"btnSeleccionarPacient\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert columIdentificacion != null : "fx:id=\"columIdentificacion\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert columNombre != null : "fx:id=\"columNombre\" was not injected: check your FXML file 'listaPaciente.fxml'.";
        assert tblPaciente != null : "fx:id=\"tblPaciente\" was not injected: check your FXML file 'listaPaciente.fxml'.";

    }

    public void setApp(App app) {this.app = app;}
    public void initMedico(Medico medico){
        this.medico=medico;
        columIdentificacion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
        columNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        tblPaciente.setItems(FXCollections.observableArrayList(app.getPacientes()));
    }

}
