package com.kitri.app1.board;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class Article {
	
	private int num ;
	private String writer ;
	private String title;
	private String content;
	private String w_date;
	private int parent;
	private ArrayList<Article> reps;
	private String file_path;
	private MultipartFile file;
	
	
	public String getFile_path() {
		return file_path;
	}
	public Article(int num, String writer, String title, String content, String w_date, int parent,
			ArrayList<Article> reps, String file_path, MultipartFile file) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
		this.parent = parent;
		this.reps = reps;
		this.file_path = file_path;
		this.file = file;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Article() {
		super();
	}
	public Article(int num, String writer, String title, String content, String w_date) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
	}

	public Article(int num, String writer, String title, String content, String w_date, int parent) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", w_date="
				+ w_date + "]";
	}
	
	public ArrayList<Article> getReps() {
		return reps;
	}
	public void setReps(ArrayList<Article> reps) {
		this.reps = reps;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getW_date() {
		return w_date;
	}
	public void setW_date(String w_date) {
		this.w_date = w_date;
	}
	
	
	

	
	
	
	

}
