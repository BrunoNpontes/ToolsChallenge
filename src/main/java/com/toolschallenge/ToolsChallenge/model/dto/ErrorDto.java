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

    public ErrorDto (Exception e){
        this.code = HttpStatus.INTERNAL_SERVER_ERROR;
        this.error = e.getCause()!=null?e.getCause().getMessage() : "ERROR";
        this.message = e.getMessage() !=null?e.getMessage(): "Ocorreu um erro inesperado";
    }
    public ErrorDto (RequestTransactionException ex){
        this.code = ex.getCode();
        this.error = ex.getError();
        this.message = ex.getMenssagen();
    }
}
