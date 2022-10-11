package com.sushivesla.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document("articles")
public class Article {

    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String header;
    private String description;
    @DocumentReference(lazy = true)
    private Image photo;
    @DocumentReference(lazy = true)
    private Category category;

    public Article () {}

    public Article(String header, String description, Category category) {
        this.header = header;
        this.description = description;
        this.category = category;
    }

    public Article(String header, String description, Image photo, Category category) {
        this.header = header;
        this.description = description;
        this.photo = photo;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category.getId();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return header.equals(article.header) && Objects.equals(description, article.description) && Objects.equals(photo, article.photo) && Objects.equals(category, article.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, description, photo, category);
    }
}
