package com.kitri.app1.member;

import com.kitri.app1.member.Member;

public interface Dao {

	void insert(Member m);
	Member select (String id);
	void update(Member m );
	void delete(String id);
	String login(String id);
	
}
