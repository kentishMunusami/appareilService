package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.service.IArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@GetMapping("/all")
	 public ResponseEntity findArticles() {
		 return ResponseEntity.ok(articleService.getArticles());
		 
	 }

}
