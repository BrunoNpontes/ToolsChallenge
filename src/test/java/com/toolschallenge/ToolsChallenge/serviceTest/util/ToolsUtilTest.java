package com.toolschallenge.ToolsChallenge.serviceTest.util;

import com.toolschallenge.ToolsChallenge.exceptions.MessagesExceptions;
import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.service.utils.ToolsUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ToolsUtilTest {

    @InjectMocks
    ToolsUtil tools;

    @Test
    public void revalidCardSuccess() throws RequestTransactionException {
        String numCad = tools.validNumCard("123456124578","cartao");
        assertEquals("123456124578", numCad);
    }

    @Test
    public void validExceptionCard()  {

        //validate if there are only number
        assertEquals(MessagesExceptions.NUMBERS_ONLY_ATTRIBUTE_CARD,
                assertThrows(RequestTransactionException.class, () ->
                        tools.validNumCard("12345fff24578", "cartao"))
                        .getMenssagen());

        //validate if it is null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.validNumCard(null, "cartao"))
                        .getMenssagen());

        //validate if it is empty
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.validNumCard("", "cartao"))
                        .getMenssagen());
    }

    @Test
    public void convertToDateTimeSuccess() throws RequestTransactionException {
        LocalDateTime dt = tools.convertToDateTime("01/01/2023 15:15:30", "dataHora");
        assertNotNull(dt);
    }

    @Test
    public void validExceptionConvertToDateTime()  {
        // validates if the string matches the required format
        assertEquals(MessagesExceptions.FORMAT_INVALID_ATTRIBUTE_DATE_TIME,
                assertThrows(RequestTransactionException.class, () ->
                        tools.convertToDateTime("2023-01-2023 15:15:30", "dataHora"))
                        .getMenssagen());

        // check if it is empty
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.convertToDateTime("", "dataHora"))
                        .getMenssagen());

        // check if it is null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.convertToDateTime(null, "dataHora"))
                        .getMenssagen());
    }

    @Test
    public void convertToBigDecimalSuccess() throws RequestTransactionException {
        BigDecimal value = tools.converToBigdecimal("30.30", "valor");
        assertNotNull(value);
    }


    @Test
    public void validExceptionConvertToBiDecimal()  {
        // validates if it is in the correct path
        assertEquals(MessagesExceptions.FORMAT_INVALID_FOR_BIGDECIMAL,
                assertThrows(RequestTransactionException.class, () ->
                        tools.converToBigdecimal("23,23.00 ", "valor"))
                        .getMenssagen());

        //validate if it is null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.converToBigdecimal(null, "valor"))
                        .getMenssagen());
        //validate if it is empty
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.converToBigdecimal("", "valor"))
                        .getMenssagen());
    }

    @Test
    public void validTypePaymentSuccess() throws RequestTransactionException {
        String value = tools.validTypePayment("AVISTA");
        assertEquals(value, "AVISTA");
    }

    @Test
    public void validTypePaymentFORMAT_INVALID_PAYMENT_METHOD()  {
        assertEquals(MessagesExceptions.FORMAT_INVALID_ATTRIBUTE_PAYMENT_METHOD,
                assertThrows(RequestTransactionException.class, () -> tools.validTypePayment("AVIdSTA"))
                .getMenssagen());
    }

    @Test
    public void validIdSuccess() throws RequestTransactionException {
       Long id = tools.validId("123456789","id");
       assertNotNull(id);
    }

    @Test
    public void validExceptionId()  {

        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validId("","id"))
                        .getMenssagen());

        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validId(null,"id"))
                        .getMenssagen());

        assertEquals(MessagesExceptions.ID_INVALID,
                assertThrows(RequestTransactionException.class, () -> tools.validId("1234789","id"))
                        .getMenssagen());
    }

    @Test
    public void validTypeNumericSuccess() throws RequestTransactionException {
        Boolean valid = tools.validTypeNumeric("123456789","id");
        assertEquals(true, valid);
    }

    @Test
    public void validExceptionTypeNumeric() throws RequestTransactionException {
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validTypeNumeric("","test"))
                        .getMenssagen());

        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validTypeNumeric(null,"test"))
                        .getMenssagen());

        assertEquals(MessagesExceptions.NUMBERS_ONLY_ATTRIBUTE_CARD,
                assertThrows(RequestTransactionException.class, () -> tools.validTypeNumeric("bg34222","test"))
                        .getMenssagen());
       ;
    }

    @Test
    public void validInstallmentsSuccess() throws RequestTransactionException {
        Integer installments = tools.validInstallments("1","AVISTA", "parcelas");
        assertEquals(1, installments);
    }


    @Test
    public void validExceptionInstallments() throws RequestTransactionException {
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments("","AVISTA", "parcelas"))
                        .getMenssagen());

        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments(null,"AVISTA", "parcelas"))
                        .getMenssagen());

        // validates if the type is AVISTA and the quantity and installments is 1
        assertEquals(MessagesExceptions.INVALID_QUANTITY_INSTALLMENTS,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments("5","AVISTA", "parcelas"))
                        .getMenssagen());
    }
}
