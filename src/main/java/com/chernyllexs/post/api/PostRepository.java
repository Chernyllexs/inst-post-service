package com.chernyllexs.post.api;

import com.chernyllexs.post.model.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Iterable<PostEntity> findByUserIdOrderByPostDate(Long userId);

    Boolean existsByPostId(Long postId);

    Long deleteByPostId(Long postId);

    Page<PostEntity> findByUserIdOrderByPostDate(Long userId, Pageable pageable);
}
