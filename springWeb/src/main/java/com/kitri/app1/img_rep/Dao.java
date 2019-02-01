package com.kitri.app1.img_rep;

import java.util.ArrayList;

public interface Dao {
	
	void insert(Rep r);
	ArrayList<Rep> selectByImgNum(int img_num);
	
}
