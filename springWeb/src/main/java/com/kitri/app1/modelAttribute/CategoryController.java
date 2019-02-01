package com.kitri.app1.modelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

	@Resource(name="cateService")
	private CategoryService cService;
	
	public void setcService(CategoryService cService) {
		this.cService = cService;
	}

/*	@ModelAttribute("LargeTypeList")
	public List<SearchType> referenceSearchTypeList1() {
		List<SearchType> options = new ArrayList<SearchType>();
		
		ArrayList<CategoryType> lList = cService.getLargeType();
		//System.out.println("lList size"+lList.size());
		
		for(int i = 0 ; i < lList.size(); i++) {
			//System.out.println("lList"+lList.get(i));
			
			options.add(new SearchType(lList.get(i).getNum(), lList.get(i).getName()));
		}
		return options;
	}*/
	

	@RequestMapping("/cate/cate1")
	public ModelAndView cate1() {
		
		
		ArrayList<CategoryType> list = cService.getLargeType();
		//ModelAndView mav = new ModelAndView("cate/main");
		//대분류 검색
		System.out.println(list.toString());
		ModelAndView mav = new ModelAndView("cate/cateList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/cate/cate2")
	public ModelAndView cate2(@RequestParam(value="parent") int parent) {
		
		System.out.println(parent);
		
		ArrayList<CategoryType> list = cService.getMediumType(parent);
		System.out.println(list);
		
		ModelAndView mav = new ModelAndView("cate/cateList");
		mav.addObject("list", list);
		//중 소분류 검색
		return mav;
	}
	
	
	
	
}
