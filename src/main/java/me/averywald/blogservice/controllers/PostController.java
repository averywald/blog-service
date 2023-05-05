package me.averywald.blogservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.averywald.blogservice.DTOs.PostDTO;
import me.averywald.blogservice.repositories.PostRepository;

@Controller
public class PostController {
    
    @Autowired private PostRepository postRepo;

    /**
     * @return a list of Post DTOs
     * 
     * @todo implement pagination?
     */
    @GetMapping("/blog")
    @ResponseBody
    public List<PostDTO> getPosts() {
        return this.postRepo.getPostList();
    }
}
