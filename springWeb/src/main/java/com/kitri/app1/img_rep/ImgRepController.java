package com.kitri.app1.img_rep;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImgRepController {

	@Resource(name="imgRepService")
	private Service service;
	
	
	@RequestMapping(value="/imgRep/add")
	public String add(Rep r) {
		service.addRep(r);
		return "redirect:/imgRep/list?img_num="+r.getImg_num();
	}
	
	@RequestMapping("/imgRep/list") 	   
	public ModelAndView add(@RequestParam(value="img_num") int img_num) {
		ArrayList<Rep> list = service.getByImgNum(img_num);
		ModelAndView mav = new ModelAndView("imgBoard/repList");
		mav.addObject("reps",list);
		return mav;
	}
	
}
