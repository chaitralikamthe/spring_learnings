package com.chai.schoolApp.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.chai.schoolApp.constants.constants;
import com.chai.schoolApp.model.Contact;
import com.chai.schoolApp.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository ;
	
	public ContactService() {
		System.out.println("Contact service bean has been initialized");
	}
	public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(constants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
	}
	
    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(constants.OPEN);
        return contactMsgs;
    }
    
    public boolean updateMsgStatus(int contactId){
    	boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(constants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
