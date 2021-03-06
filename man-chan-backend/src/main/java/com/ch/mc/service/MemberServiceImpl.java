package com.ch.mc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mc.dao.MemberDao;
import com.ch.mc.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	@Override
	public Member select(String id) {
		return md.select(id);
	}

	@Override
	public Member selectNickName(String nickName) {
		return md.selectNickName(nickName);
	}

	@Override
	public int insert(Member member) {
		return md.insert(member);
	}

}
