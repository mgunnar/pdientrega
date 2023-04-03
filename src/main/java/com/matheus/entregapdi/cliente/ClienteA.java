package com.matheus.entregapdi.cliente;


/*
 * Clientes tipo A, recebem no momento do cadastro R$ 10.000,00 de limite de crédito.
 * A cada R$ 5.000,00 em compras, este limite é acrescido em R$ 500,00.
 * Esse aumento de limite deve ser avisado no momento da compra.
 * Caso realizem compras com valor a partir de R$ 2.000,00, estes clientes recebem um desconto de 10% na compra realizada.
 * O valor do desconto deve ser avisado no momento da compra.
 */

public class ClienteA extends Cliente {
    private static final double VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO = 2000.0;
    private static final double PORCENTAGEM_DESCONTO = 0.1;
    private static final double AUMENTO_LIMITE_POR_COMPRA = 500.0;

    public ClienteA(String nome) {
        super(nome, 10000, ClienteA.class.getName());
    }

    @Override
    public boolean comprar(double valor) {
        boolean compraAutorizada = super.comprar(valor);


        if (compraAutorizada) {
            double novoLimite = this.getLimiteDeCredito();
            int numAumentos = (int) (valor / 5000.0);

            for (int i = 0; i < numAumentos; i++) {
                novoLimite += AUMENTO_LIMITE_POR_COMPRA;
                String mensagem = String.format("Limite de crédito aumentado em R$ %.2f.", AUMENTO_LIMITE_POR_COMPRA);
                logger.info(mensagem);
            }
            if (numAumentos > 0) {
                this.setLimiteDeCredito(novoLimite);
            }

            if (valor >= VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO) {
                double desconto = valor * PORCENTAGEM_DESCONTO;
                String mensagem = String.format("Desconto de R$ %.2f aplicado na compra.", desconto);
                logger.info(mensagem);
            }
        }
        return compraAutorizada;
    }

}

