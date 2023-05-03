package me.averywald.blogservice.models;


import org.springframework.data.annotation.Id;

public class Post {

    @Id public long id;
    public String author;
    public String text;

    public Post() {}
    
}
