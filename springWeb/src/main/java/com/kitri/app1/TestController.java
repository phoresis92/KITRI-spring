package com.kitri.app1;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="/test/test2", method=RequestMethod.GET)
	public void test2(Map<String, String> map) {
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
	}
	
/*	@RequestMapping("test/test3")
	public void test3(Map map) {
		List list = service.getAll();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("list", list);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("뷰페이지 경로");
		mav.addObject("data", data);
	}*/
	
	
}
