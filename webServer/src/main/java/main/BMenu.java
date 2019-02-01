package main;

import java.util.Scanner;

import bean.Article;
import board.BService;

public class BMenu {

	private BService service;

	public void setService(BService service) {
		this.service = service;
	}

	public void bmenu(Scanner sc) {

		boolean flag = true;
		int menu;
		String str = "1.게시물 모두 보기 2.게시물 보기 3.종료";
		while(flag) {
			System.out.println(str);

			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
				try {
					service.getAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
					 break;
				case 2:
					System.out.print("게시물 번호: ");
					Article a = service.getByNum(Integer.parseInt(sc.nextLine()));
					System.out.print(a.getNum()+" : ");
					System.out.print(a.getTitle()+" : ");
					System.out.print(a.getContent()+" : ");
					System.out.print(a.getWriter()+" : ");
					System.out.print(a.getW_date());
					System.out.println();
					break;
				case 3:
					return;
			}
		}// while end
		
		
	}
	
}
