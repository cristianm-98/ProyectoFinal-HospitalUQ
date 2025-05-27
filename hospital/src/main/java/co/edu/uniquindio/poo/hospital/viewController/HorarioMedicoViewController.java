package co.edu.uniquindio.poo.hospital.viewController;

import java.net.URL;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.stream.Collectors;

import co.edu.uniquindio.poo.hospital.App;
import co.edu.uniquindio.poo.hospital.model.HorarioAtencion;
import co.edu.uniquindio.poo.hospital.model.Medico;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HorarioMedicoViewController {
    private Medico medico;
    private App app;
    private ObservableList<HorarioAtencion> lista_horarios = FXCollections.observableArrayList();
    private ObservableList<LocalTime> allHoras = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<HorarioAtencion> btlHorarioM;

    @FXML
    private Button btnActualizarHorarioM;

    @FXML
    private Button btnAgregarHorarioM;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnEliminarHorarioM;

    @FXML
    private TableColumn<HorarioAtencion, String> columAtencion;

    @FXML
    private TableColumn<HorarioAtencion, LocalTime> columHorarioFinal;

    @FXML
    private TableColumn<HorarioAtencion, LocalTime> columHorarioInicio;

    @FXML
    private ComboBox<String> combDiaAtencion;

    @FXML
    private Label lbHoraFinal;

    @FXML
    private ComboBox<LocalTime> combHoraInicio;

    @FXML
    void onActualizarHorarioM(ActionEvent event) {
        HorarioAtencion horarioSeleccionado = btlHorarioM.getSelectionModel().getSelectedItem();
        if (horarioSeleccionado != null){
            if (horarioSeleccionado.getDia().equals(combDiaAtencion.getValue()) || horarioSeleccionado.getHoraInicio().equals(combHoraInicio.getValue())){
                horarioSeleccionado.setDia(combDiaAtencion.getValue());
                horarioSeleccionado.setHoraInicio(combHoraInicio.getValue());
                horarioSeleccionado.setHoraFinal(combHoraInicio.getValue().plusHours(1));
                filterHoras(combDiaAtencion.getValue());
                btlHorarioM.refresh();
                mostrarMensaje("Actualizacion", "Horario actualizado", "Se ha actualizado el horario con exito");
            }
        }

    }

    @FXML
    void onAgregarHorarioM(ActionEvent event) {
        if (combDiaAtencion.getValue() == null || combHoraInicio.getValue() == null){
            mostrarMensaje("Error", "Campos vacios", "Llene todos los campos");
        }
        else{
            String id = UUID.randomUUID().toString().replace("-", "");
            LocalTime horaFinal = combHoraInicio.getValue().plusHours(1);
            LocalTime horaInicio = combHoraInicio.getValue();
            String dia = combDiaAtencion.getValue();
            HorarioAtencion horarioAtencion = new HorarioAtencion(id,dia,horaInicio,horaFinal);
            medico.agregarHorarioAtencion(horarioAtencion);
            horarioAtencion.setTheMedico(medico);
            lista_horarios.add(horarioAtencion);
            filterHoras(combDiaAtencion.getValue());
            mostrarMensaje("Agregado", "Horario agregado", "Se ha agregado el horario con exito");
        }
        btlHorarioM.refresh();
    }

    @FXML
    void onAtras(ActionEvent event) {
        app.abrirVistaMedico(this.medico);
    }

    @FXML
    void onEliminarHorarioM(ActionEvent event) {
        HorarioAtencion horarioSeleccionado = btlHorarioM.getSelectionModel().getSelectedItem();
        if (horarioSeleccionado != null){
            medico.eliminarHorarioAtencion(horarioSeleccionado);
            lista_horarios.remove(horarioSeleccionado);
            mostrarMensaje("Eliminado", "Horario eliminado", "Se ha eliminado el horario con exito");
            filterHoras(combDiaAtencion.getValue());
        }
        else{
            mostrarMensaje("Error", "No se ha seleccionado ningun horario", "Por favor seleccione un horario");
        }
        btlHorarioM.refresh();
    }

    @FXML
    void initialize() {
        lbHoraFinal.setText("N/A");

        combDiaAtencion.setItems(FXCollections.observableArrayList(
                "Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"
        ));

        for (LocalTime t = LocalTime.of(7, 0); !t.isAfter(LocalTime.of(17, 45)); t = t.plusMinutes(15)) {
            allHoras.add(t);
        }

        combDiaAtencion.valueProperty().addListener((obs, old, day) -> {
            if (day != null) filterHoras(day);
        });

        btlHorarioM.getSelectionModel().selectedItemProperty().addListener((obs, o, sel) -> {
            if (sel != null) {
                combDiaAtencion.setValue(sel.getDia());
            }
        });

        combHoraInicio.valueProperty().addListener((obs, o, start) -> {
            lbHoraFinal.setText(start != null
                    ? start.plusHours(1).toString()
                    : "N/A"
            );
        });
    }

    public void initMedico(Medico medico) {
        this.medico = medico;
        lista_horarios.addAll(medico.getListaHorarioAtenciones());
        columAtencion.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getDia()));
        columHorarioInicio.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getHoraInicio()));
        columHorarioFinal.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getHoraFinal()));

        btlHorarioM.setItems(lista_horarios);

    }

    public void setApp(App app) {
        this.app = app;
    }
    private void mostrarMensaje(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    private void filterHoras(String dia) {

        List<HorarioAtencion> dayList = lista_horarios.stream()
                .filter(h -> h.getDia().equals(dia))
                .sorted(Comparator.comparing(HorarioAtencion::getHoraInicio))
                .collect(Collectors.toList());

        // Determine the earliest valid starting point
        LocalTime candidate = LocalTime.of(7, 0);
        for (HorarioAtencion h : dayList) {
            if (!candidate.isBefore(h.getHoraInicio()) && candidate.isBefore(h.getHoraFinal())) {
                candidate = h.getHoraFinal(); // Move candidate to the end of the overlapping horario
            }
        }


        LocalTime finalCandidate = candidate;
        ObservableList<LocalTime> avail = allHoras.filtered(t -> {
            LocalTime end = t.plusHours(1); // Assume each horario lasts 1 hour
            return !t.isBefore(finalCandidate) &&
                    dayList.stream().noneMatch(h ->
                            !(end.isBefore(h.getHoraInicio()) || t.isAfter(h.getHoraFinal()))
                    );
        });

        combHoraInicio.setItems(avail);

        if (!avail.isEmpty()) {
            combHoraInicio.setValue(avail.get(0));
            lbHoraFinal.setText(avail.get(0).plusHours(1).toString());
        } else {
            combHoraInicio.setValue(null);
            lbHoraFinal.setText("N/A");
        }
    }

}
