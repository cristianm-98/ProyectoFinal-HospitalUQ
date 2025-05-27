package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ContraseniaRestaurarViewController {
    private App app;
    private Administrador administrador;
    private Hospital hospital;
    private Persona personaEncontrada;
    private String vistaAnterior;

    private ObservableList<Paciente> listaPacientes;
    private ObservableList<Medico> listaMedicos;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnRestaurar;

    @FXML
    private Label lblNombreUsuario;

    @FXML
    private PasswordField txtContraseniaNueva;

    @FXML
    private TextField txtId;

    @FXML
    void onBuscar(ActionEvent event) {
        String id = txtId.getText().trim();

        if (id.isEmpty()) {
            mostrarAlerta("Debe ingresar una identificación.");
            return;
        }

        // Buscar en médicos
        personaEncontrada = listaMedicos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);

        // Si no se encontró, buscar en pacientes
        if (personaEncontrada == null) {
            personaEncontrada = listaPacientes.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        if (personaEncontrada == null) {
            mostrarAlerta("No se encontró ningún médico o paciente con esa identificación.");
            return;
        }

        if (personaEncontrada.getTheUsuario() == null) {
            mostrarAlerta("Este usuario no tiene cuenta asociada.");
            return;
        }

        lblNombreUsuario.setText(personaEncontrada.getNombre());
        txtContraseniaNueva.setDisable(false);
        btnRestaurar.setDisable(false);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Exito");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void onRestaurar(ActionEvent event) {
        String nueva = txtContraseniaNueva.getText();

        if (nueva.isEmpty()) {
            mostrarAlerta("La contraseña no puede estar vacía.");
            return;
        }

        personaEncontrada.getTheUsuario().setContrasena(nueva);
        mostrarAlerta("¡Contraseña actualizada correctamente! " + nueva);
        txtId.clear();
        txtContraseniaNueva.clear();
        txtContraseniaNueva.setDisable(true);
        btnRestaurar.setDisable(true);
    }

    @FXML
    void onAtras(ActionEvent event) {
        ((Stage) btnAtras.getScene().getWindow()).close();

            if ("paciente".equalsIgnoreCase(vistaAnterior)) {
                app.abrirVistaGestionPaciente(this.administrador);
            } else if ("medico".equalsIgnoreCase(vistaAnterior)) {
                app.abrirVistaGestionMedico(this.administrador);
            }
        }


        @FXML
        void initialize () {

        }

        public void initAdministrador (Administrador administrador){
            this.administrador = administrador;

        }
        public void initListaMedico (Hospital hospital){
            this.hospital = hospital;
            listaMedicos = FXCollections.observableArrayList(hospital.getListaMedicos());

        }
        public void initListaPaciente (Hospital hospital){
            this.hospital = hospital;
            listaPacientes = FXCollections.observableArrayList(hospital.getListaPacientes());

        }

        public void setApp (App app){
            this.app = app;
        }
        public void setVistaAnterior (String vista){
            this.vistaAnterior = vista;
        }
    }
