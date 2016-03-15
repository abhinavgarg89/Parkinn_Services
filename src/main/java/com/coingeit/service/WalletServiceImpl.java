package com.coingeit.service;

import com.coingeit.dao.WalletDAO;
import com.coingeit.db.DBWallet;
import com.coingeit.dto.DTOWallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Service
public class WalletServiceImpl implements WalletService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Autowired
    private WalletDAO walletDAO_;
    
    @Override
    public int getBalance(long walletId) {
        return walletDAO_.getBalance(walletId);
    }

    @Override
    public DTOWallet getWallet(long walletId){
        DBWallet dbWallet = walletDAO_.getWallet(walletId);
        return dbWallet != null ? dbWallet.toDTOWallet() : null;
    }

    @Override
    public void addBalance(long walletId, int amount){
        walletDAO_.addBalance(walletId, amount);
    }

    public void addWallet(DTOWallet dtoWallet) {
        DBWallet dbWallet = DBWallet.fromDTOWallet(dtoWallet);
        walletDAO_.saveWallet(dbWallet);
    }
}
