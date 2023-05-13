package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName("formaPagamento")
public class PaymentMethodDto {

    @JsonProperty("tipo")
    private String type;
    @JsonProperty("parcelas")
    private String installments;
}
