package com.example.article.mapper;

import java.util.List;

import com.example.article.domain.ArticleDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public int insertArticle(ArticleDTO params);

	public ArticleDTO selectArticleDetail(Long idx);

	public int updateArticle(ArticleDTO params);

	public int deleteArticle(Long idx);

	public List<ArticleDTO> selectArticleList();

	public int selectArticleTotalCount();
}
