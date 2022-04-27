package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired      // Spring boot가 미리 생성해놓은 객체를 가져다가 자동 연결
    private ArticleRepository  articleRepository;

    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/create"; 
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        // 1. Dto -> Entity 변환
        Article article = form.toEntity();

        System.out.println(article.toString());

        // 2. save Entity in DB (Repository)
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());


        return "";
    }   
}