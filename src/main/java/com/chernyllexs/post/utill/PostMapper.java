package com.chernyllexs.post.utill;

import com.chernyllexs.post.entitys.PostEntity;
import com.chernyllexs.post.models.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
    private final ModelMapper modelMapper;

    public PostMapper() {
        this.modelMapper = new ModelMapper();
    }

    public PostDto convertToDto(PostEntity postEntity){
        return modelMapper.map(postEntity, PostDto.class);
    }

    public PostEntity convertToEntity(PostDto postDto){
        return modelMapper.map(postDto, PostEntity.class);
    }
}
