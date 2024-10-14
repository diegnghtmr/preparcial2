package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PedidoViewController {

    private ModelFactory modelFactory;
    private ObservableList<Producto> productosSeleccionados = FXCollections.observableArrayList();
    private ObservableList<Pedido> listaPedidos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<Cliente> cbCliente;

    @FXML
    private ComboBox<Producto> cbProductos;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TableView<Pedido> tblPedidos;

    @FXML
    private TableView<Producto> tblProductosSeleccionados;

    @FXML
    private TableColumn<Pedido, String> tcCliente;

    @FXML
    private TableColumn<Pedido, String> tcFecha;

    @FXML
    private TableColumn<Pedido, String> tcProductos;

    @FXML
    private TableColumn<Producto, String> tcProductoSeleccionado;

    @FXML
    private TableColumn<Pedido, Double> tcTotal;

    @FXML
    private TextField txtTotal;

    @FXML
    void onAgregarProducto(ActionEvent event) {
        agregarProducto();
    }

    @FXML
    void onGuardar(ActionEvent event) {
        guardarPedido();
    }

    @FXML
    void onNuevo(ActionEvent event) {
        nuevoPedido();
    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerPedidos();
        cargarDatosComboBox();
        tblProductosSeleccionados.getItems().clear();
        tblProductosSeleccionados.setItems(productosSeleccionados);
        tblPedidos.getItems().clear();
        tblPedidos.setItems(listaPedidos);
    }

    private void initDataBinding() {
        tcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        tcFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tcTotal.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotal()).asObject());
        tcProductoSeleccionado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcProductos.setCellValueFactory(cellData -> {
            List<Producto> productos = cellData.getValue().getListaProducto();
            String productosStr = productos.stream()
                    .map(Producto::getNombre)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
            return new SimpleStringProperty(productosStr);
        });
    }

    private void obtenerPedidos() {
        listaPedidos.addAll(modelFactory.obtenerPedidos());
    }

    private void cargarDatosComboBox() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(modelFactory.obtenerClientes());
        ObservableList<Producto> productos = FXCollections.observableArrayList(modelFactory.obtenerProductos());
        initializeComboBox(cbCliente, clientes, Cliente::getNombre);
        initializeComboBox(cbProductos, productos, Producto::getNombre);
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

    private void agregarProducto() {
        Producto producto = cbProductos.getSelectionModel().getSelectedItem();
        if (producto != null) {
            productosSeleccionados.add(producto);
            actualizarTotal();
        }
    }

    private void actualizarTotal() {
        double total = productosSeleccionados.stream().mapToDouble(Producto::getPrecio).sum();
        txtTotal.setText(String.valueOf(total));
    }

    private void guardarPedido() {
        Pedido pedido = construirPedido();
        if (validarDatos(pedido)) {
            if (modelFactory.agregarPedido(pedido)) {
                listaPedidos.add(pedido);
                limpiarCampos();
                mostrarMensaje("Éxito", "Pedido guardado", "El pedido ha sido guardado exitosamente.", Alert.AlertType.INFORMATION);
                nuevoPedido();
            } else {
                mostrarMensaje("Error", "Error al guardar", "Ha ocurrido un error al guardar el pedido.", Alert.AlertType.ERROR);
            }
        }
    }

    private Pedido construirPedido() {
        Cliente cliente = cbCliente.getSelectionModel().getSelectedItem();
        double total = productosSeleccionados.stream().mapToDouble(Producto::getPrecio).sum();
        return new Pedido(dpFecha.getValue(), total, cliente, new ArrayList<>(productosSeleccionados));
    }

    private boolean validarDatos(Pedido pedido) {
        if (pedido.getCliente() == null) {
            mostrarMensaje("Error", "Cliente no seleccionado", "Debe seleccionar un cliente.", Alert.AlertType.ERROR);
            return false;
        }
        if (pedido.getFecha() == null) {
            mostrarMensaje("Error", "Fecha no seleccionada", "Debe seleccionar una fecha.", Alert.AlertType.ERROR);
            return false;
        }
        if (pedido.getListaProducto().isEmpty()) {
            mostrarMensaje("Error", "Productos no seleccionados", "Debe seleccionar al menos un producto.", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    private void nuevoPedido() {
        limpiarCampos();
        productosSeleccionados.clear();
    }

    private void limpiarCampos() {
        cbCliente.getSelectionModel().clearSelection();
        cbProductos.getSelectionModel().clearSelection();
        txtTotal.clear();
        dpFecha.setValue(null);
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}