package com.example.pos.IService.ServiceImp;


import com.example.pos.Entity.Cliente;
import com.example.pos.IRepository.IClienteRepository;
import com.example.pos.IService.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final IClienteRepository clienteRepository;
    Cliente cliente = new Cliente();


    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    @Override
    public void ActualizarCliente(Cliente cliente, long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);

        if (optional.isPresent()) {
            cliente.setId(cliente.getId());
            cliente.setNombre(cliente.getNombre());
            cliente.setEmail(cliente.getEmail());
            cliente.setTelefono(cliente.getTelefono());
            cliente.setDireccion(cliente.getDireccion());

            clienteRepository.save(cliente);
        }else{
            throw new RuntimeException(("Cliente Inexistente"));
        }
    }

    @Override
    public void eliminarCliente(long id) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Optional<Cliente> listarClientePorId(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}
