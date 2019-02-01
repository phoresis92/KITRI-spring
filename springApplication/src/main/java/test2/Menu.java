package test2;

import java.util.Scanner;

public class Menu {

	private Service service;

	public void setService(Service service) {
		this.service = service;
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		String str = "1.정보추가 2.정보검색 3.정보수정 4.정보삭제 5.종료";
		while(flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu) {
				case 1:
					service.addInfo();
					break;
				case 2:
					service.getInfo();
					break;
				case 3:
					service.editInfo();
					break;
				case 4:
					service.delInfo();
					break;
				case 5:
					flag = false;
					break;
			}
		}// while end
	}//run end
	
	
}
