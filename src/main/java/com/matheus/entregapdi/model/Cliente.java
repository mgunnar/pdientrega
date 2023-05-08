package com.matheus.entregapdi.model;

import com.matheus.entregapdi.enums.TipoCliente;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Document(collection = "clientes")
public class Cliente {

    @MongoId
    @Field(name = "_id")
    private String id;

    @Field(name = "nome")
    private String nome;

    @Field(name = "limite_de_credito")
    private double limiteDeCredito;

    @Field(name = "limite_de_credito_disponivel")
    private double limiteDeCreditoDisponivel;

    @Enumerated(EnumType.STRING)
    @Field(name = "tipo_cliente")
    private TipoCliente tipoCliente;

    public Cliente(String nome, TipoCliente tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        atualizarLimiteDeCredito();
    }

    public Cliente() {}

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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        atualizarLimiteDeCredito();
    }

    public double getLimiteDeCreditoDisponivel() {
        return limiteDeCreditoDisponivel;
    }

    public void setLimiteDeCreditoDisponivel(double limiteDeCreditoDisponivel) {
        this.limiteDeCreditoDisponivel = limiteDeCreditoDisponivel;
    }

    private void atualizarLimiteDeCredito() {
        this.limiteDeCredito = tipoCliente.getLimiteCreditoInicial();
    }

    public double getValorMinimoCompraParaTerDesconto() {
        return tipoCliente.getValorMinimoCompraParaTerDesconto();
    }

    public double getPercentualDesconto() {
        return tipoCliente.getPercentualDesconto();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", limiteDeCredito=" + limiteDeCredito +
                ", limiteDeCreditoDisponivel=" + limiteDeCreditoDisponivel +
                ", tipoCliente=" + tipoCliente +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}



    //TODO PAGAR AS CONTAS.
    //TODO Adicionar atributo para acumular total de compras realizadas para clienteA
    //refatorar para aumentar limite a cada 5 mil gastos.


    //TODO 1 - Criar cadastro de clientes;
    //TODO 2 - Criar serviço para comprar [fazer a lógica de acordo com os tipos de clientes, pagarConta, Adicionar Acumulador, Adicionar toda a lógica do comprar e testar tudo];
    //
    //TODO 3 - Criar API Rest;
