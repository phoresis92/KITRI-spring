package com.kitri.app1.member;

import java.util.Scanner;

import com.kitri.app1.member.Member;

public interface Service {
	public Member getMyInfo(String id);
	public void join(Member m) ;
	public void editMyInfo(Member m) ;
	public boolean checkId(String id) ;
	public boolean login(Member m) ;
	public void delMember(String id) ;


	
	
}
