package com.example.starter.services;

import com.example.starter.config.ApplicationConfig;
import com.example.starter.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "/application.properties")
@ContextConfiguration(classes = ApplicationConfig.class)
public class UserServiceTest {

    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        this.restTemplate = new RestTemplate();
    }

    @Test
    public void checkForAccess() {
        UserService userService = new UserService(this.restTemplate);
        ResponseEntity<User> userResponseEntity = userService.checkPostAccess();
        System.out.println(userResponseEntity);
        Assert.assertTrue("", userResponseEntity.getStatusCode().is2xxSuccessful());
    }
}