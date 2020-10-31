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
 * @author erikg
 */
public class PoblacionViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnProvincia;
    @FXML
    private JFXButton btnCanton;
    @FXML
    private JFXButton btnDistrito;
    @FXML
    private JFXButton btnUnidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionButtonProvincia(ActionEvent event) {
         FlowController.getInstance().goViewInWindowModal("AdministracionProvinciaView",stage,false);
    }

    @FXML
    private void onActionButtonCanton(ActionEvent event) {
         FlowController.getInstance().goView("AdministracionCantonView");
    }

    @FXML
    private void onActionButtonDistrito(ActionEvent event) {
         FlowController.getInstance().goView("AdministracionDistritoView");
    }

    @FXML
    private void onActionButtonUnidad(ActionEvent event) {
         FlowController.getInstance().goView("AdministracionunidadView");
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
