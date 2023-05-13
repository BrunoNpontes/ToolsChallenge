package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeName("descricao")
public class DescriptionDto implements Serializable {

    @JsonProperty("valor")
    private String value;
    @JsonProperty("dataHora")
    private String dateTime;
    @JsonProperty("estabelecimento")
    private String establishment;
    @JsonProperty("nsu")
    private String nsu;
    @JsonProperty("codigoAutorizacao")
    private String authCode;
    @JsonProperty("status")
    private String statusTransaction;
}
