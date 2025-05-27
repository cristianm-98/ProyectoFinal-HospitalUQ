package co.edu.uniquindio.poo.hospital;

import co.edu.uniquindio.poo.hospital.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

import co.edu.uniquindio.poo.hospital.model.*;

public class App extends Application {

    private Stage loginStage;
    public static Hospital hospital_main = new Hospital("810000913", "Hospital UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.loginStage = primaryStage;
        this.loginStage.setTitle("Gestion de Hospital");
        abrirVistaLogin(true);
    }

    public void abrirVistaLogin(Boolean first_time) {
        if (first_time) {
            inicializarData();
        }
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

    //-----Vistas del Paciente----------
    public void abrirVistaPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuPacienteViewController menuPacienteViewController = loader.getController();
            menuPacienteViewController.setApp(this);
            menuPacienteViewController.setPaciente(paciente);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaDatosPersonalesPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudDatosPersonales.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DatosPersonalesViewController datosPersonalesViewController = loader.getController();
            datosPersonalesViewController.initPaciente(paciente);
            datosPersonalesViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirVistaSolicitarCitaPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudSolicitarCita.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SolicitarCitaViewController solicitarCitaViewController = loader.getController();
            solicitarCitaViewController.initPaciente(paciente);
            solicitarCitaViewController.setApp(this);
            solicitarCitaViewController.initHorarios(this.getHorarios());
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaCancelarCitaPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudCancelarCita.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CancelarCitaViewController CancelarCitaViewController = loader.getController();
            CancelarCitaViewController.initPaciente(paciente);
            CancelarCitaViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaHistorialPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudHistorialMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialMedicoViewController historialViewController = loader.getController();
            historialViewController.initPaciente(paciente);
            historialViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaDetallesHistorialPaciente(HistorialMedico historialMedico, Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("detalleHistorial.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DetalleHistorialViewController detalleHistorialViewController = loader.getController();
            detalleHistorialViewController.initPaciente(paciente);
            detalleHistorialViewController.initHistorial(historialMedico);
            detalleHistorialViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaNotificacionPaciente(Paciente paciente) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudNotificaciones.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            NotificacionViewController notificacionViewControllerViewController = loader.getController();
            notificacionViewControllerViewController.initPaciente(paciente);
            notificacionViewControllerViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //---------Finaliza Vista del paciente

    public void abrirVistaMedico(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MenuMedicoViewController menuMedicoViewController = loader.getController();
            menuMedicoViewController.setApp(this);
            menuMedicoViewController.setMedico(medico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirHistorialMedico(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudMedicoHistorial.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MedicoHistoialViewController medicoHistoialViewController = loader.getController();
            medicoHistoialViewController.setApp(this);
            medicoHistoialViewController.initMedico(medico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirDetalleHistorialMedico(HistorialMedico historialMedico, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("verDetalleMedicoHistorial.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VerDetalleMedicoHistorialViewController verDetalleMedicoHistorialViewController = loader.getController();
            verDetalleMedicoHistorialViewController.setApp(this);
            verDetalleMedicoHistorialViewController.initMedico(medico);
            verDetalleMedicoHistorialViewController.initHistorialMedico(historialMedico);

            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirDetalleExamenMedico(HistorialMedico historialMedico, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("verDetalleExamen.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DetalleExamenViewController detalleExamenViewController = loader.getController();
            detalleExamenViewController.setApp(this);
            detalleExamenViewController.initMedico(medico);
            detalleExamenViewController.initHistorialMedico(historialMedico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirDetalleTratamientoMedico(HistorialMedico historialMedico, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("verDetalleTratamiento.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DetalleTratamientoViewController detalletratamientoViewController = loader.getController();
            detalletratamientoViewController.setApp(this);
            detalletratamientoViewController.initMedico(medico);
            detalletratamientoViewController.initHistorialMedico(historialMedico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirDetalleMedicamentoMedico(HistorialMedico historialMedico, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("verDetalleMedicamento.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DetalleMedicamentoViewController detalleMedicamentoViewController = loader.getController();
            detalleMedicamentoViewController.setApp(this);
            detalleMedicamentoViewController.initMedico(medico);
            detalleMedicamentoViewController.initHistorialMedico(historialMedico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirAgregarPacienteMedico(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("listaPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ListaPacienteViewController listaPacienteViewController = loader.getController();
            listaPacienteViewController.setApp(this);
            listaPacienteViewController.initMedico(medico);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirAgregarDescDiagMedico(Paciente paciente, Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("diagnosticoDescripcion.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DiagnosticoDescripcion diagnosticoDescripcion = loader.getController();
            diagnosticoDescripcion.setApp(this);
            diagnosticoDescripcion.setMedico(medico);
            diagnosticoDescripcion.setPaciente(paciente);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirVistaNotificacionMedico(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudNotificaciones.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            NotificacionViewController notificacionViewControllerViewController = loader.getController();
            notificacionViewControllerViewController.initMedico(medico);
            notificacionViewControllerViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void abrirGestionHorarioMedico(Medico medico) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("horarioMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HorarioMedicoViewController horarioMedicoViewController = loader.getController();
            horarioMedicoViewController.initMedico(medico);
            horarioMedicoViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //---------Vista del administrador-----------
    public void abrirVistaAdministrador(Administrador administrador) {
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

    public void abrirVistaGestionPaciente(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudFormularioPaciente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DatosPacienteViewController datosPacienteViewController = loader.getController();
            datosPacienteViewController.setApp(this);
            datosPacienteViewController.initAdministrador(administrador);
            datosPacienteViewController.initPaciente(hospital_main);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirVistaGestionMedico(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudFormularioMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DatosMedicosViewController datosMedicosViewController = loader.getController();
            datosMedicosViewController.initAdministrador(administrador);
            datosMedicosViewController.initMedico(hospital_main);
            datosMedicosViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirVistaDetalleReporte(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("reporteDetalle.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReporteDetalleViewController reporteDetalleViewController = loader.getController();
            reporteDetalleViewController.initAdministrador(administrador);
            reporteDetalleViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirReporteCita(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("reporteCita.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReporteCitaViewController reporteCitaViewController = loader.getController();
            reporteCitaViewController.initAdministrador(administrador);
            reporteCitaViewController.initCita(hospital_main);
            reporteCitaViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirReporteMedico(Administrador administrador) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("reporteMedico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ReporteMedicoViewController reporteMedicoViewController = loader.getController();
            reporteMedicoViewController.initAdministrador(administrador);
            reporteMedicoViewController.initReporteMedico(hospital_main);
            reporteMedicoViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void abrirContraseniaRestaurar(Administrador administrador,Hospital hospital_main, String vistaAnterior) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("contraseniaRestaurar.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            ContraseniaRestaurarViewController contraseniaRestaurarViewController = loader.getController();
            contraseniaRestaurarViewController.initAdministrador(administrador);
            contraseniaRestaurarViewController.initListaPaciente(hospital_main);
            contraseniaRestaurarViewController.initListaMedico(hospital_main);
            contraseniaRestaurarViewController.setVistaAnterior(vistaAnterior);
            contraseniaRestaurarViewController.setApp(this);
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
    public void inicializarData() {

        //Hospital
        hospital_main = new Hospital("8100", "Hospital UQ");

        //Personas
        Usuario Ausuario1 = new Usuario("jlinares", "1234", null, TipoUsuario.ADMINISTRADOR);
        Administrador administrador1 = new Administrador("1234", "Julia Linares", 25, "256310", "Manzana 50", null, "Jefe de Clinica", "Citas");
        administrador1.setTheUsuario(Ausuario1);
        Ausuario1.setThePersona(administrador1);

        Usuario Ausuario2 = new Usuario("mrodriguez", "2345", null, TipoUsuario.ADMINISTRADOR);
        Administrador administrador2 = new Administrador("2345", "Maria Rodriguez", 30, "256311", "Manzana 51", null, "Coordinadora General", "Consultas");
        administrador2.setTheUsuario(Ausuario2);
        Ausuario2.setThePersona(administrador2);

        Usuario Ausuario3 = new Usuario("lgarcia", "3456", null, TipoUsuario.ADMINISTRADOR);
        Administrador administrador3 = new Administrador("3456", "Luis Garcia", 40, "256312", "Manzana 52", null, "Director Médico", "Urgencias");
        administrador3.setTheUsuario(Ausuario3);
        Ausuario3.setThePersona(administrador3);

        Usuario Musuario1 = new Usuario("jperez", "4567", null, TipoUsuario.MEDICO);
        Medico medico1 = new Medico("789", "Jose Perez", 25, "255673", "Manzana 65", null, "A525", 5, Especialidad.CIRUGIA_GENERAL);
        medico1.setTheUsuario(Musuario1);
        Musuario1.setThePersona(medico1);

        Usuario Musuario2 = new Usuario("aprada", "5678", null, TipoUsuario.MEDICO);
        Medico medico2 = new Medico("890", "Anderson Prada", 30, "255674", "Manzana 66", null, "A526", 6, Especialidad.MEDICINA_GENERAL);
        medico2.setTheUsuario(Musuario2);
        Musuario2.setThePersona(medico2);

        Usuario Musuario3 = new Usuario("jramirez", "7890", null, TipoUsuario.MEDICO);
        Medico medico3 = new Medico("892", "Jose Ramirez", 38, "255676", "Manzana 68", null, "C210", 10, Especialidad.GINECOLOGIA);
        medico3.setTheUsuario(Musuario3);
        Musuario3.setThePersona(medico3);

        Usuario pusuario1 = new Usuario("jmartinez", "6789", null, TipoUsuario.PACIENTE);
        Paciente paciente1 = new Paciente("3674", "Julian Martinez", 25, "255677", "Manzana 69", null, "A+");
        paciente1.setTheUsuario(pusuario1);
        pusuario1.setThePersona(paciente1);

        Usuario pusuario2 = new Usuario("jperez", "6789", null, TipoUsuario.PACIENTE);
        Paciente paciente2 = new Paciente("3626", "Josefa Perez", 25, "255677", "Manzana 69", null, "A+");
        paciente2.setTheUsuario(pusuario2);
        pusuario2.setThePersona(paciente2);

        Usuario pusuario3 = new Usuario("lcastillo", "6789", null, TipoUsuario.PACIENTE);
        Paciente paciente3 = new Paciente("1236", "Lucia Castillo", 29, "255678", "Manzana 70", null, "O-");
        paciente3.setTheUsuario(pusuario3);
        pusuario3.setThePersona(paciente3);

        //Consultorio medico
        ConsultorioMedico consultorioMedico1 = new ConsultorioMedico("2516", "Cuarto Cirurgico", true, (byte) 2);
        ConsultorioMedico consultorioMedico2 = new ConsultorioMedico("2517", "Consultorio Medicina General", true, (byte) 3);
        ConsultorioMedico consultorioMedico3 = new ConsultorioMedico("2518", "Consultorio Medicina General", true, (byte) 4);
        ConsultorioMedico consultorioMedico4 = new ConsultorioMedico("2519", "Cuarto Cirurgico", true, (byte) 5);
        ConsultorioMedico consultorioMedico5 = new ConsultorioMedico("2520", "Consultorio Ginecologia", true, (byte) 6);


        //Agregar a hospital
        hospital_main.agregarAdministrador(administrador1);
        hospital_main.agregarAdministrador(administrador2);
        hospital_main.agregarAdministrador(administrador3);
        hospital_main.agregarMedico(medico1);
        hospital_main.agregarMedico(medico2);
        hospital_main.agregarMedico(medico3);
        hospital_main.agregarPaciente(paciente1);
        hospital_main.agregarPaciente(paciente2);
        hospital_main.agregarPaciente(paciente3);
        hospital_main.agregarConsultorio(consultorioMedico1);
        hospital_main.agregarConsultorio(consultorioMedico2);
        hospital_main.agregarConsultorio(consultorioMedico3);
        hospital_main.agregarConsultorio(consultorioMedico4);
        hospital_main.agregarConsultorio(consultorioMedico5);

        //horario atencion
        HorarioAtencion horarioAtencion1 = new HorarioAtencion("2747", "Martes", LocalTime.of(9, 45), LocalTime.of(10, 45));
        HorarioAtencion horarioAtencion2 = new HorarioAtencion("2748", "Miércoles", LocalTime.of(8, 30), LocalTime.of(9, 30));
        HorarioAtencion horarioAtencion3 = new HorarioAtencion("2749", "Jueves", LocalTime.of(10, 0), LocalTime.of(11, 0));
        HorarioAtencion horarioAtencion4 = new HorarioAtencion("2750", "Viernes", LocalTime.of(9, 0), LocalTime.of(10, 0));
        HorarioAtencion horarioAtencion5 = new HorarioAtencion("2751", "Sábado", LocalTime.of(8, 0), LocalTime.of(9, 0));
        HorarioAtencion horarioAtencion6 = new HorarioAtencion("2752", "Lunes", LocalTime.of(7, 30), LocalTime.of(8, 30));
        HorarioAtencion horarioAtencion7 = new HorarioAtencion("2762", "Martes", LocalTime.of(12, 45), LocalTime.of(13, 45));
        HorarioAtencion horarioAtencion8 = new HorarioAtencion("2763", "Martes", LocalTime.of(13, 45), LocalTime.of(14, 45));
        HorarioAtencion horarioAtencion9 = new HorarioAtencion("2764", "Martes", LocalTime.of(14, 45), LocalTime.of(15, 45));
        HorarioAtencion horarioAtencion10 = new HorarioAtencion("2765", "Jueves", LocalTime.of(11, 00), LocalTime.of(12, 00));
        HorarioAtencion horarioAtencion11 = new HorarioAtencion("2766", "Jueves", LocalTime.of(12, 00), LocalTime.of(13, 00));
        HorarioAtencion horarioAtencion12 = new HorarioAtencion("2767", "Jueves", LocalTime.of(13, 00), LocalTime.of(14, 00));
        HorarioAtencion horarioAtencion13 = new HorarioAtencion("2768", "Sábado", LocalTime.of(9, 00), LocalTime.of(10, 00));
        HorarioAtencion horarioAtencion14 = new HorarioAtencion("2769", "Sábado", LocalTime.of(10, 00), LocalTime.of(11, 00));
        HorarioAtencion horarioAtencion15 = new HorarioAtencion("2770", "Sábado", LocalTime.of(11, 00), LocalTime.of(12, 00));


        //Medicamento

        Medicamento medicamento1 = new Medicamento("5256", "Suplemento de Hierro Oral", "Suplemento para incrementar los niveles de hemoglobina");
        Medicamento medicamento2 = new Medicamento("5257", "Metoprolol", "Betabloqueador prescrito para regular la actividad cardíaca");
        Medicamento medicamento3 = new Medicamento("5258", "Relajante Muscular", "Utilizado junto con reposo y fisioterapia para aliviar espasmos musculares");
        Medicamento medicamento4 = new Medicamento("5259", "Cefazolina", "Antibiótico profiláctico administrado antes de la cirugía");
        Medicamento medicamento5 = new Medicamento("5260", "Amoxicilina", "Antibiótico recetado para tratar la infección");
        Medicamento medicamento6 = new Medicamento("5261", "Enalapril", "Inhibidor de la ECA utilizado junto con dieta baja en sal para controlar la presión");


        //Historial medico
        // Historial para paciente 1
        HistorialMedico historialMedico1 = new HistorialMedico("25257", LocalDate.of(2025, 5, 8), "El paciente acudió por desmayo debido a la sangre, se realizó un examen de sangre", "Se encontró anemia en el paciente, se recomienda comer carnes para subir la hemoglobina", paciente1, medico1);
        HistorialMedico historialMedico2 = new HistorialMedico("25258", LocalDate.of(2025, 5, 12), "El paciente acudió por dolor en el pecho y dificultad para respirar, se realizó un electrocardiograma", "Se encontró alteraciones en la actividad cardíaca, se prescribe medicamento para regular la actividad cardíaca", paciente1, medico2);

        // Historial para paciente 2
        HistorialMedico historialMedico3 = new HistorialMedico("25259", LocalDate.of(2025, 5, 9), "La paciente acudió por dolor en la espalda, se realizó una radiografía", "Se encontró una fractura en la vértebra lumbar, se recomienda reposo y fisioterapia", paciente2, medico2);
        HistorialMedico historialMedico4 = new HistorialMedico("25260", LocalDate.of(2025, 5, 13), "La paciente acudió por dolor abdominal persistente, se realizó una tomografía", "Se encontró un tumor en el abdomen, se recomienda cirugía para eliminarlo", paciente2, medico2);

        // Historial para paciente 3 relacionado con examen5 y tratamiento5
        HistorialMedico historialMedico5 = new HistorialMedico("25261", LocalDate.of(2025, 5, 10), "El paciente acudió por fiebre y malestar general, se realizó un análisis de orina", "Se encontró infección urinaria, se prescribe antibiótico para tratarla", paciente3, medico3);
        HistorialMedico historialMedico6 = new HistorialMedico("25262", LocalDate.of(2025, 5, 14), "El paciente acudió por hipertensión, se realizó un ultrasonido", "Se encontró agrandamiento del corazón, se recomienda control regular y dieta baja en sal", paciente3, medico3);

        //Examen

        Examen examen1 = new Examen("2747", "Test de sangre", "Se examina hemoglobina", historialMedico1);
        Examen examen2 = new Examen("2748", "Electrocardiograma", "Se examina la actividad eléctrica del corazón", historialMedico2);
        Examen examen3 = new Examen("2749", "Radiografía", "Examen de imagen de rayos X para visualizar huesos", historialMedico3);
        Examen examen4 = new Examen("2750", "Tomografía", "Examen de imágenes de cortes transversales del cuerpo", historialMedico4);
        Examen examen5 = new Examen("2751", "Análisis de orina", "Examina la composición de la orina", historialMedico5);
        Examen examen6 = new Examen("2752", "Ultrasonido", "Examina los órganos internos utilizando ondas sonoras", historialMedico6);

        //Tratamiento

        Tratamiento tratamiento1 = new Tratamiento("6934", "Se indica comer carnes para subir la hemoglobina", historialMedico1);
        Tratamiento tratamiento2 = new Tratamiento("6935", "Se prescribe medicamento para regular la actividad cardíaca", historialMedico2);
        Tratamiento tratamiento3 = new Tratamiento("6936", "Se recomienda reposo y fisioterapia", historialMedico3);
        Tratamiento tratamiento4 = new Tratamiento("6937", "Se recomienda cirugía para eliminar el tumor", historialMedico4);
        Tratamiento tratamiento5 = new Tratamiento("6938", "Se prescribe antibiótico para tratar infección", historialMedico5);
        Tratamiento tratamiento6 = new Tratamiento("6939", "Se recomienda control regular y dieta baja en sal", historialMedico6);
        //Prescripcion medica

        PrescripcionMedica prescripcionMedica1 = new PrescripcionMedica("6345", medicamento1, historialMedico1);
        PrescripcionMedica prescripcionMedica2 = new PrescripcionMedica("6346", medicamento2, historialMedico2);
        PrescripcionMedica prescripcionMedica3 = new PrescripcionMedica("6347", medicamento3, historialMedico3);
        PrescripcionMedica prescripcionMedica4 = new PrescripcionMedica("6348", medicamento4, historialMedico4);
        PrescripcionMedica prescripcionMedica5 = new PrescripcionMedica("6349", medicamento5, historialMedico5);
        PrescripcionMedica prescripcionMedica6 = new PrescripcionMedica("6350", medicamento6, historialMedico6);

        // Cita

        Cita cita1 = new Cita("52385", LocalDate.of(2025, 5, 8), LocalTime.of(10, 0), LocalTime.of(10, 45), true, consultorioMedico1, paciente1, medico3);
        Cita cita2 = new Cita("52386", LocalDate.of(2025, 5, 12), LocalTime.of(7, 30), LocalTime.of(8, 15), true, consultorioMedico2, paciente1, medico3);
        Cita cita3 = new Cita("52387", LocalDate.of(2025, 5, 9), LocalTime.of(9, 0), LocalTime.of(9, 45), true, consultorioMedico3, paciente2, medico1);
        Cita cita4 = new Cita("52388", LocalDate.of(2025, 5, 13), LocalTime.of(13, 45), LocalTime.of(14, 30), true, consultorioMedico4, paciente2, medico1);
        Cita cita5 = new Cita("52389", LocalDate.of(2025, 5, 10), LocalTime.of(8, 15), LocalTime.of(9, 0), true, consultorioMedico5, paciente3, medico2);
        Cita cita6 = new Cita("52390", LocalDate.of(2025, 5, 14), LocalTime.of(8, 30), LocalTime.of(9, 15), true, consultorioMedico2, paciente3, medico2);

        // Notificacion
        Notificacion notificacion1 = new Notificacion("52586", LocalTime.of(8, 45), "Recuerde llegar 10 minutos antes.", true, paciente1);
        Notificacion notificacion2 = new Notificacion("52586", LocalTime.of(9, 35), "Recordatorio cita", true, medico1);

        Notificacion notificacion3 = new Notificacion("52587", LocalTime.of(10, 0), "Confirme su asistencia a la cita.", true, paciente1);
        Notificacion notificacion4 = new Notificacion("52588", LocalTime.of(10, 30), "Cita próxima en 30 minutos.", true, medico3);

        Notificacion notificacion5 = new Notificacion("52589", LocalTime.of(9, 45), "Recuerde traer exámenes anteriores.", true, paciente2);
        Notificacion notificacion6 = new Notificacion("52590", LocalTime.of(10, 15), "Diríjase al consultorio asignado.", true, medico2);

        Notificacion notificacion7 = new Notificacion("52591", LocalTime.of(13, 0), "Cita programada para esta tarde.", true, paciente2);
        Notificacion notificacion8 = new Notificacion("52592", LocalTime.of(13, 30), "Prepare el expediente del paciente.", true, medico1);

        Notificacion notificacion9 = new Notificacion("52593", LocalTime.of(7, 45), "Recuerde asistir en ayunas.", true, paciente3);
        Notificacion notificacion10 = new Notificacion("52594", LocalTime.of(8, 0), "Paciente con cita a las 8:15.", true, medico3);

        Notificacion notificacion11 = new Notificacion("52595", LocalTime.of(13, 0), "Cita médica en una hora.", true, paciente3);
        Notificacion notificacion12 = new Notificacion("52596", LocalTime.of(13, 15), "Paciente próximo en agenda.", true, medico2);


        // Agregar a cada una de las clases

        //Paciente

        paciente1.agregarNotificacion(notificacion1);
        paciente1.agregarNotificacion(notificacion3);
        paciente2.agregarNotificacion(notificacion5);
        paciente2.agregarNotificacion(notificacion7);
        paciente3.agregarNotificacion(notificacion9);
        paciente3.agregarNotificacion(notificacion11);

        paciente1.agregarCita(cita1);
        paciente1.agregarCita(cita2);
        paciente2.agregarCita(cita3);
        paciente2.agregarCita(cita4);
        paciente3.agregarCita(cita5);
        paciente3.agregarCita(cita6);

        paciente1.agregarHistorial(historialMedico1);
        paciente1.agregarHistorial(historialMedico2);
        paciente2.agregarHistorial(historialMedico3);
        paciente2.agregarHistorial(historialMedico4);
        paciente3.agregarHistorial(historialMedico5);
        paciente3.agregarHistorial(historialMedico6);

        //Medicos

        medico1.agregarHistorial(historialMedico1);
        medico1.agregarHistorial(historialMedico2);
        medico2.agregarHistorial(historialMedico3);
        medico2.agregarHistorial(historialMedico4);
        medico3.agregarHistorial(historialMedico5);
        medico3.agregarHistorial(historialMedico6);

        medico1.agregarNotificacion(notificacion2);
        medico1.agregarNotificacion(notificacion8);
        medico2.agregarNotificacion(notificacion6);
        medico2.agregarNotificacion(notificacion12);
        medico3.agregarNotificacion(notificacion4);
        medico3.agregarNotificacion(notificacion12);

        medico1.agregarHorarioAtencion(horarioAtencion1);
        medico2.agregarHorarioAtencion(horarioAtencion2);
        medico3.agregarHorarioAtencion(horarioAtencion3);
        medico1.agregarHorarioAtencion(horarioAtencion4);
        medico2.agregarHorarioAtencion(horarioAtencion5);
        medico3.agregarHorarioAtencion(horarioAtencion6);
        medico1.agregarHorarioAtencion(horarioAtencion7);
        medico1.agregarHorarioAtencion(horarioAtencion8);
        medico1.agregarHorarioAtencion(horarioAtencion9);
        medico2.agregarHorarioAtencion(horarioAtencion10);
        medico2.agregarHorarioAtencion(horarioAtencion11);
        medico2.agregarHorarioAtencion(horarioAtencion12);
        medico3.agregarHorarioAtencion(horarioAtencion13);
        medico3.agregarHorarioAtencion(horarioAtencion14);
        medico3.agregarHorarioAtencion(horarioAtencion15);

        horarioAtencion1.setTheMedico(medico1);
        horarioAtencion2.setTheMedico(medico2);
        horarioAtencion3.setTheMedico(medico3);
        horarioAtencion4.setTheMedico(medico1);
        horarioAtencion5.setTheMedico(medico2);
        horarioAtencion6.setTheMedico(medico3);
        horarioAtencion7.setTheMedico(medico1);
        horarioAtencion8.setTheMedico(medico1);
        horarioAtencion9.setTheMedico(medico1);
        horarioAtencion10.setTheMedico(medico2);
        horarioAtencion11.setTheMedico(medico2);
        horarioAtencion12.setTheMedico(medico2);
        horarioAtencion13.setTheMedico(medico3);
        horarioAtencion14.setTheMedico(medico3);
        horarioAtencion15.setTheMedico(medico3);

        medico3.agregarCita(cita1);
        medico3.agregarCita(cita2);
        medico1.agregarCita(cita3);
        medico1.agregarCita(cita4);
        medico2.agregarCita(cita5);
        medico2.agregarCita(cita6);

        // Historial medico

        historialMedico1.agregarExamen(examen1);
        historialMedico2.agregarExamen(examen2);
        historialMedico3.agregarExamen(examen3);
        historialMedico4.agregarExamen(examen4);
        historialMedico5.agregarExamen(examen5);
        historialMedico6.agregarExamen(examen6);

        historialMedico1.agregarTratamiento(tratamiento1);
        historialMedico2.agregarTratamiento(tratamiento2);
        historialMedico3.agregarTratamiento(tratamiento3);
        historialMedico4.agregarTratamiento(tratamiento4);
        historialMedico5.agregarTratamiento(tratamiento5);
        historialMedico6.agregarTratamiento(tratamiento6);

        historialMedico1.agregarPrescripcion(prescripcionMedica1);
        historialMedico2.agregarPrescripcion(prescripcionMedica2);
        historialMedico3.agregarPrescripcion(prescripcionMedica3);
        historialMedico4.agregarPrescripcion(prescripcionMedica4);
        historialMedico5.agregarPrescripcion(prescripcionMedica5);
        historialMedico6.agregarPrescripcion(prescripcionMedica6);

        // Medicamento

        medicamento1.agregarPrescripcion(prescripcionMedica1);
        medicamento2.agregarPrescripcion(prescripcionMedica2);
        medicamento3.agregarPrescripcion(prescripcionMedica3);
        medicamento4.agregarPrescripcion(prescripcionMedica4);
        medicamento5.agregarPrescripcion(prescripcionMedica5);
        medicamento6.agregarPrescripcion(prescripcionMedica6);

        // Consultorio medico

        consultorioMedico1.agregarCita(cita1);
        consultorioMedico2.agregarCita(cita2);
        consultorioMedico3.agregarCita(cita3);
        consultorioMedico4.agregarCita(cita4);
        consultorioMedico5.agregarCita(cita5);
        consultorioMedico3.agregarCita(cita6);

    }

    public Persona buscarUsuario(String usuario, String clave) {
        for (Paciente paciente : hospital_main.getListaPacientes()) {
            if (paciente.getTheUsuario().getUsuario().equals(usuario) && paciente.getTheUsuario().getContrasena().equals(clave)) {
                return paciente;
            }
        }
        for (Medico medico : hospital_main.getListaMedicos()) {
            if (medico.getTheUsuario().getUsuario().equals(usuario) && medico.getTheUsuario().getContrasena().equals(clave)) {
                return medico;
            }
        }
        for (Administrador administrador : hospital_main.getListaAdministradores()) {
            if (administrador.getTheUsuario().getUsuario().equals(usuario) && administrador.getTheUsuario().getContrasena().equals(clave)) {
                return administrador;
            }
        }
        return null;
    }

    public LinkedList<HorarioAtencion> getHorarios() {
        LinkedList<HorarioAtencion> listaHorarios = new LinkedList<>();
        for (Medico medico : hospital_main.getListaMedicos()) {
            for (HorarioAtencion horarioAtencion : medico.getListaHorarioAtenciones()) {
                for (Cita cita : medico.getListaCitas()) {
                    DateTimeFormatter fmtEspanol = DateTimeFormatter.ofPattern("EEEE", new Locale("es", "ES"));
                    String dia = cita.getDia().format(fmtEspanol);
                    if ((cita.isEstado()) && !(horarioAtencion.getDia().equalsIgnoreCase(dia) && horarioAtencion.getHoraInicio().equals(cita.getHoraInicio()))) {
                        listaHorarios.add(horarioAtencion);
                    }
                }
            }
        }

        return listaHorarios;
    }

    public ConsultorioMedico getConsultorioMedico(LocalDate dia, LocalTime horaInicio) {
        LinkedList<ConsultorioMedico> listaConsultorios = new LinkedList<>(hospital_main.getListaConsultorioMedicos());
        LinkedList<ConsultorioMedico> consultoriosDisponibles = new LinkedList<>();

        for (ConsultorioMedico consultorioMedico : listaConsultorios) {
            boolean consultorioDisponible = true;
            for (Cita cita : consultorioMedico.getListaCitas()) {
                if (cita.isEstado() && dia.equals(cita.getDia()) && horaInicio.equals(cita.getHoraInicio())) {
                    consultorioDisponible = false;
                    break;
                }
            }
            if (consultorioDisponible) {
                consultoriosDisponibles.add(consultorioMedico);
            }
        }

        if (consultoriosDisponibles.isEmpty()) {
            throw new IllegalStateException("No hay consultorios disponibles para la fecha y hora seleccionada");
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(consultoriosDisponibles.size());
        return consultoriosDisponibles.get(randomIndex);

    }

    public LocalDate getDia(HorarioAtencion horarioAtencion) {
        DayOfWeek dia = null;
        switch (horarioAtencion.getDia().toLowerCase()) {
            case "lunes":
                dia = DayOfWeek.MONDAY;
            case "martes":
                dia = DayOfWeek.TUESDAY;
            case "miércoles":
                dia = DayOfWeek.WEDNESDAY;
            case "jueves":
                dia = DayOfWeek.THURSDAY;
            case "viernes":
                dia = DayOfWeek.FRIDAY;
            case "sábado":
                dia = DayOfWeek.SATURDAY;
            case "domingo":
                dia = DayOfWeek.SUNDAY;
        }

        LocalDate dia_elegido;
        Medico medico = horarioAtencion.getTheMedico();
        LocalDate fecha_actual = LocalDate.now();
        Boolean cita_encontrada;
        while (true) {
            LocalDate next_day = fecha_actual.with(TemporalAdjusters.nextOrSame(dia));
            cita_encontrada = false;
            for (Cita cita : medico.getListaCitas()) {
                if (cita.getDia().equals(next_day)) {
                    cita_encontrada = true;
                    break;
                }
            }
            if (!cita_encontrada) {
                dia_elegido = next_day;
                break;
            }
            fecha_actual = fecha_actual.plusDays(1);
        }
        return dia_elegido;
    }

    public boolean verificarID(String id) {
        for (Paciente paciente : hospital_main.getListaPacientes()) {
            if (paciente.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Medicamento> getMedicamentos() {
        LinkedList<Medicamento> listaMedicamentos = new LinkedList<>();
        for (Medico medico : hospital_main.getListaMedicos()) {
            for (HistorialMedico historialMedico : medico.getListaHistorialMedicos()) {
                for (PrescripcionMedica prescripcionMedica : historialMedico.getListaPrescripcionMedicas()) {
                    if (!(listaMedicamentos.contains(prescripcionMedica.getTheMedicamentos()))) {
                        listaMedicamentos.add(prescripcionMedica.getTheMedicamentos());
                    }
                }
            }
        }
        return listaMedicamentos;
    }

    public LinkedList<Paciente> getPacientes() {
        return hospital_main.getListaPacientes();
    }
}