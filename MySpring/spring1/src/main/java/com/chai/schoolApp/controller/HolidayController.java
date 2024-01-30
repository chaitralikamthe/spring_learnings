package com.chai.schoolApp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chai.schoolApp.model.Holiday;

@Controller
public class HolidayController {
	
	@GetMapping("/holidays/{display}")
	public String displayHoliday(@PathVariable String display, Model model) {
		
		if(display!=null && display.equals("all")) {
		model.addAttribute("festival",true);
		model.addAttribute("federal",true);
		}
		
		else if(display!=null && display.equals("festival"))
			model.addAttribute("festival",true);
		
		else if(display!=null && display.equals("federal"))
			model.addAttribute("federal",true);
		
		
		
		List<Holiday> holidays= Arrays.asList(
				new Holiday("Jan 1", "New Year's day", Holiday.Type.FESTIVAL),
				new Holiday("Jan 26", "Republic Day", Holiday.Type.FEDERAL),
				new Holiday("Oct 31", "Halloween", Holiday.Type.FESTIVAL),				
				new Holiday("May 1", "Maharastra Day", Holiday.Type.FESTIVAL),
				new Holiday("Aug 15", "Independance Day", Holiday.Type.FEDERAL),
				new Holiday("Oct 2", "Gandhi Jayanti", Holiday.Type.FESTIVAL),
				new Holiday("Dec 25", "Christamas Day", Holiday.Type.FESTIVAL),
				new Holiday("Nov 24", "ThanksGiving day", Holiday.Type.FESTIVAL)
				);
		
		Holiday.Type[] types=Holiday.Type.values();
		
		for(var type : types) {
			model.addAttribute(type.toString(),
			(holidays.stream().filter(holiday-> holiday.getType().equals(type)).collect(Collectors.toList())));
		}
		
		
		return "Holidays.html";
		
	}

}
