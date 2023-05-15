package com.toolschallenge.ToolsChallenge.service.enums;

import java.io.Serializable;

public enum StatusTransactionEnum implements Serializable {


    AUTHORIZED("AUTORIZADO"), NEGATE("NEGADO"), CANCELED("CANCELADO");

    private final String value;
    StatusTransactionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
