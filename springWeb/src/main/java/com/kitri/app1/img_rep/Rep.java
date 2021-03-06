package com.kitri.app1.img_rep;

public class Rep {
	
	private int num;
	private int img_num;
	private String writer;
	private String content;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getImg_num() {
		return img_num;
	}
	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Rep(int num, int img_num, String writer, String content) {
		super();
		this.num = num;
		this.img_num = img_num;
		this.writer = writer;
		this.content = content;
	}
	public Rep() {
		super();
	}
	@Override
	public String toString() {
		return "Rep [num=" + num + ", img_num=" + img_num + ", writer=" + writer + ", content=" + content + "]";
	}

	
	
}
