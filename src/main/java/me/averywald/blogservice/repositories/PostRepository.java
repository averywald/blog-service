package me.averywald.blogservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import me.averywald.blogservice.DTOs.PostDTO;
import me.averywald.blogservice.models.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
    @Query("{ title: '?' }")
    Post getPostByTitle(String title);

    @Query("{}")
    List<PostDTO> getPostList();

    // TODO: more queries

    public long count();
}
