package com.coingeit.controller;

import com.coingeit.service.ParkingService;
import com.coingeit.dto.DTOParking;
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
 * Date: 12/03/16
 */
@Controller
@RequestMapping("/parking")
public class ParkingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);
    
    @Autowired
    private ParkingService parkingService_;
    
    Gson gson_ = new Gson();

    @RequestMapping(value = "/get/{parkingId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getParking(@PathVariable("parkingId") long parkingId) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOParking dtoParking = parkingService_.getParking(parkingId);
        String parking = gson_.toJson(dtoParking);
        responseEntity = new ResponseEntity<>(parking, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/getListForLocation/{locationId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getParkingListForLocation(@PathVariable("locationId") int locationId) throws Exception {
        ResponseEntity<String> responseEntity;
        DTOParking[] dtoParking = parkingService_.getParkingsForLocation(locationId);
        String parking = gson_.toJson(dtoParking);
        responseEntity = new ResponseEntity<>(parking, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addParking(@RequestBody String parkingJson) {
        ResponseEntity<String> responseEntity;
        LOGGER.info("AddParking: Json Received: {}", parkingJson);
        DTOParking dtoParking = gson_.fromJson(parkingJson, DTOParking.class);
        LOGGER.info("AddClient: DTO: {}", gson_.toJson(dtoParking));

        parkingService_.addParking(dtoParking);
        responseEntity = new ResponseEntity<>("New Parking has been added successfully", HttpStatus.OK);
        return responseEntity;
    }
}
