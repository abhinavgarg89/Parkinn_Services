package com.coingeit.controller;

import com.coingeit.config.ParkinnConstants;
import com.coingeit.dto.DTOAuthResponse;
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
 * Date: 14/03/16
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService_;

    Gson gson_ = new Gson();

    @RequestMapping(value = "/email/{userEmail}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> authUserByEmail(@PathVariable("userEmail") String email, @PathVariable("password") String password) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOUser dtoUser = userService_.getUserByEmail(email);
        String authResponseJson = gson_.toJson(getAuthResponse(dtoUser.getPassword(), password));
        responseEntity = new ResponseEntity<>(authResponseJson, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/userName/{userName}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> authUserByuserName(@PathVariable("userName") String userName, @PathVariable("password") String password) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOUser dtoUser = userService_.getUserByUserName(userName);
        String authResponseJson = gson_.toJson(getAuthResponse(dtoUser.getPassword(), password));
        responseEntity = new ResponseEntity<>(authResponseJson, HttpStatus.OK);
        return responseEntity;
    }

    private DTOAuthResponse getAuthResponse(String storedPassword, String enteredPassword) {
        return storedPassword.equals(enteredPassword) ? new DTOAuthResponse(true, ParkinnConstants.AUTH_SUCCESS) :
                new DTOAuthResponse(false, ParkinnConstants.NON_MATCHED_PASSWORD);
    }
}
