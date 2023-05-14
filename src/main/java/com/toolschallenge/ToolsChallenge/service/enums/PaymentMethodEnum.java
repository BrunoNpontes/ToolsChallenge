package com.toolschallenge.ToolsChallenge.service.enums;

public enum PaymentMethodEnum {

    CASH("AVISTA") {
        @Override
        public Boolean checksTypes() {
           if(this.getValue().equals("AVISTA"))
               return true;

           return PARCELED_STORE.checksTypes();
        }
    }, PARCELED_STORE("PARCELADO LOJA") {
        @Override
        public Boolean checksTypes() {
            if(this.getValue().equals("PARCELADO LOJA"))
                return true;

            return ISSUER_INSTALLMENT.checksTypes();
        }
    },
    ISSUER_INSTALLMENT("PARCELADO EMISSOR") {
        @Override
        public Boolean checksTypes() {
            if(this.getValue().equals("PARCELADO EMISSOR"))
                return true;

            return false;
        }
    };

    private final String value;
    PaymentMethodEnum(String value) {
        this.value = value;
    }

    public abstract Boolean checksTypes();


    public String getValue() {
        return value;
    }
}
