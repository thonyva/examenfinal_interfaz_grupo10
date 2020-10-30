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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.una.examen_interfaz.services.MembresiaServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.dtos.TipoServicioDTO;
import org.una.examen_interfaz.dtos.ClienteDTO;
import org.una.examen_interfaz.dtos.MembresiaDTO;
import org.una.examen_interfaz.services.ClienteServiceImplementation;
import org.una.examen_interfaz.services.TipoServicioServiceImplementation;
import org.una.examen_interfaz.utils.Respuesta;

/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class MembresiaViewController extends Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField txtAño;
    @FXML
    private JFXTextField txtMontoTotal;
    @FXML
    private JFXTextField txtPeriodicidad;
    @FXML
    private JFXComboBox<String> cbxPeriodo;
    @FXML
    private JFXComboBox<ClienteDTO> cbxCliente;
    @FXML
    private JFXComboBox<TipoServicioDTO> cbxTipoServicio;
    @FXML
    private JFXCheckBox chkEstado;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnGuardar;

    private final MembresiaServiceImplementation service = new MembresiaServiceImplementation();
    private final ClienteServiceImplementation serviceCliente = new ClienteServiceImplementation();
    private final TipoServicioServiceImplementation serviceTipoServicio = new TipoServicioServiceImplementation();
    
    ArrayList<ClienteDTO> clientes = new ArrayList(); 
    ArrayList<TipoServicioDTO> tiposServicios = new ArrayList();
    ArrayList<String> periodosSeleccion = new ArrayList(); 
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializar();
    }    

    @FXML
    private void onActionButtonSalir(ActionEvent event) {
    }

    @FXML
    private void onActionButtonGuardar(ActionEvent event) {
        
        if (actionValidated()) {
              MembresiaDTO membresia = new MembresiaDTO();
              membresia.setTotalMonto(Long.parseLong(txtMontoTotal.getText()));
              membresia.setTotalAño(Integer.parseInt(txtAño.getText()));
              membresia.setCliente(cbxCliente.getValue());
              membresia.setTipoServicio(cbxTipoServicio.getValue());
              membresia.setPeriodicidad(Integer.parseInt(txtPeriodicidad.getText()));
              membresia.setEstado(chkEstado.isSelected());
              System.out.println(membresia);
            Respuesta respuesta = service.CrearMembresia(membresia);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando Membresias","Membresia agregada con éxito.");
                limpiarCampos();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Administrando Membresias", "Error al crear la membresia.");
            }
          }
    }
     private void inicializar(){
        obtenerClientes();
        obtenerTiposServicios();
        ElegirPeriodo();
        cbxCliente.getItems().addAll(clientes);
        cbxTipoServicio.getItems().addAll(tiposServicios);
        }
     private boolean actionValidated(){
        boolean bandera=false;
        
        try{
        if(txtAño.getText()== null || txtAño.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtAño.getScene().getWindow(), "No se puede crear una membresia sin los años de vigencia.");
        } else if (txtMontoTotal.getText() == null || txtMontoTotal.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtMontoTotal.getScene().getWindow(), "No se puede crear una membresia sin el monto total a pagar.");
        } else if (txtPeriodicidad.getText() == null || txtPeriodicidad.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtMontoTotal.getScene().getWindow(), "No se puede crear una membresia sin seleccionar un periodo de pago.");
        }else if (cbxCliente.getValue() == null ){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtMontoTotal.getScene().getWindow(), "No se puede crear una membresia sin seleccionar un cliente.");
        }else if (cbxTipoServicio.getValue() == null ){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtMontoTotal.getScene().getWindow(), "No se puede crear una membresia sin seleccionar un tipo de servicio.");
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación Incorrecta", (Stage) txtPeriodicidad.getScene().getWindow(), "Surgió un error al ingresar al sistema.");
            bandera = false;
        }
        return bandera;
    }
   
   public void limpiarCampos(){
       txtAño.setText("");
       txtMontoTotal.setText("");
       txtPeriodicidad.setText("");
       chkEstado.setSelected(true);
      
   }
    
   private void obtenerClientes(){
            Respuesta respuesta = serviceCliente.ObtenerClientes();
            if (respuesta.getEstado()) {
//                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando clientes","Clientes obtenidos con éxito.");
//                limpiarCampos();
                clientes.addAll((List<ClienteDTO>)respuesta.getResultado("Clientes"));
                
                }else {
//               new Mensaje().show(Alert.AlertType.ERROR, "Administrando clientes", "Error al crear el cliente.");
            }
   
   }
   
      private void obtenerTiposServicios(){
            Respuesta respuesta = serviceTipoServicio.ObtenerTiposServicios();
            if (respuesta.getEstado()) {
//                new Mensaje().show(Alert.AlertType.INFORMATION, "Administrando Servicios","Servicios obtenidos con éxito.");
//                limpiarCampos();
                tiposServicios.addAll((List<TipoServicioDTO>)respuesta.getResultado("TiposServicios"));
                
                }else {
//               new Mensaje().show(Alert.AlertType.ERROR, "Administrando Servicios", "Error al obtener servicios.");
            }
   
   }
      
    private void ElegirPeriodo(){
        periodosSeleccion.add("Anual");
        periodosSeleccion.add("Semestral");
        periodosSeleccion.add("Cuatrimestral");
        periodosSeleccion.add("Trimestral");
        periodosSeleccion.add("Bimensual");
        periodosSeleccion.add("Mensual");
            
        cbxPeriodo.getItems().addAll(periodosSeleccion);
        
    }
    
    
    
    private void ValidarPeriodicidad(){
        
       switch(cbxPeriodo.getValue()){
           case "Mensual":
               txtPeriodicidad.setText("1");
               break;
           case "Bimensual":
               txtPeriodicidad.setText("2");
               break;
           case "Trimestral":
               txtPeriodicidad.setText("3");
               break; 
           case "Cuatrimestral":
               txtPeriodicidad.setText("4");
               break;
           case "Semestral":
               txtPeriodicidad.setText("6");
               break;
           case "Anual":
               txtPeriodicidad.setText("12");
               break;    
           
       }
        
    }
    
  
   
    @Override
    public void initialize() {
    inicializar();
    }

    @FXML
    private void onActionMouseClickedPeriodo(ActionEvent event) {
         ValidarPeriodicidad();
    }
}
