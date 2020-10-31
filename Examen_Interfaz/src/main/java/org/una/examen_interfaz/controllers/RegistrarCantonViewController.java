/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.CantonDTO;
import org.una.examen_interfaz.services.CantonServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;



/**
 * FXML Controller class
 *
 * @author erikg
 */
public class RegistrarCantonViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXTextField txtCanton;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXTextField txtExtension;
    @FXML
    private JFXTextField txtProvincia;
    
    @FXML
    private JFXCheckBox chkEstado;
    
    private final CantonServiceImplementation service = new CantonServiceImplementation();
    

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
              CantonDTO canton = new CantonDTO();
              canton.setCanton(txtCanton.getText());
              canton.setCodigo(txtCodigo.getText());
              canton.setEstado(chkEstado.isSelected());
              System.out.println(canton);
            Respuesta respuesta = service.CrearCanton(canton);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando cantones","Canton agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando canton", "Error al crear el canton.");
            }
          } 
        
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean actionValidated() {
      boolean bandera=false;
        
        try{
        if(txtCanton.getText()== null || txtCanton.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCanton.getScene().getWindow(), "No puede existir un cantón sin nombre.");
        } else if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir un Canton sin codigo.");
        }else if (txtExtension.getText() == null || txtExtension.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir un Canton sin extensión.");
        
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCanton.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera;
    } 

   
      public void limpiarCampos(){
       txtCanton.setText("");
       chkEstado.setSelected(true);
       txtCodigo.setText("");
       txtExtension.setText("");
      
   }

    
}
