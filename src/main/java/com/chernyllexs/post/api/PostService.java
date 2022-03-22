package com.chernyllexs.post.api;

import com.chernyllexs.post.model.dto.PagingPostDto;
import com.chernyllexs.post.model.dto.PostDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    void deletePostById(Long id);

    PostDto createPost(String userId, String postText, MultipartFile file);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    List<PostDto> getPostsByUserId(Long id);

    Boolean checkPostAvailable(Long postId);

    PagingPostDto getPaginated(int pageNo, int pageSize);
}
