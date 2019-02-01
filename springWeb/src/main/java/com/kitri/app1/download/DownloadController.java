package com.kitri.app1.download;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {

	private String base_path ="C:/data/";
	
	@RequestMapping("/download/list")
	public ModelAndView fileList() {
		File dir = new File(base_path);
		String[] list = dir.list();
		
		return new ModelAndView("download/list", "list", list);
	}
	
	@RequestMapping("/download/down")
	public ModelAndView download(@RequestParam(value="name") String name) throws Exception {
		File downloadFile = new File(base_path+name);
		//param1: 뷰 페이지경로, param2: 뷰 페이지에서 부를 데이터이름, param3: 뷰 페이지로 전달할 값
		return new ModelAndView ("download", "downloadFile", downloadFile);
	}
	
}
