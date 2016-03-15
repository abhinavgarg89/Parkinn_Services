package com.coingeit.service;

import com.coingeit.dto.DTOParking;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
public interface ParkingService {
    
    public DTOParking getParking (long parkingId);
    
    public DTOParking[] getParkingsForLocation (int locationId);

    public void addParking(DTOParking dtoParking);
}
