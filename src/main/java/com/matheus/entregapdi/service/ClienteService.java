package com.matheus.entregapdi.service;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final MongoTemplate mongoTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

        @Autowired
        private ClienteRepository clienteRepository;

    public ClienteService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Cliente salvar(Cliente cliente) {
        return mongoTemplate.save(cliente);
    }
    public List<Cliente> buscarTodos() {
        return mongoTemplate.findAll(Cliente.class);
    }
}