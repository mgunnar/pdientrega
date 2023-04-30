package com.matheus.entregapdi.model;

import com.matheus.entregapdi.enums.TipoCliente;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Document(collection = "clientes")
public class Cliente {

    @Id
    @Field(name ="id")
    private ObjectId id;

    @Field(name = "nome")
    private String nome;

    @Field(name = "limite_de_credito")
    private double limiteDeCredito;

    @Enumerated(EnumType.STRING)
    @Field(name = "tipo_cliente")
    private TipoCliente tipoCliente;

    public Cliente(String nome, TipoCliente tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        atualizarLimiteDeCredito();
    }

    public Cliente() {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
        atualizarLimiteDeCredito();
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
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}



    //TODO PAGAR AS CONTAS.
    //TODO Adicionar atributo para acumular total de compras realizadas para clienteA
    //refatorar para aumentar limite a cada 5 mil gastos.


    //TODO 1 - Criar cadastro de clientes;
    //TODO 2 - Criar serviço para comprar [fazer a lógica de acordo com os tipos de clientes, pagarConta, Adicionar Acumulador, Adicionar toda a lógica do comprar e testar tudo];
    //
    //TODO 3 - Criar API Rest;
