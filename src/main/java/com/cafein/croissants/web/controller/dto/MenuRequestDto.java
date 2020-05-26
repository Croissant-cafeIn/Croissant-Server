package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuRequestDto {
    private String name;
    private String temp;
    private String item;
    private String size;
    private String menuUrl;

    public Menu toEntity(Integer storeId) {
        return new Menu(this.name, this.temp
            , this.item, this.size, storeId, this.menuUrl);
    }

}
