/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;


import org.una.examen_interfaz.dtos.CantonDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;


/**
 *
 * @author erikg
 */
public class CantonServiceImplementation {
    
     public Respuesta CrearCanton(CantonDTO canton) {
        try{
            Conexion request = new Conexion("http://localhost:8089/cantones/");
            request.post(canton);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el canton: "+request.getMensajeRespuesta());
            
            }
            CantonDTO cantonDto = (CantonDTO) request.readEntity(CantonDTO.class);
            return new Respuesta(true, "Canton", cantonDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerCantones(){
    try{
            Conexion request = new Conexion("http://localhost:8089/cantones/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los cantons: "+request.getMensajeRespuesta()); 
            }
            List<CantonDTO> cantons = (List<CantonDTO>) request.readEntity(new GenericType<List<CantonDTO>>(){});
            return new Respuesta(true, "Cantons", cantons);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarCanton(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8089/cantones/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el canton: "+request.getMensajeRespuesta());
            }
            CantonDTO cantonDto = (CantonDTO) request.readEntity(CantonDTO.class);
            return new Respuesta(true, "Canton", cantonDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

}
