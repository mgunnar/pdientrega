package com.matheus.entregapdi.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class CompraRequestDTO {
    @ApiModelProperty(value = "1000.0",name ="valor_total_compra")
    Double valorTotalCompra;

    @ApiModelProperty(value = "ID do comprador.", example = "123456789")
    private String clienteId;


    public Double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}
