package com.kitri.app1.repository;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("RepoService")
public class ServiceImpl implements Service{

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private Dao dao;
	
	
	@Override
	public void addRepo(Repo repo) {
		dao = sqlSession.getMapper(Dao.class);
		dao.insert(repo);
	}

	@Override
	public ArrayList<Repo> getAll() {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectAll();
	}

	
	
}
