package com.ibm.proyecto.repositories;

import com.ibm.proyecto.models.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {


}
