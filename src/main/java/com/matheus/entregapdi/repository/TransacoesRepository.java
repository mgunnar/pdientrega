package com.matheus.entregapdi.repository;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends MongoRepository<Compra, Long> {

}
