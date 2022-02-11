package com.chernyllexs.post.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class PostDto {
    private Long userId;
    private Long photoId;
    private String postText;
    private LocalDateTime postDate;

    public PostDto() {
    }

    public PostDto(CreatePostDto createPostDto, Long photoId){
        this.userId = createPostDto.getUserId();
        this.photoId = photoId;
        this.postText = createPostDto.getPostText();
        this.postDate = LocalDateTime.now();
    }

    public PostDto(Long userId, Long photoId, String postText, LocalDateTime postDate) {
        this.userId = userId;
        this.photoId = photoId;
        this.postText = postText;
        this.postDate = postDate;
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

        if (!getUserId().equals(postDto.getUserId())) return false;
        if (!getPhotoId().equals(postDto.getPhotoId())) return false;
        if (!getPostText().equals(postDto.getPostText())) return false;
        return getPostDate().equals(postDto.getPostDate());
    }

    @Override
    public int hashCode() {

        int result =  getUserId().hashCode();
        result = 31 * result + getPhotoId().hashCode();
        result = 31 * result + getPostText().hashCode();
        result = 31 * result + getPostDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                ", userId='" + userId + '\'' +
                ", photoId='" + photoId + '\'' +
                ", postText='" + postText + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
