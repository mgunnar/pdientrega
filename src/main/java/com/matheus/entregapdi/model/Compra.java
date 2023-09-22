package com.matheus.entregapdi.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "compras")
public class Compra {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "valor_total_compra")
    Double valorTotalCompra;

    @Column(name = "hora_transacao")
    private Date horaTransacao;

    @Column(name = "cliente_id")
    private Long clienteId;

    public Compra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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