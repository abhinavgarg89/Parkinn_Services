package com.coingeit.db;

import com.coingeit.dto.DTOUser;

import javax.persistence.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 13/03/16
 */
@Entity
@Table(name = "USER")
public class DBUser {

    @Id
    @GeneratedValue(generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
    @Column(name = "USER_ID")
    private long id_;

    @Column(name = "NAME")
    private String name_;

    @Column(name = "USERNAME")
    private String userName_;

    @Column(name = "EMAIL")
    private String email_;

    @Column(name = "PASSWORD")
    private String password_;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "WALLET_ID", nullable = true)
    private DBWallet wallet_;


    public DTOUser toDTOUser() {
        return new DTOUser(
                id_,
                name_,
                email_,
                password_,
                wallet_.toDTOWallet(),
                userName_
        );
    }

    public static DBUser fromDTOUser(DTOUser user) {
        DBUser dbUser = new DBUser();
        dbUser.setName(user.getName());
        dbUser.setUserName(user.getUserName());
        dbUser.setPassword(user.getPassword());
        dbUser.setEmail(user.getEmail());
        dbUser.setWallet(DBWallet.fromDTOWallet(user.getWallet()));
        return dbUser;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        name_ = name;
    }

    public String getUserName() {
        return userName_;
    }

    public void setUserName(String userName) {
        userName_ = userName;
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

    public DBWallet getWallet() {
        return wallet_;
    }

    public void setWallet(DBWallet wallet) {
        wallet_ = wallet;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBUser dbUser = (DBUser) o;

        if (id_ != dbUser.id_) return false;
        if (email_ != null ? !email_.equals(dbUser.email_) : dbUser.email_ != null) return false;
        if (name_ != null ? !name_.equals(dbUser.name_) : dbUser.name_ != null) return false;
        if (password_ != null ? !password_.equals(dbUser.password_) : dbUser.password_ != null) return false;
        if (userName_ != null ? !userName_.equals(dbUser.userName_) : dbUser.userName_ != null) return false;
        if (wallet_ != null ? !wallet_.equals(dbUser.wallet_) : dbUser.wallet_ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_ ^ (id_ >>> 32));
        result = 31 * result + (name_ != null ? name_.hashCode() : 0);
        result = 31 * result + (userName_ != null ? userName_.hashCode() : 0);
        result = 31 * result + (email_ != null ? email_.hashCode() : 0);
        result = 31 * result + (password_ != null ? password_.hashCode() : 0);
        result = 31 * result + (wallet_ != null ? wallet_.hashCode() : 0);
        return result;
    }
}
