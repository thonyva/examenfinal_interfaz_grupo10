/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;


import org.una.examen_interfaz.dtos.UnidadDTO;
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
public class UnidadServiceImplementation {
    
     public Respuesta CrearUnidad(UnidadDTO unidad) {
        try{
            Conexion request = new Conexion("http://localhost:8089/unidades/");
            request.post(unidad);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el unidad: "+request.getMensajeRespuesta());
            
            }
            UnidadDTO unidadDto = (UnidadDTO) request.readEntity(UnidadDTO.class);
            return new Respuesta(true, "Unidad", unidadDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerUnidades(){
    try{
            Conexion request = new Conexion("http://localhost:8089/unidades/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los unidads: "+request.getMensajeRespuesta()); 
            }
            List<UnidadDTO> unidads = (List<UnidadDTO>) request.readEntity(new GenericType<List<UnidadDTO>>(){});
            return new Respuesta(true, "Unidads", unidads);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarUnidad(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8089/unidades/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el unidad: "+request.getMensajeRespuesta());
            }
            UnidadDTO unidadDto = (UnidadDTO) request.readEntity(UnidadDTO.class);
            return new Respuesta(true, "Unidad", unidadDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

}
