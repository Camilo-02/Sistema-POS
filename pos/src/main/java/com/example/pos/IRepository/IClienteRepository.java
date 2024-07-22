package com.example.pos.IRepository;

import com.example.pos.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
