package com.coingeit.controller;

import com.coingeit.dto.DTOUser;
import com.coingeit.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);

    @Autowired
    private UserService userService_;

    Gson gson_ = new Gson();

    @RequestMapping(value = "/getUserByEmail/{userEmail}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUserByEmail(@PathVariable("userEmail") String email) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOUser dtoUser = userService_.getUserByEmail(email);
        String user = gson_.toJson(dtoUser);
        responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/getUserByUserName/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUserByUserName(@PathVariable("userName") String userName) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOUser dtoUser = userService_.getUserByUserName(userName);
        String user = gson_.toJson(dtoUser);
        responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/addWalletToUser/{userId}/{walletId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addWallet(@PathVariable("walletId") long walletId, @PathVariable("userId") long userId) throws Exception {
        ResponseEntity<String> responseEntity;
        LOGGER.info("AddWallet: Wallet Id Received: {}", walletId);
        userService_.addWallet(userId, walletId);
        responseEntity = new ResponseEntity<>("Wallet has been added to User successfully", HttpStatus.OK);
        return responseEntity;
    }
}
