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
		double valorCompraA = 10000.0;
		boolean compraAutorizadaA = clienteA.comprar(valorCompraA);
		if (compraAutorizadaA) {
			logger.info(String.format("Compra no valor de R$%.2f autorizada.", valorCompraA));
		} else {
			logger.info(String.format("Compra no valor de R$%.2f não autorizada.", valorCompraA));
		}

// Teste do método comprar da classe ClienteB
		logger.info("Cliente B");
		double valorCompraB = 1500.0;
		boolean compraAutorizadaB = clienteB.comprar(valorCompraB);
		if (compraAutorizadaB) {
			logger.info(String.format("Compra no valor de R$%.2f autorizada.", valorCompraB));
		} else {
			logger.info(String.format("Compra no valor de R$%.2f não autorizada.", valorCompraB));
		}

// Teste do método comprar da classe ClienteC
		logger.info("Cliente C");
		double valorCompraC = 8000.0;
		boolean compraAutorizadaC = clienteC.comprar(valorCompraC);
		if (compraAutorizadaC) {
			logger.info(String.format("Compra no valor de R$%.2f autorizada.", valorCompraC));
		} else {
			logger.info(String.format("Compra no valor de R$%.2f não autorizada.", valorCompraC));
		}

	}

}
