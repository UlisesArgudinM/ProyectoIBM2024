package com.ibm.proyecto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"fechaIngreso","fechaModificacion"})
public class cliente implements Serializable {

    private static final long serialVesionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @Column(name = "numero_cliente")
    private String numeroCliente;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "correo")
    private String correoUsuario;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date fechaModificacion;

    @Column(nullable = false)
    private boolean admin;

    @Column(name = "carrito")
    private int carrito;

}
