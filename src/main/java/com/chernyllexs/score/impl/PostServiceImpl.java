package com.chernyllexs.score.impl;

import com.chernyllexs.score.api.PostService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

    private final RestTemplate restTemplate;

    public PostServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Boolean postIsExists(Long postId) {
        String url = "http://GATEWAY-SERVICE:9000/api/post/check-post/{postId}";
        /*String url = "http://INST-POST-SERVICE:9001/api/post/check-post/{postId}";*/
        /*String url = "lb://INST-POST-SERVICE:9001/api/post/check-post/{postId}";*/
        ResponseEntity<Boolean> response = this.restTemplate.getForEntity(url, Boolean.class, postId);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
