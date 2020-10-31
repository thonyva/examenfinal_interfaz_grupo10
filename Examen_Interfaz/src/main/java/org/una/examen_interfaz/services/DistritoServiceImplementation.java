/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;


import org.una.examen_interfaz.dtos.DistritoDTO;
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
public class DistritoServiceImplementation {
    
     public Respuesta CrearDistrito(DistritoDTO distrito) {
        try{
            Conexion request = new Conexion("http://localhost:8089/distritos/");
            request.post(distrito);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el distrito: "+request.getMensajeRespuesta());
            
            }
            DistritoDTO distritoDto = (DistritoDTO) request.readEntity(DistritoDTO.class);
            return new Respuesta(true, "Distrito", distritoDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerDistritos(){
    try{
            Conexion request = new Conexion("http://localhost:8089/distritos/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los distritos: "+request.getMensajeRespuesta()); 
            }
            List<DistritoDTO> distritos = (List<DistritoDTO>) request.readEntity(new GenericType<List<DistritoDTO>>(){});
            return new Respuesta(true, "Distritos", distritos);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarDistrito(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8089/distritos/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el distrito: "+request.getMensajeRespuesta());
            }
            DistritoDTO distritoDto = (DistritoDTO) request.readEntity(DistritoDTO.class);
            return new Respuesta(true, "Distrito", distritoDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

}
