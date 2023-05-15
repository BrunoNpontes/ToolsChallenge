package com.toolschallenge.ToolsChallenge.exceptions;

import org.springframework.http.HttpStatus;

public enum ResponseExceptionEnum {


    VALID_IF_NULL_OR_EMPTY(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo " , MessagesExceptions.VALID_IF_NULL_OR_EMPTY),
    CAMP_IS_NUMERIC_TYPE(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ", MessagesExceptions.NUMBERS_ONLY_ATTRIBUTE_CARD),
    FORMAT_INVALID_FOR_BIGDECIMAL(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ",MessagesExceptions.FORMAT_INVALID_FOR_BIGDECIMAL),
    FORMAT_INVALID_DATE_TIME(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ",MessagesExceptions.FORMAT_INVALID_ATTRIBUTE_DATE_TIME ),
    FORMAT_INVALID_PAYMENT_METHOD(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ",MessagesExceptions.FORMAT_INVALID_ATTRIBUTE_PAYMENT_METHOD),
    NOT_DUPLICATE_PAYMENT(HttpStatus.CONFLICT, "Conflito no atributo ",MessagesExceptions.NOT_DUPLICATE_PAYMENT ),
    ID_INVALID(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ", MessagesExceptions.ID_INVALID ),
    INVALID_QUANTITY_INSTALLMENTS(HttpStatus.BAD_REQUEST, "Erro ao validar o atributo ", MessagesExceptions.INVALID_QUANTITY_INSTALLMENTS),
    TRANSACTION_NOT_FOUND_BY_ID(HttpStatus.NOT_FOUND, "Transação não encontrada com esse ", MessagesExceptions.TRANSACTION_NOT_FOUND_BY_ID),
    TRANSACTION_NOT_FOUND(HttpStatus.NOT_FOUND, "Não a transações", MessagesExceptions.TRANSACTION_NOT_FOUND);

    private final HttpStatus code;
    private final String error;
    private final String mensage;

    ResponseExceptionEnum(HttpStatus code, String error, String mensage ) {
        this.code = code;
        this.error = error;
        this.mensage = mensage;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getMensage() {
        return mensage;
    }




}