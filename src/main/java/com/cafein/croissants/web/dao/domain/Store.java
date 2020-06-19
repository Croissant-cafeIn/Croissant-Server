package com.cafein.croissants.web.dao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Store {
    private Integer id;
    private String name;
    private String location;
    private String theme;
    private String hour;
    private String phoneNumber;
    private Integer like;
    private Integer ownerId;
    private String storeUrl;
    private String congestion;

    public Store(String name, String location, String theme, String hour, String phoneNumber, Integer ownerId, String storeUrl) {
        this.name = name;
        this.location = location;
        this.theme = theme;
        this.hour = hour;
        this.phoneNumber = phoneNumber;
        this.ownerId = ownerId;
        this.storeUrl = storeUrl;
    }

    public Store(Integer id, String name, String location, String theme, String hour, String phoneNumber, Integer like, String congestion, Integer ownerId, String storeUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.theme = theme;
        this.hour = hour;
        this.phoneNumber = phoneNumber;
        this.like = like;
        this.congestion = congestion;
        this.ownerId = ownerId;
        this.storeUrl = storeUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTheme() {
        return theme;
    }

    public String getHour() {
        return hour;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getStoreUrl() {
        return storeUrl;
    }
}
