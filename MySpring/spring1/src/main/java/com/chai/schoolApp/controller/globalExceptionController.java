package com.chai.schoolApp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class globalExceptionController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView errorpage=new ModelAndView();
		errorpage.setViewName("error");
		errorpage.addObject("error",e.getMessage());
		return errorpage;
		
	}

}
