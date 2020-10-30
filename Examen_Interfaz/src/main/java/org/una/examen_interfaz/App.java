package org.una.examen_interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import org.una.examen_interfaz.utils.FlowController;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
       stage.setTitle("Requerimientos UNA");   
       FlowController.getInstance().goMain();/*.goViewInWindow("ClienteView");*/
    }

    public static void main(String[] args) {
        launch();
    }

}