package com.chernyllexs.post.repository;

import com.chernyllexs.post.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    Iterable<PostEntity> findByUserIdOrderByPostDate(Long userId);
}
