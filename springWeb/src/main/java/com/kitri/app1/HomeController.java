package com.kitri.app1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/test/test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@RequestMapping(value="/test/test1", method=RequestMethod.POST)
	public String test1_post(@ModelAttribute("qqq") Test t,Model m) {
		System.out.println(t);
		
		//m.addAttribute("test", t);
		m.addAttribute("good", "kkk");
		
		return "result1";
	}
}
