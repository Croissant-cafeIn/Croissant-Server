package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreRequestDto {
    private String name;
    private String location;
    private String theme;
    private String hour;
    private String phone_number;
    private Integer like;
    private String storeUrl;

    public Store toEntity(Integer ownerId) {
        return new Store(this.name, this.location
                , this.theme, this.hour, this.phone_number, ownerId, this.storeUrl);
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

    public String getPhone_number() {
        return phone_number;
    }

    public Integer getLike() {
        return like;
    }

    public String getStoreUrl() {
        return storeUrl;
    }
}
