package com.toolschallenge.ToolsChallenge.service.enums;

public enum PaymentMethodEnum {

    CASH("AVISTA") {
        @Override
        public Boolean nexTypes(String value) {
           if(this.getValue().equals(value))
               return true;

           return PARCELED_STORE.nexTypes(value);
        }
    }, PARCELED_STORE("PARCELADO LOJA") {
        @Override
        public Boolean nexTypes(String value) {
            if(this.getValue().equals(value))
                return true;

            return ISSUER_INSTALLMENT.nexTypes(value);
        }
    },
    ISSUER_INSTALLMENT("PARCELADO EMISSOR") {
        @Override
        public Boolean nexTypes(String value)  {
            if(this.getValue().equals(value))
                return true;

            return false;
        }
    };

    private final String value;
    PaymentMethodEnum(String value) {
        this.value = value;
    }

    public abstract Boolean nexTypes(String value);


    public String getValue() {
        return value;
    }
}
