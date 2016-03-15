package com.coingeit.db;

import com.coingeit.dto.DTOTransaction;

import javax.persistence.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 14/03/16
 */
@Entity
@Table(name = "TRANSACTION")
public class DBTransaction {

    @Id
    @GeneratedValue(generator = "TRANSACTION_SEQ")
    @SequenceGenerator(name = "TRANSACTION_SEQ", sequenceName = "TRANSACTION_SEQ")
    @Column(name = "TRANSACTION_ID")
    private long id_;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private DBUser user_;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PARKING_ID")
    private DBParking parking_;

    @Column(name = "PRICE")
    private float price_;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "STATUS")
    private DBTransactionStatus status_;

    public DTOTransaction toDTOTransaction() {
        return new DTOTransaction(
                id_,
                user_.toDTOUser(),
                parking_.toDTOParking(),
                price_,
                status_.toDTOStatusType()
        );
    }

    public static DBTransaction fromDTOTransaction(DTOTransaction dtoTransaction) {
        DBTransaction dbTransaction = new DBTransaction();
        dbTransaction.setId(dtoTransaction.getId());
        dbTransaction.setUser(DBUser.fromDTOUser(dtoTransaction.getUser()));
        dbTransaction.setPrice(dtoTransaction.getPrice());
        dbTransaction.setParking(DBParking.fromDTOParking(dtoTransaction.getParking()));
        dbTransaction.setStatus(DBTransactionStatus.fromDTOStatusType(dtoTransaction.getStatus()));
        return dbTransaction;
    }
    
    
    public long getId() {
        return id_;
    }

    public void setId(long id) {
        id_ = id;
    }

    public DBUser getUser() {
        return user_;
    }

    public void setUser(DBUser user) {
        user_ = user;
    }

    public DBParking getParking() {
        return parking_;
    }

    public void setParking(DBParking parking) {
        parking_ = parking;
    }

    public float getPrice() {
        return price_;
    }

    public void setPrice(float price) {
        price_ = price;
    }

    public DBTransactionStatus getStatus() {
        return status_;
    }

    public void setStatus(DBTransactionStatus status) {
        status_ = status;
    }
}
