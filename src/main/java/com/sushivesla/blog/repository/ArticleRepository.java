package com.sushivesla.blog.repository;

import com.sushivesla.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArticleRepository extends MongoRepository<Article, String> {
    Optional<Article> findArticleByHeader (String header);
}
