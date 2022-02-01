package com.chernyllexs.post.service;

import com.chernyllexs.post.model.PostDto;

import java.util.List;

public interface PostService {
    void deletePostById(Long id);

    PostDto addPost(PostDto newPostDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    List<PostDto> getPostsByUserId(Long id);
}
