package main;

import java.util.Scanner;

import member.Service;

public class Menu {

	private BMenu board ;
	
	private Service service;
	public static String user;
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public void setBoard(BMenu board) {
		this.board = board;
	}



	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
		String str = "1.회원가입 2.로그인 3.종료";
		while(flag) {
			System.out.println(str);

			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
					service.join(sc);
					break;
				case 2:
					boolean login = service.login(sc);
					if(login) {
						loginMenu(sc);
					}else {
						System.out.println("아이디 비밀번호 확인!");
					}
					break;
				case 3:
					flag=false;
					break;
			}
		}// while end
	}//run end
	
	public void loginMenu(Scanner sc) {
		
		boolean flag = true;
		int menu;
		String str = "1.정보관리 2.게시판 3.종료";
		while(flag) {
			System.out.println(str);

			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
					memInfo(sc);
					
					break;
				case 2:
					board.bmenu(sc);
					break;

				case 3:
					return;
			}
		}// while end
		
	}
	
	public void memInfo(Scanner sc) {
		
		boolean flag = true;
		int menu;
		String str = "1.정보변경 2.탈퇴 3.정보보기 4.종료";
		while(flag) {
			System.out.println(str);

			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1:
					service.editMyInfo(sc);
					break;
				case 2:
					service.delMember(Menu.user);
					run(sc);
					System.exit(0);
				case 3:
					System.out.println(service.getMyInfo(sc));
					break;
				case 4:
					return;
			}
		}// while end
		
	}
}
