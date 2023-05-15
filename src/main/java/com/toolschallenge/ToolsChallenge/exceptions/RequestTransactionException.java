package com.toolschallenge.ToolsChallenge.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RequestTransactionException extends Exception{

    private HttpStatus code;
    private String menssagen;
    private String error;

    public RequestTransactionException(ResponseExceptionEnum ex, String nameCamp) {
        super();
        this.menssagen = ex.getMensage();
        this.code = ex.getCode();
        this.error = ex.getError()+nameCamp;
    }




}
