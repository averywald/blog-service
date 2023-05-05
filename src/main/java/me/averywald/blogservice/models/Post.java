package me.averywald.blogservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("posts")
public class Post {
    @Id private String id;
    private String title;
    private String author;
    private String text;

    public Post(String id, String title, String author, String text) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
    }
}
