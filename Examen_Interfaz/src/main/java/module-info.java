module org.una.examen_interfaz {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.una.examen_interfaz to javafx.fxml;
    exports org.una.examen_interfaz;
}
