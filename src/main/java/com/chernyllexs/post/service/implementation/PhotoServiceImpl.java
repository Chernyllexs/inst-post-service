package com.chernyllexs.post.service.implementation;

import com.chernyllexs.post.service.PhotoService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final RestTemplate restTemplate;

    public PhotoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Long savePhoto(MultipartFile file) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", file);

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, httpHeaders);

        String serverUrl = "http://GATEWAY-SERVICE:9000/photo/post/upload-img";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Long> response = restTemplate
                .postForEntity(serverUrl, requestEntity, Long.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }

    }
}
