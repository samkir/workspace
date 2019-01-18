package com.login.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.login.model.AppUser;

@Service
public class AppUserServiceImpl {
    @Value("${resource.admin}")
    private String resource;
    @Value("${resource.admin}/{id}")
    private String idResource;
    @Autowired
    private RestTemplate restTemplate;

    public List<AppUser> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, AppUser[].class)).collect(Collectors.toList());
    }

    public AppUser update(Long id, AppUser user) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(user), AppUser.class, id).getBody();
    }

    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }

    public AppUser create(AppUser user) {
        return restTemplate.postForObject(resource, user, AppUser.class);
    }
}
