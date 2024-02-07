package com.chai.schoolApp.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Contact;

@Repository
	public interface ContactRepository extends CrudRepository<Contact,Integer> {

	    List<Contact> findByStatus(String status);
	    }


