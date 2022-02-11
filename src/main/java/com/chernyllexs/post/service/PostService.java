package com.chernyllexs.post.service;

import com.chernyllexs.post.model.CreatePostDto;
import com.chernyllexs.post.model.PostDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    void deletePostById(Long id);

    void deletePostsByUserId(Long userId);

    PostDto addPost(PostDto newPostDto);

    PostDto createPost(CreatePostDto createPostDto, MultipartFile file);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    List<PostDto> getPostsByUserId(Long id);

    Boolean checkPostAvailable(Long postId);
}
