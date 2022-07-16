package com.ch.mc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mc.model.Member;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Member select(String id) {
		return sst.selectOne("memberns.select", id);
	}

	@Override
	public Member selectNickName(String nickName) {
		return sst.selectOne("memberns.selectNickName", nickName);
	}

	@Override
	public int insert(Member member) {
		return sst.insert("memberns.insert", member);
	}

}
