package com.matheus.entregapdi.cliente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteCTest {

    @Test
    void deveAutorizarCompra() {
        ClienteC cliente = new ClienteC("Maria");
        var compraAutorizada = cliente.autorizaCompra(1000);

        assertTrue(compraAutorizada);
    }

    @Test
    void naoDeveAutorizarCompra() {
        ClienteC cliente = new ClienteC("Maria");
        var compraAutorizada = cliente.autorizaCompra(10001);

        assertFalse(compraAutorizada);
    }

    @Test
    void descontarLimiteDeCredito() {
        ClienteC cliente = new ClienteC("Maria");
        double limiteInicial = cliente.getLimiteDeCredito();

        cliente.descontarLimiteDeCredito(500.0);

        assertEquals(limiteInicial - 500.0, cliente.getLimiteDeCredito());
    }
}