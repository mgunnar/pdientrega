package com.matheus.entregapdi.model.dto;

import io.swagger.annotations.ApiModelProperty;

public class CompraRequestDTO {
    @ApiModelProperty(value = "1000.0",name ="valor_total_compra")
    Double valorTotalCompra;

    @ApiModelProperty(value = "ID do comprador.", example = "123456789")
    private Long clienteId;


    public Double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra(Double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
