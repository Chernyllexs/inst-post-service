package com.chernyllexs.post.impl;

import com.chernyllexs.post.api.PostMapper;
import com.chernyllexs.post.model.entity.PostEntity;
import com.chernyllexs.post.model.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class PostMapperImpl implements PostMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PostDto convertToDto(PostEntity postEntity){
        return Objects.isNull(postEntity) ? null : modelMapper.map(postEntity, PostDto.class);
    }

    public PostEntity convertToEntity(PostDto postDto){
        return Objects.isNull(postDto) ? null :  modelMapper.map(postDto, PostEntity.class);
    }

    @Override
    public ArrayList<PostDto> convertListToDto(Iterable<PostEntity> iterable) {
        ArrayList<PostDto> postDtos = new ArrayList<>();
        for(PostEntity postEntity: iterable){
            postDtos.add(convertToDto(postEntity));
        }
        return postDtos;
    }
}
