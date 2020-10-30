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
import org.una.examen_interfaz.services.ClienteServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.ClienteDTO;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class ClienteViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;

    @FXML
    private JFXTextField txtNombreCompleto;

    @FXML
    private JFXCheckBox chkEstado;
    
    @FXML
    private JFXTextField txtCedula;

    @FXML
    private JFXButton btnSalir;

    @FXML
    private JFXButton btnGuardar;
    
    private final ClienteServiceImplementation service = new ClienteServiceImplementation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    void onActionButtonGuardar(ActionEvent event) {
          if (actionValidated()) {
              ClienteDTO cliente = new ClienteDTO();
              cliente.setNombreCompleto(txtNombreCompleto.getText());
              cliente.setCedula(txtCedula.getText());
              cliente.setEstado(chkEstado.isSelected());
              System.out.println(cliente);
            Respuesta respuesta = service.CrearCliente(cliente);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando clientes","Cliente agregado con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando clientes", "Error al crear el cliente.");
            }
          } 
    }
    
//    @FXML
//    void onActionButtonBuscar(ActionEvent event) {
//            if(txtId.getText()== null || txtId.getText().isEmpty()){
//            new Mensaje().showModal(Alert.AlertType.ERROR, "Búsqueda de cliente", (Stage) txtCedula.getScene().getWindow(), "Ingrese el id del cliente a buscar.");
//        }else{
//            Respuesta respuesta = service.BuscarCliente(Long.parseLong(txtId.getText()));
//            if (respuesta.getEstado()) {
//                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando clientes","Se encontró el cliente con éxito.");
//                
//                
//              ClienteDTO cliente = (ClienteDTO) respuesta.getResultado("Cliente");
//              txtNombreCompleto.setText(cliente.getNombreCompleto());
//              txtCedula.setText(cliente.getCedula());
//              chkEstado.setSelected(cliente.isEstado());
//              
//                }else {
//               new Mensaje().show(Alert.AlertType.ERROR, "Administrando clientes", "Error al crear el cliente.");
//            }
//            }
//    }

    @FXML
    void onActionButtonSalir(ActionEvent event) {

    }

    @Override
    public void initialize() {
    
    }
   private boolean actionValidated(){
        boolean bandera=false;
        
        try{
        if(txtCedula.getText()== null || txtCedula.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtCedula.getScene().getWindow(), "No puede existir un cliente sin cedula.");
        } else if (txtNombreCompleto.getText() == null || txtNombreCompleto.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtNombreCompleto.getScene().getWindow(), "No puede existir un cliente sin nombre.");
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtNombreCompleto.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera;
    }
   
   public void limpiarCampos(){
       txtNombreCompleto.setText("");
       chkEstado.setSelected(true);
       txtCedula.setText("");
      
   }

    
}
