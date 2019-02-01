package com.kitri.app1.img_rep;

import java.util.ArrayList;

public interface Service {
	
	void addRep(Rep r);
	ArrayList<Rep> getByImgNum(int img_num);
	
}
