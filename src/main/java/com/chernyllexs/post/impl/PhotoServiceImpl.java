package com.chernyllexs.post.impl;

import com.chernyllexs.post.api.PhotoService;
import com.chernyllexs.post.api.exception.PostPhotoUploadException;
import com.chernyllexs.post.model.dto.UploadedPostPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public PhotoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public UploadedPostPhoto savePhoto(MultipartFile file) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        File directory = new File("/postTemp/");
        if(!directory.exists()){
            directory.mkdirs();
        }

        File file1 = new File("/postTemp/" + file.getName());

       /* if(!file1.exists()){
            file1.mkdirs();
        }*/

        try (OutputStream os = new FileOutputStream(file1)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

            body.add("file",new FileSystemResource(file1));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("INST-PHOTO-SERVICE");
        String url = "http://" + serviceInstances.get(0).getHost() + ":" + serviceInstances.get(0).getPort();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UploadedPostPhoto> exchange = restTemplate.exchange(url + "/api/photo/post-upload-img", HttpMethod.POST, requestEntity, UploadedPostPhoto.class);




        if(exchange.getStatusCode() == HttpStatus.OK) {
            return exchange.getBody();
        } else {
            throw new PostPhotoUploadException();
        }

    }
}
