package com.ch.mc.service;

import com.ch.mc.model.Member;

public interface MemberService {

	Member select(String id);

	Member selectNickName(String nickName);

	int insert(Member member);

}
