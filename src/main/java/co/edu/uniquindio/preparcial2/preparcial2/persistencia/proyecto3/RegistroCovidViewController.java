package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroCovidViewController {
    ModelFactory modelFactory;
    ObservableList<RegistroCovid> listaRegistroCovids = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnFiltrarComuna;

    @FXML
    private TableView<RegistroCovid> tblRegistroCovid;

    @FXML
    private TableColumn<RegistroCovid, String> tcCodigo;

    @FXML
    private TableColumn<RegistroCovid, String> tcFechaEntrega;

    @FXML
    private TableColumn<RegistroCovid, String> tcFechaRegistro;

    @FXML
    private TableColumn<RegistroCovid, String> tcNombreComuna;

    @FXML
    private TableColumn<RegistroCovid, String> tcNumeroHabitantes;

    @FXML
    private TableColumn<RegistroCovid, String> tcNumeroHabitantesCovid;

    @FXML
    private TableColumn<RegistroCovid, String> tcPorcentajeCovid;

    @FXML
    private TableColumn<RegistroCovid, String> tcSector;

    @FXML
    private TextField txtFiltrarComuna;

    @FXML
    void onFiltrarComuna(ActionEvent event) {
        filtarComuna();
    }


    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
        initView();
    }

    private void filtarComuna() {
        String filtro = txtFiltrarComuna.getText().toLowerCase();
        List<RegistroCovid> registrosFiltrados = new ArrayList<>();

        try {
            List<String> contenido = ArchivoUtil.leerArchivo(PersistenciaUtil.RUTA_ARCHIVO_REGISTROS_COVID);
            for (String linea : contenido) {
                String[] atributos = linea.split("##");
                String nombreComuna = atributos[1].toLowerCase();
                if (filtro.isEmpty() || nombreComuna.contains(filtro)) {
                    String codigo = atributos[0];
                    String sector = atributos[2];
                    int numeroHabitantes = Integer.parseInt(atributos[3]);
                    int numeroHabitantesConCovid = Integer.parseInt(atributos[4]);
                    String porcentajeCovid = atributos[5];
                    String fechaRegistro = atributos[6];
                    String fechaEntrega = atributos[7];

                    RegistroCovid registroCovid = new RegistroCovid(codigo, nombreComuna, sector,
                            numeroHabitantes, numeroHabitantesConCovid,
                            porcentajeCovid, fechaRegistro, fechaEntrega);

                    registrosFiltrados.add(registroCovid);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        listaRegistroCovids.setAll(registrosFiltrados);
    }



    private void initView() {
        initDataBinding();
        obtenerRegistroCovid();
        tblRegistroCovid.getItems().clear();
        tblRegistroCovid.setItems(listaRegistroCovids);
    }

    private void initDataBinding() {
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tcNombreComuna.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreComuna()));
        tcSector.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSector()));
        tcNumeroHabitantes.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroHabitantes())));
        tcNumeroHabitantesCovid.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroHabitantesCovid())));
        tcPorcentajeCovid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPorcentajeCovid()));
        tcFechaRegistro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaRegistro()));
        tcFechaEntrega.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEntrega()));
    }

    private void obtenerRegistroCovid() {
        listaRegistroCovids.addAll(modelFactory.obtenerRegistroCovid());
    }

















}
