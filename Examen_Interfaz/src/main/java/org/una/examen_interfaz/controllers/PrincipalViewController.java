/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.una.examen_interfaz.utils.FlowController;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnPoblaciones;
    @FXML
    private JFXButton btnTareas;
    @FXML
    private JFXButton btnCobros;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
    
    }

    @FXML
    private void onActionButtonSalir(ActionEvent event) {
        
        FlowController.getInstance().goViewInWindow("InicioView");
        this.getStage().close();
    }

    @FXML
    private void onActionButtonPoblaciones(ActionEvent event) {
        
        FlowController.getInstance().goViewInWindow("PoblacionView");
    }

    @FXML
    private void onActionButtonTareas(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("TareaView");
    }

    @FXML
    private void onActionButtonCobros(ActionEvent event) {
        FlowController.getInstance().goView("GenerarCobrosView");
    }
    
}
