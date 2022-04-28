package com.example.article.service;

import java.util.List;

import com.example.article.domain.ArticleDTO;

public interface ArticleService {

    public boolean registerArticle(ArticleDTO params);

	public ArticleDTO getArticleDetail(Long idx);

	public boolean deleteArticle(Long idx);

	public List<ArticleDTO> getArticleList();
    
}
