package com.chernyllexs.post.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    Boolean savePhoto(MultipartFile file);
}
