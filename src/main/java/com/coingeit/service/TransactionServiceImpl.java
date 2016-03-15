package com.coingeit.service;

import com.coingeit.dao.TransactionDAO;
import com.coingeit.db.DBTransaction;
import com.coingeit.db.DBTransactionStatus;
import com.coingeit.dto.DTOTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionDAO transactionDAO_;
    
    @Override
    public DTOTransaction[] getTransactionsForUser(long userId) {
        DBTransaction[] dbTransactions= transactionDAO_.getTransactionsForUser(userId);
        ArrayList<DTOTransaction> transactions = new ArrayList<>();
        for (DBTransaction dbTransaction : dbTransactions) {
            transactions.add(dbTransaction.toDTOTransaction());
        }
        return transactions.toArray(new DTOTransaction[transactions.size()]);
    }

    @Override
    public void addUserTransaction(DTOTransaction dtoTransaction) {
        DBTransaction dbTransaction = DBTransaction.fromDTOTransaction(dtoTransaction);
        dbTransaction.setStatus(DBTransactionStatus.UPCOMING);
        transactionDAO_.addUserTransaction(dbTransaction);
    }

    @Override
    public void cancelUserTransaction(DTOTransaction dtoTransaction) {
        DBTransaction dbTransaction = DBTransaction.fromDTOTransaction(dtoTransaction);
        dbTransaction.setStatus(DBTransactionStatus.UPCOMING);
        transactionDAO_.addUserTransaction(dbTransaction);
    }
}
