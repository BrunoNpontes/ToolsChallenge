package com.toolschallenge.ToolsChallenge.exceptions;

public class MessagesExceptions {

    public static final String NUMBERS_ONLY_ATTRIBUTE_CARD ="Apenas números é permitido neste campo";

    public static final String VALID_IF_NULL_OR_EMPTY = "O campo não pode estar NULL ou vazio";
    public static final String FORMAT_INVALID_FOR_BIGDECIMAL = "O campo deve estar no padrão  bigDeciaml";
    public static final String FORMAT_INVALID_ATTRIBUTE_DATE_TIME = "O campo deve estar no padrão dd/MM/yyyy HH:mm:ss";

    public static final String FORMAT_INVALID_ATTRIBUTE_PAYMENT_METHOD = "O campo permite apenas as contantes (AVISTA, PARCELADO LOJA, PARCELADO EMISSOR)";
    public static final String NOT_DUPLICATE_PAYMENT = "O não e possivel persistir um pagamento mais de uma vez," +
            " o id informado já pertence a uma transação";

    public static final String ID_INVALID = "id invalido, um id valido possui 9 digitos";
    public static final String INVALID_QUANTITY_INSTALLMENTS = "Quatidade de parcelas invalida para pagamento avista" ;
}
