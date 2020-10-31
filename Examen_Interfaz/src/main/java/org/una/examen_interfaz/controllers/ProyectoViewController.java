/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author thony
 */

public class ProyectoViewController extends Controller implements Initializable {
    @FXML
    private JFXButton btnSalir;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXButton btnRegresar;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private JFXButton btnEliminar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    void onActionButtonEliminar(ActionEvent event) {

    }

    @FXML
    void onActionButtonGuardar(ActionEvent event) {

    }

    @FXML
    void onActionButtonLimpiar(ActionEvent event) {

    }

    @FXML
    void onActionButtonRegresar(ActionEvent event) {

    }

    @FXML
    void onActionButtonSalir(ActionEvent event) {

    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}