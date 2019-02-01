package com.kitri.app1.board;

import java.util.ArrayList;


public interface BDao {

	void insert(Article a);
	ArrayList<Article> selectAll();
	Article selectByNum(int num);
	ArrayList<Article> selectByWriter(String writer);
	ArrayList<Article> selectByTitle(String title);
	void update(Article a);
	void delete(int num);
	
	ArrayList<Article> getReps(int num);
	
}
