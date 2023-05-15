package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    public ResponseTransactionDto(TransactionEntity entity) {
        this.transaction = new TransactionDto(entity);
    }


    public static List<ResponseTransactionDto> convertToListDTO(List<TransactionEntity> result) {
        return result.stream().map(ResponseTransactionDto::new).toList();
    }
}

