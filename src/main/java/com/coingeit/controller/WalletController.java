package com.coingeit.controller;

import com.coingeit.dto.DTOWallet;
import com.coingeit.service.WalletService;
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
 * Date: 13/03/16
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService_;

    Gson gson_ = new Gson();

    @RequestMapping(value = "/get/{walletId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getWallet(@PathVariable("walletId") long walletId) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOWallet dtoWallet = walletService_.getWallet(walletId);
        String wallet = gson_.toJson(dtoWallet);
        responseEntity = new ResponseEntity<>(wallet, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/getWalletBalance/{walletId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getWalletBalance(@PathVariable("walletId") long walletId) throws Exception {
        ResponseEntity<String> responseEntity;
        int  balance = walletService_.getBalance(walletId);
        String walletBalance = gson_.toJson(balance);
        responseEntity = new ResponseEntity<>(walletBalance, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/addBalance/{walletId}/{amount}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addBalance(@PathVariable("walletId") long walletId, @PathVariable("amount") int amount) throws Exception {
        ResponseEntity<String> responseEntity;
        walletService_.addBalance(walletId, amount);
        responseEntity = new ResponseEntity<>("Balance has been added successfully", HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addWallet(@RequestBody String walletJson) throws Exception {
        ResponseEntity<String> responseEntity;
        LOGGER.info("AddWallet: Json Received: {}", walletJson);
        DTOWallet dtoWallet = gson_.fromJson(walletJson, DTOWallet.class);
        LOGGER.info("AddWallet: DTO: {}", gson_.toJson(dtoWallet));
        walletService_.addWallet(dtoWallet);
        responseEntity = new ResponseEntity<>("Wallet has been created successfully", HttpStatus.OK);
        return responseEntity;
    }
}
