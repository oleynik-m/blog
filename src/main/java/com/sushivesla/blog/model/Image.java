package com.sushivesla.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
/*
 Отбросил вариант с загрузкой изображений в MONGODB
 Сделал вариант, где при загрузке файла через POST запрос в Document "Images" записывается IDшник и имя документа
 А сам файл сохраняется в файловом хранилище.

 В идеале хранить изображение где-нибудь в AWS и ссылаться на него
 */
@Document("images")
public class Image {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String name;
    @NotNull
    private String location;
    byte[] content;


    public Image () {}

    public Image(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public Image(String name, String location, byte[] content) {
        this.name = name;
        this.location = location;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
