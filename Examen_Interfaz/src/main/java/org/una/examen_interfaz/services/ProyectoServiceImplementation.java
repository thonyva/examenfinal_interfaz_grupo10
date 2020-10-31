/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.examen_interfaz.services;

import org.una.examen_interfaz.dtos.ProyectoDTO;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;

/**
 *
 * @author thony
 */

public class ProyectoServiceImplementation {
    public Respuesta CrearProyecto(ProyectoDTO proyecto) {
        try{
            Conexion request = new Conexion("http://localhost:8099/proyectos/");
            request.post(proyecto);
            System.out.println(request.getMensajeRespuesta());
            System.out.println(proyecto);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo crear el proyecto: "+request.getMensajeRespuesta());
            }
            ProyectoDTO proyectoDto = (ProyectoDTO) request.readEntity(ProyectoDTO.class);
            return new Respuesta(true, "Proyecto", proyectoDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }   
}