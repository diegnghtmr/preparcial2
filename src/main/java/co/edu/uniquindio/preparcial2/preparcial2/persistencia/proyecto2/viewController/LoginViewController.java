package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {
    private LoginController loginController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtcontrasenia;

    @FXML
    void onLogin(ActionEvent event) {
        start(event);
    }

    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    private void start(ActionEvent actionEvent) {
        try {
            // Cargar las propiedades desde el archivo
            ResourceBundle properties = ResourceBundle.getBundle("persistencia/proyecto2/properties/usuario");

            // Obtener el usuario y la contraseña desde las propiedades
            String usuarioProp = properties.getString("usuario");
            String contraseniaProp = properties.getString("contrasenia");

            // Obtener los valores ingresados por el usuario
            String usuarioIngresado = txtUsuario.getText();
            String contraseniaIngresada = txtcontrasenia.getText();

            // Verificar si los valores coinciden
            if (usuarioProp.equals(usuarioIngresado) && contraseniaProp.equals(contraseniaIngresada)) {
                // Navegar a la siguiente ventana si la verificación es exitosa
                navegarVentana("/persistencia/proyecto2/view/asignacion-view.fxml", "Menú Principal", actionEvent);
            } else {
                // Mostrar un mensaje de error si la verificación falla
                mostrarMensaje("Error", "Error de autenticación", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navegarVentana(String nameFileFxml, String titleWindow, ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nameFileFxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(titleWindow);
            stage.show();

            cerrarVentana(actionEvent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cerrarVentana(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    protected void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
