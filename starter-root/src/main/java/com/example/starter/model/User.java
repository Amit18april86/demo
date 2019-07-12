package com.example.starter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String name;
    public String job;
    public String id;
    public String createdAt;

    public User() {
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public User(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }
}
