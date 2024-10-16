package co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Proyecto3App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/persistencia/proyecto3/contenedor-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Oscar University");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}