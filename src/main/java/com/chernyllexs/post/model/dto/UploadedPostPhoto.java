package com.chernyllexs.post.model.dto;

public class UploadedPostPhoto {
    private Long photoId;

    public UploadedPostPhoto() {
    }

    public UploadedPostPhoto(Long photoId) {
        this.photoId = photoId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "PhotoPostDto{" +
                "photoId=" + photoId +
                '}';
    }
}
