package com.kitri.app1.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BService service;

	public void setService(BService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView mainlist(@RequestParam(value="pnum") int num) {
		ArrayList<Article> list =service.getAll();
		System.out.println(list);
		//==========================================================
		
				int page = 1;
				// page 파라미터 값 검사
				if (num != 1) {
					page = num;
				}

				
				int countList = 10; //페이지당 게시물 수
				int countPage = 10; //페이지 수
				
				
				int totalCount = list.size(); // 총 게시물 수
				int totalPage = totalCount / countList; // 총 페이지 수;
				if(totalCount%countList>0) { totalPage++; }
				if(totalPage < page) { page = totalPage; }
				
				
				int startPage = ((page-1)  / countPage ) * countPage + 1; 
				int endPage = startPage + countPage - 1;
				if (endPage > totalPage) { endPage = totalPage; }
				
				//==========================================================
		
				
				int startNum = (page-1) * countList +1;
				int endNum = page * countList;
				
				PageInfo pInfo = new PageInfo();
				pInfo.setPage(page);
				pInfo.setCountList(countList);
				pInfo.setTotalPage(totalPage);
				pInfo.setStartPage(startPage);
				pInfo.setEndPage(endPage);
				pInfo.setStartNum(startNum-1);
				pInfo.setEndNum(endNum-1);
				
		ModelAndView mav = new ModelAndView("board/list");
		
		mav.addObject("list", list);
		mav.addObject("pInfo", pInfo);
		
		return mav;
	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView bDeatil(@RequestParam(value="bnum") int num) {
		
		Article a =service.getByNum(num);
		ArrayList<Article> list = service.getReps(num);
		a.setReps(list);
		
		ModelAndView mav = new ModelAndView("board/detail");
		
		mav.addObject("Article", a);
		
		return mav;
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public void delete(@RequestParam(value="bnum") int num, HttpServletResponse res) throws IOException {
		
		service.deleteArticle(num);
		res.sendRedirect("/app1/board?pnum=1");
		
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public ModelAndView write() {
		
		ModelAndView mav = new ModelAndView("board/write");
		
		return mav;
		
	}
	
	@RequestMapping(value="/board/writeForm", method=RequestMethod.GET)
	public void writeForm( Article a ) {
		
	}
	
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write2( Article a, HttpServletResponse res ,HttpServletRequest req) throws IOException {
		
		String base_path = "C:/data/";
		
		String fileName = a.getFile().getOriginalFilename();
		String path = base_path+fileName;
		File f = new File(path);
		
		try {
			a.getFile().transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		HttpSession session = req.getSession();
		a.setWriter((String) session.getAttribute("id"));
		service.addArticle(a);
		
		//res.sendRedirect("/app1/board?pnum=1");
		return "redirect:/board?pnum=1";
		
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public ModelAndView modify(Article a , HttpServletRequest req) throws IOException {
		
		System.out.println(a);
		ModelAndView mav = new ModelAndView("board/write");

		mav.addObject("Article",a);
		
		return mav;
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public void modify(Article a, HttpServletResponse res) throws IOException {
		
		
		System.out.println(a);
		
		service.editArticle(a);
		
		res.sendRedirect("/app1/board?pnum=1");
		
	}
	
	@ResponseBody
	@RequestMapping(value="/board/search/writer", method=RequestMethod.POST, produces = "application/text; charset=utf8")
	public String searchW(@RequestParam(value="key") String key, HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		System.out.println(key);
		
		
		ArrayList<Article> list = service.getByWriter(key);
		
		
		JSONArray arr = new JSONArray();
		for(Article a : list) {
			JSONObject obj = new JSONObject();
			obj.put("num", a.getNum());
			obj.put("title", a.getTitle());
			obj.put("writer", a.getWriter());
			obj.put("content", a.getContent());
			obj.put("w_date", a.getW_date());
			arr.add(obj);
			
		}
		
		System.out.println(arr.toJSONString());
		
		return arr.toJSONString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/board/search/title", method=RequestMethod.POST, produces = "application/text; charset=utf8")
	public String searchT(@RequestParam(value="key") String key, HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		System.out.println("title : "+key);
		
		
		ArrayList<Article> list = service.getByTitle(key);
		
		
		JSONArray arr = new JSONArray();
		for(Article a : list) {
			JSONObject obj = new JSONObject();
			obj.put("num", a.getNum());
			obj.put("title", a.getTitle());
			obj.put("writer", a.getWriter());
			obj.put("content", a.getContent());
			obj.put("w_date", a.getW_date());
			arr.add(obj);
			
		}
		
		return arr.toJSONString();
		
	}
	
	@RequestMapping(value="/board/getArticle", method=RequestMethod.POST)
	public ModelAndView preview(@RequestParam(value="num") int num) throws IOException {
		
		Article a = service.getByNum(num);
		ModelAndView mav = new ModelAndView("board/getArticle");
		
		mav.addObject("a", a);
		return mav;
		
	}
	
	//-===================================================================================
	@RequestMapping(value="/board/getJsonList", method=RequestMethod.POST)
	public ModelAndView getJsonList(@RequestParam(value="word") String word, @RequestParam(value="type") int type) throws IOException {
		
		ArrayList<Article> list = null;
		
		switch(type) {
		case 1:
			list = service.getByWriter(word);
			break;
		case 2:
			list = service.getByTitle(word);
			break;
		}
		ModelAndView mav = new ModelAndView("board/getJsonList");
		
		mav.addObject("list", list);
		return mav;
		
	}
	
	
}
