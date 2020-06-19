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
    private String tall;
    private String grande;
    private String venti;
    private String etc;
    private String price;
    private String menuUrl;

    public void  size(String tall, String grande, String venti, String etc){
        if (tall.isEmpty())
            this.price = etc;
        else if (grande.isEmpty())
            this.price = tall;
        else if (venti.isEmpty())
            this.price = tall+","+grande;
        else
            this.price = tall+","+grande+","+venti;

    }
    public Menu toEntity(Integer storeId) {
        size(this.tall, this.grande, this.venti, this.etc);
        return new Menu(this.name, this.temp
            , this.item, this.size, this.price,
                storeId, this.menuUrl);
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

    public String getMenuUrl() {
        return menuUrl;
    }
}
