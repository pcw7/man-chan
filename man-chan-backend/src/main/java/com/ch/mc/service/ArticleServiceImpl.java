package com.ch.mc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.mc.model.Article;
import com.ch.mc.dao.ArticleDao;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao ad;

	@Override
	public int insert(Article article) {
		return ad.insert(article);
	}

}
