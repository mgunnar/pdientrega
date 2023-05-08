package com.matheus.entregapdi.enums;

public enum TipoCliente {

    A(10000,10000, 5000,0.1),
    B(5000,5000, 1000,0.05),
    C(1000, 1000,0,0);
    private double limiteCreditoInicial;
    private  double limiteCreditoDisponivel;
    private final double valorMinimoCompraParaTerDesconto;
    private final double percentualDesconto;

    public double getLimiteCreditoInicial() {
        return limiteCreditoInicial;
    }

    public double getValorMinimoCompraParaTerDesconto() {
        return valorMinimoCompraParaTerDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    TipoCliente(double limiteCreditoInicial, double limiteCreditoDisponivel, double valorMinimoCompraParaTerDesconto, double percentualDesconto) {
        this.limiteCreditoInicial = limiteCreditoInicial;
        this.limiteCreditoDisponivel = limiteCreditoInicial;
        this.valorMinimoCompraParaTerDesconto = valorMinimoCompraParaTerDesconto;
        this.percentualDesconto = percentualDesconto;
    }

}
