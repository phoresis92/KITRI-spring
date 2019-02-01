package com.kitri.app1.imgboard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImgController {
	@Resource(name = "imgService")
	private Service service;
	private String path = "C:\\Users\\hushe\\Desktop\\SPRING\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";

	@RequestMapping("/imgBoard/writeForm")
	public void form() {

	}

	@RequestMapping("/imgBoard/write")
	public String write(ImgBoard ib) {
		int num = service.getImgNum();// 글번호 생성;
		String fName = "";
		//파일 업로그 과정
		if (ib.getFile() != null) {
			String fileName = ib.getFile().getOriginalFilename();//업로드된 파일명을 읽는다
			System.out.println(fileName);
			StringBuilder sb = new StringBuilder(fileName);
			int idx = sb.indexOf(".");
			sb.insert(idx, num);
			fName = sb.toString();
			String img_path = path + fName;
			System.out.println("생성된 파일명:" + fName);
			File f = new File(img_path);//빈 파일 생성
			try {
				ib.getFile().transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ib.setNum(num);
		ib.setImg_path("/img/"+fName);
		service.addImg(ib);
		return "redirect:/imgBoard/list";
	}
	
	@RequestMapping("/imgBoard/list")
	public ModelAndView list(HttpServletRequest req, @RequestParam(value="frId", 
	required=false)String frId) {
		ModelAndView mav = new ModelAndView("imgBoard/list");
		HttpSession session = req.getSession(false);
		String listId = "";
		if(frId!=null && !frId.equals("")) {
			listId = frId;
			mav.addObject("frId", frId);
		}else {
			listId = (String) session.getAttribute("id");
		}
		ArrayList<ImgBoard> list = service.getAll(listId);
		mav.addObject("list", list);
		return mav;
	}
	
}
