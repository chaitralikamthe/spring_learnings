package com.chai.schoolApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{

	Person readByEmail(String email);


}
