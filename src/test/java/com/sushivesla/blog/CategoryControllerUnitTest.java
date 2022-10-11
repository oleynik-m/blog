package com.sushivesla.blog;

import com.sushivesla.blog.controller.CategoryController;
import com.sushivesla.blog.model.Category;
import com.sushivesla.blog.repository.CategoryRepository;
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

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService categoryService;


    @Test
    public void getAllCategories () throws Exception {
        List<Category> categories = List.of(
                new Category("Новости", "Категория для сухих новостей"),
                new Category("Кухня", "Категория для кулинарных статей"),
                new Category("Путешествия", "Категория статей о путешествиях")
        );

        given(categoryService.getAll()).willReturn(categories);

        mvc.perform(get("/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].header", is(categories.get(0).getHeader())))
                .andExpect(jsonPath("$[1].header", is(categories.get(1).getHeader())))
                .andExpect(jsonPath("$[2].header", is(categories.get(2).getHeader())));
    }
}
