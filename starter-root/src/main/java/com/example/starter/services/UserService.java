package com.example.starter.services;

import com.example.starter.config.ApplicationConfig;
import com.example.starter.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserService {

    private RestTemplate restTemplate;
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<User> checkPostAccess() {

        User user = new User("myName", "myJob");
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            return restTemplate.exchange(ApplicationConfig.load("app.system.url"), HttpMethod.POST, entity, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
