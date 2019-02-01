package com.kitri.test.product;

import java.util.ArrayList;

public interface Dao {

	int insert(Product p);
	ArrayList<Product> selectAll();
	ArrayList<Product> selectBySeller(String seller);
	ArrayList<Product> selectByTitle(String title);
	Product selectByNum(int num);
	int selectSeq();
	int selectLarge(int myCate);
	int selectMedium(int myCate);
	ArrayList<Product> selectByCate(int myCate);
	
	
}
