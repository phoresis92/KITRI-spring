package member;

import java.util.Scanner;

import bean.Member;

public interface Service {
	public Member getMyInfo(Scanner sc);
	public void join(Scanner sc) ;
	public void editMyInfo(Scanner sc) ;
	public boolean checkId(String id) ;
	public boolean login(Scanner sc) ;
	public void delMember(String id) ;


	
	
}
