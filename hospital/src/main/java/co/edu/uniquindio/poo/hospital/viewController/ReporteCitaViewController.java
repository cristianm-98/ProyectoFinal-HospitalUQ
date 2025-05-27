package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Administrador;
import co.edu.uniquindio.poo.hospital.model.Cita;
import co.edu.uniquindio.poo.hospital.model.Hospital;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReporteCitaViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;
    private ObservableList<Cita>listaCitas= FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCerrar;

    @FXML
    private TableColumn<Cita, LocalDate> columDia;

    @FXML
    private TableColumn<Cita, String> columEstado;

    @FXML
    private TableColumn<Cita, LocalTime> columFechaFinal;

    @FXML
    private TableColumn<Cita, LocalTime> columFechaInicio;

    @FXML
    private TableColumn<Cita, String> columMedico;

    @FXML
    private TableView<Cita> tblReporteCita;

    @FXML
    void onCerrar(ActionEvent event) {
        app.abrirVistaDetalleReporte(this.administrador);

    }

    @FXML
    void initialize() {
        columDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        columFechaInicio.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        columFechaFinal.setCellValueFactory(new PropertyValueFactory<>("horaFinal"));
        columEstado.setCellValueFactory(cellData -> {
            boolean estado = cellData.getValue().isEstado();
            String textoEstado = estado ? "Finalizada" : "Pendiente";
            return new SimpleStringProperty(textoEstado);
        });
        columMedico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTheMedico().getNombre()) );
        tblReporteCita.setItems(listaCitas);
        tblReporteCita.refresh();
    }

    public void initAdministrador(Administrador administrador) {
        this.administrador=administrador;
    }

    public void setApp(App app) {
        this.app=app;
    }
    public void initCita(Hospital hospital){
        this.hospital=hospital;
        listaCitas=FXCollections.observableArrayList(hospital.obtenerTodasLasCitas()); //Obtiene todas las citas en un sola lista global
        tblReporteCita.setItems(listaCitas);


    }
}
