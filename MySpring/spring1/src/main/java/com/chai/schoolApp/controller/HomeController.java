package com.chai.schoolApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping(value={"","/","/home"})
	public String displayHomepage() {
	//	model.addAttribute("username", "Veer");
		return "home0.html";
	}

}
