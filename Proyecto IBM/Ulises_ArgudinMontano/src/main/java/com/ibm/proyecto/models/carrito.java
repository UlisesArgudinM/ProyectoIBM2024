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
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"fechaIngreso","fechaModificacion"})
@Table(name = "carritos")
public class carrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carritoId;

    @Column(nullable = true)
    private  int idArticulo;

    @Column(nullable = true)
    private int numeroArticulos;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date fechaModificacion;
}
