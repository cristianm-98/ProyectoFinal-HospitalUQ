package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class DatosPersonalesViewController {
    public App app;
    public Paciente paciente;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAtras;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtTipoSangre;

    @FXML
    void onActualizar(ActionEvent event) {
        boolean Error = false;
        if ((txtIdentificacion.getText() != "") && (txtIdentificacion.getText() != paciente.getId())){
            if (app.verificarID(txtIdentificacion.getText())) {
                Error = true;
            }
            else {
            paciente.setId(txtIdentificacion.getText());}
        }
        else {
            txtIdentificacion.setText(paciente.getId());
        }
        if ((txtNombre.getText() != "") && (txtNombre.getText() != paciente.getNombre())){
            paciente.setNombre(txtNombre.getText());
        }
        else{
            txtNombre.setText(paciente.getNombre());
        }
        if ((txtEdad.getText() != "") && (txtEdad.getText() != paciente.getEdad()+"") && !(txtEdad.getText().matches(".*[a-zA-Z].*"))){
            paciente.setEdad(Integer.parseInt(txtEdad.getText()));
        }
        else {
            txtEdad.setText(paciente.getEdad()+"");
        }
        if ((txtDireccion.getText() != "") && (txtDireccion.getText() != paciente.getDireccion())){
            paciente.setDireccion(txtDireccion.getText());
        }
        else{
            txtDireccion.setText(paciente.getDireccion());
        }
        if ((txtTelefono.getText() != "") && (txtTelefono.getText() != paciente.getTelefono()) && !(txtTelefono.getText().matches(".*[a-zA-Z].*"))){
            paciente.setTelefono(txtTelefono.getText());
        }
        else {
            txtTelefono.setText(paciente.getTelefono());
        }
        if ((txtTipoSangre.getText() != "") && (txtTipoSangre.getText() != paciente.getTipoSangre())){
            paciente.setTipoSangre(txtTipoSangre.getText());
        }
        else {
            txtTipoSangre.setText(paciente.getTipoSangre());
        }
        if (Error){
            mostrarMensaje("Advertencia","Identificacion invalida","Ya hay un usuario con la misma identificacion");
        }
        else{ mostrarMensaje("Confirmacion","Datos actualizados","Los datos han sido actualizados exitosamente");}
    }


    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaPaciente(this.paciente );
    }

    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtDireccion != null : "fx:id=\"txtDireccion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtEdad != null : "fx:id=\"txtEdad\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtIdentificacion != null : "fx:id=\"txtIdentificacion\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";
        assert txtTipoSangre != null : "fx:id=\"txtTipoSangre\" was not injected: check your FXML file 'crudDatosPersonales.fxml'.";

    }

    public void setApp(App app) {
        this.app = app;
    }

    public void initPaciente(Paciente paciente) {
        this.paciente = paciente;

        txtNombre.setText(paciente.getNombre());
        txtEdad.setText(paciente.getEdad()+"");
        txtDireccion.setText(paciente.getDireccion());
        txtTelefono.setText(paciente.getTelefono());
        txtIdentificacion.setText(paciente.getId());
        txtTipoSangre.setText(paciente.getTipoSangre());

    }

    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
