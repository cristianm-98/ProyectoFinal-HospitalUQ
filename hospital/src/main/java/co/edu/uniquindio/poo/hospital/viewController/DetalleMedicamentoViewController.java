package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DetalleMedicamentoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarMedicamento;

    @FXML
    private Button btnAtras;

    @FXML
    private TableColumn<?, ?> columDescripcionMedic;

    @FXML
    private TableColumn<?, ?> columNombreMedic;

    @FXML
    private TableView<?> tblMedicamento;

    @FXML
    void onAgregarMedicamento(ActionEvent event) {

    }

    @FXML
    void onAtras(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnAgregarMedicamento != null : "fx:id=\"btnAgregarMedicamento\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert btnAtras != null : "fx:id=\"btnAtras\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert columDescripcionMedic != null : "fx:id=\"columDescripcionMedic\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert columNombreMedic != null : "fx:id=\"columNombreMedic\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";
        assert tblMedicamento != null : "fx:id=\"tblMedicamento\" was not injected: check your FXML file 'verDetalleMedicamento.fxml'.";

    }

}
