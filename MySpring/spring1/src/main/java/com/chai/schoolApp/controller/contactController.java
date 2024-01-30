package com.chai.schoolApp.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chai.schoolApp.model.Contact;
import com.chai.schoolApp.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class contactController {
	
	private static org.slf4j.Logger log= LoggerFactory.getLogger(contactController.class);
	
	@RequestMapping("/contact")
	public String displayHomepage(Model model) {
		model.addAttribute("contact",new Contact());
		return "contact.html";
	}
	
	private final ContactService contactService;
	
	@Autowired
	contactController(ContactService contactService){
		this.contactService=contactService;
	}
	
	
//	@PostMapping(value= "/saveMsg")
//	public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum, @RequestParam String email,
//			@RequestParam String subject , @RequestParam String message) {
//		log.info("Name ="+name);
//		log.info("Mobile Number ="+mobileNum);
//		log.info("Email Address ="+email);
//		log.info("Subject ="+subject);
//		log.info("Message ="+message);
//		 return new ModelAndView("redirect:/contact");			
		
//	}	
	
	@PostMapping(value= "/saveMsg")
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		
		if(errors.hasErrors()) {
			log.error("Contact form validation failed due to "+errors.toString());
			return "contact.html";
		}
		
		contactService.saveMessageDetails(contact);
		contactService.setCounter(contactService.getCounter()+1);
		log.info("Number of times the contact form is submitted = "+contactService.getCounter());
		return ("redirect:/contact");
	}
	
	}


