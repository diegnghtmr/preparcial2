package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Proyecto1App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/persistencia/proyecto1/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oscar Gourmet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}