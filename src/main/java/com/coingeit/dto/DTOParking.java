package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
public class DTOParking {

    @SerializedName(value = "parkingId")
    private long id_;

    @SerializedName(value = "parkingName")
    private String name_;

    @SerializedName(value = "maxSlots")
    private int maxSlots;

    @SerializedName(value = "availableSlots")
    private int availableSlots_;

    @SerializedName(value = "location")
    private DTOLocation location_;

    @SerializedName(value = "price")
    private float price_;

    public DTOParking(long id, String name, int maxSlots, int availableSlots, DTOLocation location, float price) {
        id_ = id;
        name_ = name;
        this.maxSlots = maxSlots;
        availableSlots_ = availableSlots;
        location_ = location;
        price_ = price;
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

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public int getAvailableSlots() {
        return availableSlots_;
    }

    public void setAvailableSlots(int availableSlots) {
        availableSlots_ = availableSlots;
    }

    public DTOLocation getLocation() {
        return location_;
    }

    public void setLocation(DTOLocation location) {
        location_ = location;
    }

    public float getPrice() {
        return price_;
    }

    public void setPrice(float price) {
        price_ = price;
    }
}
