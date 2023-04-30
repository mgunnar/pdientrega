package com.matheus.entregapdi.model;

import org.bson.types.ObjectId;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Document(collection = "compras")
public class Compra {

    @Id
    @Field(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    @Field(name ="valor_total_compra")
    Double valorTotalCompra;

    @Field(name = "hora_transacao")
    @CreationTimestamp
    private Timestamp horaTransacao;


    @Field(name = "cliente_id")
    private Long clienteId;

    public Compra() {

    }

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

    public Timestamp getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(Timestamp horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
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
