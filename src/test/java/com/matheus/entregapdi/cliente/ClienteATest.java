package com.matheus.entregapdi.cliente;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClienteATest {

//    @Mock
//    @Autowired
//    ClienteService clienteService;
//
//    @Mock
//    @Autowired
//    TransacoesService transacoesService;
//
//    @Test
//    void deveAutorizarCompra() {
//        Cliente cliente = new Cliente("Maria",10000);
//        var compraAutorizada = transacoesService.autorizaCompra(cliente,10000);
//
//        assertTrue(compraAutorizada);
//    }
//
//    @Test
//    void naoDeveAutorizarCompra() {
//        Cliente cliente = new Cliente("Maria", 10000);
//        var compraAutorizada = transacoesService.autorizaCompra(cliente,10001);
//
//        assertFalse(compraAutorizada);
//    }
//
//
//    @Test
//    void descontarLimiteDeCredito() {
//        Cliente cliente = new Cliente("João", 10000);
//        double limiteInicial = cliente.getLimiteDeCredito();
//
//        transacoesService.descontarLimiteDeCredito(cliente,500.0);
//
//        assertEquals(limiteInicial - 500.0, cliente.getLimiteDeCredito());
//    }

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
