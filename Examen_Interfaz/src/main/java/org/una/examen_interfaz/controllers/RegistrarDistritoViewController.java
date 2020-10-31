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
import org.una.examen_interfaz.dtos.DistritoDTO;
import org.una.examen_interfaz.services.DistritoServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;



/**
 * FXML Controller class
 *
 * @author erikg
 */
public class RegistrarDistritoViewController  extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField txtDistrito;
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
    
    private final DistritoServiceImplementation service = new DistritoServiceImplementation();

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
              DistritoDTO distrito = new DistritoDTO();
              distrito.setDistrito(txtDistrito.getText());
              distrito.setCodigo(txtCodigo.getText());
              distrito.setEstado(chkEstado.isSelected());
              System.out.println(distrito);
            Respuesta respuesta = service.CrearDistrito(distrito);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando distritos","Distrito agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando distrito", "Error al crear el distrito.");
            }
          } 
    }

    private boolean actionValidated() {
        boolean bandera=false;
        
        try{
        if(txtDistrito.getText()== null || txtDistrito.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtDistrito.getScene().getWindow(), "No puede existir un Distrito sin nombre.");
        } else if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir un Distrito sin codigo.");
        }else if (txtExtension.getText() == null || txtExtension.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir un Distrito sin extensión.");
        
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtDistrito.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera;}

    private void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize() {
       txtDistrito.setText("");
       chkEstado.setSelected(true);
       txtCodigo.setText("");
       txtExtension.setText("");}
    
}
