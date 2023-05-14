package com.toolschallenge.ToolsChallenge.controllerTest;

import com.google.gson.Gson;
import com.toolschallenge.ToolsChallenge.model.dto.DescriptionDto;
import com.toolschallenge.ToolsChallenge.model.dto.PaymentMethodDto;
import com.toolschallenge.ToolsChallenge.model.dto.TransactionDto;
import com.toolschallenge.ToolsChallenge.service.enums.PaymentMethodEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransactionControllerTest {
    @Test
    public void t(){
        Gson g = new Gson();
        TransactionDto dto = new TransactionDto();
        dto.setIdTransaction("445");
        dto.setNumCard("4578545581945618");
        DescriptionDto des = new DescriptionDto();
        des.setDateTime(LocalDateTime.now().toString());
        des.setValue("45.23");
        des.setEstablishment("posto");
        dto.setDescription(des);
        PaymentMethodDto payment = new PaymentMethodDto();
        payment.setType(PaymentMethodEnum.CASH.getValue());
        payment.setInstallments("12");
        String s = g.toJson(dto);
        System.out.println(s);

    }
}
