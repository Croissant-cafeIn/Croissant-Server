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
    private String price;
    private Integer storeId;
    private String menuUrl;

    public Menu(String name, String temp, String item, String size, String price, Integer storeId, String menuUrl) {
        this.name = name;
        this.temp = temp;
        this.item = item;
        this.size = size;
        this.price = price;
        this.storeId = storeId;
        this.menuUrl = menuUrl;
    }

    public Menu(Integer id, String name, String temp, String item, String size,  String price, Integer storeId, String menuUrl) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.item = item;
        this.size = size;
        this.price = price;
        this.storeId = storeId;
        this.menuUrl = menuUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemp() {
        return temp;
    }

    public String getItem() {
        return item;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }
}
