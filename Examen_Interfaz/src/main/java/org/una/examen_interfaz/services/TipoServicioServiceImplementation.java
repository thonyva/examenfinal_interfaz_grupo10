/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;

import java.util.List;
import javax.ws.rs.core.GenericType;
import org.una.examen_interfaz.dtos.ClienteDTO;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.TipoServicioDTO;

/**
 *
 * @author farle_000
 */
public class TipoServicioServiceImplementation {
    
    
    
    public Respuesta CrearTipoServicio(TipoServicioDTO tipoServicio) {
        try{
            Conexion request = new Conexion("http://localhost:8099/tipos_servicios/");
            request.post(tipoServicio);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo crear el tipo de servicio: "+request.getMensajeRespuesta());
            
            }
            TipoServicioDTO tipoServicioDto = (TipoServicioDTO) request.readEntity(TipoServicioDTO.class);
            return new Respuesta(true, "TipoServicio", tipoServicioDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

    public Respuesta ObtenerTiposServicios() {
    try{
            Conexion request = new Conexion("http://localhost:8099/tipos_servicios/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los tipos de servicios: "+request.getMensajeRespuesta()); 
            }
            List<TipoServicioDTO> tiposServicios = (List<TipoServicioDTO>) request.readEntity(new GenericType<List<TipoServicioDTO>>(){});
            return new Respuesta(true, "TiposServicios", tiposServicios);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
}
