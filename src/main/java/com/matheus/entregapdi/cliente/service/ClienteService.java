package com.matheus.entregapdi.cliente.service;

public class ClienteService {

    public double verificaDescontoCompra(double valorCompra, double valorMinimoParaDesconto, double porcentagem) {
        if (valorCompra >= valorMinimoParaDesconto) {
            var desconto = valorCompra * porcentagem;
            var valorComDesconto = valorCompra - desconto;
            var mensagem = String.format("Desconto de R$ %.2f aplicado na compra.", desconto);

            System.out.println(mensagem);

            return valorComDesconto;
        }

        System.out.println("Não foi aplicado desconto na compra.");

        return valorCompra;
    }

    cadastraCliente{}
}
