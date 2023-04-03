package com.matheus.entregapdi.cliente;
import java.util.logging.Logger;



public abstract class Cliente {

    protected final Logger logger;

    private double limiteDeCredito;
    private String nome;
    private double limiteDeCreditoDisponivel;

    protected Cliente(String nome, double limiteDeCredito, String className) {
        this.nome = nome;
        this.limiteDeCredito = limiteDeCredito;
        this.limiteDeCreditoDisponivel = limiteDeCredito;
        this.logger = Logger.getLogger(className);
    }

    protected Cliente(String nome, double limiteDeCredito) {
        this.nome = nome;
        this.limiteDeCredito = limiteDeCredito;
        this.limiteDeCreditoDisponivel = limiteDeCredito;
        this.logger = Logger.getLogger(Cliente.class.getName());
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

    public void setLimiteDeCredito(double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }

    public double getLimiteDeCreditoDisponivel() {
        return limiteDeCreditoDisponivel;
    }

    public void setLimiteDeCreditoDisponivel(double limiteDeCreditoDisponivel) {
        this.limiteDeCreditoDisponivel = limiteDeCreditoDisponivel;
    }

    public abstract comprar(double valor);

    public bool

    //TODO tornar método abstrato forçando as classes a implementarem o método;
    // certificar de fazer o desconto do limite após a autorização o compra.
    //separar responsabilidades dos métodos  e criar testes unitários para todos os cenários.
}
