/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen_interfaz.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.Alert;
import javax.ws.rs.core.GenericType;
import org.una.examen_interfaz.utils.Conexion;
import org.una.examen_interfaz.utils.Respuesta;
import org.una.examen_interfaz.dtos.ClienteDTO;
import org.una.examen_interfaz.utils.Mensaje;
/**
 *
 * @author farle_000
 */
public class ClienteServiceImplementation {
    
    public Respuesta CrearCliente(ClienteDTO cliente) {
        try{
            Conexion request = new Conexion("http://localhost:8099/clientes/");
            request.post(cliente);
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo crear el cliente: "+request.getMensajeRespuesta());
            
            }
            ClienteDTO clienteDto = (ClienteDTO) request.readEntity(ClienteDTO.class);
            return new Respuesta(true, "Cliente", clienteDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }
    
    public Respuesta ObtenerClientes(){
    try{
            Conexion request = new Conexion("http://localhost:8099/clientes/");
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se puedo obtener los clientes: "+request.getMensajeRespuesta()); 
            }
            List<ClienteDTO> clientes = (List<ClienteDTO>) request.readEntity(new GenericType<List<ClienteDTO>>(){});
            return new Respuesta(true, "Clientes", clientes);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    
    }
    
    public Respuesta BuscarCliente(Long id) {
        try{
            Map<String, Object> datos = new HashMap<>();
            datos.put("id", id);
            Conexion request = new Conexion("http://localhost:8099/clientes/","/{id}",datos);
            request.get();
            if(request.isError()){
                return new Respuesta(false, request.getError(), "No se pudo encontrar el cliente: "+request.getMensajeRespuesta());
            }
            ClienteDTO clienteDto = (ClienteDTO) request.readEntity(ClienteDTO.class);
            return new Respuesta(true, "Cliente", clienteDto);
        }catch(Exception ex){
            return new Respuesta(false, ex.toString(), "Error al comunicarse con el servidor");
        }
    }

    
    
    
}
