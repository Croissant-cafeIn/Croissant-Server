package com.cafein.croissants.web.dao;

import com.cafein.croissants.web.dao.domain.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDao {
    private static final Logger log = LoggerFactory.getLogger(StoreDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Store newStore) {
        String query = "INSERT INTO store (name, location, theme, hour, phone_number, owner_id, store_url) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(query, newStore.getName()
                , newStore.getLocation(), newStore.getTheme(),newStore.getHour(),newStore.getPhoneNumber()
                , newStore.getOwnerId(), newStore.getStoreUrl());

        if(result < 0) {
            throw new IllegalArgumentException("가게 등록 오류");
        }

        return jdbcTemplate.queryForObject( "SELECT LAST_INSERT_ID()", (rs, rowNum) -> rs.getInt("LAST_INSERT_ID()"));
    }

    public List<Store> findAll() {
        String query = "SELECT * FROM store ";

        return jdbcTemplate.query(query, (rs, rowNum) -> new Store(rs.getInt("store_id")
                , rs.getString("name")
                , rs.getString("location")
                , rs.getString("theme")
                , rs.getString("hour")
                , rs.getString("phone_number")
                , rs.getInt("like")
                , rs.getString("congestion")
                , rs.getInt("owner_id")
                , rs.getString("store_url")));
    }

    public List<Store> findAll(Integer ownerId) {
        String query = "SELECT * FROM store WHERE owner_id = ?";

        return jdbcTemplate.query(query, (rs, rowNum) -> new Store(rs.getInt("store_id")
                , rs.getString("name")
                , rs.getString("location")
                , rs.getString("theme")
                , rs.getString("hour")
                , rs.getString("phone_number")
                , rs.getInt("like")
                , rs.getString("congestion")
                , rs.getInt("owner_id")
                , rs.getString("store_url")), ownerId);
    }

    public Store findById(Integer storeId) {
        String query = "SELECT * FROM store WHERE store_id = ?";

        log.info("storeId: {}", storeId);
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Store(rs.getInt("store_id")
                , rs.getString("name")
                , rs.getString("location")
                , rs.getString("theme")
                , rs.getString("hour")
                , rs.getString("phone_number")
                , rs.getInt("like")
                , rs.getString("congestion")
                , rs.getInt("owner_id")
                , rs.getString("store_url")), storeId);
    }

    public void updateCongestion(Integer storeId, Integer congestion) {
        String query = "UPDATE store SET congestion = ? WHERE store_id = ?";
        jdbcTemplate.update(query, congestion, storeId);

    }
}
