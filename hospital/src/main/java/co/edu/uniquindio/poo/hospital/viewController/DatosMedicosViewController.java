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

public class DatosMedicosViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;
    private ObservableList<Medico> listaMedicos;



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
    private TableColumn<Medico, String> columIdentificacion;

    @FXML
    private TableColumn<Medico, String> columUsuario;

    @FXML
    private TableView<Medico> tbMedicos;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtDireccionMedico;

    @FXML
    private TextField txtEdadMedico;

    @FXML
    private TextField txtExperienciaMedico;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtLicenciaMedico;

    @FXML
    private TextField txtNombreMedico;

    @FXML
    private TextField txtTelefonoMedico;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onActualizar(ActionEvent event) {
        Medico medicoSeleccionado = tbMedicos.getSelectionModel().getSelectedItem();

        if (txtIdentificacion.getText().isEmpty() ||
                txtNombreMedico.getText().isEmpty() ||
                txtEdadMedico.getText().isEmpty() ||
                txtTelefonoMedico.getText().isEmpty() ||
                txtDireccionMedico.getText().isEmpty() ||
                txtLicenciaMedico.getText().isEmpty() ||
                txtExperienciaMedico.getText().isEmpty() ||
                cboxEspecialidadMedico.getValue() == null ||
                txtUsuario.getText().isEmpty()||
                txtContrasenia.getText().isEmpty()) {
            mostrarAlerta("Por favor complete los datos completos incluyendo usuario y contraseña");
            return;
        }

        try {
            String id = txtIdentificacion.getText();
            String nombre = txtNombreMedico.getText();
            int edad = Integer.parseInt(txtEdadMedico.getText().trim());
            String telefono = txtTelefonoMedico.getText();
            String direccion = txtDireccionMedico.getText();
            String licencia = txtLicenciaMedico.getText();
            int experiencia = Integer.parseInt(txtExperienciaMedico.getText().trim());
            Especialidad especialidad = cboxEspecialidadMedico.getValue();
            String usuarioText=txtUsuario.getText();
            String contraseniaText=txtContrasenia.getText();

            if (medicoSeleccionado == null) {
                Usuario usuario=new Usuario(usuarioText,contraseniaText,null,TipoUsuario.MEDICO);
                Medico newMedico = new Medico(id, nombre, edad, telefono, direccion, null, licencia, experiencia, especialidad);
                newMedico.setTheUsuario(usuario);
                usuario.setThePersona(newMedico);
                listaMedicos.add(newMedico);
                hospital.getListaMedicos().add(newMedico);
                tbMedicos.refresh();

            } else {
                medicoSeleccionado.setNombre(nombre);
                medicoSeleccionado.setEdad(edad);
                medicoSeleccionado.setTelefono(telefono);
                medicoSeleccionado.setDireccion(direccion);
                medicoSeleccionado.setLicencia(licencia);
                medicoSeleccionado.setAnioExperiencia(experiencia);
                medicoSeleccionado.setEspecialidad(especialidad);

                if (medicoSeleccionado.getTheUsuario()==null){
                    Usuario nuevoUsuario=new Usuario(usuarioText,contraseniaText,null,TipoUsuario.MEDICO);
                    medicoSeleccionado.setTheUsuario(nuevoUsuario);
                }else{
                    String contraseniaActual=medicoSeleccionado.getTheUsuario().getContrasena();
                    if(!contraseniaText.equals(contraseniaActual)){
                        mostrarAlerta("No se puede cambiar la constraseña, Use el boton Restaurar Contraseña");
                        txtContrasenia.setText(contraseniaActual);
                        return;
                    }
                    medicoSeleccionado.getTheUsuario().setUsuario(usuarioText);
                }
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
            if (txtIdentificacion.getText().isBlank() ||
                    txtNombreMedico.getText().isBlank() ||
                    txtEdadMedico.getText().isBlank() ||
                    txtTelefonoMedico.getText().isBlank() ||
                    txtDireccionMedico.getText().isBlank() ||
                    txtLicenciaMedico.getText().isBlank() ||
                    txtExperienciaMedico.getText().isBlank() ||
                    cboxEspecialidadMedico.getValue() == null ||
                    txtUsuario.getText().isBlank()||
                    txtContrasenia.getText().isBlank())
            {
                mostrarAlerta("Por favor complete los datos completos y seleccione una especialidad");
                return;
            }

            String id = txtIdentificacion.getText();
            String nombre = txtNombreMedico.getText();
            int edad = Integer.parseInt(txtEdadMedico.getText());
            String telefono = txtTelefonoMedico.getText();
            String direccion = txtDireccionMedico.getText();
            String licencia = txtLicenciaMedico.getText();
            int experiencia = Integer.parseInt(txtExperienciaMedico.getText());
            Especialidad especialidad = cboxEspecialidadMedico.getValue();

            //Crear usuario
            String usuarioNombre=txtUsuario.getText();
            String contrasenia=txtContrasenia.getText();
            Usuario newUsuario= new Usuario(usuarioNombre,contrasenia,null,TipoUsuario.MEDICO);

            //Crear medico
            Medico newMedico = new Medico(id, nombre, edad, telefono, direccion, null, licencia, experiencia, especialidad);
            newMedico.setTheUsuario(newUsuario);
            newUsuario.setThePersona(newMedico);

            //Agregar a la lista
            listaMedicos.add(newMedico);
            hospital.getListaMedicos().add(newMedico);
            tbMedicos.refresh();
            limpiarCampo();
            mostrarAlerta("Medico creado con exito. \nUsuario: " + usuarioNombre + "\nContraseña: "+ contrasenia +"\nGuarde esta informacion");
        } catch (NumberFormatException e) {
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
            hospital.getListaMedicos().remove(medicoSeleccionado);
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
        columIdentificacion.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columLicencia.setCellValueFactory(new PropertyValueFactory<>("licencia"));
        columExperiencia.setCellValueFactory(new PropertyValueFactory<>("anioExperiencia"));
        columEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        cboxEspecialidadMedico.getItems().addAll(Especialidad.values());
        columUsuario.setCellValueFactory(cellData -> {
            Usuario usuario = cellData.getValue().getTheUsuario();
            if (usuario != null) {
                return new SimpleStringProperty(usuario.getUsuario());
            } else {
                return new SimpleStringProperty("No asignado");
            }
        });
        tbMedicos.setItems(listaMedicos);
        tbMedicos.refresh();


        tbMedicos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarMedicoSeleccionado(newValue)
        );

    }

    private void mostrarMedicoSeleccionado(Medico medico) {
        if (medico != null) {
            txtIdentificacion.setText(medico.getId());
            txtNombreMedico.setText(medico.getNombre());
            txtEdadMedico.setText(String.valueOf(medico.getEdad()));
            txtTelefonoMedico.setText(medico.getTelefono());
            txtDireccionMedico.setText(medico.getDireccion());
            txtLicenciaMedico.setText(medico.getLicencia());
            txtExperienciaMedico.setText(String.valueOf(medico.getAnioExperiencia()));
            cboxEspecialidadMedico.setValue(medico.getEspecialidad());

            if (medico.getTheUsuario() != null) {
                txtUsuario.setText(medico.getTheUsuario().getUsuario());
                txtContrasenia.setText(medico.getTheUsuario().getContrasena());
            } else {
                txtUsuario.clear();
                txtContrasenia.clear();
            }

        } else {
            limpiarCampo();
        }
    }

    public void limpiarCampo() {
        txtIdentificacion.clear();
        txtNombreMedico.clear();
        txtEdadMedico.clear();
        txtTelefonoMedico.clear();
        txtDireccionMedico.clear();
        txtLicenciaMedico.clear();
        txtExperienciaMedico.clear();
        cboxEspecialidadMedico.setValue(null);
        txtUsuario.clear();
        txtContrasenia.clear();
        tbMedicos.getSelectionModel().clearSelection();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void initMedico(Hospital hospital) {
        this.hospital = hospital;
        listaMedicos = FXCollections.observableArrayList(hospital.getListaMedicos());
        tbMedicos.setItems(listaMedicos);
    }
}