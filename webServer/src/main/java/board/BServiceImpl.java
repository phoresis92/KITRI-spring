package board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import bean.Article;

public class BServiceImpl implements BService{

	
	private SqlSession sqlSession ;
	private BDao dao;
	
	public BServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		dao = sqlSession.getMapper(BDao.class);
	}
	
	@Override
	public void addArticle(Article a) {
		dao.insert(a);
	}

	@Override
	public ArrayList<Article> getAll() {
		ArrayList<Article> list = dao.selectAll();
		
		for(Article a : list) {
			/*System.out.print(a.getNum()+" : ");
			System.out.print(a.getTitle()+" : ");
			System.out.print(a.getWriter()+" : ");
			System.out.print(a.getW_date());
			System.out.println();*/
			System.out.println(a);
			System.out.println();
		}
		
		return list;
	}

	@Override
	public Article getByNum(int num) {
		return dao.selectByNum(num);
	}

	@Override
	public ArrayList<Article> getByWriter(String writer) {
		return dao.selectByWriter(writer);
	}

	@Override
	public ArrayList<Article> getByTitle(String title) {
		return dao.selectByTitle("%"+title+"%");
	}

	@Override
	public void editArticle(Article a) {
		dao.update(a);
	}

	@Override
	public void deleteArticle(int num) {
		dao.delete(num);
	}

}
