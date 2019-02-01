package com.kitri.test.member;

import com.kitri.test.member.Member;

public interface Dao {

	void insert(Member m);
	Member select (String id);
	void update(Member m );
	void delete(String id);
	String login(String id);
	
}
