package com.sushivesla.blog.service.impl;

import com.sushivesla.blog.model.Category;
import com.sushivesla.blog.repository.CategoryRepository;
import com.sushivesla.blog.service.CategoryService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll () {
        return this.categoryRepository.findAll();
    }
}
