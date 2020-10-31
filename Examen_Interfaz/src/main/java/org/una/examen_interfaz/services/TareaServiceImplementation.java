/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.examen_interfaz.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.TareaDTO;

/**
 *
 * @author thony
 */

public class TareaServiceImplementation {
    public Respuesta CrearTarea(TareaDTO tarea) {
        try{
            Conexion request = new Conexion("http://localhost:8099/tareas/");
            request.post(tarea);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el tarea: "+request.getMensajeRespuesta());
            
            }
            TareaDTO tareaDto = (TareaDTO) request.readEntity(TareaDTO.class);
            return new Respuesta(true, "Tarea", tareaDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerTareas(){
    try{
            Conexion request = new Conexion("http://localhost:8099/tareas/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los tareas: "+request.getMensajeRespuesta()); 
            }
            List<TareaDTO> tareas = (List<TareaDTO>) request.readEntity(new GenericType<List<TareaDTO>>(){});
            return new Respuesta(true, "Tareas", tareas);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarTarea(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8099/tareas/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el tarea: "+request.getMensajeRespuesta());
            }
            TareaDTO tareaDto = (TareaDTO) request.readEntity(TareaDTO.class);
            return new Respuesta(true, "Tarea", tareaDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }  
}