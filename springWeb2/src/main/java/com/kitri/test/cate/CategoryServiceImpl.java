package com.kitri.test.cate;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("cateService")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="sqlSession")
	private SqlSession sqlSession ;
	private CategoryDao dao;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ArrayList<CategoryType> getLargeType() {
		dao = sqlSession.getMapper(CategoryDao.class);
		return dao.getLargeType();
	}

	@Override
	public ArrayList<CategoryType> getMediumType(int parent) {
		dao = sqlSession.getMapper(CategoryDao.class);
		return dao.getMediumType(parent);
	}

	@Override
	public GetName getName(int num) {
		dao = sqlSession.getMapper(CategoryDao.class);
		return dao.getName(num);
	}


}
