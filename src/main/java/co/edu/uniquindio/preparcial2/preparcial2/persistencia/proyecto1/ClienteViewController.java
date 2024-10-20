package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClienteViewController {
    ModelFactory modelFactory;
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    Cliente clienteSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<String> cbTipoDocumento;

    @FXML
    private TableView<Cliente> tblCliente;

    @FXML
    private TableColumn<Cliente, String> tcApellido;

    @FXML
    private TableColumn<Cliente, String> tcCodigo;

    @FXML
    private TableColumn<Cliente, String> tcDocumento;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TableColumn<Cliente, String> tcTelefono;

    @FXML
    private TableColumn<Cliente, String> tcTipoDocumento;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void onAgregar(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onNuevo(ActionEvent event) {
        limpiarCampos();
        deseleccionarTabla();
    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        cargarDatosComboBox();
        tblCliente.getItems().clear();
        tblCliente.setItems(listaClientes);
        listenerSelection();
    }

    private void initDataBinding() {
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tcDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDocumento()));
        tcTipoDocumento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoIdentificacion()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
    }

    private void obtenerClientes() {
        listaClientes.addAll(modelFactory.obtenerClientes());
    }

    private void cargarDatosComboBox() {
        ObservableList<String> tipoDocumento = FXCollections.observableArrayList("Cedula de Ciudadania",
                "Tarjeta de Identidad", "Cedula de Extranjeria", "Pasaporte");

        initializeComboBox(cbTipoDocumento, tipoDocumento, Function.identity());
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

    private void listenerSelection() {
        tblCliente.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                           oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if (clienteSeleccionado != null) {
            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtDocumento.setText(clienteSeleccionado.getDocumento());
            txtTelefono.setText(clienteSeleccionado.getTelefono());
            txtCodigo.setText(clienteSeleccionado.getCodigo());
            cbTipoDocumento.getSelectionModel().select(clienteSeleccionado.getTipoIdentificacion());
        }
    }

    private void agregarCliente() {
        Cliente cliente = construirCliente();
        if (validarDatos(cliente)) {
            if (modelFactory.agregarCliente(cliente)) {
                listaClientes.add(cliente);
                limpiarCampos();
                mostrarMensaje("Información", "Cliente agregado", "El cliente ha sido agregado correctamente.",
                        Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Cliente existente", "El cliente ya existe.", Alert.AlertType.ERROR);
            }
        }
    }

    private Cliente construirCliente() {
        return new Cliente(txtCodigo.getText(), txtDocumento.getText(), cbTipoDocumento.getValue(),
                txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());
    }

    private boolean validarDatos(Cliente cliente) {
        if (cliente.getCodigo().isEmpty() || cliente.getDocumento().isEmpty() || cliente.getTipoIdentificacion().isEmpty()
                || cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || cliente.getTelefono().isEmpty()) {
            mostrarMensaje("Error", "Campos vacíos", "Todos los campos deben estar llenos.", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtCodigo.setText("");
        cbTipoDocumento.getSelectionModel().clearSelection();
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void deseleccionarTabla() {
        tblCliente.getSelectionModel().clearSelection();
        clienteSeleccionado = null;
    }

}
