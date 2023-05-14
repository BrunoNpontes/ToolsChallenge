package com.toolschallenge.ToolsChallenge.controllerTest;

import com.toolschallenge.ToolsChallenge.MockApplication;
import com.toolschallenge.ToolsChallenge.controller.TransactionController;
import com.toolschallenge.ToolsChallenge.model.dto.ResponseTransactionDto;
import com.toolschallenge.ToolsChallenge.model.dto.TransactionDto;
import com.toolschallenge.ToolsChallenge.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @InjectMocks
    TransactionController controller;

    @Mock
    TransactionService service;


    @Test
    public void testMakePaymentSucess(){
        TransactionDto request = MockApplication.transactionDto();
        when(service.makePayment(request)).thenReturn(MockApplication.responseTransactionDtoResponseEntitySucess());
        ResponseEntity<ResponseTransactionDto> res = controller.makePayment(request);
        assertEquals(res.getStatusCode(), MockApplication.responseTransactionDtoResponseEntitySucess().getStatusCode());
        assertNotNull(res.getBody().getTransaction());
    }

    @Test
    public void testMakePaymentBad(){
        TransactionDto request = MockApplication.transactionDto();
        when(service.makePayment(request)).thenReturn(MockApplication.responseTransactionDtoResponseEntityBad());
        ResponseEntity<ResponseTransactionDto> res = controller.makePayment(request);
        assertEquals(res.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}
