package com.coingeit.dao;

import com.coingeit.db.DBTransaction;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
public interface TransactionDAO {

    public DBTransaction[] getTransactionsForUser(long userId);

    public void addUserTransaction(DBTransaction dbTransaction);
}
