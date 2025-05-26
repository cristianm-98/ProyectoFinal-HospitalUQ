package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Examen;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Tratamiento;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DetalleTratamientoViewController {
    private App app;
    private Medico medico;
    private HistorialMedico historialMedico;
    private ObservableList<Tratamiento> lista_tratamiento;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarTratamiento;

    @FXML
    private Button btnAgregarTratamiento;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarTrtamiento;

    @FXML
    private TableColumn<Tratamiento, String> columDescripcionTratam;

    @FXML
    private TableView<Tratamiento> tblDescripcion;

    @FXML
    private TextArea txtDescripcionTratamiento;

    @FXML
    void onActualizarTratamiento(ActionEvent event) {
        Tratamiento tratamientoSeleccionado = tblDescripcion.getSelectionModel().getSelectedItem();
        if (tratamientoSeleccionado != null){
            Boolean error = false;
            if (txtDescripcionTratamiento.getText().isEmpty()){
                error = true;
            }
            if (!(txtDescripcionTratamiento.getText().equalsIgnoreCase(tratamientoSeleccionado.getDescripcion()))){
                tratamientoSeleccionado.setDescripcion(txtDescripcionTratamiento.getText());
            }
            if (error){
                mostrarMensaje("Error","Datos en blanco","Por favor ingrese datos validos.");
            }
            else{
                mostrarMensaje("Actualizacion", "Tratamiento actualizado", "Se ha actualizado el tratamiento con exito");
            }
            tblDescripcion.refresh();
        }
    }

    @FXML
    void onAgregarTratamiento(ActionEvent event) {
        if (tblDescripcion.getSelectionModel().getSelectedItem() == null){
            String descripcion = txtDescripcionTratamiento.getText();
            if (descripcion.isEmpty()){
                mostrarMensaje("Error", "Campos vacios", "Llene todos los campos");
                txtDescripcionTratamiento.setText("");
            }
            else{
                String id = UUID.randomUUID().toString().replace("-", "");
                Tratamiento tratamiento = new Tratamiento(id,descripcion,historialMedico);
                this.historialMedico.agregarTratamiento(tratamiento);
                lista_tratamiento.add(tratamiento);
                mostrarMensaje("Agregado", "Tratamiento agregado", "Se ha agregado el tratamiento con exito");
            }
            tblDescripcion.refresh();
        }
    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirDetalleHistorialMedico(historialMedico,medico);
    }

    @FXML
    void onEliminarTratamiento(ActionEvent event) {
        Tratamiento tratamientoSeleccionado = tblDescripcion.getSelectionModel().getSelectedItem();
        if (tratamientoSeleccionado != null){
            historialMedico.eliminarTratamiento(tratamientoSeleccionado);
            lista_tratamiento.remove(tratamientoSeleccionado);
            mostrarMensaje("Eliminado", "Tratamiento eliminado", "Se ha eliminado el tratamiento con exito");
        }
        tblDescripcion.refresh();
    }

    @FXML
    void initialize() {
        assert btnActualizarTratamiento != null : "fx:id=\"btnActualizarTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnAgregarTratamiento != null : "fx:id=\"btnAgregarTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert btnEliminarTrtamiento != null : "fx:id=\"btnEliminarTrtamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert columDescripcionTratam != null : "fx:id=\"columDescripcionTratam\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert tblDescripcion != null : "fx:id=\"tblDescripcion\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        assert txtDescripcionTratamiento != null : "fx:id=\"txtDescripcionTratamiento\" was not injected: check your FXML file 'verDetalleTratamiento.fxml'.";
        tblDescripcion.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtDescripcionTratamiento.setText(newSelection.getDescripcion());

            } else {
                txtDescripcionTratamiento.clear();
            }
        });
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initMedico(Medico medico) {
        this.medico=medico;
    }

    public void initHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico=historialMedico;
        columDescripcionTratam.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));

        lista_tratamiento = FXCollections.observableArrayList(this.historialMedico.getListaTratamientos());
        tblDescripcion.setItems(lista_tratamiento);
    }

    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
