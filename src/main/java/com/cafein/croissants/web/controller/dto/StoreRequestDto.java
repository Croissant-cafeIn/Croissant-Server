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
    private String storeUrl;

    public Store toEntity(Integer ownerId) {
        return new Store(this.name, this.location
                , this.theme, ownerId, this.storeUrl);
    }
}
