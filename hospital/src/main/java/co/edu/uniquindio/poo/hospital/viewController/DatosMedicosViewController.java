package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatosMedicosViewController {
    private App app;
    private Administrador administrador;

    private ObservableList<Medico> listaMedicos = FXCollections.observableArrayList();

    public void setListaMedicos(ObservableList<Medico> lista) {
        this.listaMedicos = lista;
        tbMedicos.setItems(listaMedicos);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarMedico;

    @FXML
    private Button btnAgregarMedico;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarMedico;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<Especialidad> cboxEspecialidadMedico;

    @FXML
    private TableColumn<Medico, String> columDireccion;

    @FXML
    private TableColumn<Medico, Integer> columEdad;

    @FXML
    private TableColumn<Medico, String> columEspecialidad;

    @FXML
    private TableColumn<Medico, Integer> columExperiencia;

    @FXML
    private TableColumn<Medico, String> columLicencia;

    @FXML
    private TableColumn<Medico, String> columNombre;

    @FXML
    private TableColumn<Medico, String> columTelefono;

    @FXML
    private TableView<Medico> tbMedicos;

    @FXML
    private TextField txtDireccionMedico;

    @FXML
    private TextField txtEdadMedico;

    @FXML
    private TextField txtExperienciaMedico;

    @FXML
    private TextField txtLicenciaMedico;

    @FXML
    private TextField txtNombreMedico;

    @FXML
    private TextField txtTelefonoMedico;

    @FXML
    void onActualizar(ActionEvent event) {
        Medico medicoSeleccionado = tbMedicos.getSelectionModel().getSelectedItem();

        if (txtNombreMedico.getText().isEmpty() ||
                txtEdadMedico.getText().isEmpty() ||
                txtTelefonoMedico.getText().isEmpty() ||
                txtDireccionMedico.getText().isEmpty() ||
                txtLicenciaMedico.getText().isEmpty() ||
                txtExperienciaMedico.getText().isEmpty() ||
                cboxEspecialidadMedico.getValue() == null) {
            mostrarAlerta("Por favor complete los datos completos y seleccione una especialidad");
            return;
        }

        try {
            String id = UUID.randomUUID().toString();
            String nombre = txtNombreMedico.getText();
            int edad = Integer.parseInt(txtEdadMedico.getText().trim());
            String telefono = txtTelefonoMedico.getText();
            String direccion = txtDireccionMedico.getText();
            String licencia = txtLicenciaMedico.getText();
            int experiencia = Integer.parseInt(txtExperienciaMedico.getText().trim());
            Especialidad especialidad = cboxEspecialidadMedico.getValue();

            if (medicoSeleccionado == null) {
                Medico newMedico = new Medico(id, nombre, edad, telefono, direccion, null, licencia, experiencia, especialidad);
                listaMedicos.add(newMedico);
            } else {
                medicoSeleccionado.setNombre(nombre);
                medicoSeleccionado.setEdad(edad);
                medicoSeleccionado.setTelefono(telefono);
                medicoSeleccionado.setDireccion(direccion);
                medicoSeleccionado.setLicencia(licencia);
                medicoSeleccionado.setAnioExperiencia(experiencia);
                medicoSeleccionado.setEspecialidad(especialidad);
                tbMedicos.refresh();
            }
            limpiarCampo();
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad y Años de experiencia deber ser numeros enteros");
        }
    }

    @FXML
    void onAgregar(ActionEvent event) {
        try {
            if (txtNombreMedico.getText().isBlank() ||
                    txtEdadMedico.getText().isBlank() ||
                    txtTelefonoMedico.getText().isBlank() ||
                    txtDireccionMedico.getText().isBlank() ||
                    txtLicenciaMedico.getText().isBlank() ||
                    txtExperienciaMedico.getText().isBlank() ||
                    cboxEspecialidadMedico.getValue() == null) {
                mostrarAlerta("Por favor complete los datos completos y seleccione una especialidad");
                return;
            }

            String id = UUID.randomUUID().toString();
            String nombre = txtNombreMedico.getText();
            int edad = Integer.parseInt(txtEdadMedico.getText());
            String telefono = txtTelefonoMedico.getText();
            String direccion = txtDireccionMedico.getText();
            String licencia = txtLicenciaMedico.getText();
            int experiencia = Integer.parseInt(txtExperienciaMedico.getText());
            Especialidad especialidad = cboxEspecialidadMedico.getValue();

            Medico newMedico = new Medico(id, nombre, edad, telefono, direccion, null, licencia, experiencia, especialidad);
            listaMedicos.add(newMedico);
            tbMedicos.refresh();
            limpiarCampo();
        }catch (NumberFormatException e){
            mostrarAlerta("Edad y Años de experiencia deber ser numeros enteros");
        }

    }
    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaAdministrador(this.administrador);

    }

    @FXML
    void onEliminar(ActionEvent event) {
        Medico medicoSeleccionado = tbMedicos.getSelectionModel().getSelectedItem();
        if (medicoSeleccionado != null) {
            listaMedicos.remove(medicoSeleccionado);
            limpiarCampo();
        } else {
            mostrarAlerta("Debe seleccionar un medico para eliminar");
        }

    }

    @FXML
    void onLimpiar(ActionEvent event) {
        limpiarCampo();

    }

    @FXML
    void initialize() {
        tbMedicos.setItems(listaMedicos);
        tbMedicos.refresh();

        columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columLicencia.setCellValueFactory(new PropertyValueFactory<>("licencia"));
        columExperiencia.setCellValueFactory(new PropertyValueFactory<>("anioExperiencia"));
        columEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        cboxEspecialidadMedico.getItems().addAll(Especialidad.values());


        tbMedicos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarMedicoSeleccionado(newValue)
        );

    }

    private void mostrarMedicoSeleccionado(Medico medico) {
        if (medico != null) {
            txtNombreMedico.setText(medico.getNombre());
            txtEdadMedico.setText(String.valueOf(medico.getEdad()));
            txtTelefonoMedico.setText(medico.getTelefono());
            txtDireccionMedico.setText(medico.getDireccion());
            txtLicenciaMedico.setText(medico.getLicencia());
            txtExperienciaMedico.setText(String.valueOf(medico.getAnioExperiencia()));
            cboxEspecialidadMedico.setValue(medico.getEspecialidad());
        } else {
            limpiarCampo();
        }
    }

    public void limpiarCampo() {
        txtNombreMedico.clear();
        txtEdadMedico.clear();
        txtTelefonoMedico.clear();
        txtDireccionMedico.clear();
        txtLicenciaMedico.clear();
        txtExperienciaMedico.clear();
        cboxEspecialidadMedico.setValue(null);
        tbMedicos.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }


}
