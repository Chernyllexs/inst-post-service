package com.chernyllexs.post.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class PostDto {
    private Long postId;
    private Long userId;
    private Long photoId;
    private String postText;
    private LocalDateTime postDate;

    public PostDto() {
    }

    public PostDto(Long postId, Long userId, Long photoId, String postText, LocalDateTime postDate) {
        this.postId = postId;
        this.userId = userId;
        this.photoId = photoId;
        this.postText = postText;
        this.postDate = postDate;
    }

    public PostDto(CreatePostDto createPostDto, Long photoId){
        this.userId = createPostDto.getUserId();
        this.photoId = photoId;
        this.postText = createPostDto.getPostText();
        this.postDate = LocalDateTime.now();
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

        PostDto postDto = (PostDto) o;

        if (getPostId() != null ? !getPostId().equals(postDto.getPostId()) : postDto.getPostId() != null) return false;
        if (getUserId() != null ? !getUserId().equals(postDto.getUserId()) : postDto.getUserId() != null) return false;
        if (getPhotoId() != null ? !getPhotoId().equals(postDto.getPhotoId()) : postDto.getPhotoId() != null)
            return false;
        if (getPostText() != null ? !getPostText().equals(postDto.getPostText()) : postDto.getPostText() != null)
            return false;
        return getPostDate() != null ? getPostDate().equals(postDto.getPostDate()) : postDto.getPostDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getPostId() != null ? getPostId().hashCode() : 0;
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getPhotoId() != null ? getPhotoId().hashCode() : 0);
        result = 31 * result + (getPostText() != null ? getPostText().hashCode() : 0);
        result = 31 * result + (getPostDate() != null ? getPostDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", photoId=" + photoId +
                ", postText='" + postText + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
