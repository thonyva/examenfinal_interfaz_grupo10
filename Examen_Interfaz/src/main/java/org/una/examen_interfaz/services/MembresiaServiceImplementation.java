/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;

import javafx.scene.control.Alert;
import org.una.examen_interfaz.dtos.MembresiaDTO;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Mensaje;
import org.una.examen_interfaz.utils.Respuesta;

/**
 *
 * @author farle_000
 */
public class MembresiaServiceImplementation {
    
    public Respuesta CrearMembresia(MembresiaDTO membresia) {
        try{
            Conexion request = new Conexion("http://localhost:8099/membresias/");
            request.post(membresia);
            System.out.println(request.getMensajeRespuesta());
            System.out.println(membresia);
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
