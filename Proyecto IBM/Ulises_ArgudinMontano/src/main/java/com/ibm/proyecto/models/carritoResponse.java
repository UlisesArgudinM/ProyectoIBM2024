package com.ibm.proyecto.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class carritoResponse {
    private int numeroArticulos;
    private Date fechaIngreso;
    private Date fechaModificacion;
}
