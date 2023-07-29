package com.matheus.entregapdi.business.service;

import com.matheus.entregapdi.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private final MongoTemplate mongoTemplate;

    public ClienteService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Cliente salvar(Cliente cliente) {
        return mongoTemplate.save(cliente);
    }

    public Cliente buscarPorId(String id) {
        return mongoTemplate.findById(id, Cliente.class);
    }

    public Object apagar(String id) {
        var cliente = buscarPorId(id);
        return mongoTemplate.remove(cliente);
    }

    public List<Cliente> buscarTodos() {
        return mongoTemplate.findAll(Cliente.class);
    }
}