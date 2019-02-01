package com.kitri.app1.modelAttribute;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameSearchController {

	
	@ModelAttribute("SearchTypeList")
	public List<SearchType> referenceSearchTypeList() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "아이템"));
		options.add(new SearchType(3, "캐릭터"));
		return options;
	}
	
	@ModelAttribute("PopularQueryList")
	public String[] getPopularQueryList() {
		return new String[] {"게임", "창천2", "위메이드"};
	}
	
	@RequestMapping("/game")
	public String main() {
		return "gameMain";
	}
	
	
}
