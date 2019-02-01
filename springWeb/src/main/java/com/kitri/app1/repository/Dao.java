package com.kitri.app1.repository;

import java.util.ArrayList;

public interface Dao {

	public void insert(Repo repo);
	public ArrayList<Repo> selectAll();
	
}
