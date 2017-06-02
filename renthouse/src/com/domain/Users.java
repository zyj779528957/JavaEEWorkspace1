package com.domain;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Aeyjie on 2017-05-28.
 */
public class Users {
    private long id;
    private String name;
    private String password;
    private String telephone;
    private String username;
    private String isadmin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (telephone != null ? !telephone.equals(users.telephone) : users.telephone != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;
        if (isadmin != null ? !isadmin.equals(users.isadmin) : users.isadmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (isadmin != null ? isadmin.hashCode() : 0);
        return result;
    }

    public Collection<House> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<House> housesById) {
        this.housesById = housesById;
    }
}
