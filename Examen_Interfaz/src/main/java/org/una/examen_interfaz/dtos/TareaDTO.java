/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.examen_interfaz.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author thony
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString

public class TareaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private String importancia;
    private String urgencia;
    private String porcentajeAvance;
}