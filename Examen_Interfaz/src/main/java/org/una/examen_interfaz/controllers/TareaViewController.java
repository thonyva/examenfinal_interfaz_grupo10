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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.una.examen_interfaz.services.TareaServiceImplementation;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.TareaDTO;

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
    private JFXButton btnRegresar;

    @FXML
    private JFXButton btnSalir;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private JFXButton btnEliminar;
    
    @FXML
    private JFXButton btnGuardar;
    
    private final TareaServiceImplementation service = new TareaServiceImplementation();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    void onActionButtonEliminar(ActionEvent event) {

    }

    @FXML
    private void onActionButtonGuardar(ActionEvent event) {
    if (actionValidated()) {
              TareaDTO tarea = new TareaDTO();
              tarea.setNombre(txtNombre.getText());
              tarea.setImportancia(txtImportancia.getText());
              System.out.println(tarea);
            Respuesta respuesta = service.CrearTarea(tarea);
            if (respuesta.getEstado()) {
                new Mensaje().show(Alert.AlertType.INFORMATION, "Tarea agregada con éxito!");
                limpiar();
                }else {
               new Mensaje().show(Alert.AlertType.ERROR, "Error al crear la tarea!");
            }
        } 
    }
        
    private boolean actionValidated(){
        boolean bandera=false;
        try{
        if(txtNombre.getText()== null || txtImportancia.getText().isEmpty()){
            bandera = false;
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación incorrecta", (Stage) txtNombre.getScene().getWindow(), "No puede existir una tarea sin nombre.");
        } else if (txtNombre.getText() == null || txtNombre.getText().isEmpty()){
                bandera = false;
                new Mensaje().showModal(Alert.AlertType.ERROR, "Validación incorrecta", (Stage) txtImportancia.getScene().getWindow(), "No puede existir una tarea sin importancia.");
        }else{
            bandera = true;
        }
        } catch (Exception ex){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Validación incorrecta", (Stage) txtUrgencia.getScene().getWindow(), "No puede existir una tarea sin urgencia.");
            bandera = false;
        }
        return bandera;
    }
 
    @FXML
    void onActionButtonLimpiar(ActionEvent event) {

    }

    @FXML
    void onActionButtonRegresar(ActionEvent event) {

    }
    
    public void limpiar(){
       txtNombre.setText("");
       txtUrgencia.setText("");
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}