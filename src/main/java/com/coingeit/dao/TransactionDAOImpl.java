package com.coingeit.dao;

import com.coingeit.db.DBTransaction;
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
 * Date: 15/03/16
 */
@Repository
public class TransactionDAOImpl implements TransactionDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory_;


    Session getSession() {
        return sessionFactory_.getCurrentSession();
    }

    @Override
    @Transactional
    public DBTransaction[] getTransactionsForUser(long userId) {
        List result = getSession().createCriteria(DBTransaction.class, "transaction")
                .createAlias("transaction.user_", "user")
                .add(Restrictions.eq("user.id_", userId))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return (DBTransaction[]) result.toArray(new DBTransaction[result.size()]);
    }

    @Override
    @Transactional
    public void addUserTransaction(DBTransaction dbTransaction) {
        
    }
}
