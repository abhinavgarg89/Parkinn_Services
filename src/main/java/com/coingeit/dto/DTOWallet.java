package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public class DTOWallet {

    @SerializedName(value = "walletId")
    private long id_;

    @SerializedName(value = "balance")
    private int balance_;

    public DTOWallet(long id, int balance) {
        id_ = id;
        balance_ = balance;
    }

    public long getId() {
        return id_;
    }

    public void setId(long id) {
        id_ = id;
    }

    public int getBalance() {
        return balance_;
    }

    public void setBalance(int balance) {
        balance_ = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DTOWallet dtoWallet = (DTOWallet) o;

        if (balance_ != dtoWallet.balance_) return false;
        if (id_ != dtoWallet.id_) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_ ^ (id_ >>> 32));
        result = 31 * result + balance_;
        return result;
    }
}
