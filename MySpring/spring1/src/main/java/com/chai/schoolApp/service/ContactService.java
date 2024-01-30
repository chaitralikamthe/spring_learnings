package com.chai.schoolApp.service;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.chai.schoolApp.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {
	
	private int counter=0;
	
	public ContactService() {
		System.out.println("Contact service bean has been initialized");
	}
	public boolean saveMessageDetails(Contact contact) {
		boolean isSaved=true;
		log.info(contact.toString());
		return isSaved;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

}
