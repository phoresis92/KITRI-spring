package com.kitri.test.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

	@Resource(name="service")
	private Service service;
	
	@RequestMapping(value="/product/add",  method=RequestMethod.GET)
	public String addG() {
		return "/product/add";
	}
	
	@RequestMapping(value="/product/add",  method=RequestMethod.POST)
	public String addP(Product p) {
		
		String img_path = "C:\\Users\\hushe\\Desktop\\SPRING\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\";
		int num = service.getSeq();

		if(!p.getFile1().getOriginalFilename().equals("")) {

			//String fileName = p.getFile1().getOriginalFilename();
			String fileName = mkFileName(p.getFile1(), num, 1);
			String path = img_path + fileName;
			File f = new File(path);// 업로드된 파일을 복사할 파일 생성
			// c:/img 폴더에 동일한 이름으로 파일 생성
			try {
				p.getFile1().transferTo(f);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			p.setImg1("/img/"+fileName);
			
		}
		if(!p.getFile2().getOriginalFilename().equals("")) {

			//String fileName = p.getFile2().getOriginalFilename();
			String fileName = mkFileName(p.getFile2(), num, 2);
			
			String path = img_path + fileName;
			File f = new File(path);// 업로드된 파일을 복사할 파일 생성
			// c:/img 폴더에 동일한 이름으로 파일 생성
			try {
				p.getFile2().transferTo(f);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			p.setImg2("/img/"+fileName);
			
		}
		if(!p.getFile3().getOriginalFilename().equals("")) {
			
			//String fileName = p.getFile3().getOriginalFilename();
			String fileName = mkFileName(p.getFile3(), num, 3);
			
			String path = img_path + fileName;
			File f = new File(path);// 업로드된 파일을 복사할 파일 생성
			// c:/img 폴더에 동일한 이름으로 파일 생성
			try {
				p.getFile3().transferTo(f);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			p.setImg3("/img/"+fileName);
			
		}
		if(!p.getFile4().getOriginalFilename().equals("")) {

			//String fileName = p.getFile4().getOriginalFilename();
			String fileName = mkFileName(p.getFile4(), num, 4);
			
			String path = img_path + fileName;
			File f = new File(path);// 업로드된 파일을 복사할 파일 생성
			// c:/img 폴더에 동일한 이름으로 파일 생성
			try {
				p.getFile4().transferTo(f);
			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			p.setImg4("/img/"+fileName);
			
		}
		p.setNum(num);
		System.out.println("result p : "+p);
		int r = service.addProd(p);
		System.out.println("결과값 리턴"+r);
		
		if(r == 1) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		return "redirect:/product/list";
	}
	
	public String mkFileName(MultipartFile f, int num, int idx ) {
		
		String originFileName = f.getOriginalFilename();
		int dot = originFileName.indexOf(".");
		String front = originFileName.substring(0, dot);
		String back = originFileName.substring(dot);
		String returnName = num+"_"+front+idx+back;
		return returnName;
	}
	
	
	@RequestMapping(value="/product/list",  method=RequestMethod.GET)
	public String list(Model model) {
		
		ArrayList<Product> list = service.getAll();
		
		model.addAttribute("list",list);
		
		return "/product/list";
	}
	
	@RequestMapping(value="/product/myList",  method=RequestMethod.GET)
	public String myList(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		ArrayList<Product> list = service.getByMem((String)session.getAttribute("id"));
		
		model.addAttribute("list",list);
		model.addAttribute("myListCheck", "my");
		
		return "/product/list";
	}
	
	@RequestMapping(value="/product/detail",  method=RequestMethod.GET)
	public String detail(@RequestParam(value="num") int num, Model model, HttpServletRequest req) {
		
		Product p = service.getByNum(num);
		model.addAttribute("p",p);
		
		return "/product/detail";
	}
	
	@RequestMapping(value="/product/searchLarge",  method=RequestMethod.GET)
	public String searchLarge(@RequestParam(value="parent") int num, Model model) {
		
		
		System.out.println("파라미터값: "+num);
		ArrayList<Product> list = service.getAll();
		System.out.println("전체리스트" + list);
		ArrayList<Product> resultList = new ArrayList<Product>();
		for(Product p :list) {
			int grand = service.searchLarge(p.getNum());
			System.out.println("grand 값"+grand);
			if(grand == num) {
				resultList.add(p);
			}
		}
		System.out.println("결과값"+ resultList);
		model.addAttribute("list",resultList);
		
		return "product/searchResult";
	}
	
	@RequestMapping(value="/product/searchMedium",  method=RequestMethod.GET)
	public String searchMedinum(@RequestParam(value="parent") int num, Model model) {
		
		
		System.out.println("파라미터값: "+num);
		ArrayList<Product> list = service.getAll();
		System.out.println("전체리스트" + list);
		ArrayList<Product> resultList = new ArrayList<Product>();
		for(Product p :list) {
			int parent = service.searchMedium(p.getNum());
			System.out.println("grand 값"+parent);
			if(parent == num) {
				resultList.add(p);
			}
		}
		System.out.println("결과값"+ resultList);
		model.addAttribute("list",resultList);
		
		return "product/searchResult";
	}
	
	@RequestMapping(value="/product/searchCate",  method=RequestMethod.GET)
	public String searchCate(@RequestParam(value="cate") int inputCate, Model model) {
		
		
		System.out.println("파라미터값: "+inputCate);
		ArrayList<Product> resultList = service.searchByCate(inputCate);
			
			
		System.out.println("결과값"+ resultList);
		model.addAttribute("list",resultList);
		
		return "product/searchResult";
	}
	
	
}
