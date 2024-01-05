package com.ibm.proyecto.repositories;

import com.ibm.proyecto.models.carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
public interface carritoRepository extends JpaRepository<carrito, Long> {
}
