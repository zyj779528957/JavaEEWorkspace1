package com.domain;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Aeyjie on 2017-05-28.
 */
public class Type {
    private long id;
    private String name;
    private Collection<House> housesById = new HashSet<House>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (id != type.id) return false;
        if (name != null ? !name.equals(type.name) : type.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<House> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<House> housesById) {
        this.housesById = housesById;
    }
}
