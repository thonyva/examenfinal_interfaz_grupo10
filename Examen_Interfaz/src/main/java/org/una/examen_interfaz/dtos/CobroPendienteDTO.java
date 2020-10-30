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
 * @author farle_000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class CobroPendienteDTO {
    private Long id; 
    private double monto;   
    private boolean estado; 
    private Date fechaRegistro; 
    private Date fechaModificacion;
    private Date fechaVencimiento;
    private Date fechaPago;
    
    private MembresiaDTO membresia;
}
