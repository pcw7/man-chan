package com.ch.mc.dao;

import com.ch.mc.model.Member;

public interface MemberDao {

	Member select(String id);

	Member selectNickName(String nickName);

	int insert(Member member);

}
