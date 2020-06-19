package com.cafein.croissants.web.dao;

import com.cafein.croissants.web.dao.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.event.CaretListener;
import java.util.List;

@Repository
public class ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int insert(Client client) {
        String query = "INSERT INTO client (email, password, point) VALUES (?, ?, ?)";
        return jdbcTemplate.update(query, client.getEmail(), client.getPassword(), client.getPoint());
    }

    public int update(Client client) {
        String query = "UPDATE client SET password = ? WHERE email = ?";

        return jdbcTemplate.update(query, client.getPassword(), client.getEmail(), client.getPoint());

    }

    public List<Client> findAll() {
        String query = "SELECT * FROM client";

        return jdbcTemplate.query(query, (rs, rowNum) -> new Client(rs.getInt("client_id")
                , rs.getString("email")
                , rs.getString("password")
                , rs.getInt("point")));
    }

    public Client findByEmail(String email) {
        String query = "SELECT * FROM client WHERE email = ?";

        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Client(rs.getInt("client_id")
                , rs.getString("email")
                , rs.getString("password"), rs.getInt("point")), email);
    }

    public void addPoint(String email , int point) {

        String query = "UPDATE client SET point = point + ? WHERE email = ?";
        jdbcTemplate.update(query, point, email);
    }

    public void minusPoint(Integer client_id, int point) {
        String query = "UPDATE client SET point = point - ? WHERE client_id = ?";
        jdbcTemplate.update(query, point, client_id);
    }

    public void updatePassword(String email, String password) {
        String query = "UPDATE client SET password = ? WHERE email = ?";
        jdbcTemplate.update(query, password, email);
    }
}
