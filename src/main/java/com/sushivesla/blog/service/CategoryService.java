package com.sushivesla.blog.service;

import com.sushivesla.blog.model.Category;
import org.springframework.data.domain.Example;

import java.util.List;

public interface CategoryService {
    List<Category> getAll ();
}
