package com.kitri.app1.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportSubmissionController {

	private String img_path = "C:\\Users\\hushe\\Desktop\\SPRING\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\img\\";
	
	@RequestMapping(value="/report/submission", method=RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}// go to Formpage
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: "+ report.getOriginalFilename());
	}//test Print
	
	@RequestMapping(value="/report/submitReport1", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		String fileName = report.getOriginalFilename();
		String path = img_path + fileName;
		File f = new File(path);// 업로드된 파일을 복사할 파일 생성
		// c:/img 폴더에 동일한 이름으로 파일 생성
		try {
			report.transferTo(f);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "report/submissionCommplete";
	}// submitReport1

	
	@RequestMapping(value="/report/submitReport2", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String fileName = report.getOriginalFilename();
		String path = img_path + fileName;
		File f = new File(path);// 업로드된 파일을 복사할 파일 생성
		// c:/img 폴더에 동일한 이름으로 파일 생성
		try {
			report.transferTo(f);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "report/submissionCommplete";
	}// submitReport2
	
	
	@RequestMapping(value="/report/submitReport3", method=RequestMethod.POST)
	public ModelAndView submitReport3(ReportCommand reportCommand) {
		
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		String fileName = reportCommand.getReport().getOriginalFilename();
		String path = img_path + fileName;
		File f = new File(path);// 업로드된 파일을 복사할 파일 생성
		// c:/img 폴더에 동일한 이름으로 파일 생성
		try {
			reportCommand.getReport().transferTo(f);
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("report/submissionCommplete");
		File imgDir = new File(img_path);
		String[] imgList = imgDir.list();//업로드 디렉토리의 파일 목록을 뷰 페이지에 반환
		mav.addObject("imgList", imgList);
		return mav;
		
	}// submitReport3
	
	
}
