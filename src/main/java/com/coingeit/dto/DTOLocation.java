package com.coingeit.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
public class DTOLocation {
    
    @SerializedName(value = "locationId")
    private long id_;

    @SerializedName(value = "locationName")
    private String name_;

    public DTOLocation(long id, String name) {
        id_ = id;
        name_ = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DTOLocation that = (DTOLocation) o;

        if (id_ != that.id_) return false;
        if (name_ != null ? !name_.equals(that.name_) : that.name_ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_ ^ (id_ >>> 32));
        result = 31 * result + (name_ != null ? name_.hashCode() : 0);
        return result;
    }
}
