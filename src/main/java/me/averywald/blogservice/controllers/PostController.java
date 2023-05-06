package me.averywald.blogservice.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.averywald.blogservice.DTOs.PostDTO;
import me.averywald.blogservice.repositories.PostRepository;

@Controller
@RequestMapping("/blog")
public class PostController {

    // TODO: implement pagination, in a service?
    
    @Autowired private PostRepository postRepo;

    /**
     * Catch the controller's top-level request
     * "/blog", and redirects it to "/blog/posts".
     */
    @GetMapping
    public void redirectToPostsEndpoint(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.sendRedirect(req.getServletPath() + "/posts");
        }
        catch (IOException e) {
            throw e;
        }
    }

    /**
     * @return a list of Post DTOs
     */
    @GetMapping("/posts")
    @ResponseBody
    public List<PostDTO> getPosts() {
        return this.postRepo.getPostList();
    }

    /**
     * @param author the name of the author to find posts for
     * @return list of post DTOs
     */
    @GetMapping("/posts/author/{author}")
    @ResponseBody
    public List<PostDTO> getPostsByAuthor(@PathVariable String author) {
        return this.postRepo.getPostsByAuthor(author);
    }

}
