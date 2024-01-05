package com.ibm.proyecto.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class clienteResponse {
    private String numeroCliente;
    private String nombre;
    private Date fechaIngreso;
    private Date fechaModificacion;

    private boolean admin;
    private int carrito;

    private int añosCumplidos;
    private int mesesCumplidos;
    private int diasCumplidos;

}
