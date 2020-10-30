/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.utils;

import java.io.IOException;
//import java.lang.System.Logger.Level;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.una.examen_interfaz.App;
import org.una.examen_interfaz.controllers.Controller;


public class FlowController {

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
    private static ResourceBundle idioma;
    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();

    public FlowController() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (FlowController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage, ResourceBundle idioma) {
        getInstance();
        this.mainStage = stage;
        this.idioma = idioma;
    }
public void InitializarVentana(Stage stage, ResourceBundle idioma,String nombrefxml) {
         getInstance();
        this.mainStage = stage;
        this.idioma = idioma;
        
       FlowController.getInstance().goViewInWindow(nombrefxml); 
       
    }
public void goMain() {
        try {
            this.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/org/una/examen_interfaz/views/ClienteView.fxml"), this.idioma)));
            this.mainStage.setMinWidth(800);
            this.mainStage.setMinHeight(600);
            this.mainStage.show();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }
    private FXMLLoader getLoader(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                if (loader == null) {
                    try {
                        loader = new FXMLLoader(App.class.getResource("views/" + name + ".fxml"), this.idioma);
                        loader.load();
                        loaders.put(name, loader);
                    } catch (Exception ex) {
                        loader = null;
                        java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
                    }
                }
            }
        }
        return loader;
    }
    public void goMain(String nombre) {
        this.nombre = nombre;
        try {
            
            this.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("views/DashboardPrincipalView.fxml"), this.idioma)));
            
            goView(nombre);
            this.mainStage.show();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }
    

    public void goView(String viewName) {
        goView(viewName, "Center", null);
    }

    public void goView(String viewName, String accion) {
        goView(viewName, "Center", accion);
    }
    
public String nombre = "";
public String getNombre(){
System.out.println(nombre);
return nombre;
}
    public void goView(String viewName, String location, String accion) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(accion);
        controller.initialize();
        Stage stage = controller.getStage();
        if (stage == null) {
            stage = this.mainStage;
            controller.setStage(stage);
        }
        switch (location) {
            case "Center":
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().clear();
//                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).setFillWidth(true);
//                loader.getRoot().
//                HBox hb = new HBox();
                VBox.setVgrow(loader.getRoot(), Priority.ALWAYS);  
//                hb.getChildren().add(loader.getRoot());
                
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().add(loader.getRoot());
//                loader.getRoot().getClass().
                        
                   break;
            case "Top":
                break;
            case "Bottom":
                break;
            case "Right":
                break;
            case "Left":
                break;
            default:
                break;
        }
    }

    public void goViewInStage(String viewName, Stage stage) {
        
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
       
    }

    public void goViewInWindow(String viewName) {
        FXMLLoader loader = getLoader(viewName);
        System.out.println(loader);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
//        stage.getIcons().add(new Image("/org/una/interfaz/resources/.png"));
//        stage.setTitle("");   
        
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public void goViewInWindowModal(String viewName, Stage parentStage, Boolean resizable) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        this.parentStage = parentStage;
//        stage.getIcons().add(new Image("/org/una/interfaz/resources/.png"));
//        stage.setTitle("");   
        stage.setResizable(resizable);
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.centerOnScreen();
        stage.showAndWait();
        
    }
    public Stage parentStage=null;
     public void getNameParentStage(){
     System.out.println(getNameView(getController("VIEW")));
     
    }
    
      public String getNameView(Controller controller) {
        return controller.toString();
    }        
             
    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }

    public static void setIdioma(ResourceBundle idioma) {
        FlowController.idioma = idioma;
    }
    
    public void initialize() {
        this.loaders.clear();
    }

    public void salir() {
        this.mainStage.close();
    }

}
