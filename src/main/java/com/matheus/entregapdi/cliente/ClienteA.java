package com.matheus.entregapdi.cliente;


/*
 * Clientes tipo A, recebem no momento do cadastro R$ 10.000,00 de limite de crédito.
 * A cada R$ 5.000,00 em compras, este limite é acrescido em R$ 500,00.
 * Esse aumento de limite deve ser avisado no momento da compra.
 * Caso realizem compras com valor a partir de R$ 2.000,00, estes clientes recebem um desconto de 10% na compra realizada.
 * O valor do desconto deve ser avisado no momento da compra.
 */

import com.matheus.entregapdi.cliente.service.ClienteService;

public class ClienteA extends Cliente {

    private static final double VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO = 2000.0;
    private static final double PORCENTAGEM_DESCONTO = 0.1;
    private static final double AUMENTO_LIMITE_POR_COMPRA = 500.0;
    private static final double LIMITE_INICIAL = 10000;

    private final ClienteService service;

    public ClienteA(String nome, ClienteService service) {
        super(nome, LIMITE_INICIAL, ClienteA.class.getName());
        this.service = service;
    }

    @Override
    public double comprar(double valor) {
        var compraAutorizada = autorizaCompra(valor);

        if (compraAutorizada) {
            var valorCompraDescontado = service.verificaDescontoCompra(valor, VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO, PORCENTAGEM_DESCONTO);
            descontarLimiteDeCredito(valorCompraDescontado);
            verificaAumentoDeLimite(valor);
        }
        return this.getLimiteDeCredito();
    }

    private void verificaAumentoDeLimite(double valorCompra) {
        var novoLimite = this.getLimiteDeCredito();
        var numAumentos = (int) (valorCompra / 5000.0);

        for (int i = 0; i < numAumentos; i++) {
            novoLimite += AUMENTO_LIMITE_POR_COMPRA;
            String mensagem = String.format("Limite de crédito aumentado em R$ %.2f.", AUMENTO_LIMITE_POR_COMPRA);
            logger.info(mensagem);
        }

        if (numAumentos > 0) {
            this.setLimiteDeCredito(novoLimite);
        }
    }//TODO como testar esse método. Usar como stub e donothing com os outros métodos que não são usados.
}

