package com.coingeit.controller;

import com.coingeit.dto.DTOTransaction;
import com.coingeit.service.TransactionService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 14/03/16
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService_;

    Gson gson_ = new Gson();

    @RequestMapping(value = "/getUserTransactions/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUserTransactions(@PathVariable("userId") long userId) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOTransaction[] dtoTransactions = transactionService_.getTransactionsForUser(userId);
        String parking = gson_.toJson(dtoTransactions);
        responseEntity = new ResponseEntity<>(parking, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/createUserTransaction/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> createUserTransaction(@RequestBody String transactionJson) throws Exception {
        ResponseEntity<String> responseEntity;
        LOGGER.info("Create Transaction: Json Received: {}", transactionJson);
        DTOTransaction dtoTransaction = gson_.fromJson(transactionJson, DTOTransaction.class);
        LOGGER.info("Create Transaction: DTO: {}", gson_.toJson(dtoTransaction));
        transactionService_.addUserTransaction(dtoTransaction);
        responseEntity = new ResponseEntity<>("New Transaction has been added successfully", HttpStatus.OK);
        return responseEntity;
    }

//    @RequestMapping(value = "/cancelTransaction/{transactionId}", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<String> createUserTransaction(@PathVariable("transactionId") long transactionId) throws Exception {
//        ResponseEntity<String> responseEntity;
//        LOGGER.info("Cancel Transaction: : TransactionId : {}", transactionId);
//        DTOTransaction dtoTransaction = gson_.fromJson(transactionJson, DTOTransaction.class);
//        LOGGER.info("Create Transaction: DTO: {}", gson_.toJson(dtoTransaction));
//        transactionService_.addUserTransaction(dtoTransaction);
//        responseEntity = new ResponseEntity<>("New Transaction has been added successfully", HttpStatus.OK);
//        return responseEntity;
//    }
    
}
