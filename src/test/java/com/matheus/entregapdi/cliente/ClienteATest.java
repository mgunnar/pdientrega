package com.matheus.entregapdi.cliente;

import com.matheus.entregapdi.cliente.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ClienteATest {
    @Mock
    ClienteService clienteService;

    @Test
    void deveAutorizarCompra() {
        ClienteA cliente = new ClienteA("Maria",clienteService);
        var compraAutorizada = cliente.autorizaCompra(10000);

        assertTrue(compraAutorizada);
    }

    @Test
    void naoDeveAutorizarCompra() {
        ClienteA cliente = new ClienteA("Maria", clienteService);
        var compraAutorizada = cliente.autorizaCompra(10001);

        assertFalse(compraAutorizada);
    }


    @Test
    void descontarLimiteDeCredito() {
        ClienteA cliente = new ClienteA("João", clienteService);
        double limiteInicial = cliente.getLimiteDeCredito();

        cliente.descontarLimiteDeCredito(500.0);

        assertEquals(limiteInicial - 500.0, cliente.getLimiteDeCredito());
    }

//    @Test
//    void deveAumentarLimite() {
//        ClienteA cliente = new ClienteA("Pedro", clienteService);
//        cliente.comprar(5000);
//
//        assertEquals(
//
//                10500, cliente.getLimiteDeCredito());
//    }
//
//    @Test
//    void deveComprarComDesconto() {
//        ClienteA cliente = new ClienteA("Maria");
//        double valorCompra = 6000;
//        var valorCompraComDesconto = cliente.verificaDescontoCompra(valorCompra);
//        var limiteEsperado = cliente.getLimiteDeCredito() - valorCompraComDesconto;
//
//        cliente.comprar(valorCompra);
//
//        System.out.println(("Limite esperado: " + limiteEsperado));
//
//        assertEquals(limiteEsperado, cliente.getLimiteDeCredito());
//    }
//
//    @Test
//    void deveComprarComDescontoEAumentoDeLimite() {
//        ClienteA cliente = new ClienteA("José");
//        double valorCompra = 5000;
//        var valorCompraComDesconto = cliente.verificaDescontoCompra(valorCompra);
//        var limiteEsperado = cliente.getLimiteDeCredito() - valorCompraComDesconto;
//
//        cliente.comprar(valorCompra);
//
//        System.out.println(("Limite esperado: " + limiteEsperado));
//
//        assertEquals(limiteEsperado, cliente.getLimiteDeCredito());
//    }

}
