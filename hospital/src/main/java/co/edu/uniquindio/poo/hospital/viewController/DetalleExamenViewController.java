package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Examen;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DetalleExamenViewController {
    public  App app;
    public Medico medico;
    public Examen examen;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarExamen;

    @FXML
    private Button btnAgregarExamen;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarExamen;

    @FXML
    private TableColumn<?, ?> columDescripcionExam;

    @FXML
    private TableColumn<?, ?> columNombreExamen;

    @FXML
    private TableView<?> tblExamen;

    @FXML
    private TextArea txtDescripcionMedic;

    @FXML
    private TextField txtNombreExamen;

    @FXML
    void onActualizarExamen(ActionEvent event) {

    }

    @FXML
    void onAgregarExamen(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirDetalleHistorialMedico(examen.getTheHistorialMedico(),medico);
    }

    @FXML
    void onEliminarExamen(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizarExamen != null : "fx:id=\"btnActualizarExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert btnAgregarExamen != null : "fx:id=\"btnAgregarExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert btnEliminarExamen != null : "fx:id=\"btnEliminarExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert columDescripcionExam != null : "fx:id=\"columDescripcionExam\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert columNombreExamen != null : "fx:id=\"columNombreExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert tblExamen != null : "fx:id=\"tblExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert txtDescripcionMedic != null : "fx:id=\"txtDescripcionMedic\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";
        assert txtNombreExamen != null : "fx:id=\"txtNombreExamen\" was not injected: check your FXML file 'verDetalleExamen.fxml'.";

    }

    public void setApp(App app) {
        this.app=app;
    }

    public void initMedico(Medico medico) {
        this.medico=medico;
    }

    public void initExamen(Examen examen) {
        this.examen = examen;
    }
}
