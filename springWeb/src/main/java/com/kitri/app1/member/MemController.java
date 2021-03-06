package com.kitri.app1.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemController {
	
	@Resource(name="memService")
	private Service service;

	public void setService(Service service) {
		this.service = service;
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public void joinForm() {
		
	}

	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String join(Member m) {
		
		System.out.println(m);
		try {
		service.join(m);
		}catch(Exception e) {
			return "member/join";
		}
		return "member/login";
	}
	
/*	@RequestMapping(value="/member/idCheck", method=RequestMethod.GET)
	public ModelAndView idCheck(HttpServletRequest req, HttpServletResponse res) {
		
		String id = req.getParameter("inputId");
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView("member/checkId");
		
		boolean flag = service.checkId(id);
		mav.addObject("flag", flag);
		return mav;
		
		
	}*/
	@ResponseBody
	@RequestMapping(value="/member/idCheck", method=RequestMethod.GET)
	public String idCheck(@RequestParam(value="inputId") String id, HttpServletResponse res) throws IOException {
		
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView("/member/join");
		
		boolean flag = service.checkId(id);
		String result = "";
		if(flag) {
			result += "no";
		}else {
			result += "yes";
		}	
		
		return result;
		
	}
	
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res, Member m) throws IOException {
		
		HttpSession session = req.getSession();
		
		boolean flag = service.login(m);
		System.out.println(m);
		String result ="";
		if(flag) {
			
			session.setAttribute("id", m.getId());
			result += "member/menu";
			
		}else {
			req.setCharacterEncoding("UTF-8");
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.print("<script>");
			out.print("alert('아이디 비밀번호를 확인해주세요');");
			out.print("history.back()");
			out.print("</script>");
			out.close();
			System.out.println("로그인 실패");
			
			//result += "member/login";
			
		}

		return result;
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String login2() {
		return "member/login";
	}
	
	@RequestMapping(value="/member/lobby", method=RequestMethod.GET)
	public String lobby() {
		return "member/menu";
	}
	
	
	@RequestMapping(value="/member/myInfo", method=RequestMethod.GET)
	public ModelAndView myInfo(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		Member m = service.getMyInfo(id);
		
		ModelAndView mav = new ModelAndView("member/myInfo");
				mav.addObject("m",m);
		return mav;
		
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.POST)
	public String myInfo(Member m) {
	
		service.editMyInfo(m);
		return "member/menu";
		
	}
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		return "member/join";
		
	}
	
	
	
}
