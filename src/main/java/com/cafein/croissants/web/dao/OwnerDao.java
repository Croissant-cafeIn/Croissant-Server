package com.cafein.croissants.web.dao;

import com.cafein.croissants.web.dao.domain.Owner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Owner owner) {
        String query = "INSERT INTO owner (email, name, password) VALUES (?, ?, ?)";
        return jdbcTemplate.update(query, owner.getEmail(), owner.getName(), owner.getPassword());
    }

    public int update(Owner owner) {
        String query = "UPDATE owner SET name = ?, password = ? WHERE email = ?";

        return jdbcTemplate.update(query, owner.getPassword(), owner.getName(), owner.getEmail());

    }

    public List<Owner> findAll() {
        String query = "SELECT * FROM owner";

        return jdbcTemplate.query(query, (rs, rowNum) -> new Owner(rs.getInt("owner_id")
                , rs.getString("email")
                , rs.getString("name")
                , rs.getString("password")));
    }

    public Owner findByEmail(String email) {
        String query = "SELECT * FROM owner WHERE email = ?";

        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Owner(rs.getInt("owner_id")
                , rs.getString("email")
                , rs.getString("name")
                , rs.getString("password")), email);
    }
}
