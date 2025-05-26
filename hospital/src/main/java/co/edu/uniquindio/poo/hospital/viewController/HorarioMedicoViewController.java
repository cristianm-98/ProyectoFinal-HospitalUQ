package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HorarioMedicoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> btlHorarioM;

    @FXML
    private Button btnActualizarHorarioM;

    @FXML
    private Button btnAgregarHorarioM;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarHorarioM;

    @FXML
    private TableColumn<?, ?> columAtencion;

    @FXML
    private TableColumn<?, ?> columHorarioFinal;

    @FXML
    private TableColumn<?, ?> columHorarioInicio;

    @FXML
    private ComboBox<?> combDiaAtencion;

    @FXML
    private ComboBox<?> combHoraFinal;

    @FXML
    private ComboBox<?> combHoraInicio;

    @FXML
    void onActualizarHorarioM(ActionEvent event) {

    }

    @FXML
    void onAgregarHorarioM(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void onEliminarHorarioM(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btlHorarioM != null : "fx:id=\"btlHorarioM\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert btnActualizarHorarioM != null : "fx:id=\"btnActualizarHorarioM\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert btnAgregarHorarioM != null : "fx:id=\"btnAgregarHorarioM\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert btnEliminarHorarioM != null : "fx:id=\"btnEliminarHorarioM\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert columAtencion != null : "fx:id=\"columAtencion\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert columHorarioFinal != null : "fx:id=\"columHorarioFinal\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert columHorarioInicio != null : "fx:id=\"columHorarioInicio\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert combDiaAtencion != null : "fx:id=\"combDiaAtencion\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert combHoraFinal != null : "fx:id=\"combHoraFinal\" was not injected: check your FXML file 'horarioMedico.fxml'.";
        assert combHoraInicio != null : "fx:id=\"combHoraInicio\" was not injected: check your FXML file 'horarioMedico.fxml'.";

    }

}
