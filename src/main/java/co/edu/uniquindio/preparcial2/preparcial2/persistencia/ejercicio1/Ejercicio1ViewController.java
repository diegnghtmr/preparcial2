package co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio1;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.ArchivoUtil;
import co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Ejercicio1ViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

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
    }

    private void buscar() {
        String codigoBuscado = txtCodigo.getText();

        if (codigoBuscado.isEmpty()) {
            mostrarMensaje("Error", "Campo vacío", "El campo de código no puede estar vacío.", Alert.AlertType.ERROR);
            return;
        }

        String rutaArchivo = Persistencia.RUTA_ARCHIVO;

        try {
            ArrayList<String> contenido = ArchivoUtil.leerArchivo(rutaArchivo);

            for (String linea : contenido) {
                String[] datos = linea.split(",");
                if (datos[0].equals(codigoBuscado)) {
                    txtCodigo.setText(datos[0]);
                    txtNombre.setText(datos[1]);
                    txtNota1.setText(datos[2]);
                    txtNota2.setText(datos[3]);
                    txtNota3.setText(datos[4]);
                    return;
                }
            }

            txtCodigo.setText("");
            txtNombre.setText("");
            txtNota1.setText("");
            txtNota2.setText("");
            txtNota3.setText("");
        } catch (IOException e) {
            e.printStackTrace();
            ArchivoUtil.guardarRegistroLog("Error al buscar los datos: " + e.getMessage(), 3, "Buscar", Persistencia.RUTA_LOG);
        }
    }

    private void guardar() {
        // Retrieve data from text fields
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String nota1 = txtNota1.getText();
        String nota2 = txtNota2.getText();
        String nota3 = txtNota3.getText();

        if (codigo.isEmpty() || nombre.isEmpty() || nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty()) {
            mostrarMensaje("Error", "Campos vacíos", "Todos los campos deben estar llenos.", Alert.AlertType.ERROR);
            return;
        }

        String contenido = generarContenido(codigo, nombre, nota1, nota2, nota3);

        String rutaArchivo = Persistencia.RUTA_ARCHIVO;

        try {
            ArchivoUtil.guardarArchivo(rutaArchivo, contenido, true);
            limpiarCampos();
            ArchivoUtil.guardarRegistroLog("Datos guardados correctamente. Estudiante: " + nombre, 1, "Guardar", Persistencia.RUTA_LOG);
        } catch (IOException e) {
            e.printStackTrace();
            // Log the error
            ArchivoUtil.guardarRegistroLog("Error al guardar los datos: " + e.getMessage(), 3, "Guardar", Persistencia.RUTA_LOG);
        }
    }

    private String generarContenido(String codigo, String nombre, String nota1, String nota2, String nota3) {
        return codigo + "," + nombre + "," + nota1 + "," + nota2 + "," + nota3 + "\n";
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
