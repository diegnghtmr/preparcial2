package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.viewController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.controller.AsignacionController;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Asignacion;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Docente;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Estudiante;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.model.Materia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AsignacionViewController {
    AsignacionController asignacionController;
    private ObservableList<Asignacion> listaAsignacion = FXCollections.observableArrayList();
    private ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarEstudiante;

    @FXML
    private Button btnGuardarAsignacion;

    @FXML
    private Button btnLimpiarFormulario;

    @FXML
    private ComboBox<Docente> cbCodigoDocente;

    @FXML
    private ComboBox<Estudiante> cbCodigoEstudiante;

    @FXML
    private ComboBox<Materia> cbCodigoMateria;

    @FXML
    private TableView<Asignacion> tblAsignaciones;

    @FXML
    private TableColumn<Estudiante, String> tcApellidoEstudianteSub;

    @FXML
    private TableColumn<Asignacion, String> tcCodigoAsignacion;

    @FXML
    private TableColumn<Asignacion, String> tcCodigoDocente;

    @FXML
    private TableColumn<Estudiante, String> tcCodigoEstudianteSub;

    @FXML
    private TableColumn<Asignacion, String> tcCodigoMateria;

    @FXML
    private TableColumn<Asignacion, String> tcCodigosEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> tcNombreEstudianteSub;

    @FXML
    private TableColumn<Asignacion, String> tcNombreMateria;

    @FXML
    private TableView<Estudiante> tlbEstudiantesSub;

    @FXML
    private TextField txtCodigoAsignacion;

    @FXML
    private TextField txtNombreMateria;

    @FXML
    void onAgregarEstudiante(ActionEvent event) {
        agregarEstudiante();
    }

    @FXML
    void onGuardarAsignacion(ActionEvent event) {
        guardarAsignacion();
    }

    @FXML
    void onLimpiarFormulario(ActionEvent event) {
        limpiarFormulario();
    }

    @FXML
    void initialize() {
        asignacionController = new AsignacionController();
        initView();
        agregarListenerComboBoxMateria();
    }

    private void agregarListenerComboBoxMateria() {
        cbCodigoMateria.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtNombreMateria.setText(newValue.getNombre());
            }
        });
    }

    private void initView() {
        initDataBinding();
        obtenerAsignaciones();
        cargarDatosComboBox();
        tlbEstudiantesSub.getItems().clear();
        tlbEstudiantesSub.setItems(listaEstudiantes);
        tblAsignaciones.getItems().clear();
        tblAsignaciones.setItems(listaAsignacion);
    }

    private void initDataBinding() {
        tcCodigoEstudianteSub.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tcNombreEstudianteSub.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoEstudianteSub.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));

        tcCodigoAsignacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoAsignacion()));
        tcCodigoDocente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoDocente()));
        tcCodigoMateria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoMateria()));
        tcNombreMateria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreMateria()));
        tcCodigosEstudiantes.setCellValueFactory(cellData -> {
            List<String> codigoEstudiantes = cellData.getValue().getCodigoEstudiantes();
            String estudiantesStr = String.join(", ", codigoEstudiantes);
            return new SimpleStringProperty(estudiantesStr);
        });
    }

    private void obtenerAsignaciones() {
        listaAsignacion.addAll(asignacionController.obtenerAsignaciones());
    }

    private void cargarDatosComboBox() {
        ObservableList<Docente> listaDocentes = FXCollections.observableArrayList(
                asignacionController.obtenerDocentes());
        ObservableList<Materia> listaMaterias = FXCollections.observableArrayList(
                asignacionController.obtenerMaterias());
        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList(
                asignacionController.obtenerEstudiantes());

        initializeComboBox(cbCodigoDocente, listaDocentes, docente -> docente.getCodigo() +
                " | " + docente.getNombre() + " " + docente.getApellido());
        initializeComboBox(cbCodigoMateria, listaMaterias, materia -> materia.getCodigo() +
                " | " + materia.getNombre());
        initializeComboBox(cbCodigoEstudiante, listaEstudiantes, estudiante -> estudiante.getCodigo() +
                " | " + estudiante.getNombre() + " " + estudiante.getApellido());
    }

    private <T> void initializeComboBox(ComboBox<T> comboBox,
                                        ObservableList<T> items,
                                        Function<T, String> displayFunction) {
        comboBox.setItems(items);
        comboBox.setCellFactory(lv -> new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
        comboBox.setButtonCell(new ListCell<T>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : displayFunction.apply(item));
            }
        });
    }

    private void agregarEstudiante() {
        Estudiante estudiante = cbCodigoEstudiante.getSelectionModel().getSelectedItem();
        if (estudiante != null) {
            listaEstudiantes.add(estudiante);
            cbCodigoEstudiante.getItems().remove(estudiante);
        }
    }

    private void guardarAsignacion() {
        Asignacion asignacion = construirAsignacion();
        if (validarDatos(asignacion)) {
            if (asignacionController.guardarAsignacion(asignacion)) {
                listaAsignacion.add(asignacion);
                mostrarMensaje("Éxito", "Asignación guardada",
                        "La asignación se ha guardado correctamente", Alert.AlertType.INFORMATION);
                limpiarFormulario();
            } else {
                mostrarMensaje("Error", "Error al guardar asignación",
                        "No se ha podido guardar la asignación", Alert.AlertType.ERROR);
            }
        }
    }

    private Asignacion construirAsignacion() {
        String codigoAsignacion = txtCodigoAsignacion.getText();
        String codigoDocente = cbCodigoDocente.getSelectionModel().getSelectedItem().getCodigo();
        String codigoMateria = cbCodigoMateria.getSelectionModel().getSelectedItem().getCodigo();
        String nombreMateria = txtNombreMateria.getText();
        List<String> codigoEstudiantes = listaEstudiantes.stream().map(Estudiante::getCodigo).toList();

        return new Asignacion(codigoAsignacion, codigoMateria,
                nombreMateria, codigoDocente, codigoEstudiantes);
    }

    private boolean validarDatos(Asignacion asignacion) {
        if (asignacion.getCodigoAsignacion().isEmpty()) {
            mostrarMensaje("Error", "Error al guardar asignación",
                    "El código de la asignación no puede estar vacío", Alert.AlertType.ERROR);
            return false;
        }
        if (asignacion.getCodigoDocente().isEmpty()) {
            mostrarMensaje("Error", "Error al guardar asignación",
                    "El código del docente no puede estar vacío", Alert.AlertType.ERROR);
            return false;
        }
        if (asignacion.getCodigoMateria().isEmpty()) {
            mostrarMensaje("Error", "Error al guardar asignación",
                    "El código de la materia no puede estar vacío", Alert.AlertType.ERROR);
            return false;
        }
        if (asignacion.getNombreMateria().isEmpty()) {
            mostrarMensaje("Error", "Error al guardar asignación",
                    "El nombre de la materia no puede estar vacío", Alert.AlertType.ERROR);
            return false;
        }
        if (asignacion.getCodigoEstudiantes().isEmpty()) {
            mostrarMensaje("Error", "Error al guardar asignación",
                    "Debe agregar al menos un estudiante a la asignación", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }


    private void limpiarFormulario() {
        limpiarCampos();
        listaEstudiantes.clear();
    }

    private void limpiarCampos() {
        txtCodigoAsignacion.clear();
        cbCodigoDocente.getSelectionModel().clearSelection();
        cbCodigoMateria.getSelectionModel().clearSelection();
        cbCodigoEstudiante.getSelectionModel().clearSelection();
        txtNombreMateria.clear();
        tlbEstudiantesSub.getItems().clear();
    }


    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
