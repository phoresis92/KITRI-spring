package com.kitri.test.product;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int num;
	private String title;
	private String seller;
	private int cate;
	private int quantity;
	private String content;
	private int price;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;
	private MultipartFile file4;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public MultipartFile getFile3() {
		return file3;
	}
	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}
	public MultipartFile getFile4() {
		return file4;
	}
	public void setFile4(MultipartFile file4) {
		this.file4 = file4;
	}
	public Product(int num, String title, String seller, int cate, int quantity, String content, int price, String img1,
			String img2, String img3, String img4, MultipartFile file1, MultipartFile file2, MultipartFile file3,
			MultipartFile file4) {
		super();
		this.num = num;
		this.title = title;
		this.seller = seller;
		this.cate = cate;
		this.quantity = quantity;
		this.content = content;
		this.price = price;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
		this.file4 = file4;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", title=" + title + ", seller=" + seller + ", cate=" + cate + ", quantity="
				+ quantity + ", content=" + content + ", price=" + price + ", img1=" + img1 + ", img2=" + img2
				+ ", img3=" + img3 + ", img4=" + img4 + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3
				+ ", file4=" + file4 + "]";
	}
	
	
	
	
}
