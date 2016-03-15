package com.coingeit.db;

import com.coingeit.dto.DTOParking;

import javax.persistence.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
@Entity
@Table(name = "PARKING")
public class DBParking {

    @Id
    @GeneratedValue(generator = "PARKING_SEQ")
    @SequenceGenerator(name = "PARKING_SEQ", sequenceName = "PARKING_SEQ")
    @Column(name = "PARKING_ID")
    private long id_;

    @Column(name = "NAME")
    private String name_;

    @Column(name = "MAX_SLOTS")
    private int maxSlots_;

    @Column(name = "AVAILABLE_SLOTS")
    private int availableSlots_;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private DBLocation location_;

    @Column(name = "PRICE")
    private float price_;
    
    public DTOParking toDTOParking() {
        return new DTOParking(
                id_,
                name_,
                maxSlots_,
                availableSlots_,
                location_.toDTOLocation(),
                price_
        );
    }

    public static DBParking fromDTOParking(DTOParking dtoParking) {
        DBParking dbParking = new DBParking();
        dbParking.setAvailableSlots(dtoParking.getAvailableSlots());
        dbParking.setMaxSlots(dtoParking.getMaxSlots());
        dbParking.setName(dtoParking.getName());
        dbParking.setLocation(DBLocation.fromDTOLocation(dtoParking.getLocation()));
        dbParking.setPrice(dtoParking.getPrice());
        return dbParking;
    }

    public long getId() {
        return id_;
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        name_ = name;
    }

    public int getMaxSlots() {
        return maxSlots_;
    }

    public void setMaxSlots(int maxSlots) {
        maxSlots_ = maxSlots;
    }

    public int getAvailableSlots() {
        return availableSlots_;
    }

    public void setAvailableSlots(int availableSlots) {
        availableSlots_ = availableSlots;
    }

    public DBLocation getLocation() {
        return location_;
    }

    public void setLocation(DBLocation location) {
        location_ = location;
    }


    public float getPrice() {
        return price_;
    }

    public void setPrice(float price) {
        price_ = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBParking dbParking = (DBParking) o;

        if (availableSlots_ != dbParking.availableSlots_) return false;
        if (id_ != dbParking.id_) return false;
        if (maxSlots_ != dbParking.maxSlots_) return false;
        if (location_ != null ? !location_.equals(dbParking.location_) : dbParking.location_ != null) return false;
        if (name_ != null ? !name_.equals(dbParking.name_) : dbParking.name_ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_ ^ (id_ >>> 32));
        result = 31 * result + (name_ != null ? name_.hashCode() : 0);
        result = 31 * result + maxSlots_;
        result = 31 * result + availableSlots_;
        result = 31 * result + (location_ != null ? location_.hashCode() : 0);
        return result;
    }
    
}
