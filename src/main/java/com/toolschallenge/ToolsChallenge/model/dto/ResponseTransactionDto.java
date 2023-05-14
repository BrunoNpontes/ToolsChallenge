package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseTransactionDto implements Serializable {

    @JsonProperty("trasacoes")
    private TransactionDto transaction;
    @JsonProperty("Error")
    private ErrorDto error;

    public ResponseTransactionDto() {

    }
    public ResponseTransactionDto(ErrorDto error) {
        this.error = error;
    }

    public static ResponseTransactionDto converto(TransactionEntity entity) {
        ResponseTransactionDto response = new ResponseTransactionDto();
            TransactionDto transact = new TransactionDto();
            transact.setIdTransaction(entity.getIdTransaction().toString());
            transact.setNumCard(entity.getNumCard());
            DescriptionDto description = new DescriptionDto();
                    description.setEstablishment(entity.getDescription().getEstablishment());
                    description.setValue(entity.getDescription().getValue().toString());
                    description.setDateTime(entity.getDescription().getDateTime().toString());
                    description.setNsu(entity.getDescription().getNsu());
                    description.setAuthCode(entity.getDescription().getAuthCode());
                    description.setStatusTransaction(entity.getDescription().getStatusTransaction());
                    transact.setDescription(description);
                    PaymentMethodDto paymentMethod = new PaymentMethodDto();
                    paymentMethod.setInstallments(entity.getPaymentMethod().getInstallments().toString());{
                        paymentMethod.setType(entity.getPaymentMethod().getType());
                        transact.setPaymentMethod(paymentMethod);
                        response.setTransaction(transact);
                        return response;
        }

    }
}

