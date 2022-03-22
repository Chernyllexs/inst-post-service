package com.chernyllexs.post.impl;

import com.chernyllexs.post.api.*;
import com.chernyllexs.post.api.exception.PostNotFoundException;
import com.chernyllexs.post.model.dto.CreatePostDto;
import com.chernyllexs.post.model.dto.PagingPostDto;
import com.chernyllexs.post.model.dto.PostDto;
import com.chernyllexs.post.model.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PhotoService photoService;


    @Override
    public void deletePostById(Long id) {
        if (postRepository.deleteByPostId(id) == 0) {
            throw new PostNotFoundException("Nothing could be deleted!");
        }
    }


    public PostDto createPost(String userId, String postText, MultipartFile file) {
        CreatePostDto createPostDto = new CreatePostDto(Long.decode(userId), postText);
        Long photoId = photoService.savePhoto(file).getPhotoId();


        return postMapper.convertToDto(postRepository.save(postMapper.convertToEntity(new PostDto(createPostDto, photoId))));

    }


    @Override
    public List<PostDto> getAllPosts() {
        ArrayList<PostDto> postDtos = postMapper.convertListToDto(postRepository.findAll());
        if (postDtos.isEmpty()) {
            throw new PostNotFoundException("The list of posts is empty!");
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
        ArrayList<PostDto> postDtos = postMapper.convertListToDto(postRepository.findByUserIdOrderByPostDate(id));
        if (postDtos.isEmpty()) {
            throw new PostNotFoundException("The list of posts is empty!");
        }
        return postDtos;
    }

    @Override
    public Boolean checkPostAvailable(Long postId) {
        return postRepository.existsByPostId(postId);
    }

    @Override
    public PagingPostDto getPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<PostEntity> pagedResult = postRepository.findByUserIdOrderByPostDate(1L,paging);

        PagingPostDto pagingPostDto = new PagingPostDto();
        pagingPostDto
                .setCurrentPage( pageNo)
                .setNumberOfPages(pagedResult.getTotalPages())
                .setPosts(postMapper.convertListToDto(pagedResult.toList()));

        return pagingPostDto;
    }
}
