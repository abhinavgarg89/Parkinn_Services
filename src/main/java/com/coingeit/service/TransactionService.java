package com.coingeit.service;

import com.coingeit.dto.DTOTransaction;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
public interface TransactionService {
    
    public DTOTransaction[] getTransactionsForUser(long userId);

    public void addUserTransaction(DTOTransaction dtoTransaction);

    public void cancelUserTransaction(DTOTransaction dtoTransaction);
}
