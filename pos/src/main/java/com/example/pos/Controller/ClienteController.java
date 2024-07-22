package com.example.pos.Controller;


import com.example.pos.Entity.Cliente;
import com.example.pos.IService.ClienteService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.PatternValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final PatternValidator patternValidator;

    @PostMapping("/guardarCliente")
    public Cliente guardarCliente(@RequestBody Cliente cliente) { return clienteService.guardarCliente(cliente);}

    @PutMapping("/{id}")
    public void ActualizarCliente(@RequestBody Cliente cliente, @PathVariable long id){clienteService.ActualizarCliente(cliente,id);}

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable long id) { clienteService.eliminarCliente(id);}

    @GetMapping("")
    public List<Cliente> listarCliente(){return clienteService.listarClientes();}

    @GetMapping("/{id}")
    public Optional<Cliente> listarIdCliente(@PathVariable long id){ return clienteService.listarClientePorId(id);}




}
