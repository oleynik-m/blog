package com.sushivesla.blog.repository;

import com.sushivesla.blog.model.Category;
import com.sushivesla.blog.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
