package com.example.article.service;

import java.util.*;

import com.example.article.domain.ArticleDTO;
import com.example.article.mapper.ArticleMapper;

import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceImpl implements ArticleService{
    
    @Autowired
	private ArticleMapper boardMapper;

	@Override
	public boolean registerArticle(ArticleDTO params) {
		int queryResult = 0;

		if (params.getIdx() == null) {
			queryResult = boardMapper.insertArticle(params);
		} else {
			queryResult = boardMapper.updateArticle(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public ArticleDTO getArticleDetail(Long idx) {
		return boardMapper.selectArticleDetail(idx);
	}

	@Override
	public boolean deleteArticle(Long idx) {
		int queryResult = 0;

		ArticleDTO board = boardMapper.selectArticleDetail(idx);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteArticle(idx);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<ArticleDTO> getArticleList() {
		List<ArticleDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.selectArticleTotalCount();

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectArticleList();
		}

		return boardList;
	}
}
