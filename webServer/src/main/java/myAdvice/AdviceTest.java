package myAdvice;

//공통 코드가 적용될 대상
public class AdviceTest {
	
	private String str;
	
	public String test1() {
		str = "test1";
		return str;
	}
	
	public String test2() {
		str = "test2";
		return str;
	}
	
	public String test3() {
		str = "test3";
		return str;
	}

}

/*aspectjrt
aspectjweaver
aspectjtools

*/
