package com.kitri.app1.modelAttribute;

import java.util.ArrayList;

public interface CategoryDao {
	
	public ArrayList<CategoryType> getLargeType();
	public ArrayList<CategoryType> getMediumType(int parent);

}
