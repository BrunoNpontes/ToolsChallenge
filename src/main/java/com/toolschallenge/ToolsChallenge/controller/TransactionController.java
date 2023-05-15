package com.toolschallenge.ToolsChallenge.controller;

import com.toolschallenge.ToolsChallenge.model.dto.ResponseTransactionDto;
import com.toolschallenge.ToolsChallenge.model.dto.TransactionDto;
import com.toolschallenge.ToolsChallenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService service;

    @RequestMapping(value = "make/payment", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseTransactionDto> makePayment(@RequestBody TransactionDto request) {
    return service.makePayment(request);
    }

    @RequestMapping(value = "consult/payment/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ResponseTransactionDto> consultTransactionById(@PathVariable Long id) {
        return service.consultTransactionById(id,false);
    }

    @RequestMapping(value = "consult/payment/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> consultTransactionAll() {
        return service.consultTransactionByAll(false);
    }

    @RequestMapping(value = "consult/payment/chargeback/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> consultTransactionChargebackId(@PathVariable Long id) {
        return service.consultTransactionById(id, true);
    }

    @RequestMapping(value = "consult/payment/chargeback/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> consultTransactionChargebackId() {
        return service.consultTransactionByAll(true);
    }
}
