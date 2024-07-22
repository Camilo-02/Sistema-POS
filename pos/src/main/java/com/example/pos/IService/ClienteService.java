package com.example.pos.IService;

import com.example.pos.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente guardarCliente(Cliente cliente);
    void ActualizarCliente(Cliente cliente, long id);
    void eliminarCliente(long id);
    Optional<Cliente> listarClientePorId(long id);
    List<Cliente> listarClientes();
}
