package com.toolschallenge.ToolsChallenge.serviceTest;

import com.toolschallenge.ToolsChallenge.MockApplication;
import com.toolschallenge.ToolsChallenge.exceptions.MessagesExceptions;
import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.model.dto.ResponseTransactionDto;
import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import com.toolschallenge.ToolsChallenge.repository.DescriptionRepository;
import com.toolschallenge.ToolsChallenge.repository.PaymentMethodRepository;
import com.toolschallenge.ToolsChallenge.repository.TransactionRepository;
import com.toolschallenge.ToolsChallenge.service.TransactionService;
import com.toolschallenge.ToolsChallenge.service.utils.ToolsUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    TransactionService service;

    @Mock
    private ToolsUtil tools;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private DescriptionRepository descriptionRepository;
    @Mock
    private PaymentMethodRepository paymentMethodRepository;


    @Test
    public void testMakePaymentSuccessAUTHORIZED() throws RequestTransactionException {
        when(tools.validId(any(), any())).thenReturn(Long.parseLong("547689256"));
        when(tools.validNumCard(any(), any())).thenReturn("123456749851");
        when(tools.converToBigdecimal(any(), any())).thenReturn(new BigDecimal("45.23"));
        when(tools.convertToDateTime(any(), any())).thenReturn(LocalDateTime.now());
        when(tools.validTypePayment(any())).thenReturn("AVISTA");
        when(tools.validInstallments(any(), any(), any())).thenReturn(Integer.parseInt("1"));
        ResponseEntity<ResponseTransactionDto> res =  service.makePayment(MockApplication.transactionDto());
        assertEquals(res.getStatusCode(), HttpStatus.OK);
        assertEquals(true, res.getBody().getTransaction().getDescription().
                getStatusTransaction().equals("AUTORIZADO"));
    }


    @Test
    public void testMakePaymentNOT_DUPLICATE_ID() throws RequestTransactionException {
        when(tools.validId(any(), any())).thenReturn(1L);
        when(tools.validNumCard(any(), any())).thenReturn("123456749851");
        when(tools.converToBigdecimal(any(), any())).thenReturn(new BigDecimal("30.00"));
        when(tools.convertToDateTime(any(), any())).thenReturn(LocalDateTime.now());
        when(tools.validTypePayment(any())).thenReturn("AVISTA");
        when(tools.validInstallments(any(), any(), any())).thenReturn(Integer.parseInt("1"));
        Optional<TransactionEntity> optionalTransaction = Optional.of(new TransactionEntity());
        when(transactionRepository.findById(1L)).thenReturn(optionalTransaction);

        ResponseEntity<ResponseTransactionDto> res =  service.makePayment(MockApplication.transactionDto());
        assertEquals(res.getStatusCode(), HttpStatus.CONFLICT);
    }

    @Test
    public void testConsultTransactionById()  {
        ResponseEntity<ResponseTransactionDto> res =  service.consultTransactionById(1L, false);
        verify(transactionRepository).findById(1l);
    }

    @Test
    public void testConsultTransactionByIdCANCELED()  {
        ResponseEntity<ResponseTransactionDto> res =  service.consultTransactionById(1L, true);
        verify(transactionRepository).findChargebackById(1l);
    }

    @Test
    public void testConsultTransactionByIdCANCELEDAll()  {
        ResponseEntity<?> res =  service.consultTransactionByAll( true);
        verify(transactionRepository).findChargebackAll();
    }
    @Test
    public void testConsultTransactionAll()  {
        ResponseEntity<?> res =  service.consultTransactionByAll( false);
        verify(transactionRepository).findAll();
    }

}
