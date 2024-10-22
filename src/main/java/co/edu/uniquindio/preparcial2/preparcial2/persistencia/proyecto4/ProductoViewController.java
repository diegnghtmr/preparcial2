package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto4;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductoViewController {
    ModelFactory modelFactory;
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnFiltrarCodigo;

    @FXML
    private TableView<Producto> tblProducto;

    @FXML
    private TableColumn<Producto, String> tcIdProducto;

    @FXML
    private TableColumn<Producto, String> tcIdProveedor;

    @FXML
    private TableColumn<Producto, String> tcNombreProducto;

    @FXML
    private TableColumn<Producto, String> tcPrecio;

    @FXML
    private TextField txtFiltrarCodigo;

    @FXML
    void onFiltrarCodigo(ActionEvent event) {
        filtrarCodigo();
    }

    private void filtrarCodigo() {
        String filtro = txtFiltrarCodigo.getText().toLowerCase();
        List<Producto> listaFiltrada =  new ArrayList<>();

        try {
            List<String> contenido = ArchivoUtil.leerArchivo(PersistenciaUtil.RUTA_ARCHIVO_PRODUCTO);
            for (String linea : contenido) {
                String[] atributos = linea.split("@@");
                if (filtro.isEmpty() || atributos[0].toLowerCase().contains(filtro)) {
                    Producto producto = new Producto(atributos[0], atributos[1], atributos[2], Double.parseDouble(atributos[3]));
                    listaFiltrada.add(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        listaProductos.setAll(listaFiltrada);
    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerRegistroCovid();
        tblProducto.getItems().clear();
        tblProducto.setItems(listaProductos);
    }

    private void initDataBinding() {
        tcIdProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProducto()));
        tcNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProducto()));
        tcIdProveedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProveedor()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
    }

    private void obtenerRegistroCovid() {
        listaProductos.addAll(modelFactory.obtenerProductos());
    }

}
