package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductoViewController {
    ModelFactory modelFactory;
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    Producto productoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<Producto> tblProducto;

    @FXML
    private TableColumn<Producto, String> tcCodigo;

    @FXML
    private TableColumn<Producto, String> tcNombre;

    @FXML
    private TableColumn<Producto, String> tcPrecio;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    void onAgregar(ActionEvent event) {
        agregarProducto();
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
        obtenerProductos();
        tblProducto.getItems().clear();
        tblProducto.setItems(listaProductos);
        listenerSelection();
    }

    private void initDataBinding() {
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
    }

    private void obtenerProductos() {
        listaProductos.addAll(modelFactory.obtenerProductos());
    }

    private void listenerSelection() {
        tblProducto.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                            oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });
    }

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
        if (productoSeleccionado != null) {
            txtCodigo.setText(productoSeleccionado.getCodigo());
            txtNombre.setText(productoSeleccionado.getNombre());
            txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
        }
    }

    private void agregarProducto() {
        Producto producto = construirProducto();
        if (validarDatos(producto)) {
            if (modelFactory.agregarProducto(producto)) {
                listaProductos.add(producto);
                limpiarCampos();
                mostrarMensaje("Información", "Producto agregado", "El producto ha sido agregado correctamente.", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Producto no agregado", "El producto no ha sido agregado.", Alert.AlertType.ERROR);
            }
        }
    }

    private Producto construirProducto() {
        return new Producto(txtCodigo.getText(), txtNombre.getText(),
                Double.parseDouble(txtPrecio.getText()));
    }

    private boolean validarDatos(Producto producto) {
        if (producto.getCodigo().isEmpty() || producto.getNombre().isEmpty() || producto.getPrecio() == 0) {
            mostrarMensaje("Error", "Campos vacíos", "Todos los campos son obligatorios.", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    public void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void deseleccionarTabla() {
        tblProducto.getSelectionModel().clearSelection();
        productoSeleccionado = null;
    }

}
