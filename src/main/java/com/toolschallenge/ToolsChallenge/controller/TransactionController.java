package com.toolschallenge.ToolsChallenge.controller;

import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.model.dto.TransactionDto;
import com.toolschallenge.ToolsChallenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService service;

    @RequestMapping(value = "make/payment", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> makePayment(@RequestBody TransactionDto request) {
    return service.makePayment(request);
    }

}
