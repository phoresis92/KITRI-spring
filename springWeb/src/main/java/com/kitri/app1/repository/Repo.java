package com.kitri.app1.repository;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Repo {
	
	private int seq;
	private String title;
	private String content;
	private String writer;
	private Date w_date;
	private String file_path;
	private MultipartFile file;
	public Repo(int seq, String title, String content, String writer, Date w_date, String file_path,
			MultipartFile file) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.w_date = w_date;
		this.file_path = file_path;
		this.file = file;
	}
	public Repo() {
		super();
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	@Override
	public String toString() {
		return "Repo [seq=" + seq + ", title=" + title + ", content=" + content + ", writer=" + writer + ", w_date="
				+ w_date + ", file_path=" + file_path + ", file=" + file + "]";
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}
