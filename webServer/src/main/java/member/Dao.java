package member;

import bean.Member;

public interface Dao {

	void insert(Member m);
	Member select (String id);
	void update(Member m );
	void delete(String id);
	String login(String id);
	
}
