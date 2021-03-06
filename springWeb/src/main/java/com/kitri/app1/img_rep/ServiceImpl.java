package com.kitri.app1.img_rep;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("imgRepService")
public class ServiceImpl implements Service {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private Dao dao;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void addRep(Rep r) {
		dao = sqlSession.getMapper(Dao.class);
		dao.insert(r);
	}

	@Override
	public ArrayList<Rep> getByImgNum(int img_num) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByImgNum(img_num);
	}

}
