module co.edu.uniquindio.preparcial2.preparcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens co.edu.uniquindio.preparcial2.preparcial2 to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio1;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio1 to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio2;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.ejercicio2 to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.utils to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto1 to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2 to javafx.fxml;
    exports co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.viewController;
    opens co.edu.uniquindio.preparcial2.preparcial2.persistencia.proyecto2.viewController to javafx.fxml;
}