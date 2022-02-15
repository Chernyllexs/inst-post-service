package com.chernyllexs.post.controller;

import com.chernyllexs.post.model.CreatePostDto;
import com.chernyllexs.post.model.PostDto;
import com.chernyllexs.post.service.implementation.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping()
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok().body(postService.addPost(postDto));
    }

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@ModelAttribute CreatePostDto createPostDto,
                                              @RequestParam MultipartFile file) {
        return ResponseEntity.ok().body(postService.createPost(createPostDto, file));
    }

    /*@PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestPart("json") CreatePostDto createPostDto,
                                              @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok().body(postService.createPost(createPostDto, file));
    }*/

    @GetMapping("/get-post-by-id/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok().body(postService.getPostById(postId));
    }

    @GetMapping("/get-all-posts-for-user/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok().body(postService.getPostsByUserId(userId));
    }

    @GetMapping("/check-post/{postId}")
    public Boolean postIsExist(@PathVariable Long postId){
        return postService.checkPostAvailable(postId);
    }

    @DeleteMapping("/delete-post-by-id/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePostById(postId);
    }

    @DeleteMapping
    public void deletePostsByUserId(@PathVariable Long userId){
        postService.deletePostsByUserId(userId);
    }

    //==============

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }
}
