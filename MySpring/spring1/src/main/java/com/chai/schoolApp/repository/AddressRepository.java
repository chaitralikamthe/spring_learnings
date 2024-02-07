package com.chai.schoolApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chai.schoolApp.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
