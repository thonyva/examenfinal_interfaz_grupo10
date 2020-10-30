/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class MembresiaViewController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField txtAño;
    @FXML
    private JFXTextField txtMontoTotal;
    @FXML
    private JFXComboBox<?> cbx;
    @FXML
    private JFXTextField txtPeriodicidad;
    @FXML
    private JFXComboBox<?> cbxCliente;
    @FXML
    private JFXComboBox<?> cbxTipoServicio;
    @FXML
    private JFXCheckBox chkEstado;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionButtonSalir(ActionEvent event) {
    }

    @FXML
    private void onActionButtonGuardar(ActionEvent event) {
    }
    
}
