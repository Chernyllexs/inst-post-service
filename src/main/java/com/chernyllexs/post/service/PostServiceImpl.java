package com.chernyllexs.post.service;

import com.chernyllexs.post.entity.PostEntity;
import com.chernyllexs.post.model.PostDto;
import com.chernyllexs.post.repository.PostRepository;
import com.chernyllexs.post.utill.PostMapper;
import com.chernyllexs.post.utill.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public PostDto addPost(PostDto newPostDto) {
        newPostDto.setPostDate(LocalDateTime.now());
        return postMapper.convertToDto(postRepository.save(postMapper.convertToEntity(newPostDto)));
    }

    @Override
    public List<PostDto> getAllPosts() {
        Iterable<PostEntity> iterable = postRepository.findAll();
        ArrayList<PostDto> postDtos = new ArrayList<>();
        for(PostEntity postEntity: iterable){
            postDtos.add(postMapper.convertToDto(postEntity));
        }
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found: id = " + id));
        return postMapper.convertToDto(postEntity);
    }

    @Override
    public List<PostDto> getPostsByUserId(Long id) {
        Iterable<PostEntity> iterable = postRepository.findByUserIdOrderByPostDate(id);
        ArrayList<PostDto> postsDto = new ArrayList<>();
        for(PostEntity postEntity: iterable){
            postsDto.add(postMapper.convertToDto(postEntity));
        }
        return postsDto;
    }
}
