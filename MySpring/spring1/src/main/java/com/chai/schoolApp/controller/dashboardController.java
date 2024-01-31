package com.chai.schoolApp.controller;


import org.springframework.security.core.Authentication;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class dashboardController {

	
	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication auth) {
		model.addAttribute("username",auth.getName());
		model.addAttribute("roles", auth.getAuthorities().toString());
		//throw new RuntimeException("It's been a bad day");
		return "dashboard.html";
	}
}
