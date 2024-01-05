package com.ibm.proyecto.controller;

import com.ibm.proyecto.excepciones.ResourceNotFoundException;
import com.ibm.proyecto.models.producto;
import com.ibm.proyecto.repositories.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiProducto/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class productoController {
    @Autowired
    private productoRepository repository;

    @GetMapping("/productos")
    public List<producto> listarproductos(){
        return repository.findAll();
    }

    @PostMapping("/productos")
    public producto guardarproducto(@RequestBody producto producto) {
        return repository.save(producto);
    }

    //este metodo sirve para buscar un producto
    @GetMapping("/productos/{id}")
    public ResponseEntity<producto> obtenerproductoPorId(@PathVariable Long id){
        producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));
        return ResponseEntity.ok(producto);
    }

    //este metodo sirve para actualizar producto
    @PutMapping("/productos/{id}")
    public ResponseEntity<producto> actualizarproducto(@PathVariable Long id,@RequestBody producto detallesproducto){
        producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));

        producto.setNombreProducto(detallesproducto.getNombreProducto());
        producto.setPrecio(detallesproducto.getPrecio());

        producto productoActualizado = repository.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    //este metodo sirve para eliminar un producto
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarproducto(@PathVariable Long id){
        producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));

        repository.delete(producto);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
