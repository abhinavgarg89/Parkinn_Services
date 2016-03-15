package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
public class DTOTransaction {

    @SerializedName(value = "transactionId")
    private long id_;

    @SerializedName(value = "user")
    private DTOUser user_;

    @SerializedName(value = "parking")
    private DTOParking parking_;

    @SerializedName(value = "price")
    private float price_;

    @SerializedName(value = "status")
    private DTOTransactionStatus status_;

    public DTOTransaction(long id, DTOUser user, DTOParking parking, float price, DTOTransactionStatus status) {
        id_ = id;
        user_ = user;
        parking_ = parking;
        price_ = price;
        status_ = status;
    }

    public long getId() {
        return id_;
    }

    public void setId(long id) {
        id_ = id;
    }

    public DTOUser getUser() {
        return user_;
    }

    public void setUser(DTOUser user) {
        user_ = user;
    }

    public DTOParking getParking() {
        return parking_;
    }

    public void setParking(DTOParking parking) {
        parking_ = parking;
    }

    public float getPrice() {
        return price_;
    }

    public void setPrice(float price) {
        price_ = price;
    }

    public DTOTransactionStatus getStatus() {
        return status_;
    }

    public void setStatus(DTOTransactionStatus status) {
        status_ = status;
    }
}
