package com.kitri.test.cate;

import java.util.ArrayList;

public interface CategoryService {

	public ArrayList<CategoryType> getLargeType();
	public ArrayList<CategoryType> getMediumType(int parent);
	public GetName getName(int num);
	
}
