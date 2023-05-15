package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.toolschallenge.ToolsChallenge.model.entitys.PaymentMethodEntity;
import lombok.Data;

@Data
@JsonTypeName("formaPagamento")
public class PaymentMethodDto {

    @JsonProperty("tipo")
    private String type;
    @JsonProperty("parcelas")
    private String installments;

    public  PaymentMethodDto(){}

    public  PaymentMethodDto(PaymentMethodEntity entity){
        this.setType(entity.getType());
        this.setInstallments(entity.getInstallments().toString());
    }


}
