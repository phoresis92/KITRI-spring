package com.kitri.app1.repository;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
public class RepositoryController {

	@Resource(name="RepoService")
	private Service service;
	
	@RequestMapping(value="Repo/list", method=RequestMethod.GET) 
	public void list(Map<String,ArrayList<Repo>> map) {
		ArrayList<Repo> list = service.getAll();
		map.put("list", list);
	}
	
}
