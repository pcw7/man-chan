package com.ch.mc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.mc.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int insert(Article article) {
		return sst.insert("articlens.insert", article);
	}

}
