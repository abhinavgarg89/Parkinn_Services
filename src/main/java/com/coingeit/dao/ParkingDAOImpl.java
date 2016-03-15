package com.coingeit.dao;

import com.coingeit.db.DBParking;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
@Repository
public class ParkingDAOImpl implements ParkingDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory_;


    Session getSession() {
        return sessionFactory_.getCurrentSession();
    }

    @Override
    @Transactional
    public DBParking getParking(long parkingId) {
        return (DBParking) getSession().get(DBParking.class, parkingId);
    }
    
    @Override
    @Transactional
    public void saveParking(DBParking dbParking) {
        getSession().saveOrUpdate(dbParking);
    }

    @Override
    @Transactional
    public DBParking[] getParkingForLocation(int locationId) {
        List result = getSession().createCriteria(DBParking.class, "parking")
                .createAlias("parking.location_", "location")
                .add(Restrictions.eq("location.id_", locationId))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return (DBParking[]) result.toArray(new DBParking[result.size()]);
    }
}
