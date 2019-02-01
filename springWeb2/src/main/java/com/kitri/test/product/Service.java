package com.kitri.test.product;

import java.util.ArrayList;

public interface Service {

	int addProd(Product p);
	ArrayList<Product> getAll();
	ArrayList<Product> getByMem(String id);
	ArrayList<Product> getByTitle(String title);
	Product getByNum(int num);
	int getSeq();
	int searchLarge(int myCate);
	int searchMedium(int myCate);
	ArrayList<Product> searchByCate(int myCate);
	
}
