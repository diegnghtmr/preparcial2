package co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio2;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class Ejercicio2ViewController {
    private UniQuindio uniQuindio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<String> cbModalidad;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    void onBuscar(ActionEvent event) {
        buscar();
    }

    @FXML
    void onGuardar(ActionEvent event) {
        guardar();
    }

    @FXML
    void initialize() {
        cargarModalidades();
        cargarDatosIniciales();
    }

    private void cargarModalidades() {
        try (InputStream input = getClass().getResourceAsStream(Persistencia.MODALIDAD_ARCHIVO)) {
            Properties prop = new Properties();
            prop.load(input);
            cbModalidad.getItems().addAll(prop.getProperty("modalidad.distancia"), prop.getProperty("modalidad.presencial"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void cargarDatosIniciales() {
        String rutaArchivo = Persistencia.EJERCICIO2_XML_FILE_PATH;
        File archivo = new File(rutaArchivo);
        if (archivo.exists() && archivo.length() > 0) {
            try {
                uniQuindio = (UniQuindio) ArchivoUtil.cargarRecursoSerializadoXML(rutaArchivo);
                if (uniQuindio == null) {
                    uniQuindio = new UniQuindio();
                }
            } catch (IOException e) {
                e.printStackTrace();
                uniQuindio = new UniQuindio();
            }
        } else {
            uniQuindio = new UniQuindio();
        }
    }

    private List<Programa> cargarProgramas() {
        if (uniQuindio != null) {
            return uniQuindio.getProgramas();
        }
        return new ArrayList<>();
    }

    private void buscar() {
        String codigoBuscado = txtCodigo.getText();

        if (codigoBuscado.isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo de código no puede estar vacío.", Alert.AlertType.ERROR);
            return;
        }

        List<Programa> programas = cargarProgramas();

        for (Programa programa : programas) {
            if (programa.getCodigo().equals(codigoBuscado)) {
                txtNombre.setText(programa.getNombre());
                cbModalidad.setValue(programa.getModalidad());
                return;
            }
        }

        txtCodigo.setText("");
        txtNombre.setText("");
        cbModalidad.setValue(null);
    }

    private void guardar() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String modalidad = cbModalidad.getValue();

        if (codigo.isEmpty() || nombre.isEmpty() || modalidad == null) {
            mostrarMensaje("Error", "Campos vacíos", "Todos los campos deben estar llenos.", Alert.AlertType.ERROR);
            return;
        }

        Programa programa = new Programa(codigo, nombre, modalidad);
        uniQuindio.agregarPrograma(programa);

        String rutaArchivo = Persistencia.EJERCICIO2_XML_FILE_PATH;
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(rutaArchivo, uniQuindio);
            System.out.println("Datos guardados correctamente.");
            limpiarCampos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        cbModalidad.setValue(null);
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
