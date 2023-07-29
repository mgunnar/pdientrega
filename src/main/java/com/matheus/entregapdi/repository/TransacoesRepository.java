package com.matheus.entregapdi.repository;

import com.matheus.entregapdi.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoesRepository extends MongoRepository<Compra, String> {

    Compra findByClienteId(String clienteId);
    List<Compra> findAll();
    Compra save(Compra compra);
    void deleteById(String id);

}
