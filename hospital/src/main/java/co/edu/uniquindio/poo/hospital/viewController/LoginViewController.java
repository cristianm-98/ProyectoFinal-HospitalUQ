package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import co.edu.uniquindio.poo.hospital.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {
    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnSalir;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onIngresar(ActionEvent event) {

        String usuarioIngresado = txtUsuario.getText();
        String claveIngresada = txtContrasenia.getText();

        Persona personaLogeada = app.buscarUsuario(usuarioIngresado, claveIngresada);
        if (personaLogeada != null) {
            switch (personaLogeada.getTheUsuario().getTipoUsuario()) {
                case PACIENTE -> app.abrirVistaPaciente((Paciente) personaLogeada);
                case MEDICO -> app.abrirVistaMedico((Medico) personaLogeada);
                case ADMINISTRADOR -> app.abrirVistaAdministrador();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario o contraseña incorrecta");
            alerta.showAndWait();
        }
    }

    @FXML
    void onSalir(ActionEvent event) {
        Stage stage=(Stage) btnSalir.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {

    }

    public void setApp(App app) {
        this.app = app;
    }
}
