package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonPropertyOrder({"cartao","id","descricao","formaPagamento" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDto implements Serializable {

    @JsonProperty("id")
    private String idTransaction;
    @JsonProperty("cartao")
    private String numCard;
    @JsonProperty("descricao")
    private DescriptionDto description;
    @JsonProperty("formaPagamento")
    private PaymentMethodDto paymentMethod;

    public TransactionDto(){}

    public TransactionDto(TransactionEntity entity){
        this.setIdTransaction(entity.getIdTransaction().toString());
        this.setNumCard(entity.getNumCard());
        this.setDescription(new DescriptionDto(entity.getDescription()));
        this.setPaymentMethod( new PaymentMethodDto(entity.getPaymentMethod()));
    }

}
