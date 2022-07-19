-- 회원
drop table tb_member cascade constraints;
create table tb_member (
	id varchar2(20) primary key,        		 -- 아이디
	password varchar2(300) not null,  			 -- 비밀번호
	email varchar2(50) not null,     			 -- 이메일
	nickName varchar2(20) not null  			 -- 별명
)

-- 게시판 
drop table tb_article cascade constraints;
create table tb_article (
	ano	NUMBER primary key,										-- 게시글번호	(id -> ano)
	title VARCHAR2(50) not null,				 				-- 제목
	content VARCHAR2(1000) not null,							-- 본문
	created_at DATE not null,						 			-- 발행 날짜
	updated_at DATE not null,					 		 		-- 수정일		
	readcount NUMBER default 0 not null,		 				-- 조회수	
	member_id VARCHAR2(20) references tb_member(id) not null,	-- 아이디(작성자)
	thumbnail VARCHAR2(100) 		             				-- 썸네일
);

drop sequence seq_article_ano;
create sequence seq_article_ano;

-- 댓글
drop table tb_comment cascade constraints;
create table tb_comment ( 
	id	NUMBER primary key,				 				 		-- 댓글번호
	content VARCHAR2(500) not null,		 		 		 		-- 댓글내용
	created_at DATE not null,						 	 		-- 발행 날짜	
	updated_at DATE not null,					 		 		-- 수정일	
	member_id VARCHAR2(20) references tb_member(id) not null,	-- 아이디(작성자)	
	article_id NUMBER references tb_article(id) not null	 	-- 게시글번호
);

drop sequence seq_comment_id;
create sequence seq_comment_id;

-- 좋아요
drop table tb_like;
create table tb_like (
	id NUMBER primary key,                     			 	 	 -- 좋아요번호
 	member_id VARCHAR2(20) references tb_member(id) not null,	 -- 아이디(작성자)	
	article_id NUMBER references tb_article(id) not null	 	 -- 게시글번호
);

drop sequence seq_like_id;
create sequence seq_like_id;


select * from tb_article;
