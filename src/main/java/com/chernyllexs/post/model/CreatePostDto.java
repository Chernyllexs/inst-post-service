package com.chernyllexs.post.model;

public class CreatePostDto {
    private Long userId;
    private String postText;

    public CreatePostDto() {
    }

    public CreatePostDto(Long userId, String postText) {
        this.userId = userId;
        this.postText = postText;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    @Override
    public String toString() {
        return "CreatePostDto{" +
                "userId=" + userId +
                ", postText='" + postText + '\'' +
                '}';
    }
}
