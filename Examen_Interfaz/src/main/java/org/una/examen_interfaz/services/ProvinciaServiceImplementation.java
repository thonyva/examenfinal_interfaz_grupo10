/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;


import org.una.examen_interfaz.dtos.ProvinciaDTO;
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
public class ProvinciaServiceImplementation {
    
     public Respuesta CrearProvincia(ProvinciaDTO provincia) {
        try{
            Conexion request = new Conexion("http://localhost:8089/provincias/");
            request.post(provincia);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el provincia: "+request.getMensajeRespuesta());
            
            }
            ProvinciaDTO provinciaDto = (ProvinciaDTO) request.readEntity(ProvinciaDTO.class);
            return new Respuesta(true, "Provincia", provinciaDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerProvinciaes(){
    try{
            Conexion request = new Conexion("http://localhost:8089/provincias/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los provincias: "+request.getMensajeRespuesta()); 
            }
            List<ProvinciaDTO> provincias = (List<ProvinciaDTO>) request.readEntity(new GenericType<List<ProvinciaDTO>>(){});
            return new Respuesta(true, "Provincias", provincias);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarProvincia(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8089/provincias/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el provincia: "+request.getMensajeRespuesta());
            }
            ProvinciaDTO provinciaDto = (ProvinciaDTO) request.readEntity(ProvinciaDTO.class);
            return new Respuesta(true, "Provincia", provinciaDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

}

