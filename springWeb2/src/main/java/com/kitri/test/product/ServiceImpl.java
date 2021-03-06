package com.kitri.test.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("service")
public class ServiceImpl implements Service {
	
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	private Dao dao;

	@Override
	public int addProd(Product p) {
		System.out.println("serviceImpl : " + p);
		dao = sqlSession.getMapper(Dao.class);
		return dao.insert(p);
	}

	@Override
	public ArrayList<Product> getAll() {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectAll();
	}

	@Override
	public ArrayList<Product> getByMem(String seller) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectBySeller(seller);
	}

	@Override
	public ArrayList<Product> getByTitle(String title) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByTitle(title);
	}

	@Override
	public Product getByNum(int num) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByNum(num);
	}

	@Override
	public int getSeq() {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectSeq();
	}

	@Override
	public int searchLarge(int myCate) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectLarge(myCate);
	}

	@Override
	public int searchMedium(int myCate) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectMedium(myCate);
	}

	@Override
	public ArrayList<Product> searchByCate(int myCate) {
		dao = sqlSession.getMapper(Dao.class);
		return dao.selectByCate(myCate);
	}

	

}
