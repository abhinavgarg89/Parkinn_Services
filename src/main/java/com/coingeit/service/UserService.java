package com.coingeit.service;

import com.coingeit.dto.DTOUser;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public interface UserService {

    public DTOUser getUserByEmail(String userEmail);
    
    public DTOUser getUserByUserName(String userName);

    void addWallet(long userId, long walletId);
}
