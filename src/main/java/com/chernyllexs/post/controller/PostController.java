package com.chernyllexs.post.controller;

import com.chernyllexs.post.model.PostDto;
import com.chernyllexs.post.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping()
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto) {

        return ResponseEntity.ok().body(postService.addPost(postDto));
    }

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok().body(postService.getPostById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok().body(postService.getPostsByUserId(userId));
    }
}
