package com.chernyllexs.post.api.exception;

public class PostPhotoUploadException extends RuntimeException{
    public PostPhotoUploadException() {
        super();
    }

    public PostPhotoUploadException(String message) {
        super(message);
    }
}
