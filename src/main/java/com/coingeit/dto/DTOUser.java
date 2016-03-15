package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
public class DTOUser {

    @SerializedName(value = "userId")
    private long id_;

    @SerializedName(value = "userName")
    private String userName_;
    
    
    @SerializedName(value = "name")
    private String name_;

    @SerializedName(value = "email")
    private String email_;

    @SerializedName(value = "password")
    private String password_;

    @SerializedName(value = "wallet")
    private DTOWallet wallet_;


    public DTOUser(long id, String name, String email, String password, DTOWallet wallet, String userName) {
        id_ = id;
        name_ = name;
        email_ = email;
        password_ = password;
        wallet_ = wallet;
        userName_ = userName;
    }

    public long getId() {
        return id_;
    }

    public void setId(long id) {
        id_ = id;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        name_ = name;
    }

    public String getEmail() {
        return email_;
    }

    public void setEmail(String email) {
        email_ = email;
    }

    public String getPassword() {
        return password_;
    }

    public void setPassword(String password) {
        password_ = password;
    }

    public DTOWallet getWallet() {
        return wallet_;
    }

    public void setWallet(DTOWallet wallet) {
        wallet_ = wallet;
    }

    public String getUserName() {
        return userName_;
    }

    public void setUserName(String userName) {
        userName_ = userName;
    }
}
