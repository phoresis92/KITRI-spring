package member;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import bean.Member;
import main.Menu;

public class MService implements Service {
	
	private SqlSession sqlSession;
	
	Dao dao ;

	public MService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		dao = sqlSession.getMapper(Dao.class);
		
	}

	@Override
	public Member getMyInfo(Scanner sc) {
		
		String id = Menu.user;
		Member m = dao.select(id);
		
		return m;
	}

	@Override
	public void join(Scanner sc) {

		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비번 : ");
		String pwd = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		Member m = new Member(id,pwd,name,email);
		
		dao.insert(m);
		
	}

	@Override
	public void editMyInfo(Scanner sc) {

		System.out.println("비번 : ");
		String pwd = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		Member m = new Member(Menu.user, pwd, name, email);
		
		dao.update(m);
		
	}

	@Override
	public boolean checkId(String id) {

		boolean result = false;
		Member m = dao.select(id);
		System.out.println(m);
		if(m.getId() == null || m.getId().equals("")) {
			result = false;
		}else {
			result = true;
		}
		System.out.println("result : "+ result);
		return result;
	}
	@Override
	public boolean login(Scanner sc) {
		
		System.out.println("id:");
		String id = sc.nextLine();
		System.out.println("pwd:");
		String pwd = sc.nextLine();
		String result = dao.login(id);
		
		boolean ok = false;
		if(result.equals(pwd)) {
			ok = true;
			Menu.user = id;
		}
		
		return ok;
	}

	@Override
	public void delMember(String id) {
		dao.delete(id);
	}

}
