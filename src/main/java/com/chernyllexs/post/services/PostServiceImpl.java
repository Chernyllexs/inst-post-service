package com.chernyllexs.post.services;

import com.chernyllexs.post.entitys.PostEntity;
import com.chernyllexs.post.models.PostDto;
import com.chernyllexs.post.repository.PostRepository;
import com.chernyllexs.post.utill.PostMapper;
import com.chernyllexs.post.utill.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addPost(PostDto newPostDto) {
        newPostDto.setPostDate(ZonedDateTime.now());
        postRepository.save(postMapper.convertToEntity(newPostDto));
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
}
