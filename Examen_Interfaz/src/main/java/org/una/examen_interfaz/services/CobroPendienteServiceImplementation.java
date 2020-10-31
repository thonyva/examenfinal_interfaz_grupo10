/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;

import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.CobroPendienteDTO;

/**
 *
 * @author farle_000
 */
public class CobroPendienteServiceImplementation {
    
    
    
    public Respuesta CrearCobroPendiente(CobroPendienteDTO cobroPendiente) {
        try{
            Conexion request = new Conexion("http://localhost:8099/cobros_pendientes//");
            request.post(cobroPendiente);
            System.out.println(cobroPendiente);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo crear el Cobro Pendiente: "+request.getMensajeRespuesta());
            
            }
            CobroPendienteDTO cobroPendienteDto = (CobroPendienteDTO) request.readEntity(CobroPendienteDTO.class);
            return new Respuesta(true, "CobroPendiente", cobroPendienteDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
}
