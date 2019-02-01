package com.kitri.test.cate;

public class CategoryType {

	private int num;
	private String name;
	private String parent;
	
	
	
	public CategoryType() {
		super();
	}

	public CategoryType(int num, String name, String parent) {
		super();
		this.num = num;
		this.name = name;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "CategoryType [num=" + num + ", name=" + name + ", parent=" + parent + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	
	
}
