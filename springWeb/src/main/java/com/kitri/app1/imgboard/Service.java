package com.kitri.app1.imgboard;

import java.util.ArrayList;

public interface Service {
	int getImgNum();
	void addImg(ImgBoard ib);
	ArrayList<ImgBoard> getAll(String writer);
	ImgBoard getByNum(int num);
	void editImgBoard(ImgBoard ib);//title, content, w_date만 수정
	void delImgBoard(int num);
}
