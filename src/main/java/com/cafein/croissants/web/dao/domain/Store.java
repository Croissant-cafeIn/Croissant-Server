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
    private Integer ownerId;
    private String storeUrl;

    public Store(String name, String location, String theme, Integer ownerId, String storeUrl) {
        this.name = name;
        this.location = location;
        this.theme = theme;
        this.ownerId = ownerId;
        this.storeUrl = storeUrl;
    }

    public Store(Integer id, String name, String location, String theme, Integer ownerId, String storeUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.theme = theme;
        this.ownerId = ownerId;
        this.storeUrl = storeUrl;
    }
}
