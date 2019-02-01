package com.kitri.test.cate;

public class GetName {

	private String myName;
	private String parent;
	private String grand;
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getGrand() {
		return grand;
	}
	public void setGrand(String grand) {
		this.grand = grand;
	}
	public GetName(String myName, String parent, String grand) {
		super();
		this.myName = myName;
		this.parent = parent;
		this.grand = grand;
	}
	public GetName() {
		super();
	}
	@Override
	public String toString() {
		return "GetName [myName=" + myName + ", parent=" + parent + ", grand=" + grand + "]";
	}
	
}
