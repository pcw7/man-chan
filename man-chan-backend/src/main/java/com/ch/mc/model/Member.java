package com.ch.mc.model;

import lombok.Data;

@Data
public class Member {
	private String id;        // 아이디
	private String password;  // 비밀번호
	private String email;     // 이메일
	private String nickName;  // 별명
}
