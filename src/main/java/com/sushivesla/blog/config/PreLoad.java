package com.sushivesla.blog.config;

import com.sushivesla.blog.model.Article;
import com.sushivesla.blog.model.Category;
import com.sushivesla.blog.repository.ArticleRepository;
import com.sushivesla.blog.repository.CategoryRepository;
import com.sushivesla.blog.service.FileLocationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.List;

@Configuration
public class PreLoad {
    static final Logger logger =
            LoggerFactory.getLogger(PreLoad.class);

    @Bean
    CommandLineRunner initDatabase(ArticleRepository articleRepository, CategoryRepository categoryRepository, FileLocationService fileLocationService) {
        return args -> {
            try {
                List<Category> categories = Arrays.asList(
                        new Category("Новости", "Категория для сухих новостей"),
                        new Category("Кухня", "Категория для кулинарных статей"),
                        new Category("Путешествия", "Категория статей о путешествиях")
                );
                categoryRepository.saveAll(categories);
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
            try {
                List<Article> articles = Arrays.asList(
                        new Article("Сухая новость", "Сухая новость",categoryRepository.findCategoryByHeader("Новости")),
                        new Article("Как правильно жарить стейк рибай", "Как правильно жарить стейк рибай", categoryRepository.findCategoryByHeader("Кухня")),
                        new Article("Орел и решка", "Путешествия", categoryRepository.findCategoryByHeader("Путешествия"))
                );
                articleRepository.saveAll(articles);
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        };
    }
}
