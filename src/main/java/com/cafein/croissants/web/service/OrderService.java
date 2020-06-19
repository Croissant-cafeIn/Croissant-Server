package com.cafein.croissants.web.service;
import com.cafein.croissants.web.controller.dto.OrderRequestDto;
import com.cafein.croissants.web.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import com.cafein.croissants.web.dao.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public void newOrder(OrderRequestDto orderRequestDto) {
        Order newOrder = orderRequestDto.toEntity();
        orderDao.insert(newOrder);
    }

    public List<Order> findClientOrder(Integer clientId) {
        return orderDao.findClientOrder(clientId);
    }

    public List<Order> findOwnerOrder(Integer storeId) { //AD - owner store에 새로 들어온 주문 조회
        return orderDao.findOwnerOrder(storeId);
    }

    public List<Order> findStoreOrder(Integer storeId){
        return orderDao.findStoreOrder(storeId);
    }

    public void updateStatus(Integer orderId) { orderDao.updateStatus(orderId); }

    public List<Order> findUpdateOrder(Integer orderId) {return orderDao.findUpdateOrder(orderId);   }
}
