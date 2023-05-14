package com.toolschallenge.ToolsChallenge.service;

import com.toolschallenge.ToolsChallenge.exceptions.RequestTransactionException;
import com.toolschallenge.ToolsChallenge.exceptions.ResponseExceptionEnum;
import com.toolschallenge.ToolsChallenge.model.dto.*;
import com.toolschallenge.ToolsChallenge.model.entitys.DescriptionEntity;
import com.toolschallenge.ToolsChallenge.model.entitys.PaymentMethodEntity;
import com.toolschallenge.ToolsChallenge.model.entitys.TransactionEntity;
import com.toolschallenge.ToolsChallenge.repository.DescriptionRepository;
import com.toolschallenge.ToolsChallenge.repository.PaymentMethodRepository;
import com.toolschallenge.ToolsChallenge.repository.TransactionRepository;
import com.toolschallenge.ToolsChallenge.service.enums.StatusTransactionEnum;
import com.toolschallenge.ToolsChallenge.service.utils.ToolsUtil;
import com.toolschallenge.ToolsChallenge.service.utils.GenerateRandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private ToolsUtil tools;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    private TransactionEntity transactionEntity;

    private static final BigDecimal DAILY_LIMIT_VALUE = new BigDecimal("30000.00");

    public ResponseEntity<ResponseTransactionDto> makePayment(TransactionDto request) {
        try{
            prepareRequestPayment(request);
            ResponseTransactionDto response = executPayment(transactionEntity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (RequestTransactionException ex){
            ErrorDto error = new ErrorDto(ex);
            return new ResponseEntity<>(new ResponseTransactionDto(error), error.getCode());
        }
    }

    private ResponseTransactionDto executPayment(TransactionEntity transactionEntity) throws RequestTransactionException {
        authorizationPayment();
        if(transactionEntity.getDescription().getStatusTransaction().
                equals(StatusTransactionEnum.AUTHORIZED.getValue())){

            descriptionRepository.save(transactionEntity.getDescription());
            paymentMethodRepository.save(transactionEntity.getPaymentMethod());
            transactionRepository.save(transactionEntity);
        }
        return ResponseTransactionDto.converto(transactionEntity);
    }

    private void authorizationPayment() throws RequestTransactionException {
        Optional<TransactionEntity> optional =transactionRepository.findById(transactionEntity.getIdTransaction());
        if(optional.isPresent()){
            throw  new RequestTransactionException(ResponseExceptionEnum.NOT_DUPLICATE_PAYMENT, "id");
        }
        if (transactionEntity.getDescription().getValue().compareTo(DAILY_LIMIT_VALUE)< 0 ){
            transactionEntity.getDescription().setAuthCode(GenerateRandomNumber.
                    toGenerate(transactionEntity.getIdTransaction(), transactionEntity.getNumCard()));
            transactionEntity.getDescription().setNsu(GenerateRandomNumber.toNsu(transactionEntity.getIdTransaction()));
            transactionEntity.getDescription().setStatusTransaction(StatusTransactionEnum.AUTHORIZED.getValue());
        }else{
            transactionEntity.getDescription().setStatusTransaction(StatusTransactionEnum.NEGATE.getValue());
        }

    }

    private void prepareRequestPayment(TransactionDto request) throws RequestTransactionException {
        transactionEntity = new TransactionEntity();
        transactionEntity.setIdTransaction(tools.validId(request.getIdTransaction(),"id"));
        transactionEntity.setNumCard(tools.validationNumCard(request.getNumCard(), "cartao"));
        transactionEntity.setDescription(prepareDescription(request.getDescription()));
        transactionEntity.setPaymentMethod(preparePaymentMethod(request.getPaymentMethod()));
    }

    private PaymentMethodEntity preparePaymentMethod(PaymentMethodDto paymentMethod) throws RequestTransactionException {
        tools.validIfNullOrEmpty(paymentMethod,"formaPagamento");
        PaymentMethodEntity response = new PaymentMethodEntity();
        response.setType(tools.validTypePayment(paymentMethod.getType()));
        response.setInstallments(tools.validInstallments(paymentMethod.getInstallments(), paymentMethod.getType(), "parcelas"));
        return  response;
    }

    public DescriptionEntity prepareDescription(DescriptionDto description) throws RequestTransactionException {
        tools.validIfNullOrEmpty(description,"descricao");
        DescriptionEntity response = new DescriptionEntity();
        response.setValue(tools.converToBigdecimal(description.getValue(), "valor"));
        response.setDateTime(tools.converToDateTime(description.getDateTime(),"dataHora"));
        tools.validIfNullOrEmpty(description.getEstablishment(),"estabelecimento");
        response.setEstablishment(description.getEstablishment());
        return  response;
    }








}
