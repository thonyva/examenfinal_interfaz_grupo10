/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author thony
 */

public class TareaViewController extends Controller implements Initializable {
    
    @FXML
    private JFXTextField txtNombre;

    @FXML
    private JFXTextField txtImportancia;

    @FXML
    private JFXTextField txtPrioridad;

    @FXML
    private JFXTextField txtDescripcion;

    @FXML
    private JFXTextField txtUrgencia;

    @FXML
    private JFXComboBox<?> cbProyecto;

    @FXML
    private DatePicker dpFechaDeInicio;

    @FXML
    private DatePicker dpFechaDeFinalizacion;

    @FXML
    private JFXButton btnCalcular;

    @FXML
    private JFXTextField txtPorcentaje;

    @FXML
    private JFXButton btnCrear;

    @FXML
    private JFXButton btnRegresar;

    @FXML
    private JFXButton btnSalir;

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
    void onActionButtonCrear(ActionEvent event) {
    }

    @FXML
    void onActionButtonLimpiar(ActionEvent event) {

    }

    @FXML
    void onActionButtonRegresar(ActionEvent event) {

    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}