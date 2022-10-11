package com.sushivesla.blog.service.impl;

import com.sushivesla.blog.model.Article;
import com.sushivesla.blog.repository.ArticleRepository;
import com.sushivesla.blog.service.ArticleService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Optional<Article> getByHeader(String header) {
        return this.articleRepository.findArticleByHeader(header);
    }

    @Override
    public Optional<Article> getById(String id) {
        return this.articleRepository.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
