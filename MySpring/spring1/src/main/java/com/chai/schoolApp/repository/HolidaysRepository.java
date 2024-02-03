package com.chai.schoolApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Holiday;

@Repository
public class HolidaysRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidaysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Holiday> findAllHolidays() {
        String sql = "SELECT * FROM holidays";
        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

}
