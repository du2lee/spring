package com.example.article.controller;

import java.util.*;

import com.example.article.domain.ArticleDTO;
import com.example.article.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
	private ArticleService articleService;

	@GetMapping(value = "/write")
	public String openArticleWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		
        // 게시글 리스트 페이지 -> 게시글 등록 페이지
        if (idx == null) {
			model.addAttribute("article", new ArticleDTO());
		} else {    //게시글 상세 페이지 -> 게시글 수정 페이지
			ArticleDTO article = articleService.getArticleDetail(idx);
			if (article == null) {
				return "redirect:/article/list";
			}
			model.addAttribute("article", article);
		}
		return "article/write";
	}

    @PostMapping(value = "/register")
	public String registerArticle(final ArticleDTO params) {
		try {
			boolean isRegistered = articleService.registerArticle(params);
			if (isRegistered == false) {
				// TODO => 게시글 등록에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		return "redirect:/article/list";
	}


    @GetMapping(value = "/list")
	public String openArticleList(Model model) {
		List<ArticleDTO> articleList = articleService.getArticleList();
		model.addAttribute("articleList", articleList);

		return "article/list";
	}

    @GetMapping(value = "/view")
	public String openArticleDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		if (idx == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/article/list";
		}

		ArticleDTO article = articleService.getArticleDetail(idx);
		if (article == null || "Y".equals(article.getDeleteYn())) {
			// TODO => 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/article/list";
		}
		model.addAttribute("article", article);

		return "article/view";
	}

    @PostMapping(value = "/delete")
	public String deleteArticle(@RequestParam(value = "idx", required = false) Long idx) {
		if (idx == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/article/list";
		}

		try {
			boolean isDeleted = articleService.deleteArticle(idx);
			if (isDeleted == false) {
				// TODO => 게시글 삭제에 실패하였다는 메시지를 전달
			}
		} catch (DataAccessException e) {
			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달

		} catch (Exception e) {
			// TODO => 시스템에 문제가 발생하였다는 메시지를 전달
		}

		return "redirect:/article/list";
	}
    
}
