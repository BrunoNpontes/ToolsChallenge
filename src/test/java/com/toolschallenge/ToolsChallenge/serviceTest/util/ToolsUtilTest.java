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

        //valida se tem apenas numeros
        assertEquals(MessagesExceptions.NUMBERS_ONLY_ATTRIBUTE_CARD,
                assertThrows(RequestTransactionException.class, () ->
                        tools.validNumCard("12345fff24578", "cartao"))
                        .getMenssagen());

        //valida se esta null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.validNumCard(null, "cartao"))
                        .getMenssagen());

        //valida se esta vazio
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
        // valida se a string esta diacordo com o formato exigido
        assertEquals(MessagesExceptions.FORMAT_INVALID_ATTRIBUTE_DATE_TIME,
                assertThrows(RequestTransactionException.class, () ->
                        tools.convertToDateTime("2023-01-2023 15:15:30", "dataHora"))
                        .getMenssagen());

        //verifica se esta vazia
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.convertToDateTime("", "dataHora"))
                        .getMenssagen());

        // verifica se esta null
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
        // valida se esta no patão correto
        assertEquals(MessagesExceptions.FORMAT_INVALID_FOR_BIGDECIMAL,
                assertThrows(RequestTransactionException.class, () ->
                        tools.converToBigdecimal("23,23.00 ", "valor"))
                        .getMenssagen());

        //valida se esta null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () ->
                        tools.converToBigdecimal(null, "valor"))
                        .getMenssagen());
        //valida se esta vazio
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

        //valida se esta vazio
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validId("","id"))
                        .getMenssagen());
        //valida se esta null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validId(null,"id"))
                        .getMenssagen());
        // valida se esta no formato valido
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
        // valida se esta no vazio
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validTypeNumeric("","test"))
                        .getMenssagen());
        // valida se esta no null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validTypeNumeric(null,"test"))
                        .getMenssagen());

        // valida se contem apenas numeros
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
        // valida se esta no vazio
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments("","AVISTA", "parcelas"))
                        .getMenssagen());
        // valida se esta no null
        assertEquals(MessagesExceptions.VALID_IF_NULL_OR_EMPTY,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments(null,"AVISTA", "parcelas"))
                        .getMenssagen());

        // valida se o tipo e avista e a quantidade e parcelas e 1
        assertEquals(MessagesExceptions.INVALID_QUANTITY_INSTALLMENTS,
                assertThrows(RequestTransactionException.class, () -> tools.validInstallments("5","AVISTA", "parcelas"))
                        .getMenssagen());
    }
}
