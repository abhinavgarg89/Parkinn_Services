package com.coingeit.db;

import com.coingeit.dto.DTOTransactionStatus;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 15/03/16
 */
public enum DBTransactionStatus {
    COMPLETED("Completed"), CANCELLED("Cancelled"), UPCOMING("UpComing");

    private String name_;

    private DBTransactionStatus(String name) {
        name_ = name;
    }

    public String getName() {
        return name_;
    }

    public DTOTransactionStatus toDTOStatusType() {
        return equals(COMPLETED) ? DTOTransactionStatus.COMPLETED :
                equals(CANCELLED) ? DTOTransactionStatus.CANCELLED : DTOTransactionStatus.UPCOMING;
    }

    public static DBTransactionStatus fromDTOStatusType(DTOTransactionStatus dtoTransactionStatus) {
        return dtoTransactionStatus.equals(DTOTransactionStatus.COMPLETED) ? COMPLETED :
                dtoTransactionStatus.equals(DTOTransactionStatus.CANCELLED) ? CANCELLED : UPCOMING;
    }

    @Override
    public String toString() {
        return name_;
    }
}
