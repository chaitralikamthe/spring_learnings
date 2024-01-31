package com.chai.schoolApp.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class loginController {
	
	@RequestMapping(value="/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String displayLogin(@RequestParam(value= "error", required=false) String error,
			@RequestParam(value="logout",required=false) String logout,Model model) {
		
		String errorMsg=null;
		
		if(error!=null) {
			 errorMsg="Username or Password is incorrect.";
		}
		
		if(logout !=null) {
			errorMsg="You have been successfully Logged out";
		}
		
		model.addAttribute("errorMsg", errorMsg);		
		return "login.html";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest req,HttpServletResponse resp) {
		
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(req,resp,auth);
		}
		return "/login?logout=true";
	}

}

