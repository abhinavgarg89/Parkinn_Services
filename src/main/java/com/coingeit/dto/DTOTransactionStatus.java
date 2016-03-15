package com.coingeit.dto;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
public enum  DTOTransactionStatus {

    COMPLETED("Completed"), CANCELLED("Cancelled"), UPCOMING("UpComing");

    private String name_;

    private DTOTransactionStatus(String name) {
        name_ = name;
    }

    public String getName() {
        return name_;
    }

    @Override
    public String toString() {
        return name_;
    }
}
