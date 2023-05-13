package com.toolschallenge.ToolsChallenge.service.enums;

import java.io.Serializable;

public enum StatusTransactionEnum implements Serializable {


    CASH("AVISTA"), PARCELED_STORE("PARCELADO LOJA"),
    ISSUER_INSTALLMENT("PARCELADO EMISSOR") ;

    private final String value;
    StatusTransactionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
