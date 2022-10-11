package com.sushivesla.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document("categories")
public class Category {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String header;
    private String description;
    @DocumentReference(lazy = true)
    private Image photo;

    public Category () {}

    public Category(String header, String description) {
        this.header = header;
        this.description = description;
    }

    public Category(String header, String description, Image photo) {
        this.header = header;
        this.description = description;
        this.photo = photo;
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

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", header='" + header + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return header.equals(category.header) && Objects.equals(description, category.description) && Objects.equals(photo, category.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, description, photo);
    }
}
