package com.ch.mc.service;

import java.util.List;

import com.ch.mc.model.Article;

public interface ArticleService {

	int insert(Article article);

	List<Article> list();



}
