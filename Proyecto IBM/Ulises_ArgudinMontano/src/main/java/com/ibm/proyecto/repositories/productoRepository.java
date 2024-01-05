package com.ibm.proyecto.repositories;

import com.ibm.proyecto.models.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productoRepository extends JpaRepository<producto, Long> {

}
