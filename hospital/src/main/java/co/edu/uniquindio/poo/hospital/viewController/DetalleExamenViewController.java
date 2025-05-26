package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Examen;
import co.edu.uniquindio.poo.hospital.model.HistorialMedico;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DetalleExamenViewController {
    private  App app;
    private Medico medico;
    private HistorialMedico historialMedico;
    private ObservableList<Examen> lista_examen;

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
    private TableColumn<Examen, String> columDescripcionExam;

    @FXML
    private TableColumn<Examen, String> columNombreExamen;

    @FXML
    private TableView<Examen> tblExamen;

    @FXML
    private TextArea txtDescripcionMedic;

    @FXML
    private TextField txtNombreExamen;

    @FXML
    void onActualizarExamen(ActionEvent event) {
        Examen examenSeleccionado = tblExamen.getSelectionModel().getSelectedItem();
        if (examenSeleccionado != null){
            Boolean error = false;
            if (txtDescripcionMedic.getText().isEmpty()|| txtNombreExamen.getText().isEmpty()){
                error = true;
            }
            if (!(txtDescripcionMedic.getText().equalsIgnoreCase(examenSeleccionado.getDescripcion()))){
                examenSeleccionado.setDescripcion(txtDescripcionMedic.getText());
            }
            if (!(txtNombreExamen.getText().equalsIgnoreCase(examenSeleccionado.getNombreExamen()))){
                examenSeleccionado.setNombreExamen(txtNombreExamen.getText());
            }
            if (error){
                mostrarMensaje("Error","Datos en blanco","Por favor ingrese datos validos.");
            }
            else{
                mostrarMensaje("Actualizacion", "Examen actualizado", "Se ha actualizado el examen con exito");
            }
            tblExamen.refresh();

        }

    }

    @FXML
    void onAgregarExamen(ActionEvent event) {
        if (tblExamen.getSelectionModel().getSelectedItem() == null){
            String nombre = txtNombreExamen.getText();
            String descripcion = txtDescripcionMedic.getText();
            if (nombre.isEmpty() || descripcion.isEmpty()){
                mostrarMensaje("Error", "Campos vacios", "Llene todos los campos");
                txtDescripcionMedic.setText("");
                txtNombreExamen.setText("");
            }
            else{
                String id = UUID.randomUUID().toString().replace("-", "");
                Examen examen = new Examen(id,nombre,descripcion,historialMedico);
                this.historialMedico.agregarExamen(examen);
                lista_examen.add(examen);
                mostrarMensaje("Agregado", "Examen agregado", "Se ha agregado el examen con exito");
            }
            tblExamen.refresh();
        }

    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirDetalleHistorialMedico(historialMedico,medico);
    }

    @FXML
    void onEliminarExamen(ActionEvent event) {
        Examen examenSeleccionado = tblExamen.getSelectionModel().getSelectedItem();
        if (examenSeleccionado != null){
            historialMedico.eliminarExamen(examenSeleccionado);
            lista_examen.remove(examenSeleccionado);
            mostrarMensaje("Eliminado", "Examen eliminado", "Se ha eliminado el examen con exito");
        }
        tblExamen.refresh();
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
        tblExamen.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtNombreExamen.setText(newSelection.getNombreExamen());
                txtDescripcionMedic.setText(newSelection.getDescripcion());
            } else {
                txtNombreExamen.clear();
                txtDescripcionMedic.clear();
            }
        });
    }

    public void setApp(App app) {
        this.app=app;
    }

    public void initMedico(Medico medico) {
        this.medico=medico;
    }

    public void initHistorialMedico(HistorialMedico historialMedico){
        this.historialMedico=historialMedico;
        columNombreExamen.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombreExamen()));
        columDescripcionExam.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDescripcion()));

        lista_examen = FXCollections.observableArrayList(this.historialMedico.getListaExamenes());
        tblExamen.setItems(lista_examen);
    }
    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}
