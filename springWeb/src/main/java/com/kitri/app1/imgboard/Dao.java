package com.kitri.app1.imgboard;

import java.util.ArrayList;

public interface Dao {
	int makeImgNum();
	void insert(ImgBoard ib);
	ArrayList<ImgBoard> selectAll(String writer);
	ImgBoard selectByNum(int num);
	void update(ImgBoard ib);//title, content, w_date만 수정
	void delete(int num);
	//mapper:imgBoard.xml
}
