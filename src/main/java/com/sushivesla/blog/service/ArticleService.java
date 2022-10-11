package com.sushivesla.blog.service;

import com.sushivesla.blog.model.Article;
import com.sushivesla.blog.model.Category;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<Article> getByHeader (String header);
    Optional<Article> getById (String id);
    List<Article> getAll ();

}
