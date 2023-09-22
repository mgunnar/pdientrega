package com.matheus.entregapdi.business.service;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("clienteService")
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarTodos() {
        return (List<Cliente>) clienteRepository.findAll();
    }
}