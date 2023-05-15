package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.toolschallenge.ToolsChallenge.model.entitys.DescriptionEntity;
import com.toolschallenge.ToolsChallenge.service.utils.ToolsUtil;
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

    public DescriptionDto(){}

    public DescriptionDto(DescriptionEntity entity){
        this.setEstablishment(entity.getEstablishment());
        this.setValue(entity.getValue().toString());
        this.setDateTime(ToolsUtil.LocalDateTimeToString(entity.getDateTime()));
        this.setNsu(entity.getNsu());
        this.setAuthCode(entity.getAuthCode());
        this.setStatusTransaction(entity.getStatusTransaction());
    }
}
