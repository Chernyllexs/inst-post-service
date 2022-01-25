package com.chernyllexs.post.controllers;

import com.chernyllexs.post.models.PostDto;
import com.chernyllexs.post.services.PostService;
import com.chernyllexs.post.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePostById(id);
    }

    @PostMapping("/add")
    public void addPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }
}
