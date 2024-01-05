package com.ibm.proyecto.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class productoResponse
{
    private String nombreProducto;
    private double precio;
    private Date fechaIngreso;
    private Date fechaModificacion;

}
