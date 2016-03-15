package com.coingeit.service;

import com.coingeit.dao.ParkingDAO;
import com.coingeit.db.DBParking;
import com.coingeit.dto.DTOParking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
@Service
public class ParkingServiceImpl implements ParkingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingServiceImpl.class);

    @Autowired
    private ParkingDAO parkingDAO_;

    @Override
    public DTOParking getParking(long parkingId) {
        DBParking dbParking = parkingDAO_.getParking(parkingId);
        DTOParking dtoParking = dbParking != null ? dbParking.toDTOParking() : null;
        return dtoParking;
    }

    @Override
    public DTOParking[] getParkingsForLocation(int locationId) {
        DBParking[] dbParkings = parkingDAO_.getParkingForLocation(locationId);
        ArrayList<DTOParking> parkings = new ArrayList<>();
        for (DBParking dbParking : dbParkings) {
            parkings.add(dbParking.toDTOParking());
        }
        return parkings.toArray(new DTOParking[parkings.size()]);
    }

    @Override
    public void addParking(DTOParking dtoParking){
        DBParking dbParking = DBParking.fromDTOParking(dtoParking);
        parkingDAO_.saveParking(dbParking);
    }

}
