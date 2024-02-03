package com.chai.schoolApp.repository;
import com.chai.schoolApp.rommappers.ContactRowMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Contact;

@Repository
	public class ContactRepository {

	    private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public ContactRepository(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public int saveContactMsg(Contact contact){
	        String sql = "insert into contact_msg (name,mobile_num,email,subject,message,status," +
	                "created_at,created_by) values(?,?,?,?,?,?,?,?)";
	        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),
	                contact.getEmail(),contact.getSubject(),contact.getMessage(),
	                contact.getStatus(),contact.getCreatedAt(),contact.getCreatedBy());
	    }

	    public List<Contact> findMsgsWithStatus(String status) {
	        String sql = "SELECT * FROM contact_msg WHERE STATUS = ?";
	        return jdbcTemplate.query(sql,new PreparedStatementSetter() {
	            public void setValues(PreparedStatement preparedStatement) throws SQLException {
	                preparedStatement.setString(1, status);
	            }
	        },new ContactRowMapper());
	    }

	    public int updateMsgStatus(int contactId, String status,String updatedBy) {
	        String sql = "UPDATE contact_msg SET STATUS = ?, updated_by = ?,updated_at =? WHERE contact_id = ?";
	        return jdbcTemplate.update(sql,new PreparedStatementSetter() {
	            public void setValues(PreparedStatement preparedStatement) throws SQLException {
	                preparedStatement.setString(1, status);
	                preparedStatement.setString(2, updatedBy);
	                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
	                preparedStatement.setInt(4, contactId);
	            }
	        });
	    }
}

