package com.matheus.entregapdi;

import com.matheus.entregapdi.cliente.ClienteA;
import com.matheus.entregapdi.cliente.ClienteB;
import com.matheus.entregapdi.cliente.ClienteC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class EntregapdiApplication {

	private static final Logger logger = Logger.getLogger(EntregapdiApplication.class.getName());

	public static void main(String[] args) {

		SpringApplication.run(EntregapdiApplication.class, args);



		ClienteA clienteA = new ClienteA("Cliente A");
		ClienteB clienteB = new ClienteB("Cliente B");
		ClienteC clienteC = new ClienteC("Cliente C");

// Teste do método comprar da classe ClienteA
		logger.info("Cliente A");
		double valorCompraA = 10000;
		boolean compraAutorizadaA = clienteA.comprar(valorCompraA);


// Teste do método comprar da classe ClienteB
		logger.info("Cliente B");
		double valorCompraB = 8500.0;
		boolean compraAutorizadaB = clienteB.comprar(valorCompraB);


// Teste do método comprar da classe ClienteC
		logger.info("Cliente C");
		double valorCompraC = 999.0;
		boolean compraAutorizadaC = clienteC.comprar(valorCompraC);

	}

}
