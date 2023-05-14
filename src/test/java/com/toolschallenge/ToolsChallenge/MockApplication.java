package com.toolschallenge.ToolsChallenge;

import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.exceptions.ResponseExceptionEnum;
import com.toolschallenge.ToolsChallenge.model.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class MockApplication {

    public static TransactionDto transactionDto() {
        TransactionDto transact = new TransactionDto();
        transact.setIdTransaction("547689256");
        transact.setNumCard("123456749851");
        DescriptionDto description = new DescriptionDto();
        description.setEstablishment("Posto Atem");
        description.setValue("34.65");
        description.setDateTime(LocalDateTime.now().toString());
        description.setNsu("3632352");
        description.setAuthCode("652566593");
        description.setStatusTransaction("AUTORIZADO");
        transact.setDescription(description);
        PaymentMethodDto paymentMethod = new PaymentMethodDto();
        paymentMethod.setInstallments("1");
        paymentMethod.setType("AVISTA");
        transact.setPaymentMethod(paymentMethod);
        return transact;
    }

    public static ResponseEntity<ResponseTransactionDto> responseTransactionDtoResponseEntitySucess() {
        return new  ResponseEntity<ResponseTransactionDto> (responseTransactionDto(),HttpStatus.OK);
    }

    public static ResponseEntity<ResponseTransactionDto> responseTransactionDtoResponseEntityBad() {
        ResponseTransactionDto dto =new ResponseTransactionDto();
        dto.setError(errorDto());
        return new  ResponseEntity<ResponseTransactionDto> (dto,dto.getError().getCode());
    }

    public static ErrorDto errorDto(){
        RequestTransactionException exception =
                new RequestTransactionException(ResponseExceptionEnum.ID_INVALID,"id");
        ErrorDto errorDto = new ErrorDto( exception);
        return  errorDto;
    }

    public static ResponseTransactionDto responseTransactionDto() {
        ResponseTransactionDto dto = new ResponseTransactionDto();
        dto.setTransaction(transactionDto());
        return dto;
    }
}
