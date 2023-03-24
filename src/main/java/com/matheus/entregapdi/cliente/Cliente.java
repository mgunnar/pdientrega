package com.matheus.entregapdi.cliente;
import java.util.logging.Logger;



public abstract class Cliente {

    private static final Logger logger = Logger.getLogger(Cliente.class.getName());

    private double limiteDeCredito;
    private String nome;
    private double limiteDeCreditoDisponivel;

    public Cliente(String nome) {
        this.nome = nome;
        this.limiteDeCredito = 0;
        this.limiteDeCreditoDisponivel = 0;
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

    public boolean comprar(double valor) {
        if (valor > this.limiteDeCreditoDisponivel) {
            logger.info("Compra não realizada, limite de crédito insuficiente.");
            return false;
        }
        this.limiteDeCreditoDisponivel -= valor;
        logger.info(String.format("Compra de R$ %.2f realizada com sucesso", valor));
        return true;
    }
}
