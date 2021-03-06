package com.kitri.app1.board;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("boardService")
public class BServiceImpl implements BService{

	@Resource(name="sqlSession")
	private SqlSession sqlSession ;
	private BDao dao;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void addArticle(Article a) {
		System.out.println("addArticle : "+a);
		dao = sqlSession.getMapper(BDao.class);

		dao.insert(a);
	}

	@Override
	public ArrayList<Article> getAll() {
		dao = sqlSession.getMapper(BDao.class);

		ArrayList<Article> list = dao.selectAll();
		
		/*for(Article a : list) {
			System.out.println(a);
		}*/
		
		return list;
	}

	@Override
	public Article getByNum(int num) {
		dao = sqlSession.getMapper(BDao.class);

		return dao.selectByNum(num);
	}

	@Override
	public ArrayList<Article> getByWriter(String writer) {
		dao = sqlSession.getMapper(BDao.class);

		return dao.selectByWriter("%"+writer+"%");
	}

	@Override
	public ArrayList<Article> getByTitle(String title) {
		dao = sqlSession.getMapper(BDao.class);

		return dao.selectByTitle("%"+title+"%");
	}

	@Override
	public void editArticle(Article a) {
		dao = sqlSession.getMapper(BDao.class);

		dao.update(a);
	}

	@Override
	public void deleteArticle(int num) {
		dao = sqlSession.getMapper(BDao.class);

		dao.delete(num);
	}

	@Override
	public ArrayList<Article> getReps(int parent) {
		
		dao = sqlSession.getMapper(BDao.class);
		
		return dao.getReps(parent);
	}

}
