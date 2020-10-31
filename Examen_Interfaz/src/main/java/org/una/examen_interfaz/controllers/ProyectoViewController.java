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
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.una.examen_interfaz.dtos.ProyectoDTO;
import org.una.examen_interfaz.services.ProyectoServiceImplementation;
import org.una.examen_interfaz.services.ProyectoServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;

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
    @FXML
    private JFXTextField txtPorcentajeDeAvance;
    
    private final ProyectoServiceImplementation service = new ProyectoServiceImplementation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    void onActionButtonEliminar(ActionEvent event) {

    }

    @FXML
    private void onActionButtonGuardar(ActionEvent event) {
    if (actionValidated()) {
              ProyectoDTO proyecto = new ProyectoDTO();
              proyecto.setNombre(txtNombre.getText());
              proyecto.setPorcentajeAvance(txtPorcentajeDeAvance.getText());
              System.out.println(proyecto);
            Respuesta respuesta = service.CrearProyecto(proyecto);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Proyecto agregado con éxito!");
                limpiar();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Error al crear la proyecto!");
            }
        } 
    }
    
    private boolean actionValidated(){
        boolean bandera=false;
        if(txtNombre.getText()== null || txtPorcentajeDeAvance.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación incorrecta", (Stage) txtNombre.getScene().getWindow(), "No puede existir un proyecto sin nombre.");
        } else if (txtNombre.getText() == null || txtNombre.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación incorrecta", (Stage) txtPorcentajeDeAvance.getScene().getWindow(), "No puede existir un proyecto sin porcentaje de avance.");
        }else{
            bandera = true;
        }
        return bandera;
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
    
    public void limpiar(){
       txtNombre.setText("");
       txtPorcentajeDeAvance.setText("");
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}