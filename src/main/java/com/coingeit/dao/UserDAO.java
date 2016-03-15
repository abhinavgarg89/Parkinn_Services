package com.coingeit.dao;

import com.coingeit.db.DBUser;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public interface UserDAO {

    public DBUser getUserByEmail(String email);

    public DBUser getUserByUserName(String userName);

    public DBUser getUserById(long userId);

    public void saveUser(DBUser dbUser);
}
