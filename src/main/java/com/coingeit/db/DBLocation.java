package com.coingeit.db;

import com.coingeit.dto.DTOLocation;

import javax.persistence.*;

/**
 * Copyright (c) 2015 Exponential Interactive, Inc. All rights reserved.
 * User: abhinavgarg
 * Date: 12/03/16
 */
@Entity
@Table(name = "LOCATION")
public class DBLocation {

    @Id
    @GeneratedValue(generator = "LOCATION_SEQ")
    @SequenceGenerator(name = "LOCATION_SEQ", sequenceName = "LOCATION_SEQ")
    @Column(name = "LOCATION_ID")
    private int id_;

    @Column(name = "NAME")
    private String name_;


    public DTOLocation toDTOLocation() {
        return new DTOLocation(id_, name_);
    }

    public static DBLocation fromDTOLocation(DTOLocation dtoLocation) {
        DBLocation dbLocation = new DBLocation();
        dbLocation.setName(dtoLocation.getName());
        return dbLocation;
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

        DBLocation that = (DBLocation) o;

        if (id_ != that.id_) return false;
        if (name_ != null ? !name_.equals(that.name_) : that.name_ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id_;
        result = 31 * result + (name_ != null ? name_.hashCode() : 0);
        return result;
    }

}
