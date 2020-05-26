package com.cafein.croissants.web.dao;

import com.cafein.croissants.web.dao.domain.Menu;
import com.cafein.croissants.web.dao.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Menu newMenu) {
        String query = "INSERT INTO menu (name, temp, item, size, store_id, menu_url) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(query, newMenu.getName()
                , newMenu.getTemp(), newMenu.getItem()
                , newMenu.getSize(), newMenu.getStoreId()
                , newMenu.getMenuUrl());

        if (result < 0) {
            throw new IllegalArgumentException("메뉴 등록 오류");
        }

        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", (rs, rowNum) -> rs.getInt("LAST_INSERT_ID()"));
    }

    public List<Menu> findAll(Integer storeId) {
        String query = "SELECT * FROM menu WHERE store_id = ?";

        return jdbcTemplate.query(query, (rs, rowNum) -> new Menu(rs.getInt("menu_id")
                , rs.getString("name")
                , rs.getString("temp")
                , rs.getString("item")
                , rs.getString("size")
                , rs.getInt("store_id")
                , rs.getString("menu_url")), storeId);
    }
}
