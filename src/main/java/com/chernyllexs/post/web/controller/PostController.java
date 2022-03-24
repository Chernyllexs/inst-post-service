package com.chernyllexs.post.web.controller;

import com.chernyllexs.post.api.PostService;
import com.chernyllexs.post.model.dto.PagingPostDto;
import com.chernyllexs.post.model.dto.PostDto;
import com.chernyllexs.post.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*") //*
public class PostController {
    @Autowired
    private PostService postService;



    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PostDto> createPost(@RequestParam (value = "userId") String userId,
                                              @RequestParam (value = "postText") String postText,
                                              @RequestParam (value = "file") MultipartFile file) {
        return ResponseEntity.ok().body(postService.createPost(userId, postText, file));
    }

    @GetMapping("/get-post-by-id/{postId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok().body(postService.getPostById(postId));
    }

    @GetMapping("/get-all-posts-for-user/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok().body(postService.getPostsByUserId(userId));
    }

    @GetMapping("/check-post/{postId}")
    public Boolean postIsExist(@PathVariable Long postId){
        return postService.checkPostAvailable(postId);
    }

    @DeleteMapping("/delete-post-by-id/{postId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePostById(postId);
    }


    @GetMapping("/get-paginated/{pageNo}/{pageSize}")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<PagingPostDto> getPaginatedPost(@PathVariable int pageNo, @PathVariable int pageSize){
        return ResponseEntity.ok().body(postService.getPaginated(pageNo,pageSize));
    }
    //============== delete ==============

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.getAllPosts();
    }
}
