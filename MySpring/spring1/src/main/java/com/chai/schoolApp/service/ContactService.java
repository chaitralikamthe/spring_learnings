package com.chai.schoolApp.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.chai.schoolApp.constants.constants;
import com.chai.schoolApp.model.Contact;
import com.chai.schoolApp.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@RequestScope
//@SessionScope
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository ;
	
	public ContactService() {
		System.out.println("Contact service bean has been initialized");
	}
	public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(constants.OPEN);
        contact.setCreatedBy(constants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
	}
	
    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(constants.OPEN);
        return contactMsgs;
    }
    
    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,constants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
