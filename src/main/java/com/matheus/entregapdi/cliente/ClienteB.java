package com.matheus.entregapdi.cliente;

/* 2.   Clientes tipo B, recebem R$ 5.000,00 de limite de crédito.
*       Caso realizem compras com valor a partir de R$ 1.000,00, estes clientes recebem um desconto de 5% na compra realizada.
*       O valor do desconto deve ser avisado no momento da compra.
*/

public class ClienteB extends Cliente {
    private static final double VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO = 1000.0;
    private static final double PORCENTAGEM_DESCONTO = 0.05;

    public ClienteB(String nome) {
        super(nome,5000, ClienteB.class.getName());
    }

    @Override
    public boolean comprar(double valor) {
        boolean compraAutorizada = super.comprar(valor);

        if (compraAutorizada && valor >= VALOR_MINIMO_COMPRA_PARA_TER_DESCONTO) {
            double desconto = valor * PORCENTAGEM_DESCONTO;
            String mensagem = String.format("Desconto de R$ %.2f aplicado na compra.", desconto);
            logger.info(mensagem);
        }
        return compraAutorizada;
    }
}

