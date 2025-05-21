package co.edu.uniquindio.poo.hospital;

import co.edu.uniquindio.poo.hospital.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import co.edu.uniquindio.poo.hospital.model.*;

public class App extends Application {
    private Stage loginStage;
    public static Hospital hospital = new Hospital("810000913", "Hospital UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.loginStage = primaryStage;
        this.loginStage.setTitle("Gestion de Hospital");
        abrirVistaLogin();
    }
    public void abrirVistaLogin() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("login.fxml"));
            javafx.scene.layout.BorderPane rootLayout = (javafx.scene.layout.BorderPane) loader.load();
            LoginViewController loginViewController = loader.getController();
            loginViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaPaciente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuPacienteViewController menuPacienteViewController = loader.getController();
            menuPacienteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void abrirVistaMedico() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuMedicoViewController menuMedicoViewController = loader.getController();
            menuMedicoViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void abrirVistaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuAdministradorViewController menuAdministradorViewController = loader.getController();
            menuAdministradorViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void abrirCrudVistaDatosPersonales() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudDatosPersonales.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DatosPersonalesViewController datosPersonalesViewController = loader.getController();
            datosPersonalesViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void app(String[] args) {
        launch();
    }



    //servicios
    public void inicializarData(){

        Paciente paciente = new Paciente("24714234","Adriana Gomez",54,"606874102","Manzana 80",null,"A+");
        Usuario usuarioPaciente = new Usuario("agomez", "1234", paciente, TipoUsuario.PACIENTE);
        paciente.setTheUsuario(usuarioPaciente);
        hospital.getListaPacientes().add(paciente);


        Medico medico = new Medico("1054874201","Mateo Hernandez",30,"3145784101","Manzana 80",null,"1054874201",25,Especialidad.MEDICINA_GENERAL);
        Usuario usuarioMedico = new Usuario("mhernandez","1234",medico,TipoUsuario.MEDICO);
        medico.setTheUsuario(usuarioMedico);
        hospital.getListaMedicos().add(medico);

        Administrador administrador =new Administrador("100258138","Anderson Raba",35,"3125871145","Calle 35 N 11N-24",null,"Jefe Sistemas","Citas");
        Usuario usuarioAdmin=new Usuario("araba","2530",administrador,TipoUsuario.ADMINISTRADOR);
        administrador.setTheUsuario(usuarioAdmin);
        hospital.getListaAdministradores().add(administrador);

    }
    public Persona buscarUsuario(String usuario, String clave) {
        for (Paciente paciente : hospital.getListaPacientes()) {
            if (paciente.getTheUsuario().getUsuario().equals(usuario) && paciente.getTheUsuario().getContrasena().equals(clave)) {
                return paciente;
            }
        }
        for (Medico medico : hospital.getListaMedicos()) {
            if (medico.getTheUsuario().getUsuario().equals(usuario) && medico.getTheUsuario().getContrasena().equals(clave)) {
                return medico;
            }
        }
        for (Administrador administrador : hospital.getListaAdministradores()) {
            if(administrador.getTheUsuario().getUsuario().equals(usuario) && administrador.getTheUsuario().getContrasena().equals(clave)){
                return administrador;
            }
        }
        return null;
    }
}