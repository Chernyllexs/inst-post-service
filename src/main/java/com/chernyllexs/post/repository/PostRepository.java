package com.chernyllexs.post.repository;

import com.chernyllexs.post.entitys.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
