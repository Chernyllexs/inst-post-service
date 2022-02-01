package com.chernyllexs.post.utill;

import com.chernyllexs.post.entity.PostEntity;
import com.chernyllexs.post.model.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class PostMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PostDto convertToDto(PostEntity postEntity){
        return Objects.isNull(postEntity) ? null : modelMapper.map(postEntity, PostDto.class);
    }

    public PostEntity convertToEntity(PostDto postDto){
        return Objects.isNull(postDto) ? null :  modelMapper.map(postDto, PostEntity.class);
    }
}
