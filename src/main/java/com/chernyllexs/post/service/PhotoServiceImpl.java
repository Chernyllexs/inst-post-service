package com.chernyllexs.post.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoServiceImpl implements PhotoService{

    private final RestTemplate restTemplate;

    public PhotoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Boolean savePhoto(MultipartFile file) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", file);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, httpHeaders);

        String serverUrl = "http://GATEWAY-SERVICE:9000/photo/post/upload-img";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

/*
        String url = "http://GATEWAY-SERVICE:9000/photo/post/upload-img";
        ResponseEntity<Boolean> response = this.restTemplate.getForEntity(url, Boolean.class, postId);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
        */
        return null;
    }
}
