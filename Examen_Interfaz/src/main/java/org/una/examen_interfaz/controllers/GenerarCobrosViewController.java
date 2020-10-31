/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.una.examen_interfaz.services.ClienteServiceImplementation;
import org.una.examen_interfaz.services.MembresiaServiceImplementation;
import org.una.examen_interfaz.services.TipoServicioServiceImplementation;
import org.una.examen_interfaz.services.CobroPendienteServiceImplementation;


/**
 * FXML Controller class
 *
 * @author farle_000
 */
public class GenerarCobrosViewController implements Initializable {

    @FXML
    private TreeView<String> tvTree;
    
    
    
    private final ClienteServiceImplementation clienteService= new ClienteServiceImplementation();
    private final TipoServicioServiceImplementation tipoServicioService= new TipoServicioServiceImplementation();
    private final MembresiaServiceImplementation membresiaService= new MembresiaServiceImplementation();
    private final CobroPendienteServiceImplementation cobroService= new CobroPendienteServiceImplementation();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     TreeItem<String> rootItem = new TreeItem<String> ("dsnfifjsdm");
     rootItem.setExpanded(true);
     for(int i=0;i<6;i++){
          TreeItem<String> item = new TreeItem<String> ("msj" + i);
          rootItem.getChildren().add(item);
                  
     }
//     TreeView<String> tree = new TreeView<String> (rootItem);
        tvTree.setRoot(rootItem);
    }    
    
}
