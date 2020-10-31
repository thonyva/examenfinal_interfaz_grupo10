/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Alert;
import org.una.examen_interfaz.dtos.MembresiaDTO;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.CobroPendienteDTO;

/**
 *
 * @author farle_000
 */
public class MembresiaServiceImplementation {
    
    public Respuesta CrearMembresia(MembresiaDTO membresia) {
        try{
            Conexion request = new Conexion("http://localhost:8099/membresias//");
            System.out.println(request.getMensajeRespuesta());
            request.post(membresia);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo crear la membresia: "+request.getMensajeRespuesta());
            }
            MembresiaDTO membresiaDto = (MembresiaDTO) request.readEntity(MembresiaDTO.class);
            
            return new Respuesta(true, "Membresia", membresiaDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

   
}
