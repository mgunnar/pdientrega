package com.matheus.entregapdi.service;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.model.Compra;
import com.matheus.entregapdi.repository.TransacoesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacoesService {

    private final MongoTemplate mongoTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);


    public TransacoesService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public Compra comprar(Cliente cliente, Double valorCompra) {

        Compra compra = new Compra();

        if (autorizaCompra(cliente, valorCompra)) {

            var valorCompraDescontado = verificaDescontoCompra(valorCompra, cliente.getValorMinimoCompraParaTerDesconto(), cliente.getPercentualDesconto());

            LOGGER.info("Total: {}", valorCompraDescontado);

            descontarLimiteDeCredito(cliente, valorCompraDescontado);
            registraCompra(cliente, valorCompra);

            return compra;
        }

        LOGGER.info("NÃO AUTORIZADA - Compra no valor de R$ {} .", valorCompra);

        return compra;
    }

    public double verificaDescontoCompra(double valorCompra, double valorMinimoParaDesconto, double porcentagem) {

        if (valorCompra >= valorMinimoParaDesconto) {

            LOGGER.info("AUTORIZADA - Compra no valor de R$ {}.", valorCompra);
            var desconto = valorCompra * porcentagem;
            LOGGER.info("Desconto aplicado R$ {}.",desconto);

            return valorCompra - desconto;
        }

        LOGGER.info("Não foi aplicado desconto na compra.");

        return valorCompra;
    }

    private void registraCompra(Cliente cliente, Double valorCompra) {

        var compra = new Compra();

        compra.setValorTotalCompra(valorCompra);
        salvar(compra);
    }

    public Double verificaAumentoLimiteAposCompra(Cliente cliente, double valorCompra) {
        return valorCompra;
    }

    public void descontarLimiteDeCredito(Cliente cliente, double valor) {
        cliente.setLimiteDeCreditoDisponivel(cliente.getLimiteDeCreditoDisponivel() - valor);
    }

    public Boolean autorizaCompra(Cliente cliente, double valor) {
        return valor <= cliente.getLimiteDeCreditoDisponivel();
    }

    public Compra salvar(Compra compra) {
        LOGGER.info("Registrando nova compra: {}", compra);
        return mongoTemplate.save(compra);
    }

    public List<Compra> buscarTodos() {
        LOGGER.info("Buscando todas as transações.");
        return mongoTemplate.findAll(Compra.class);
    }
}