package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StockSucursalViewController {
    ModelFactory modelFactory;
    ObservableList<StockSucursal> listaStockSucursal = FXCollections.observableArrayList();
    StockSucursal stockSucursalSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private ComboBox<Proveedor> cbIdProveedor;

    @FXML
    private ComboBox<Producto> cbNombreProducto;

    @FXML
    private ComboBox<Inventario> cbNombreSucursal;

    @FXML
    private TableView<StockSucursal> tblStockSucursal;

    @FXML
    private TableColumn<StockSucursal , String> tcCantidadStock;

    @FXML
    private TableColumn<StockSucursal , String> tcIdProveedor;

    @FXML
    private TableColumn<StockSucursal , String> tcNombreProducto;

    @FXML
    private TableColumn<StockSucursal , String> tcNombreSucursal;

    @FXML
    private TableColumn<StockSucursal , String> tcPrecioProducto;

    @FXML
    private TextField txtCantidadStock;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    void onAgregar(ActionEvent event) {
        agregarStockSucursal();
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
        txtCantidadStock.setEditable(false);
        txtPrecioProducto.setEditable(false);
    }

    private void initView() {
        initDataBinding();
        obtenerStockSucursal();
        cargarDatosComboBox();
        tblStockSucursal.getItems().clear();
        tblStockSucursal.setItems(listaStockSucursal);
        listenerSelection();
    }

    private void initDataBinding() {
        tcCantidadStock.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCantidadStock())));
        tcIdProveedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProveedor()));
        tcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        tcNombreSucursal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreSucursal()));
        tcPrecioProducto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecioProducto())));
    }

    private void obtenerStockSucursal() {
        listaStockSucursal.addAll(modelFactory.obtenerStockSucursal());
    }

    private void cargarDatosComboBox() {
        ObservableList<Proveedor> proveedores = FXCollections.observableArrayList(modelFactory.obtenerProveedores());
        ObservableList<Producto> productos = FXCollections.observableArrayList(modelFactory.obtenerProductos());
        ObservableList<Inventario> inventarios = FXCollections.observableArrayList(modelFactory.obtenerInventarios());

        initializeComboBox(cbIdProveedor, proveedores, Proveedor::getIdProveedor);
        initializeComboBox(cbNombreProducto, productos, Producto::getNombreProducto);
        initializeComboBox(cbNombreSucursal, inventarios, Inventario::getNombreSucursal);

        cbNombreProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtPrecioProducto.setText(String.valueOf(newSelection.getPrecio()));
            } else {
                txtPrecioProducto.clear();
            }
        });

        cbNombreSucursal.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtCantidadStock.setText(String.valueOf(newSelection.getCantidadStock()));
            } else {
                txtCantidadStock.clear();
            }
        });
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
        tblStockSucursal.getSelectionModel().selectedItemProperty().addListener((obs,
                                                                                 oldSelection, newSelection) -> {
           stockSucursalSeleccionado = newSelection;
            mostrarInformacionStockSucursal(stockSucursalSeleccionado);
        });
    }

    private void mostrarInformacionStockSucursal(StockSucursal stockSucursalSeleccionado) {
        if (stockSucursalSeleccionado != null) {
            txtCantidadStock.setText(String.valueOf(stockSucursalSeleccionado.getCantidadStock()));
            txtPrecioProducto.setText(String.valueOf(stockSucursalSeleccionado.getPrecioProducto()));
            cbIdProveedor.getSelectionModel().select(
                    cbIdProveedor.getItems().stream()
                            .filter(proveedor -> proveedor.getIdProveedor().equals(stockSucursalSeleccionado.getIdProveedor()))
                            .findFirst()
                            .orElse(null)
            );
            cbNombreProducto.getSelectionModel().select(
                    cbNombreProducto.getItems().stream()
                            .filter(producto -> producto.getNombreProducto().equals(stockSucursalSeleccionado.getNombreProducto()))
                            .findFirst()
                            .orElse(null)
            );
            cbNombreSucursal.getSelectionModel().select(
                    cbNombreSucursal.getItems().stream()
                            .filter(inventario -> inventario.getNombreSucursal().equals(stockSucursalSeleccionado.getNombreSucursal()))
                            .findFirst()
                            .orElse(null)
            );
        }
    }

    private void agregarStockSucursal() {
        StockSucursal stockSucursal = construirStockSucursal();
        if (validarDatos(stockSucursal)) {
            if (modelFactory.agregarStockSucursal(stockSucursal)) {
                listaStockSucursal.add(stockSucursal);
                limpiarCampos();
                mostrarMensaje("Información", "Stock de sucursal agregado", "El stock de sucursal ha sido agregado correctamente.",
                        Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "Stock de sucursal existente", "El stock de sucursal ya existe.", Alert.AlertType.ERROR);
            }
        }
    }

    private StockSucursal construirStockSucursal() {
        return new StockSucursal(
                cbIdProveedor.getSelectionModel().getSelectedItem().getIdProveedor(),
                cbNombreSucursal.getSelectionModel().getSelectedItem().getNombreSucursal(),
                cbNombreProducto.getSelectionModel().getSelectedItem().getNombreProducto(),
                Integer.parseInt(txtCantidadStock.getText()),
                Double.parseDouble(txtPrecioProducto.getText())
        );
    }

    private boolean validarDatos(StockSucursal stockSucursal) {
        if (stockSucursal.getIdProveedor().isEmpty()) {
            mostrarMensaje("Error", "Proveedor no seleccionado", "Seleccione un proveedor.", Alert.AlertType.ERROR);
            return false;
        }
        if (stockSucursal.getNombreProducto().isEmpty()) {
            mostrarMensaje("Error", "Producto no seleccionado", "Seleccione un producto.", Alert.AlertType.ERROR);
            return false;
        }
        if (stockSucursal.getNombreSucursal().isEmpty()) {
            mostrarMensaje("Error", "Sucursal no seleccionada", "Seleccione una sucursal.", Alert.AlertType.ERROR);
            return false;
        }
        if (stockSucursal.getCantidadStock() == 0) {
            mostrarMensaje("Error", "Cantidad no válida", "La cantidad no puede ser 0.", Alert.AlertType.ERROR);
            return false;
        }
        if (stockSucursal.getPrecioProducto() == 0) {
            mostrarMensaje("Error", "Precio no válido", "El precio no puede ser 0.", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    public void limpiarCampos() {
        txtCantidadStock.clear();
        txtPrecioProducto.clear();
        cbIdProveedor.getSelectionModel().clearSelection();
        cbNombreProducto.getSelectionModel().clearSelection();
        cbNombreSucursal.getSelectionModel().clearSelection();
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void deseleccionarTabla() {
        tblStockSucursal.getSelectionModel().clearSelection();
        stockSucursalSeleccionado = null;
    }


}
