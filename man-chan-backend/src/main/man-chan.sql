-- 회원
drop table Member2 cascade constraints;
create table Member2 (
	id varchar2(20) not null,        		  	 -- 아이디
	password varchar2(300) not null,  			 -- 비밀번호
	email varchar2(50) not null,     			 -- 이메일
	nickName varchar2(20) not null  			 -- 별명
)