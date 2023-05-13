package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonTypeName("transacao")
public class TransactionDto implements Serializable {

    @JsonProperty("id")
    private String idTransaction;
    @JsonProperty("cartao")
    private String numCard;
    @JsonProperty("descricao")
    private DescriptionDto description;
    @JsonProperty("formaPagamento")
    private PaymentMethodDto paymentMethod;
}
