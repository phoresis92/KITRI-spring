
	
	
	create table prod_cate(
	num number primary key,
	name varchar2(20) not null,
	parent number references prod_cate(num) on delete cascade);
	
	create sequence seq_prod_cate;
	seq_prod_cate.nextval from dual;
	
	insert into prod_cate values(seq_prod_cate.nextval,'의류',null);
	insert into prod_cate values(seq_prod_cate.nextval,'전자제품',null);
	insert into prod_cate values(seq_prod_cate.nextval,'잡화',null);
	
	insert into prod_cate values(seq_prod_cate.nextval,'여성복',1);
	insert into prod_cate values(seq_prod_cate.nextval,'남성복',1);
	insert into prod_cate values(seq_prod_cate.nextval,'아동복',1);
	
	insert into prod_cate values(seq_prod_cate.nextval,'가전',2);
	insert into prod_cate values(seq_prod_cate.nextval,'음향',2);
	insert into prod_cate values(seq_prod_cate.nextval,'컴퓨터',2);
	
	insert into prod_cate values(seq_prod_cate.nextval,'신발',3);
	insert into prod_cate values(seq_prod_cate.nextval,'악세서리',3);
	insert into prod_cate values(seq_prod_cate.nextval,'시계',3);
	
	insert into prod_cate values(seq_prod_cate.nextval,'원피스',4);
	insert into prod_cate values(seq_prod_cate.nextval,'투피스',4);
	insert into prod_cate values(seq_prod_cate.nextval,'쓰리피스',4);
	
	insert into prod_cate values(seq_prod_cate.nextval,'셔츠',5);
	insert into prod_cate values(seq_prod_cate.nextval,'바지',5);
	
	insert into prod_cate values(seq_prod_cate.nextval,'내복',6);
	insert into prod_cate values(seq_prod_cate.nextval,'티셔츠',6);
	insert into prod_cate values(seq_prod_cate.nextval,'청바지',6);
	
	insert into prod_cate values(seq_prod_cate.nextval,'TV',7);
	insert into prod_cate values(seq_prod_cate.nextval,'세탁기',7);
	insert into prod_cate values(seq_prod_cate.nextval,'냉장고',7);
	
	insert into prod_cate values(seq_prod_cate.nextval,'스피커',8);
	insert into prod_cate values(seq_prod_cate.nextval,'믹서',8);
	insert into prod_cate values(seq_prod_cate.nextval,'마이크',8);
	
	insert into prod_cate values(seq_prod_cate.nextval,'노트북',9);
	insert into prod_cate values(seq_prod_cate.nextval,'데스크탑',9);
	insert into prod_cate values(seq_prod_cate.nextval,'태블릿',9);
	
	
	insert into prod_cate values(seq_prod_cate.nextval,'구두',10);
	insert into prod_cate values(seq_prod_cate.nextval,'운동화',10);
	
	insert into prod_cate values(seq_prod_cate.nextval,'목걸이',11);
	insert into prod_cate values(seq_prod_cate.nextval,'귀걸이',11);
	insert into prod_cate values(seq_prod_cate.nextval,'반지',11);
	
	insert into prod_cate values(seq_prod_cate.nextval,'손목시계',12);
	insert into prod_cate values(seq_prod_cate.nextval,'탁상시계',12);
	
	
	select p.name from prod_cate p, prod_cate n where p.parent = n.num;
	