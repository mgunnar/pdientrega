package com.matheus.entregapdi.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection = "compras")
public class Compra {

    @MongoId
    @Field(name ="_id")
    private ObjectId id;

    @Field(name ="valor_total_compra")
    Double valorTotalCompra;

    @Field(name = "hora_transacao")
    private Date horaTransacao;

    @Field(name = "cliente_id")
    private String clienteId;

    public Compra() {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public Date getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(Timestamp horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", valorTotalCompra=" + valorTotalCompra +
                ", horaTransacao=" + horaTransacao +
                ", clienteId=" + clienteId +
                '}';
    }
}