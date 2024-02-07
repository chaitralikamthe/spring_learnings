package com.chai.schoolApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Holiday;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday,String>{



}
