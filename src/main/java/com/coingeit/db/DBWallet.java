package com.coingeit.db;

import com.coingeit.dto.DTOWallet;

import javax.persistence.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Entity
@Table(name = "WALLET")
public class DBWallet {

    @Id
    @GeneratedValue(generator = "WALLET_SEQ")
    @SequenceGenerator(name = "WALLET_SEQ", sequenceName = "WALLET_SEQ")
    @Column(name = "WALLET_ID")
    private long id_;

    @Column(name = "BALANCE")
    private int balance_;

    public long getId() {
        return id_;
    }
    
    public int getBalance() {
        return balance_;
    }

    public void setBalance(int balance) {
        balance_ = balance;
    }

    public DTOWallet toDTOWallet() {
        return new DTOWallet(
                id_,
                balance_
        );
    }

    public static DBWallet fromDTOWallet(DTOWallet dtoWallet) {
        DBWallet dbWallet = new DBWallet();
        dbWallet.setBalance(dtoWallet.getBalance());
        return dbWallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBWallet dbWallet = (DBWallet) o;

        if (balance_ != dbWallet.balance_) return false;
        if (id_ != dbWallet.id_) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_ ^ (id_ >>> 32));
        result = 31 * result + balance_;
        return result;
    }
}
