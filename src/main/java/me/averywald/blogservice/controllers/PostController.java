package me.averywald.blogservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import me.averywald.blogservice.DTOs.PostDTO;
import me.averywald.blogservice.repositories.PostRepository;

@Controller
public class PostController {

    // TODO: implement pagination, in a service?
    
    @Autowired private PostRepository postRepo;

    /**
     * @return a list of Post DTOs
     */
    @GetMapping("/blog")
    @ResponseBody
    public List<PostDTO> getPosts() {
        return this.postRepo.getPostList();
    }

    /**
     * @param author the name of the author to find posts for
     * @return list of post DTOs
     */
    @GetMapping("/blog/author/{author}")
    @ResponseBody
    public List<PostDTO> getPostsByAuthor(@PathVariable String author) {
        return this.postRepo.getPostsByAuthor(author);
    }

}
