package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatosPacienteViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;

    private ObservableList<Paciente> listaPacientes;

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
    private Button btnRestaurarCont;

    @FXML
    private TableColumn<Paciente, String> colDireccion;

    @FXML
    private TableColumn<Paciente, Integer> colEdad;

    @FXML
    private TableColumn<Paciente, String> colIdentificacion;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableColumn<Paciente, String> colTipoSangre;

    @FXML
    private TableColumn<Paciente, String> colUsuario;

    @FXML
    private TableView<Paciente> tblPaciente;

    @FXML
    private PasswordField txtContrasenia;

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
    private TextField txtUsuario;

    @FXML
    void onAgregPaciente(ActionEvent event) {
        try {
            if (txtIdPaciente.getText().isBlank() ||
                    txtNombPaciente.getText().isBlank() ||
                    txtEdadPaciente.getText().isBlank() ||
                    txtTelPaciente.getText().isBlank() ||
                    txtDirPaciente.getText().isBlank() ||
                    txtSangrePaciente.getText().isBlank() ||
                    txtUsuario.getText().isBlank() ||
                    txtContrasenia.getText().isBlank()) {
                mostrarAlerta("Por favor complete los datos completos");
                return;
            }

            String id = txtIdPaciente.getText();
            String nombre = txtNombPaciente.getText();
            int edad = Integer.parseInt(txtEdadPaciente.getText());
            String telefono = txtTelPaciente.getText();
            String direccion = txtDirPaciente.getText();
            String tipoSangre = txtSangrePaciente.getText();

            //Crear Usuario
            String usuarioNombre = txtUsuario.getText();
            String contrasenia = txtContrasenia.getText();
            Usuario newUsuario = new Usuario(usuarioNombre, contrasenia, null, TipoUsuario.PACIENTE);

            //Crear Paciente
            Paciente newPaciente = new Paciente(id, nombre, edad, telefono, direccion, null, tipoSangre);
            newPaciente.setTheUsuario(newUsuario);
            newUsuario.setThePersona(newPaciente);

            //Agregar a la lista Paciente
            listaPacientes.add(newPaciente);
            hospital.getListaPacientes().add(newPaciente);
            tblPaciente.refresh();
            limpiarCampo();
            mostrarAlerta("Paciente creado con exito. \nUsuario: " + usuarioNombre + "\nContraseña: " + contrasenia + "\nGuarde esta informacion");
        } catch (NumberFormatException e) {
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
    void onActPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = tblPaciente.getSelectionModel().getSelectedItem();

        if (txtIdPaciente.getText().isEmpty() ||
                txtNombPaciente.getText().isEmpty() ||
                txtEdadPaciente.getText().isEmpty() ||
                txtTelPaciente.getText().isEmpty() ||
                txtDirPaciente.getText().isEmpty() ||
                txtSangrePaciente.getText().isEmpty() ||
                txtUsuario.getText().isEmpty() ||
                txtContrasenia.getText().isEmpty()) {
            mostrarAlerta("Por favor complete los datos completos");
            return;
        }

        try {
            String id = txtIdPaciente.getText();
            String nombre = txtNombPaciente.getText();
            int edad = Integer.parseInt(txtEdadPaciente.getText().trim());
            String telefono = txtTelPaciente.getText();
            String direccion = txtDirPaciente.getText();
            String tipoSangre = txtSangrePaciente.getText();
            String usuarioText=txtUsuario.getText();
            String contraseniaText=txtContrasenia.getText();

            if (pacienteSeleccionado == null) {
                Usuario usuario=new Usuario(usuarioText,contraseniaText,null,TipoUsuario.PACIENTE);
                Paciente newPaciente = new Paciente(id, nombre, edad, telefono, direccion, null, tipoSangre);
                newPaciente.setTheUsuario(usuario);
                usuario.setThePersona(newPaciente);
                listaPacientes.add(newPaciente);
                hospital.getListaPacientes().add(newPaciente);
                tblPaciente.refresh();
            } else {
                pacienteSeleccionado.setId(id);
                pacienteSeleccionado.setNombre(nombre);
                pacienteSeleccionado.setEdad(edad);
                pacienteSeleccionado.setTelefono(telefono);
                pacienteSeleccionado.setDireccion(direccion);
                pacienteSeleccionado.setTipoSangre(tipoSangre);

                if (pacienteSeleccionado.getTheUsuario() == null) {
                    Usuario nuevoUsuario = new Usuario(usuarioText, contraseniaText, null, TipoUsuario.PACIENTE);
                    pacienteSeleccionado.setTheUsuario(nuevoUsuario);
                } else {
                    String contraseniaActual = pacienteSeleccionado.getTheUsuario().getContrasena();
                    if (!contraseniaText.equals(contraseniaActual)) {
                        mostrarAlerta("No se puede cambiar la constraseña, Use el boton Restaurar Contraseña");
                        txtContrasenia.setText(contraseniaActual);
                        return;
                    }
                    pacienteSeleccionado.getTheUsuario().setUsuario(usuarioText);
                }
                tblPaciente.refresh();
            }
            limpiarCampo();;
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad y Años de experiencia deber ser numeros enteros");
        }
    }

    @FXML
    void onElimPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = tblPaciente.getSelectionModel().getSelectedItem();
        if (pacienteSeleccionado != null) {
            hospital.getListaPacientes().remove(pacienteSeleccionado);
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
    void onAtras(ActionEvent event) {
        app.abrirVistaAdministrador(this.administrador);

    }

    @FXML
    void onRestaurarCont(ActionEvent event) {
        app.abrirContraseniaRestaurarPaciente(this.administrador);

    }

    @FXML
    void initialize() {
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTipoSangre.setCellValueFactory(new PropertyValueFactory<>("tipoSangre"));
        colUsuario.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue().getTheUsuario();
            if (usuario != null) {
                return new SimpleStringProperty(usuario.getUsuario());
            } else {
                return new SimpleStringProperty("No asignado");
            }
        });
        tblPaciente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarPacienteSeleccionado(newValue)
        );
        tblPaciente.setItems(listaPacientes);
        tblPaciente.refresh();
    }

    private void mostrarPacienteSeleccionado(Paciente paciente) {
        if (paciente != null) {
            txtIdPaciente.setText(paciente.getId());
            txtNombPaciente.setText(paciente.getNombre());
            txtEdadPaciente.setText(String.valueOf(paciente.getEdad()));
            txtTelPaciente.setText(paciente.getTelefono());
            txtDirPaciente.setText(paciente.getDireccion());
            txtSangrePaciente.setText(paciente.getTipoSangre());

            if (paciente.getTheUsuario() != null) {
                txtUsuario.setText(paciente.getTheUsuario().getUsuario());
                txtContrasenia.setText(paciente.getTheUsuario().getContrasena());
            } else {
                txtUsuario.clear();
                txtContrasenia.clear();
            }
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
        txtUsuario.clear();
        txtContrasenia.clear();
        tblPaciente.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    //Metodo para que cargue la inforamcion a la tableView
    public void initPaciente(Hospital hospital) {
        this.hospital = hospital;
        listaPacientes = FXCollections.observableArrayList(hospital.getListaPacientes());
        tblPaciente.setItems(listaPacientes);
    }
}
