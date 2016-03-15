package com.coingeit.dao;

import com.coingeit.db.DBWallet;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public interface WalletDAO {

    public int getBalance(long walletId);
    
    void addBalance(long walletId, int amount);

    public DBWallet getWallet(long walletId);

    public void saveWallet(DBWallet dbWallet);
}
