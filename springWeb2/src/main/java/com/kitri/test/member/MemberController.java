package com.kitri.test.member;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.test.member.Member;
import com.kitri.test.member.Service;

@Controller
public class MemberController {
	
	@Resource(name="memService")
	private Service service;
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginGet(Model model) {
		
		
		return"/member/login";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String loginPost(Member m, HttpServletRequest req) {
		
		
		boolean flag = service.login(m);
		if(!flag) {
			return "/member/login";
		}
		HttpSession session = req.getSession();
		session.setAttribute("id", m.getId());
		m = service.getMyInfo(m.getId());
		//System.out.println(m);
		session.setAttribute("type", m.getType());

		return "redirect:/";
		
	}
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public String joinForm() {
		return "/member/join";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String join(Member m) {
		
		System.out.println(m);
		try {
		service.join(m);
		}catch(Exception e) {
			return "/member/join";
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/idCheck", method=RequestMethod.GET)
	public String idCheck(@RequestParam(value="inputId") String id, HttpServletResponse res) throws IOException {
		
		//System.out.println(id);
		
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


	@RequestMapping(value="/member/myMenu", method=RequestMethod.GET)
	public String myInfo(HttpServletRequest req, Model model) {
	
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		Member m = service.getMyInfo(id);
		
		model.addAttribute("m",m);
		return "/member/myMenu";
		
		
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.POST)
	public String myInfo(Member m) {
	
		service.editMyInfo(m);
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/member/del", method=RequestMethod.POST)
	public String del(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		
		service.delMember((String)session.getAttribute("id"));
		return "redirect:/member/logout";
		
	}
	
}
