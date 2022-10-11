package com.sushivesla.blog.repository;

import com.sushivesla.blog.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findCategoryByHeader (String header);
}
