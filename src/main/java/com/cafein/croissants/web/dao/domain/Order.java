package com.cafein.croissants.web.dao.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private Integer clientId;
    private Integer storeId;
    private String storeName;
    private String orderList;
    private Integer point;
    private String orderDate;
    private Integer orderStatus;

    public Order(Integer clientId, Integer storeId, String storeName, String orderList, Integer point, String orderDate, Integer orderStatus) {
        this.clientId = clientId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.orderList = orderList;
        this.point = point;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Order(Integer orderId, Integer storeId, String storeName, Integer clientId, String orderList, Integer point, String orderDate, Integer orderStatus) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.clientId = clientId;
        this.orderList = orderList;
        this.point = point;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Order(Integer storeId, String storeName, String orderList, Integer point, String orderDate, Integer orderStatus) {
        this.storeName = storeName;
        this.storeId = storeId;
        this.orderList = orderList;
        this.point = point;
        this.orderDate = orderDate;
        this.orderStatus=orderStatus;
    }



    public String getStoreName() { return storeName; }

    public Integer getPoint() { return point;  }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public String getOrderList() {
        return orderList;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }
}
