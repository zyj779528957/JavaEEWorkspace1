package com.domain;

import java.sql.Time;

/**
 * Created by Aeyjie on 2017-05-28.
 */
public class House {
    private long id;
    private Long userId;
    private Long typeId;
    private String title;
    private String description;
    private Long price;
    private Time pubdate;
    private Long floorage;
    private String contact;
    private Long streetId;
    private Users usersByUserId;
    private Type typeByTypeId;
    private Street streetByStreetId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Time getPubdate() {
        return pubdate;
    }

    public void setPubdate(Time pubdate) {
        this.pubdate = pubdate;
    }

    public Long getFloorage() {
        return floorage;
    }

    public void setFloorage(Long floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        if (id != house.id) return false;
        if (userId != null ? !userId.equals(house.userId) : house.userId != null) return false;
        if (typeId != null ? !typeId.equals(house.typeId) : house.typeId != null) return false;
        if (title != null ? !title.equals(house.title) : house.title != null) return false;
        if (description != null ? !description.equals(house.description) : house.description != null) return false;
        if (price != null ? !price.equals(house.price) : house.price != null) return false;
        if (pubdate != null ? !pubdate.equals(house.pubdate) : house.pubdate != null) return false;
        if (floorage != null ? !floorage.equals(house.floorage) : house.floorage != null) return false;
        if (contact != null ? !contact.equals(house.contact) : house.contact != null) return false;
        if (streetId != null ? !streetId.equals(house.streetId) : house.streetId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pubdate != null ? pubdate.hashCode() : 0);
        result = 31 * result + (floorage != null ? floorage.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (streetId != null ? streetId.hashCode() : 0);
        return result;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    public Street getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(Street streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }
}
