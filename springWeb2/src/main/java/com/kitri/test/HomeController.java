package com.kitri.test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.test.member.Service;

import com.kitri.test.member.Member;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
/*		HttpSession session = req.getSession();
		int type = 2;
		try {
			type = (Integer) session.getAttribute("type");
		}catch(Exception e) {
			
		}
		
		//System.out.println(type);
		
		if(type == 1) {
			model.addAttribute("data", "seller page");
			return "seller/product/list";
		}else {
			model.addAttribute("data", "cons page" );
			return "cons/product/list";
		}*/
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		model.addAttribute("data", id );
		return "hello";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/time", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String time(Locale locale) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
	}
	

	

	

	
	
}
