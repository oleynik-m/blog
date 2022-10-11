package com.sushivesla.blog.controller;

import com.sushivesla.blog.model.Article;
import com.sushivesla.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    static final Logger logger =
            LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/id/{id}")
    Article getById(@PathVariable String id) {
        return this.articleService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article Not Found"));
    }
    @GetMapping("/header/{header}")
    Article getByHeader(@PathVariable String header) {
        return this.articleService.getByHeader(header).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article Not Found"));
    }
    @GetMapping()
    List<Article> getAll() {
        return this.articleService.getAll();
    }
}
