package com.coingeit.service;

import com.coingeit.dto.DTOWallet;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public interface WalletService {

    public int getBalance(long walletId);

    public DTOWallet getWallet(long walletId);

    public void addBalance(long walletId, int amount);

    public void addWallet(DTOWallet dtoWallet);
}
