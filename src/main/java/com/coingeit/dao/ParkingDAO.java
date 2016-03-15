package com.coingeit.dao;

import com.coingeit.db.DBParking;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
public interface ParkingDAO {
    
    public DBParking getParking(long parkingId);
    
    public void saveParking(DBParking dbParking);

    public DBParking[] getParkingForLocation(int locationId);

    
}
