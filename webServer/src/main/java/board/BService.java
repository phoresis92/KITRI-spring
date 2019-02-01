package board;

import java.util.ArrayList;

import bean.Article;

public interface BService {

	void addArticle(Article a);
	ArrayList<Article> getAll();
	Article getByNum(int num);
	ArrayList<Article> getByWriter(String writer);
	ArrayList<Article> getByTitle(String title);
	void editArticle(Article a);
	void deleteArticle(int num);
	
}
