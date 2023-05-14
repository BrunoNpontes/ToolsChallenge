package com.toolschallenge.ToolsChallenge.service.utils;

import java.time.LocalDateTime;

public class GenerateRandomNumber {

    public static String toGenerate(Long id , String numcard){

        String response = id.toString().substring(0,4);
        response+= numcard.substring(8,numcard.length());
        return response;
    }

    public static String toNsu(Long idTransaction) {
        Integer num = LocalDateTime.now().getDayOfMonth();
        return String.valueOf(num * Integer.parseInt(idTransaction.toString().substring(0,6)));
    }
}
