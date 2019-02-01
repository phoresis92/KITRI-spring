package test1;

public class Test {

	public String str ;
	public int num ;
	
	
	
	
	@Override
	public String toString() {
		return "Test [str=" + str + ", num=" + num + "]";
	}

	public Test() {
		str = "aaa";
		num = 12;
	}
	
	public Test(String str) {
		this.str = str;
		
	}
	public Test(int num) {
		this.num = num;
	}
	
	
	public Test(String str, int num) {
		this.str = str;
		this.num = num;
	}
	
	
	public void test1() {
		System.out.println("test1");
	}
	
	public void test2() {
		System.out.println("test2");
	}
	
	public void test3() {
		System.out.println("test3");
	}
	
}
