package com.kitri.app1.imgboard;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("imgService")
public class ServiceImpl implements Service {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private Dao dao;

	@Override
	public void addImg(ImgBoard ib) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		dao.insert(ib);
	}

	@Override
	public ArrayList<ImgBoard> getAll(String writer) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectAll(writer);
	}

	@Override
	public ImgBoard getByNum(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByNum(num);
	}

	@Override
	public void editImgBoard(ImgBoard ib) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		dao.update(ib);
	}

	@Override
	public void delImgBoard(int num) {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		dao.delete(num);
	}

	@Override
	public int getImgNum() {
		// TODO Auto-generated method stub
		dao = sqlSession.getMapper(Dao.class);
		return dao.makeImgNum();
	}

}
