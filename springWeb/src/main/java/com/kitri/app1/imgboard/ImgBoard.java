package com.kitri.app1.imgboard;



import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ImgBoard {
	private int num;
	private String writer;
	private String title;
	private Date w_date;
	private String content;
	private String img_path;
	private MultipartFile file;
	public ImgBoard() {}
	public ImgBoard(int num, String writer, String title, Date w_date, 
			String content, String img_path) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.w_date = w_date;
		this.content = content;
		this.img_path = img_path;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "ImgBoard [num=" + num + ", writer=" + writer + ", title=" + title + ", w_date=" + w_date + ", content="
				+ content + ", img_path=" + img_path + "]";
	}
	
	
}
