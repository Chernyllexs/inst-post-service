package com.chernyllexs.post.api;

import com.chernyllexs.post.model.dto.PostDto;
import com.chernyllexs.post.model.entity.PostEntity;

import java.util.ArrayList;
import java.util.Objects;

public interface PostMapper {
    public PostDto convertToDto(PostEntity postEntity);

    public PostEntity convertToEntity(PostDto postDto);

    public ArrayList<PostDto> convertListToDto(Iterable<PostEntity> iterable);
}
