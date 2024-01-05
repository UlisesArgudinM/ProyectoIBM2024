package com.ibm.proyecto.controller;

import com.ibm.proyecto.excepciones.ResourceNotFoundException;
import com.ibm.proyecto.models.cliente;
import com.ibm.proyecto.repositories.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiCliente/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class clienteController {

    @Autowired
    private  clienteRepository repository;

    @GetMapping("/clientes")
    public List<cliente> listarClientes(){
        return repository.findAll();
    }

    @PostMapping("/clientes")
    public cliente guardarcliente(@RequestBody cliente cliente) {
        return repository.save(cliente);
    }

    //este metodo sirve para buscar un cliente
    @GetMapping("/clientes/{id}")
    public ResponseEntity<cliente> obtenerclientePorId(@PathVariable Long id){
        cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
        return ResponseEntity.ok(cliente);
    }

    //este metodo sirve para actualizar cliente
    @PutMapping("/clientes/{id}")
    public ResponseEntity<cliente> actualizarcliente(@PathVariable Long id,@RequestBody cliente detallescliente){
        cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));

        cliente.setNombre(detallescliente.getNombre());
        cliente.setNumeroCliente(detallescliente.getNumeroCliente());
        cliente.setCorreoUsuario(detallescliente.getCorreoUsuario());

        cliente clienteActualizado = repository.save(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    //este metodo sirve para eliminar un cliente
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarcliente(@PathVariable Long id){
        cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));

        repository.delete(cliente);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
