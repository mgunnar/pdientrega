package com.matheus.entregapdi.cliente;

/*
 * Clientes tipo A, recebem no momento do cadastro R$ 10.000,00 de limite de crédito.
 * A cada R$ 5.000,00 em compras, este limite é acrescido em R$ 500,00.
 * Esse aumento de limite deve ser avisado no momento da compra.
 * Caso realizem compras com valor a partir de R$ 2.000,00, estes clientes recebem um desconto de 10% na compra realizada.
 * O valor do desconto deve ser avisado no momento da compra.
 */



public class ClienteA extends Cliente {
    private static final double LIMITE_DE_CREDITO_BASE = 10000.0;
    private static final double AUMENTO_LIMITE_POR_COMPRA = 500.0;
    private static final double VALOR_MINIMO_DESCONTO = 2000.0;
    private static final double PORCENTAGEM_DESCONTO = 0.1;

    public ClienteA(String nome) {
        super(nome, LIMITE_DE_CREDITO_BASE);
    }

    @Override
    public boolean comprar(double valor) {

        boolean compraRealizada = super.comprar(valor);

        if (compraRealizada && valor >= VALOR_MINIMO_DESCONTO) {

            double desconto = valor * PORCENTAGEM_DESCONTO;
            System.out.printf("Desconto de R$%.2f aplicado na compra\n", desconto);

            double aumentoLimite = AUMENTO_LIMITE_POR_COMPRA * Math.floor(this.numeroCompras / 5.0);

            this.setLimiteDeCreditoDisponivel(this.getLimiteDeCreditoDisponivel() + aumentoLimite);


            }
        }
        return compraRealizada;
    }
}

