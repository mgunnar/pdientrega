package com.matheus.entregapdi.cliente;

import java.util.logging.Logger;


public abstract class Cliente {

    protected final Logger logger;

    private double limiteDeCredito;
    private String nome;

    protected Cliente(String nome, double limiteDeCredito, String className) {
        this.nome = nome;
        this.limiteDeCredito = limiteDeCredito;
        this.logger = Logger.getLogger(className);
    }

    protected Cliente(String nome, double limiteDeCredito) {
        this.nome = nome;
        this.limiteDeCredito = limiteDeCredito;
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

    protected abstract double comprar(double valor);

    protected boolean autorizaCompra(double valor) {
        return valor <= this.getLimiteDeCredito();
    }

    protected void descontarLimiteDeCredito(double valor) {
        this.setLimiteDeCredito(this.getLimiteDeCredito() - valor);
    }


    //TODO PAGAR AS CONTAS.
    //TODO Adicionar atributo para acumular total de compras realizadas para clienteA
    //refatorar para aumentar limite a cada 5 mil gastos.



    //TODO 1 - Criar cadastro de clientes;
    //TODO 2 - Criar serviço para comprar [fazer a lógica de acordo com os tipos de clientes, pagarConta, Adicionar Acumulador, Adicionar toda a lógica do comprar e testar tudo];
    //TODO 3 - Criar API Rest;
}
