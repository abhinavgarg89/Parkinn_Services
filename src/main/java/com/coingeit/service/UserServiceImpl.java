package com.coingeit.service;

import com.coingeit.dao.UserDAO;
import com.coingeit.dao.WalletDAO;
import com.coingeit.db.DBUser;
import com.coingeit.dto.DTOUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO_;
    
    @Autowired
    private WalletDAO walletDAO_;
    
    @Override
    public DTOUser getUserByEmail(String userEmail) {
        DBUser dbUser = userDAO_.getUserByEmail(userEmail);
        return dbUser != null ? dbUser.toDTOUser() : null;
    }

    @Override
    public DTOUser getUserByUserName(String userName) {
        DBUser dbUser = userDAO_.getUserByUserName(userName);
        return dbUser != null ? dbUser.toDTOUser() : null;
    }

    @Override
    @Transactional
    public void addWallet(long userId, long walletId) {
        DBUser dbUser = userDAO_.getUserById(userId);
        dbUser.setWallet(walletDAO_.getWallet(walletId));
        userDAO_.saveUser(dbUser);
    }
}
