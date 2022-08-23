package com.ch.mc.dao;

import java.util.List;

import com.ch.mc.model.Article;

public interface ArticleDao {

	int insert(Article article);

	List<Article> list();

}
