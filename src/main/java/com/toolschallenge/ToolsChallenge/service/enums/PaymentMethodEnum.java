package com.toolschallenge.ToolsChallenge.service.enums;

public enum PaymentMethodEnum {

    CASH("AVISTA"), PARCELED_STORE("PARCELADO LOJA"),
    ISSUER_INSTALLMENT("PARCELADO EMISSOR") ;

    private final String value;
    PaymentMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
