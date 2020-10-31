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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.una.examen_interfaz.dtos.UnidadDTO;
import org.una.examen_interfaz.services.UnidadServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author erikg
 */
public class RegistrarUnidadViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXComboBox<?> cbTipoUnidad;
    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXTextField txtExtension;
    @FXML
    private JFXTextField txtUnidad;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;
    
        
    @FXML
    private JFXCheckBox chkEstado;
    
    private final UnidadServiceImplementation service = new UnidadServiceImplementation();

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
              UnidadDTO unidad = new UnidadDTO();
              unidad.setUnidad(txtUnidad.getText());
              unidad.setCodigo(txtCodigo.getText());
              unidad.setEstado(chkEstado.isSelected());
              System.out.println(unidad);
            Respuesta respuesta = service.CrearUnidad(unidad);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando unidades","Unidad agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando unidad", "Error al crear el unidad.");
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
        if(txtUnidad.getText()== null || txtUnidad.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtUnidad.getScene().getWindow(), "No puede existir una unidad sin nombre.");
        } else if (txtCodigo.getText() == null || txtCodigo.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir una unidad sin codigo.");
        }else if (txtExtension.getText() == null || txtExtension.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCodigo.getScene().getWindow(), "No puede existir una unidad sin extensión.");
        
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtUnidad.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera; }

    private void limpiarCampos() {
      txtUnidad.setText("");
       chkEstado.setSelected(true);
       txtCodigo.setText("");
       txtExtension.setText(""); }
    
}
