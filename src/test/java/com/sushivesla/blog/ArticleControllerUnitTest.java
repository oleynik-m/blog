package com.sushivesla.blog;

import com.sushivesla.blog.controller.ArticleController;
import com.sushivesla.blog.controller.CategoryController;
import com.sushivesla.blog.model.Article;
import com.sushivesla.blog.model.Category;
import com.sushivesla.blog.service.ArticleService;
import com.sushivesla.blog.service.CategoryService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerUnitTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ArticleService articleService;

    @Test
    public void getAllArticlesTest () throws Exception {
        List<Category> categories = Arrays.asList(
                new Category("Новости", "Новостная категроия"),
                new Category("Кухня", "Кухня"),
                new Category("Ремонт", "Ремонт" )
        );
        List<Article> articles = List.of(
                new Article("Новости", "Новостная категроия", categories.get(0)),
                new Article("Кухня", "Кухня", categories.get(1)),
                new Article("Ремонт", "Ремонт", categories.get(2))
        );

        given(articleService.getAll()).willReturn(articles);

        mvc.perform(get("/article")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].header", is(articles.get(0).getHeader())))
                .andExpect(jsonPath("$[1].header", is(articles.get(1).getHeader())))
                .andExpect(jsonPath("$[2].header", is(articles.get(2).getHeader())));
    }

    @Test
    public void getArticleByHeaderTest () throws Exception {
        Category category = new Category("Новости", "Новостная категроия");
        Article article = new Article("Новости", "Новостная категроия",category);

        given(articleService.getByHeader("Новости")).willReturn(Optional.of(article));

        mvc.perform(get("/article/header/{header}","Новости")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.header", is("Новости")));
    }
}
