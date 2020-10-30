/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.una.examen_interfaz.dtos.TipoServicioDTO;
import org.una.examen_interfaz.services.TipoServicioServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class TipoServicioViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextArea txtArDescripcion;
    @FXML
    private JFXCheckBox chkEstado;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;
    
    private final TipoServicioServiceImplementation service = new TipoServicioServiceImplementation();

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
        if (actionValidated()) {
              TipoServicioDTO tipoServicio = new TipoServicioDTO();
              tipoServicio.setDescripción(txtArDescripcion.getText());
              tipoServicio.setEstado(chkEstado.isSelected());
              System.out.println(tipoServicio);
            Respuesta respuesta = service.CrearTipoServicio(tipoServicio);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando tipoServicios","TipoServicio agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando tipoServicios", "Error al crear el tipoServicio.");
            }
          } 
        
    }
    
      private boolean actionValidated(){
        boolean bandera=false;
        
        try{
        if(txtArDescripcion.getText()== null || txtArDescripcion.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtArDescripcion.getScene().getWindow(), "No puede existir un tipo de servicio sin descripción.");
        } else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtArDescripcion.getScene().getWindow(), "Surgió un error al consultar el sistema.");
            bandera = false;
        }
        return bandera;
    }
   
   public void limpiarCampos(){
       txtArDescripcion.setText("");
       chkEstado.setSelected(true);
      
   }

    @Override
    public void initialize() {
    
    }
    
}
