package com.cafein.croissants.web.dao;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.cafein.croissants.web.dao.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    private static final Logger log = LoggerFactory.getLogger(OrderDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Order newOrder) {
        String query = "INSERT INTO orderlist (client_id, store_id, store_name, order_list, point, order_date, order_status) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, newOrder.getClientId(), newOrder.getStoreId(), newOrder.getStoreName(),
                newOrder.getOrderList(), newOrder.getPoint(), newOrder.getOrderDate(), newOrder.getOrderStatus());
    }

    public List<Order> findClientOrder(Integer clientId) {
     String query = "SELECT store_id, store_name, order_list, point, order_date, order_status FROM orderlist WHERE client_id = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Order(
                rs.getInt("store_id")
                , rs.getString("store_name")
                , rs.getString("order_list")
                ,rs.getInt("point")
                , rs.getString("order_date")
                , rs.getInt("order_status")), clientId);
    }

    public List<Order> findOwnerOrder(Integer storeId) {  // AD-owner앱 store에 들어온 주문 확인
        String query = "SELECT order_id, store_id, store_name, client_id, order_list, point, order_date, order_status FROM orderlist WHERE store_id = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Order(
                rs.getInt("order_id")
                , rs.getInt("store_id")
                , rs.getString("store_name")
                , rs.getInt("client_id")
                , rs.getString("order_list")
                , rs.getInt("point")
                , rs.getString("order_date")
                , rs.getInt("order_status")), storeId);
    }

    public List<Order> findStoreOrder(Integer storeId) {
        String query = "SELECT order_id, store_id, store_name, client_id, order_list, point, order_date, order_status FROM orderlist WHERE store_id = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Order(
                rs.getInt("order_id")
                , rs.getInt("store_id")
                , rs.getString("store_name")
                , rs.getInt("client_id")
                , rs.getString("order_list")
                , rs.getInt("point")
                , rs.getString("order_date")
                , rs.getInt("order_status")), storeId);
    }

    public void updateStatus(Integer orderId) {
        String query = "UPDATE orderlist SET order_status = 1 WHERE order_id = ?";
        jdbcTemplate.update(query, orderId);
    }

    public List<Order> findUpdateOrder(Integer orderId) {
        String query = "SELECT order_id, store_id, store_name, client_id, order_list, point, order_date, order_status FROM orderlist WHERE order_id = ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Order(
                rs.getInt("order_id")
                , rs.getInt("store_id")
                , rs.getString("store_name")
                , rs.getInt("client_id")
                , rs.getString("order_list")
                , rs.getInt("point")
                , rs.getString("order_date")
                , rs.getInt("order_status")), orderId);

    }
}
