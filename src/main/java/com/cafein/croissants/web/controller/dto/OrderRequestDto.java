package com.cafein.croissants.web.controller.dto;

import com.cafein.croissants.web.dao.domain.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {
    private Integer clientId;
    private Integer storeId;
    private String storeName;
    private String orderList;
    private String orderDate;
    private Integer status;
    private String email;
    private int point;

    public Order toEntity() {
        return new Order(this.clientId, this.storeId, this.storeName
                , this.orderList, this.point, this.orderDate, this.status);
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }

    public Integer getClient_id() {
        return clientId;
    }

    public Integer getStore_id() {
        return storeId;
    }

    public String getOrder_list() {
        return orderList;
    }

    public String getOrder_date() {
        return orderDate;
    }

    public Integer getStatus() {
        return status;
    }
}
