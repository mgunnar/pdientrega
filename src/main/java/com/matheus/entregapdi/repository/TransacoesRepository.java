package com.matheus.entregapdi.repository;

import com.matheus.entregapdi.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TransacoesRepository extends JpaRepository<Compra, Long> {

}
