package com.matheus.entregapdi.cliente;

/*
 * 3 .Clientes tipo C, recebem R$ 1.000,00 de limite de crédito,
 * e podem comprar e pagar suas compras.
 *
 */
public class ClienteC extends Cliente {
    public ClienteC(String nome) {
        super(nome,1000, ClienteC.class.getName());
    }
}
