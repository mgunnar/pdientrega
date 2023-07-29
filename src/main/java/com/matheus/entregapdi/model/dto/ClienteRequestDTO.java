package com.matheus.entregapdi.model.dto;

import com.matheus.entregapdi.enums.TipoCliente;
import io.swagger.annotations.ApiModelProperty;

public record ClienteRequestDTO (

    @ApiModelProperty(value = "Nome do cliente", example = "João")
    String nome,

    @ApiModelProperty(value = "Tipo do cliente", example = "A, B ou C")
     TipoCliente tipoCliente){}
