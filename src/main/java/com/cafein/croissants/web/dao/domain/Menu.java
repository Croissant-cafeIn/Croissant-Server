package com.cafein.croissants.web.dao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Menu {
    private Integer id;
    private String name;
    private String temp;
    private String item;
    private String size;
    private Integer storeId;
    private String menuUrl;

    public Menu(String name, String temp, String item, String size, Integer storeId, String menuUrl) {
        this.name = name;
        this.temp = temp;
        this.item = item;
        this.size = size;
        this.storeId = storeId;
        this.menuUrl = menuUrl;
    }

    public Menu(Integer id, String name, String temp, String item, String size, Integer storeId, String menuUrl) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.item = item;
        this.size = size;
        this.storeId = storeId;
        this.menuUrl = menuUrl;
    }
}
