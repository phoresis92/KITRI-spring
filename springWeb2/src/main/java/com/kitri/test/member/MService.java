package com.kitri.test.member;

import java.awt.Menu;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.kitri.test.member.Dao;

import com.kitri.test.member.Member;

@Component("memService")
public class MService implements Service {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private Dao dao;


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Member getMyInfo(String id) {
		dao = sqlSession.getMapper(Dao.class);
		Member m = dao.select(id);
		
		return m;
	}

	@Override
	public void join(Member m) {
		dao = sqlSession.getMapper(Dao.class);
		System.out.println("join : "+m);
			dao.insert(m);
		
	}

	@Override
	public void editMyInfo(Member m) {
		dao = sqlSession.getMapper(Dao.class);
		dao.update(m);
	}

	@Override
	public boolean checkId(String id) {
		dao = sqlSession.getMapper(Dao.class);
		boolean result = false;
		Member m = dao.select(id);
		//System.out.println(m);
		if(m == null) {
			result = false;
		}else {
			result = true;
		}
		//System.out.println("result : "+ result);
		return result;
	}
	@Override
	public boolean login(Member m) {
		dao = sqlSession.getMapper(Dao.class);
		String result = dao.login(m.getId());
		
		boolean ok = false;
		try {
		if(result.equals(m.getPwd())) {
			ok = true;
		}
		}catch(Exception e) {
			ok = false;
		}
		return ok;
	}

	@Override
	public void delMember(String id) {
		dao = sqlSession.getMapper(Dao.class);
		dao.delete(id);
	}

}
