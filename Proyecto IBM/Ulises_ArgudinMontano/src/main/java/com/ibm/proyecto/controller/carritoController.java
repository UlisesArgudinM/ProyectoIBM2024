package com.ibm.proyecto.controller;

import com.ibm.proyecto.excepciones.ResourceNotFoundException;
import com.ibm.proyecto.models.carrito;
import com.ibm.proyecto.repositories.carritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiCarrito/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class carritoController {
    @Autowired
    private carritoRepository repository;

    @GetMapping("/carritos")
    public List<carrito> listarcarritos(){
        return repository.findAll();
    }

    @PostMapping("/carritos")
    public carrito guardarcarrito(@RequestBody carrito carrito) {
        return repository.save(carrito);
    }

    //este metodo sirve para buscar un carrito
    @GetMapping("/carritos/{id}")
    public ResponseEntity<carrito> obtenercarritoPorId(@PathVariable Long id){
        carrito carrito = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el carrito con el ID : " + id));
        return ResponseEntity.ok(carrito);
    }

    //este metodo sirve para actualizar carrito
    @PutMapping("/carritos/{id}/{idArticulo}")
    public ResponseEntity<carrito> actualizarcarrito(@PathVariable Long id,@PathVariable int idArticulo,@RequestBody carrito detallescarrito){
            carrito carrito = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("No existe el carrito con el ID : " + id));
            carrito.setIdArticulo(detallescarrito.getIdArticulo());
            carrito.setNumeroArticulos(detallescarrito.getNumeroArticulos());

            carrito carritoActualizado = repository.save(carrito);
        return ResponseEntity.ok(carritoActualizado);
    }

    //este metodo sirve para eliminar un carrito
    @DeleteMapping("/carritos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarcarrito(@PathVariable Long id){
        carrito carrito = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el carrito con el ID : " + id));

        repository.delete(carrito);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
    
}
