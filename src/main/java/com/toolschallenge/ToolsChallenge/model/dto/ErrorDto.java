package com.toolschallenge.ToolsChallenge.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;


@Data
public class ErrorDto implements Serializable {
    @JsonProperty("codigo")
    private HttpStatus code;
    @JsonProperty("erro")
    private String error;
    @JsonProperty("mensagem")
    private  String message;

    public ErrorDto (RequestTransactionException ex){
        this.code = ex.getCode();
        this.error = ex.getError();
        this.message = ex.getMenssagen();
    }
}
