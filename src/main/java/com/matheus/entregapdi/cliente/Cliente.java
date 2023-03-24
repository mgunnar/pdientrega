package com.matheus.entregapdi.cliente;


public abstract class Cliente {
    private String nome;
    private final double limiteDeCredito;
    private double limiteDeCreditoDisponivel;

    public Cliente(String nome, double limiteDeCredito) {
        this.nome = nome;
        this.limiteDeCredito = limiteDeCredito;
        this.limiteDeCreditoDisponivel = limiteDeCredito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public double getLimiteDeCreditoDisponivel() {
        return limiteDeCreditoDisponivel;
    }

    public void setLimiteDeCreditoDisponivel(double limiteDeCreditoDisponivel) {
        this.limiteDeCreditoDisponivel = limiteDeCreditoDisponivel;
    }

    public boolean comprar(double valor) {
        if (valor > this.limiteDeCreditoDisponivel) {
            System.out.println("Compra não realizada, limite de crédito insuficiente.");
            return false;
        }
        this.limiteDeCreditoDisponivel -= valor;
        System.out.printf("Compra de R$ %.2f realizada com sucesso\n", valor);
        return true;
    }
}
