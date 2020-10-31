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
import org.una.examen_interfaz.dtos.ProvinciaDTO;
import org.una.examen_interfaz.services.ProvinciaServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author erikg
 */
public class RegistrarProvinciaViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField txtProvincia;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXTextField txtExtension;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXCheckBox chkEstado;
    
    private final ProvinciaServiceImplementation service = new ProvinciaServiceImplementation();
    
    
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
              ProvinciaDTO provincia = new ProvinciaDTO();
              provincia.setProvincia(txtProvincia.getText());
              provincia.setCodigo(txtCodigo.getText());
              provincia.setEstado(chkEstado.isSelected());
              System.out.println(provincia);
            Respuesta respuesta = service.CrearProvincia(provincia);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando provincias","Provincia agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando provincia", "Error al crear el provincia.");
            }
          } 
    }

    
     

    private boolean actionValidated() {
        boolean bandera=false;
        
        try{
        if(txtProvincia.getText()== null || txtProvincia.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtProvincia.getScene().getWindow(), "No puede existir una Provincia sin nombre.");
        } else if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir una Provincia sin codigo.");
        }else if (txtExtension.getText() == null || txtExtension.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir una Provincia sin extensión.");
        
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtProvincia.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera;}

    private void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public void initialize() {
       txtProvincia.setText("");
       chkEstado.setSelected(true);
       txtCodigo.setText("");
       txtExtension.setText("");
    }
               
} 

