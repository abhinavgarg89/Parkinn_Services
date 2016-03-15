package com.coingeit.dao;

import com.coingeit.db.DBWallet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Repository
public class WalletDAOImpl implements WalletDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory_;


    Session getSession() {
        Session session = sessionFactory_.getCurrentSession();
        return session;
    }

    @Override
    public void saveWallet(DBWallet dbWallet) {
        getSession().saveOrUpdate(dbWallet);
    }
    
    @Override
    @Transactional
    public DBWallet getWallet(long walletId) {
        return ((DBWallet) getSession().get(DBWallet.class, walletId));
    }

    @Override
    @Transactional
    public void addBalance(long walletId, int amount) {
        DBWallet wallet = ((DBWallet) getSession().get(DBWallet.class, walletId));
        wallet.setBalance(wallet.getBalance() + amount);
        getSession().saveOrUpdate(wallet);
    }

    @Override
    @Transactional
    public int getBalance(long walletId) {
        return ((DBWallet) getSession().get(DBWallet.class, walletId)).getBalance();
    }

    
}
