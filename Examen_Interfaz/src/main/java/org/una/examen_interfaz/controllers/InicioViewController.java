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
import org.una.examen_interfaz.utils.FlowController;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class InicioViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnPoblaciones;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void onActionButtonPoblaciones(ActionEvent event) {
        FlowController.getInstance().goMain();
        this.getStage().close();
       
    }



    @Override
    public void initialize() {
    
    }
    
}
