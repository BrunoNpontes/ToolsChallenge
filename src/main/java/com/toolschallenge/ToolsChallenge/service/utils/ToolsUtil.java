package com.toolschallenge.ToolsChallenge.service.utils;

import com.toolschallenge.ToolsChallenge.exceptions.ResponseExceptionEnum;
import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.service.enums.PaymentMethodEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ToolsUtil {

    public static String LocalDateTimeToString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return date.format(formatter);
    }

    public String validNumCard(String numCard, String nameCamp) throws RequestTransactionException {
        validIfNullOrEmpty(numCard, nameCamp);

        // Remove quaisquer espaços em branco ou traços do número do cartão
        numCard = numCard.replaceAll("[\\s-]", "");

        // Verifica se o número do cartão tem pelo menos 12 dígitos e se é numérico
        if (numCard.length() < 12 || !numCard.matches("[0-9]+")) {
            throw new RequestTransactionException(ResponseExceptionEnum.CAMP_IS_NUMERIC_TYPE, nameCamp);
        }
        return numCard;
    }



    public  <T> void validIfNullOrEmpty(T object, String nameCamp) throws RequestTransactionException {
        Optional<T> optional = Optional.ofNullable(object);
        if (optional.isEmpty() || optional.get() instanceof String && optional.get() == "") {
            throw new RequestTransactionException(ResponseExceptionEnum.VALID_IF_NULL_OR_EMPTY, nameCamp);
        }
    }

    public LocalDateTime convertToDateTime(String dateTime, String nameCamp) throws RequestTransactionException {
        validIfNullOrEmpty(dateTime, "datHora");
        if(!dateTime.matches("^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}$")){
            throw new RequestTransactionException(ResponseExceptionEnum.FORMAT_INVALID_DATE_TIME, nameCamp);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, formatter);
    }

    public BigDecimal converToBigdecimal(String value, String nameCamp) throws RequestTransactionException {
        validIfNullOrEmpty(value, nameCamp);
         if( !value.matches("^[0-9.,]+$")){
            throw new RequestTransactionException(ResponseExceptionEnum.FORMAT_INVALID_FOR_BIGDECIMAL, nameCamp);
        }
        return new BigDecimal(value.replaceAll(",", "."));
    }


    public String validTypePayment(String type) throws RequestTransactionException {
        String nameCamp = "tipo";
        validIfNullOrEmpty(type, nameCamp);
        if(PaymentMethodEnum.CASH.nexTypes(type)){
            return type;
        }else{
            throw new RequestTransactionException(ResponseExceptionEnum.FORMAT_INVALID_PAYMENT_METHOD, nameCamp);
        }
    }

    public Long validId(String id, String nameCamp) throws RequestTransactionException {
        if(validTypeNumeric(id, "id")){
            if(id.length() !=9){
                throw new RequestTransactionException(ResponseExceptionEnum.ID_INVALID,"id");
            }
        }
        return Long.parseLong(id);
    }

    public Boolean validTypeNumeric(String value, String nameCamp) throws RequestTransactionException {
        validIfNullOrEmpty(value, nameCamp );
        if(!value.matches("^[0-9]+$")){
            throw new RequestTransactionException(ResponseExceptionEnum.CAMP_IS_NUMERIC_TYPE, nameCamp);
        }
        return true;
    }

    public Integer validInstallments(String installments, String type, String nameCamp) throws RequestTransactionException {
        Integer response =0;
        if(validTypeNumeric(installments, "parcelas")){
             response = Integer.parseInt(installments);
            if(response > 1 && type.equals(PaymentMethodEnum.CASH.getValue())){
                throw new RequestTransactionException(ResponseExceptionEnum.INVALID_QUANTITY_INSTALLMENTS, nameCamp);
            }
        }
        return response;
    }
}
