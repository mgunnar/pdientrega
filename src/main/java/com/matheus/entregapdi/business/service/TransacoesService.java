package com.matheus.entregapdi.business.service;

import com.matheus.entregapdi.model.Cliente;
import com.matheus.entregapdi.model.Compra;
import com.matheus.entregapdi.repository.TransacoesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransacoesService {


    @Autowired
    private TransacoesRepository transacoesRepository;



    public Compra comprar(Cliente cliente, Double valorCompra) {

        Compra compra = new Compra();

        boolean isCompraAutorizada = autorizaCompra(cliente, valorCompra);

        if (isCompraAutorizada) {

            var valorCompraDescontado = verificaDescontoCompra(valorCompra, cliente.getValorMinimoCompraParaTerDesconto(), cliente.getPercentualDesconto());

//            log.info("Total: {}", valorCompraDescontado);

            descontarLimiteDeCredito(cliente, valorCompraDescontado);
            registraCompra(valorCompra);

            return compra;
        }

        log.info("NÃO AUTORIZADA - Compra no valor de R$ {} .", valorCompra);

        return compra;
    }

    public double verificaDescontoCompra(double valorCompra, double valorMinimoParaDesconto, double porcentagem) {

        if (valorCompra >= valorMinimoParaDesconto) {

//            log.info("AUTORIZADA - Compra no valor de R$ {}.", valorCompra);
            var desconto = valorCompra * porcentagem;
//            log.info("Desconto aplicado R$ {}.", desconto);

            return valorCompra - desconto;
        }

//        log.info("Não foi aplicado desconto na compra.");

        return valorCompra;
    }

    private void registraCompra(Double valorCompra) {

        var compra = new Compra();

        compra.setValorTotalCompra(valorCompra);
        salvarCompra(compra);
    }

    public Double verificaAumentoLimiteAposCompra(double valorCompra) {
        return valorCompra;
    }

    public void descontarLimiteDeCredito(Cliente cliente, double valor) {
        cliente.setLimiteDeCreditoDisponivel(cliente.getLimiteDeCreditoDisponivel() - valor);
    }

    public Boolean autorizaCompra(Cliente cliente, double valor) {
        return valor <= cliente.getLimiteDeCreditoDisponivel();
    }

    public Compra salvarCompra(Compra compra) {
//        log.info("Registrando nova compra: {}", compra);
        return transacoesRepository.save(compra);
    }

    public List<Compra> buscarTodasAsTransacoes() {
//        log.info("Buscando todas as transações.");
        return transacoesRepository.findAll();
    }

}