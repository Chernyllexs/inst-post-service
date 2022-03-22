package com.chernyllexs.post.api;

import com.chernyllexs.post.model.dto.UploadedPostPhoto;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    UploadedPostPhoto savePhoto(MultipartFile file);
}
