package com.matheus.entregapdi.cliente;

/*
 * 3 .Clientes tipo C, recebem R$ 1.000,00 de limite de crédito,
 * e podem comprar e pagar suas compras.
 *
 */
public class ClienteC extends Cliente {

    double limiteDeCredito = 1000.0;
    public ClienteC(String nome) {
        super(nome);
        this.setLimiteDeCreditoDisponivel(limiteDeCredito);
    }
}
