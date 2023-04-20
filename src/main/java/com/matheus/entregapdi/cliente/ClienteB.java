package com.matheus.entregapdi.cliente;

/* 2.   Clientes tipo B, recebem R$ 5.000,00 de limite de crédito.
 *       Caso realizem compras com valor a partir de R$ 1.000,00, estes clientes recebem um desconto de 5% na compra realizada.
 *       O valor do desconto deve ser avisado no momento da compra.
 */

import com.matheus.entregapdi.cliente.service.ClienteService;

public class ClienteB extends Cliente {
    private static final double VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO = 1000.0;
    private static final double PORCENTAGEM_DESCONTO = 0.05;

    private ClienteService service;

    public ClienteB(String nome, ClienteService service) {
        super(nome, 5000, ClienteB.class.getName());
        this.service = service;
    }

    @Override
    public double comprar(double valor) {

        if (autorizaCompra(valor)) {
            var valorCompraDescontado = service.verificaDescontoCompra(valor, VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO, PORCENTAGEM_DESCONTO);
            descontarLimiteDeCredito(valorCompraDescontado);
        }

        return this.getLimiteDeCredito();
    }

    @Override
    protected boolean autorizaCompra(double valor) {
        return valor <= this.getLimiteDeCredito();
    }

    @Override
    protected void descontarLimiteDeCredito(double valor) {
        this.setLimiteDeCredito(this.getLimiteDeCredito() - valor);
    }
}

