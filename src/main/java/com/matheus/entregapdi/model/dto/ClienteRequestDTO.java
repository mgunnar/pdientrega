package com.matheus.entregapdi.model.dto;

import com.matheus.entregapdi.enums.TipoCliente;
import io.swagger.annotations.ApiModelProperty;

public class ClienteRequestDTO {

    @ApiModelProperty(value = "Nome do cliente", example = "João")
    private String nome;

    @ApiModelProperty(value = "Tipo do cliente", example = "A, B ou C")
    private TipoCliente tipoCliente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
