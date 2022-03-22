package com.chernyllexs.post.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    private Long userId;
    private Long photoId;
    private String postText;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime postDate;

    public PostEntity() {
    }

    public PostEntity(Long postId, Long userId, Long photoId, String postText, LocalDateTime postDate) {
        this.postId = postId;
        this.userId = userId;
        this.photoId = photoId;
        this.postText = postText;
        this.postDate = postDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (!getPostId().equals(that.getPostId())) return false;
        if (!getUserId().equals(that.getUserId())) return false;
        if (!getPhotoId().equals(that.getPhotoId())) return false;
        if (!getPostText().equals(that.getPostText())) return false;
        return getPostDate().equals(that.getPostDate());
    }

    @Override
    public int hashCode() {
        int result = getPostId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getPhotoId().hashCode();
        result = 31 * result + getPostText().hashCode();
        result = 31 * result + getPostDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "postId=" + postId +
                ", userId='" + userId + '\'' +
                ", photoId='" + photoId + '\'' +
                ", postText='" + postText + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
