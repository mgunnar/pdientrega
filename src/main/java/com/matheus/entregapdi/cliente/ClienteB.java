package com.matheus.entregapdi.cliente;

/* 2.   Clientes tipo B, recebem R$ 5.000,00 de limite de crédito.
*       Caso realizem compras com valor a partir de R$ 1.000,00, estes clientes recebem um desconto de 5% na compra realizada.
*       O valor do desconto deve ser avisado no momento da compra.
*/
public class ClienteB extends Cliente {
    private static final double LIMITE_BASE = 5000.0;
    private static final double DESCONTO_MINIMO = 0.05;

    public ClienteB(String nome) {
        super(nome, LIMITE_BASE);
    }

    @Override
    public double getDesconto(double valorCompra) {
        if (valorCompra >= 1000.0) {
            return valorCompra * DESCONTO_MINIMO;
        } else {
            return 0.0;
        }
    }
}
