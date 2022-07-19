package com.ch.mc.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Article {
	private int ano; 			// 게시글번호	
	private String title; 		// 제목
	private String content; 	// 본문
	private Date created_at;	// 발행일
	private Date updated_at;	// 수정일		
	private int readcount;		// 조회수	
	private String member_id;	// 아이디(작성자)
	private String thumbnail;	// 썸네일
}
