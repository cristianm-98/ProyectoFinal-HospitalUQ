package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Administrador;
import co.edu.uniquindio.poo.hospital.model.Especialidad;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatosPacienteViewController {

    private App app;
    private Administrador administrador;

    private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();
    public void setListaPacientes(ObservableList<Paciente> lista) {
        this.listaPacientes = lista;
        tblPaciente.setItems(listaPacientes);

    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActPaciente;

    @FXML
    private Button btnAgregPaciente;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnElimPaciente;

    @FXML
    private Button btnLimpPaciente;

    @FXML
    private TableColumn<Paciente, String> colDireccion;

    @FXML
    private TableColumn<Paciente,Integer> colEdad;

    @FXML
    private TableColumn<Paciente, String> colIdentificacion;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableColumn<Paciente, String> colTipoSangre;

    @FXML
    private TableView<Paciente> tblPaciente;

    @FXML
    private TextField txtDirPaciente;

    @FXML
    private TextField txtEdadPaciente;

    @FXML
    private TextField txtIdPaciente;

    @FXML
    private TextField txtNombPaciente;

    @FXML
    private TextField txtSangrePaciente;

    @FXML
    private TextField txtTelPaciente;

    @FXML
    void onActPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = tblPaciente.getSelectionModel().getSelectedItem();

        if (txtIdPaciente.getText().isEmpty()||
                txtNombPaciente.getText().isEmpty()||
                txtEdadPaciente.getText().isEmpty()||
                txtTelPaciente.getText().isEmpty()||
                txtDirPaciente.getText().isEmpty()||
                txtSangrePaciente.getText().isEmpty()) {
            mostrarAlerta("Por favor complete los datos completos y seleccione una especialidad");
            return;
        }

        try {
            String id= txtIdPaciente.getText();
            String nombre = txtNombPaciente.getText();
            int edad = Integer.parseInt(txtEdadPaciente.getText().trim());
            String telefono = txtTelPaciente.getText();
            String direccion = txtDirPaciente.getText();
            String tipoSangre = txtSangrePaciente.getText();

            if (pacienteSeleccionado == null) {
                Paciente newPaciente=new Paciente(id,nombre,edad,telefono,direccion,null,tipoSangre);
                listaPacientes.add(newPaciente);
            } else {
                pacienteSeleccionado.setId(id);
                pacienteSeleccionado.setNombre(nombre);
                pacienteSeleccionado.setEdad(edad);
                pacienteSeleccionado.setTelefono(telefono);
                pacienteSeleccionado.setDireccion(direccion);
                pacienteSeleccionado.setTipoSangre(tipoSangre);
                tblPaciente.refresh();
            }
            limpiarCampo();
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad y Años de experiencia deber ser numeros enteros");
        }
    }

    @FXML
    void onAgregPaciente(ActionEvent event) {
        try {
            if (txtIdPaciente.getText().isBlank() ||
                    txtNombPaciente.getText().isBlank()||
                    txtEdadPaciente.getText().isBlank()||
                    txtTelPaciente.getText().isBlank()||
                    txtDirPaciente.getText().isBlank()||
                    txtSangrePaciente.getText().isBlank()){
                mostrarAlerta("Por favor complete los datos completos y seleccione una especialidad");
                return;
            }

            String id=txtIdPaciente.getText();
            String nombre = txtNombPaciente.getText();
            int edad = Integer.parseInt(txtEdadPaciente.getText());
            String telefono = txtTelPaciente.getText();
            String direccion = txtDirPaciente.getText();
            String tipoSangre=txtSangrePaciente.getText();


            Paciente newPaciente=new Paciente(id,nombre,edad,telefono,direccion,null,tipoSangre);
            listaPacientes.add(newPaciente);
            tblPaciente.refresh();
            limpiarCampo();
        }catch (NumberFormatException e){
            mostrarAlerta("Edad deber ser numeros enteros");
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
    void onElimPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = tblPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSeleccionado != null) {
            listaPacientes.remove(pacienteSeleccionado);
            limpiarCampo();
        } else {
            mostrarAlerta("Debe seleccionar un medico para eliminar");
        }
    }

    @FXML
    void onLimPaciente(ActionEvent event) {
        limpiarCampo();

    }

    @FXML
    void initialize() {
        tblPaciente.setItems(listaPacientes);
        tblPaciente.refresh();

        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTipoSangre.setCellValueFactory(new PropertyValueFactory<>("tipoSangre"));

        tblPaciente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarPacienteSeleccionado(newValue)
        );
    }

    private void mostrarPacienteSeleccionado(Paciente paciente) {
        if (paciente != null) {
            txtIdPaciente.setText(paciente.getId());
            txtNombPaciente.setText(paciente.getNombre());
            txtEdadPaciente.setText(String.valueOf(paciente.getEdad()));
            txtTelPaciente.setText(paciente.getTelefono());
            txtDirPaciente.setText(paciente.getDireccion());
            txtSangrePaciente.setText(paciente.getTipoSangre());
        } else {
            limpiarCampo();
        }
    }

    public void limpiarCampo() {
        txtIdPaciente.clear();
        txtNombPaciente.clear();
        txtEdadPaciente.clear();
        txtTelPaciente.clear();
        txtDirPaciente.clear();
        txtSangrePaciente.clear();
        tblPaciente.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app=app;
    }

    public void initAdministrador(Administrador administrador) {
        this.administrador=administrador;
    }

}
