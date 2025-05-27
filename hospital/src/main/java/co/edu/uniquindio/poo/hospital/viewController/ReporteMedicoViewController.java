package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Administrador;
import co.edu.uniquindio.poo.hospital.model.Hospital;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReporteMedicoViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Medico, String> columEspecialidad;

    @FXML
    private TableColumn<Medico, String> columEstado;

    @FXML
    private TableColumn<Medico, String> columMedico;

    @FXML
    private TableView<Medico> tblReporteMedico;

    @FXML
    void onCerrar(ActionEvent event) {
        app.abrirVistaDetalleReporte(this.administrador);

    }

    @FXML
    void initialize() {
        columMedico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columEstado.setCellValueFactory(cellData -> {
            Medico medico = cellData.getValue();
            boolean ocupado = medico.getListaCitas() != null && medico.getListaCitas().size() > 0;
            String estado = ocupado ? "Ocupado" : "Disponible";
            return new SimpleStringProperty(estado);

        });
    }
    private void cargarDatosEnTabla() {
        if (hospital != null) {
            tblReporteMedico.setItems(FXCollections.observableArrayList(hospital.getListaMedicos()));
        }
    }
    public void initAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void initReporteMedico(Hospital hospital){
        this.hospital=hospital;
        cargarDatosEnTabla();
    }

}
