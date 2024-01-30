package com.chai.schoolApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer{
	
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/courses").setViewName("courses0");		
		reg.addViewController("/about").setViewName("about");
	}
}
